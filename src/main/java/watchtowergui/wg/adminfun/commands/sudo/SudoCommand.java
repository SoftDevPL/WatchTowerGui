package watchtowergui.wg.adminfun.commands.sudo;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.Permissions;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SudoCommand implements CommandExecutor, TabCompleter {
    public final Permissions permissions;
    private final LanguageConfig languageConfig;
    private final CommandsControlListener commandsControlListener;

    public SudoCommand(PluginCommand command) {
        this.languageConfig = WatchTowerGui.getInstance().configsManager.languageConfig;
        this.commandsControlListener = WatchTowerGui.getInstance().commandsControlListener;
        this.permissions = WatchTowerGui.getInstance().permissions;
        command.setExecutor(this);
        command.setTabCompleter(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 2) {
            Player playerToExecute = Bukkit.getPlayer(args[0]);
            if (playerToExecute == null) {
                sender.sendMessage(languageConfig.getCommandsLocale_freeze_messagePlayerOffline(args[0]));
                return true;
            }
            String sudoLabel = args[1];
            String[] sudoArgs = new String[args.length - 2];
            System.arraycopy(args, 2, sudoArgs, 0, sudoArgs.length);
            Bukkit.getPluginManager().callEvent(new SudoEvent(sender, playerToExecute, sudoLabel, sudoArgs));
            return true;
        }
        sender.sendMessage(watchtowergui.wg.manager.CommandsManager.getDescription(label, command));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1)
            return watchtowergui.wg.manager.CommandsManager.mergeTabCompleter(Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName).collect(Collectors.toList()), args[0]);

        Player player = Bukkit.getPlayer(args[0]);
        if (player == null) return new ArrayList<>(0);

        if (args.length == 2) return watchtowergui.wg.manager.CommandsManager.mergeTabCompleter(
                new ArrayList<>(this.commandsControlListener.getActiveLabels()), args[1]);
        else {
            Command cmd = this.commandsControlListener.getActiveCommand(args[1]);
            if (cmd == null) return new ArrayList<>(0);
            return cmd.tabComplete(player, alias, Arrays.copyOfRange(args, 2, args.length));
        }
    }
}
