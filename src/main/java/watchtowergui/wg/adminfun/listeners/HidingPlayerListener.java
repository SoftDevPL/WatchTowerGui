package watchtowergui.wg.adminfun.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.PlayerHideEvent;
import watchtowergui.wg.adminfun.events.PlayerUnHideEvent;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import watchtowergui.wg.managers.Permissions;

import java.util.*;
import java.util.stream.Collectors;

public class HidingPlayerListener implements Listener {

    private final List<UUID> hiddenPlayers = new ArrayList<>();
    private WatchTowerGui plugin;
    private LanguageConfig languageConfig;
    private Database database;
    private Permissions permissions;

    public void init() {
        this.plugin = WatchTowerGui.getInstance();
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.languageConfig = this.plugin.configsManager.languageConfig;
        this.database = this.plugin.SQLmanager.database;
        this.permissions = this.plugin.permissions;
        loadFromDatabase();
        startScheduler();
        hideAllPlayersOnReload();
    }

    private void loadFromDatabase() {
        List<String> all = database.getVanishedPlayers();
        for (String one : all) {
            try {
                UUID uuid = UUID.fromString(one);
                this.hiddenPlayers.add(uuid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startScheduler() {
        List<UUID> alreadyChecked = new ArrayList<>();

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
            Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
            for (Player p : onlinePlayers) {
                if (canSeeOthers(p) && !alreadyChecked.contains(p.getUniqueId())) {
                    alreadyChecked.add(p.getUniqueId());
                    showPlayersForThisPlayer(p);
                } else if (!canSeeOthers(p) && alreadyChecked.contains(p.getUniqueId())) {
                    alreadyChecked.remove(p.getUniqueId());
                    hidePlayersForThisPlayer(p);
                }
            }
        }, 0, 20);
    }

    private void hideAllPlayersOnReload() {
        for (UUID uuid : hiddenPlayers) {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null) continue;
            this.hidePlayer(player);
        }
    }


    public void disable() {
        for (UUID uuid : hiddenPlayers) {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null) continue;
            this.showPlayer(player);
        }
    }

    public boolean addPlayerToHideList(UUID playerUUID) {
        if (!isHidden(playerUUID)) {
            hiddenPlayers.add(playerUUID);
            Player player = Bukkit.getPlayer(playerUUID);
            if (player != null) hidePlayer(player);
            addToDatabase(playerUUID);
            return true;
        }
        return false;
    }

    public boolean addPlayerToHideList(Player player) {
        if (!isHidden(player.getUniqueId())) {
            hiddenPlayers.add(player.getUniqueId());
            hidePlayer(player);
            addToDatabase(player.getUniqueId());
            return true;
        }
        return false;
    }

    public boolean removePlayerFromHideList(Player player) {
        if (isHidden(player.getUniqueId())) {
            hiddenPlayers.remove(player.getUniqueId());
            showPlayer(player);
            removeFromDatabase(player.getUniqueId());
            return true;
        }
        return false;
    }

    public boolean removePlayerFromHideList(UUID playerUUID) {
        if (isHidden(playerUUID)) {
            hiddenPlayers.remove(playerUUID);
            Player player = Bukkit.getPlayer(playerUUID);
            if (player != null) showPlayer(player);
            removeFromDatabase(playerUUID);
            return true;
        }
        return false;
    }


    private void hidePlayersForThisPlayer(Player player) {
        Collection<Player> hiddenPlayers = this.getHiddenPlayers().stream()
                .map(Bukkit::getPlayer).filter(Objects::nonNull).collect(Collectors.toList());

        for (Player p : hiddenPlayers) {
            player.hidePlayer(WatchTowerGui.getInstance(), p);
        }
    }

    private void showPlayersForThisPlayer(Player player) {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        for (Player p : onlinePlayers) {
            player.showPlayer(WatchTowerGui.getInstance(), p);
        }
    }


    private void hidePlayer(Player player) {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        for (Player p : onlinePlayers) {
            if (canSeeOthers(p)) continue;
            p.hidePlayer(this.plugin, player);
        }
    }

    private void showPlayer(Player player) {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        for (Player p : onlinePlayers) {
            p.showPlayer(this.plugin, player);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void hidingPlayers(PlayerHideEvent event) {
        CommandSender sender = event.getSender();
        boolean senderIsHidingPlayer = sender instanceof Player && ((Player) sender).getUniqueId().equals(event.getPlayer().getUniqueId());
        if (sender != null) {
            //assert sender instanceof Player;
            addPlayerToHideList((Player) event.getPlayer());
            if (senderIsHidingPlayer) {
                event.getSender().sendMessage(languageConfig.getCommandsLocale_hide_youAreHidden());
            } else {
                event.getSender().sendMessage(languageConfig.getCommandsLocale_hide_playerIsAlreadyHidden(event.getPlayer().getName()));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void showingPlayers(PlayerUnHideEvent event) {
        CommandSender sender = event.getSender();
        boolean senderIsHidingPlayer = sender instanceof Player && ((Player) sender).getUniqueId().equals(event.getPlayer().getUniqueId());
        if (sender != null) {
           // assert sender instanceof Player;
            removePlayerFromHideList((Player) event.getPlayer());
            if (senderIsHidingPlayer) {
                event.getSender().sendMessage(languageConfig.getCommandsLocale_hide_youAreNotHidden());
            } else {
                event.getSender().sendMessage(languageConfig.getCommandsLocale_hide_playerNotHidden(event.getPlayer().getName()));
            }
        }
    }


    @EventHandler
    public void removingHidingWhenQuit(PlayerQuitEvent event) {
        Player playerWhoLeave = event.getPlayer();
        if (isHidden(playerWhoLeave.getUniqueId())) {
            showPlayer(playerWhoLeave);
        }
        for (UUID uuid : hiddenPlayers) {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null) continue;
            playerWhoLeave.showPlayer(this.plugin, player);
        }
    }

    @EventHandler
    public void hidingPlayerWhenJoin(PlayerJoinEvent event) {
        Player playerWhoJoin = event.getPlayer();
        if (isHidden(playerWhoJoin.getUniqueId())) {
            hidePlayer(playerWhoJoin);
        }
        for (UUID uuid : hiddenPlayers) {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null) continue;
            playerWhoJoin.hidePlayer(this.plugin, player);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void noJoinMessage(PlayerJoinEvent event) {
        if (isHidden(event.getPlayer().getUniqueId())) {
            event.setJoinMessage("");
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void noQuitMessage(PlayerQuitEvent event) {
        if (isHidden(event.getPlayer().getUniqueId())) {
            event.setQuitMessage("");
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void noDeathMessage(PlayerDeathEvent event) {
        if (isHidden(event.getEntity().getUniqueId())) {
            event.setDeathMessage("");
            return;
        }
        Player killer = event.getEntity().getKiller();
        if (killer == null) return;
        if (isHidden(killer.getUniqueId())) {
            String message = event.getDeathMessage();
            message = message.replaceAll("(?i)" + killer.getName(), ChatColor.MAGIC + "HEROBRINE" + ChatColor.RESET);
            event.setDeathMessage(message);
        }
    }

    public List<UUID> getHiddenPlayers() {
        return hiddenPlayers;
    }

    public boolean isHidden(UUID player) {
        return hiddenPlayers.contains(player);
    }

    public boolean canSeeOthers(Player player) {
        return player.hasPermission(permissions.canSeeHiddenPerm);
    }

    private void addToDatabase(UUID player) {
        database.insertIntoVanishTable(player.toString());
    }

    private void removeFromDatabase(UUID player) {
        database.deleteVanishedPlayers(player.toString());
    }
}
