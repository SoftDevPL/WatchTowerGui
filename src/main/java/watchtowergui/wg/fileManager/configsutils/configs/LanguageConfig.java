package watchtowergui.wg.fileManager.configsutils.configs;

import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.LiteralType;

public class LanguageConfig extends ConfigAccessor {

    private String disabledChat;
    private String commandMenuCommandsHasBeenReset;
    private String commandMenuResetAllCommandsWarning;
    private String commandMenuCommandNotFound;
    private String mesToFrozenPlayer;
    private String mesToFreezer;
    private String mesToReleasedPlayer;
    private String mesToReleaser;
    private String mesPlayerNotFound;
    private String mesPlayerOffline;
    private String mesToPlayerWhoIsFrozen;
    private String bannedPlayer;
    private String valueNotANumber;
    private String banMustBeGreaterThan0;
    private String playerNotExists;
    private String banComment;
    private String enterBanComment;
    private String banCommentCanceled;
    private String thisPlayerIsNotBanned;
    private String banUnBadArgs;
    private String unBannedPlayer;
    private String playerToUnbanNotExists;
    private String banEnterTime;
    private String playerHidden;
    private String playerNotHidden;
    private String youAreHidden;
    private String youAreNotHidden;
    private String spamKickMessage;
    private String spamKickMessageInConsole;
    private String messageForSpammingToPlayer;
    private String muteValueNotANumber;
    private String mutedPlayer;
    private String mutedEarlier;
    private String muteNotExists;
    private String muteEnterTime;
    private String unMuteBadArgs;
    private String unMutedPlayer;
    private String unMutedEarlier;
    private String unMuteNotExists;
    private String muteMessage;
    private String youAreMutedMessage;
    private String onlyPlayerCanExecuteCommand;
    private String playerIsOffline;
    private String playerNotFoundAD;
    private String maintenanceModeMessage;
    private String maintenanceModeOn;
    private String youAreHiddenNow;
    private String playerIsHiddenNow;
    private String maintenanceModeOff;
    private String logsGettingLogs;
    private String logsSuccessfullyDownloaded;
    private String logsEnterMessageForDay;
    private String logsEnterMessageForDate;
    private String logsEnterMessageForDayAndUUID;
    private String logsEnterMessageForDateAndUUID;
    private String logsPlayerNotExists;
    private String logsWrongMessageForDay;
    private String logsWrongMessageForDate;
    private String logsWrongMessageForDayAndUUID;
    private String logsWrongMessageForDateAndUUID;
    private String pluginMenuNotExists;

