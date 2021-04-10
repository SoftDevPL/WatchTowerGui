package watchtowergui.wg.adminfun.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;

public abstract class FreezeEvent extends Event {

    private final OfflinePlayer executor;
    private final int timeInSeconds;
    private final OfflinePlayer frozenPlayer;

    public FreezeEvent(OfflinePlayer frozenPlayer, OfflinePlayer executor, int timeInSeconds) {
        this.frozenPlayer = frozenPlayer;
        this.executor = executor;
        this.timeInSeconds = timeInSeconds;
    }

    public FreezeEvent(OfflinePlayer frozenPlayer, OfflinePlayer executor) {
        this(frozenPlayer, executor, -1);
    }

    public OfflinePlayer getExecutor() {
        return executor;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public OfflinePlayer getFrozenPlayer() {
        return frozenPlayer;
    }
}
