package watchtowergui.wg.fileManager.configsutils.configs;

import app.annotations.ConfigYml;
import lombok.ToString;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.LiteralType;

import java.util.Map;

@ConfigYml
@ToString
public class GuiLanguageConfig extends ConfigAccessor {

    String adminStaffGuiDisableChat = "§b§lDisable chat for all players";
    String adminStaffGuiDisableChatCurrent = "§fCurrent:";
    String singlePlayerGuiUnbanPlayer = "§4§lThis player is banned §f§lClick to unban";
    String singlePlayerGuiTempUnbanPlayer = "§c§lThis player is banned temporary §f§lClick to remove temp-ban";
    String singlePlayerGuiUnMutePlayer = "§e§lThis player is muted §f§lClick to unmute";
    String adminStaffGuiMaintenanceCurrent = "§fCurrent:";
    String singlePlayerGuiLastActivity = "§7§lMaintenance Mode";
    String singlePlayerGuiPlayerLocationName = "§d§lCurrent location";
    String singlePlayerGuiPlayerLocationX = "§c§lX: §f§l[X]";
    String singlePlayerGuiPlayerLocationY = "§b§lY: §f§l[Y]";
    String singlePlayerGuiPlayerLocationZ = "§e§lZ: §f§l[Z]";
    String singlePlayerGuiPlayerLocationClickToTeleportToPlayer = "§a§lClick to teleport to player";
    String singlePlayerGuiPlayerLocationLocationPlayersOffline = "§2§lLocation: §f§lPlayer is offline";
    String singlePlayerGuiPlayerInfoMuted = "§a§lThis player is muted";
    String singlePlayerGuiStatus_offline_never_player_before = "§e§lPlayer has never played before";
    String worldToolsGuiSelectPlayer = "§2§lSelect player";
    String serverControlGuiGuiTitle = "§5§lManage your server";
    String serverControlGuiPluginListName = "§e§lPlugins list";
    String serverControlGuiPluginListLore = "§f§lShow information about installed plugins";
    String serverControlGuiManageCommandsName = "§6§lManage commands";
    String serverControlGuiManageCommandsLore = "§f§lShow or edit information and usage of this server commands";
    String singlePluginGuiCreatePluginNameItemVersion = "§5§lVersion: §f§l[pluginVersion]";
    String singlePluginGuiCreatePluginDescriptionItemDescription = "§6§lDescription:";
    String singlePluginGuiCreatePluginDescriptionItemLore = "§d[pluginDescription]";
    String singlePluginGuiCreatePluginDescriptionItemNotSpecified = "§cNot specified";
    String singlePluginGuiCreateAuthorsItemAuthors = "§e§lAuthors:";
    String singlePluginGuiCreateAuthorsItemLore = "§9[pluginAuthors]";
    String singlePluginGuiCreateAuthorsItemNotSpecified = "§cNot specified";
    String singlePluginGuiCreateWebsiteItemWebsite = "§b§LWebsite:";
    String singlePluginGuiCreateWebsiteItemLore = "§2[pluginWebsite]";
    String singlePluginGuiCreateWebsiteItemNotSpecified = "§cNot specified";
    String singlePluginGuiCreatePluginCommandsItemName = "§2§lPlugin commands";
    String singlePluginGuiCreatePluginCommandsItemCommands_lore = "§dClick to manage this plugin commands";
    String singlePluginGuiCreatePluginCommandsItemNo_commands_lore = "§dThis plugin do not have commands";
    String singlePluginGuiCreateDependItemName = "§aPlugins required for this plugin:";
    String singlePluginGuiCreateDependItemLore = "§aPlugins that give full functionalities:";
    String pluginControlGuiGetDescriptionItemLore = "§2§lClick for details";
    String aliasGuiCommandNameAliasesPageName = "§6§l[commandName] aliases";
    String aliasGuiAddAliasItemName = "§a§lAdd alias";
    String aliasGuiRemoveAliasItemName = "§c§lClick to remove";
    String aliasGuiTypeNewAlias = "§dType new alias on chat (\"[cancelModel]\" to cancel)";
    String aliasGuiEnterAliasAgain = "§dEnter alias again (\"[cancelModel]\" to cancel)";
    String aliasGuiAliasRemoved = "§a§lAlias successfully removed!";
    String aliasGuiCantRemovedAlias = "§c§lRemoving alias failed!";
    String aliasGuiCancelPhrase = "§c§lCanceled";
    String commandControlGuiPageName = "§5§lManage §2§l[commandName] §5§lcommands";
    String commandControlGuiFilterOn = "§f§lCurrent: §a§lON";
    String commandControlGuiFilterOff = "§f§lCurrent: §c§lOFF";
    String commandControlGuiGetUsage = "§f§lUsage: §2§l[commandUsage]";
    String commandControlGuiGetLabel = "§f§lLabel: §b§l[commandLabel]";
    String commandControlGuiStatusOn = "§f§lStatus: §a§lactive";
    String commandControlGuiStatusOff = "§f§lStatus: §c§ldisabled";
    String commandControlGuiGetAliases = "§6§lAliases:";
    String commandControlGuiGetPlugin = "§f§lPlugin: §d§l[pluginName]";
    String commandControlGuiGetEditLabel = "§b§lClick to edit";
    String commandControlGuiActiveCommandsFilterItem = "§2§lShow active commands";
    String commandControlGuiDisabledCommandsFilterItem = "§4§lShow disabled commands";
    String commandControlGuiAlphabeticOrderFilterItem = "§b§lSort in alphabetic order";
    String commandControlGuiPluginOrderFilterItem = "§9§lSort in plugin order";
    String commandControlGuiVanillaCommandsFilterItem = "§e§lShow default commands";
    String commandControlGuiPluginCommandsFilterItem = "§d§lShow plugins commands";
    String singleCommandGuiAreYouSure = "§e§lAre you sure?";
    String singleCommandGuiReceiveChangeLabelResult = "§f§lEnter label again or cancel with §d§l[cancelModel]";
    String singleCommandGuiCheckIsLabelEnterCancelCancelPhrase = "§c§lCanceled";
    String singleCommandGuiReceiveDisableResultCanNotDisable = "§c§lCan not disable this command";
    String singleCommandGuiReceiveDisableResultSuccessfullyDisabled = "§a§lCommand successfully disabled";
    String singleCommandGuiSetCommandEnableEnterNewLabel = "§f§lEnter new label §c§l([cancelModel] to cancel)";
    String singleCommandGuiCreatePermissionItemName = "§f§lPermission for this command: §9§l[commandPermission]";
    String singleCommandGuiCreatePermissionNotSpecified = "§c§lNot specified";
    String singleCommandGuiCreateNameItemName = "§f§lName: §1§l[commandName]";
    String singleCommandGuiCreateNameItemLore_1 = "§f§lLabel: §e§l[commandLabel]";
    String singleCommandGuiCreateNameItemLore_2 = "§f§lClick to change label §c§l(not recommended)";
    String singleCommandGuiCreateAliasesItemName = "§5§lAliases:";
    String singleCommandGuiCreateAliasesItemLore = "§b§lClick to add/remove alias";
    String singleCommandGuiCreatePluginItemNameSpecified = "§f§lCommand received from: §5§l[commandName] §f§l-> Click to see plugin";
    String singleCommandGuiCreatePluginItemNameNotSpecified = "§d§lThis command is default server command or plugin can not be specified";
    String singleCommandGuiCreateUsageItemName = "§f§lUsage: §d§l[commandUsage]";
    String singleCommandGuiCreateUsageItemNotSpecified = "§c§lNot specified";
    String singleCommandGuiCreateDescriptionItemName = "§f§lDescription: §b§l[commandDescription]";
    String singleCommandGuiCreateActiveStatusItemName = "§e§lThis command is enabled. §f§lClick to disable this command";
    String singleCommandGuiCreateDisableStatusItemName = "§c§lThis command is disabled. §f§lClick to enable this command";
    String commandControlListenerShowError = "§c§lSomething is wrong check command: [commandName]";
    String commandControlListenerNewCommandAlias = "§e§lIt seems like you have new command with alias or label: §f§l[commandLabel] §e§lCommand §f§l[commandName] §e§lhas return to original label";
    String commandControlListenerLoadAddedAliases = "§c§lAlias: §f§l[commandAlias] §c§lcan not be added to §f§l[commandName] §c§lit is probably because you have new command with that alias or label";
    String commandControlListenerEnableCommandNotExists = "§c§lCommand: §6§l[commandName] §c§ldoes not exist";
    String commandControlListenerEnableCommandCommandAlreadyExists = "§e§lCommand already is enabled";
    String commandControlListenerAliasAlreadyExistsAlreadyExists = "§c§lAlias/label: §f§l[commandAlias] §c§lis already use by: §f§l[commandName]";
    String commandControlListenerAliasAlreadyExistsSuccessfullyEnabled = "§2§lCommand enabled successfully";
    String commandControlListenerChangeLabelNotExists = "§c§lCommand does not exist";
    String commandControlListenerChangeLabelCanNotBeChanged = "§4§lThis label can not be changed";
    String commandControlListenerChangeLabelSuccessfullyChanged = "§2§lLabel change successfully";
    String commandControlListenerAddAliasNotExists = "§c§lCommand does not exists";
    String commandControlListenerAddAliasSuccessfullyAdded = "§2§lAlias added successfully";
    String commandControlListenerOnlyViableAliasMessage = "§e§lOnly viable prefix for this command is: §f§l[commandPrefix]";
    String commandControlListenerCommandHasThatAliasOrLabel = "§c§lThis command already has that alias or label";
    String commandControlListenerCommandHasThatAlias = "§c§lCommand: §f§l[commandName] §c§lalready has that alias or label!";
    String commandMenuPageName = "§5§lManage Commands";
    String singlePlayerGuiHomesList = "§6§lShow this player homes";
    String adminGuiPlayersGuiShowOfflinePlayersName = "";
    String adminGuiPlayersGuiShowOfflinePlayersON = "§f§lCurrent: §a§lON";
    String adminGuiPlayersGuiShowOfflinePlayersOFF = "§f§lCurrent: §c§lOFF";
    String mainGuiPlayers = "§1§lPlayers";
    String adminGuiMainGuiManageServer = "§5§lManage Server";
    String adminGuiUnknownStatus = "§c§lUnknown status";
    String adminGuiBack = "§f§lGo Back";
    String adminGuiClose = "§c§lClose";
    String adminGuiExecute = "§a§lExecute §f§l[title]";
    String adminGuiExpiredTime = "§6§lExpired Time";
    String mainGuiPageName = "§6§lAdmin Gui";
    String mainGuiBans = "§c§lBans";
    String mainGuiAdminStaff = "§6§lAdmin Staff";
    String playersGuiPageName = "§5§lPlayers";
    String bansGuiPageName = "§c§lBans";
    String bansGuiBannedPlayersList = "§7§lBanned Players List";
    String bansGuiTemporaryBannedPlayersList = "§e§lTmBanned Players";
    String bansGuiMutedPlayers = "§d§lMuted Players";
    String bansGuiFrozenPlayersList = "§1§lFrozen Players List";
    String bansGuiHiddenPlayers = "§b§lHidden Players";
    String adminStaffGuiPageName = "§2§lAdminStaff";
    String adminStaffGuiVanish = "§6§lVanish";
    String adminStaffGuiVanish_current = "'§fCurrent:";
    String adminStaffGuiMaintenance = "§7§lMaintenance Mode";
    String adminStaffGuiAdminTools = "§b§lAdmin Tools";
    String adminToolsGuiPageName = "§b§lAdmin Tools";
    String adminToolsGuiAdminAxe = "§e§lAdmin Axe";
    String adminToolsGuiAdminPickAxe = "§9§lAdmin Pickaxe";
    String adminToolsGuiAdminShovel = "§2§lAdmin Shovel";
    String adminToolsGuiAdminSword = "§c§lAdmin Sword";
    String adminToolsGuiAdminBow = "§d§lAdmin Bow";
    String adminToolsGuiAdminHoe = "§b§lAdmin... Hoe???";
    String singlePlayerGuiStatus_online = "§a§lPlayer is online";
    String singlePlayerGuiStatus_offline = "§c§lPlayer is offline";
    String singlePlayerGuiKillPlayer = "§4§lKill Player";
    String singlePlayerGuiFreezePlayer = "§9§lFreeze Player";
    String singlePlayerGuiTeleportPlayer = "§2§lTeleport Player";
    String singlePlayerGuiTeleportToPlayer = "§2§lTeleport To Player";
    String singlePlayerGuiBanPlayer = "§6§lBan Player";
    String singlePlayerGuiMutePlayer = "§a§lMute Player";
    String singlePlayerGuiInventory = "§2§lInventory";
    String singlePlayerGuiEnderChest = "§5§lEnder Chest";
    String singlePlayerGuiHidePlayer = "§f§lHide Player";
    String singlePlayerGuiHidePlayer_current = "§f§lCurrent: ";
    String singlePlayerGuiKickPlayer = "§d§lKick Player";
    String singlePlayerGuiTemporaryBanPlayer = "§8§lTemporary Ban Player";
    String singlePlayerGuiBanGuiPageName = "§0§lBan §6§l[playerName]?";
    String singlePlayerGuiPageName = "§6§l[playerName]";
    String singlePlayerGuiReleasePlayer = "§c§lRelease Player";
    String chooseTimeGuiPageName = "§0§lChoose Time";
    String chooseTimeGuiSecond = "§7§lSecond";
    String chooseTimeGuiMinute = "§9§lMinute'";
    String chooseTimeGuiHour = "§b§lHour";
    String chooseTimeGuiDay = "§d§lDay";
    String chooseTimeGuiWeek = "§5§lWeek";
    String chooseTimeGuiMonth = "§e§lMonth";
    String chooseTimeGuiYear = "§6§lYear";
    String chooseTimeGuiSeconds = "§7§lSeconds";
    String chooseTimeGuiMinutes = "§9§lMinutes";
    String chooseTimeGuiHours = "§b§lHours";
    String chooseTimeGuiDays = "§d§lDays";
    String chooseTimeGuiWeeks = "§5§lWeeks";
    String chooseTimeGuiMonths = "§e§lMonths";
    String chooseTimeGuiYears = "§6§lYears";
    String chooseTimeGuiExit = "§c§lExit";
    String bansGuiUnban = "§6§lUnban §5§L[playerName]?";
    String banDescriptionBannedBy = "§6§lBanned by: §f§l[date]";
    String banDescriptionBannedDate = "§6§lBan date: §f§l[date]";
    String banDescriptionExpiredDate = "§6§lExpired date: §f§l[date]";
    String banDescriptionComment = "§7§lComment: §c§l[comment]";
    String mutesGuiMutedBy = "§f§lMuted by: [playerName]";
    String mutesGuiExpiredDate = "§f§lExpired date: [date]";
    String mutesGuiUnmute = "§f§lUnmute: [playerName]";
    String bansGuiSelectTime = "§c§lSelect Time";
    String logsName = "§e§lLogs";
    String logsGuiSelectPlayer = "§e§lSelect Player";
    String logsGuiTitle = "§b§lChoose time range";
    String logsForAll = "§5§lLogs for all players";
    String logsForOnePlayer = "§2§lGet logs for specified player";
    String firstCalendarGuiTitle = "§d§lSelect first date";
    String secondCalendarGuiTitle = "§5§lSelect second date";
    String calendarGuiTitle = "§a§lSelect date";
    String logsTimeGuiTitle = "§b§lChoose time range";
    String logsTimeOneDay = "§2§lMerge logs from one day";
    String logsTimeMultiDay = "§5§lMerge logs from many days";
    String calendarGuiFirstDate = "§2§lFirst Date";
    String calendarGuiEndDate = "§e§lEnd Date";
    String logsFromDay = "§b§lGet logs from specific day";
    String logsFromDateInterval = "§3§lGet logs from date interval";
    String adminGuiWorldToolsGuiEnterMessageInChat = "§e§lEnter message in chat";
    String adminGuiWorldToolsGuiWorldToolsGuiPageName = "§2§lSelect player";
    String adminGuiWorldToolsGuiDefaultGamemodeName = "§b§lSet default gamemode";
    String adminGuiWorldToolsGuiDefaultGamemodeLore = "§f§lBy clicking this you can set default gamemode type for every player: [survival, creative, spectator, hardcore]";
    String adminGuiWorldToolsGuiWorldDifficultyName = "§c§lSet difficulty";
    String adminGuiWorldToolsGuiWorldDifficultyLore = "§f§lBy clicking this you can set world difficulty: [peaceful, easy, medium, hard]";
    String adminGuiWorldToolsGuiGamemodeName = "§e§lGamemode";
    String adminGuiWorldToolsGuiGamemodeLore = "§f§lSet your gamemode: [survival, creative, spectator, hardcore]";
    String adminGuiWorldToolsGuiReloadName = "§a§lReload server";
    String adminGuiWorldToolsGuiReloadLore = "§f§lBy clicking this you can reload your server";
    String adminGuiWorldToolsGuiSayName = "§9§lSay globally";
    String adminGuiWorldToolsGuiSayLore = "§f§lBy clicking this you can write in chat to say something globally";
    String adminGuiWorldToolsGuiSeedName = "§2§lGet world seed";
    String adminGuiWorldToolsGuiSeedLore = "§f§lBy clicking this you can display world seed";
    String adminGuiWorldToolsGuiSetWorldSpawnName = "§6§lSet worldspawn";
    String adminGuiWorldToolsGuiSetWorldSpawnLore = "§f§l(provided by Minecraft) By clicking this you can set world spawn in position when you are staying";
    String adminGuiWorldToolsGuiSpawnPointName = "§4§lSet set spawn point";
    String adminGuiWorldToolsGuiSpawnPointLore = "§f§l(provided by Minecraft) By clicking this you can set spawn point to yourself in position when you are staying";
    String adminGuiWorldToolsGuiTimeName = "§d§lSet time";
    String adminGuiWorldToolsGuiTimeLore = "§f§lBy clicking this you can change your world time";
    String adminGuiWorldToolsGuiWeatherName = "§5§lSet weather";
    String adminGuiWorldToolsGuiWeatherLore = "§f§lBy clicking this you can set your world weather";
    String adminGuiWorldToolsGuiWorldBorderName = "§7§lSet world border";
    String adminGuiWorldToolsGuiWorldBorderLore = "§f§lBy clicking this you can set you world border";
    String adminGuiWorldToolsGuiXpName = "§4§lGive xp";
    String adminGuiWorldToolsGuiXpLore = "§f§lBy clicking this you can add xp";
    String adminGuiWorldToolsGuiXpChatMessage = "§f§lEnter xp amount §c§l([cancelModel] to cancel)";
    String adminGuiWorldToolsGuiXpChatCanceledMessage = "§c§lCanceled";
    String adminGuiWorldToolsGuiTitleName = "§5§lDisplay title to player";
    String adminGuiWorldToolsGuiTitleLore = "§f§lBy clicking this you can send a screen title to specific player";
    String adminGuiWorldToolsGuiTitleChatMessage = "§f§lEnter message to player §c§l([cancelModel] to cancel)";
    String adminGuiWorldToolsGuiTitleChatCanceledMessage = "§c§lCanceled";
    String adminGuiWorldToolsGuiTellName = "§1§lSend private message";
    String adminGuiWorldToolsGuiTellLore = "§f§lby clicking this you can send a private message to a specific player";
    String adminGuiWorldToolsGuiTellChatMessage = "§f§lEnter message to player §c§l([cancelModel] to cancel)";
    String adminGuiWorldToolsGuiTellChatCanceledMessage = "§c§lCanceled";
    String adminGuiWeatherGuiWeatherGuiPageName = "§b§lSet weather";
    String adminGuiWeatherGuiSunny = "§e§lSunny";
    String adminGuiWeatherGuiRainy = "§9§lRainy";
    String adminGuiWeatherGuiThunder = "§7§lThunder";
    String adminGuiTimeGuiPageName = "§5§lSelect Time";
    String adminGuiTimeGuiDay = "§b§lDay";
    String adminGuiTimeGuiNoon = "§e§lNoon";
    String adminGuiTimeGuiMidNight = "§a§lMidnight";
    String adminGuiTimeGuiNight = "§9§lNight";
    String adminGuiTimeGuiNumber = "§f§lTime value";
    String adminGuiTimeGuiChatResponse = "§f§lWrite message in chat";
    String adminGuiDifficultyGuiDifficultyGuiPageName = "§d§lSet difficulty";
    String adminGuiDifficultyGuiPeaceful = "§a§lPeaceful";
    String adminGuiDifficultyGuiEasy = "§2§lEasy";
    String adminGuiDifficultyGuiMedium = "§e§lNormal";
    String adminGuiDifficultyGuiHard = "§4§lHard";
    String adminGuiGamemodeGuiGamemodeGuiPageName = "§9§lSet your gamemode";
    String adminGuiGamemodeGuiSurvival = "§2§lSurvival";
    String adminGuiGamemodeGuiCreative = "§b§lCreative";
    String adminGuiGamemodeGuiHardcore = "§c§lHardcore";
    String adminGuiGamemodeGuiSpectator = "§6§lSpectator";
    String adminGuiDefaultGamemodeGuiDefaultGamemodeGuiPageName = "§5§lSet default gamemode";
    String adminGuiDefaultGamemodeGuiSurvival = "§2§lSurvival";
    String adminGuiDefaultGamemodeGuiCreative = "§b§lCreative";
    String adminGuiDefaultGamemodeGuiHardcore = "§c§lHardcore";
    String adminGuiDefaultGamemodeGuiSpectator = "§6§lSpectator";
    String adminGuiWorldBorderGuiWorldBorderGuiPageName = "§2§lConfigure your world border";
    String adminGuiWorldBorderGuiAddToWorldBorderName = "§a§lAdd";
    String adminGuiWorldBorderGuiAddToWorldBorderLore = "§f§l/worldborder add <sizeInBlocks> [timeInSeconds]";
    String adminGuiWorldBorderGuiAddToWorldBorderChatMessage = "§f§lWrite message in chat";
    String adminGuiWorldBorderGuiGetWorldBorderName = "§f§lActual border:";
    String adminGuiWorldBorderGuiGetWorldBorderLore = "§f§lworldborder size: §6§l[worldBorderSize]";
    String adminGuiWorldBorderGuiWorldBorderWarningName = "§e§lWarning";
    String adminGuiWorldBorderGuiWorldBorderWarningLore = "§f§l/worldborder warning time §e§l<timeInSeconds>";
    String adminGuiWorldBorderGuiWorldBorderWarningChatMessage = "§f§lWrite message in chat";
    String adminGuiWorldBorderGuiWorldBorderDamageName = "§c§lDamage";
    String adminGuiWorldBorderGuiWorldBorderDamageLore = "§f§l/worldborder damage buffer §d§l<sizeInBlocks>";
    String adminGuiWorldBorderGuiWorldBorderDamageChatMessage = "§f§lWrite message in chat";
    String adminGuiWorldBorderGuiCenterWorldBorderName = "§d§lCenter";
    String adminGuiWorldBorderGuiCenterWorldBorderLore = "§f§l/worldborder center §c§l<x> <z>";
    String adminGuiWorldBorderGuiCenterWorldBorderChatMessage = "§f§lWrite message in chat";
    String adminGuiWorldBorderGuiSetWorldBorderName = "§3§lSet";
    String adminGuiWorldBorderGuiSetWorldBorderLore = "§f§l/worldborder set §c§l<sizeInBlocks> [timeInSeconds]";
    String adminGuiWorldBorderGuiSetWorldBorderChatMessage = "§f§lWrite message in chat";
    String playerIsOffline = "§c§lPlayer is offline";

