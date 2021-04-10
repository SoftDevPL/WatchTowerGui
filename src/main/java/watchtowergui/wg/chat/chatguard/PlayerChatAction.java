package watchtowergui.wg.chat.chatguard;

import org.bukkit.entity.Player;

public interface PlayerChatAction {
    boolean action(String chatMessage, Player player);
}
