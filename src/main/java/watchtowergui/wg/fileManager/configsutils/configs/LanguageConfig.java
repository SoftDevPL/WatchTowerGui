package watchtowergui.wg.fileManager.configsutils.configs;

import app.annotations.ConfigYml;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.LiteralType;

import java.util.Map;

@ConfigYml
public class LanguageConfig extends ConfigAccessor {

    String commandsLocale_basic_playerNotFound = "&4&lPlayer not found";
    String commandsLocale_basic_playerNotFoundWithPlayerName = "&4&lPlayer &f&l[playerName] &4&lnot found";
    String commandsLocale_basic_onlyPlayerCanExecuteThisCommand = "&4&lOnly &f&lplayer &4&lcan execute this command!";
    @Getter
    String commandsLocale_basic_sudoSuccess = "&a&lCommand successfully revoked!";
    @Getter
    String commandsLocale_basic_sudoFailed = "&c&lCommand failed!";
    String commandsLocale_commandMenu_CommandsHasBeenReset = "&f&lCommands has been reset reload your server by typing &a&l /reload &f&lto apply changes";
    String commandsLocale_commandMenu_ResetAllCommandsWarning = "&d&lCalling this command will reset all your commands setting like aliases and labels, this cannot be undo. Type &f&l[commandLabel] yes. &d&lIf you really want it";
    String commandsLocale_commandMenu_CommandNotFound = "&c&lCommand not found or is disabled";
    String commandsLocale_pluginMenu_pluginMenuNotExists = "&c&lPlugin does not exist";
    String commandsLocale_hide_playerIsAlreadyHidden = "&4&lPlayer &f&l[playerName] &4&lis already hidden!";
    String commandsLocale_hide_playerNotHidden = "&f&lPlayer &2&l[playerName] &f&lis visible now!";
    String commandsLocale_hide_youAreHidden = "&f&lYou &e&lare hidden &f&lnow!";
    String commandsLocale_hide_youAreNotHidden = "&f&lYou &2&lare not hidden &f&lnow!";
    String commandsLocale_hide_youAreHiddenNow = "&f&lYou &4&lcan not &f&lbe hidden twice!";
    String commandsLocale_hide_playerIsHiddenNow = "&4&lPlayer &f&l[playerName] &4&lis already hidden!";
    String commandsLocale_freeze_messageToFrozenPlayer = "&9&lYou have been frozen by &f&l[playerName]!";
    String commandsLocale_freeze_messageToFreezer = "&9&lYou've frozen &f&l[playerName]";
    String commandsLocale_freeze_messageToReleasedPlayer = "&c&lYou have been released by &f&l[playerName]!";
    String commandsLocale_freeze_messageToReleaser = "&c&lYou've released &f&l[playerName]";
    String commandsLocale_freeze_messagePlayerOffline = "&4&lWARNING: &f&l[playerName] &e&lis offline!";
    String commandsLocale_freeze_messageToPlayerWhoIsFrozen = "&9&lYou are frozen!";
    String commandsLocale_bans_ban_bannedPlayer = "&f&lPlayer &2&l[playerName] &f&lhas been banned";
    String commandsLocale_bans_ban_valueNotANumber = "&c&lWrong arguments, &f&lvalue not a number";
    String commandsLocale_bans_ban_banMustBeGreaterThan0 = "&c&lBan time must be greater than 0";
    String commandsLocale_bans_ban_banComment = "&f&lYou are banned to &6&l[banTime] \n &f&lReason: &c&l[comment]";
    String commandsLocale_bans_ban_enterBanComment = "&e&lEnter ban comment";
    String commandsLocale_bans_ban_banCommentCanceled = "&c&lCanceled";
    String commandsLocale_bans_ban_thisPlayerIsNotBanned = "&f&lThis player &c&lis &f&lnot banned!";
    String commandsLocale_bans_ban_banEnterTime = "&c&lEnter time!";
    String commandsLocale_bans_unban_unbanUnBadArgs = "&2&l/tmunban &3&l<player>";
    String commandsLocale_bans_unban_unBannedPlayer = "&2&lPlayer &f&l[playerName] &2&lhas been unbanned";
    String commandsLocale_mutes_mute_muteValueNotANumber = "&f&lWrong arguments, &f&lvalue not a number";
    String commandsLocale_mutes_mute_mutedPlayer = "&f&l[playerName] &6&lis muted";
    String commandsLocale_mutes_mute_mutedEarlier = "&f&l[playerName] &e&lhas been muted earlier";
    String commandsLocale_mutes_mute_muteEnterTime = "&6&lEnter Time";
    String commandsLocale_mutes_mute_muteMessage = "&b&lYou are muted by &a&l[sender] &b&lto &f&l[date]";
    String commandsLocale_mutes_mute_youAreMutedMessage = "&4&lSORRY!! &e&lYou are muted";
    String commandsLocale_mutes_unmute_unMuteBadArgs = "&2&l/unmute &3&l<player>";
    String commandsLocale_mutes_unmute_unMutedPlayer = "&f&l[playerName] &a&lis unmuted";
    String commandsLocale_mutes_unmute_unMutedEarlier = "&f&l[playerName] &a&lhas been unmuted earlier";
    String commandsLocale_logs_logsGettingLogs = "&e&lGetting Logs";
    String commandsLocale_logs_logsSuccessfullyDownloaded = "&2&lLogs created &4&l!!&f&lCheck plugins/MainAD/Logs";
    String commandsLocale_logs_logsEnterMessageForDay = "&6&lEnter day: \n <yyyy/MM/dd>";
    String commandsLocale_logs_logsEnterMessageForDate = "&6&lEnter date: \n <yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd HH:mm:ss>";
    String commandsLocale_logs_logsEnterMessageForDayAndUUID = "&6&lEnter date: \n <playerName> <yyyy/MM/dd>";
    String commandsLocale_logs_logsEnterMessageForDateAndUUID = "&6&lEnter date: \n <playerName> <yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd HH:mm:ss>";
    String commandsLocale_logs_logsWrongMessageForDay = "&c&lWrong format: \n &f&l<yyyy/MM/dd>";
    String commandsLocale_logs_logsWrongMessageForDate = "&c&lWrong format: \n &f&l<yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd/HH:mm:ss>";
    String commandsLocale_logs_logsWrongMessageForDayAndUUID = "&c&lWrong format: \n &f&l<playerName> <yyyy/MM/dd>";
    String commandsLocale_logs_logsWrongMessageForDateAndUUID = "&c&lWrong format: \n &f&l<playerName> <yyyy/MM/dd HH:mm:ss> <yyyy/MM/dd HH:mm:ss>";
    String specialLocale_spamming_spamKickMessage = "&c&lYou have been kicked &f&lfor spamming";
    String specialLocale_spamming_spamKickMessageInConsole = "'&3&l[playerName] &e&lhas been kicked for spamming'";
    String specialLocale_spamming_messageForSpammingToPlayer = "&c&lHey!! &f&lStop spamming";
    String specialLocale_adminStaff_chat_disabledChat = "&7&lChat has been disabled!";
    String specialLocale_adminStaff_maintenanceMode_maintenanceModeOn = "&6&lMaintenance mode is &2&loff!";
    String specialLocale_adminStaff_maintenanceMode_maintenanceModeOff = "&6&lMaintenance mode is &c&lon!";
    String specialLocale_adminStaff_maintenanceMode_maintenanceModeKickMessage = "&c&lSORRY! \n &6&lServer &f&lencountered an unprecedented problem \n &a&lTry again later!";

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

