package watchtowergui.wg.chat.mute.listeners;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.mute.events.PlayerGetMuteEvent;
import watchtowergui.wg.chat.mute.events.PlayerRemoveMuteEvent;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;


public class MuteListener implements Listener {

    private final int schedulerDelay = 20;
    public LanguageConfig languageConfig;
    List<PlayerMuteData> muteDataList = new ArrayList<>();
    private AdminGuiDatabase adminGuiDatabase;

    public void init() {
        WatchTowerGui watchTowerGui = WatchTowerGui.getInstance();
        this.adminGuiDatabase = watchTowerGui.SQLmanager.database;
        this.languageConfig = watchTowerGui.configsManager.languageConfig;
        watchTowerGui.getServer().getPluginManager().registerEvents(this, watchTowerGui);
        getAllMutes();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(watchTowerGui, new Runnable() {
            @Override
            public void run() {

                for (PlayerMuteData playerMuteData : muteDataList) {
                    if (playerMuteData.expiryTime <= System.currentTimeMillis()) {
                        adminGuiDatabase.deleteBanFromPlayersMutesTable(playerMuteData.MutedPlayer.toString());
                    }
                }

                muteDataList.removeIf((PlayerMuteData playerMuteData) ->
                        playerMuteData.expiryTime <= System.currentTimeMillis());
            }
        }, schedulerDelay, schedulerDelay);
    }

    public boolean isPlayerMuted(UUID playerUUID) {
        for (PlayerMuteData playerMuteData : muteDataList) {
            if (playerMuteData.MutedPlayer.equals(playerUUID)) {
                return true;
            }
        }
        return false;
    }

    public List<PlayerMuteData> getMuteDataList() {
        return muteDataList;
    }

    private void getAllMutes() {
        List<List<String>> allMutes = adminGuiDatabase.getAllMuted();
        for (List<String> mute : allMutes) {
            UUID playerUUID = UUID.fromString(mute.get(0));
            long muteTime = Long.parseLong(mute.get(2));
            PlayerMuteData playerMuteData = new PlayerMuteData(playerUUID, mute.get(1), muteTime);
            muteDataList.add(playerMuteData);
        }
    }

    @EventHandler
    public void blockPlayerFromWriting(AsyncPlayerChatEvent event) {
        for (PlayerMuteData playerMuteData : muteDataList) {
            if (playerMuteData.MutedPlayer.equals(event.getPlayer().getUniqueId())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(languageConfig.getYouAreMutedMessage());
            } else {
                event.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void catchMutes(PlayerGetMuteEvent event) {
        if (!isPlayerMuted(event.getMutedPlayer().getUniqueId())) {
            PlayerMuteData playerMuteData = new PlayerMuteData(event.getMutedPlayer().getUniqueId(), event.getWhoMuted().getName(), event.getExpiredTime());
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(playerMuteData.expiryTime);
            String time = calendar.toZonedDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss dd MMM uuuu"));
            muteDataList.add(playerMuteData);

            if (event.getMutedPlayer() instanceof Player) {
                Player playerToMute = (Player) event.getMutedPlayer();
                String message = languageConfig.getMuteMessage(playerMuteData.whoMuted, time);
                playerToMute.sendMessage(message);
            }
        }
    }

    @EventHandler
    public void deleteMutes(PlayerRemoveMuteEvent event) {
        if (isPlayerMuted(event.getUnMutedPlayer().getUniqueId())) {
            muteDataList.removeIf(playerMuteData -> playerMuteData.MutedPlayer.equals(event.getUnMutedPlayer().getUniqueId()));
        }
    }
}






