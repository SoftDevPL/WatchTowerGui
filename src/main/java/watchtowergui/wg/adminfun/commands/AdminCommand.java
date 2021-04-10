package watchtowergui.wg.adminfun.commands;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.guis.AdminGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigGenerator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements CommandExecutor {

    final private WatchTowerGui plugin;
    public LanguageConfig languageConfig;
    public ConfigGenerator configGenerator;

    public AdminCommand(WatchTowerGui plugin) {
        this.plugin = plugin;
        configGenerator = plugin.configsManager.configGenerator;
        languageConfig = this.plugin.configsManager.languageConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.configsManager.languageConfig.getPlayerNotFoundAD());
            return true;
        }
        Player player = (Player) sender;
        AdminGui adminGui = new AdminGui(null);
        adminGui.open(player);
        return true;
    }
}
