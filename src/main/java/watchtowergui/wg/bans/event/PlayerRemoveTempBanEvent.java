package watchtowergui.wg.bans.event;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerRemoveTempBanEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    private final OfflinePlayer unBannedPlayer;
    private final CommandSender whoUnbanned;

    public PlayerRemoveTempBanEvent(OfflinePlayer unBannedPlayer, CommandSender whoUnbanned) {
        this.unBannedPlayer = unBannedPlayer;
        this.whoUnbanned = whoUnbanned;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public OfflinePlayer getUnBannedPlayer() {
        return unBannedPlayer;
    }

    public CommandSender getWhoUnbanned() {
        return whoUnbanned;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
