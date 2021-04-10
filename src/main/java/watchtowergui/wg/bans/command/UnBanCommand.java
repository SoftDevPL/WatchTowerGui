package watchtowergui.wg.bans.command;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.event.PlayerRemoveTempBanEvent;
import watchtowergui.wg.bans.guis.ActiveTempBansGui;
import watchtowergui.wg.bans.listeners.TempBanListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class UnBanCommand implements CommandExecutor, TabCompleter {

    private final WatchTowerGui watchTowerGui;
    private final LanguageConfig languageConfig;
    private final TempBanListener tempBanListener;

    public UnBanCommand(PluginCommand command) {
        this.watchTowerGui = WatchTowerGui.getInstance();
        command.setExecutor(this);
        command.setTabCompleter(this);
        this.languageConfig = this.watchTowerGui.configsManager.languageConfig;
        tempBanListener = this.watchTowerGui.listenersManager.tempBanListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1) {
            OfflinePlayer offlinePlayer = UltimateGuis.getOfflinePlayer(args[0]);
            if (offlinePlayer == null) {
                sender.sendMessage(languageConfig.getPlayerToUnbanNotExists(args[0]));
                return true;
            }
            if (!this.watchTowerGui.listenersManager.tempBanListener.isPlayerBanned(offlinePlayer.getUniqueId())) {
                sender.sendMessage(languageConfig.getThisPlayerIsNotBanned());
                return true;
            }
            sender.sendMessage(languageConfig.getUnBannedPlayer(args[0]));
            Bukkit.getPluginManager().callEvent(new PlayerRemoveTempBanEvent(offlinePlayer, sender));
        } else {
            new ActiveTempBansGui(null).open((Player) sender);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return CommandsManager.mergeTabCompleter(this.tempBanListener.getBanDataList().stream()
                .map(data -> Bukkit.getOfflinePlayer(data.getBannedPlayer()).getName())
                .collect(Collectors.toList()), args[0]);
    }
}
