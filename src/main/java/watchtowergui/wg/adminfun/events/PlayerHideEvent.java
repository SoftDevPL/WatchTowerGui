package watchtowergui.wg.adminfun.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerHideEvent extends Event implements Cancellable {

    private final static HandlerList handlerList = new HandlerList();
    private final OfflinePlayer player;
    private final CommandSender sender;
    private boolean cancel;

    public PlayerHideEvent(OfflinePlayer who, CommandSender sender) {
        this.player = who;
        this.sender = sender;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public CommandSender getSender() {
        return sender;
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
