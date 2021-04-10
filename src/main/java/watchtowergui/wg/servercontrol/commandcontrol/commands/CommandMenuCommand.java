package watchtowergui.wg.servercontrol.commandcontrol.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;
import watchtowergui.wg.servercontrol.commandcontrol.guis.CommandsControlGui;
import watchtowergui.wg.servercontrol.commandcontrol.guis.SingleCommandGui;

import java.util.ArrayList;
import java.util.List;

public class CommandMenuCommand implements CommandExecutor, TabCompleter {

    private final CommandsControlListener commandsControlListener;
    private final LanguageConfig lg;
    private final GuiLanguageConfig glc;

    public CommandMenuCommand(PluginCommand command) {
        command.setExecutor(this);
        command.setExecutor(this);
        commandsControlListener = WatchTowerGui.getInstance().commandsControlListener;
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        lg = WatchTowerGui.getInstance().configsManager.languageConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(lg.getOnlyPlayerCanExecuteCommand());
            return true;
        }
        if (args.length == 0) {
            new CommandsControlGui(glc.getCommandMenuPageName()).open(((Player) sender));
            return true;
        }
        Command cmd = getCommand(args[0]);
        if (cmd == null) {
            sender.sendMessage(lg.getCommandMenuCommandNotFound());
            return true;
        }
        new SingleCommandGui(cmd, null).open(((Player) sender));
        return true;
    }

    public Command getCommand(String label) {
        return this.commandsControlListener.getActiveCommand(label);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length != 1) return new ArrayList<>(0);
        return CommandsManager.mergeTabCompleter(new ArrayList<>(
                this.commandsControlListener.getActiveLabels()), args[0]);
    }
}
