package watchtowergui.wg.servercontrol.plugincontrol.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
import watchtowergui.wg.servercontrol.plugincontrol.guis.PluginControlGui;
import watchtowergui.wg.servercontrol.plugincontrol.guis.SinglePluginGui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PluginMenuCommand implements CommandExecutor, TabCompleter {
    private final LanguageConfig languageConfig;

    public PluginMenuCommand(PluginCommand command) {
        languageConfig = WatchTowerGui.getInstance().configsManager.languageConfig;
        command.setTabCompleter(this);
        command.setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(languageConfig.getBasicOnlyPlayerCanExecuteThisCommand());
            return true;
        }
        if (args.length <= 0) {
            //TODO
            new PluginControlGui(null, "Manage Plugins").open((Player) sender);
            return true;
        }
        Plugin plugin;
        List<Plugin> pluginList = findPluginIgnoreCase(args[0]);
        if (pluginList.isEmpty()) {
            sender.sendMessage(languageConfig.getPluginMenuNotExists());
            return true;
        } else if (pluginList.size() == 1) {
            plugin = pluginList.get(0);
        } else {
            plugin = findPlugin(args[0]);
        }

        if (plugin == null) {
            plugin = pluginList.get(0);
        }
        new SinglePluginGui(plugin, null).open((Player) sender);
        return true;
    }

    private Plugin findPlugin(final String name) {
        return Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .filter(plg -> plg.getName().equals(name)).findAny().orElse(null);
    }

    private List<Plugin> findPluginIgnoreCase(final String name) {
        return Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .filter(plg -> plg.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return CommandsManager.mergeTabCompleter(Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .map(Plugin::getName).collect(Collectors.toList()), args[0]);
    }
}
