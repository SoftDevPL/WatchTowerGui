package watchtowergui.wg.adminfun.commands.sudo;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;

public class SudoListener implements Listener {
    public LanguageConfig languageConfig;

    public void init() {
        this.languageConfig = WatchTowerGui.getInstance().configsManager.languageConfig;
        Bukkit.getServer().getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void sudoExecutor(SudoEvent event) {
        StringBuilder stringBuilder = new StringBuilder(event.getLabel());
        for (String arg : event.getArgs()) {
            stringBuilder.append(" ").append(arg);
        }
        String command = stringBuilder.toString();
        if (event.getPlayerToExecute().performCommand(command)) {
            event.getWho().sendMessage(this.languageConfig.getCommandsLocale_basic_sudoSuccess());
        } else {
            event.getWho().sendMessage(this.languageConfig.getCommandsLocale_basic_sudoFailed());
        }
    }
}
