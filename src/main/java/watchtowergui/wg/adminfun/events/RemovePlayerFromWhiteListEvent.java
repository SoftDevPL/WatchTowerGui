package watchtowergui.wg.adminfun.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RemovePlayerFromWhiteListEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final OfflinePlayer whiteListedPlayer;

    public RemovePlayerFromWhiteListEvent(OfflinePlayer offlinePlayer) {
        this.whiteListedPlayer = offlinePlayer;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public OfflinePlayer getPlayer() {
        return whiteListedPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
