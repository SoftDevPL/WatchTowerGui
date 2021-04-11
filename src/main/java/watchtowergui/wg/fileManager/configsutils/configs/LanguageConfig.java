package watchtowergui.wg.fileManager.configsutils.configs;

import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.LiteralType;

public class LanguageConfig extends ConfigAccessor {

    private String basicPlayerNotFoundAD;
    private String basicPlayerNotFound;
    private String basicOnlyPlayerCanExecuteThisCommand;
    private String mesToFrozenPlayer;
    private String mesToFreezer;
    private String mesToReleasedPlayer;
    private String mesToReleaser;
    private String mesPlayerOffline;
    private String mesToPlayerWhoIsFrozen;
    private String bannedPlayer;
    private String valueNotANumber;
    private String banMustBeGreaterThan0;
    private String banComment;
    private String enterBanComment;
    private String banCommentCanceled;
    private String thisPlayerIsNotBanned;
    private String banUnBadArgs;
    private String unBannedPlayer;
    private String banEnterTime;
    private String spamKickMessage;
    private String spamKickMessageInConsole;
    private String messageForSpammingToPlayer;
    private String muteValueNotANumber;
    private String mutedPlayer;
    private String mutedEarlier;
    private String muteEnterTime;
    private String unMuteBadArgs;
    private String unMutedPlayer;
    private String unMutedEarlier;
    private String muteMessage;
    private String youAreMutedMessage;
    private String logsGettingLogs;
    private String logsSuccessfullyDownloaded;
    private String logsEnterMessageForDay;
    private String logsEnterMessageForDate;
    private String logsEnterMessageForDayAndUUID;
    private String logsEnterMessageForDateAndUUID;
    private String logsWrongMessageForDay;
    private String logsWrongMessageForDate;
    private String logsWrongMessageForDayAndUUID;
    private String logsWrongMessageForDateAndUUID;
    private String disabledChat;
    private String commandMenuCommandsHasBeenReset;
    private String commandMenuResetAllCommandsWarning;
    private String commandMenuCommandNotFound;
    private String playerHidden;
    private String playerNotHidden;
    private String youAreHidden;
    private String youAreNotHidden;
    private String maintenanceModeMessage;
    private String maintenanceModeOn;
    private String youAreHiddenNow;
    private String playerIsHiddenNow;
    private String maintenanceModeOff;
    private String pluginMenuNotExists;

