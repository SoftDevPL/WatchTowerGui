package watchtowergui.wg.servercontrol.commandcontrol.listeners;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandAliasAddEvent;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandAliasRemoveEvent;
import watchtowergui.wg.servercontrol.commandcontrol.guis.AliasesGui;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.HashSet;
import java.util.Set;

public class AliasesGuiListener implements Listener {
    private final Set<AliasesGui> aliasesGuis = new HashSet<>();

    public void init() {
        Bukkit.getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
    }

    public void addGui(AliasesGui gui) {
        this.aliasesGuis.add(gui);
    }

    public void removeGui(AliasesGui gui) {
        this.aliasesGuis.remove(gui);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void checkAliasAddingResult(CommandAliasAddEvent event) {
        aliasesGuis.forEach(gui -> {
            boolean value = gui.isWaitingForResult() && gui.getCommand().equals(event.getCommand());
            if (value) gui.receiveAliasAdded(event.isDone(), event.getAlias(), event.getComment());
        });
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void checkAliasRemoveResult(CommandAliasRemoveEvent event) {
        aliasesGuis.forEach(gui -> {
            boolean value = gui.isWaitingForResult() && gui.getCommand().equals(event.getCommand());
            if (value) gui.receiveAliasRemoved(event.isDone(), event.getAlias());
        });
    }

}
