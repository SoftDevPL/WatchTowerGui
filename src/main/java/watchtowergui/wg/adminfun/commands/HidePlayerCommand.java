package watchtowergui.wg.adminfun.commands;

import ad.guis.ultimateguis.UltimateGuis;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.PlayerHideEvent;
import watchtowergui.wg.adminfun.events.PlayerUnHideEvent;
import watchtowergui.wg.adminfun.listeners.HidingPlayerListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;

public class HidePlayerCommand implements CommandExecutor {
    private final LanguageConfig languageConfig;
    private final HidingPlayerListener hidingPlayerListener;

    public HidePlayerCommand(WatchTowerGui plugin) {
        this.languageConfig = plugin.configsManager.languageConfig;
        this.hidingPlayerListener = plugin.listenersManager.hidingPlayerListener;
    }

    private void callHideEvent(Player player, CommandSender sender) {
        if (!hidingPlayerListener.isHidden(player.getUniqueId())) {
            Bukkit.getPluginManager().callEvent(new PlayerHideEvent(player, sender));
        } else {
            Bukkit.getPluginManager().callEvent(new PlayerUnHideEvent(player, sender));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;
            callHideEvent(player, sender);
            return true;
        }
        String playerName = args[0];
        OfflinePlayer player = UltimateGuis.getOfflinePlayer(playerName);
        if (player == null) {
            sender.sendMessage(languageConfig.getCommandsLocale_basic_playerNotFoundWithPlayerName(playerName));
            return true;
        }
        callHideEvent((Player) player, sender);
//        sender.sendMessage(languageConfig.getBasicOnlyPlayerCanExecuteThisCommand());
        return true;
    }
}
