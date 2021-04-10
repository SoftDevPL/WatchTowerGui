package watchtowergui.wg.servercontrol.plugincontrol.events;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.server.PluginEvent;
import org.bukkit.plugin.Plugin;

public abstract class CustomPluginEvent extends PluginEvent implements Cancellable {
    private boolean cancel;
    private CommandSender executor;
    private boolean done;


    public CustomPluginEvent(Plugin plugin, CommandSender executor){
        super(plugin);
        this.executor = executor;
    }

    public void setDone(){
        this.done = true;
    }

    public boolean isDone() {
        return done;
    }

    public CommandSender getExecutor() {
        return executor;
    }

    public void setExecutor(CommandSender executor) {
        this.executor = executor;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
