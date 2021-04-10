package watchtowergui.wg.chat.chatguard;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.event.PlayerGetTempBanEvent;
import watchtowergui.wg.fileManager.configsutils.configs.BadWordsConfig;
import watchtowergui.wg.fileManager.configsutils.configs.DisabledCommandsForLogsConfig;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.configsutils.configs.MainConfig;
import watchtowergui.wg.managers.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerKickEvent;
import watchtowergui.wg.managers.staticclasses.CustomMath;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReplaceBadWords implements Listener {

    public DisabledCommandsForLogsConfig disabledCommandsForLogsConfig;
    public Permissions permission;
    Map<String, Long> cooldown = new HashMap<>();
    Map<String, Integer> count = new HashMap<>();
    Map<UUID, AtomicInteger> countOfKicks = new HashMap<>();
    private WatchTowerGui watchTowerGui;
    private BadWordsConfig badWordsConfig;
    private LanguageConfig languageConfig;
    private MainConfig mainConfig;
    private long banTime;
    private String banTimeStringFormat;
    private int countsToBan;
    private List<String> badWords;

    public void init() {
        this.watchTowerGui = WatchTowerGui.getInstance();
        this.permission = watchTowerGui.permissions;
        watchTowerGui.getServer().getPluginManager().registerEvents(this, watchTowerGui);
        this.mainConfig = watchTowerGui.configsManager.mainConfig;
        this.countsToBan = mainConfig.getCountOfTriesToBan();
        this.banTimeStringFormat = mainConfig.getBanTime();
        this.badWordsConfig = watchTowerGui.configsManager.badWordsConfig;
        this.disabledCommandsForLogsConfig = this.watchTowerGui.configsManager.disabledCommandsForLogsConfig;
        this.languageConfig = watchTowerGui.configsManager.languageConfig;
        badWords = badWordsConfig.getAllWordsFromConfig();
    }

    @EventHandler
    public void catchTypingBadWords(AsyncPlayerChatEvent event) {
        if (!mainConfig.getAllowedBadWords()) {
            for (String badWord : badWords) {
                if (event.getMessage().toLowerCase().contains(badWord.toUpperCase()))
                    continue;
                char[] wordCH = new char[badWord.length()];
                Arrays.fill(wordCH, '*');
                String replacedBadWord = new String(wordCH);
                event.setMessage(event.getMessage().replaceAll("(?i)" + badWord, replacedBadWord));
            }
        }

    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void toFastTyping(AsyncPlayerChatEvent event) {
        if (!event.getPlayer().hasPermission(permission.allowSpamming)) {
            if (cooldown.containsKey(event.getPlayer().getName())) {
                if (cooldown.get(event.getPlayer().getName()) > System.currentTimeMillis()) {
                    if (!count.containsKey(event.getPlayer().getName())) {
                        count.put(event.getPlayer().getName(), 0);
                    }
                    count.replace(event.getPlayer().getName(), count.get(event.getPlayer().getName()) + 1);
                    if (count.get(event.getPlayer().getName()) > mainConfig.getCountOfTries() + 1) {

                        Bukkit.getPluginManager().callEvent(new PlayerKickEvent(event.getPlayer(), languageConfig.getSpamKickMessage(), languageConfig.getSpamKickMessageInConsole(event.getPlayer().getName())));
                        count.remove(event.getPlayer().getName());
                    }
                    event.setCancelled(true);
                    event.getPlayer().sendMessage(languageConfig.getMessageForSpammingToPlayer());
                    return;
                } else {
                    cooldown.remove(event.getPlayer().getName());
                }
            }
            cooldown.put(event.getPlayer().getName(), System.currentTimeMillis() + (mainConfig.getCountdown() * 1000));
        }
    }

    @EventHandler
    public void kickPlayer(PlayerKickEvent event) {
        Bukkit.getScheduler().runTask(this.watchTowerGui, () -> {
            tmBanPlayerOnSpammingTries(event);
            event.getPlayer().kickPlayer(event.getReason());
        });
    }

    private long reformatStringBanTime(String string) {
        Date date = new Date();
        String[] strs = string.split("(?!\\w)");
        for (String st : strs) {
            if (st.contains("%S")) {
                String value1 = st.replaceAll("%S", "");
                banTime += CustomMath.calcMilliseconds(Long.parseLong(value1), 0L, 0L, 0L, 0L, 0L, 0L);
            }
            if (st.contains("%Mi")) {
                String value2 = st.replaceAll("%Mi", "");
                banTime += CustomMath.calcMilliseconds(0L, Long.parseLong(value2), 0L, 0L, 0L, 0L, 0L);
            }
            if (st.contains("%H")) {
                String value3 = st.replaceAll("%H", "");
                banTime += CustomMath.calcMilliseconds(0L, 0L, Long.parseLong(value3), 0L, 0L, 0L, 0L);
            }
            if (st.contains("%D")) {
                String value4 = st.replaceAll("%D", "");
                banTime += CustomMath.calcMilliseconds(0L, 0L, 0L, Long.parseLong(value4), 0L, 0L, 0L);
            }
            if (st.contains("%W")) {
                String value5 = st.replaceAll("%W", "");
                banTime += CustomMath.calcMilliseconds(0L, 0L, 0L, 0L, Long.parseLong(value5), 0L, 0L);
            }
            if (st.contains("%Mo")) {
                String value6 = st.replaceAll("%Mo", "");
                banTime += CustomMath.calcMilliseconds(0L, 0L, 0L, 0L, 0L, Long.parseLong(value6), 0L);
            }
            if (st.contains("%Y")) {
                String value7 = st.replaceAll("%Y", "");
                banTime += CustomMath.calcMilliseconds(0L, 0L, 0L, 0L, 0L, 0L, Long.parseLong(value7));
            }
        }
        return date.getTime() + banTime;
    }

    private void tmBanPlayerOnSpammingTries(PlayerKickEvent event) {
        if (countOfKicks.containsKey(event.getPlayer().getUniqueId())) {
            countOfKicks.get(event.getPlayer().getUniqueId()).incrementAndGet();
            if (countOfKicks.get(event.getPlayer().getUniqueId()).get() > countsToBan) {
                long banTime = reformatStringBanTime(banTimeStringFormat);
                CommandSender commandSender = Bukkit.getConsoleSender();
                Bukkit.getPluginManager().callEvent(new PlayerGetTempBanEvent(event.getPlayer(), banTime, commandSender, System.currentTimeMillis(), "Banned from console"));
                countOfKicks.get(event.getPlayer().getUniqueId()).set(0);
            }
        } else {
            countOfKicks.put(event.getPlayer().getUniqueId(), new AtomicInteger(0));
        }
    }

}
