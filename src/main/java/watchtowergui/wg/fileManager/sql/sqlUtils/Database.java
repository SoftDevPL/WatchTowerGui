package watchtowergui.wg.fileManager.sql.sqlUtils;

import ad.guis.ultimateguis.engine.Pair;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import watchtowergui.wg.adminfun.commands.controlPlayer.models.SpectatingPlayer;

import java.sql.*;
import java.util.*;

public class Database extends CustomSQLInterface {

    public static final Integer COMMANDS_LOGS = 0;
    public static final Integer CHAT_LOGS = 1;
    public static final Integer JOIN_LOGS = 2;
    public static final Integer QUIT_LOGS = 3;
    /**
     * chat_logs;
     */
    public static final Integer CHAT_LOG_UUID = 0;
    public static final Integer CHAT_LOG_Date = 1;
    public static final Integer CHAT_LOG_Chat = 2;
    /**
     * commands_logs;
     */
    public static final Integer COMMANDS_LOG_UUID = 0;
    public static final Integer COMMANDS_LOG_Date = 1;
    public static final Integer COMMANDS_LOG_Chat = 2;
    /**
     * join_logs";
     */
    public static final Integer JOIN_LOG_UUID = 0;
    public static final Integer JOIN_LOG_Date = 1;
    /**
     * quit_logs;
     */
    public static final Integer QUIT_LOG_UUID = 0;
    public static final Integer QUIT_LOG_Date = 1;
    /**
     * Dla Player Bans
     */
    public static final Integer PLAYER_BAN_UUID = 0;
    public static final Integer BANNER = 1;
    public static final Integer COMMENT = 2;
    public static final Integer BAN_DATE = 3;
    public static final Integer BAN_TIME = 4;
    /**
     * Players Mute
     */
    public static final Integer PLAYER_MUTE_UUID = 0;
    public static final Integer MUTER = 1;
    public static final Integer MUTE_TIME = 2;
    public static final Integer VANISH_PLAYER_UUID = 0;
    /**
     * Maintenance mode
     */
    public static final Integer MAINTENANCE_PLAYER_UUID = 0;
    /**
     * commandIdentifiersTable
     */
    public static final Integer COMMAND_IDENTIFIES_NAME = 0;
    /**
     * Tables Names
     */
    private final String players_table = "players";
    private final String frozenPlayersTable = "frozen_players";
    private final String playerBansTable = "playerBans";
    private final String playersMutesTable = "playersMutes";
    private final String chatLogsTable = "chat_logs";
    private final String commandsLogsTable = "commands_logs";
    private final String joinLogsTable = "join_logs";
    private final String quitLogsTable = "quit_logs";
    /**
     * Vanish
     */
    private final String vanishTable = "vanishTable";
    /**
     * Maintenance mode
     */
    private final String maintenanceModeTable = "maintenanceTable";
    /**
     * Maintenance mode ON/OFF
     */
    private final String maintenanceModeSwitchTable = "maintenanceSwitchTable";
    private final String maintMode = "maintenance";
    /**
     * commands manager Tables;
     */
    private final String commandsIdentifiersTable = "commandIdentifiersTable";
    private final String commandLabelTable = "commandLabelTable";
    private final String commandAddedNameTable = "commandAddedNameTable";
    private final String commandRemovedNameTable = "commandRemovedNameTable";
    /**
     * chat_logs;
     */
    String chatLogUUID = "playerUUID";
    String chatLogDate = "logDate";
    String chatLogChat = "chat";
    /**
     * commands_logs;
     */
    String commandsLogUUID = "playerUUID";
    String commandsLogDate = "logDate";
    String commandsLogChat = "command";
    /**
     * join_logs";
     */
    String joinLogUUID = "playerUUID";
    String joinLogDate = "joinDate";
    /**
     * quit_logs;
     */
    String quitLogUUID = "playerUUID";
    String quitLogDate = "quitDate";
    /**
     * players_table
     */
    String playerUUID = "playerUUID";
    /**
     * playerBansTable
     */
    String banTime = "banTime";
    String banner = "banner";
    String comment = "comment";
    String banDate = "banDate";
    /**
     * Players Mutes
     */
    String muter = "muter";
    String muteTime = "muteTime";
    String commandsIdentifiersName = "commandName";
    /**
     * labelTable
     */
    String commandLabelIdentifier = "commandName";
    String commandLabelAlias = "commandLabelAlias";
    /**
     * disabledCommandsTable
     */
    String commandRemovedNameIdentifier = "commandName";
    String commandRemovedNameAlias = "commandDisableId";
    /**
     * enabledCommandsTable
     */
    String commandAddedNameIdentifier = "commandName";
    String commandAddedNameAlias = "commandEnableId";
    /**
     * DisableChat
     */
    String disableChatTable = "disable_chat_table";
    String disableChatValue = "disableChatValue";
    /**
     * ControllingPlayersTable
     */
    String controllingPlayersTable = "spectatingPlayersTable";
    String controllingPlayerUUID = "spectatingPlayerUUID";
    String controlledPlayerUUID = "controlledPlayerUUID";
    String controllerLastWorldUUID = "spectatorLastWorldUUID";
    String isControlling = "isControlling";
    String lastGameMode = "lastGamemode";
    String x = "x";
    String y = "y";
    String z = "z";
    String pitch = "pitch";
    String yaw = "yaw";