    public void init() {
        super.init("LanguageConfig", "locale/");
        this.disabledChat = this.getStringPath("General.commands.adminGui.chatisDisabled");
        this.pluginMenuNotExists = this.getStringPath("General.commands.adminGui.pluginMenu.notExists");
        this.logsGettingLogs = this.getStringPath("Logs.gettingLogs");
        this.logsWrongMessageForDay = this.getStringPath("Logs.wrongMessageForDay");
        this.logsWrongMessageForDate = this.getStringPath("Logs.wrongMessageForDate");
        this.logsWrongMessageForDayAndUUID = this.getStringPath("Logs.wrongMessageForDayAndUUID");
        this.logsWrongMessageForDateAndUUID = this.getStringPath("Logs.wrongMessageForDateAndUUID");
        this.logsSuccessfullyDownloaded = this.getStringPath("Logs.successfullyDownloaded");
        this.logsEnterMessageForDay = this.getStringPath("Logs.enterMessageForDay");
        this.logsEnterMessageForDate = this.getStringPath("Logs.enterMessageForDate");
        this.logsEnterMessageForDayAndUUID = this.getStringPath("Logs.enterMessageForDayAndUUID");
        this.logsEnterMessageForDateAndUUID = this.getStringPath("Logs.enterMessageForDateAndUUID");
        this.logsPlayerNotExists = this.getStringPath("Logs.PlayerNotExists");
        this.youAreHiddenNow = this.getStringPath("General.commands.adminGui.youAreHiddenNow");
        this.playerIsHiddenNow = this.getStringPath("General.commands.adminGui.playerIsHiddenNow");
        this.playerHidden = this.getStringPath("General.commands.adminGui.playerHidden");
        this.playerNotHidden = this.getStringPath("General.commands.adminGui.playerNotHidden");
        this.youAreHidden = this.getStringPath("General.commands.adminGui.youAreHidden");
        this.youAreNotHidden = this.getStringPath("General.commands.adminGui.youAreNotHidden");
        this.maintenanceModeOn = this.getStringPath("General.commands.adminGui.maintenanceModeOn");
        this.maintenanceModeOff = this.getStringPath("General.commands.adminGui.maintenanceModeOff");
        this.maintenanceModeMessage = this.getStringPath("General.commands.adminGui.maintenanceModeMessage");
        this.mesToFrozenPlayer = this.getStringPath("General.commands.freeze.freeze.1");
        this.mesToFreezer = this.getStringPath("General.commands.freeze.freeze.2");
        this.mesToReleasedPlayer = this.getStringPath("General.commands.freeze.unfreeze.1");
        this.mesToReleaser = this.getStringPath("General.commands.freeze.unfreeze.2");
        this.mesPlayerNotFound = this.getStringPath("General.commands.freeze.playerNotFound");
        this.mesPlayerOffline = this.getStringPath("General.commands.freeze.offlinePlayerFrozen");
        this.mesToPlayerWhoIsFrozen = this.getStringPath("General.commands.freeze.frozenPlayerMove");
        this.onlyPlayerCanExecuteCommand = this.getStringPath("General.commands.permissions.onlyPlayer");
        this.valueNotANumber = this.getStringPath("General.commands.ban.valueNotANumber");
        this.bannedPlayer = this.getStringPath("General.commands.ban.bannedPlayer");
        this.banMustBeGreaterThan0 = this.getStringPath("General.commands.ban.mustBeGreaterThan0");
        this.playerNotExists = this.getStringPath("General.commands.ban.playerNotExists");
        this.banComment = this.getStringPath("General.commands.ban.banComment");
        this.banCommentCanceled = this.getStringPath("General.commands.ban.banCommentCanceled");
        this.thisPlayerIsNotBanned = this.getStringPath("General.commands.ban.thisPlayerIsNotBanned");
        this.banUnBadArgs = this.getStringPath("General.commands.unBan.banUnBadArgs");
        this.unBannedPlayer = this.getStringPath("General.commands.unBan.unBannedPlayer");
        this.playerToUnbanNotExists = this.getStringPath("General.commands.unBan.playerToUnbanNotExists");
        this.spamKickMessage = this.getStringPath("Chat.spamKickMessage");
        this.spamKickMessageInConsole = this.getStringPath("Chat.spamKickMessageInConsole");
        this.messageForSpammingToPlayer = this.getStringPath("Chat.messageForSpammingToPlayer");
        this.muteMessage = this.getStringPath("General.commands.mute.muteMessage");
        this.youAreMutedMessage = this.getStringPath("General.commands.mute.youAreMutedMessage");
        this.muteValueNotANumber = this.getStringPath("General.commands.mute.muteValueNotANumber");
        this.mutedPlayer = this.getStringPath("General.commands.mute.mutedPlayer");
        this.mutedEarlier = this.getStringPath("General.commands.unmute.unMutedEarlier");
        this.muteNotExists = this.getStringPath("General.commands.mute.muteNotExists");
        this.muteEnterTime = this.getStringPath("General.commands.mute.muteEnterTime");
        this.unMuteBadArgs = this.getStringPath("General.commands.unmute.unmuteBadArgs");
        this.unMutedPlayer = this.getStringPath("General.commands.unmute.unMutedPlayer");
        this.unMutedEarlier = this.getStringPath("General.commands.unmute.unMutedEarlier");
        this.unMuteNotExists = this.getStringPath("General.commands.unmute.unMuteNotExists");
        this.playerIsOffline = this.getStringPath("General.commands.adminGui.playerIsOffline");
        this.enterBanComment = this.getStringPath("General.commands.ban.enterBanComment");
        this.banEnterTime = this.getStringPath("General.commands.ban.enterBanComment");
        this.playerNotFoundAD = this.getStringPath("General.commands.adminGui.playerNotFoundAD");
        this.commandMenuCommandNotFound = this.getStringPath("General.commands.adminGui.commandMenu.notFound");
        this.commandMenuResetAllCommandsWarning = this.getStringPath("General.commands.adminGui.commandMenu.resetAllCommandsWarning");
        this.commandMenuCommandsHasBeenReset = this.getStringPath("General.commands.adminGui.commandMenu.commandsHasBeenReset");
    }

    public String getDisabledChat() {
        return disabledChat;
    }

    public String getPluginMenuNotExists() {
        return pluginMenuNotExists;
    }

    public String getCommandMenuCommandsHasBeenReset() {
        return commandMenuCommandsHasBeenReset;
    }

    public String getCommandMenuResetAllCommandsWarning(String word) {
        return commandMenuResetAllCommandsWarning.replaceAll(LiteralType.COMMAND_LABEL, word);
    }

    public String getCommandMenuCommandNotFound() {
        return commandMenuCommandNotFound;
    }

    public String getLogsGettingLogs() {
        return logsGettingLogs;
    }

