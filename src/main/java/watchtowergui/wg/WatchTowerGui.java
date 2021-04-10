package watchtowergui.wg;

import watchtowergui.wg.managers.CommandsManager;
import watchtowergui.wg.fileManager.configsutils.ConfigsManager;
import watchtowergui.wg.fileManager.sql.sqlUtils.SQLManager;
import watchtowergui.wg.managers.ListenersManager;
import watchtowergui.wg.managers.Permissions;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import static ad.guis.ultimateguis.ANSIColors.*;

public final class WatchTowerGui extends JavaPlugin {

    public final Logger mesLogger =  Logger.getLogger("");
    private static final Logger log = Logger.getLogger("Minecraft");
    static private WatchTowerGui instance;

    public ListenersManager listenersManager;
    public CommandsManager commandsManager;
    public CommandsControlListener commandsControlListener;
    public ConfigsManager configsManager;
    public SQLManager SQLmanager;
    public Permissions permissions;
    boolean initCorrect = true;

    public static WatchTowerGui getInstance() {
        if (instance == null) {
            log.info(ANSI_RED + "MainClass.java -> Instance not exist" + ANSI_RESET);
        }
        return instance;
    }

    public void createClasses() {
        permissions = new Permissions();
        listenersManager = new ListenersManager();
        commandsManager = new CommandsManager();
        configsManager = new ConfigsManager();
        SQLmanager = new SQLManager();
        commandsControlListener = new CommandsControlListener();
    }

    public void initClasses() {
        configsManager.init();
        SQLmanager.init();
        listenersManager.init();
        commandsManager.init();
        commandsControlListener.init();
    }

    public void initAll() {
        if (setupApis()) {
            createClasses();
            initClasses();
            setupLoggerOnEnable();
            initCorrect = true;
        } else {
            initCorrect = false;
            commandsControlListener = new CommandsControlListener();
            commandsControlListener.init();
            commandsControlListener.removeCommandsByPlugin(this);
            commandsControlListener = null;
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onEnable() {
        instance = this;
        initAll();
    }

    @Override
    public void onDisable() {
        if (instance == this) instance = null;
        if (initCorrect) {
            listenersManager.disable();
        }
        setupLoggerOnDisable();
    }

    private String getMinecraftVersion(Server server) {
        String version = server.getVersion();
        int start = version.indexOf("MC: ") + 4;
        int end = version.length() - 1;
        return version.substring(start, end);
    }

    private String getPluginVersion() {
        PluginDescriptionFile pdf = this.getDescription();
        return pdf.getVersion();
    }

    public static String convertColors(String st) {
        return ChatColor.translateAlternateColorCodes('&', st);
    }

    private void setupLoggerOnEnable() {
        mesLogger.info(" ");
        mesLogger.info(ANSI_PURPLE + "     I8,        8        ,8I" + ANSI_BRIGHT_PURPLE + "   ,ad8888ba," + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "     `8b       d8b       d8'" + ANSI_BRIGHT_PURPLE + "  d8'    `8b " + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "       8,     ,88,      ,8  " + ANSI_BRIGHT_PURPLE + " d8'         " + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "       Y8     8P Y8     8P  " + ANSI_BRIGHT_PURPLE + " 88          " + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "       `8b   d8' `8b   d8'  " + ANSI_BRIGHT_PURPLE + " 88      88888" + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "        `8a a8'   `8a a8'   " + ANSI_BRIGHT_PURPLE + " Y8,        88" + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "         `8a8'     `8a8'    " + ANSI_BRIGHT_PURPLE + "  Y8a.    .a88" + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "          `8'       `8'     " + ANSI_BRIGHT_PURPLE + "    `Y88888P  " + ANSI_RESET);
        mesLogger.info("");
        mesLogger.info("          WatchTowerGui v" + getPluginVersion());
        mesLogger.info("          Running on Spigot - " + getMinecraftVersion(Bukkit.getServer()));
        mesLogger.info("          Made by DevieTeam");
        mesLogger.info(" ");
        mesLogger.info("          Action: " + ANSI_GREEN +"Plugin Enabled" + ANSI_RESET);
        mesLogger.info(" ");
    }


    private void setupLoggerOnDisable() {
        mesLogger.info(" ");
        mesLogger.info(ANSI_PURPLE + "     I8,        8        ,8I" + ANSI_BRIGHT_PURPLE + "   ,ad8888ba," + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "     `8b       d8b       d8'" + ANSI_BRIGHT_PURPLE + "  d8'    `8b " + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "       8,     ,88,      ,8  " + ANSI_BRIGHT_PURPLE + " d8'         " + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "       Y8     8P Y8     8P  " + ANSI_BRIGHT_PURPLE + " 88         " + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "       `8b   d8' `8b   d8'  " + ANSI_BRIGHT_PURPLE + " 88      88888" + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "        `8a a8'   `8a a8'   " + ANSI_BRIGHT_PURPLE + " Y8,        88" + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "         `8a8'     `8a8'    " + ANSI_BRIGHT_PURPLE + "  Y8a.    .a88" + ANSI_RESET);
        mesLogger.info(ANSI_PURPLE + "          `8'       `8'     " + ANSI_BRIGHT_PURPLE + "    `Y88888P  " + ANSI_RESET);
        mesLogger.info("");
        mesLogger.info("          WatchTowerGui v" + getPluginVersion());
        mesLogger.info("          Running on Spigot - " + getMinecraftVersion(Bukkit.getServer()));
        mesLogger.info("          Made by DevieTeam");
        mesLogger.info(" ");
        mesLogger.info("          Action: " + ANSI_RED +"Disabling...." + ANSI_RESET);
        mesLogger.info(" ");
    }

    private void warnPluginDisableLog() {
        mesLogger.info(ANSI_YELLOW + " !=========================!" + ANSI_RESET);
        mesLogger.info(ANSI_BRIGHT_GREEN + " - UltimateGuis " + ANSI_RED + "not found!" + ANSI_RESET);
        mesLogger.info(" - To enable your plugin you ");
        mesLogger.info(" - need to fulfill requirements");
        mesLogger.info(ANSI_BRIGHT_CYAN + " - DOWNLOAD => " + ANSI_BRIGHT_GREEN + "UltimateGuis!" + ANSI_RESET);
        mesLogger.info(ANSI_YELLOW + " !=========================!" + ANSI_RESET);
    }


    private boolean setupApis() {
        log.info("");
        logUltimateGuisFound();
        return !setupUltimateGuisApi();
    }

    private void logUltimateGuisFound() {
        try {
            Class.forName("ad.guis.ultimateguis");
        } catch (ClassNotFoundException e) {
            if (!setupUltimateGuisApi()) {
                mesLogger.info(ANSI_BRIGHT_YELLOW + "UltimateGuis " + ANSI_WHITE + "hooked into AdminGui!" + ANSI_RESET);
            } else {
                warnPluginDisableLog();
                log.info("");
            }

        }

    }
    private boolean setupUltimateGuisApi() {
        return getServer().getPluginManager().getPlugin("UltimateGuis") == null;
    }
}
