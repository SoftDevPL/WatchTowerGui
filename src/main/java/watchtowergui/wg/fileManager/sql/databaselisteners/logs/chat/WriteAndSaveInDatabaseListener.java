package watchtowergui.wg.fileManager.sql.databaselisteners.logs.chat;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.DisabledCommandsForLogsConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WriteAndSaveInDatabaseListener implements Listener {

    private final Database database;
    private final List<String> commandsList;
    public DisabledCommandsForLogsConfig disabledCommandsForLogsConfig;

    public WriteAndSaveInDatabaseListener(WatchTowerGui watchTowerGui) {
        watchTowerGui.getServer().getPluginManager().registerEvents(this, watchTowerGui);
        this.disabledCommandsForLogsConfig = watchTowerGui.configsManager.disabledCommandsForLogsConfig;
        this.database = watchTowerGui.SQLmanager.database;
        commandsList = disabledCommandsForLogsConfig.getAllWordsFromConfig();
    }

    private java.sql.Timestamp returnSQLDate() {
        Date date = new Date();
        return new java.sql.Timestamp(date.getTime());
    }

    private List<String> prepareCommandList(List<String> commandsList) {
        return commandsList.stream().map(item -> item.replace("/", "")).collect(Collectors.toList());
    }

    private boolean chatMessageContainsCommand(String chatMessage) {
        for (String command : prepareCommandList(commandsList)) {
            if (chatMessage.contains(command)) {
                return true;
            }
        }
        return false;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void catchPlayerWrite(AsyncPlayerChatEvent playerChatEvent) {
        String chatMessage = chatMessageContainsCommand(playerChatEvent.getMessage())
                ? disabledCommandsForLogsConfig.getCommandExcludeResponse()
                : playerChatEvent.getMessage();
        playerChatEvent.setMessage(chatMessage);
        java.sql.Timestamp sqlTime = returnSQLDate();
        this.database.insertIntoChatLogsTable(
                String.valueOf(playerChatEvent.getPlayer().getUniqueId()),
                sqlTime,
                chatMessage);
    }

}
