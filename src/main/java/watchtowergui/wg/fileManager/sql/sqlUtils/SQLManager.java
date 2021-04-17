package watchtowergui.wg.fileManager.sql.sqlUtils;

public class SQLManager {
    public Database database;
    public FrozenPlayersTable frozenPlayersConfig;

    public SQLManager() {
        this.database = new Database();
        this.frozenPlayersConfig = new FrozenPlayersTable();
    }

    public void init() {
        this.database.init();
        this.database.connect();

        this.frozenPlayersConfig.init();
    }
}
