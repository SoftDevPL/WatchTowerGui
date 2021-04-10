package watchtowergui.wg.fileManager.configsutils.configs;

import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.LiteralType;

public class GuiLanguageConfig extends ConfigAccessor {

    private String adminStaffGuiDisableChat;
    private String adminStaffGuiDisableChatCurrent;
    private String singlePlayerGuiUnbanPlayer;
    private String singlePlayerGuiTempUnbanPlayer;
    private String singlePlayerGuiUnMutePlayer;
    private String adminStaffGuiMaintenanceCurrent;
    private String singlePlayerGuiLastActivity;
    private String singlePlayerGuiPlayerLocationName;
    private String singlePlayerGuiPlayerLocationX;
    private String singlePlayerGuiPlayerLocationY;
    private String singlePlayerGuiPlayerLocationZ;
    private String singlePlayerGuiPlayerLocationClickToTeleportToPlayer;
    private String singlePlayerGuiPlayerLocationLocationPlayersOffline;
    private String singlePlayerGuiPlayerInfoMuted;
    private String singlePlayerGuiStatus_offline_never_player_before;
    private String worldToolsGuiSelectPlayer;
    private String serverControlGuiGuiTitle;
    private String serverControlGuiPluginListName;
    private String serverControlGuiPluginListLore;
    private String serverControlGuiManageCommandsName;
    private String serverControlGuiManageCommandsLore;
    private String singlePluginGuiCreatePluginNameItemVersion;
    private String singlePluginGuiCreatePluginDescriptionItemDescription;
    private String singlePluginGuiCreatePluginDescriptionItemLore;
    private String singlePluginGuiCreatePluginDescriptionItemNotSpecified;
    private String singlePluginGuiCreateAuthorsItemAuthors;
    private String singlePluginGuiCreateAuthorsItemLore;
    private String singlePluginGuiCreateAuthorsItemNotSpecified;
    private String singlePluginGuiCreateWebsiteItemWebsite;
    private String singlePluginGuiCreateWebsiteItemLore;
    private String singlePluginGuiCreateWebsiteItemNotSpecified;
    private String singlePluginGuiCreatePluginCommandsItemName;
    private String singlePluginGuiCreatePluginCommandsItemCommands_lore;
    private String singlePluginGuiCreatePluginCommandsItemNo_commands_lore;
    private String singlePluginGuiCreateDependItemName;
    private String singlePluginGuiCreateDependItemLore;
    private String pluginControlGuiGetDescriptionItemLore;
    private String aliasGuiCommandNameAliasesPageName;
    private String aliasGuiAddAliasItemName;
    private String aliasGuiRemoveAliasItemName;
    private String aliasGuiTypeNewAlias;
    private String aliasGuiEnterAliasAgain;
    private String aliasGuiAliasRemoved;
    private String aliasGuiCantRemovedAlias;
    private String aliasGuiCancelPhrase;
    private String commandControlGuiPageName;
    private String commandControlGuiFilterOn;
    private String commandControlGuiFilterOff;
    private String commandControlGuiGetUsage;
    private String commandControlGuiGetLabel;
    private String commandControlGuiStatusOn;
    private String commandControlGuiStatusOff;
    private String commandControlGuiGetAliases;
    private String commandControlGuiGetPlugin;
    private String commandControlGuiGetEditLabel;
    private String commandControlGuiActiveCommandsFilterItem;
    private String commandControlGuiDisabledCommandsFilterItem;
    private String commandControlGuiAlphabeticOrderFilterItem;
    private String commandControlGuiPluginOrderFilterItem;
    private String commandControlGuiVanillaCommandsFilterItem;
    private String commandControlGuiPluginCommandsFilterItem;
    private String singleCommandGuiAreYouSure;
    private String singleCommandGuiReceiveChangeLabelResult;
    private String singleCommandGuiCheckIsLabelEnterCancelCancelPhrase;
    private String singleCommandGuiReceiveDisableResultCanNotDisable;
    private String singleCommandGuiReceiveDisableResultSuccessfullyDisabled;
    private String singleCommandGuiSetCommandEnableEnterNewLabel;
    private String singleCommandGuiCreatePermissionItemName;
    private String singleCommandGuiCreatePermissionNotSpecified;
    private String singleCommandGuiCreateNameItemName;
    private String singleCommandGuiCreateNameItemLore_1;
    private String singleCommandGuiCreateNameItemLore_2;
    private String singleCommandGuiCreateAliasesItemName;
    private String singleCommandGuiCreateAliasesItemLore;
    private String singleCommandGuiCreatePluginItemNameSpecified;
    private String singleCommandGuiCreatePluginItemNameNotSpecified;
    private String singleCommandGuiCreateUsageItemName;
    private String singleCommandGuiCreateUsageItemNotSpecified;
    private String singleCommandGuiCreateDescriptionItemName;
    private String singleCommandGuiCreateActiveStatusItemName;
    private String singleCommandGuiCreateDisableStatusItemName;
    private String commandControlListenerShowError;
    private String commandControlListenerNewCommandAlias;
    private String commandControlListenerLoadAddedAliases;
    private String commandControlListenerEnableCommandNotExists;
    private String commandControlListenerEnableCommandCommandAlreadyExists;
    private String commandControlListenerAliasAlreadyExistsAlreadyExists;
    private String commandControlListenerAliasAlreadyExistsSuccessfullyEnabled;
    private String commandControlListenerChangeLabelNotExists;
    private String commandControlListenerChangeLabelCanNotBeChanged;
    private String commandControlListenerChangeLabelSuccessfullyChanged;
    private String commandControlListenerAddAliasNotExists;
    private String commandControlListenerAddAliasSuccessfullyAdded;
    private String commandControlListenerOnlyViableAliasMessage;
    private String commandControlListenerCommandHasThatAliasOrLabel;
    private String commandControlListenerCommandHasThatAlias;
    private String commandMenuPageName;
    private String singlePlayerGuiHomesList;
    private String adminGuiPlayersGuiShowOfflinePlayersName;
    private String adminGuiPlayersGuiShowOfflinePlayersON;
    private String adminGuiPlayersGuiShowOfflinePlayersOFF;
    private String mainGuiPlayers;
    private String adminGuiMainGuiManageServer;
    private String adminGuiUnknownStatus;
    private String adminGuiBack;
    private String adminGuiClose;
    private String adminGuiExecute;
    private String adminGuiExpiredTime;
    private String mainGuiPageName;
    private String mainGuiBans;
    private String mainGuiAdminStaff;
    private String playersGuiPageName;
    private String bansGuiPageName;
    private String bansGuiBannedPlayersList;
    private String bansGuiTemporaryBannedPlayersList;
    private String bansGuiMutedPlayers;
    private String bansGuiFrozenPlayersList;
    private String bansGuiHiddenPlayers;
    private String adminStaffGuiPageName;
    private String adminStaffGuiVanish;
    private String adminStaffGuiVanish_current;
    private String adminStaffGuiMaintenance;
    private String adminStaffGuiAdminTools;
    private String adminToolsGuiPageName;
    private String adminToolsGuiAdminAxe;
    private String adminToolsGuiAdminPickAxe;
    private String adminToolsGuiAdminShovel;
    private String adminToolsGuiAdminSword;
    private String adminToolsGuiAdminBow;
    private String adminToolsGuiAdminHoe;
    private String singlePlayerGuiStatus_online;
    private String singlePlayerGuiStatus_offline;
    private String singlePlayerGuiKillPlayer;
    private String singlePlayerGuiFreezePlayer;
    private String singlePlayerGuiTeleportPlayer;
    private String singlePlayerGuiTeleportToPlayer;
    private String singlePlayerGuiBanPlayer;
    private String singlePlayerGuiMutePlayer;
    private String singlePlayerGuiInventory;
    private String singlePlayerGuiEnderChest;
    private String singlePlayerGuiHidePlayer;
    private String singlePlayerGuiHidePlayer_current;
    private String singlePlayerGuiKickPlayer;
    private String singlePlayerGuiTemporaryBanPlayer;
    private String singlePlayerGuiBanGuiPageName;
    private String singlePlayerGuiPageName;
    private String singlePlayerGuiReleasePlayer;
    private String chooseTimeGuiPageName;
    private String chooseTimeGuiSecond;
    private String chooseTimeGuiMinute;
    private String chooseTimeGuiHour;
    private String chooseTimeGuiDay;
    private String chooseTimeGuiWeek;
    private String chooseTimeGuiMonth;
    private String chooseTimeGuiYear;
    private String chooseTimeGuiSeconds;
    private String chooseTimeGuiMinutes;
    private String chooseTimeGuiHours;
    private String chooseTimeGuiDays;
    private String chooseTimeGuiWeeks;
    private String chooseTimeGuiMonths;
    private String chooseTimeGuiYears;
    private String chooseTimeGuiExit;
    private String bansGuiUnban;
    private String banDescriptionBannedBy;
    private String banDescriptionBannedDate;
    private String banDescriptionExpiredDate;
    private String banDescriptionComment;
    private String mutesGuiMutedBy;
    private String mutesGuiExpiredDate;
    private String mutesGuiUnmute;
    private String bansGuiSelectTime;
    private String logsName;
    private String logsGuiSelectPlayer;
    private String logsGuiTitle;
    private String logsForAll;
    private String logsForOnePlayer;
    private String firstCalendarGuiTitle;
    private String secondCalendarGuiTitle;
    private String calendarGuiTitle;
    private String logsTimeGuiTitle;
    private String logsTimeOneDay;
    private String logsTimeMultiDay;
    private String firstDate;
    private String endDate;
    private String logsFromDay;
    private String logsFromDateInterval;
    private String adminGuiWorldToolsGuiEnterMessageInChat;
    private String adminGuiWorldToolsGuiWorldToolsGuiPageName;
    private String adminGuiWorldToolsGuiDefaultGamemodeName;
    private String adminGuiWorldToolsGuiDefaultGamemodeLore;
    private String adminGuiWorldToolsGuiWorldDifficultyName;
    private String adminGuiWorldToolsGuiWorldDifficultyLore;
    private String adminGuiWorldToolsGuiGamemodeName;
    private String adminGuiWorldToolsGuiGamemodeLore;
    private String adminGuiWorldToolsGuiReloadName;
    private String adminGuiWorldToolsGuiReloadLore;
    private String adminGuiWorldToolsGuiSayName;
    private String adminGuiWorldToolsGuiSayLore;
    private String adminGuiWorldToolsGuiSeedName;
    private String adminGuiWorldToolsGuiSeedLore;
    private String adminGuiWorldToolsGuiSetWorldSpawnName;
    private String adminGuiWorldToolsGuiSetWorldSpawnLore;
    private String adminGuiWorldToolsGuiSpawnPointName;
    private String adminGuiWorldToolsGuiSpawnPointLore;
    private String adminGuiWorldToolsGuiTimeName;
    private String adminGuiWorldToolsGuiTimeLore;
    private String adminGuiWorldToolsGuiWeatherName;
    private String adminGuiWorldToolsGuiWeatherLore;
    private String adminGuiWorldToolsGuiWorldBorderName;
    private String adminGuiWorldToolsGuiWorldBorderLore;
    private String adminGuiWorldToolsGuiXpName;
    private String adminGuiWorldToolsGuiXpLore;
    private String adminGuiWorldToolsGuiXpChatMessage;
    private String adminGuiWorldToolsGuiXpChatCanceledMessage;
    private String adminGuiWorldToolsGuiTitleName;
    private String adminGuiWorldToolsGuiTitleLore;
    private String adminGuiWorldToolsGuiTitleChatMessage;
    private String adminGuiWorldToolsGuiTitleChatCanceledMessage;
    private String adminGuiWorldToolsGuiTellName;
    private String adminGuiWorldToolsGuiTellLore;
    private String adminGuiWorldToolsGuiTellChatMessage;
    private String adminGuiWorldToolsGuiTellChatCanceledMessage;
    private String adminGuiWeatherGuiWeatherGuiPageName;
    private String adminGuiWeatherGuiSunny;
    private String adminGuiWeatherGuiRainy;
    private String adminGuiWeatherGuiThunder;
    private String adminGuiTimeGuiPageName;
    private String adminGuiTimeGuiDay;
    private String adminGuiTimeGuiNoon;
    private String adminGuiTimeGuiMidNight;
    private String adminGuiTimeGuiNight;
    private String adminGuiTimeGuiNumber;
    private String adminGuiTimeGuiChatResponse;
    private String adminGuiDifficultyGuiDifficultyGuiPageName;
    private String adminGuiDifficultyGuiPeaceful;
    private String adminGuiDifficultyGuiEasy;
    private String adminGuiDifficultyGuiMedium;
    private String adminGuiDifficultyGuiHard;
    private String adminGuiGamemodeGuiGamemodeGuiPageName;
    private String adminGuiGamemodeGuiSurvival;
    private String adminGuiGamemodeGuiCreative;
    private String adminGuiGamemodeGuiHardcore;
    private String adminGuiGamemodeGuiSpectator;
    private String adminGuiDefaultGamemodeGuiDefaultGamemodeGuiPageName;
    private String adminGuiDefaultGamemodeGuiSurvival;
    private String adminGuiDefaultGamemodeGuiCreative;
    private String adminGuiDefaultGamemodeGuiHardcore;
    private String adminGuiDefaultGamemodeGuiSpectator;
    private String adminGuiWorldBorderGuiWorldBorderGuiPageName;
    private String adminGuiWorldBorderGuiAddToWorldBorderName;
    private String adminGuiWorldBorderGuiAddToWorldBorderLore;
    private String adminGuiWorldBorderGuiAddToWorldBorderChatMessage;
    private String adminGuiWorldBorderGuiGetWorldBorderName;
    private String adminGuiWorldBorderGuiGetWorldBorderLore;
    private String adminGuiWorldBorderGuiWorldBorderWarningName;
    private String adminGuiWorldBorderGuiWorldBorderWarningLore;
    private String adminGuiWorldBorderGuiWorldBorderWarningChatMessage;
    private String adminGuiWorldBorderGuiWorldBorderDamageName;
    private String adminGuiWorldBorderGuiWorldBorderDamageLore;
    private String adminGuiWorldBorderGuiWorldBorderDamageChatMessage;
    private String adminGuiWorldBorderGuiCenterWorldBorderName;
    private String adminGuiWorldBorderGuiCenterWorldBorderLore;
    private String adminGuiWorldBorderGuiCenterWorldBorderChatMessage;
    private String adminGuiWorldBorderGuiSetWorldBorderName;
    private String adminGuiWorldBorderGuiSetWorldBorderLore;
    private String adminGuiWorldBorderGuiSetWorldBorderChatMessage;

