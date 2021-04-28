package watchtowergui.wg.logs.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import watchtowergui.wg.logs.guis.LogsGui;
import watchtowergui.wg.logs.utils.ConsoleChatListener;
import watchtowergui.wg.logs.utils.LogsYmlGenerator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GetLogsFromDay implements CommandExecutor {

    private final WatchTowerGui plugin;
    private final ConsoleChatListener consoleChatListener;
    public Database database;
    public LogsYmlGenerator logsYmlGenerator;
    public LanguageConfig languageConfig;

    public GetLogsFromDay(WatchTowerGui plugin) {
        this.plugin = plugin;
        this.consoleChatListener = this.plugin.listenersManager.consoleChatListener;
        this.logsYmlGenerator = this.plugin.configsManager.logsYmlGenerator;
        this.languageConfig = this.plugin.configsManager.languageConfig;
        this.database = this.plugin.SQLmanager.database;
    }

    private List<List<String>> getFromDatabase(Database database, String StringDate, CommandSender sender) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(StringDate);
        } catch (ParseException e) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDay());
            e.printStackTrace();
        }
        assert date != null;
        long millis = date.getTime();
        return database.getLogsByDay(millis);
    }

    private void generateFilesWithLogs(List<List<String>> logs) {
        this.logsYmlGenerator.generateFile(logs);
    }

    private void changeActionForPlayerNull(CommandSender sender) {
        if (sender instanceof Player) {
            LogsGui.logsOneDay(null).open((Player) sender);
        } else {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsEnterMessageForDay());
            consoleChatListener.setTask(sender, (chatMessage, chatSender) -> {
                List<String> dates = getDatesFromString(chatMessage);
                if (dates.size() == 1) {
                    BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getLogsGettingLogs(), sender, this.plugin);
                    Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                            () -> {
                                generateFilesWithLogs(getFromDatabase(
                                        database,
                                        dates.get(0) + " 00:00:00",
                                        sender));
                                logsYmlGenerator.taskFinished(sender, task);
                            });
                } else {
                    logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDay());
                }
                return true;
            });
        }
    }

    private List<String> getDatesFromString(String chatMessage) {
        return new ArrayList<>(Arrays.asList(chatMessage.split(" ")));
    }

    private boolean checkDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            changeActionForPlayerNull(sender);
            return true;
        }
        if (!checkDate(args[0])) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDay());
            return true;
        }
        BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getLogsGettingLogs(), sender, this.plugin);
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                () -> {
                    generateFilesWithLogs(getFromDatabase(
                            database,
                            args[0] + " 00:00:00",
                            sender));
                    logsYmlGenerator.taskFinished(sender, task);
                });
        return true;
    }
}
