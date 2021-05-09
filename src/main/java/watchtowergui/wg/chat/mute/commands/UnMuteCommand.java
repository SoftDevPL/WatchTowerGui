package watchtowergui.wg.chat.mute.commands;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.mute.events.PlayerRemoveMuteEvent;
import watchtowergui.wg.chat.mute.listeners.MuteListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import watchtowergui.wg.managers.staticclasses.CalendarCalculator;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnMuteCommand implements CommandExecutor {

    private final LanguageConfig languageConfig;
    private final Database database;
    private final MuteListener muteListener;

    public UnMuteCommand(WatchTowerGui watchTowerGui) {
        this.database = watchTowerGui.SQLmanager.database;
        this.muteListener = watchTowerGui.listenersManager.muteListener;
        this.languageConfig = watchTowerGui.configsManager.languageConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            OfflinePlayer offlinePlayer = UltimateGuis.getOfflinePlayer(args[0]);
            if (offlinePlayer == null) {
                sender.sendMessage(languageConfig.getCommandsLocale_basic_playerNotFoundWithPlayerName(args[0]));
                return true;
            }
            if (muteListener.isPlayerMuted(offlinePlayer.getUniqueId())) {
                database.deleteBanFromPlayersMutesTable(CalendarCalculator.getOfflinePlayerUUID(args[0]));
                Bukkit.getPluginManager().callEvent(new PlayerRemoveMuteEvent(CalendarCalculator.getOfflinePlayerUU(args[0]), sender));
                sender.sendMessage(languageConfig.getCommandsLocale_mutes_unmute_unMutedPlayer(args[0]));
                Bukkit.getPluginManager().callEvent(new PlayerRemoveMuteEvent(offlinePlayer, sender));
            } else {
                sender.sendMessage(languageConfig.getCommandsLocale_mutes_unmute_unMutedEarlier(offlinePlayer.getName()));
            }
        } else {
            sender.sendMessage(languageConfig.getCommandsLocale_bans_unban_unbanUnBadArgs());
        }
        return true;
    }
}
