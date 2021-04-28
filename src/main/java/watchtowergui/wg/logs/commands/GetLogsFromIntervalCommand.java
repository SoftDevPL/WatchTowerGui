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

public class GetLogsFromIntervalCommand implements CommandExecutor {

    private final WatchTowerGui plugin;
    private final ConsoleChatListener consoleChatListener;
    public Database database;
    public LogsYmlGenerator logsYmlGenerator;
    public LanguageConfig languageConfig;

    public GetLogsFromIntervalCommand(WatchTowerGui plugin) {
        this.plugin = plugin;
        this.consoleChatListener = this.plugin.listenersManager.consoleChatListener;
        this.logsYmlGenerator = this.plugin.configsManager.logsYmlGenerator;
        this.languageConfig = this.plugin.configsManager.languageConfig;
        this.database = this.plugin.SQLmanager.database;
    }

    private void changeActionForPlayerNull(CommandSender sender) {
        if (sender instanceof Player) {
            LogsGui.logsManyDays(null).open((Player) sender);
        } else {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsEnterMessageForDate());
            consoleChatListener.setTask(sender, (chatMessage, chatSender) -> {
                List<String> dates = getDatesFromString(chatMessage);
                if (dates.size() == 4) {
                    BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getLogsGettingLogs(), sender, this.plugin);
                    Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                            () -> {
                                generateFilesWithLogs(getFromDatabase(
                                        database,
                                        dates.get(0) + " " + dates.get(1),
                                        dates.get(2) + " " + dates.get(3),
                                        sender));
                                logsYmlGenerator.taskFinished(sender, task);
                            });
                } else {
                    logsYmlGenerator.sendTypedMessageToSender(chatSender, languageConfig.getLogsWrongMessageForDate());
                }
                return true;
            });
        }
    }

    private void generateFilesWithLogs(List<List<String>> logs) {
        this.logsYmlGenerator.generateFile(logs);
    }

    private List<String> getDatesFromString(String chatMessage) {
        return new ArrayList<>(Arrays.asList(chatMessage.split(" ")));
    }

    private List<List<String>> getFromDatabase(Database database, String stringFirstDate, String stringSecondDate, CommandSender sender) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(stringFirstDate);
            date2 = sdf.parse(stringSecondDate);
        } catch (ParseException e) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDate());
            e.printStackTrace();
        }
        assert date1 != null;
        assert date2 != null;
        long firstMillis = date1.getTime();
        long secondMillis = date2.getTime();
        return database.getLogsByDate(firstMillis, secondMillis);
    }

    private boolean checkDate(String date1, String date2) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date1 + " " + date2);
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
        if (args.length == 4 && checkDate(args[0], args[1]) && checkDate(args[2], args[3])) {
            BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getLogsGettingLogs(), sender, this.plugin);
            Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                    () -> {
                        generateFilesWithLogs(getFromDatabase(
                                database,
                                args[0] + " " + args[1],
                                args[2] + " " + args[3],
                                sender));
                        logsYmlGenerator.taskFinished(sender, task);
                    });
        } else {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDate());
        }
        return true;
    }
}
