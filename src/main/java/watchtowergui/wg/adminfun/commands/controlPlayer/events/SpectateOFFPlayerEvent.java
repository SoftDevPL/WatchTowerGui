package watchtowergui.wg.adminfun.commands.controlPlayer.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class SpectateOFFPlayerEvent extends PlayerEvent implements Cancellable {

    private boolean cancel;
    private Player controllingPlayer;
    private final static HandlerList handlerList = new HandlerList();

    public SpectateOFFPlayerEvent(Player who, Player controllingPlayer) {
        super(who);
        this.controllingPlayer = controllingPlayer;
    }

    public static HandlerList getHandlerList() { return handlerList; }

    public Player getControllingPlayer() { return controllingPlayer;}

    public void setControllingPlayer(Player controllingPlayer) { this.controllingPlayer = controllingPlayer;}

    @Override
    public HandlerList getHandlers() {return  handlerList; }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

}
