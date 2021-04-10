package watchtowergui.wg.logs.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;
import watchtowergui.wg.WatchTowerGui;

import java.util.HashMap;
import java.util.Map;

public class ConsoleChatListener implements Listener {

    private final Map<CommandSender, ConsoleChatAction> chatTasks = new HashMap<>();

    public void init() {
        WatchTowerGui plugin = WatchTowerGui.getInstance();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void executeTask(ServerCommandEvent event) {
        if (chatTasks.containsKey(event.getSender())) {
            event.setCancelled(true);
            if (chatTasks.get(event.getSender()).action(event.getCommand(), event.getSender())) {
                chatTasks.remove(event.getSender());
            }
        }
    }

    public void removeTask(CommandSender commandSender) {
        chatTasks.remove(commandSender);
    }

    public void clearTasks() {
        chatTasks.clear();
    }

    public boolean checkIfTaskExecuted() {
        return chatTasks.isEmpty();
    }

    public void setTask(CommandSender commandSender, ConsoleChatAction action) {
        chatTasks.put(commandSender, action);
    }
}
