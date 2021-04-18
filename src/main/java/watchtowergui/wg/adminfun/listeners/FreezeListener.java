package watchtowergui.wg.adminfun.listeners;

import org.bukkit.Bukkit;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.PlayerFreezeEvent;
import watchtowergui.wg.adminfun.events.PlayerUnfreezeEvent;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.FrozenPlayersTable;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FreezeListener implements Listener {

    List<String> frozenUUIDs;
    private WatchTowerGui plugin;
    private FrozenPlayersTable frozenPlayersTable;
    private LanguageConfig languageConfig;

    public void init() {
        this.plugin = WatchTowerGui.getInstance();
        this.frozenPlayersTable = this.plugin.SQLmanager.frozenPlayersConfig;
        frozenUUIDs = this.frozenPlayersTable.getPlayersList();
        this.languageConfig = this.plugin.configsManager.languageConfig;
        plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    public boolean addPlayer(OfflinePlayer playerToFreeze) {
        if (!frozenUUIDs.contains(playerToFreeze.getUniqueId().toString())) {
            frozenUUIDs.add(playerToFreeze.getUniqueId().toString());
            this.frozenPlayersTable.addPlayerToConfig(playerToFreeze);
            this.plugin.getServer().getPluginManager().callEvent(new PlayerFreezeEvent(playerToFreeze, null));
            return true;
        }
        return false;
    }

    public boolean removePlayer(OfflinePlayer frozenPlayer) {
        if (!frozenUUIDs.contains(frozenPlayer.getUniqueId().toString()))
            return false;
        frozenUUIDs.remove(frozenPlayer.getUniqueId().toString());
        this.frozenPlayersTable.removePlayerFromConfig(frozenPlayer);
        this.plugin.getServer().getPluginManager().callEvent(new PlayerUnfreezeEvent(frozenPlayer, null));
        return true;

    }

    public boolean isFrozen(OfflinePlayer player) {
        return frozenUUIDs.contains(player.getUniqueId().toString());
    }

    public List<UUID> getFrozenPlayers() {
        return frozenUUIDs.stream().map(UUID::fromString).collect(Collectors.toList());
    }


    @EventHandler(ignoreCancelled = true)
    private void freezeMoveEvent(PlayerMoveEvent e) {
        if (isFrozen(e.getPlayer())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.languageConfig.getMesToPlayerWhoIsFrozen());
        }
    }

    @EventHandler(ignoreCancelled = true)
    private void freezeInteractEvent(PlayerInteractEvent e) {
        if (isFrozen(e.getPlayer())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.languageConfig.getMesToPlayerWhoIsFrozen());
        }
    }

    @EventHandler(ignoreCancelled = true)
    private void placeBlockEvent(BlockPlaceEvent e) {
        if (isFrozen(e.getPlayer())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.languageConfig.getMesToPlayerWhoIsFrozen());
        }
    }

    @EventHandler(ignoreCancelled = true)
    private void damageEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && isFrozen((OfflinePlayer) e.getDamager())) {
            e.setCancelled(true);
            e.getDamager().sendMessage(this.languageConfig.getMesToPlayerWhoIsFrozen());
        }
    }
}
