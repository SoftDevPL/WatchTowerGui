package watchtowergui.wg.adminfun.commands;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.listeners.FreezeListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {
    private final FreezeListener freezeListener;
    private final LanguageConfig languageConfig;

    public Freeze(WatchTowerGui plugin) {
        this.freezeListener = plugin.listenersManager.freezeListener;
        this.languageConfig = plugin.configsManager.languageConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            OfflinePlayer playerToFreeze;
            if ((playerToFreeze = Bukkit.getPlayer(args[0])) == null) {
                playerToFreeze = UltimateGuis.getOfflinePlayer(args[0]);
            }
            if (playerToFreeze == null) {
                sender.sendMessage(this.languageConfig.getBasicPlayerNotFound(args[0]));
                return true;
            }
            if (freezeListener.isFrozen(playerToFreeze)) {
                freezeListener.removePlayer(playerToFreeze);
                if (playerToFreeze instanceof Player)
                    ((Player) playerToFreeze).sendMessage(this.languageConfig.getMesToReleasedPlayer(sender.getName()));
                sender.sendMessage(this.languageConfig.getMesToReleaser(playerToFreeze.getName()));
            } else {
                freezeListener.addPlayer(playerToFreeze);
                if (playerToFreeze instanceof Player)
                    ((Player) playerToFreeze).sendMessage(this.languageConfig.getMesToFrozenPlayer(sender.getName()));
                else
                    sender.sendMessage(this.languageConfig.getMesPlayerOffline(playerToFreeze.getName()));
                sender.sendMessage(this.languageConfig.getMesToFreezener(playerToFreeze.getName()));
            }
            return true;
        }
        sender.sendMessage(CommandsManager.getDescription(label, command));
        return true;
    }
}