    public void init() {
        super.init("GuiLocale_en", "locale");
        this.yml.addDefaults(this.serialize());
        this.yml.options().copyDefaults(true);
        this.save();
        watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfigSerializator
                .injectTo(this, this.yml.getConfigurationSection("").getValues(true));
        System.out.println(this.toString());
    }

    public Map<String, Object> serialize(){
        return watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfigSerializator.serialize(this);
    }

    public String getPlayerIsOffline() {
        return playerIsOffline;
    }

    public String getAdminStaffGuiDisableChat() {
        return adminStaffGuiDisableChat;
    }

    public String getAdminStaffGuiDisableChatCurrent() {
        return adminStaffGuiDisableChatCurrent;
    }

    public String getAdminStaffGuiMaintenanceCurrent() {
        return adminStaffGuiMaintenanceCurrent;
    }

    public String getSinglePlayerGuiUnbanPlayer() {
        return singlePlayerGuiUnbanPlayer;
    }

    public String getSinglePlayerGuiTempUnbanPlayer() {
        return singlePlayerGuiTempUnbanPlayer;
    }

    public String getSinglePlayerGuiUnMutePlayer() {
        return singlePlayerGuiUnMutePlayer;
    }

    public String getSinglePlayerGuiLastActivity(String word) {
        return singlePlayerGuiLastActivity.replaceAll(LiteralType.LAST_ACTIVITY, word);
    }

