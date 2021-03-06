package watchtowergui.wg.logs.commands;

import ad.guis.ultimateguis.UltimateGuis;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
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

public class GetLogsFromIntervalCommandAndUUID implements CommandExecutor {

    private final WatchTowerGui plugin;
    private final ConsoleChatListener consoleChatListener;
    public Database database;
    public LogsYmlGenerator logsYmlGenerator;
    public LanguageConfig languageConfig;

    public GetLogsFromIntervalCommandAndUUID(WatchTowerGui plugin) {
        this.plugin = plugin;
        this.consoleChatListener = this.plugin.listenersManager.consoleChatListener;
        this.logsYmlGenerator = this.plugin.configsManager.logsYmlGenerator;
        this.languageConfig = this.plugin.configsManager.languageConfig;
        this.database = this.plugin.SQLmanager.database;
    }

    private void generateFilesWithLogs(List<List<String>> logs) {
        this.logsYmlGenerator.generateFile(logs);
    }

    private void changeActionForPlayerNull(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            LogsGui.logsManyDaysForPlayer(player.getName(), null).open(player);
        } else {
            sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_logs_logsEnterMessageForDateAndUUID());
            consoleChatListener.setTask(sender, (chatMessage, chatSender) -> {
                List<String> dates = getDatesFromString(chatMessage);
                if (dates.size() < 4) {
                    sendTypedMessageToSender(chatSender, languageConfig.getCommandsLocale_logs_logsEnterMessageForDateAndUUID());
                    return true;
                }
                OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(dates.get(0));
                if (playerToBan == null) {
                    sendTypedMessageToSender(chatSender, languageConfig.getCommandsLocale_basic_playerNotFoundWithPlayerName(dates.get(0)));
                    return true;
                }
                if (dates.size() == 5) {
                    BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getCommandsLocale_logs_logsGettingLogs(), sender, this.plugin);
                    Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                            () -> {
                                generateFilesWithLogs(getFromDatabase(
                                        dates.get(0),
                                        database,
                                        dates.get(1) + " " + dates.get(2),
                                        dates.get(3) + " " + dates.get(4),
                                        sender));
                                logsYmlGenerator.taskFinished(sender, task);
                            });
                } else {
                    sendTypedMessageToSender(chatSender, languageConfig.getCommandsLocale_logs_logsWrongMessageForDateAndUUID());
                }
                return false;
            });
        }
    }

    private List<String> getDatesFromString(String chatMessage) {
        return new ArrayList<>(Arrays.asList(chatMessage.split(" ")));

    }

    private List<List<String>> getFromDatabase(String playerName, Database database, String stringFirstDate, String stringSecondDate, CommandSender sender) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(stringFirstDate);
            date2 = sdf.parse(stringSecondDate);
        } catch (ParseException e) {
            sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_logs_logsWrongMessageForDateAndUUID());
            e.printStackTrace();
        }
        assert date1 != null;
        assert date2 != null;
        long firstMillis = date1.getTime();
        long secondMillis = date2.getTime();
        OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(playerName);
        return database.getLogsByUuidAndDate(playerToBan.getUniqueId().toString(), firstMillis, secondMillis);
    }

    private void sendTypedMessageToSender(CommandSender sender, String string) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(string);
        } else {
            Bukkit.broadcastMessage(string);
        }
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
        OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(args[0]);
        if (playerToBan == null) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_basic_playerNotFoundWithPlayerName(args[0]));
            return true;
        }
        if (args.length == 1) {
            changeActionForPlayerNull((CommandSender) playerToBan);
            return true;
        }
        if (args.length == 5 && checkDate(args[1], args[2]) && checkDate(args[3], args[4])) {
            BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getCommandsLocale_logs_logsGettingLogs(), sender, this.plugin);
            Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                    () -> {
                        generateFilesWithLogs(getFromDatabase(
                                args[0],
                                database,
                                args[1] + " " + args[2],
                                args[3] + " " + args[4],
                                sender));
                        logsYmlGenerator.taskFinished(sender, task);
                    });
        } else {
            sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_logs_logsWrongMessageForDateAndUUID());
        }
        return true;
    }
}
