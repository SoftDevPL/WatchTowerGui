package watchtowergui.wg.logs.commands;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import watchtowergui.wg.logs.guis.LogsGui;
import watchtowergui.wg.logs.utils.ConsoleChatListener;
import watchtowergui.wg.logs.utils.LogsYmlGenerator;
import watchtowergui.wg.managers.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GetLogsFromIntervalCommand implements CommandExecutor {

    private final WatchTowerGui plugin;
    private final ConsoleChatListener consoleChatListener;
    public AdminGuiDatabase adminGuiDatabase;
    public Permissions permissions;
    public LogsYmlGenerator logsYmlGenerator;
    public LanguageConfig languageConfig;

    public GetLogsFromIntervalCommand(WatchTowerGui plugin) {
        this.plugin = plugin;
        this.consoleChatListener = this.plugin.listenersManager.consoleChatListener;
        this.logsYmlGenerator = this.plugin.configsManager.logsYmlGenerator;
        this.languageConfig = this.plugin.configsManager.languageConfig;
        this.adminGuiDatabase = this.plugin.SQLmanager.database;
        this.permissions = this.plugin.permissions;
    }

    private void changeActionForPlayerNull(CommandSender sender) {
        if (sender instanceof Player) {
            LogsGui.logsManyDays(null).open((Player) sender);
        } else {
            logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsEnterMessageForDate());
            consoleChatListener.setTask(sender, (chatMessage, chatSender) -> {
                List<String> dates = getDatesFromString(chatMessage);
                if (dates.size() == 4) {
                    Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                            () -> {
                                sender.sendMessage(languageConfig.getLogsGettingLogs());
                                generateFilesWithLogs(getFromDatabase(
                                        adminGuiDatabase,
                                        dates.get(0) + " " + dates.get(1),
                                        dates.get(2) + " " + dates.get(3),
                                        sender));
                                logsYmlGenerator.taskFinished(sender);
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

    private List<List<String>> getFromDatabase(AdminGuiDatabase database, String stringFirstDate, String stringSecondDate, CommandSender sender) {
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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            changeActionForPlayerNull(sender);
        } else {
            if (args.length == 4) {
                Bukkit.getScheduler().runTaskAsynchronously(this.plugin,
                        () -> {
                            sender.sendMessage(languageConfig.getLogsGettingLogs());
                            generateFilesWithLogs(getFromDatabase(
                                    adminGuiDatabase,
                                    args[0] + " " + args[1],
                                    args[2] + " " + args[3],
                                    sender));
                            logsYmlGenerator.taskFinished(sender);
                        });
            } else {
                logsYmlGenerator.sendTypedMessageToSender(sender, languageConfig.getLogsWrongMessageForDate());
            }
        }
        return true;
    }
}
