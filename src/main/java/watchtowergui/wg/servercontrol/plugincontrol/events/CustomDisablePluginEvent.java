package watchtowergui.wg.servercontrol.plugincontrol.events;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

public class CustomDisablePluginEvent extends CustomPluginEvent {
    private final static HandlerList handlerList = new HandlerList();

    public CustomDisablePluginEvent(Plugin plugin, CommandSender executor) {
        super(plugin, executor);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
