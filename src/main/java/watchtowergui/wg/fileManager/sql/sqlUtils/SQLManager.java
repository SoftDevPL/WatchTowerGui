package watchtowergui.wg.fileManager.sql.sqlUtils;

import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import watchtowergui.wg.fileManager.sql.sqlUtils.tables.FrozenPlayersTable;

public class SQLManager {
    public AdminGuiDatabase database;
    public FrozenPlayersTable frozenPlayersConfig;

    public SQLManager() {
        this.database = new AdminGuiDatabase();
        this.frozenPlayersConfig = new FrozenPlayersTable();
    }

    public void init() {
        this.database.init();
        this.database.connect();

        this.frozenPlayersConfig.init();
    }
}
