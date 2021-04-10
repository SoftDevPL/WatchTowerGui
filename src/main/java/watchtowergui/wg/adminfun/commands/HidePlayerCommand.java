package watchtowergui.wg.adminfun.commands;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.PlayerHideEvent;
import watchtowergui.wg.adminfun.events.PlayerUnHideEvent;
import watchtowergui.wg.adminfun.listeners.HiddingPlayerListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HidePlayerCommand implements CommandExecutor {
    private final LanguageConfig languageConfig;
    private final HiddingPlayerListener hiddingPlayerListener;

    public HidePlayerCommand(WatchTowerGui plugin) {
        this.languageConfig = plugin.configsManager.languageConfig;
        this.hiddingPlayerListener = plugin.listenersManager.hiddingPlayerListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;
            if (!hiddingPlayerListener.isHidden(player.getUniqueId())) {
                Bukkit.getPluginManager().callEvent(new PlayerHideEvent(player, sender));
            } else {
                Bukkit.getPluginManager().callEvent(new PlayerUnHideEvent(player, sender));
            }
            return true;
        } else if (args.length >= 1) {
            String playerName = args[0];
            OfflinePlayer player = UltimateGuis.getOfflinePlayer(playerName);
            if (player == null) {
                sender.sendMessage(languageConfig.getMesPlayerNotFound(playerName));
                return true;
            }
            if (!hiddingPlayerListener.isHidden(player.getUniqueId())) {
                Bukkit.getPluginManager().callEvent(new PlayerHideEvent(player, sender));
            } else {
                Bukkit.getPluginManager().callEvent(new PlayerUnHideEvent(player, sender));
            }
            return true;
        } else {
            sender.sendMessage(languageConfig.getOnlyPlayerCanExecuteCommand());
        }
        return true;
    }
}
