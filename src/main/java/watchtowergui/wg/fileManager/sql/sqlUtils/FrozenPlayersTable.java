package watchtowergui.wg.fileManager.sql.sqlUtils;

import watchtowergui.wg.WatchTowerGui;
import org.bukkit.OfflinePlayer;

import java.util.List;

public class FrozenPlayersTable {

    public Database database;

    public void init() {
        WatchTowerGui plugin = WatchTowerGui.getInstance();
        this.database = plugin.SQLmanager.database;
    }

    public boolean addPlayerToConfig(OfflinePlayer player) {
        return database.insertDataIntoFrozenPlayersTable(player.getUniqueId().toString());
    }

    public boolean removePlayerFromConfig(OfflinePlayer player) {
        return database.deleteFrozenPlayerFromFrozenPlayersTable(player.getUniqueId().toString());
    }

    public List<String> getPlayersList() {
        return database.getFrozenPlayersList();
    }
}
