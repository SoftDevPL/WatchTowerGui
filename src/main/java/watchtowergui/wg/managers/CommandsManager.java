package watchtowergui.wg.managers;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.commands.*;
import watchtowergui.wg.adminfun.commands.sudo.SudoCommand;
import watchtowergui.wg.bans.command.BanCommand;
import watchtowergui.wg.bans.command.UnBanCommand;
import watchtowergui.wg.chat.ClearChatCommand;
import watchtowergui.wg.chat.mute.commands.MuteCommand;
import watchtowergui.wg.chat.mute.commands.UnMuteCommand;
import watchtowergui.wg.logs.commands.GetLogsFromDay;
import watchtowergui.wg.logs.commands.GetLogsFromDayAndUUID;
import watchtowergui.wg.logs.commands.GetLogsFromIntervalCommand;
import watchtowergui.wg.logs.commands.GetLogsFromIntervalCommandAndUUID;
import watchtowergui.wg.servercontrol.commandcontrol.commands.CommandMenuCommand;
import watchtowergui.wg.servercontrol.commandcontrol.commands.ResetAllCommandsCommand;
import watchtowergui.wg.servercontrol.commandcontrol.utilities.CommandIdentifier;
import watchtowergui.wg.servercontrol.plugincontrol.commands.PluginMenuCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandsManager {

    public static List<String> mergeTabCompleter(List<String> currentTabCompleter, String[] arg, int nr) {
        if (nr >= arg.length) return new ArrayList<>(currentTabCompleter);
        else return mergeTabCompleter(currentTabCompleter, arg[nr]);
    }

    public static String getDescription(String label, Command command) {
        String[] strings = command.getUsage().split(" ", 2);
        String usage = strings.length < 2 ? "" : " " + command.getUsage().split(" ", 2)[1];
        return ChatColor.GREEN + "" + ChatColor.BOLD + "Use" + ChatColor.GRAY + " => " + ChatColor.GREEN + "" + ChatColor.BOLD + "/" + label + ChatColor.GRAY + usage;
    }

    public static List<String> mergeTabCompleter(List<String> currentTabCompleter, String arg) {
        final String lowArg = arg.toLowerCase();
        return currentTabCompleter.stream().filter(s -> s.toLowerCase().indexOf(lowArg) == 0).collect(Collectors.toList());
    }

    public static String getMCCommand(String name) {
        return WatchTowerGui.getInstance().commandsControlListener
                .getCommandLabel(new CommandIdentifier(name, "minecraft"));
    }

    public static String getADCommand(String name) {
        return WatchTowerGui.getInstance().commandsControlListener
                .getMainADCommandLabel(name);
    }

    public static String getAnyCommand(String nameWithPrefix) {
        return WatchTowerGui.getInstance().commandsControlListener.getCommandLabel(nameWithPrefix);
    }

    public void init() {
        WatchTowerGui plugin = WatchTowerGui.getInstance();
        plugin.getCommand("freeze").setExecutor(new Freeze(plugin));
        plugin.getCommand("ad").setExecutor(new AdminCommand(plugin));
        new PlayerMenuCommand(plugin.getCommand("playerMenu"));
        new BanCommand(plugin.getCommand("tmban"));
        new UnBanCommand(plugin.getCommand("tmunban"));
        plugin.getCommand("mute").setExecutor(new MuteCommand(plugin));
        plugin.getCommand("unmute").setExecutor(new UnMuteCommand(plugin));
        plugin.getCommand("hide").setExecutor(new HidePlayerCommand(plugin));
        plugin.getCommand("mmode").setExecutor(new MaintenanceModeCommand(plugin));
        plugin.getCommand("glday").setExecutor(new GetLogsFromDay(plugin));
        plugin.getCommand("gldate").setExecutor(new GetLogsFromIntervalCommand(plugin));
        plugin.getCommand("gluday").setExecutor(new GetLogsFromDayAndUUID(plugin));
        plugin.getCommand("gludate").setExecutor(new GetLogsFromIntervalCommandAndUUID(plugin));
        new CommandMenuCommand(plugin.getCommand("commandmenu"));
        new PluginMenuCommand(plugin.getCommand("pluginmenu"));
        plugin.getCommand("resetallcommands").setExecutor(new ResetAllCommandsCommand());
        new SudoCommand(plugin.getCommand("sudo"));
        new ClearChatCommand(plugin.getCommand("clearchat"));
    }
}
