package watchtowergui.wg.fileManager.sql.sqlUtils.tables;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import org.bukkit.OfflinePlayer;

import java.util.List;

public class FrozenPlayersTable {

    public AdminGuiDatabase adminGuiDatabase;

    public void init() {
        WatchTowerGui plugin = WatchTowerGui.getInstance();
        this.adminGuiDatabase = plugin.SQLmanager.database;
    }

    public boolean addPlayerToConfig(OfflinePlayer player) {
        return adminGuiDatabase.insertDataIntoFrozenPlayersTable(player.getUniqueId().toString());
    }

    public boolean removePlayerfromConfig(OfflinePlayer player) {
        return adminGuiDatabase.deleteFrozenPlayerFromFrozenPlayersTable(player.getUniqueId().toString());
    }

    public List<String> getPlayersList() {
        return adminGuiDatabase.getFrozenPlayersList();
    }
}
