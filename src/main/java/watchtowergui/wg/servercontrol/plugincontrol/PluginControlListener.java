package watchtowergui.wg.servercontrol.plugincontrol;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;
import watchtowergui.wg.servercontrol.plugincontrol.events.CustomDisablePluginEvent;

public class PluginControlListener implements Listener {

    private CommandsControlListener commandsControlListener;

    public void init() {
        this.commandsControlListener = WatchTowerGui.getInstance().commandsControlListener;
        Bukkit.getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void disablingPluginsHandler(CustomDisablePluginEvent e) {
        if (e.getPlugin().getName().equals(WatchTowerGui.getInstance().getName()) ||
                e.getPlugin().getName().equals("UltimateGuis"))
            return;

        Bukkit.getPluginManager().disablePlugin(e.getPlugin());
        if (Bukkit.getPluginManager().isPluginEnabled(e.getPlugin())) return;
        commandsControlListener.removeActiveCommandsByPlugin(e.getPlugin());
        e.setDone();
    }
}
