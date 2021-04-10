package watchtowergui.wg.chat.mute.commands;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.mute.events.PlayerRemoveMuteEvent;
import watchtowergui.wg.chat.mute.listeners.MuteListener;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import watchtowergui.wg.managers.staticclasses.CalendarCalculator;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnMuteCommand implements CommandExecutor {

    private final LanguageConfig languageConfig;
    private final AdminGuiDatabase adminGuiDatabase;
    private final MuteListener muteListener;

    public UnMuteCommand(WatchTowerGui watchTowerGui) {
        this.adminGuiDatabase = watchTowerGui.SQLmanager.database;
        this.muteListener = watchTowerGui.listenersManager.muteListener;
        this.languageConfig = watchTowerGui.configsManager.languageConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            OfflinePlayer offlinePlayer = UltimateGuis.getOfflinePlayer(args[0]);
            if (offlinePlayer == null) {
                sender.sendMessage(languageConfig.getUnMuteNotExists(args[0]));
                return true;
            }
            if (muteListener.isPlayerMuted(offlinePlayer.getUniqueId())) {
                adminGuiDatabase.deleteBanFromPlayersMutesTable(CalendarCalculator.getOfflinePlayerUUID(args[0]));
                Bukkit.getPluginManager().callEvent(new PlayerRemoveMuteEvent(CalendarCalculator.getOfflinePlayerUU(args[0]), sender));
                sender.sendMessage(languageConfig.getUnMutedPlayer(args[0]));
                Bukkit.getPluginManager().callEvent(new PlayerRemoveMuteEvent(offlinePlayer, sender));
            } else {
                sender.sendMessage(languageConfig.getUnMutedEarlier(offlinePlayer.getName()));
            }
        } else {
            sender.sendMessage(languageConfig.getBanUnBadArgs());
        }
        return true;
    }
}