    public void init() {
        super.init("GuiLanguageConfig", "locale/");
        this.singlePlayerGuiLastActivity = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.lastActivity");
        this.singlePlayerGuiPlayerLocationName = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.playerLocation.name");
        this.singlePlayerGuiPlayerLocationX = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.playerLocation.x");
        this.singlePlayerGuiPlayerLocationY = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.playerLocation.y");
        this.singlePlayerGuiPlayerLocationZ = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.playerLocation.z");
        this.singlePlayerGuiPlayerLocationClickToTeleportToPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.playerLocation.clickToTeleportToPlayer");
        this.singlePlayerGuiPlayerLocationLocationPlayersOffline = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.playerLocation.locationPlayersOffline");
        this.singlePlayerGuiPlayerInfoMuted = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.playerInfo.muted");
        this.singlePlayerGuiStatus_offline_never_player_before = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.status_offline_never_player_before");
        this.singlePlayerGuiUnbanPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.unbanPlayer");
        this.singlePlayerGuiTempUnbanPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.tempUnbanPlayer");
        this.singlePlayerGuiUnMutePlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.unMutePlayer");
        this.serverControlGuiGuiTitle = this.getStringPath("Guis.adminGui.serverControl.serverControlGui.guiTitle");
        this.serverControlGuiPluginListName = this.getStringPath("Guis.adminGui.serverControl.serverControlGui.pluginList.name");
        this.serverControlGuiPluginListLore = this.getStringPath("Guis.adminGui.serverControl.serverControlGui.pluginList.lore");
        this.serverControlGuiManageCommandsName = this.getStringPath("Guis.adminGui.serverControl.serverControlGui.manageCommands.name");
        this.serverControlGuiManageCommandsLore = this.getStringPath("Guis.adminGui.serverControl.serverControlGui.manageCommands.lore");
        this.singlePluginGuiCreatePluginDescriptionItemLore = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createPluginDescriptionItem.lore");
        this.singlePluginGuiCreateAuthorsItemLore = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createAuthorsItem.lore");
        this.singlePluginGuiCreateWebsiteItemLore = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createWebsiteItem.lore");
        this.singlePluginGuiCreatePluginNameItemVersion = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createPluginNameItem.version");
        this.singlePluginGuiCreatePluginDescriptionItemDescription = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createPluginDescriptionItem.description");
        this.singlePluginGuiCreatePluginDescriptionItemNotSpecified = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createPluginDescriptionItem.notSpecified");
        this.singlePluginGuiCreateAuthorsItemAuthors = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createAuthorsItem.authors");
        this.singlePluginGuiCreateAuthorsItemNotSpecified = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createAuthorsItem.notSpecified");
        this.singlePluginGuiCreateWebsiteItemWebsite = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createWebsiteItem.website");
        this.singlePluginGuiCreateWebsiteItemNotSpecified = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createWebsiteItem.notSpecified");
        this.singlePluginGuiCreatePluginCommandsItemName = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createPluginCommandsItem.name");
        this.singlePluginGuiCreatePluginCommandsItemCommands_lore = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createPluginCommandsItem.commands_lore");
        this.singlePluginGuiCreatePluginCommandsItemNo_commands_lore = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createPluginCommandsItem.no_commands_lore");
        this.singlePluginGuiCreateDependItemName = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createDependItem.name");
        this.singlePluginGuiCreateDependItemLore = this.getStringPath("Guis.adminGui.serverControl.singlePluginGui.createDependItem.lore");
        this.pluginControlGuiGetDescriptionItemLore = this.getStringPath("Guis.adminGui.serverControl.pluginControlGui.getDescriptionItem.lore");
        this.singleCommandGuiAreYouSure = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.areYouSure");
        this.singleCommandGuiReceiveChangeLabelResult = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.receiveChangeLabelResult");
        this.singleCommandGuiCheckIsLabelEnterCancelCancelPhrase = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.checkIsLabelEnterCancel.cancelPhrase");
        this.singleCommandGuiReceiveDisableResultCanNotDisable = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.receiveDisableResult.canNotDisable");
        this.singleCommandGuiReceiveDisableResultSuccessfullyDisabled = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.receiveDisableResult.successfullyDisabled");
        this.singleCommandGuiSetCommandEnableEnterNewLabel = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.setCommandEnable.enterNewLabel");
        this.singleCommandGuiCreatePermissionItemName = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createPermissionItem.name");
        this.singleCommandGuiCreatePermissionNotSpecified = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createPermissionItem.notSpecified");
        this.singleCommandGuiCreateNameItemName = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createNameItem.name");
        this.singleCommandGuiCreateNameItemLore_1 = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createNameItem.lore_1");
        this.singleCommandGuiCreateNameItemLore_2 = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createNameItem.lore_2");
        this.singleCommandGuiCreateAliasesItemName = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createAliasesItem.name");
        this.singleCommandGuiCreateAliasesItemLore = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createAliasesItem.lore");
        this.singleCommandGuiCreatePluginItemNameSpecified = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createPluginItem.nameSpecified");
        this.singleCommandGuiCreatePluginItemNameNotSpecified = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createPluginItem.nameNotSpecified");
        this.singleCommandGuiCreateUsageItemName = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createUsageItem.name");
        this.singleCommandGuiCreateUsageItemNotSpecified = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createUsageItem.notSpecified");
        this.singleCommandGuiCreateDescriptionItemName = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createDescriptionItem.name");
        this.singleCommandGuiCreateActiveStatusItemName = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createActiveStatusItem.name");
        this.singleCommandGuiCreateDisableStatusItemName = this.getStringPath("Guis.adminGui.serverControl.singleCommandGui.createDisableStatusItem.name");
        this.commandControlListenerShowError = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.showError");
        this.commandControlListenerNewCommandAlias = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.newCommandAlias");
        this.commandControlListenerLoadAddedAliases = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.loadAddedAliases");
        this.commandControlListenerEnableCommandNotExists = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.enableCommand.notExists");
        this.commandControlListenerEnableCommandCommandAlreadyExists = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.enableCommand.commandAlreadyExists");
        this.commandControlListenerAliasAlreadyExistsAlreadyExists = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.aliasAlreadyExists.alreadyExists");
        this.commandControlListenerAliasAlreadyExistsSuccessfullyEnabled = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.aliasAlreadyExists.successfullyEnabled");
        this.commandControlListenerChangeLabelNotExists = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.changeLabel.notExists");
        this.commandControlListenerChangeLabelCanNotBeChanged = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.changeLabel.canNotBeChanged");
        this.commandControlListenerChangeLabelSuccessfullyChanged = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.changeLabel.successfullyChanged");
        this.commandControlListenerAddAliasNotExists = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.addAlias.notExists");
        this.commandControlListenerAddAliasSuccessfullyAdded = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.addAlias.successfullyAdded");
        this.commandControlListenerOnlyViableAliasMessage = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.onlyViableAliasMessage");
        this.commandControlListenerCommandHasThatAliasOrLabel = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.commandHasThatAliasOrLabel");
        this.commandControlListenerCommandHasThatAlias = this.getStringPath("Guis.adminGui.serverControl.commandControlListener.commandHasThatAlias");
        this.commandMenuPageName = this.getStringPath("Guis.adminGui.serverControl.commandMenu.pageName");
        this.adminGuiWorldBorderGuiSetWorldBorderChatMessage = this.getStringPath("Guis.adminGui.worldBorderGui.setWorldBorder.chatMessage");
        this.adminGuiWorldBorderGuiCenterWorldBorderChatMessage = this.getStringPath("Guis.adminGui.worldBorderGui.centerWorldBorder.chatMessage");
        this.adminGuiWorldBorderGuiWorldBorderDamageChatMessage = this.getStringPath("Guis.adminGui.worldBorderGui.worldBorderdamage.chatMessage");
        this.adminGuiWorldBorderGuiWorldBorderWarningChatMessage = this.getStringPath("Guis.adminGui.worldBorderGui.worldBorderWarning.chatMessage");
        this.adminGuiWorldBorderGuiAddToWorldBorderChatMessage = this.getStringPath("Guis.adminGui.worldBorderGui.addToWorldBorder.chatMessage");
        this.adminGuiWorldBorderGuiWorldBorderGuiPageName = this.getStringPath("Guis.adminGui.worldBorderGui.worldBorderGuiPageName");
        this.adminGuiWorldBorderGuiAddToWorldBorderName = this.getStringPath("Guis.adminGui.worldBorderGui.addToWorldBorder.name");
        this.adminGuiWorldBorderGuiAddToWorldBorderLore = this.getStringPath("Guis.adminGui.worldBorderGui.addToWorldBorder.lore");
        this.adminGuiWorldBorderGuiGetWorldBorderName = this.getStringPath("Guis.adminGui.worldBorderGui.getWorldBorder.name");
        this.adminGuiWorldBorderGuiGetWorldBorderLore = this.getStringPath("Guis.adminGui.worldBorderGui.getWorldBorder.lore");
        this.adminGuiWorldBorderGuiWorldBorderWarningName = this.getStringPath("Guis.adminGui.worldBorderGui.worldBorderWarning.name");
        this.adminGuiWorldBorderGuiWorldBorderWarningLore = this.getStringPath("Guis.adminGui.worldBorderGui.worldBorderWarning.lore");
        this.adminGuiWorldBorderGuiWorldBorderDamageName = this.getStringPath("Guis.adminGui.worldBorderGui.worldBorderdamage.name");
        this.adminGuiWorldBorderGuiWorldBorderDamageLore = this.getStringPath("Guis.adminGui.worldBorderGui.worldBorderdamage.lore");
        this.adminGuiWorldBorderGuiCenterWorldBorderName = this.getStringPath("Guis.adminGui.worldBorderGui.centerWorldBorder.name");
        this.adminGuiWorldBorderGuiCenterWorldBorderLore = this.getStringPath("Guis.adminGui.worldBorderGui.centerWorldBorder.lore");
        this.adminGuiWorldBorderGuiSetWorldBorderName = this.getStringPath("Guis.adminGui.worldBorderGui.setWorldBorder.name");
        this.adminGuiWorldBorderGuiSetWorldBorderLore = this.getStringPath("Guis.adminGui.worldBorderGui.setWorldBorder.lore");
        this.adminGuiDefaultGamemodeGuiDefaultGamemodeGuiPageName = this.getStringPath("Guis.adminGui.defaultGamemodeGui.defaultGamemodeGuiPageName");
        this.adminGuiDefaultGamemodeGuiSurvival = this.getStringPath("Guis.adminGui.defaultGamemodeGui.survival");
        this.adminGuiDefaultGamemodeGuiCreative = this.getStringPath("Guis.adminGui.defaultGamemodeGui.creative");
        this.adminGuiDefaultGamemodeGuiHardcore = this.getStringPath("Guis.adminGui.defaultGamemodeGui.hardcore");
        this.adminGuiDefaultGamemodeGuiSpectator = this.getStringPath("Guis.adminGui.defaultGamemodeGui.spectator");
        this.adminGuiGamemodeGuiGamemodeGuiPageName = this.getStringPath("Guis.adminGui.gamemodeGui.gamemodeGuiPageName");
        this.adminGuiGamemodeGuiSurvival = this.getStringPath("Guis.adminGui.gamemodeGui.survival");
        this.adminGuiGamemodeGuiCreative = this.getStringPath("Guis.adminGui.gamemodeGui.creative");
        this.adminGuiGamemodeGuiHardcore = this.getStringPath("Guis.adminGui.gamemodeGui.hardcore");
        this.adminGuiGamemodeGuiSpectator = this.getStringPath("Guis.adminGui.gamemodeGui.spectator");
        this.adminGuiDifficultyGuiDifficultyGuiPageName = this.getStringPath("Guis.adminGui.difficultyGui.difficultyGuiPageName");
        this.adminGuiDifficultyGuiPeaceful = this.getStringPath("Guis.adminGui.difficultyGui.peaceful");
        this.adminGuiDifficultyGuiEasy = this.getStringPath("Guis.adminGui.difficultyGui.easy");
        this.adminGuiDifficultyGuiMedium = this.getStringPath("Guis.adminGui.difficultyGui.normal");
        this.adminGuiDifficultyGuiHard = this.getStringPath("Guis.adminGui.difficultyGui.hard");
        this.adminGuiTimeGuiChatResponse = this.getStringPath("Guis.adminGui.timeGui.chatResponse");
        this.adminGuiTimeGuiPageName = this.getStringPath("Guis.adminGui.timeGui.timeGuiPageName");
        this.adminGuiTimeGuiDay = this.getStringPath("Guis.adminGui.timeGui.day");
        this.adminGuiTimeGuiNoon = this.getStringPath("Guis.adminGui.timeGui.noon");
        this.adminGuiTimeGuiMidNight = this.getStringPath("Guis.adminGui.timeGui.midNight");
        this.adminGuiTimeGuiNight = this.getStringPath("Guis.adminGui.timeGui.night");
        this.adminGuiTimeGuiNumber = this.getStringPath("Guis.adminGui.timeGui.number");
        this.adminGuiWeatherGuiWeatherGuiPageName = this.getStringPath("Guis.adminGui.weatherGui.weatherGuiPageName");
        this.adminGuiWeatherGuiSunny = this.getStringPath("Guis.adminGui.weatherGui.sunny");
        this.adminGuiWeatherGuiRainy = this.getStringPath("Guis.adminGui.weatherGui.rainy");
        this.adminGuiWeatherGuiThunder = this.getStringPath("Guis.adminGui.weatherGui.thunder");
        this.adminGuiWorldToolsGuiWorldToolsGuiPageName = this.getStringPath("Guis.adminGui.worldToolsGui.worldToolsGuiPageName");
        this.adminGuiWorldToolsGuiEnterMessageInChat = this.getStringPath("Guis.adminGui.worldToolsGui.enterMessageInChat");
        this.adminGuiWorldToolsGuiDefaultGamemodeName = this.getStringPath("Guis.adminGui.worldToolsGui.defaultGamemode.name");
        this.adminGuiWorldToolsGuiDefaultGamemodeLore = this.getStringPath("Guis.adminGui.worldToolsGui.defaultGamemode.lore");
        this.adminGuiWorldToolsGuiWorldDifficultyName = this.getStringPath("Guis.adminGui.worldToolsGui.difficulty.name");
        this.adminGuiWorldToolsGuiWorldDifficultyLore = this.getStringPath("Guis.adminGui.worldToolsGui.difficulty.lore");
        this.adminGuiWorldToolsGuiGamemodeName = this.getStringPath("Guis.adminGui.worldToolsGui.gamemode.name");
        this.adminGuiWorldToolsGuiGamemodeLore = this.getStringPath("Guis.adminGui.worldToolsGui.gamemode.lore");
        this.adminGuiWorldToolsGuiReloadName = this.getStringPath("Guis.adminGui.worldToolsGui.reload.name");
        this.adminGuiWorldToolsGuiReloadLore = this.getStringPath("Guis.adminGui.worldToolsGui.reload.lore");
        this.adminGuiWorldToolsGuiSayName = this.getStringPath("Guis.adminGui.worldToolsGui.say.name");
        this.adminGuiWorldToolsGuiSayLore = this.getStringPath("Guis.adminGui.worldToolsGui.say.lore");
        this.adminGuiWorldToolsGuiSeedName = this.getStringPath("Guis.adminGui.worldToolsGui.seed.name");
        this.adminGuiWorldToolsGuiSeedLore = this.getStringPath("Guis.adminGui.worldToolsGui.seed.lore");
        this.adminGuiWorldToolsGuiSetWorldSpawnName = this.getStringPath("Guis.adminGui.worldToolsGui.setWorldSpawn.name");
        this.adminGuiWorldToolsGuiSetWorldSpawnLore = this.getStringPath("Guis.adminGui.worldToolsGui.setWorldSpawn.lore");
        this.adminGuiWorldToolsGuiSpawnPointName = this.getStringPath("Guis.adminGui.worldToolsGui.spawnPoint.name");
        this.adminGuiWorldToolsGuiSpawnPointLore = this.getStringPath("Guis.adminGui.worldToolsGui.spawnPoint.lore");
        this.worldToolsGuiSelectPlayer = this.getStringPath("Guis.adminGui.worldToolsGui.selectPlayerPageName");
        this.adminGuiWorldToolsGuiTimeName = this.getStringPath("Guis.adminGui.worldToolsGui.time.name");
        this.adminGuiWorldToolsGuiTimeLore = this.getStringPath("Guis.adminGui.worldToolsGui.time.lore");
        this.adminGuiWorldToolsGuiWeatherName = this.getStringPath("Guis.adminGui.worldToolsGui.weather.name");
        this.adminGuiWorldToolsGuiWeatherLore = this.getStringPath("Guis.adminGui.worldToolsGui.weather.lore");
        this.adminGuiWorldToolsGuiWorldBorderName = this.getStringPath("Guis.adminGui.worldToolsGui.worldBorder.name");
        this.adminGuiWorldToolsGuiWorldBorderLore = this.getStringPath("Guis.adminGui.worldToolsGui.worldBorder.lore");
        this.adminGuiWorldToolsGuiXpName = this.getStringPath("Guis.adminGui.worldToolsGui.xp.name");
        this.adminGuiWorldToolsGuiXpLore = this.getStringPath("Guis.adminGui.worldToolsGui.xp.lore");
        this.adminGuiWorldToolsGuiXpChatMessage = this.getStringPath("Guis.adminGui.worldToolsGui.xp.chatMessage");
        this.adminGuiWorldToolsGuiXpChatCanceledMessage = this.getStringPath("Guis.adminGui.worldToolsGui.xp.chatCanceledMessage");
        this.adminGuiWorldToolsGuiTitleName = this.getStringPath("Guis.adminGui.worldToolsGui.title.name");
        this.adminGuiWorldToolsGuiTitleLore = this.getStringPath("Guis.adminGui.worldToolsGui.title.lore");
        this.adminGuiWorldToolsGuiTitleChatMessage = this.getStringPath("Guis.adminGui.worldToolsGui.title.chatMessage");
        this.adminGuiWorldToolsGuiTitleChatCanceledMessage = this.getStringPath("Guis.adminGui.worldToolsGui.title.chatCanceledMessage");
        this.adminGuiWorldToolsGuiTellName = this.getStringPath("Guis.adminGui.worldToolsGui.tell.name");
        this.adminGuiWorldToolsGuiTellLore = this.getStringPath("Guis.adminGui.worldToolsGui.tell.lore");
        this.adminGuiWorldToolsGuiTellChatMessage = this.getStringPath("Guis.adminGui.worldToolsGui.tell.chatMessage");
        this.adminGuiWorldToolsGuiTellChatCanceledMessage = this.getStringPath("Guis.adminGui.worldToolsGui.tell.chatCanceledMessage");
        this.logsFromDay = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.logsFromDay");
        this.logsFromDateInterval = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.logsFromDateInterval");
        this.adminGuiMainGuiManageServer = this.getStringPath("Guis.adminGui.mainGui.manageServer");
        this.logsName = this.getStringPath("Guis.adminGui.mainGui.logs");
        this.adminGuiPlayersGuiShowOfflinePlayersName = this.getStringPath("Guis.adminGui.playersGui.addFilter");
        this.adminGuiPlayersGuiShowOfflinePlayersON = this.getStringPath("Guis.adminGui.playersGui.filterOn");
        this.adminGuiPlayersGuiShowOfflinePlayersOFF = this.getStringPath("Guis.adminGui.playersGui.filterOff");
        this.bansGuiSelectTime = this.getStringPath("Guis.adminGui.bansGui.selectTime");
        this.mutesGuiMutedBy = this.getStringPath("Guis.adminGui.mutesGui.mutedBy");
        this.mutesGuiExpiredDate = this.getStringPath("Guis.adminGui.mutesGui.expiredDate");
        this.mutesGuiUnmute = this.getStringPath("Guis.adminGui.mutesGui.unmute");
        this.banDescriptionBannedBy = this.getStringPath("Guis.adminGui.bansGui.banDescription.bannedBy");
        this.banDescriptionBannedDate = this.getStringPath("Guis.adminGui.bansGui.banDescription.bannedDate");
        this.banDescriptionExpiredDate = this.getStringPath("Guis.adminGui.bansGui.banDescription.expiredDate");
        this.banDescriptionComment = this.getStringPath("Guis.adminGui.bansGui.banDescription.comment");
        this.bansGuiUnban = this.getStringPath("Guis.adminGui.bansGui.unban");
        this.chooseTimeGuiExit = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.exit");
        this.adminGuiUnknownStatus = this.getStringPath("Guis.adminGui.unknownStatus");
        this.adminGuiBack = this.getStringPath("Guis.adminGui.back");
        this.adminGuiClose = this.getStringPath("Guis.adminGui.close");
        this.adminGuiExecute = this.getStringPath("Guis.adminGui.execute");
        this.adminGuiExpiredTime = this.getStringPath("Guis.adminGui.expiredTime");
        this.mainGuiPageName = this.getStringPath("Guis.adminGui.mainGui.pageName");
        this.mainGuiBans = this.getStringPath("Guis.adminGui.mainGui.bans");
        this.mainGuiAdminStaff = this.getStringPath("Guis.adminGui.mainGui.adminStaff");
        this.mainGuiPlayers = this.getStringPath("Guis.adminGui.mainGui.players");
        this.playersGuiPageName = this.getStringPath("Guis.adminGui.playersGui.pageName");
        this.bansGuiPageName = this.getStringPath("Guis.adminGui.bansGui.pageName");
        this.bansGuiBannedPlayersList = this.getStringPath("Guis.adminGui.bansGui.bannedPlayersList");
        this.bansGuiTemporaryBannedPlayersList = this.getStringPath("Guis.adminGui.bansGui.temporaryBannedPlayersList");
        this.bansGuiMutedPlayers = this.getStringPath("Guis.adminGui.bansGui.mutedPlayers");
        this.bansGuiFrozenPlayersList = this.getStringPath("Guis.adminGui.bansGui.frozenPlayersList");
        this.bansGuiHiddenPlayers = this.getStringPath("Guis.adminGui.bansGui.hiddenPlayers");
        this.adminStaffGuiPageName = this.getStringPath("Guis.adminGui.adminStaffGui.pageName");
        this.adminStaffGuiVanish = this.getStringPath("Guis.adminGui.adminStaffGui.vanish.vanish");
        this.adminStaffGuiVanish_current = this.getStringPath("Guis.adminGui.adminStaffGui.vanish.vanish_current");
        this.adminStaffGuiDisableChat = this.getStringPath("Guis.adminGui.adminStaffGui.disableChat.disableChat");
        this.adminStaffGuiDisableChatCurrent = this.getStringPath("Guis.adminGui.adminStaffGui.disableChat.disableChatCurrent");
        this.adminStaffGuiMaintenance = this.getStringPath("Guis.adminGui.adminStaffGui.maintenanceMode.maintenanceMode");
        this.adminStaffGuiMaintenanceCurrent = this.getStringPath("Guis.adminGui.adminStaffGui.maintenanceMode.maintenanceMode_current");
        this.adminStaffGuiAdminTools = this.getStringPath("Guis.adminGui.adminStaffGui.adminTools");
        this.adminToolsGuiPageName = this.getStringPath("Guis.adminGui.adminStaffGui.adminToolsGui.pageName");
        this.adminToolsGuiAdminAxe = this.getStringPath("Guis.adminGui.adminStaffGui.adminToolsGui.adminAxe");
        this.adminToolsGuiAdminPickAxe = this.getStringPath("Guis.adminGui.adminStaffGui.adminToolsGui.adminPickAxe");
        this.adminToolsGuiAdminShovel = this.getStringPath("Guis.adminGui.adminStaffGui.adminToolsGui.adminShovel");
        this.adminToolsGuiAdminSword = this.getStringPath("Guis.adminGui.adminStaffGui.adminToolsGui.adminSword");
        this.adminToolsGuiAdminBow = this.getStringPath("Guis.adminGui.adminStaffGui.adminToolsGui.adminBow");
        this.adminToolsGuiAdminHoe = this.getStringPath("Guis.adminGui.adminStaffGui.adminToolsGui.adminHoe");
        this.singlePlayerGuiBanGuiPageName = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.banGui.pageName");
        this.singlePlayerGuiPageName = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.pageName");
        this.singlePlayerGuiStatus_online = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.status_online");
        this.singlePlayerGuiStatus_offline = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.status_offline");
        this.singlePlayerGuiKillPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.killPlayer");
        this.singlePlayerGuiFreezePlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.freezePlayer");
        this.singlePlayerGuiTeleportPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.teleportPlayer");
        this.singlePlayerGuiTeleportToPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.teleportToPlayer");
        this.singlePlayerGuiHomesList = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.homesList");
        this.singlePlayerGuiBanPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.banPlayer");
        this.singlePlayerGuiMutePlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.mutePlayer");
        this.singlePlayerGuiInventory = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.inventory");
        this.singlePlayerGuiEnderChest = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.enderChest");
        this.singlePlayerGuiHidePlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.hidePlayer");
        this.singlePlayerGuiHidePlayer_current = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.hidePlayer_current");
        this.singlePlayerGuiKickPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.kickPlayer");
        this.singlePlayerGuiTemporaryBanPlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.temporaryBanPlayer");
        this.singlePlayerGuiReleasePlayer = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.releasePlayer");
        this.chooseTimeGuiPageName = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.pageName");
        this.chooseTimeGuiSecond = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.single.second");
        this.chooseTimeGuiMinute = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.single.minute");
        this.chooseTimeGuiHour = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.single.hour");
        this.chooseTimeGuiDay = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.single.day");
        this.chooseTimeGuiWeek = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.single.week");
        this.chooseTimeGuiMonth = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.single.month");
        this.chooseTimeGuiYear = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.single.year");
        this.chooseTimeGuiSeconds = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.plural.seconds");
        this.chooseTimeGuiMinutes = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.plural.minutes");
        this.chooseTimeGuiHours = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.plural.hours");
        this.chooseTimeGuiDays = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.plural.days");
        this.chooseTimeGuiWeeks = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.plural.weeks");
        this.chooseTimeGuiMonths = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.plural.months");
        this.chooseTimeGuiYears = this.getStringPath("Guis.adminGui.playersGui.singlePlayerGui.chooseTimeGui.plural.years");
        this.logsGuiTitle = this.getStringPath("Guis.adminGui.logsGui.logsGuiTitle");
        this.logsGuiSelectPlayer = this.getStringPath("Guis.adminGui.logsGui.selectPlayer");
        this.logsForAll = this.getStringPath("Guis.adminGui.logsGui.logsForAll");
        this.logsForOnePlayer = this.getStringPath("Guis.adminGui.logsGui.logsForPlayer");
        this.calendarGuiTitle = this.getStringPath("Guis.adminGui.calendarGui.calendarGuiTitle");
        this.logsTimeGuiTitle = this.getStringPath("Guis.adminGui.logsGui.logsTimeGuiTitle");
        this.logsTimeMultiDay = this.getStringPath("Guis.adminGui.logsGui.logsTimeMultiDay");
        this.logsTimeOneDay = this.getStringPath("Guis.adminGui.logsGui.logsTimeOneDay");
        this.firstCalendarGuiTitle = this.getStringPath("Guis.adminGui.calendarGui.calendarGuiTitleFirst");
        this.secondCalendarGuiTitle = this.getStringPath("Guis.adminGui.calendarGui.calendarGuiTitleSecond");
        this.firstDate = this.getStringPath("Guis.adminGui.calendarGui.calendarFirstDate");
        this.endDate = this.getStringPath("Guis.adminGui.calendarGui.calendarEndDate");
        this.aliasGuiCommandNameAliasesPageName = this.getStringPath("Guis.adminGui.serverControl.aliasGui.commandNameAliasesPageName");
        this.aliasGuiAddAliasItemName = this.getStringPath("Guis.adminGui.serverControl.aliasGui.addAliasItemName");
        this.aliasGuiRemoveAliasItemName = this.getStringPath("Guis.adminGui.serverControl.aliasGui.removeAliasItemName");
        this.aliasGuiTypeNewAlias = this.getStringPath("Guis.adminGui.serverControl.aliasGui.typeNewAlias");
        this.aliasGuiEnterAliasAgain = this.getStringPath("Guis.adminGui.serverControl.aliasGui.enterAliasAgain");
        this.aliasGuiAliasRemoved = this.getStringPath("Guis.adminGui.serverControl.aliasGui.aliasRemoved");
        this.aliasGuiCantRemovedAlias = this.getStringPath("Guis.adminGui.serverControl.aliasGui.cantRemovedAlias");
        this.aliasGuiCancelPhrase = this.getStringPath("Guis.adminGui.serverControl.aliasGui.cancelPhrase");
        this.commandControlGuiPageName = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.pageName");
        this.commandControlGuiFilterOn = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.filterOn");
        this.commandControlGuiFilterOff = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.filterOff");
        this.commandControlGuiGetUsage = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.getUsage");
        this.commandControlGuiGetLabel = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.getLabel");
        this.commandControlGuiStatusOn = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.statusOn");
        this.commandControlGuiStatusOff = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.statusOff");
        this.commandControlGuiGetAliases = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.getAliases");
        this.commandControlGuiGetPlugin = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.getPlugin");
        this.commandControlGuiGetEditLabel = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.getEditLabel");
        this.commandControlGuiActiveCommandsFilterItem = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.itemNames.activeCommandsFilterItem");
        this.commandControlGuiDisabledCommandsFilterItem = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.itemNames.disabledCommandsFilterItem");
        this.commandControlGuiAlphabeticOrderFilterItem = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.itemNames.alphabeticOrderFilterItem");
        this.commandControlGuiPluginOrderFilterItem = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.itemNames.pluginOrderFilterItem");
        this.commandControlGuiVanillaCommandsFilterItem = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.itemNames.vanillaCommandsFilterItem");
        this.commandControlGuiPluginCommandsFilterItem = this.getStringPath("Guis.adminGui.serverControl.commandControlGui.itemNames.pluginCommandsFilterItem");
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

    public String getFirstDate() {
        return firstDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getSinglePlayerGuiStatus_offline_never_player_before() {
        return singlePlayerGuiStatus_offline_never_player_before;
    }

    public String getAdminGuiWorldToolsGuiEnterMessageInChat() {
        return adminGuiWorldToolsGuiEnterMessageInChat;
    }
}
