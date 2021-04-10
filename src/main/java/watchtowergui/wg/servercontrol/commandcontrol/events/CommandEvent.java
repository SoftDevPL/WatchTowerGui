package watchtowergui.wg.servercontrol.commandcontrol.events;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;

public abstract class CommandEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();
    protected final Command command;
    protected final @Nullable CommandSender sender;
    private boolean cancel = false;

    @Getter
    private boolean done = false;

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public abstract String getDescription();

    public CommandEvent(Command command, @Nullable CommandSender sender) {
        this.command = command;
        this.sender = sender;
    }

    public @Nullable CommandSender getSender() {
        return sender;
    }

    public Command getCommand() {
        return command;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public void done() {
        this.done = true;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