    public String getPlayerIsHiddenNow(String player) {
        return this.playerIsHiddenNow.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getLogsSuccessfullyDownloaded() {
        return logsSuccessfullyDownloaded;
    }

    public String getLogsEnterMessageForDay() {
        return logsEnterMessageForDay;
    }

    public String getLogsEnterMessageForDate() {
        return logsEnterMessageForDate;
    }

    public String getLogsEnterMessageForDayAndUUID() {
        return logsEnterMessageForDayAndUUID;
    }

    public String getLogsEnterMessageForDateAndUUID() {
        return logsEnterMessageForDateAndUUID;
    }

    public String getLogsPlayerNotExists(String playerName) {
        return logsPlayerNotExists.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getLogsWrongMessageForDay() {
        return logsWrongMessageForDay;
    }

    public String getLogsWrongMessageForDate() {
        return logsWrongMessageForDate;
    }

    public String getLogsWrongMessageForDayAndUUID() {
        return logsWrongMessageForDayAndUUID;
    }

    public String getLogsWrongMessageForDateAndUUID() {
        return logsWrongMessageForDateAndUUID;
    }

    public String getYouAreHiddenNow() {
        return this.youAreHiddenNow;
    }

    public String getPlayerHidden(String player) {
        return this.playerHidden.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getPlayerNotHidden(String player) {
        return this.playerNotHidden.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getYouAreHidden() {
        return this.youAreHidden;
    }

    public String getYouAreNotHidden() {
        return this.youAreNotHidden;
    }

    public String getMaintenanceModeOn() {
        return maintenanceModeOn;
    }

    public String getMaintenanceModeOff() {
        return maintenanceModeOff;
    }

    public String getMaintenanceModeMessage() {
        return maintenanceModeMessage;
    }

    public String getPlayerNotFoundAD() {
        return playerNotFoundAD;
    }

    public String getBanEnterTime() {
        return banEnterTime;
    }

    public String getEnterBanComment() {
        return enterBanComment;
    }

    public String getBanReasonCom(String banTime, String comment) {
        String mes = this.banComment.replaceAll(LiteralType.BAN_TIME, banTime);
        return mes.replaceAll(LiteralType.COMMENT, comment);
    }

    public String getBanCommentCanceled() {
        return banCommentCanceled;
    }

    public String getThisPlayerIsNotBanned() {
        return thisPlayerIsNotBanned;
    }

    public String getPlayerIsOffline() {
        return playerIsOffline;
    }


    public String getOnlyPlayerCanExecuteCommand() {
        return onlyPlayerCanExecuteCommand;
    }

    public String getMuteMessage(String sender, String date) {
        String mes = this.muteMessage.replaceAll(LiteralType.DATE, date);
        return mes.replaceAll(LiteralType.SENDER, sender);
    }

    public String getYouAreMutedMessage() {
        return this.youAreMutedMessage;
    }


    public String getMuteEnterTime() {
        return muteEnterTime;
    }

    public String getMuteValueNotANumber() {
        return muteValueNotANumber;
    }

    public String getMutedPlayer(String playerName) {
        return mutedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getMutedEarlier(String playerName) {
        return mutedEarlier.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getMuteNotExists(String playerName) {
        return muteNotExists.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getBanUnBadArgs() {
        return unMuteBadArgs;
    }

    public String getUnMutedPlayer(String playerName) {
        return unMutedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getUnMutedEarlier(String playerName) {
        return unMutedEarlier.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getUnMuteNotExists(String playerName) {
        return unMuteNotExists.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getMessageForSpammingToPlayer() {
        return this.messageForSpammingToPlayer;
    }

    public String getSpamKickMessageInConsole(String playerName) {
        return this.spamKickMessageInConsole.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getSpamKickMessage() {
        return this.spamKickMessage;
    }

    public String getUnBanBadArgs() {
        return this.banUnBadArgs;
    }

    public String getUnBannedPlayer(String playerName) {
        return this.unBannedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getPlayerToUnbanNotExists(String playerName) {
        return this.playerToUnbanNotExists.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getValueNotANumber() {
        return this.valueNotANumber;
    }

    public String getBannedPlayer(String playerToBan) {
        return this.bannedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerToBan);
    }

    public String getBanPlayerNotExists(String playerNotExists) {
        return this.playerNotExists.replaceAll(LiteralType.PLAYER_NAME, playerNotExists);
    }

    public String getMesToFrozenPlayer(String freezenerName) {
        return this.mesToFrozenPlayer.replaceAll(LiteralType.PLAYER_NAME, freezenerName);
    }

    public String getMesToFreezener(String frozenPlayerName) {
        return this.mesToFreezer.replaceAll(LiteralType.PLAYER_NAME, frozenPlayerName);
    }

    public String getMesToReleasedPlayer(String releaserName) {
        return this.mesToReleasedPlayer.replaceAll(LiteralType.PLAYER_NAME, releaserName);
    }

    public String getMesToReleaser(String releasedPlayerName) {
        return this.mesToReleaser.replaceAll(LiteralType.PLAYER_NAME, releasedPlayerName);
    }

    public String getMesPlayerNotFound(String notFoundPlayerName) {
        return this.mesPlayerNotFound.replaceAll(LiteralType.PLAYER_NAME, notFoundPlayerName);
    }

    public String getMesPlayerOffline(String offlinePlayerName) {
        return this.mesPlayerOffline.replaceAll(LiteralType.PLAYER_NAME, offlinePlayerName);
    }

    public String getMesToPlayerWhoIsFrozen() {
        return this.mesToPlayerWhoIsFrozen;
    }

    public String getBanMustBeGreaterThan0() {
        return banMustBeGreaterThan0;
    }
}
