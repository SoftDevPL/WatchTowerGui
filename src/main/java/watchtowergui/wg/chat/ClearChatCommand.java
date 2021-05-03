package watchtowergui.wg.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import watchtowergui.wg.WatchTowerGui;

public class ClearChatCommand implements CommandExecutor {

    public ClearChatCommand(PluginCommand command) {
        command.setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        clearChat();
        sender.sendMessage(WatchTowerGui.convertColors("&2Chat cleared successfully"));
        return true;
    }

    public static void clearChat(){
        for(int i=0; i<100; i++)
            Bukkit.broadcastMessage("");
    }
}
