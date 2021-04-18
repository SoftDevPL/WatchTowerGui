package watchtowergui.wg.adminfun.commands.controlPlayer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.ControlOFFPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.ControlOnPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.listeners.PlayerControlListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.CommandsManager;

public class ControlPlayerCommand implements CommandExecutor {

    public LanguageConfig languageConfig;
    public PlayerControlListener playerControlListener;

    public ControlPlayerCommand(WatchTowerGui plugin) {
        this.languageConfig = plugin.configsManager.languageConfig;
        this.playerControlListener = plugin.listenersManager.playerControlListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(languageConfig.getBasicOnlyPlayerCanExecuteThisCommand());
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(CommandsManager.getDescription(label, command));
            return true;
        }
        Player playerToControl = Bukkit.getPlayer(args[0]);
        if (playerToControl == null) {
            sender.sendMessage(this.languageConfig.getBasicPlayerNotFound(args[0]));
            return true;
        }
        Player player = (Player) sender;
      if (playerControlListener.getControllingPlayerLocationMap().containsKey(player.getUniqueId())) {
            Bukkit.getServer().getPluginManager().callEvent(new ControlOFFPlayerEvent(player, playerToControl));
        } else {
            Bukkit.getServer().getPluginManager().callEvent(new ControlOnPlayerEvent(player, playerToControl));
        }
        return true;
    }
}
