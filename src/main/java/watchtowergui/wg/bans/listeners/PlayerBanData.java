package watchtowergui.wg.bans.listeners;

import watchtowergui.wg.bans.event.PlayerGetTempBanEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PlayerBanData {

    private UUID bannedPlayer;
    private String comment = "You are temp banned!";
    private long expiredTime;
    private String banExecutor = "unknown";
    private long bannedTime = 0;

    public PlayerBanData(PlayerGetTempBanEvent event) {
        this.bannedPlayer = event.getBannedPlayer().getUniqueId();
        this.comment = event.getComment();
        this.expiredTime = event.getExpiredTime();
        this.banExecutor = event.getBanExecutor().getName();
        this.bannedTime = event.getBannedTime();
    }

}
