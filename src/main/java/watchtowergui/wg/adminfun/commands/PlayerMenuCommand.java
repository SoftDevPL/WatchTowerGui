package watchtowergui.wg.adminfun.commands;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.guis.PlayerActionGui;
import watchtowergui.wg.bans.OfflinePlayerTabCompleter;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public class PlayerMenuCommand extends OfflinePlayerTabCompleter implements CommandExecutor {

    public LanguageConfig languageConfig;

    public PlayerMenuCommand(PluginCommand command) {
        super(command);
        WatchTowerGui plugin = WatchTowerGui.getInstance();
        command.setExecutor(this);
        languageConfig = plugin.configsManager.languageConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(languageConfig.getBasicPlayerNotFoundAD());
            return true;
        }
        Player player = (Player) sender;
        OfflinePlayer playerToMenu;
        if (args.length > 0) {
            if ((playerToMenu = Bukkit.getPlayer(args[0])) == null) {
                playerToMenu = UltimateGuis.getOfflinePlayer(args[0]);
            }
            if (playerToMenu == null) {
                player.sendMessage(languageConfig.getBasicPlayerNotFound(args[0]));
                return true;
            }
            new PlayerActionGui(playerToMenu, null).open(player);
        }
        return true;
    }
}
