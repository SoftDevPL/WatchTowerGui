package watchtowergui.wg.bans.event;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerGetTempBanEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final long expiredTime;
    private final CommandSender banExecutor;
    private final OfflinePlayer bannedPlayer;
    private final String comment;
    private final long bannedTime;

    public PlayerGetTempBanEvent(OfflinePlayer bannedPlayer, long whenExpired, CommandSender banExecutor, long bannedTime, String comment) {
        this.expiredTime = whenExpired;
        this.banExecutor = banExecutor;
        this.bannedPlayer = bannedPlayer;
        this.comment = comment;
        this.bannedTime = bannedTime;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public String getComment() {
        return comment;
    }

    public long getBannedTime() {
        return bannedTime;
    }

    public OfflinePlayer getBannedPlayer() {
        return bannedPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public CommandSender getBanExecutor() {
        return banExecutor;
    }
}
