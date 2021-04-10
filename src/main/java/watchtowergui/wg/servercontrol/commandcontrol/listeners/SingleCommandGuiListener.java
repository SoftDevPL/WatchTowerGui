package watchtowergui.wg.servercontrol.commandcontrol.listeners;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandDisableEvent;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandEnableEvent;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandLabelChangeEvent;
import watchtowergui.wg.servercontrol.commandcontrol.guis.SingleCommandGui;

import java.util.HashSet;
import java.util.Set;

public class SingleCommandGuiListener implements Listener {

    private final Set<SingleCommandGui> guiList = new HashSet<>();

    public void init() {
        Bukkit.getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
    }

    public void addGui(SingleCommandGui gui) {
        guiList.add(gui);
    }

    public void removeGui(SingleCommandGui gui) {
        guiList.remove(gui);
    }

    private boolean checkResultAcceptation(SingleCommandGui gui, Command command) {
        return gui.isWaitingForResult() && gui.getCommand().equals(command);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void checkCommandEnableResult(CommandEnableEvent event) {
        guiList.forEach(gui -> {
            if (checkResultAcceptation(gui, event.getCommand()))
                gui.receiveEnableResult(event.isDone(), event.getComment());
        });
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void checkCommandDisableResult(CommandDisableEvent event) {
        guiList.forEach(gui -> {
            if (checkResultAcceptation(gui, event.getCommand()))
                gui.receiveDisableResult(event.isDone());
        });
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void checkLabelChangeResult(CommandLabelChangeEvent event) {
        guiList.forEach(gui -> {
            if (checkResultAcceptation(gui, event.getCommand()))
                gui.receiveChangeLabelResult(event.isDone(), event.getNewLabel(), event.getComment());
        });
    }

}
