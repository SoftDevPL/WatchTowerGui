package watchtowergui.wg.servercontrol.commandcontrol.commands;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResetAllCommandsCommand implements CommandExecutor, TabCompleter {
    public final static String APPLY_PHRASE = "yes";
    private final LanguageConfig lg;
    private final CommandsControlListener commandsControlListener;

    public ResetAllCommandsCommand() {
        this.lg = WatchTowerGui.getInstance().configsManager.languageConfig;
        this.commandsControlListener = WatchTowerGui.getInstance().commandsControlListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase(APPLY_PHRASE)) {
            sender.sendMessage(lg.getCommandMenuResetAllCommandsWarning(label));
        } else {
            this.commandsControlListener.resetAllCommands();
            sender.sendMessage(lg.getCommandMenuCommandsHasBeenReset());
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length != 1) return new ArrayList<>(0);
        return Collections.singletonList(APPLY_PHRASE);
    }
}
