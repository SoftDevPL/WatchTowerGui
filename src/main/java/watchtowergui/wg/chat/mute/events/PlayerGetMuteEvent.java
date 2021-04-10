package watchtowergui.wg.chat.mute.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerGetMuteEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final OfflinePlayer mutedPlayer;
    private final CommandSender whoMuted;
    private final long expiredTime;

    public PlayerGetMuteEvent(OfflinePlayer mutedPlayer, CommandSender whoMuted, long expiredTime) {
        this.mutedPlayer = mutedPlayer;
        this.whoMuted = whoMuted;
        this.expiredTime = expiredTime;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public OfflinePlayer getMutedPlayer() {
        return mutedPlayer;
    }

    public CommandSender getWhoMuted() {
        return whoMuted;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