    public String getSinglePlayerGuiPlayerLocationName() {
        return singlePlayerGuiPlayerLocationName;
    }

    public String getSinglePlayerGuiPlayerLocationX(String word) {
        return singlePlayerGuiPlayerLocationX.replaceAll(LiteralType.X, word);
    }

    public String getSinglePlayerGuiPlayerLocationY(String word) {
        return singlePlayerGuiPlayerLocationY.replaceAll(LiteralType.Y, word);
    }

    public String getSinglePlayerGuiPlayerLocationZ(String word) {
        return singlePlayerGuiPlayerLocationZ.replaceAll(LiteralType.Z, word);
    }

    public String getSinglePlayerGuiPlayerLocationClickToTeleportToPlayer() {
        return singlePlayerGuiPlayerLocationClickToTeleportToPlayer;
    }

    public String getSinglePlayerGuiPlayerLocationLocationPlayersOffline() {
        return singlePlayerGuiPlayerLocationLocationPlayersOffline;
    }

    public String getSinglePlayerGuiPlayerInfoMuted() {
        return singlePlayerGuiPlayerInfoMuted;
    }

    public String getWorldToolsGuiSelectPlayer() {
        return worldToolsGuiSelectPlayer;
    }

    public String getServerControlGuiGuiTitle() {
        return serverControlGuiGuiTitle;
    }

