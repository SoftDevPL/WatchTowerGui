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

public class GetLogsFromDayAndUUID implements CommandExecutor {

    private final WatchTowerGui plugin;
    private final ConsoleChatListener consoleChatListener;
    public Database database;
    public LogsYmlGenerator logsYmlGenerator;
    public LanguageConfig languageConfig;

    public GetLogsFromDayAndUUID(WatchTowerGui plugin) {
        this.plugin = plugin;
        this.consoleChatListener = this.plugin.listenersManager.consoleChatListener;
        this.logsYmlGenerator = this.plugin.configsManager.logsYmlGenerator;
        this.languageConfig = this.plugin.configsManager.languageConfig;
        this.database = this.plugin.SQLmanager.database;
    }

    private List<List<String>> getFromDatabase(String playerName, Database database, String StringDate, CommandSender sender) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(StringDate);
        } catch (ParseException e) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_logs_logsWrongMessageForDayAndUUID());
            e.printStackTrace();
        }
        assert date != null;
        long millis = date.getTime();
        OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(playerName);
        return database.getLogsByUuidAndDay(playerToBan.getUniqueId().toString(), millis);
    }

    private void generateFilesWithLogs(List<List<String>> logs) {
        this.logsYmlGenerator.generateFile(logs);
    }

    private void changeActionForPlayerNull(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            LogsGui.logsOneDayForPlayer(player.getName(), null).open(player);
        } else {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_logs_logsEnterMessageForDayAndUUID());
            consoleChatListener.setTask(sender, (chatMessage, chatSender) -> {
                List<String> dates = getDatesFromString(chatMessage);
                OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(dates.get(0));
                if (dates.size() < 2) {
                    logsYmlGenerator.sendTypedMessageToSender(chatSender, languageConfig.getCommandsLocale_logs_logsEnterMessageForDayAndUUID());
                    return true;
                }
                if (playerToBan == null) {
                    logsYmlGenerator.sendTypedMessageToSender(chatSender, languageConfig.getCommandsLocale_basic_playerNotFoundWithPlayerName(dates.get(0)));
                    return true;
                }
                if (dates.size() == 2) {
                    BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getCommandsLocale_logs_logsGettingLogs(), sender, this.plugin);
                    Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                            () -> {
                                generateFilesWithLogs(getFromDatabase(
                                        dates.get(0),
                                        database,
                                        dates.get(1) + " 00:00:00",
                                        sender));
                                logsYmlGenerator.taskFinished(sender, task);
                            });
                } else {
                    logsYmlGenerator.sendTypedMessageToSender(chatSender, languageConfig.getCommandsLocale_logs_logsWrongMessageForDayAndUUID());
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
        OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(args[0]);
        if (playerToBan == null) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_basic_playerNotFoundWithPlayerName(args[0]));
            return true;
        }
        if (args.length == 1) {
            changeActionForPlayerNull((CommandSender) playerToBan);
            return true;
        }
        if (!checkDate(args[1])) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getCommandsLocale_logs_logsWrongMessageForDayAndUUID());
            return true;
        }
        BukkitTask task = logsYmlGenerator.displayCurrentSec(languageConfig.getCommandsLocale_logs_logsGettingLogs(), sender, this.plugin);
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                () -> {
                    generateFilesWithLogs(getFromDatabase(
                            args[0],
                            database,
                            args[1] + " 00:00:00",
                            sender));
                    logsYmlGenerator.taskFinished(sender, task);
                });
        return true;
    }
}
