package watchtowergui.wg.adminfun.commands.controlPlayer.listeners;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
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
    private LanguageConfig languageConfig;
    @Getter
    private Database database;
    @Getter
    private WatchTowerGui watchTowerGui;
    @Getter
    private Map<UUID, SpectatingPlayer> spectatingPlayerLocationMap = new HashMap<>();
    @Getter
    /*
    1. playerWithSpectator
    2. spectator
     */
    private Map<UUID, UUID> playersWithSpectators = new HashMap<>();
    public void init() {
        this.watchTowerGui = WatchTowerGui.getInstance();
        this.database = this.watchTowerGui.SQLmanager.database;
        this.languageConfig = this.watchTowerGui.configsManager.languageConfig;
        Bukkit.getServer().getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
        deleteAllNotExistingWorlds();
        this.spectatingPlayerLocationMap = this.database.getAllSpectatingPlayers();
        System.out.println(spectatingPlayerLocationMap);
        this.playersWithSpectators = this.database.getAllPlayersWithSpectators();
    }

    private List<UUID> returnRetailedList(List<UUID> mainList, List<UUID> listToRetail) {
        return listToRetail.stream().filter(item -> !mainList.contains(item)).collect(Collectors.toList());
    }

    private void deleteAllNotExistingWorlds() {
        List<UUID> homesWorldsUUIDS = new ArrayList<>();

        for (Map.Entry<UUID, SpectatingPlayer> entry : database.getAllSpectatingPlayers().entrySet()) {
            if (entry.getValue().getLocation().getWorld() == null) {
                this.database.deleteSpectatingPlayerData(entry.getKey().toString());
            } else {
                homesWorldsUUIDS.add(entry.getValue().getLocation().getWorld().getUID());
            }
        }

        for (UUID uuid : returnRetailedList(Bukkit.getWorlds().stream().map(World::getUID).collect(Collectors.toList()), homesWorldsUUIDS)) {
            this.database.deleteSpectatingPlayerDataByWorld(uuid.toString());
        }
    }

    private void addSpectatingPlayer(Player spectatingPlayer) {
        if (!this.spectatingPlayerLocationMap.containsKey(spectatingPlayer.getUniqueId())) {
            SpectatingPlayer spectatingPlayerModel = new SpectatingPlayer(
                    spectatingPlayer.getUniqueId(),
                    spectatingPlayer.getGameMode().name(),
                    spectatingPlayer.getLocation()
            );
            this.spectatingPlayerLocationMap.put(spectatingPlayer.getUniqueId(), spectatingPlayerModel);
            this.database.insertSpectatingPlayer(spectatingPlayer, spectatingPlayer.getLocation());
        }
    }

    private void deleteSpectatingPlayer(Player spectatingPlayer) {
        this.spectatingPlayerLocationMap.remove(spectatingPlayer.getUniqueId());
        this.database.deleteSpectatingPlayerData(spectatingPlayer.getUniqueId().toString());
    }

    @EventHandler
    private void SpectatePlayerOn(SpectateOnPlayerEvent e) {
        if (e.getPlayer().equals(e.getControllingPlayer())) {
            e.getPlayer().sendMessage("Nie mozesz siebie");
            return;
        }
        this.playersWithSpectators.put(e.getControllingPlayer().getUniqueId(), e.getPlayer().getUniqueId());
        this.database.insertPlayerWithSpectator(e.getControllingPlayer(), e.getPlayer());
        addSpectatingPlayer(e.getPlayer());
        e.getPlayer().setGameMode(GameMode.SPECTATOR);
        Bukkit.getServer().getScheduler().runTaskAsynchronously(this.watchTowerGui, ()-> {
            e.getPlayer().teleport(e.getControllingPlayer().getLocation(), PlayerTeleportEvent.TeleportCause.PLUGIN);
            Bukkit.getServer().getScheduler().runTaskAsynchronously(this.watchTowerGui, ()-> {
                e.getPlayer().setSpectatorTarget(e.getControllingPlayer());
            });
        });
    }

    @EventHandler
    private void SpectatePlayerOFF(SpectateOFFPlayerEvent e) {
        SpectatingPlayer spectatingPlayer = this.spectatingPlayerLocationMap.get(e.getPlayer().getUniqueId());
        GameMode gameMode = spectatingPlayer.getLastGamemode().equals(GameMode.ADVENTURE.name()) ? GameMode.ADVENTURE
                : spectatingPlayer.getLastGamemode().equals(GameMode.CREATIVE.name()) ? GameMode.CREATIVE
                : spectatingPlayer.getLastGamemode().equals(GameMode.SURVIVAL.name()) ? GameMode.SURVIVAL
                : spectatingPlayer.getLastGamemode().equals(GameMode.ADVENTURE.name()) ? GameMode.ADVENTURE : GameMode.CREATIVE;
        e.getPlayer().teleport(spectatingPlayer.getLocation());
        e.getPlayer().leaveVehicle();
        e.getPlayer().setSpectatorTarget(null);
        e.getPlayer().setGameMode(gameMode);
        deleteSpectatingPlayer(e.getPlayer());
        this.playersWithSpectators.remove(e.getControllingPlayer().getUniqueId());
        this.database.deletePlayerWithSpectator(e.getControllingPlayer().getUniqueId().toString());
    }

    @EventHandler
    private void OnQuit(PlayerQuitEvent event) {
        if (playersWithSpectators.containsKey(event.getPlayer().getUniqueId())) {
            Bukkit.getServer().getPluginManager().callEvent(new SpectateOFFPlayerEvent(Bukkit.getPlayer(playersWithSpectators.get(event.getPlayer().getUniqueId())), event.getPlayer()));
        }
    }

    @EventHandler
    private void playerSneakEvent(PlayerToggleSneakEvent e) {
        deleteSpectatingPlayer(e.getPlayer());
        UUID spectatingPlayerUUID = playersWithSpectators.keySet()
                .parallelStream()
                .filter(key -> e.getPlayer().getUniqueId().equals(playersWithSpectators.get(key)))
                .findFirst().orElse(null);
        playersWithSpectators.remove(e.getPlayer().getUniqueId());
        this.database.deletePlayerWithSpectator(e.getPlayer().getUniqueId().toString());
        if (spectatingPlayerUUID != null) {
            this.database.deleteSpectatingPlayerData(spectatingPlayerUUID.toString());
        }
    }

    @EventHandler
    private void controlPlayerOn(ControlOnPlayerEvent e) {

    }

    @EventHandler
    private void controlPlayerOFF(ControlOFFPlayerEvent e) {

    }
}