    public String getServerControlGuiPluginListName() {
        return serverControlGuiPluginListName;
    }

    public String getServerControlGuiPluginListLore() {
        return serverControlGuiPluginListLore;
    }

    public String getServerControlGuiManageCommandsName() {
        return serverControlGuiManageCommandsName;
    }

    public String getServerControlGuiManageCommandsLore() {
        return serverControlGuiManageCommandsLore;
    }

    public String getSinglePluginGuiCreatePluginDescriptionItemLore(String word) {
        return singlePluginGuiCreatePluginDescriptionItemLore.replaceAll(LiteralType.PLUGIN_DESCRIPTION, word);
    }

    public String getSinglePluginGuiCreateAuthorsItemLore(String word) {
        return singlePluginGuiCreateAuthorsItemLore.replaceAll(LiteralType.PLUGIN_AUTHORS, word);
    }

    public String getSinglePluginGuiCreateWebsiteItemLore(String word) {
        return singlePluginGuiCreateWebsiteItemLore.replaceAll(LiteralType.PLUGIN_WEBSITE, word);
    }

    public String getSinglePluginGuiCreatePluginNameItemVersion(String word) {
        return singlePluginGuiCreatePluginNameItemVersion.replaceAll(LiteralType.PLUGIN_VERSION, word);
    }

    public String getSinglePluginGuiCreatePluginDescriptionItemDescription() {
        return singlePluginGuiCreatePluginDescriptionItemDescription;
    }

    public String getSinglePluginGuiCreatePluginDescriptionItemNotSpecified() {
        return singlePluginGuiCreatePluginDescriptionItemNotSpecified;
    }

    public String getSinglePluginGuiCreateAuthorsItemAuthors() {
        return singlePluginGuiCreateAuthorsItemAuthors;
    }

    public String getSinglePluginGuiCreateAuthorsItemNotSpecified() {
        return singlePluginGuiCreateAuthorsItemNotSpecified;
    }

    public String getSinglePluginGuiCreateWebsiteItemWebsite() {
        return singlePluginGuiCreateWebsiteItemWebsite;
    }

    public String getSinglePluginGuiCreateWebsiteItemNotSpecified() {
        return singlePluginGuiCreateWebsiteItemNotSpecified;
    }

    public String getSinglePluginGuiCreatePluginCommandsItemName() {
        return singlePluginGuiCreatePluginCommandsItemName;
    }

    public String getSinglePluginGuiCreatePluginCommandsItemCommands_lore() {
        return singlePluginGuiCreatePluginCommandsItemCommands_lore;
    }

    public String getSinglePluginGuiCreatePluginCommandsItemNo_commands_lore() {
        return singlePluginGuiCreatePluginCommandsItemNo_commands_lore;
    }

    public String getSinglePluginGuiCreateDependItemName() {
        return singlePluginGuiCreateDependItemName;
    }

