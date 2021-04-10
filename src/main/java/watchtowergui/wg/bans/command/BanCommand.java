package watchtowergui.wg.bans.command;

import ad.guis.ultimateguis.UltimateGuis;
import ad.guis.ultimateguis.examples.ConfirmGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.OfflinePlayerTabCompleter;
import watchtowergui.wg.bans.event.PlayerGetTempBanEvent;
import watchtowergui.wg.bans.guis.CustomBansGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
import watchtowergui.wg.managers.staticclasses.CalendarCalculator;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BanCommand extends OfflinePlayerTabCompleter implements CommandExecutor, Listener {

    private final WatchTowerGui watchTowerGui;
    private final LanguageConfig languageConfig;
    private final ChatManager chatManager;

    public BanCommand(PluginCommand command) {
        super(command);
        command.setExecutor(this);
        this.watchTowerGui = WatchTowerGui.getInstance();
        this.languageConfig = this.watchTowerGui.configsManager.languageConfig;
        this.chatManager = this.watchTowerGui.listenersManager.chatManager;
        Bukkit.getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            OfflinePlayer playerToBan = UltimateGuis.getOfflinePlayer(args[0]);
            if (playerToBan == null) {
                sender.sendMessage(languageConfig.getBanPlayerNotExists(args[0]));
                return true;
            }
            if (!this.watchTowerGui.listenersManager.tempBanListener.isPlayerBanned(playerToBan.getUniqueId())) {
                long banTime = 0;
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        new CustomBansGui(playerToBan, null).open((Player) sender);
                    } else {
                        sender.sendMessage(languageConfig.getBanEnterTime());
                    }
                    return true;
                }
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
                    sender.sendMessage(languageConfig.getValueNotANumber());
                }
                if (banTime > 0) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage(languageConfig.getEnterBanComment());
                        long finalBanTime = banTime;
                        chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                            new ConfirmGui("Ban " + playerToBan.getName() + "?", playerWhoAccept -> {
                                Bukkit.getPluginManager().callEvent(new PlayerGetTempBanEvent(playerToBan, finalBanTime,
                                        sender, System.currentTimeMillis(), chatMessage));
                                playerWhoAccept.closeInventory();
                            }, playerWhoDenied -> {
                                playerWhoDenied.sendMessage(languageConfig.getBanCommentCanceled());
                                playerWhoDenied.closeInventory();
                            }).open(chatPlayer);
                            return true;
                        });
                    } else {
                        Bukkit.getPluginManager().callEvent(new PlayerGetTempBanEvent(playerToBan, banTime, sender,
                                System.currentTimeMillis(), (args.length >= 8) ? args[8] : "."));
                        sender.sendMessage(languageConfig.getBannedPlayer(args[0]));
                    }
                }
            } else {
                sender.sendMessage(languageConfig.getBanMustBeGreaterThan0());
            }

        } else {
            sender.sendMessage(CommandsManager.getDescription(label, command));
        }
        return true;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void infoAboutTempBan(PlayerGetTempBanEvent e) {
        if (e.getBanExecutor() == null) return;
        e.getBanExecutor().sendMessage(languageConfig.getBannedPlayer(e.getBannedPlayer().getName()));
    }

}