    public void init() {
        super.init("AdminGui");
        CheckIfDatabaseExists();
        createCommandsIdentifiersTable(commandsIdentifiersTable, commandsIdentifiersName);
        createCommandLabelTable(commandLabelTable, commandLabelIdentifier, commandLabelAlias);
        createCommandAddedNameTable(commandAddedNameTable, commandAddedNameIdentifier, commandAddedNameAlias);
        createCommandRemovedNameTable(commandRemovedNameTable, commandRemovedNameIdentifier, commandRemovedNameAlias);
        createChatLogsTable(chatLogsTable, chatLogUUID, chatLogDate, chatLogChat);
        createCommandsLogsTable(commandsLogsTable, commandsLogUUID, commandsLogDate, commandsLogChat);
        createJoinLogsTable(joinLogsTable, joinLogUUID, joinLogDate);
        createQuitLogsTable(quitLogsTable, quitLogUUID, quitLogDate);
        createPlayers_DataTable(players_table, playerUUID);
        createFrozenPlayersTable(frozenPlayersTable, playerUUID);
        createPlayersBansTable(playerBansTable, playerUUID, banner, comment, banDate, banTime);
        createPlayersMuteTable(playersMutesTable, playerUUID, muter, muteTime);
        createVanishTable(vanishTable, playerUUID);
        createMaintenanceTable(maintenanceModeTable, playerUUID);
        createMaintenanceSwitchTable(maintenanceModeSwitchTable, maintMode);
        createDisableChatTable(disableChatTable, disableChatValue);
        createControllingPlayersTable(controllingPlayersTable, controllingPlayerUUID,controlledPlayerUUID,isControlling, lastGameMode, controllerLastWorldUUID, x, y, z ,pitch, yaw);
    }

