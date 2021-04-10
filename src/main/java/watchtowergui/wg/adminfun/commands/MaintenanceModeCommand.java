package watchtowergui.wg.adminfun.commands;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.AddPlayerToWhiteListEvent;
import watchtowergui.wg.adminfun.events.RemovePlayerFromWhiteListEvent;
import watchtowergui.wg.adminfun.events.WhiteListOffEvent;
import watchtowergui.wg.adminfun.events.WhiteListOnEvent;
import watchtowergui.wg.adminfun.listeners.WhiteListListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaintenanceModeCommand implements CommandExecutor {

    static boolean isWhitelist = false;
    private final Permissions permissions;
    private final LanguageConfig languageConfig;
    private final WhiteListListener whiteListListener;


    public MaintenanceModeCommand(WatchTowerGui plugin) {
        this.permissions = plugin.permissions;
        this.languageConfig = plugin.configsManager.languageConfig;
        this.whiteListListener = plugin.listenersManager.whiteListListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        isWhitelist = whiteListListener.maintenanceMode;
        if (isWhitelist) {
            sender.sendMessage(languageConfig.getMaintenanceModeOn());
            Bukkit.getPluginManager().callEvent(new WhiteListOffEvent((Player) sender));
        } else {
            sender.sendMessage(languageConfig.getMaintenanceModeOff());
            Bukkit.getPluginManager().callEvent(new WhiteListOnEvent((Player) sender));
        }
        for (Player playerToWhitelist : Bukkit.getOnlinePlayers()) {
            if (playerToWhitelist.hasPermission(permissions.maintenancePerm)) {
                if (!whiteListListener.isPlayerInMainteneceMode(playerToWhitelist)) {
                    Bukkit.getPluginManager().callEvent(new AddPlayerToWhiteListEvent(playerToWhitelist));
                }
            } else {
                Bukkit.getPluginManager().callEvent(new RemovePlayerFromWhiteListEvent(playerToWhitelist));
            }
        }
        return true;
    }
}
