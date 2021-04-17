package watchtowergui.wg.bans.listeners;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.event.PlayerGetTempBanEvent;
import watchtowergui.wg.bans.event.PlayerRemoveTempBanEvent;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TempBanListener implements Listener {
    private final List<PlayerBanData> banDataList = new ArrayList<>();
    private final int schedulerDelay = 20;
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private WatchTowerGui plugin;
    private Database database;

    public void init() {
        this.plugin = WatchTowerGui.getInstance();
        this.database = this.plugin.SQLmanager.database;
        getAllBans();
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
            @Override
            public void run() {
                banDataList.removeIf(data -> {
                    if (data.getExpiredTime() <= System.currentTimeMillis()) {
                        removeFromDatabase(data.getBannedPlayer());
                        return true;
                    }
                    return false;
                });
            }
        }, schedulerDelay, schedulerDelay);
    }

    public boolean isPlayerBanned(final UUID playerToCheck) {
        return banDataList.stream().anyMatch(data -> data.getBannedPlayer().equals(playerToCheck));
    }

    @EventHandler
    private void blockPlayer(AsyncPlayerPreLoginEvent event) {
        for (PlayerBanData playerBanData : banDataList) {
            if (playerBanData.getBannedPlayer().equals(event.getUniqueId())) {
                String comment = dateFormat.format(playerBanData.getExpiredTime());
                comment = plugin.configsManager.languageConfig.getBanReasonCom(comment, playerBanData.getComment());
                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, comment);
                return;
            }
        }
    }

    private void getAllBans() {
        List<List<String>> allBans = database.getAllBanned();
        for (List<String> ban : allBans) {
            UUID playerUUID = UUID.fromString(ban.get(Database.PLAYER_BAN_UUID));
            long expiredTime = Long.parseLong(ban.get(Database.BAN_TIME));
            long bannedTime = Long.parseLong(ban.get(Database.BAN_DATE));
            String whoBanned = ban.get(Database.BANNER);
            String comment = ban.get(Database.COMMENT);
            PlayerBanData playerBanData = new PlayerBanData(playerUUID, comment, expiredTime, whoBanned, bannedTime);
            banDataList.add(playerBanData);
        }
    }

    @EventHandler
    private void catchBans(PlayerGetTempBanEvent event) {
        if (!isPlayerBanned(event.getBannedPlayer().getUniqueId())) {
            PlayerBanData banData = new PlayerBanData(event);

            banDataList.add(banData);
            saveToDatabase(banData);
            if (event.getBannedPlayer() instanceof Player) {
                Player playerToKick = (Player) event.getBannedPlayer();
                String comment = dateFormat.format(event.getExpiredTime());
                comment = plugin.configsManager.languageConfig.getBanReasonCom(comment, event.getComment());
                playerToKick.kickPlayer(comment);
            }
        }
    }

    @EventHandler
    public void removeBan(PlayerRemoveTempBanEvent event) {
        banDataList.removeIf(data -> {
            if (event.getUnBannedPlayer().getUniqueId().equals(data.getBannedPlayer())) {
                removeFromDatabase(data.getBannedPlayer());
                return true;
            }
            return false;
        });
    }

    public void saveToDatabase(PlayerBanData data) {
        database.insertDataIntoPlayersBanTable(data.getBannedPlayer().toString(),
                data.getBanExecutor(), data.getComment(), data.getBannedTime(), data.getExpiredTime());
    }

    public void removeFromDatabase(UUID bannedPlayer) {
        database.deleteBanFromPlayersBansTable(bannedPlayer.toString());
    }

    public List<PlayerBanData> getBanDataList() {
        return banDataList;
    }
}
