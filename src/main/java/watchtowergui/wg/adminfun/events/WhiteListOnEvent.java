package watchtowergui.wg.adminfun.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class WhiteListOnEvent extends PlayerEvent {

    private final static HandlerList handlerList = new HandlerList();

    public WhiteListOnEvent(Player who) {
        super(who);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

}
