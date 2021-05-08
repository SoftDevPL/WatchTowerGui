package watchtowergui.wg.fileManager.configsutils.configs;

import app.annotations.ConfigYml;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.LiteralType;

import java.util.Map;

@ConfigYml
public class LanguageConfig extends ConfigAccessor {

    String basicPlayerNotFoundAD = "§4§lPlayer not found";
    String basicPlayerNotFound = "§4§lPlayer §f§l[playerName] §4§lnot found";
    String basicOnlyPlayerCanExecuteThisCommand = "§4§lOnly §f§lplayer §4§lcan execute this command!";
    String mesToFrozenPlayer = "§9§lYou have been frozen by §f§l[playerName]!";
    String mesToFreezer = "§9§lYou've frozen §f§l[playerName]";
    String mesToReleasedPlayer = "§c§lYou have been released by §f§l[playerName]!";
    String mesToReleaser = "§c§lYou've released §f§l[playerName]";
    String mesPlayerOffline = "§4§lWARNING: §f§l[playerName] §e§lis offline!";
    String mesToPlayerWhoIsFrozen = "§9§lYou are frozen!";
    String bannedPlayer = "§f§lPlayer §2§l[playerName] §f§lhas been banned";
    String valueNotANumber = "§c§lWrong arguments, §f§lvalue not a number";
    String banMustBeGreaterThan0 = "§c§lBan time must be greater than 0";
    String banComment = "§f§lYou are banned to §6§l[banTime] \n §f§lReason: §c§l[comment]";
    String enterBanComment = "§e§lEnter ban comment";
    String banCommentCanceled = "§c§lCanceled";
    String thisPlayerIsNotBanned = "§f§lThis player §c§lis §f§lnot banned!";
    String banUnBadArgs = "§2§l/tmunban §3§l<player>";
    String unBannedPlayer = "§2§lPlayer §f§l[playerName] §2§lhas been unbanned";
    String banEnterTime = "§c§lEnter time!";
    String spamKickMessage = "§c§lYou have been kicked §f§lfor spamming";
    String spamKickMessageInConsole = "'§3§l[playerName] §e§lhas been kicked for spamming'";
    String messageForSpammingToPlayer = "§c§lHey!! §f§lStop spamming";
    String muteValueNotANumber = "§f§lWrong arguments, §f§lvalue not a number";
    String mutedPlayer = "§f§l[playerName] §6§lis muted";
    String mutedEarlier = "§f§l[playerName] §e§lhas been muted earlier";
    String muteEnterTime = "§6§lEnter Time";
    String unMuteBadArgs = "§2§l/unmute §3§l<player>";
    String unMutedPlayer = "§f§l[playerName] §a§lis unmuted";
    String unMutedEarlier = "§f§l[playerName] §a§lhas been unmuted earlier";
    String muteMessage = "§b§lYou are muted by §a§l[sender] §b§lto §f§l[date]";
    String youAreMutedMessage = "§4§lSORRY!! §e§lYou are muted";
    String logsGettingLogs = "§e§lGetting Logs";
    String logsSuccessfullyDownloaded = "§2§lLogs created §4§l!!§f§lCheck plugins/MainAD/Logs";
    String logsEnterMessageForDay = "§6§lEnter day: \n <yyyy/MM/dd>";
    String logsEnterMessageForDate = "§6§lEnter date: \n <yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd HH:mm:ss>";
    String logsEnterMessageForDayAndUUID = "§6§lEnter date: \n <playerName> <yyyy/MM/dd>";
    String logsEnterMessageForDateAndUUID = "§6§lEnter date: \n <playerName> <yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd HH:mm:ss>";
    String logsWrongMessageForDay = "§c§lWrong format: \n §f§l<yyyy/MM/dd>";
    String logsWrongMessageForDate = "§c§lWrong format: \n §f§l<yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd/HH:mm:ss>";
    String logsWrongMessageForDayAndUUID = "§c§lWrong format: \n §f§l<playerName> <yyyy/MM/dd>";
    String logsWrongMessageForDateAndUUID = "§c§lWrong format: \n §f§l<playerName> <yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd HH:mm:ss>";
    String disabledChat = "§7§lChat has been disabled!";
    String commandMenuCommandsHasBeenReset = "§f§lCommands has been reset reload your server by typing §a§l /reload §f§lto apply changes";
    String commandMenuResetAllCommandsWarning = "§d§lCalling this command will reset all your commands setting like aliases and labels, this cannot be undo. Type §f§l[commandLabel] yes. §d§lIf you really want it";
    String commandMenuCommandNotFound = "§c§lCommand not found or is disabled";
    String playerHidden = "§4§lPlayer §f§l[playerName] §4§lis already hidden!";
    String playerNotHidden = "§f§lPlayer §2§l[playerName] §f§lis visible now!";
    String youAreHidden = "§f§lYou §e§lare hidden §f§lnow!";
    String youAreNotHidden = "§f§lYou §2§lare not hidden §f§lnow!";
    String maintenanceModeKickMessage = "§c§lSORRY! \n §6§lServer §f§lencountered an unprecedented problem \n §a§lTry again later!";
    String maintenanceModeOn = "§6§lMaintenance mode is §2§loff!";
    String youAreHiddenNow = "§f§lYou §4§lcan not §f§lbe hidden twice!";
    String playerIsHiddenNow = "§4§lPlayer §f§l[playerName] §4§lis already hidden!";
    String maintenanceModeOff = "§6§lMaintenance mode is §c§lon!";
    String pluginMenuNotExists = "§c§lPlugin does not exist";
    @Getter
    String sudoSuccess = "§a§lCommand successfully revoked!";
    @Getter
    String sudoFailed = "§c§lCommand failed!";

    public void init() {
        super.init("Locale_en", "locale");
        this.yml.addDefaults(this.serialize());
        this.yml.options().copyDefaults(true);
        this.save();

        Map<String, Object> defaults = this.yml.getDefaults().getValues(true);
        this.yml = YamlConfiguration.loadConfiguration(this.file);

        Map<String, Object> map = this.yml.getConfigurationSection("").getValues(true);
        watchtowergui.wg.fileManager.configsutils.configs.LanguageConfigSerializator.injectTo(this, map,defaults, this.yml);
        this.save();

    }

    public Map<String, Object> serialize(){
        return watchtowergui.wg.fileManager.configsutils.configs.LanguageConfigSerializator.serialize(this);
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

    public String getMaintenanceModeKickMessage() {
        return maintenanceModeKickMessage;
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