    public String getSinglePluginGuiCreateDependItemLore() {
        return singlePluginGuiCreateDependItemLore;
    }

    public String getPluginControlGuiGetDescriptionItemLore() {
        return pluginControlGuiGetDescriptionItemLore;
    }

    public String getCommandControlListenerShowError(String word) {
        return commandControlListenerShowError.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getCommandControlListenerNewCommandAlias(String word1, String word2) {
        String str1 = commandControlListenerNewCommandAlias.replace(LiteralType.COMMAND_ALIAS, word1);
        return str1.replaceAll(LiteralType.COMMAND_NAME, word2);
    }

    public String getCommandControlListenerLoadAddedAliases(String word1, String word2) {
        String str1 = commandControlListenerLoadAddedAliases.replaceAll(LiteralType.COMMAND_ALIAS, word1);
        return str1.replaceAll(LiteralType.COMMAND_NAME, word2);
    }

    public String getCommandControlListenerEnableCommandNotExists(String word) {
        return commandControlListenerEnableCommandNotExists.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getCommandControlListenerEnableCommandCommandAlreadyExists() {
        return commandControlListenerEnableCommandCommandAlreadyExists;
    }

    public String getCommandControlListenerAliasAlreadyExistsAlreadyExists(String word1, String word2) {
        String str1 = commandControlListenerAliasAlreadyExistsAlreadyExists.replaceAll(LiteralType.COMMAND_ALIAS, word1);
        return str1.replaceAll(LiteralType.COMMAND_NAME, word2);
    }

    public String getCommandControlListenerAliasAlreadyExistsSuccessfullyEnabled() {
        return commandControlListenerAliasAlreadyExistsSuccessfullyEnabled;
    }

    public String getCommandControlListenerChangeLabelNotExists() {
        return commandControlListenerChangeLabelNotExists;
    }

    public String getCommandControlListenerChangeLabelCanNotBeChanged() {
        return commandControlListenerChangeLabelCanNotBeChanged;
    }

    public String getCommandControlListenerChangeLabelSuccessfullyChanged() {
        return commandControlListenerChangeLabelSuccessfullyChanged;
    }

    public String getCommandControlListenerAddAliasNotExists() {
        return commandControlListenerAddAliasNotExists;
    }

    public String getCommandControlListenerAddAliasSuccessfullyAdded() {
        return commandControlListenerAddAliasSuccessfullyAdded;
    }

    public String getCommandControlListenerOnlyViableAliasMessage(String word) {
        return commandControlListenerOnlyViableAliasMessage.replaceAll(LiteralType.COMMAND_PREFIX, word);
    }

    public String getCommandControlListenerCommandHasThatAliasOrLabel() {
        return commandControlListenerCommandHasThatAliasOrLabel;
    }

    public String getCommandControlListenerCommandHasThatAlias(String word) {
        return commandControlListenerCommandHasThatAlias.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getSingleCommandGuiAreYouSure() {
        return singleCommandGuiAreYouSure;
    }

    public String getSingleCommandGuiReceiveChangeLabelResult(String word) {
        return singleCommandGuiReceiveChangeLabelResult.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getSingleCommandGuiCheckIsLabelEnterCancelCancelPhrase() {
        return singleCommandGuiCheckIsLabelEnterCancelCancelPhrase;
    }

    public String getSingleCommandGuiReceiveDisableResultCanNotDisable() {
        return singleCommandGuiReceiveDisableResultCanNotDisable;
    }

    public String getSingleCommandGuiReceiveDisableResultSuccessfullyDisabled() {
        return singleCommandGuiReceiveDisableResultSuccessfullyDisabled;
    }

    public String getSingleCommandGuiSetCommandEnableEnterNewLabel(String word) {
        return singleCommandGuiSetCommandEnableEnterNewLabel.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getSingleCommandGuiCreatePermissionItemName(String word) {
        return singleCommandGuiCreatePermissionItemName.replaceAll(LiteralType.COMMAND_PERMISSION, word);
    }

    public String getSingleCommandGuiCreatePermissionNotSpecified() {
        return singleCommandGuiCreatePermissionNotSpecified;
    }

    public String getSingleCommandGuiCreateNameItemName(String word) {
        return singleCommandGuiCreateNameItemName.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getSingleCommandGuiCreateNameItemLore_1(String word) {
        return singleCommandGuiCreateNameItemLore_1.replaceAll(LiteralType.COMMAND_LABEL, word);
    }

    public String getSingleCommandGuiCreateNameItemLore_2() {
        return singleCommandGuiCreateNameItemLore_2;
    }

    public String getSingleCommandGuiCreateAliasesItemName() {
        return singleCommandGuiCreateAliasesItemName;
    }

    public String getSingleCommandGuiCreateAliasesItemLore() {
        return singleCommandGuiCreateAliasesItemLore;
    }

    public String getSingleCommandGuiCreatePluginItemNameSpecified(String word) {
        return singleCommandGuiCreatePluginItemNameSpecified.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getSingleCommandGuiCreatePluginItemNameNotSpecified() {
        return singleCommandGuiCreatePluginItemNameNotSpecified;
    }

    public String getSingleCommandGuiCreateUsageItemName(String word) {
        return singleCommandGuiCreateUsageItemName.replaceAll(LiteralType.COMMAND_USAGE, word);
    }

    public String getSingleCommandGuiCreateUsageItemNotSpecified() {
        return singleCommandGuiCreateUsageItemNotSpecified;
    }

    public String getSingleCommandGuiCreateDescriptionItemName(String word) {
        return singleCommandGuiCreateDescriptionItemName.replaceAll(LiteralType.COMMAND_DESCRIPTION, word);
    }

    public String getSingleCommandGuiCreateActiveStatusItemName() {
        return singleCommandGuiCreateActiveStatusItemName;
    }

    public String getSingleCommandGuiCreateDisableStatusItemName() {
        return singleCommandGuiCreateDisableStatusItemName;
    }


    public String getCommandControlGuiGetUsage(String word) {
        return commandControlGuiGetUsage.replaceAll(LiteralType.COMMAND_USAGE, word);
    }

    public String getCommandControlGuiGetLabel(String word) {
        return commandControlGuiGetLabel.replaceAll(LiteralType.COMMAND_LABEL, word);
    }

    public String getCommandControlGuiStatusOn() {
        return commandControlGuiStatusOn;
    }

    public String getCommandControlGuiStatusOff() {
        return commandControlGuiStatusOff;
    }

    public String getCommandControlGuiGetAliases() {
        return commandControlGuiGetAliases;
    }

    public String getCommandControlGuiGetPlugin(String word) {
        return commandControlGuiGetPlugin.replaceAll(LiteralType.PLUGIN_NAME, word);
    }

    public String getCommandControlGuiGetEditLabel() {
        return commandControlGuiGetEditLabel;
    }

    public String getCommandControlGuiActiveCommandsFilterItem() {
        return commandControlGuiActiveCommandsFilterItem;
    }

    public String getCommandControlGuiDisabledCommandsFilterItem() {
        return commandControlGuiDisabledCommandsFilterItem;
    }

    public String getCommandControlGuiAlphabeticOrderFilterItem() {
        return commandControlGuiAlphabeticOrderFilterItem;
    }

    public String getCommandControlGuiPluginOrderFilterItem() {
        return commandControlGuiPluginOrderFilterItem;
    }

    public String getCommandControlGuiVanillaCommandsFilterItem() {
        return commandControlGuiVanillaCommandsFilterItem;
    }

    public String getCommandControlGuiPluginCommandsFilterItem() {
        return commandControlGuiPluginCommandsFilterItem;
    }

    public String getCommandControlGuiPageName(String word) {
        return commandControlGuiPageName.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getCommandControlGuiFilterOn() {
        return commandControlGuiFilterOn;
    }

    public String getCommandControlGuiFilterOff() {
        return commandControlGuiFilterOff;
    }

    public String getAliasGuiCommandNameAliasesPageName(String word) {
        return aliasGuiCommandNameAliasesPageName.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getAliasGuiAddAliasItemName() {
        return aliasGuiAddAliasItemName;
    }

    public String getAliasGuiRemoveAliasItemName() {
        return aliasGuiRemoveAliasItemName;
    }

    public String getAliasGuiTypeNewAlias(String word) {
        return aliasGuiTypeNewAlias.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getAliasGuiEnterAliasAgain(String word) {
        return aliasGuiEnterAliasAgain.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getAliasGuiAliasRemoved() {
        return aliasGuiAliasRemoved;
    }

    public String getAliasGuiCantRemovedAlias() {
        return aliasGuiCantRemovedAlias;
    }

    public String getAliasGuiCancelPhrase() {
        return aliasGuiCancelPhrase;
    }

    public String getCommandMenuPageName() {
        return commandMenuPageName;
    }

    public String getLogsGuiSelectPlayer() {
        return logsGuiSelectPlayer;
    }

    public String getSinglePlayerGuiHomesList() {
        return singlePlayerGuiHomesList;
    }

    public String getAdminGuiPlayersGuiShowOfflinePlayersName() {
        return adminGuiPlayersGuiShowOfflinePlayersName;
    }

    public String getAdminGuiPlayersGuiShowOfflinePlayersON() {
        return adminGuiPlayersGuiShowOfflinePlayersON;
    }

    public String getAdminGuiPlayersGuiShowOfflinePlayersOFF() {
        return adminGuiPlayersGuiShowOfflinePlayersOFF;
    }

    public String getMainGuiPlayers() {
        return mainGuiPlayers;
    }

    public String getAdminGuiMainGuiManageServer() {
        return adminGuiMainGuiManageServer;
    }

    public String getAdminGuiWorldBorderGuiAddToWorldBorderChatMessage() {
        return adminGuiWorldBorderGuiAddToWorldBorderChatMessage;
    }

    public String getAdminGuiWorldBorderGuiWorldBorderWarningChatMessage() {
        return adminGuiWorldBorderGuiWorldBorderWarningChatMessage;
    }

    public String getAdminGuiWorldBorderGuiWorldBorderDamageChatMessage() {
        return adminGuiWorldBorderGuiWorldBorderDamageChatMessage;
    }

    public String getAdminGuiWorldBorderGuiCenterWorldBorderChatMessage() {
        return adminGuiWorldBorderGuiCenterWorldBorderChatMessage;
    }

    public String getAdminGuiWorldBorderGuiSetWorldBorderChatMessage() {
        return adminGuiWorldBorderGuiSetWorldBorderChatMessage;
    }

    public String getAdminGuiWorldBorderGuiWorldBorderGuiPageName() {
        return adminGuiWorldBorderGuiWorldBorderGuiPageName;
    }

    public String getAdminGuiWorldBorderGuiAddToWorldBorderName() {
        return adminGuiWorldBorderGuiAddToWorldBorderName;
    }

    public String getAdminGuiWorldBorderGuiAddToWorldBorderLore() {
        return adminGuiWorldBorderGuiAddToWorldBorderLore;
    }

    public String getAdminGuiWorldBorderGuiGetWorldBorderName() {
        return adminGuiWorldBorderGuiGetWorldBorderName;
    }

    public String getAdminGuiWorldBorderGuiGetWorldBorderLore(String message) {
        return adminGuiWorldBorderGuiGetWorldBorderLore.replaceAll(LiteralType.WORLD_BORDER_SIZE, message);
    }

    public String getAdminGuiWorldBorderGuiWorldBorderWarningName() {
        return adminGuiWorldBorderGuiWorldBorderWarningName;
    }

    public String getAdminGuiWorldBorderGuiWorldBorderWarningLore() {
        return adminGuiWorldBorderGuiWorldBorderWarningLore;
    }

    public String getAdminGuiWorldBorderGuiWorldBorderDamageName() {
        return adminGuiWorldBorderGuiWorldBorderDamageName;
    }

    public String getAdminGuiWorldBorderGuiWorldBorderDamageLore() {
        return adminGuiWorldBorderGuiWorldBorderDamageLore;
    }

    public String getAdminGuiWorldBorderGuiCenterWorldBorderName() {
        return adminGuiWorldBorderGuiCenterWorldBorderName;
    }

    public String getAdminGuiWorldBorderGuiCenterWorldBorderLore() {
        return adminGuiWorldBorderGuiCenterWorldBorderLore;
    }

    public String getAdminGuiWorldBorderGuiSetWorldBorderName() {
        return adminGuiWorldBorderGuiSetWorldBorderName;
    }

    public String getAdminGuiWorldBorderGuiSetWorldBorderLore() {
        return adminGuiWorldBorderGuiSetWorldBorderLore;
    }

    public String getAdminGuiDefaultGamemodeGuiDefaultGamemodeGuiPageName() {
        return adminGuiDefaultGamemodeGuiDefaultGamemodeGuiPageName;
    }

    public String getAdminGuiDefaultGamemodeGuiSurvival() {
        return adminGuiDefaultGamemodeGuiSurvival;
    }

    public String getAdminGuiDefaultGamemodeGuiCreative() {
        return adminGuiDefaultGamemodeGuiCreative;
    }

    public String getAdminGuiDefaultGamemodeGuiHardcore() {
        return adminGuiDefaultGamemodeGuiHardcore;
    }

    public String getAdminGuiDefaultGamemodeGuiSpectator() {
        return adminGuiDefaultGamemodeGuiSpectator;
    }

    public String getAdminGuiGamemodeGuiGamemodeGuiPageName() {
        return adminGuiGamemodeGuiGamemodeGuiPageName;
    }

    public String getAdminGuiGamemodeGuiSurvival() {
        return adminGuiGamemodeGuiSurvival;
    }

    public String getAdminGuiGamemodeGuiCreative() {
        return adminGuiGamemodeGuiCreative;
    }

    public String getAdminGuiGamemodeGuiHardcore() {
        return adminGuiGamemodeGuiHardcore;
    }

    public String getAdminGuiGamemodeGuiSpectator() {
        return adminGuiGamemodeGuiSpectator;
    }

    public String getAdminGuiDifficultyGuiDifficultyGuiPageName() {
        return adminGuiDifficultyGuiDifficultyGuiPageName;
    }

    public String getAdminGuiDifficultyGuiPeaceful() {
        return adminGuiDifficultyGuiPeaceful;
    }

    public String getAdminGuiDifficultyGuiEasy() {
        return adminGuiDifficultyGuiEasy;
    }

    public String getAdminGuiDifficultyGuiMedium() {
        return adminGuiDifficultyGuiMedium;
    }

    public String getAdminGuiDifficultyGuiHard() {
        return adminGuiDifficultyGuiHard;
    }

    public String getAdminGuiTimeGuiChatResponse() {
        return adminGuiTimeGuiChatResponse;
    }

    public String getAdminGuiTimeGuiPageName() {
        return adminGuiTimeGuiPageName;
    }

    public String getAdminGuiTimeGuiDay() {
        return adminGuiTimeGuiDay;
    }

    public String getAdminGuiTimeGuiNoon() {
        return adminGuiTimeGuiNoon;
    }

    public String getAdminGuiTimeGuiMidNight() {
        return adminGuiTimeGuiMidNight;
    }

    public String getAdminGuiTimeGuiNight() {
        return adminGuiTimeGuiNight;
    }

    public String getAdminGuiTimeGuiNumber() {
        return adminGuiTimeGuiNumber;
    }

    public String getAdminGuiWeatherGuiWeatherGuiPageName() {
        return adminGuiWeatherGuiWeatherGuiPageName;
    }

    public String getAdminGuiWeatherGuiSunny() {
        return adminGuiWeatherGuiSunny;
    }

    public String getAdminGuiWeatherGuiRainy() {
        return adminGuiWeatherGuiRainy;
    }

    public String getAdminGuiWeatherGuiThunder() {
        return adminGuiWeatherGuiThunder;
    }

    public String getAdminGuiWorldToolsGuiWorldToolsGuiPageName() {
        return adminGuiWorldToolsGuiWorldToolsGuiPageName;
    }

    public String getAdminGuiWorldToolsGuiDefaultGamemodeName() {
        return adminGuiWorldToolsGuiDefaultGamemodeName;
    }

    public String getAdminGuiWorldToolsGuiDefaultGamemodeLore() {
        return adminGuiWorldToolsGuiDefaultGamemodeLore;
    }

    public String getAdminGuiWorldToolsGuiWorldDifficultyName() {
        return adminGuiWorldToolsGuiWorldDifficultyName;
    }

    public String getAdminGuiWorldToolsGuiWorldDifficultyLore() {
        return adminGuiWorldToolsGuiWorldDifficultyLore;
    }

    public String getAdminGuiWorldToolsGuiGamemodeName() {
        return adminGuiWorldToolsGuiGamemodeName;
    }

    public String getAdminGuiWorldToolsGuiGamemodeLore() {
        return adminGuiWorldToolsGuiGamemodeLore;
    }

    public String getAdminGuiWorldToolsGuiReloadName() {
        return adminGuiWorldToolsGuiReloadName;
    }

    public String getAdminGuiWorldToolsGuiReloadLore() {
        return adminGuiWorldToolsGuiReloadLore;
    }

    public String getAdminGuiWorldToolsGuiSayName() {
        return adminGuiWorldToolsGuiSayName;
    }

    public String getAdminGuiWorldToolsGuiSayLore() {
        return adminGuiWorldToolsGuiSayLore;
    }

    public String getAdminGuiWorldToolsGuiSeedName() {
        return adminGuiWorldToolsGuiSeedName;
    }

    public String getAdminGuiWorldToolsGuiSeedLore() {
        return adminGuiWorldToolsGuiSeedLore;
    }

    public String getAdminGuiWorldToolsGuiSetWorldSpawnName() {
        return adminGuiWorldToolsGuiSetWorldSpawnName;
    }

    public String getAdminGuiWorldToolsGuiSetWorldSpawnLore() {
        return adminGuiWorldToolsGuiSetWorldSpawnLore;
    }

    public String getAdminGuiWorldToolsGuiSpawnPointName() {
        return adminGuiWorldToolsGuiSpawnPointName;
    }

    public String getAdminGuiWorldToolsGuiSpawnPointLore() {
        return adminGuiWorldToolsGuiSpawnPointLore;
    }

    public String getAdminGuiWorldToolsGuiTimeName() {
        return adminGuiWorldToolsGuiTimeName;
    }

    public String getAdminGuiWorldToolsGuiTimeLore() {
        return adminGuiWorldToolsGuiTimeLore;
    }

    public String getAdminGuiWorldToolsGuiWeatherName() {
        return adminGuiWorldToolsGuiWeatherName;
    }

    public String getAdminGuiWorldToolsGuiWeatherLore() {
        return adminGuiWorldToolsGuiWeatherLore;
    }

    public String getAdminGuiWorldToolsGuiWorldBorderName() {
        return adminGuiWorldToolsGuiWorldBorderName;
    }

    public String getAdminGuiWorldToolsGuiWorldBorderLore() {
        return adminGuiWorldToolsGuiWorldBorderLore;
    }

    public String getAdminGuiWorldToolsGuiXpName() {
        return adminGuiWorldToolsGuiXpName;
    }

    public String getAdminGuiWorldToolsGuiXpLore() {
        return adminGuiWorldToolsGuiXpLore;
    }

    public String getAdminGuiWorldToolsGuiXpChatMessage(String message) {
        return adminGuiWorldToolsGuiXpChatMessage.replaceAll(LiteralType.CANCEL_MODEL, message);
    }

    public String getAdminGuiWorldToolsGuiXpChatCanceledMessage() {
        return adminGuiWorldToolsGuiXpChatCanceledMessage;
    }

    public String getAdminGuiWorldToolsGuiTitleName() {
        return adminGuiWorldToolsGuiTitleName;
    }

    public String getAdminGuiWorldToolsGuiTitleLore() {
        return adminGuiWorldToolsGuiTitleLore;
    }

    public String getAdminGuiWorldToolsGuiTitleChatMessage(String message) {
        return adminGuiWorldToolsGuiTitleChatMessage.replaceAll(LiteralType.CANCEL_MODEL, message);
    }

    public String getAdminGuiWorldToolsGuiTitleChatCanceledMessage() {
        return adminGuiWorldToolsGuiTitleChatCanceledMessage;
    }

    public String getAdminGuiWorldToolsGuiTellName() {
        return adminGuiWorldToolsGuiTellName;
    }

    public String getAdminGuiWorldToolsGuiTellLore() {
        return adminGuiWorldToolsGuiTellLore;
    }

    public String getAdminGuiWorldToolsGuiTellChatMessage(String message) {
        return adminGuiWorldToolsGuiTellChatMessage.replaceAll(LiteralType.CANCEL_MODEL, message);
    }

    public String getAdminGuiWorldToolsGuiTellChatCanceledMessage() {
        return adminGuiWorldToolsGuiTellChatCanceledMessage;
    }

    public String getLogsFromDay() {
        return logsFromDay;
    }

    public String getLogsFromDateInterval() {
        return logsFromDateInterval;
    }

    public String getBansGuiSelectTime() {
        return bansGuiSelectTime;
    }

    public String getChooseTimeGuiSeconds() {
        return chooseTimeGuiSeconds;
    }

    public String getChooseTimeGuiMinutes() {
        return chooseTimeGuiMinutes;
    }

    public String getChooseTimeGuiHours() {
        return chooseTimeGuiHours;
    }

    public String getChooseTimeGuiDays() {
        return chooseTimeGuiDays;
    }

    public String getChooseTimeGuiWeeks() {
        return chooseTimeGuiWeeks;
    }

    public String getChooseTimeGuiMonths() {
        return chooseTimeGuiMonths;
    }

    public String getChooseTimeGuiYears() {
        return chooseTimeGuiYears;
    }

    public String getSinglePlayerGuiReleasePlayer() {
        return singlePlayerGuiReleasePlayer;
    }

    public String getMutesGuiMutedBy(String player) {
        return mutesGuiMutedBy.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getMutesGuiExpiredDate(String date) {
        return mutesGuiExpiredDate.replaceAll(LiteralType.DATE, date);
    }

    public String getMutesGuiUnmute(String player) {
        return mutesGuiUnmute.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getBanDescriptionBannedBy(String date) {
        return banDescriptionBannedBy.replaceAll(LiteralType.DATE, date);
    }

    public String getBanDescriptionBannedDate(String date) {
        return banDescriptionBannedDate.replaceAll(LiteralType.DATE, date);
    }

    public String getBanDescriptionExpiredDate(String date) {
        return banDescriptionExpiredDate.replaceAll(LiteralType.DATE, date);
    }

    public String getLogsName() {
        return logsName;
    }

    public String getBanDescriptionComment(String comment) {
        return banDescriptionComment.replaceAll(LiteralType.COMMENT, comment);
    }

    public String getBansGuiUnban(String player) {
        return bansGuiUnban.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getChooseTimeGuiExit() {
        return chooseTimeGuiExit;
    }

    public String getAdminGuiUnknownStatus() {
        return adminGuiUnknownStatus;
    }

    public String getChooseTimeGuiPageName() {
        return chooseTimeGuiPageName;
    }

    public String getChooseTimeGuiSecond() {
        return chooseTimeGuiSecond;
    }

    public String getChooseTimeGuiMinute() {
        return chooseTimeGuiMinute;
    }

    public String getChooseTimeGuiHour() {
        return chooseTimeGuiHour;
    }

    public String getChooseTimeGuiDay() {
        return chooseTimeGuiDay;
    }

    public String getChooseTimeGuiWeek() {
        return chooseTimeGuiWeek;
    }

    public String getChooseTimeGuiMonth() {
        return chooseTimeGuiMonth;
    }

    public String getChooseTimeGuiYear() {
        return chooseTimeGuiYear;
    }

    public String getAdminGuiExpiredTime() {
        return adminGuiExpiredTime;
    }

    public String getAdminGuiExecute(String title) {
        return adminGuiExecute.replaceAll(LiteralType.TITLE, title);
    }

    public String getSinglePlayerGuiBanGuiPageName(String player) {
        return singlePlayerGuiBanGuiPageName.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getSinglePlayerGuiPageName(String player) {
        return singlePlayerGuiPageName.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getSinglePlayerGuiStatus_online() {
        return singlePlayerGuiStatus_online;
    }

    public String getSinglePlayerGuiStatus_offline() {
        return singlePlayerGuiStatus_offline;
    }

    public String getSinglePlayerGuiKillPlayer() {
        return singlePlayerGuiKillPlayer;
    }

    public String getSinglePlayerGuiFreezePlayer() {
        return singlePlayerGuiFreezePlayer;
    }

    public String getSinglePlayerGuiTeleportPlayer() {
        return singlePlayerGuiTeleportPlayer;
    }

    public String getSinglePlayerGuiTeleportToPlayer() {
        return singlePlayerGuiTeleportToPlayer;
    }

    public String getSinglePlayerGuiBanPlayer() {
        return singlePlayerGuiBanPlayer;
    }

    public String getSinglePlayerGuiMutePlayer() {
        return singlePlayerGuiMutePlayer;
    }

    public String getSinglePlayerGuiInventory() {
        return singlePlayerGuiInventory;
    }

    public String getSinglePlayerGuiEnderChest() {
        return singlePlayerGuiEnderChest;
    }

    public String getSinglePlayerGuiHidePlayer() {
        return singlePlayerGuiHidePlayer;
    }

    public String getSinglePlayerGuiHidePlayer_current() {
        return singlePlayerGuiHidePlayer_current;
    }

    public String getSinglePlayerGuiKickPlayer() {
        return singlePlayerGuiKickPlayer;
    }

    public String getSinglePlayerGuiTemporaryBanPlayer() {
        return singlePlayerGuiTemporaryBanPlayer;
    }

    public String getAdminToolsGuiPageName() {
        return adminToolsGuiPageName;
    }

    public String getAdminToolsGuiAdminAxe() {
        return adminToolsGuiAdminAxe;
    }

    public String getAdminToolsGuiAdminPickAxe() {
        return adminToolsGuiAdminPickAxe;
    }

    public String getAdminToolsGuiAdminShovel() {
        return adminToolsGuiAdminShovel;
    }

    public String getAdminToolsGuiAdminSword() {
        return adminToolsGuiAdminSword;
    }

    public String getAdminToolsGuiAdminBow() {
        return adminToolsGuiAdminBow;
    }

    public String getAdminToolsGuiAdminHoe() {
        return adminToolsGuiAdminHoe;
    }

    public String getAdminStaffGuiPageName() {
        return adminStaffGuiPageName;
    }

    public String getAdminStaffGuiVanish() {
        return adminStaffGuiVanish;
    }

    public String getAdminStaffGuiVanish_current() {
        return adminStaffGuiVanish_current;
    }

    public String getAdminStaffGuiMaintenance() {
        return adminStaffGuiMaintenance;
    }

    public String getAdminStaffGuiAdminTools() {
        return adminStaffGuiAdminTools;
    }

    public String getBansGuiPageName() {
        return bansGuiPageName;
    }

    public String getBansGuiBannedPlayersList() {
        return bansGuiBannedPlayersList;
    }

    public String getBansGuiTemporaryBannedPlayersList() {
        return bansGuiTemporaryBannedPlayersList;
    }

    public String getBansGuiMutedPlayers() {
        return bansGuiMutedPlayers;
    }

    public String getBansGuiFrozenPlayersList() {
        return bansGuiFrozenPlayersList;
    }

    public String getBansGuiHiddenPlayers() {
        return bansGuiHiddenPlayers;
    }

    public String getMainGuiPageName() {
        return mainGuiPageName;
    }

    public String getMainGuiBans() {
        return mainGuiBans;
    }

    public String getMainGuiAdminStaff() {
        return mainGuiAdminStaff;
    }

    public String getPlayersGuiPageName() {
        return playersGuiPageName;
    }

    public String getAdminGuiBack() {
        return adminGuiBack;
    }

    public String getAdminGuiClose() {
        return adminGuiClose;
    }

    public String getLogsTimeGuiTitle() {
        return logsTimeGuiTitle;
    }

    public String getLogsTimeOneDay() {
        return logsTimeOneDay;
    }

    public String getLogsTimeMultiDay() {
        return logsTimeMultiDay;
    }

    public String getFirstCalendarGuiTitle() {
        return firstCalendarGuiTitle;
    }

    public String getSecondCalendarGuiTitle() {
        return secondCalendarGuiTitle;
    }

    public String getCalendarGuiTitle() {
        return calendarGuiTitle;
    }

    public String getLogsGuiTitle() {
        return logsGuiTitle;
    }

    public String getLogsForAll() {
        return logsForAll;
    }

    public String getLogsForOnePlayer() {
        return logsForOnePlayer;
    }

    public String getCalendarGuiFirstDate() {
        return calendarGuiFirstDate;
    }

    public String getCalendarGuiEndDate() {
        return calendarGuiEndDate;
    }

    public String getSinglePlayerGuiStatus_offline_never_player_before() {
        return singlePlayerGuiStatus_offline_never_player_before;
    }

    public String getAdminGuiWorldToolsGuiEnterMessageInChat() {
        return adminGuiWorldToolsGuiEnterMessageInChat;
    }
}
