package watchtowergui.wg.bans.listeners;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.guis.CustomBansGui;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class CustomBansGuiListener implements Listener {
    private final List<CustomBansGui> guiList = new ArrayList<>();
    private final int schedulerDelay = 20;
    private WatchTowerGui plugin;
    private int actualSchedulerTask;

    public void init() {
        this.plugin = WatchTowerGui.getInstance();
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.actualSchedulerTask = Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
            @Override
            public void run() {
                for (CustomBansGui gui : guiList) {
                    gui.reloadDate();
                }
                actualSchedulerTask = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, this, schedulerDelay);
            }
        }, schedulerDelay);
    }

    public void addGui(CustomBansGui gui) {
        if (guiList.contains(gui))
            return;
        guiList.add(gui);
    }

    public void removeGui(CustomBansGui gui) {
        guiList.remove(gui);
    }
}
