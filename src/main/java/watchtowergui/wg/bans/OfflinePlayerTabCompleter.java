package watchtowergui.wg.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OfflinePlayerTabCompleter implements TabCompleter {

    public OfflinePlayerTabCompleter(PluginCommand command) {
        command.setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return watchtowergui.wg.manager.CommandsManager.mergeTabCompleter(Arrays.stream(Bukkit.getOfflinePlayers())
                .map(OfflinePlayer::getName).collect(Collectors.toList()), args[0]);
    }
}
