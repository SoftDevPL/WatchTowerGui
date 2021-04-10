package watchtowergui.wg.logs.utils;

import org.bukkit.command.CommandSender;

public interface ConsoleChatAction {
    boolean action(String chatMessage, CommandSender sender);
}
