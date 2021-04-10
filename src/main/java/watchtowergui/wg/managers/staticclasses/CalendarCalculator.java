package watchtowergui.wg.managers.staticclasses;

import ad.guis.ultimateguis.UltimateGuis;
import watchtowergui.wg.WatchTowerGui;
import org.bukkit.OfflinePlayer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarCalculator {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy");

    public static String getOfflinePlayerUUID(String playerName) {
        OfflinePlayer offlinePlayer = UltimateGuis.getOfflinePlayer(playerName);
        if (offlinePlayer == null) {
            return "";
        }
        return offlinePlayer.getUniqueId().toString();
    }

    public static OfflinePlayer getOfflinePlayerUU(String playerName) {
        return UltimateGuis.getOfflinePlayer(playerName);
    }

    public static long getCurrentMilliseconds() {
        Date data = new Date();
        return data.getTime();
    }

    public static long calcMilliseconds(long secInMili, long minInMili, long hourInMili, long dayInMili, long weekInMili, long monthInMili, long yearInMili) {
        Date data = new Date();
        return data.getTime() + (secInMili * 1000L) + (minInMili * 60000L) + (hourInMili * 3600000L) + (dayInMili * 86400000L) + (weekInMili * 604800017L) + (monthInMili * 2629800000L) + (yearInMili * 31557600000L);
    }

    public static String standardDateFormat(long timeInMillis) {
        return dateFormat.format(new Date(timeInMillis));
    }

    public void init() {
        WatchTowerGui plugin = WatchTowerGui.getInstance();
    }
}
