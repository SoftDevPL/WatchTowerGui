package watchtowergui.wg.fileManager.sql.databaselisteners.logs.joinandquit;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Date;

public class QuitAndSaveUserInDatabaseListener implements Listener {

    private final Database database;

    public QuitAndSaveUserInDatabaseListener(WatchTowerGui plugin) {
        this.database = plugin.SQLmanager.database;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void saveUserOnQuit(PlayerQuitEvent playerQuitEvent) {
        Date date = new Date();
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
        this.database.insertIntoQuitLogsTable(
                String.valueOf(playerQuitEvent.getPlayer().getUniqueId()),
                sqlTime);
    }
}