    public void init() {
        super.init("Locale_en", "locale/");
        this.basicPlayerNotFoundAD = this.getStringPath("General.commands.basicResponses.playerNotFoundAD");
        this.basicPlayerNotFound = this.getStringPath("General.commands.basicResponses.playerNotFound");
        this.basicOnlyPlayerCanExecuteThisCommand = this.getStringPath("General.commands.basicResponses.onlyPlayer");
        this.logsGettingLogs = this.getStringPath("General.commands.logs.gettingLogs");
        this.logsWrongMessageForDay = this.getStringPath("General.commands.logs.wrongMessageForDay");
        this.logsWrongMessageForDate = this.getStringPath("General.commands.logs.wrongMessageForDate");
        this.logsWrongMessageForDayAndUUID = this.getStringPath("General.commands.logs.wrongMessageForDayAndUUID");
        this.logsWrongMessageForDateAndUUID = this.getStringPath("General.commands.logs.wrongMessageForDateAndUUID");
        this.logsSuccessfullyDownloaded = this.getStringPath("General.commands.logs.successfullyDownloaded");
        this.logsEnterMessageForDay = this.getStringPath("General.commands.logs.enterMessageForDay");
        this.logsEnterMessageForDate = this.getStringPath("General.commands.logs.enterMessageForDate");
        this.logsEnterMessageForDayAndUUID = this.getStringPath("General.commands.logs.enterMessageForDayAndUUID");
        this.logsEnterMessageForDateAndUUID = this.getStringPath("General.commands.logs.enterMessageForDateAndUUID");
        this.disabledChat = this.getStringPath("General.commands.listeners.chatisDisabled");
        this.pluginMenuNotExists = this.getStringPath("General.commands.listeners.pluginMenu.notExists");
        this.youAreHiddenNow = this.getStringPath("General.commands.hide.youAreHiddenNow");
        this.playerIsHiddenNow = this.getStringPath("General.commands.hide.playerIsHiddenNow");
        this.playerHidden = this.getStringPath("General.commands.hide.playerHidden");
        this.playerNotHidden = this.getStringPath("General.commands.hide.playerNotHidden");
        this.youAreHidden = this.getStringPath("General.commands.hide.youAreHidden");
        this.youAreNotHidden = this.getStringPath("General.commands.hide.youAreNotHidden");
        this.maintenanceModeOn = this.getStringPath("General.commands.maintenanceMode.maintenanceModeOn");
        this.maintenanceModeOff = this.getStringPath("General.commands.maintenanceMode.maintenanceModeOff");
        this.maintenanceModeMessage = this.getStringPath("General.commands.maintenanceMode.maintenanceModeKickMessage");
        this.commandMenuCommandNotFound = this.getStringPath("General.commands.listeners.commandMenu.notFound");
        this.commandMenuResetAllCommandsWarning = this.getStringPath("General.commands.listeners.commandMenu.resetAllCommandsWarning");
        this.commandMenuCommandsHasBeenReset = this.getStringPath("General.commands.listeners.commandMenu.commandsHasBeenReset");
        this.mesToFrozenPlayer = this.getStringPath("General.commands.freeze.freeze.1");
        this.mesToFreezer = this.getStringPath("General.commands.freeze.freeze.2");
        this.mesToReleasedPlayer = this.getStringPath("General.commands.freeze.unfreeze.1");
        this.mesToReleaser = this.getStringPath("General.commands.freeze.unfreeze.2");
        this.mesPlayerOffline = this.getStringPath("General.commands.freeze.offlinePlayerFrozen");
        this.mesToPlayerWhoIsFrozen = this.getStringPath("General.commands.freeze.frozenPlayerMove");
        this.valueNotANumber = this.getStringPath("General.commands.ban.valueNotANumber");
        this.bannedPlayer = this.getStringPath("General.commands.ban.bannedPlayer");
        this.banMustBeGreaterThan0 = this.getStringPath("General.commands.ban.mustBeGreaterThan0");
        this.banComment = this.getStringPath("General.commands.ban.banComment");
        this.banCommentCanceled = this.getStringPath("General.commands.ban.banCommentCanceled");
        this.thisPlayerIsNotBanned = this.getStringPath("General.commands.ban.thisPlayerIsNotBanned");
        this.banUnBadArgs = this.getStringPath("General.commands.unBan.banUnBadArgs");
        this.unBannedPlayer = this.getStringPath("General.commands.unBan.unBannedPlayer");
        this.spamKickMessage = this.getStringPath("Chat.spamKickMessage");
        this.spamKickMessageInConsole = this.getStringPath("Chat.spamKickMessageInConsole");
        this.messageForSpammingToPlayer = this.getStringPath("Chat.messageForSpammingToPlayer");
        this.muteMessage = this.getStringPath("General.commands.mute.muteMessage");
        this.youAreMutedMessage = this.getStringPath("General.commands.mute.youAreMutedMessage");
        this.muteValueNotANumber = this.getStringPath("General.commands.mute.muteValueNotANumber");
        this.mutedPlayer = this.getStringPath("General.commands.mute.mutedPlayer");
        this.mutedEarlier = this.getStringPath("General.commands.unmute.unMutedEarlier");
        this.muteEnterTime = this.getStringPath("General.commands.mute.muteEnterTime");
        this.unMuteBadArgs = this.getStringPath("General.commands.unmute.unmuteBadArgs");
        this.unMutedPlayer = this.getStringPath("General.commands.unmute.unMutedPlayer");
        this.unMutedEarlier = this.getStringPath("General.commands.unmute.unMutedEarlier");
        this.enterBanComment = this.getStringPath("General.commands.ban.enterBanComment");
        this.banEnterTime = this.getStringPath("General.commands.ban.enterBanComment");
    }

    public String getBasicOnlyPlayerCanExecuteThisCommand() {
        return basicOnlyPlayerCanExecuteThisCommand;
    }

    public String getBasicPlayerNotFoundAD() {
        return basicPlayerNotFoundAD;
    }

    public String getBasicPlayerNotFound(String playerName) {
        return basicPlayerNotFound.replaceAll(LiteralType.PLAYER_NAME, playerName);
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

    public String getPlayerIsHiddenNow(String player) {
        return this.playerIsHiddenNow.replaceAll(LiteralType.PLAYER_NAME, player);
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

    public String getLogsGettingLogs() {
        return logsGettingLogs;
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

    public String getBanUnBadArgs() {
        return unMuteBadArgs;
    }

    public String getUnMutedPlayer(String playerName) {
        return unMutedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getUnMutedEarlier(String playerName) {
        return unMutedEarlier.replaceAll(LiteralType.PLAYER_NAME, playerName);
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

    public String getValueNotANumber() {
        return this.valueNotANumber;
    }

    public String getBannedPlayer(String playerToBan) {
        return this.bannedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerToBan);
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
