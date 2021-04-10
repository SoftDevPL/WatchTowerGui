package watchtowergui.wg.logs.commands;

import ad.guis.ultimateguis.UltimateGuis;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import watchtowergui.wg.logs.guis.LogsGui;
import watchtowergui.wg.logs.utils.ConsoleChatListener;
import watchtowergui.wg.logs.utils.LogsYmlGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GetLogsFromDayAndUUID implements CommandExecutor {

    private final WatchTowerGui plugin;
    private final ConsoleChatListener consoleChatListener;
    public AdminGuiDatabase adminGuiDatabase;
    public LogsYmlGenerator logsYmlGenerator;
    public LanguageConfig languageConfig;

    public GetLogsFromDayAndUUID(WatchTowerGui plugin) {
        this.plugin = plugin;
        this.consoleChatListener = this.plugin.listenersManager.consoleChatListener;
        this.logsYmlGenerator = this.plugin.configsManager.logsYmlGenerator;
        this.languageConfig = this.plugin.configsManager.languageConfig;
        this.adminGuiDatabase = this.plugin.SQLmanager.database;
    }

    private List<List<String>> getFromDatabase(String playerName, AdminGuiDatabase database, String StringDate, CommandSender sender) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(StringDate);
        } catch (ParseException e) {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDayAndUUID());
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
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsEnterMessageForDayAndUUID());
            consoleChatListener.setTask(sender, (chatMessage, chatSender) -> {
                List<String> dates = getDatesFromString(chatMessage);
                OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(dates.get(0));
                if (dates.size() < 2) {
                    logsYmlGenerator.sendTypedMessageToSender(chatSender, languageConfig.getLogsEnterMessageForDayAndUUID());
                    return true;
                }
                if (playerToBan == null) {
                    logsYmlGenerator.sendTypedMessageToSender(chatSender, languageConfig.getLogsPlayerNotExists(dates.get(0)));
                    return true;
                }
                if (dates.size() == 2) {
                    Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                            () -> {
                                sender.sendMessage(languageConfig.getLogsGettingLogs());
                                generateFilesWithLogs(getFromDatabase(
                                        dates.get(0),
                                        adminGuiDatabase,
                                        dates.get(1) + " 00:00:00",
                                        sender));
                                logsYmlGenerator.taskFinished(sender);
                            });
                } else {
                    logsYmlGenerator.sendTypedMessageToSender(chatSender, languageConfig.getLogsWrongMessageForDayAndUUID());
                }
                return true;
            });
        }
    }

    private List<String> getDatesFromString(String chatMessage) {
        return new ArrayList<>(Arrays.asList(chatMessage.split(" ")));
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            changeActionForPlayerNull(sender);
        } else {
            if (args.length == 2) {
                OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(args[0]);
                if (playerToBan == null) {
                    logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsPlayerNotExists(args[0]));
                    return true;
                }
                Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                        () -> {
                            sender.sendMessage(languageConfig.getLogsGettingLogs());
                            generateFilesWithLogs(getFromDatabase(
                                    args[0],
                                    adminGuiDatabase,
                                    args[1] + " 00:00:00",
                                    sender));
                            logsYmlGenerator.taskFinished(sender);
                        });
            } else {
                logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDayAndUUID());
            }
        }
        return true;
    }
}
