package watchtowergui.wg.logs.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class LogsYmlGenerator {

    public static final Integer COMMANDS_LOGS = 0;
    public static final Integer CHAT_LOGS = 1;
    public static final Integer JOIN_LOGS = 2;
    public static final Integer QUIT_LOGS = 3;
    public static List<String> commandsLogList;
    public static List<String> chatLogList;
    public static List<String> joinLogList;
    public static List<String> quitLogsList;
    public LanguageConfig languageConfig;
    private File folder;

    public void sendTypedMessageToSender(CommandSender sender, String string) {
        sender.sendMessage(string);
    }

    public synchronized void taskFinished(CommandSender sender) {
        sendTypedMessageToSender(sender, languageConfig.getLogsSuccessfullyDownloaded());
    }

    public void init() {
        WatchTowerGui plugin = WatchTowerGui.getInstance();
        this.folder = new File(plugin.getDataFolder() + "/logs");
        this.languageConfig = plugin.configsManager.languageConfig;
    }

    private void deleteFiles() {
        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
            makeLogsFolderIfNotExists();
        }
    }

    public void generateFile(List<List<String>> logs) {
        deleteFiles();
        makeLogsFolderIfNotExists();
        commandsLogList = logs.get(COMMANDS_LOGS);
        chatLogList = logs.get(CHAT_LOGS);
        joinLogList = logs.get(JOIN_LOGS);
        quitLogsList = logs.get(QUIT_LOGS);
        if (commandsLogList.isEmpty() && chatLogList.isEmpty() && joinLogList.isEmpty() && quitLogsList.isEmpty()) {
            generateYmlWithNoLogs("No_Logs_Found");
            return;
        }
        if (!commandsLogList.isEmpty()) {
            generateYmlForLog3Args(commandsLogList, "Commands_Logs");
        }
        if (!chatLogList.isEmpty()) {
            generateYmlForLog3Args(chatLogList, "Chat_Logs");
        }
        if (!joinLogList.isEmpty()) {
            generateYmlForLog2Args(joinLogList, "Join_Logs");
        }
        if (!quitLogsList.isEmpty()) {
            generateYmlForLog2Args(quitLogsList, "Quit_Logs");
        }

    }

    private boolean makeLogsFolderIfNotExists() {
        if (!folder.exists()) {
            return folder.mkdir();
        }
        return true;
    }


    private String replaceAllSpacesWithBottoms(String string) {
        return string.replaceAll("\\s", "  ");
    }

    private String reduceAndFormatDateStringFor3Args(String date) {
        String formatted = date.substring(0, date.indexOf("."));
        return formatted + "--";
    }

    private YamlConfiguration makeFileIfNotExist(File file) {
        YamlConfiguration yml = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
                yml = YamlConfiguration.loadConfiguration(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return yml;
    }

    private File initConfig(String filename) {
        return new File(folder, filename + ".yml");
    }

    private void generateYmlWithNoLogs(String configName) {
        File file = initConfig(configName);
        YamlConfiguration yml = makeFileIfNotExist(file);
        yml.addDefault("!Warning.noLogsFound", "If you see that, maybe your input date is too old or too new, or doesn't exists in sql database");
        saveConfig(file, yml);
    }

    private String getPlayerNameFromUUID(String uuid) {
        try {
            return Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
        } catch (IllegalArgumentException e) {
            return "Server console";
        }
    }

    private void generateYmlForLog3Args(List<String> logs, String configName) {
        File file = initConfig(configName);
        YamlConfiguration yml = makeFileIfNotExist(file);
        for (int i = 0; i < logs.size(); i += 3) {
            String uuid = replaceAllSpacesWithBottoms(logs.get(i));
            String date = replaceAllSpacesWithBottoms(logs.get(i + 1));
            yml.addDefault(getPlayerNameFromUUID(uuid) + "." + reduceAndFormatDateStringFor3Args(date), logs.get(i + 2));

        }
        saveConfig(file, yml);
    }

    private void generateYmlForLog2Args(List<String> logs, String configName) {
        File file = initConfig(configName);
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        for (int i = 0; i < logs.size(); i += 2) {
            String uuid = replaceAllSpacesWithBottoms(logs.get(i));
            String date = replaceAllSpacesWithBottoms(logs.get(i + 1));
            yml.addDefault(date.substring(0, date.indexOf(".")) + "--", getPlayerNameFromUUID(uuid));
        }
        saveConfig(file, yml);
    }

    private void saveConfig(File file, YamlConfiguration yml) {
        save(file, yml);
    }

    public boolean save(File file, YamlConfiguration yml) {
        makeLogsFolderIfNotExists();
        makeFileIfNotExist(file);
        try {
            yml.options().copyDefaults(true);
            yml.save(file);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
