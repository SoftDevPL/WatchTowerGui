package watchtowergui.wg.fileManager.sql.databaselisteners.logs.joinandquit;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Date;

public class JoinAndSaveUserInDatabaseListener implements Listener {

    private final Database database;

    public JoinAndSaveUserInDatabaseListener(WatchTowerGui plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.database = plugin.SQLmanager.database;
    }

    @EventHandler
    private void saveUserOnJoin(PlayerJoinEvent playerJoinEvent) {
        Date date = new Date();
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
        this.database.insertIntoJoinLogsTable(
                String.valueOf(playerJoinEvent.getPlayer().getUniqueId()),
                sqlTime);
    }

}
