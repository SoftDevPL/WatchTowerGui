package watchtowergui.wg.chat.mute.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerRemoveMuteEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final OfflinePlayer unMutedPlayer;
    private final CommandSender whoUnMuted;

    public PlayerRemoveMuteEvent(OfflinePlayer unMutedPlayer, CommandSender whoUnMuted) {
        this.unMutedPlayer = unMutedPlayer;
        this.whoUnMuted = whoUnMuted;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public OfflinePlayer getUnMutedPlayer() {
        return unMutedPlayer;
    }

    public CommandSender getWhoUnMuted() {
        return whoUnMuted;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }


}
