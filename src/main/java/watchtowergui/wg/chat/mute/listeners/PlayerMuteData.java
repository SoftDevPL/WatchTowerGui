package watchtowergui.wg.chat.mute.listeners;

import java.util.UUID;

public class PlayerMuteData {

    UUID MutedPlayer;
    String whoMuted;
    long expiryTime;

    public PlayerMuteData(UUID mutedPlayer, String whoMuted, long expiryTime) {
        MutedPlayer = mutedPlayer;
        this.whoMuted = whoMuted;
        this.expiryTime = expiryTime;
    }

    public UUID getMutedPlayer() {
        return MutedPlayer;
    }

    public String getWhoMuted() {
        return whoMuted;
    }

    public long getExpiryTime() {
        return expiryTime;
    }
}
