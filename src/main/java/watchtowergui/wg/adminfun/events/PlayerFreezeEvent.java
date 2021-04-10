package watchtowergui.wg.adminfun.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public final class PlayerFreezeEvent extends FreezeEvent {

    private static final HandlerList handlerList = new HandlerList();

    public PlayerFreezeEvent(OfflinePlayer frozenPlayer, OfflinePlayer executor, int timeInSeconds) {
        super(frozenPlayer, executor, timeInSeconds);
    }

    public PlayerFreezeEvent(OfflinePlayer frozenPlayer, OfflinePlayer executor) {
        super(frozenPlayer, executor);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

}
