package watchtowergui.wg.adminfun.listeners;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.guis.AdminFunGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import watchtowergui.wg.managers.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import watchtowergui.wg.adminfun.events.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WhiteListListener implements Listener {
    private final List<AdminFunGui> adminFunGuis = new ArrayList<>();
    private final int schedulerDelay = 20;
    public Permissions permissions;
    public LanguageConfig languageConfig;
    public boolean maintenanceMode;
    private int maintenanceSwitchedValue = 0;
    private List<String> maintenancePlayerList;
    private Database database;

    private boolean MaintenanceSwitched() {
        return this.maintenanceSwitchedValue == 1;
    }

    public void init() {
        WatchTowerGui watchTowerGui = WatchTowerGui.getInstance();
        permissions = watchTowerGui.permissions;
        database = watchTowerGui.SQLmanager.database;
        this.maintenanceSwitchedValue = this.database.getMaintenanceModeSwitched();
        this.maintenanceMode = MaintenanceSwitched();
        maintenancePlayerList = database.getMaintenancePlayers();
        setItemMode();
        languageConfig = watchTowerGui.configsManager.languageConfig;
        watchTowerGui.getServer().getPluginManager().registerEvents(this, watchTowerGui);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(watchTowerGui, () -> {
            Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
            for (Player player : onlinePlayers) {
                if (maintenanceMode) {
                    if (!player.hasPermission(permissions.maintenancePerm)) {
                        maintenancePlayerList.remove(player.getUniqueId().toString());
                        database.deleteMeintenencePlayers(player.getUniqueId().toString());
                        player.kickPlayer(languageConfig.getMaintenanceModeKickMessage());
                    }
                }
            }
        }, schedulerDelay, schedulerDelay);

    }

    public boolean isPlayerInMainteneceMode(Player player) {
        return maintenancePlayerList.contains(player.getUniqueId().toString());
    }

    public int maintenanceValue() {
        return maintenanceMode ? 1 : 0;
    }


    public boolean addToAdminFunGuis(AdminFunGui gui) {
        if (!adminFunGuis.contains(gui)) {
            return adminFunGuis.add(gui);
        }
        return false;
    }

    public boolean removeAdminFunGuis(AdminFunGui gui) {
        return adminFunGuis.remove(gui);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void addPlayerToWhiteList(AddPlayerToWhiteListEvent e) {
        database.insertIntoMaintenanceTable(e.getPlayer().getUniqueId().toString());
        maintenancePlayerList.add(e.getPlayer().getUniqueId().toString());
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void removePlayerFromWhiteList(RemovePlayerFromWhiteListEvent e) {
        maintenancePlayerList.remove(e.getPlayer().getUniqueId().toString());
        database.deleteMeintenencePlayers(e.getPlayer().getUniqueId().toString());
        e.getPlayer().getPlayer().kickPlayer(languageConfig.getMaintenanceModeKickMessage());
    }

    @EventHandler
    private void kickIfNotInMaintenanceMode(PlayerLoginEvent event) {
        if (maintenanceMode) {
            if (!event.getPlayer().hasPermission(permissions.maintenancePerm)) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, languageConfig.getMaintenanceModeKickMessage());

            }
        }
    }

    public void setItemMode() {
        if (maintenanceMode) {
            for (AdminFunGui adminFunGui : adminFunGuis) {
                adminFunGui.setMaintenanceMode(AdminFunGui.ONN);
            }
        } else {
            for (AdminFunGui adminFunGui : adminFunGuis) {
                adminFunGui.setMaintenanceMode(AdminFunGui.OFF);
            }
        }
    }

    @EventHandler
    private void whiteListOn(WhiteListOnEvent e) {
        database.deleteMaintenanceSwitchValue();
        database.insertIntoMaintenanceSwitchTable(1);
        maintenanceMode = true;
        for (AdminFunGui adminFunGui : adminFunGuis) {
            adminFunGui.setMaintenanceMode(AdminFunGui.ONN);
        }
    }

    @EventHandler
    private void whiteListOff(WhiteListOffEvent e) {
        database.deleteMaintenanceSwitchValue();
        database.insertIntoMaintenanceSwitchTable(0);
        maintenanceMode = false;
        for (AdminFunGui adminFunGui : adminFunGuis) {
            adminFunGui.setMaintenanceMode(AdminFunGui.OFF);
        }
    }

    @EventHandler
    public void vanishOn(PlayerHideEvent e) {
        for (AdminFunGui adminFunGui : adminFunGuis) {
            if (adminFunGui.getLastViewer().getUniqueId().equals(e.getPlayer().getUniqueId()))
                adminFunGui.setVanishMode(true);
        }
    }

    @EventHandler
    public void vanishOff(PlayerUnHideEvent e) {
        for (AdminFunGui adminFunGui : adminFunGuis) {
            if (adminFunGui.getLastViewer().getUniqueId().equals(e.getPlayer().getUniqueId()))
                adminFunGui.setVanishMode(false);
        }
    }
}
