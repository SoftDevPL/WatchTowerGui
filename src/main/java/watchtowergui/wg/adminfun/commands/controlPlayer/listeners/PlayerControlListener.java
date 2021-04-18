package watchtowergui.wg.adminfun.commands.controlPlayer.listeners;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.ControlOFFPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.ControlOnPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.SpectateOFFPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.SpectateOnPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.models.SpectatingPlayer;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerControlListener implements Listener {
    @Getter
    private final Map<UUID, Integer> bukkitTasks = new HashMap<>();
    @Getter
    private LanguageConfig languageConfig;
    @Getter
    private Database database;
    @Getter
    private WatchTowerGui watchTowerGui;
    @Getter
    private Map<UUID, SpectatingPlayer> controllingPlayerLocationMap = new HashMap<>();
    @Getter
    private final Map<UUID, UUID> playersWithControllers = new HashMap<>();

    public void init() {
        watchTowerGui = WatchTowerGui.getInstance();
        database = watchTowerGui.SQLmanager.database;
        languageConfig = watchTowerGui.configsManager.languageConfig;
        Bukkit.getServer().getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
        deleteAllNotExistingWorlds();
        controllingPlayerLocationMap = database.getAllControlingPlayers();
        setupControlledPlayers();
        lockAllPlayersOnReload();
    }

    private void setupControlledPlayers() {
        for (Map.Entry<UUID, SpectatingPlayer> entry : controllingPlayerLocationMap.entrySet()) {
            playersWithControllers.put(entry.getValue().getControlledPlayerUUID(), entry.getKey());
        }
    }

    private List<UUID> returnRetailedList(List<UUID> mainList, List<UUID> listToRetail) {
        return listToRetail.stream().filter(item -> !mainList.contains(item)).collect(Collectors.toList());
    }

    private void deleteAllNotExistingWorlds() {
        List<UUID> homesWorldsUUIDS = new ArrayList<>();

        for (Map.Entry<UUID, SpectatingPlayer> entry : database.getAllControlingPlayers().entrySet()) {
            if (entry.getValue().getLocation().getWorld() == null) {
                this.database.deleteControllingPlayerData(entry.getKey().toString());
            } else {
                homesWorldsUUIDS.add(entry.getValue().getLocation().getWorld().getUID());
            }
        }

        for (UUID uuid : returnRetailedList(Bukkit.getWorlds().stream().map(World::getUID).collect(Collectors.toList()), homesWorldsUUIDS)) {
            this.database.deleteControllingPlayerDataByWorld(uuid.toString());
        }
    }

    private void lockAllPlayersOnReload() {
        for (Map.Entry<UUID, SpectatingPlayer> entry : controllingPlayerLocationMap.entrySet()) {
            Player playerToControl = Bukkit.getPlayer(entry.getValue().getControlledPlayerUUID());
            Player controller = Bukkit.getPlayer(entry.getKey());
            if (playerToControl != null && controller != null) {
                lockPlayer(controller, playerToControl, entry.getValue().getIsControlling());
            }
        }
    }

    private void setupPlayerAfterDisabling(Player controller, Player controllingPlayer) {
        controllingPlayer.setAllowFlight(false);
        SpectatingPlayer spectatingPlayer = this.controllingPlayerLocationMap.get(controller.getUniqueId());
        GameMode gameMode = spectatingPlayer.getLastGameMode().equals(GameMode.ADVENTURE.name()) ? GameMode.ADVENTURE
                : spectatingPlayer.getLastGameMode().equals(GameMode.CREATIVE.name()) ? GameMode.CREATIVE
                : spectatingPlayer.getLastGameMode().equals(GameMode.SURVIVAL.name()) ? GameMode.SURVIVAL
                : spectatingPlayer.getLastGameMode().equals(GameMode.ADVENTURE.name()) ? GameMode.ADVENTURE : GameMode.CREATIVE;
        controller.teleport(spectatingPlayer.getLocation());
        controller.setGameMode(gameMode);
        playersWithControllers.remove(controllingPlayer.getUniqueId());
        database.deleteControllingPlayerData(controller.getUniqueId().toString());
        controllingPlayerLocationMap.remove(controller.getUniqueId());
        Bukkit.getServer().getScheduler().cancelTask(bukkitTasks.get(controller.getUniqueId()));
        bukkitTasks.remove(controller.getUniqueId());
    }

    private void changeControllingValue(Player controller, Player controlledPlayer, Integer isControlled) {
        if (!playersWithControllers.containsValue(controlledPlayer.getUniqueId())) {
            this.database.insertControllingPlayer(controller, controlledPlayer, isControlled);
            playersWithControllers.remove(controlledPlayer.getUniqueId());
            playersWithControllers.put(controlledPlayer.getUniqueId(), controller.getUniqueId());
            SpectatingPlayer spectatingPlayer = new SpectatingPlayer(
                    controller.getUniqueId(),
                    controlledPlayer.getUniqueId(),
                    isControlled,
                    controller.getGameMode().name(),
                    controller.getLocation()
            );
            controllingPlayerLocationMap.remove(controller.getUniqueId());
            controllingPlayerLocationMap.put(controller.getUniqueId(), spectatingPlayer);
            lockPlayer(controller, controlledPlayer, isControlled);
        }
    }

    @EventHandler
    private void controlPlayerOn(ControlOnPlayerEvent e) {
        if (e.getPlayer().equals(e.getControllingPlayer())) {
            e.getPlayer().sendMessage(WatchTowerGui.convertColors("&c&lYou can't control &f&lyourself"));
            return;
        }
        if (playersWithControllers.containsValue(e.getPlayer().getUniqueId()) || playersWithControllers.containsKey(e.getControllingPlayer().getUniqueId())) {
            e.getPlayer().sendMessage(WatchTowerGui.convertColors("&c&lSomeone is controlling this player"));
            return;
        }
        changeControllingValue(e.getPlayer(), e.getControllingPlayer(), 1);
    }

    private synchronized BukkitTask runScheduler(Player controller, Player playerToControl, Integer isControlling) {
        return Bukkit.getServer().getScheduler().runTaskTimer(this.watchTowerGui, () -> {
            if (isControlling == 1) {
                Location location = controller.getLocation();
                Vector inverseDirectionVec = controller.getLocation().getDirection().normalize().multiply(-1);
                location.add(inverseDirectionVec);
                playerToControl.teleport(location);
            } else {
                Location location = playerToControl.getLocation();
                Vector inverseDirectionVec = playerToControl.getLocation().getDirection().normalize().multiply(+1);
                location.add(inverseDirectionVec);
                controller.teleport(location);
            }
        }, 5, 2);
    }

    private void lockPlayer(Player controller, Player playerToControl, Integer isControlled) {
        playerToControl.setAllowFlight(true);
        controller.setGameMode(GameMode.SPECTATOR);
        Bukkit.getServer().getScheduler().runTaskAsynchronously(this.watchTowerGui, () -> {
            controller.teleport(playerToControl.getLocation());
            BukkitTask task = runScheduler(controller, playerToControl, isControlled);
            if (!bukkitTasks.containsKey(controller.getUniqueId())) {
                bukkitTasks.put(controller.getUniqueId(), task.getTaskId());
            }
        });
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        Player controller = Bukkit.getPlayer(playersWithControllers.get(event.getPlayer().getUniqueId()));
        Bukkit.getServer().getPluginManager().callEvent(new ControlOFFPlayerEvent(controller, event.getPlayer()));
    }

    @EventHandler
    private void spectatePlayerOn(SpectateOnPlayerEvent e) {
        if (e.getPlayer().equals(e.getControllingPlayer())) {
            e.getPlayer().sendMessage(WatchTowerGui.convertColors("&c&lYou can't spectate &f&lyourself"));
            return;
        }
        if (playersWithControllers.containsValue(e.getPlayer().getUniqueId()) || playersWithControllers.containsKey(e.getControllingPlayer().getUniqueId())) {
            e.getPlayer().sendMessage(WatchTowerGui.convertColors("&c&lSomeone is spectating this player"));
            return;
        }
        changeControllingValue(e.getPlayer(), e.getControllingPlayer(), 0);
    }

    @EventHandler
    private void controlPlayerOFF(ControlOFFPlayerEvent e) {
        setupPlayerAfterDisabling(e.getPlayer(), e.getControllingPlayer());
        if (bukkitTasks.containsKey(e.getPlayer().getUniqueId())) {
            Bukkit.getServer().getPluginManager().callEvent(new ControlOnPlayerEvent(e.getPlayer(), e.getControllingPlayer()));
        }
    }

    @EventHandler
    private void spectatePlayerOFF(SpectateOFFPlayerEvent e) {
        setupPlayerAfterDisabling(e.getPlayer(), e.getControllingPlayer());
        if (bukkitTasks.containsKey(e.getPlayer().getUniqueId())) {
            Bukkit.getServer().getPluginManager().callEvent(new SpectateOnPlayerEvent(e.getPlayer(), e.getControllingPlayer()));
        }
    }
}
