package watchtowergui.wg.fileManager.sql.databaselisteners.logs.commands;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.*;
import watchtowergui.wg.bans.event.PlayerGetTempBanEvent;
import watchtowergui.wg.bans.event.PlayerRemoveTempBanEvent;
import watchtowergui.wg.chat.mute.events.PlayerGetMuteEvent;
import watchtowergui.wg.chat.mute.events.PlayerRemoveMuteEvent;
import watchtowergui.wg.fileManager.configsutils.configs.DisabledCommandsForLogsConfig;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

import java.util.Date;
import java.util.List;

public class ExecuteCommandAndSaveInDatabaseListener implements Listener {

    private final AdminGuiDatabase adminGuiDatabase;
    private final List<String> commandsList;
    public LanguageConfig languageConfig;
    public DisabledCommandsForLogsConfig disabledCommandsForLogsConfig;

    public ExecuteCommandAndSaveInDatabaseListener(WatchTowerGui watchTowerGui) {
        this.languageConfig = watchTowerGui.configsManager.languageConfig;
        watchTowerGui.getServer().getPluginManager().registerEvents(this, watchTowerGui);
        this.adminGuiDatabase = watchTowerGui.SQLmanager.database;
        this.disabledCommandsForLogsConfig = watchTowerGui.configsManager.disabledCommandsForLogsConfig;
        commandsList = disabledCommandsForLogsConfig.getAllWordsFromConfig();
    }

    private java.sql.Timestamp returnSQLDate() {
        Date date = new Date();
        return new java.sql.Timestamp(date.getTime());
    }

    private boolean chatMessageContainsCommand(String chatMessage) {
        for (String command : commandsList) {
            if (chatMessage.contains(command)) {
                return true;
            }
        }
        return false;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void catchPlayerExecuteCommand(PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        String chatMessage = chatMessageContainsCommand(playerCommandPreprocessEvent.getMessage())
                ? disabledCommandsForLogsConfig.getCommandExcludeResponse()
                : playerCommandPreprocessEvent.getMessage();
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(playerCommandPreprocessEvent.getPlayer().getUniqueId()),
                sqlTime,
                chatMessage);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void serverCommand(ServerCommandEvent event) {
        String chatMessage = chatMessageContainsCommand(event.getCommand())
                ? disabledCommandsForLogsConfig.getCommandExcludeResponse()
                : event.getCommand();
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                "Server",
                sqlTime,
                chatMessage);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void catchPlayerBan(PlayerGetTempBanEvent e) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(e.getBannedPlayer().getUniqueId()),
                sqlTime,
                e.getBannedPlayer().getName() + " banned by: " + e.getComment());

    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void catchPlayerUnBan(PlayerRemoveTempBanEvent e) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(e.getUnBannedPlayer().getUniqueId()),
                sqlTime,
                e.getUnBannedPlayer().getName() + " unbanned by: " + e.getWhoUnbanned().getName());

    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void catchPlayerMute(PlayerGetMuteEvent e) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(e.getMutedPlayer().getUniqueId()),
                sqlTime,
                e.getMutedPlayer().getName() + " muted by: " + e.getWhoMuted().getName());

    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void catchPlayerUnMute(PlayerRemoveMuteEvent e) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(e.getUnMutedPlayer().getUniqueId()),
                sqlTime,
                e.getUnMutedPlayer().getName() + " unmuted by: " + e.getWhoUnMuted().getName());

    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void catchCommandEvent(CommandEvent e) {
        if (e.isDone()) {
            java.sql.Timestamp sqlTime = returnSQLDate();
            Player player;
            if (e.getSender() instanceof Player) {
                player = (Player) e.getSender();
                this.adminGuiDatabase.insertIntoCommandsLogsTable(
                        String.valueOf(player.getUniqueId()),
                        sqlTime,
                        e.getDescription()
                );
            } else {
                this.adminGuiDatabase.insertIntoCommandsLogsTable(
                        "info",
                        sqlTime,
                        e.getDescription()
                );
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void chatEnabled(ChatDisabledOnEvent event) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(event.getPlayer().getUniqueId()),
                sqlTime,
                "enabled chat"
        );
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void chatDisabled(ChatDisabledOFFEvent event) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(event.getPlayer().getUniqueId()),
                sqlTime,
                "disabled chat"
        );
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void maintenanceModeON(WhiteListOnEvent event) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(event.getPlayer().getUniqueId()),
                sqlTime,
                "maintenanceMode updated to ON"
        );
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void maintenanceModeOFF(WhiteListOffEvent event) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(event.getPlayer().getUniqueId()),
                sqlTime,
                "maintenanceMode updated to OFF"
        );
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void vanishON(PlayerHideEvent event) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(event.getPlayer().getUniqueId()),
                sqlTime,
                "Player vanished"
        );
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    private void vanishOFF(PlayerUnHideEvent event) {
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.adminGuiDatabase.insertIntoCommandsLogsTable(
                String.valueOf(event.getPlayer().getUniqueId()),
                sqlTime,
                "Player appeared"
        );
    }
}
