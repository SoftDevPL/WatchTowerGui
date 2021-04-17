package watchtowergui.wg.adminfun.commands.controlPlayer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.SpectateOFFPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.events.SpectateOnPlayerEvent;
import watchtowergui.wg.adminfun.commands.controlPlayer.listeners.PlayerControlListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.CommandsManager;

public class SpectatePlayerCommand implements CommandExecutor {

    public LanguageConfig languageConfig;
    public PlayerControlListener playerControlListener;

    public SpectatePlayerCommand(WatchTowerGui plugin) {
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
        Player playerToWatch = Bukkit.getPlayer(args[0]);
        if (playerToWatch == null) {
            sender.sendMessage(this.languageConfig.getBasicPlayerNotFound(args[0]));
            return true;
        }
        Player player = (Player) sender;
        if (playerControlListener.getSpectatingPlayerLocationMap().containsKey(player.getUniqueId())) {
            Bukkit.getServer().getPluginManager().callEvent(new SpectateOFFPlayerEvent(player, playerToWatch));
        } else {
            Bukkit.getServer().getPluginManager().callEvent(new SpectateOnPlayerEvent(player, playerToWatch));
        }
        return true;
    }
}