    private void createControllingPlayersTable(String spectatingPlayersTable, String spectatingPlayerUUID, String controlledPlayerUUID, String isControlling, String lastGamemode, String spectatorLastWorldUUID, String x, String y, String z, String pitch, String yaw) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + spectatingPlayersTable + " (" + spectatingPlayerUUID + " wibblewibble NOT NULL, "+ controlledPlayerUUID + " wibblewibble NOT NULL, " + isControlling + " INTEGER NOT NULL, " + lastGamemode + " TEXT NOT NULL, " + spectatorLastWorldUUID + " wibblewibble NOT NULL, "+ x + "  REAL NOT NULL, " + y + "  REAL NOT NULL, " + z + " REAL NOT NULL, " + pitch + "  REAL NOT NULL, " + yaw + "  REAL NOT NULL);" ;
        createTable(saleable, this.databaseUrl);
    }

    private void createDisableChatTable(String disableChatTable, String disableChatValue) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + disableChatTable + " (" + disableChatValue + " wibblewibble NOT NULL " + ");";
        createTable(saleable, this.databaseUrl);
    }

    private void createCommandsIdentifiersTable(String tableName, String commandIdentifiersID) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + commandIdentifiersID + " TEXT NOT NULL " + ");";
        createTable(saleable, this.databaseUrl);
    }

    private void createCommandLabelTable(String tableName, String commandLabelId, String commandLabelValue) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + commandLabelId + " TEXT NOT NULL, "
                + commandLabelValue + " TEXT NOT NULL " + ");";
        createTable(saleable, this.databaseUrl);
    }

    private void createCommandAddedNameTable(String tableName, String commandNameId, String commandNameValue) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + commandNameId + " TEXT NOT NULL, "
                + commandNameValue + " TEXT NOT NULL " + ");";
        createTable(saleable, this.databaseUrl);
    }

    private void createCommandRemovedNameTable(String tableName, String commandNameId, String commandNameValue) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + commandNameId + " TEXT NOT NULL, "
                + commandNameValue + " TEXT NOT NULL " + ");";
        createTable(saleable, this.databaseUrl);
    }

    private void createChatLogsTable(String tableName, String playerUUID, String logDate, String chat) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL, "
                + logDate + " timestamp NOT NULL, " + chat + " TEXT NOT NULL " + ");";
        createTable(saleable, this.databaseUrl);
    }

    private void createCommandsLogsTable(String tableName, String playerUUID, String logDate, String command) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL, "
                + logDate + " timestamp NOT NULL, " + command + " TEXT NOT NULL " + ");";
        createTable(saleable, this.databaseUrl);
    }

    private void createJoinLogsTable(String tableName, String playerUUID, String joinDate) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL, "
                + joinDate + " timestamp NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    private void createQuitLogsTable(String tableName, String playerUUID, String quitDate) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL, "
                + quitDate + " timestamp NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    private void createMaintenanceSwitchTable(String tableName, String playerUUID) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    private void createMaintenanceTable(String tableName, String playerUUID) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    private void createVanishTable(String tableName, String playerUUID) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    private void createPlayers_DataTable(String tableName, String playerUUID) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " wibblewibble NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    public void createFrozenPlayersTable(String tableName, String playerUUID) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " TEXT NOT NULL);";
        createTable(saleable, this.databaseUrl);
    }

    public void createPlayersBansTable(String tableName, String playerUUID, String banner, String comment, String banDate, String banTime) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " TEXT NOT NULL , " + banner + " TEXT NOT NULL , " + comment + " TEXT NOT NULL , " + banDate + " INTEGER NOT NULL , " + banTime + " INTEGER NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    public void createPlayersMuteTable(String tableName, String playerUUID, String muter, String muteTime) {
        String saleable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + playerUUID + " TEXT NOT NULL , " + muter + " TEXT NOT NULL , " + muteTime + " INTEGER NOT NULL );";
        createTable(saleable, this.databaseUrl);
    }

    public void insertControllingPlayer(Player player, Player controlledPlayer, Integer isControlling) {
        String sql = "INSERT INTO " + controllingPlayersTable + " (" + controllingPlayerUUID + ", " + controlledPlayerUUID + ", " + this.isControlling +  ", " + lastGameMode + ", " + controllerLastWorldUUID + ", " + x + ", " + y + ", " + z + ", " + pitch + ", " + yaw + ") VALUES(?,?,?,?,?,?,?,?,?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, player.getUniqueId().toString());
            pstmt.setString(2, controlledPlayer.getUniqueId().toString());
            pstmt.setInt(3,isControlling);
            pstmt.setString(4, player.getGameMode().name());
            pstmt.setString(5, String.valueOf(player.getLocation().getWorld().getUID()));
            pstmt.setDouble(6, player.getLocation().getX());
            pstmt.setDouble(7, player.getLocation().getY());
            pstmt.setDouble(8, player.getLocation().getZ());
            pstmt.setFloat(9, player.getLocation().getPitch());
            pstmt.setFloat(10, player.getLocation().getYaw());
        }, sql);
    }

    public void updateControllingPlayer(Player controlledPlayer, Integer isControlling) {
        String sql = "UPDATE " + controllingPlayersTable + " SET " + this.isControlling + " = ? WHERE " + this.controlledPlayerUUID   + " = ?";
        insertSomething(pstmt -> {
            pstmt.setInt(1, isControlling);
            pstmt.setString(2, controlledPlayer.getUniqueId().toString());
        },sql);
    }

    public void changeIntoCommandsLabelTable(String commandLabelId, String commandLabelAlias) {
        String sql = "UPDATE " + commandLabelTable + " SET " + this.commandLabelAlias
                + " = '" + commandLabelAlias + "' WHERE " + this.commandLabelIdentifier
                + " = '" + commandLabelId + "" +
                "'";
        boolean insert = false;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (pstmt.executeUpdate() == 0)
                insert = true;
            close(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (insert) this.insertIntoCommandsLabelTable(commandLabelId, commandLabelAlias);
    }

    public void insertIntoCommandsIdentifiersTable(String commandIdentifiersName) {
        String sql = "INSERT INTO " + commandsIdentifiersTable + " (" + commandsIdentifiersName + ") VALUES(?)";
        insertSomething(pstmt -> pstmt.setString(1, commandIdentifiersName), sql);
    }

    private void insertIntoCommandsLabelTable(String commandLabelId, String commandLabelAlias) {
        String sql = "INSERT INTO  " + commandLabelTable + " (" + this.commandLabelIdentifier + ", " + this.commandLabelAlias + ") VALUES(?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, commandLabelId);
            pstmt.setString(2, commandLabelAlias);
        }, sql);
    }

    public void insertIntoAddedCommandsTable(String commandEnabledId, String commandEnabledAlias) {
        String sql = "INSERT INTO  " + commandAddedNameTable + " (" + this.commandAddedNameIdentifier + ", " + this.commandAddedNameAlias + ") VALUES(?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, commandEnabledId);
            pstmt.setString(2, commandEnabledAlias);
        }, sql);
    }

    public void insertIntoRemovedCommandsTable(String commandDisabledId, String commandDisabledAlias) {
        String sql = "INSERT INTO  " + commandRemovedNameTable + " (" + this.commandRemovedNameIdentifier + ", " + this.commandRemovedNameAlias + ") VALUES(?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, commandDisabledId);
            pstmt.setString(2, commandDisabledAlias);
        }, sql);
    }

    public void insertIntoChatLogsTable(String playerUUID, java.sql.Timestamp logDate, String chat) {
        String sql = "INSERT INTO  " + chatLogsTable + " (" + chatLogUUID + ", " + chatLogDate + ", " + chatLogChat + ") VALUES(?,?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, playerUUID);
            pstmt.setTimestamp(2, logDate);
            pstmt.setString(3, chat);
        }, sql);
    }

    public void insertIntoCommandsLogsTable(String playerUUID, java.sql.Timestamp logDate, String command) {
        String sql = "INSERT INTO  " + commandsLogsTable + " (" + commandsLogUUID + ", " + commandsLogDate + ", " + commandsLogChat + ") VALUES(?,?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, playerUUID);
            pstmt.setTimestamp(2, logDate);
            pstmt.setString(3, command);
        }, sql);
    }

    public void insertIntoJoinLogsTable(String playerUUID, java.sql.Timestamp logDate) {
        String sql = "INSERT INTO  " + joinLogsTable + " (" + joinLogUUID + ", " + joinLogDate + ") VALUES(?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, playerUUID);
            pstmt.setTimestamp(2, logDate);
        }, sql);
    }

    public void insertIntoQuitLogsTable(String playerUUID, java.sql.Timestamp logDate) {
        String sql = "INSERT INTO  " + quitLogsTable + " (" + quitLogUUID + ", " + quitLogDate + ") VALUES(?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, playerUUID);
            pstmt.setTimestamp(2, logDate);
        }, sql);
    }

    public void insertIntoMaintenanceSwitchTable(int value) {
        String sql = "INSERT INTO  " + maintenanceModeSwitchTable + " (" + this.maintMode + ") VALUES(?)";
        insertSomething(pstmt -> pstmt.setInt(1, value), sql);
    }

    public void insertIntoDisableChatTableSwitchTable(int value) {
        String sql = "INSERT INTO  " + disableChatTable + " (" + this.disableChatValue + ") VALUES(?)";
        insertSomething(pstmt -> pstmt.setInt(1, value), sql);
    }

    public void insertIntoMaintenanceTable(String playerUUID) {
        String sql = "INSERT INTO " + maintenanceModeTable + " (" + this.playerUUID + ") VALUES(?)";
        insertSomething(pstmt -> pstmt.setString(1, playerUUID), sql);
    }

    public void insertIntoVanishTable(String playerUUID) {
        String sql = "INSERT INTO " + vanishTable + " (" + this.playerUUID + ") VALUES(?)";
        insertSomething(pstmt -> pstmt.setString(1, playerUUID), sql);
    }

    public boolean insertDataIntoFrozenPlayersTable(String playerUUID) {
        String sql = "INSERT INTO " + this.frozenPlayersTable + "(" + this.playerUUID + ") VALUES(?)";
        insertSomething(pstmt -> pstmt.setString(1, playerUUID), sql);
        return false;
    }

    public void insertDataIntoPlayersBanTable(String playerUUID, String banner, String comment, long banDate, long banTime) {
        String sql = "INSERT INTO " + this.playerBansTable + "(" + this.playerUUID + ", " + this.banner + ", " + this.comment + ", " + this.banDate + ", " + this.banTime + ") VALUES(?,?,?,?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, playerUUID);
            pstmt.setString(2, banner);
            pstmt.setString(3, comment);
            pstmt.setLong(4, banDate);
            pstmt.setLong(5, banTime);
        }, sql);
    }

    public void insertDataIntoPlayersMutesTable(String playerUUID, String muter, long muteTime) {
        String sql = "INSERT INTO " + this.playersMutesTable + "(" + this.playerUUID + ", " + this.muter + ", " + this.muteTime + ") VALUES(?,?,?)";
        insertSomething(pstmt -> {
            pstmt.setString(1, playerUUID);
            pstmt.setString(2, muter);
            pstmt.setLong(3, muteTime);
        }, sql);
    }

    public List<String> getCommandIdentifiers() {
        String sql = "SELECT * FROM " + commandsIdentifiersTable;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> commandsIdentifiersList = new ArrayList<>();
            while (rs.next()) {
                commandsIdentifiersList.add(COMMAND_IDENTIFIES_NAME, rs.getString(commandsIdentifiersName));
            }
            return commandsIdentifiersList;
        }, sql);
    }

    public List<Pair<String, String>> getCommandLabels() {
        String sql = "SELECT * FROM " + commandLabelTable;
        return new Worker<List<Pair<String, String>>>().getSomething(rs -> {
            List<Pair<String, String>> commandsLabelList = new ArrayList<>();
            while (rs.next()) {
                Pair<String, String> labels = new Pair<>(rs.getString(commandLabelIdentifier), rs.getString(commandLabelAlias));
                commandsLabelList.add(labels);
            }
            return commandsLabelList;
        }, sql);
    }

    public List<Pair<String, String>> getCommandAddedAliases() {
        String sql = "SELECT * FROM " + commandAddedNameTable;
        return new Worker<List<Pair<String, String>>>().getSomething(rs -> {
            List<Pair<String, String>> commandsAddedAliasList = new ArrayList<>();
            while (rs.next()) {
                Pair<String, String> labels = new Pair<>(rs.getString(commandAddedNameIdentifier), rs.getString(commandAddedNameAlias));
                commandsAddedAliasList.add(labels);
            }
            return commandsAddedAliasList;
        }, sql);
    }

    public List<Pair<String, String>> getCommandRemovedAliases() {
        String sql = "SELECT * FROM " + commandRemovedNameTable;
        return new Worker<List<Pair<String, String>>>().getSomething(rs -> {
            List<Pair<String, String>> commandsRemovedAliasList = new ArrayList<>();
            while (rs.next()) {
                Pair<String, String> labels = new Pair<>(rs.getString(commandRemovedNameIdentifier), rs.getString(commandRemovedNameAlias));
                commandsRemovedAliasList.add(labels);
            }
            return commandsRemovedAliasList;
        }, sql);
    }

    public List<List<String>> getLogsByDate(long startDate, long endDate) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(COMMANDS_LOGS, getCommandsLogsByDateInterval(startDate, endDate));
        logs.add(CHAT_LOGS, getChatLogsByDateInterval(startDate, endDate));
        logs.add(JOIN_LOGS, getJoinLogsByDateInterval(startDate, endDate));
        logs.add(QUIT_LOGS, getQuitLogsByDateInterval(startDate, endDate));
        return logs;
    }

    public List<List<String>> getLogsByUuidAndDate(String uuid, long startDate, long endDate) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(COMMANDS_LOGS, getCommandsLogsByUuidAndDateInterval(uuid, startDate, endDate));
        logs.add(CHAT_LOGS, getChatLogsByUuidAndDateInterval(uuid, startDate, endDate));
        logs.add(JOIN_LOGS, getJoinLogsByUuidAndDateInterval(uuid, startDate, endDate));
        logs.add(QUIT_LOGS, getQuitLogsByUuidAndDateInterval(uuid, startDate, endDate));
        return logs;
    }

    public List<List<String>> getLogsByDay(long day) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(COMMANDS_LOGS, getCommandsLogsByDay(day));
        logs.add(CHAT_LOGS, getChatLogsByDay(day));
        logs.add(JOIN_LOGS, getJoinLogsByDay(day));
        logs.add(QUIT_LOGS, getQuitLogsByDay(day));
        return logs;
    }

    public List<List<String>> getLogsByUuidAndDay(String uuid, long day) {
        List<List<String>> logs = new ArrayList<>();
        logs.add(COMMANDS_LOGS, getCommandsLogsByUuidAndDay(uuid, day));
        logs.add(CHAT_LOGS, getChatLogsByUuidAndDay(uuid, day));
        logs.add(JOIN_LOGS, getJoinLogsByUuidAndDay(uuid, day));
        logs.add(QUIT_LOGS, getQuitLogsByUuidAndDay(uuid, day));
        return logs;
    }

    public List<String> getCommandsLogsByDateInterval(long startDate, long endDate) {
        String sql = "SELECT * FROM " + commandsLogsTable + " WHERE " + commandsLogDate + " BETWEEN " + startDate + " AND " + endDate;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> commandsList = new ArrayList<>();
            while (rs.next()) {
                commandsList.add(COMMANDS_LOG_UUID, rs.getString(commandsLogUUID));
                commandsList.add(COMMANDS_LOG_Date, String.valueOf(rs.getTimestamp(commandsLogDate)));
                commandsList.add(COMMANDS_LOG_Chat, rs.getString(commandsLogChat));
            }
            return commandsList;
        }, sql);
    }

    public List<String> getChatLogsByDateInterval(long startDate, long endDate) {
        String sql = "SELECT * FROM " + chatLogsTable + " WHERE " + chatLogDate + " BETWEEN " + startDate + " AND " + endDate;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> chatLogs = new ArrayList<>();
            while (rs.next()) {
                chatLogs.add(CHAT_LOG_UUID, rs.getString(chatLogUUID));
                chatLogs.add(CHAT_LOG_Date, String.valueOf(rs.getTimestamp(chatLogDate)));
                chatLogs.add(CHAT_LOG_Chat, rs.getString(chatLogChat));
            }
            return chatLogs;
        }, sql);
    }

    public List<String> getJoinLogsByDateInterval(long startDate, long endDate) {
        String sql = "SELECT * FROM " + joinLogsTable + " WHERE " + joinLogDate + " BETWEEN " + startDate + " AND " + endDate;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> joinsList = new ArrayList<>();
            while (rs.next()) {
                joinsList.add(JOIN_LOG_UUID, rs.getString(joinLogUUID));
                joinsList.add(JOIN_LOG_Date, String.valueOf(rs.getTimestamp(joinLogDate)));
            }
            return joinsList;
        }, sql);
    }

    public List<String> getQuitLogsByDateInterval(long startDate, long endDate) {
        String sql = "SELECT * FROM " + quitLogsTable + " WHERE " + quitLogDate + " BETWEEN " + startDate + " AND " + endDate;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> quitsList = new ArrayList<>();
            while (rs.next()) {
                quitsList.add(QUIT_LOG_UUID, rs.getString(quitLogUUID));
                quitsList.add(QUIT_LOG_Date, String.valueOf(rs.getTimestamp(quitLogDate)));
            }
            return quitsList;
        }, sql);
    }

    public List<String> getCommandsLogsByUuidAndDateInterval(String uuid, long startDate, long endDate) {
        String sql = "SELECT * FROM " + commandsLogsTable + " WHERE " + commandsLogDate + " BETWEEN " + startDate + " AND " + endDate + " AND " + commandsLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> commandsList = new ArrayList<>();
            while (rs.next()) {
                commandsList.add(COMMANDS_LOG_UUID, rs.getString(commandsLogUUID));
                commandsList.add(COMMANDS_LOG_Date, String.valueOf(rs.getTimestamp(commandsLogDate)));
                commandsList.add(COMMANDS_LOG_Chat, rs.getString(commandsLogChat));
            }
            return commandsList;
        }, sql);
    }

    public List<String> getChatLogsByUuidAndDateInterval(String uuid, long startDate, long endDate) {
        String sql = "SELECT * FROM " + chatLogsTable + " WHERE " + chatLogDate + " BETWEEN " + startDate + " AND " + endDate + " AND " + this.chatLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> chatLogs = new ArrayList<>();
            while (rs.next()) {
                chatLogs.add(CHAT_LOG_UUID, rs.getString(chatLogUUID));
                chatLogs.add(CHAT_LOG_Date, String.valueOf(rs.getTimestamp(chatLogDate)));
                chatLogs.add(CHAT_LOG_Chat, rs.getString(chatLogChat));
            }
            return chatLogs;
        }, sql);
    }

    public Map<UUID, SpectatingPlayer> getAllControlingPlayers() {
        String sql = "SELECT * FROM " + controllingPlayersTable;
        return new Worker<Map<UUID, SpectatingPlayer>>().getSomething(rs -> {
            Map<UUID, SpectatingPlayer> spectatingPlayers = new HashMap<>();
            while (rs.next()) {
                UUID playerUUID = UUID.fromString(rs.getString(this.controllingPlayerUUID));
                Location location = new Location(
                        Bukkit.getWorld(UUID.fromString(rs.getString(this.controllerLastWorldUUID))),
                        rs.getDouble(this.x),
                        rs.getDouble(this.y),
                        rs.getDouble(this.z),
                        rs.getFloat(this.yaw),
                        rs.getFloat(this.pitch)
                );
                SpectatingPlayer spectatingPlayer = new SpectatingPlayer(
                        UUID.fromString(rs.getString(this.controlledPlayerUUID)),
                        playerUUID,
                        rs.getInt(this.isControlling),
                        rs.getString(this.lastGameMode),
                        location
                );

                spectatingPlayers.put(playerUUID, spectatingPlayer);
            }
            return spectatingPlayers;
        },sql);
    }

    public List<String> getJoinLogsByUuidAndDateInterval(String uuid, long startDate, long endDate) {
        String sql = "SELECT * FROM " + joinLogsTable + " WHERE " + joinLogDate + " BETWEEN " + startDate + " AND " + endDate + " AND " + this.joinLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> joinsList = new ArrayList<>();
            while (rs.next()) {
                joinsList.add(JOIN_LOG_UUID, rs.getString(joinLogUUID));
                joinsList.add(JOIN_LOG_Date, String.valueOf(rs.getTimestamp(joinLogDate)));
            }
            return joinsList;
        }, sql);
    }

    public List<String> getQuitLogsByUuidAndDateInterval(String uuid, long startDate, long endDate) {
        String sql = "SELECT * FROM " + quitLogsTable + " WHERE " + quitLogDate + " BETWEEN " + startDate + " AND " + endDate + " AND " + this.quitLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> quitsList = new ArrayList<>();
            while (rs.next()) {
                quitsList.add(QUIT_LOG_UUID, rs.getString(quitLogUUID));
                quitsList.add(QUIT_LOG_Date, String.valueOf(rs.getTimestamp(quitLogDate)));
            }
            return quitsList;
        }, sql);
    }

    public List<String> getCommandsLogsByDay(long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + commandsLogsTable + " WHERE " + commandsLogDate + " BETWEEN " + day + " AND " + endOfDay;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> commandsList = new ArrayList<>();
            while (rs.next()) {
                commandsList.add(COMMANDS_LOG_UUID, rs.getString(commandsLogUUID));
                commandsList.add(COMMANDS_LOG_Date, String.valueOf(rs.getTimestamp(commandsLogDate)));
                commandsList.add(COMMANDS_LOG_Chat, rs.getString(commandsLogChat));
            }
            return commandsList;
        }, sql);
    }

    public List<String> getChatLogsByDay(long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + chatLogsTable + " WHERE " + chatLogDate + " BETWEEN " + day + " AND " + endOfDay;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> chatLogs = new ArrayList<>();
            while (rs.next()) {
                chatLogs.add(CHAT_LOG_UUID, rs.getString(chatLogUUID));
                chatLogs.add(CHAT_LOG_Date, String.valueOf(rs.getTimestamp(chatLogDate)));
                chatLogs.add(CHAT_LOG_Chat, rs.getString(chatLogChat));
            }
            return chatLogs;
        }, sql);
    }

    public List<String> getJoinLogsByDay(long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + joinLogsTable + " WHERE " + joinLogDate + " BETWEEN " + day + " AND " + endOfDay;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> joinsList = new ArrayList<>();
            while (rs.next()) {
                joinsList.add(JOIN_LOG_UUID, rs.getString(joinLogUUID));
                joinsList.add(JOIN_LOG_Date, String.valueOf(rs.getTimestamp(joinLogDate)));
            }
            return joinsList;
        }, sql);
    }

    public List<String> getQuitLogsByDay(long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + quitLogsTable + " WHERE " + quitLogDate + " BETWEEN " + day + " AND " + endOfDay;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> quitsList = new ArrayList<>();
            while (rs.next()) {
                quitsList.add(QUIT_LOG_UUID, rs.getString(quitLogUUID));
                quitsList.add(QUIT_LOG_Date, String.valueOf(rs.getTimestamp(quitLogDate)));
            }
            return quitsList;
        }, sql);
    }

    public List<String> getCommandsLogsByUuidAndDay(String uuid, long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + commandsLogsTable + " WHERE " + commandsLogDate + " BETWEEN " + day + " AND " + endOfDay + " AND " + commandsLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> commandsList = new ArrayList<>();
            while (rs.next()) {
                commandsList.add(COMMANDS_LOG_UUID, rs.getString(commandsLogUUID));
                commandsList.add(COMMANDS_LOG_Date, String.valueOf(rs.getTimestamp(commandsLogDate)));
                commandsList.add(COMMANDS_LOG_Chat, rs.getString(commandsLogChat));
            }
            return commandsList;
        }, sql);
    }

    public List<String> getChatLogsByUuidAndDay(String uuid, long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + chatLogsTable + " WHERE " + chatLogDate + " BETWEEN " + day + " AND " + endOfDay + " AND " + this.chatLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> chatLogs = new ArrayList<>();
            while (rs.next()) {
                chatLogs.add(CHAT_LOG_UUID, rs.getString(chatLogUUID));
                chatLogs.add(CHAT_LOG_Date, String.valueOf(rs.getTimestamp(chatLogDate)));
                chatLogs.add(CHAT_LOG_Chat, rs.getString(chatLogChat));
            }
            return chatLogs;
        }, sql);
    }

    public List<String> getJoinLogsByUuidAndDay(String uuid, long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + joinLogsTable + " WHERE " + joinLogDate + " BETWEEN " + day + " AND " + endOfDay + " AND " + this.joinLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> joinsList = new ArrayList<>();
            while (rs.next()) {
                joinsList.add(JOIN_LOG_UUID, rs.getString(joinLogUUID));
                joinsList.add(JOIN_LOG_Date, String.valueOf(rs.getTimestamp(joinLogDate)));
            }
            return joinsList;
        }, sql);
    }

    public List<String> getQuitLogsByUuidAndDay(String uuid, long day) {
        long endOfDay = day + 86400000L;
        String sql = "SELECT * FROM " + quitLogsTable + " WHERE " + quitLogDate + " BETWEEN " + day + " AND " + endOfDay + " AND " + this.quitLogUUID + " = " + "\"" + uuid + "\"";
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> quitsList = new ArrayList<>();
            while (rs.next()) {
                quitsList.add(QUIT_LOG_UUID, rs.getString(quitLogUUID));
                quitsList.add(QUIT_LOG_Date, String.valueOf(rs.getTimestamp(quitLogDate)));
            }
            return quitsList;
        }, sql);
    }

    public int getMaintenanceModeSwitched() {
        String sql = "SELECT * FROM " + maintenanceModeSwitchTable;
        int switched = 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            switched = rs.getInt(this.maintMode);
            close(pstmt);
        } catch (SQLException ignored) {

        }
        return switched;
    }

    public int getDisableChatSwitched() {
        String sql = "SELECT * FROM " + disableChatTable;
        int switched = 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            switched = rs.getInt(this.disableChatValue);
            close(pstmt);
        } catch (SQLException ignored) {
        }
        return switched;
    }

    public boolean getCommandIdentifierAddedNameExists(String commandsIdentifiersId) {
        String sql = "SELECT * FROM " + commandAddedNameTable + " WHERE " + this.commandAddedNameIdentifier + " = " + "\"" + commandsIdentifiersId + "\"";
        return new Worker<Boolean>().getSomething(ResultSet::next, sql);
    }

    public boolean getCommandIdentifierRemovedNameExists(String commandsIdentifiersId) {
        String sql = "SELECT * FROM " + commandRemovedNameTable + " WHERE " + this.commandRemovedNameIdentifier + " = " + "\"" + commandsIdentifiersId + "\"";
        return new Worker<Boolean>().getSomething(ResultSet::next, sql);
    }

    public List<String> getMaintenancePlayers() {
        String sql = "SELECT * FROM " + maintenanceModeTable;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> maintenancePlayers = new ArrayList<>();
            while (rs.next()) {
                maintenancePlayers.add(MAINTENANCE_PLAYER_UUID, rs.getString(this.playerUUID));
            }
            return maintenancePlayers;
        }, sql);
    }

    public List<String> getVanishedPlayers() {
        String sql = "SELECT * FROM " + vanishTable;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> vanishedPlayers = new ArrayList<>();
            while (rs.next()) {
                vanishedPlayers.add(VANISH_PLAYER_UUID, rs.getString(this.playerUUID));
            }
            return vanishedPlayers;
        }, sql);
    }

    public List<String> getFrozenPlayersList() {
        String sql = "SELECT * FROM " + this.frozenPlayersTable;
        return new Worker<List<String>>().getSomething(rs -> {
            List<String> frozenPlayersList = new ArrayList<>();
            while (rs.next()) {
                frozenPlayersList.add(rs.getString(this.playerUUID));
            }
            return frozenPlayersList;
        }, sql);
    }

    public long getBanTime(String playerUUID) {
        String sql = "SELECT * FROM " + playerBansTable + " WHERE " + this.playerUUID + " = " + "\"" + playerUUID + "\"";
        return new Worker<Long>().getSomething(rs -> {
            if (playerUUID.equals(rs.getString(this.playerUUID))) {
                return rs.getLong(this.banTime);
            }
            return (long) 0;
        }, sql);
    }

    public List<List<String>> getAllBanned() {
        String sql = "SELECT * FROM " + playerBansTable;
        return new Worker<List<List<String>>>().getSomething(rs -> {
            List<List<String>> playerBanDataList = new ArrayList<>();
            while (rs.next()) {
                List<String> playerBanData = new ArrayList<>();
                playerBanData.add(PLAYER_BAN_UUID, rs.getString(this.playerUUID));
                playerBanData.add(BANNER, rs.getString(this.banner));
                playerBanData.add(COMMENT, rs.getString(this.comment));
                playerBanData.add(BAN_DATE, rs.getString(this.banDate));
                playerBanData.add(BAN_TIME, rs.getString(this.banTime));
                playerBanDataList.add(playerBanData);
            }
            return playerBanDataList;
        }, sql);
    }

    public List<List<String>> getAllMuted() {
        String sql = "SELECT * FROM " + playersMutesTable;
        return new Worker<List<List<String>>>().getSomething(rs -> {
            List<List<String>> playerMutesDataList = new ArrayList<>();
            while (rs.next()) {
                List<String> playersMuteData = new ArrayList<>();
                playersMuteData.add(PLAYER_MUTE_UUID, rs.getString(this.playerUUID));
                playersMuteData.add(MUTER, rs.getString(this.muter));
                playersMuteData.add(MUTE_TIME, rs.getString(this.muteTime));
                playerMutesDataList.add(playersMuteData);
            }
            return playerMutesDataList;
        }, sql);
    }

    public void clearAllCommandsTables() {
        String sql1 = "DELETE FROM " + commandsIdentifiersTable;
        String sql2 = "DELETE FROM " + commandLabelTable;
        String sql3 = "DELETE FROM " + commandAddedNameTable;
        String sql4 = "DELETE FROM " + commandRemovedNameTable;
        delete(sql1);
        delete(sql2);
        delete(sql3);
        delete(sql4);
    }

    public void deleteCommandIdentifiersLabel(String commandIdentifierName) {
        String sql = "DELETE FROM " + this.commandLabelTable + " WHERE " + this.commandLabelIdentifier + " = " + "\"" + commandIdentifierName + "\"";
        delete(sql);
    }

    public void deleteCommandIdentifiers(String commandIdentifierName) {
        String sql = "DELETE FROM " + this.commandsIdentifiersTable + " WHERE " + this.commandsIdentifiersName + " = " + "\"" + commandIdentifierName + "\"";
        delete(sql);
    }

    public void deleteCommandIdentifiersAddedName(String commandIdentifierName) {
        String sql = "DELETE FROM " + this.commandAddedNameTable + " WHERE " + this.commandAddedNameIdentifier + " = " + "\"" + commandIdentifierName + "\"";
        delete(sql);
    }

    public void deleteCommandIdentifiersRemovedName(String commandIdentifierName) {
        String sql = "DELETE FROM " + this.commandRemovedNameTable + " WHERE " + this.commandRemovedNameIdentifier + " = " + "\"" + commandIdentifierName + "\"";
        delete(sql);
    }

    public void deleteAllOldLogs(int days, long dateInMili) {
        deleteLogsFromCommands(days, dateInMili);
        deleteLogsFromChat(days, dateInMili);
        deleteLogsFromJoin(days, dateInMili);
        deleteLogsFromQuit(days, dateInMili);
    }

    public void deleteLogsFromCommands(int days, long dateInMili) {
        long daysInMilli = dateInMili - (days * 86400000L);
        String sql = "DELETE FROM " + commandsLogsTable + " WHERE " + commandsLogDate + " < " + daysInMilli;
        delete(sql);
    }

    public void deleteLogsFromChat(int days, long dateInMili) {
        long daysInMilli = dateInMili - (days * 86400000L);
        String sql = "DELETE FROM " + chatLogsTable + " WHERE " + chatLogDate + " < " + daysInMilli;
        delete(sql);
    }

    public void deleteLogsFromJoin(int days, long dateInMili) {
        long daysInMilli = dateInMili - (days * 86400000L);
        String sql = "DELETE FROM " + joinLogsTable + " WHERE " + joinLogDate + " < " + daysInMilli;
        delete(sql);
    }

    public void deleteLogsFromQuit(int days, long dateInMili) {
        long daysInMilli = dateInMili - (days * 86400000L);
        String sql = "DELETE FROM " + quitLogsTable + " WHERE " + quitLogDate + " < " + daysInMilli;
        delete(sql);
    }

    public void deleteMaintenanceSwitchValue() {
        String sql = "DELETE FROM " + this.maintenanceModeSwitchTable;
        delete(sql);
    }

    public void deleteDisableChatSwitchValue() {
        String sql = "DELETE FROM " + this.disableChatTable;
        delete(sql);
    }

    public void deleteMeintenencePlayers(String playerUUID) {
        String sql = "DELETE FROM " + this.maintenanceModeTable + " WHERE " + this.playerUUID + " = " + "\"" + playerUUID + "\"";
        delete(sql);
    }

    public void deleteVanishedPlayers(String playerUUID) {
        String sql = "DELETE FROM " + this.vanishTable + " WHERE " + this.playerUUID + " = " + "\"" + playerUUID + "\"";
        delete(sql);
    }

    public boolean deleteFrozenPlayerFromFrozenPlayersTable(String frozenPlayerUUID) {
        String sql = "DELETE FROM " + this.frozenPlayersTable + " WHERE " + this.playerUUID + " = " + "\"" + frozenPlayerUUID + "\"";
        delete(sql);
        return false;
    }

    public void deleteBanFromPlayersBansTable(String playerUUID) {
        String sql = "DELETE FROM " + this.playerBansTable + " WHERE " + this.playerUUID + " = " + "\"" + playerUUID + "\"";
        delete(sql);
    }

    public void deleteBanFromPlayersMutesTable(String playerUUID) {
        String sql = "DELETE FROM " + this.playersMutesTable + " WHERE " + this.playerUUID + " = " + "\"" + playerUUID + "\"";
        delete(sql);
    }

    public void deleteControllingPlayerData(String spectatingPlayerUUID) {
        String sql = "DELETE FROM " + controllingPlayersTable + " WHERE " + this.controllingPlayerUUID + " = " + "\"" + spectatingPlayerUUID + "\"";
        delete(sql);
    }

    public void deleteControllingPlayerDataByWorld(String spectatingPlayerWorldUUID) {
        String sql = "DELETE FROM " + controllingPlayersTable + " WHERE " + this.controllerLastWorldUUID + " = " + "\"" + spectatingPlayerWorldUUID + "\"";
        delete(sql);
    }

    public void delete(String query) {
        try (Connection conn = Database.this.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSomething(DatabaseInsertion operation, String query) {
        try (Connection conn = Database.this.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            operation.insert(pstmt);
            pstmt.executeUpdate();
            close(pstmt);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTable(String query, String databaseUrl) {
        try (Connection conn = DriverManager.getConnection(databaseUrl);
             Statement stmt = conn.createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public interface DatabaseOperation<T> {
        T operate(ResultSet rs) throws SQLException;
    }


    public interface DatabaseInsertion<T> {
        void insert(PreparedStatement pstmt) throws SQLException;
    }

    public class Worker<T> {
        public T getSomething(DatabaseOperation<T> operation, String query) {
            T temp = null;
            try (Connection conn = Database.this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                ResultSet rs = pstmt.executeQuery();
                temp = operation.operate(rs);
                close(pstmt);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return temp;
        }
    }

}
