package watchtowergui.wg.chat.mute.commands;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.guis.CustomBansGui;
import watchtowergui.wg.chat.mute.events.PlayerGetMuteEvent;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import watchtowergui.wg.managers.CommandsManager;
import watchtowergui.wg.managers.staticclasses.CalendarCalculator;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements CommandExecutor {
    private final LanguageConfig languageConfig;
    private final AdminGuiDatabase adminGuiDatabase;

    public MuteCommand(WatchTowerGui watchTowerGui) {
        this.adminGuiDatabase = watchTowerGui.SQLmanager.database;
        this.languageConfig = watchTowerGui.configsManager.languageConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(CommandsManager.getDescription(label, command));
            return true;
        }
        OfflinePlayer player = UltimateGuis.getOfflinePlayer(args[0]);
        if (player == null) {
            sender.sendMessage(languageConfig.getBasicPlayerNotFound(args[0]));
            return true;
        }
        if (args.length == 1) {
            if (sender instanceof Player) {
                new CustomBansGui(player, null, CustomBansGui.MUTE_GUI).open((Player) sender);
            } else {
                sender.sendMessage(languageConfig.getMuteEnterTime());
            }
            return true;
        }
        long banTime = 0;
        if (args.length <= 8) {
            try {
                long[] val = {0, 0, 0, 0, 0, 0, 0};
                for (int i = 0; i < val.length; i++) {
                    try {
                        val[i] = Long.parseLong(args[i + 1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }
                }
                banTime = CalendarCalculator.calcMilliseconds(val[0], val[1], val[2], val[3], val[4], val[5], val[6]);
            } catch (NumberFormatException e) {
                sender.sendMessage(languageConfig.getMuteValueNotANumber());
            }
        }
        if (banTime > 0) {
            adminGuiDatabase.insertDataIntoPlayersMutesTable(player.getUniqueId().toString(), sender.getName(), banTime);
            Bukkit.getPluginManager().callEvent(new PlayerGetMuteEvent(player, sender, banTime));
            sender.sendMessage(languageConfig.getMutedPlayer(args[0]));
        }
        return true;
    }
}