    public String getCommandsLocale_basic_onlyPlayerCanExecuteThisCommand() {
        return commandsLocale_basic_onlyPlayerCanExecuteThisCommand;
    }

    public String getCommandsLocale_basic_playerNotFound() {
        return commandsLocale_basic_playerNotFound;
    }

    public String getCommandsLocale_basic_playerNotFoundWithPlayerName(String playerName) {
        return commandsLocale_basic_playerNotFoundWithPlayerName.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getSpecialLocale_adminStaff_chat_disabledChat() {
        return specialLocale_adminStaff_chat_disabledChat;
    }

    public String getCommandsLocale_pluginMenu_pluginMenuNotExists() {
        return commandsLocale_pluginMenu_pluginMenuNotExists;
    }

    public String getCommandsLocale_commandMenu_CommandsHasBeenReset() {
        return commandsLocale_commandMenu_CommandsHasBeenReset;
    }

    public String getCommandsLocale_commandMenu_ResetAllCommandsWarning(String word) {
        return commandsLocale_commandMenu_ResetAllCommandsWarning.replaceAll(LiteralType.COMMAND_LABEL, word);
    }

    public String getCommandsLocale_commandMenu_CommandNotFound() {
        return commandsLocale_commandMenu_CommandNotFound;
    }

    public String getCommandsLocale_hide_playerIsHiddenNow(String player) {
        return this.commandsLocale_hide_playerIsHiddenNow.replaceAll(LiteralType.PLAYER_NAME, player);
    }
    public String getCommandsLocale_hide_youAreHiddenNow() {
        return this.commandsLocale_hide_youAreHiddenNow;
    }

    public String getCommandsLocale_hide_playerIsAlreadyHidden(String player) {
        return this.commandsLocale_hide_playerIsAlreadyHidden.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getCommandsLocale_hide_playerNotHidden(String player) {
        return this.commandsLocale_hide_playerNotHidden.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getCommandsLocale_hide_youAreHidden() {
        return this.commandsLocale_hide_youAreHidden;
    }

    public String getCommandsLocale_hide_youAreNotHidden() {
        return this.commandsLocale_hide_youAreNotHidden;
    }

    public String getSpecialLocale_adminStaff_maintenanceMode_maintenanceModeOn() {
        return specialLocale_adminStaff_maintenanceMode_maintenanceModeOn;
    }

    public String getSpecialLocale_adminStaff_maintenanceMode_maintenanceModeOff() {
        return specialLocale_adminStaff_maintenanceMode_maintenanceModeOff;
    }

    public String getSpecialLocale_adminStaff_maintenanceMode_maintenanceModeKickMessage() {
        return specialLocale_adminStaff_maintenanceMode_maintenanceModeKickMessage;
    }

    public String getCommandsLocale_logs_logsGettingLogs() {
        return commandsLocale_logs_logsGettingLogs;
    }

    public String getCommandsLocale_logs_logsSuccessfullyDownloaded() {
        return commandsLocale_logs_logsSuccessfullyDownloaded;
    }

    public String getCommandsLocale_logs_logsEnterMessageForDay() {
        return commandsLocale_logs_logsEnterMessageForDay;
    }

    public String getCommandsLocale_logs_logsEnterMessageForDate() {
        return commandsLocale_logs_logsEnterMessageForDate;
    }

    public String getCommandsLocale_logs_logsEnterMessageForDayAndUUID() {
        return commandsLocale_logs_logsEnterMessageForDayAndUUID;
    }

    public String getCommandsLocale_logs_logsEnterMessageForDateAndUUID() {
        return commandsLocale_logs_logsEnterMessageForDateAndUUID;
    }

    public String getCommandsLocale_logs_logsWrongMessageForDay() {
        return commandsLocale_logs_logsWrongMessageForDay;
    }

    public String getCommandsLocale_logs_logsWrongMessageForDate() {
        return commandsLocale_logs_logsWrongMessageForDate;
    }

    public String getCommandsLocale_logs_logsWrongMessageForDayAndUUID() {
        return commandsLocale_logs_logsWrongMessageForDayAndUUID;
    }

    public String getCommandsLocale_logs_logsWrongMessageForDateAndUUID() {
        return commandsLocale_logs_logsWrongMessageForDateAndUUID;
    }

    public String getCommandsLocale_bans_ban_banEnterTime() {
        return commandsLocale_bans_ban_banEnterTime;
    }

    public String getCommandsLocale_bans_ban_enterBanComment() {
        return commandsLocale_bans_ban_enterBanComment;
    }

    public String getBanReasonCom(String banTime, String comment) {
       String mes = this.commandsLocale_bans_ban_banComment.replaceAll(LiteralType.BAN_TIME, banTime);
        return mes.replaceAll(LiteralType.COMMENT, comment);
    }

    public String getCommandsLocale_bans_ban_banCommentCanceled() {
        return commandsLocale_bans_ban_banCommentCanceled;
    }

    public String getCommandsLocale_bans_ban_thisPlayerIsNotBanned() {
        return commandsLocale_bans_ban_thisPlayerIsNotBanned;
    }

    public String getCommandsLocale_mutes_mute_muteMessage(String sender, String date) {
       String mes = this.commandsLocale_mutes_mute_muteMessage.replaceAll(LiteralType.DATE, date);
        return mes.replaceAll(LiteralType.SENDER, sender);
    }

    public String getCommandsLocale_mutes_mute_youAreMutedMessage() {
        return this.commandsLocale_mutes_mute_youAreMutedMessage;
    }


    public String getCommandsLocale_mutes_mute_muteEnterTime() {
        return commandsLocale_mutes_mute_muteEnterTime;
    }

    public String getCommandsLocale_mutes_mute_muteValueNotANumber() {
        return commandsLocale_mutes_mute_muteValueNotANumber;
    }

    public String getCommandsLocale_mutes_mute_mutedPlayer(String playerName) {
        return commandsLocale_mutes_mute_mutedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getCommandsLocale_mutes_mute_mutedEarlier(String playerName) {
        return commandsLocale_mutes_mute_mutedEarlier.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getCommandsLocale_bans_unban_unbanUnBadArgs() {
        return commandsLocale_mutes_unmute_unMuteBadArgs;
    }

    public String getCommandsLocale_mutes_unmute_unMutedPlayer(String playerName) {
        return commandsLocale_mutes_unmute_unMutedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getCommandsLocale_mutes_unmute_unMutedEarlier(String playerName) {
        return commandsLocale_mutes_unmute_unMutedEarlier.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getSpecialLocale_spamming_messageForSpammingToPlayer() {
        return this.specialLocale_spamming_messageForSpammingToPlayer;
    }

    public String getSpecialLocale_spamming_spamKickMessageInConsole(String playerName) {
        return this.specialLocale_spamming_spamKickMessageInConsole.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getSpecialLocale_spamming_spamKickMessage() {
        return this.specialLocale_spamming_spamKickMessage;
    }

    public String getUnBanBadArgs() {
        return this.commandsLocale_bans_unban_unbanUnBadArgs;
    }

    public String getCommandsLocale_bans_unban_unBannedPlayer(String playerName) {
        return this.commandsLocale_bans_unban_unBannedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerName);
    }

    public String getCommandsLocale_bans_ban_valueNotANumber() {
        return this.commandsLocale_bans_ban_valueNotANumber;
    }

    public String getCommandsLocale_bans_ban_bannedPlayer(String playerToBan) {
        return this.commandsLocale_bans_ban_bannedPlayer.replaceAll(LiteralType.PLAYER_NAME, playerToBan);
    }

    public String getCommandsLocale_freeze_messageToFrozenPlayer(String freezenerName) {
        return this.commandsLocale_freeze_messageToFrozenPlayer.replaceAll(LiteralType.PLAYER_NAME, freezenerName);
    }

    public String getMesToFreezener(String frozenPlayerName) {
        return this.commandsLocale_freeze_messageToFreezer.replaceAll(LiteralType.PLAYER_NAME, frozenPlayerName);
    }

    public String getCommandsLocale_freeze_messageToReleasedPlayer(String releaserName) {
        return this.commandsLocale_freeze_messageToReleasedPlayer.replaceAll(LiteralType.PLAYER_NAME, releaserName);
    }

    public String getCommandsLocale_freeze_messageToReleaser(String releasedPlayerName) {
        return this.commandsLocale_freeze_messageToReleaser.replaceAll(LiteralType.PLAYER_NAME, releasedPlayerName);
    }

    public String getCommandsLocale_freeze_messagePlayerOffline(String offlinePlayerName) {
        return this.commandsLocale_freeze_messagePlayerOffline.replaceAll(LiteralType.PLAYER_NAME, offlinePlayerName);
    }

    public String getCommandsLocale_freeze_messageToPlayerWhoIsFrozen() {
        return this.commandsLocale_freeze_messageToPlayerWhoIsFrozen;
    }

    public String getCommandsLocale_bans_ban_banMustBeGreaterThan0() {
        return commandsLocale_bans_ban_banMustBeGreaterThan0;
    }
}
