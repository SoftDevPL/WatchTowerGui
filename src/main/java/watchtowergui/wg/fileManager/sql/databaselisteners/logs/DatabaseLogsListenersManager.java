package watchtowergui.wg.fileManager.sql.databaselisteners.logs;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.sql.databaselisteners.logs.chat.WriteAndSaveInDatabaseListener;
import watchtowergui.wg.fileManager.sql.databaselisteners.logs.commands.ExecuteCommandAndSaveInDatabaseListener;
import watchtowergui.wg.fileManager.sql.databaselisteners.logs.joinandquit.JoinAndSaveUserInDatabaseListener;
import watchtowergui.wg.fileManager.sql.databaselisteners.logs.joinandquit.QuitAndSaveUserInDatabaseListener;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatabaseLogsListenersManager {

    private static AdminGuiDatabase adminGuiDatabase;
    public JoinAndSaveUserInDatabaseListener joinAndSaveUserInDatabaseListener;
    public QuitAndSaveUserInDatabaseListener quitAndSaveUserInDatabaseListener;
    public ExecuteCommandAndSaveInDatabaseListener executeCommandAndSaveInDatabaseListener;
    public WriteAndSaveInDatabaseListener writeAndSaveInDatabaseListener;
    private WatchTowerGui plugin;

    public static AdminGuiDatabase getAdminGuiDatabase() {
        return adminGuiDatabase;
    }

    public void init() {
        this.plugin = WatchTowerGui.getInstance();
        initDatabaseListeners();
        adminGuiDatabase = this.plugin.SQLmanager.database;
        deleteOldLogs();
    }

    private void initDatabaseListeners() {
        joinAndSaveUserInDatabaseListener = new JoinAndSaveUserInDatabaseListener(this.plugin);
        quitAndSaveUserInDatabaseListener = new QuitAndSaveUserInDatabaseListener(this.plugin);
        executeCommandAndSaveInDatabaseListener = new ExecuteCommandAndSaveInDatabaseListener(this.plugin);
        writeAndSaveInDatabaseListener = new WriteAndSaveInDatabaseListener(this.plugin);
    }

    public void deleteOldLogs() {
        Calendar now = new GregorianCalendar();
        Calendar next = new GregorianCalendar();
        next.set(Calendar.MILLISECOND, 0);
        next.set(Calendar.SECOND, 0);
        next.set(Calendar.HOUR_OF_DAY, 4);
        next.set(Calendar.MINUTE, 0);
        if (now.after(next)) {
            next.add(Calendar.DATE, 1);
        }
        if (now.before(next)) {
            long ticks = (next.getTimeInMillis() - now.getTimeInMillis()) / 1000 * 20;
            Bukkit.getScheduler().runTaskTimer(this.plugin, () ->
                    getAdminGuiDatabase().deleteAllOldLogs(30, now.getTimeInMillis()), ticks, 24 * 60 * 60 * 20);
        }
    }
}
