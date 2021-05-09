package watchtowergui.wg.fileManager.configsutils.configs;

import app.annotations.ConfigYml;
import org.bukkit.configuration.file.YamlConfiguration;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.LiteralType;

import java.util.Map;

@ConfigYml
public class GuiLanguageConfig extends ConfigAccessor {

    String guiLocale_adminStaffGui_disableChat = "&b&lDisable chat for all players";
    String guiLocale_adminStaffGui_disableChatCurrent = "&fCurrent:";
    String guiLocale_adminStaffGui_maintenanceCurrent = "&fCurrent:";

    String guiLocale_singlePlayerGui_unbanPlayer = "&4&lThis player is banned &f&lClick to unban";
    String guiLocale_singlePlayerGui_tempUnbanPlayer = "&c&lThis player is banned temporary &f&lClick to remove temp-ban";
    String guiLocale_singlePlayerGui_unMutePlayer = "&e&lThis player is muted &f&lClick to unmute";
    String guiLocale_singlePlayerGui_lastActivity = "&7&lMaintenance Mode";
    String guiLocale_singlePlayerGui_playerLocationName = "&d&lCurrent location";
    String guiLocale_singlePlayerGui_playerLocationX = "&c&lX: &f&l[X]";
    String guiLocale_singlePlayerGui_playerLocationY = "&b&lY: &f&l[Y]";
    String guiLocale_singlePlayerGui_playerLocationZ = "&e&lZ: &f&l[Z]";
    String guiLocale_singlePlayerGui_playerLocationClickToTeleportToPlayer = "&a&lClick to teleport to player";
    String guiLocale_singlePlayerGui_playerLocationLocationPlayersOffline = "&2&lLocation: &f&lPlayer is offline";
    String guiLocale_singlePlayerGui_playerInfoMuted = "&a&lThis player is muted";
    String guiLocale_singlePlayerGui_statusOfflineNeverPlayerBefore = "&e&lPlayer has never played before";

    String guiLocale_serverControlGui_guiTitle = "&5&lManage your server";
    String guiLocale_serverControlGui_pluginListName = "&e&lPlugins list";
    String guiLocale_serverControlGui_pluginListLore = "&f&lShow information about installed plugins";
    String guiLocale_serverControlGui_manageCommandsName = "&6&lManage commands";
    String guiLocale_serverControlGui_manageCommandsLore = "&f&lShow or edit information and usage of this server commands";

    String guiLocale_singlePluginGui_createPluginNameItemVersion = "&5&lVersion: &f&l[pluginVersion]";
    String guiLocale_singlePluginGui_createPluginDescriptionItemDescription = "&6&lDescription:";
    String guiLocale_singlePluginGui_createPluginDescriptionItemLore = "&d[pluginDescription]";
    String guiLocale_singlePluginGui_createPluginDescriptionItemNotSpecified = "&cNot specified";
    String guiLocale_singlePluginGui_createAuthorsItemAuthors = "&e&lAuthors:";
    String guiLocale_singlePluginGui_createAuthorsItemLore = "&9[pluginAuthors]";
    String guiLocale_singlePluginGui_createAuthorsItemNotSpecified = "&cNot specified";
    String guiLocale_singlePluginGui_createWebsiteItemWebsite = "&b&LWebsite:";
    String guiLocale_singlePluginGui_createWebsiteItemLore = "&2[pluginWebsite]";
    String guiLocale_singlePluginGui_createWebsiteItemNotSpecified = "&cNot specified";
    String guiLocale_singlePluginGui_createPluginCommandsItemName = "&2&lPlugin commands";
    String guiLocale_singlePluginGui_createPluginCommandsItemCommandsLore = "&dClick to manage this plugin commands";
    String guiLocale_singlePluginGui_createPluginCommandsItemNoCommandsLore = "&dThis plugin do not have commands";
    String guiLocale_singlePluginGui_createDependItemName = "&aPlugins required for this plugin:";
    String guiLocale_singlePluginGui_createDependItemLore = "&aPlugins that give full functionalities:";

    String guiLocale_pluginControlGui_getDescriptionItemLore = "&2&lClick for details";

    String guiLocale_aliasGui_commandNameAliasesPageName = "&6&l[commandName] aliases";
    String guiLocale_aliasGui_addAliasItemName = "&a&lAdd alias";
    String guiLocale_aliasGui_removeAliasItemName = "&c&lClick to remove";
    String guiLocale_aliasGui_typeNewAlias = "&dType new alias on chat (\"[cancelModel]\" to cancel)";
    String guiLocale_aliasGui_enterAliasAgain = "&dEnter alias again (\"[cancelModel]\" to cancel)";
    String guiLocale_aliasGui_aliasRemoved = "&a&lAlias successfully removed!";
    String guiLocale_aliasGui_canNotRemovedAlias = "&c&lRemoving alias failed!";
    String guiLocale_aliasGui_cancelPhrase = "&c&lCanceled";

    String guiLocale_commandControlGui_pageName = "&5&lManage &2&l[commandName] &5&lcommands";
    String guiLocale_commandControlGui_filterOn = "&f&lCurrent: &a&lON";
    String guiLocale_commandControlGui_filterOff = "&f&lCurrent: &c&lOFF";
    String guiLocale_commandControlGui_getUsage = "&f&lUsage: &2&l[commandUsage]";
    String guiLocale_commandControlGui_getLabel = "&f&lLabel: &b&l[commandLabel]";
    String guiLocale_commandControlGui_statusOn = "&f&lStatus: &a&lactive";
    String guiLocale_commandControlGui_statusOff = "&f&lStatus: &c&ldisabled";
    String guiLocale_commandControlGui_getAliases = "&6&lAliases:";
    String guiLocale_commandControlGui_getPlugin = "&f&lPlugin: &d&l[pluginName]";
    String guiLocale_commandControlGui_getEditLabel = "&b&lClick to edit";
    String guiLocale_commandControlGui_activeCommandsFilterItem = "&2&lShow active commands";
    String guiLocale_commandControlGui_disabledCommandsFilterItem = "&4&lShow disabled commands";
    String guiLocale_commandControlGui_alphabeticOrderFilterItem = "&b&lSort in alphabetic order";
    String guiLocale_commandControlGui_pluginOrderFilterItem = "&9&lSort in plugin order";
    String guiLocale_commandControlGui_vanillaCommandsFilterItem = "&e&lShow default commands";
    String guiLocale_commandControlGui_pluginCommandsFilterItem = "&d&lShow plugins commands";

    String guiLocale_singleCommandGui_areYouSure = "&e&lAre you sure?";
    String guiLocale_singleCommandGui_receiveChangeLabelResult = "&f&lEnter label again or cancel with &d&l[cancelModel]";
    String guiLocale_singleCommandGui_checkIsLabelEnterCancelCancelPhrase = "&c&lCanceled";
    String guiLocale_singleCommandGui_receiveDisableResultCanNotDisable = "&c&lCan not disable this command";
    String guiLocale_singleCommandGui_receiveDisableResultSuccessfullyDisabled = "&a&lCommand successfully disabled";
    String guiLocale_singleCommandGui_setCommandEnableEnterNewLabel = "&f&lEnter new label &c&l([cancelModel] to cancel)";
    String guiLocale_singleCommandGui_createPermissionItemName = "&f&lPermission for this command: &9&l[commandPermission]";
    String guiLocale_singleCommandGui_createPermissionNotSpecified = "&c&lNot specified";
    String guiLocale_singleCommandGui_createNameItemName = "&f&lName: &1&l[commandName]";
    String guiLocale_singleCommandGui_createNameItemLore1 = "&f&lLabel: &e&l[commandLabel]";
    String guiLocale_singleCommandGui_createNameItemLore2 = "&f&lClick to change label &c&l(not recommended)";
    String guiLocale_singleCommandGui_createAliasesItemName = "&5&lAliases:";
    String guiLocale_singleCommandGui_createAliasesItemLore = "&b&lClick to add/remove alias";
    String guiLocale_singleCommandGui_createPluginItemNameSpecified = "&f&lCommand received from: &5&l[commandName] &f&l-> Click to see plugin";
    String guiLocale_singleCommandGui_createPluginItemNameNotSpecified = "&d&lThis command is default server command or plugin can not be specified";
    String guiLocale_singleCommandGui_createUsageItemName = "&f&lUsage: &d&l[commandUsage]";
    String guiLocale_singleCommandGui_createUsageItemNotSpecified = "&c&lNot specified";
    String guiLocale_singleCommandGui_createDescriptionItemName = "&f&lDescription: &b&l[commandDescription]";
    String guiLocale_singleCommandGui_createActiveStatusItemName = "&e&lThis command is enabled. &f&lClick to disable this command";
    String guiLocale_singleCommandGui_createDisableStatusItemName = "&c&lThis command is disabled. &f&lClick to enable this command";

    String guiLocale_commandControlListener_showError = "&c&lSomething is wrong check command: [commandName]";
    String guiLocale_commandControlListener_newCommandAlias = "&e&lIt seems like you have new command with alias or label: &f&l[commandLabel] &e&lCommand &f&l[commandName] &e&lhas return to original label";
    String guiLocale_commandControlListener_loadAddedAliases = "&c&lAlias: &f&l[commandAlias] &c&lcan not be added to &f&l[commandName] &c&lit is probably because you have new command with that alias or label";
    String guiLocale_commandControlListener_enableCommandNotExists = "&c&lCommand: &6&l[commandName] &c&ldoes not exist";
    String guiLocale_commandControlListener_enableCommandCommandAlreadyExists = "&e&lCommand already is enabled";
    String guiLocale_commandControlListener_aliasAlreadyExistsAlreadyExists = "&c&lAlias/label: &f&l[commandAlias] &c&lis already use by: &f&l[commandName]";
    String guiLocale_commandControlListener_aliasAlreadyExistsSuccessfullyEnabled = "&2&lCommand enabled successfully";
    String guiLocale_commandControlListener_changeLabelNotExists = "&c&lCommand does not exist";
    String guiLocale_commandControlListener_changeLabelCanNotBeChanged = "&4&lThis label can not be changed";
    String guiLocale_commandControlListener_changeLabelSuccessfullyChanged = "&2&lLabel change successfully";
    String guiLocale_commandControlListener_addAliasNotExists = "&c&lCommand does not exists";
    String guiLocale_commandControlListener_addAliasSuccessfullyAdded = "&2&lAlias added successfully";
    String guiLocale_commandControlListener_onlyViableAliasMessage = "&e&lOnly viable prefix for this command is: &f&l[commandPrefix]";
    String guiLocale_commandControlListener_commandHasThatAliasOrLabel = "&c&lThis command already has that alias or label";
    String guiLocale_commandControlListener_commandHasThatAlias = "&c&lCommand: &f&l[commandName] &c&lalready has that alias or label!";

    String guiLocale_commandMenu_pageName = "&5&lManage Commands";


    String guiLocale_adminGui_playersGuiShowOfflinePlayersName = "";
    String guiLocale_adminGui_playersGuiShowOfflinePlayersON = "&f&lCurrent: &a&lON";
    String guiLocale_adminGui_playersGuiShowOfflinePlayersOFF = "&f&lCurrent: &c&lOFF";
    String guiLocale_adminGui_mainGuiManageServer = "&5&lManage Server";
    String guiLocale_adminGui_unknownStatus = "&c&lUnknown status";
    String guiLocale_adminGui_back = "&f&lGo Back";
    String guiLocale_adminGui_close = "&c&lClose";
    String guiLocale_adminGui_execute = "&a&lExecute &f&l[title]";
    String guiLocale_adminGui_expiredTime = "&6&lExpired Time";

    String guiLocale_mainGui_players = "&1&lPlayers";
    String guiLocale_mainGui_pageName = "&6&lAdmin Gui";
    String guiLocale_mainGui_bans = "&c&lBans";
    String guiLocale_mainGui_adminStaff = "&6&lAdmin Staff";

    String guiLocale_playersGui_pageName = "&5&lPlayers";

    String guiLocale_bansGui_pageName = "&c&lBans";
    String guiLocale_bansGui_bannedPlayersList = "&7&lBanned Players List";
    String guiLocale_bansGui_temporaryBannedPlayersList = "&e&lTmBanned Players";
    String guiLocale_bansGui_mutedPlayers = "&d&lMuted Players";
    String guiLocale_bansGui_frozenPlayersList = "&1&lFrozen Players List";
    String guiLocale_bansGui_hiddenPlayers = "&b&lHidden Players";

    String guiLocale_adminStaff_guiPageName = "&2&lAdminStaff";
    String guiLocale_adminStaff_guiVanish = "&6&lVanish";
    String guiLocale_adminStaff_guiVanishCurrent = "&fCurrent:";
    String guiLocale_adminStaff_guiMaintenance = "&7&lMaintenance Mode";
    String guiLocale_adminStaff_adminTools = "&b&lAdmin Tools";

    String guiLocale_adminToolsGui_pageName = "&b&lAdmin Tools";
    String guiLocale_adminToolsGui_adminAxe = "&e&lAdmin Axe";
    String guiLocale_adminToolsGui_adminPickAxe = "&9&lAdmin Pickaxe";
    String guiLocale_adminToolsGui_adminShovel = "&2&lAdmin Shovel";
    String guiLocale_adminToolsGui_adminSword = "&c&lAdmin Sword";
    String guiLocale_adminToolsGui_adminBow = "&d&lAdmin Bow";
    String guiLocale_adminToolsGui_adminHoe = "&b&lAdmin... Hoe???";

    String guiLocale_singlePlayerGui_statusOnline = "&a&lPlayer is online";
    String guiLocale_singlePlayerGui_statusOffline = "&c&lPlayer is offline";
    String guiLocale_singlePlayerGui_killPlayer = "&4&lKill Player";
    String guiLocale_singlePlayerGui_freezePlayer = "&9&lFreeze Player";
    String guiLocale_singlePlayerGui_teleportPlayer = "&2&lTeleport Player";
    String guiLocale_singlePlayerGui_teleportToPlayer = "&2&lTeleport To Player";
    String guiLocale_singlePlayerGui_banPlayer = "&6&lBan Player";
    String guiLocale_singlePlayerGui_mutePlayer = "&a&lMute Player";
    String guiLocale_singlePlayerGui_inventory = "&2&lInventory";
    String guiLocale_singlePlayerGui_enderChest = "&5&lEnder Chest";
    String guiLocale_singlePlayerGui_hidePlayer = "&f&lHide Player";
    String guiLocale_singlePlayerGui_hidePlayerCurrent = "&f&lCurrent: ";
    String guiLocale_singlePlayerGui_kickPlayer = "&d&lKick Player";
    String guiLocale_singlePlayerGui_temporaryBanPlayer = "&8&lTemporary Ban Player";
    String guiLocale_singlePlayerGui_banGuiPageName = "&0&lBan &6&l[playerName]?";
    String guiLocale_singlePlayerGui_pageName = "&6&l[playerName]";
    String guiLocale_singlePlayerGui_releasePlayer = "&c&lRelease Player";

    String guiLocale_chooseTimeGui_pageName = "&0&lChoose Time";
    String guiLocale_chooseTimeGui_second = "&7&lSecond";
    String guiLocale_chooseTimeGui_minute = "&9&lMinute";
    String guiLocale_chooseTimeGui_hour = "&b&lHour";
    String guiLocale_chooseTimeGui_day = "&d&lDay";
    String guiLocale_chooseTimeGui_week = "&5&lWeek";
    String guiLocale_chooseTimeGui_month = "&e&lMonth";
    String guiLocale_chooseTimeGui_year = "&6&lYear";
    String guiLocale_chooseTimeGui_seconds = "&7&lSeconds";
    String guiLocale_chooseTimeGui_minutes = "&9&lMinutes";
    String guiLocale_chooseTimeGui_hours = "&b&lHours";
    String guiLocale_chooseTimeGui_days = "&d&lDays";
    String guiLocale_chooseTimeGui_weeks = "&5&lWeeks";
    String guiLocale_chooseTimeGui_months = "&e&lMonths";
    String guiLocale_chooseTimeGui_years = "&6&lYears";
    String guiLocale_chooseTimeGui_exit = "&c&lExit";

    String guiLocale_bansGui_unban = "&6&lUnban &5&L[playerName]?";
    String guiLocale_bansGui_selectTime = "&c&lSelect Time";

    String guiLocale_bansGui_banDescriptionBannedBy = "&6&lBanned by: &f&l[date]";
    String guiLocale_bansGui_banDescriptionBannedDate = "&6&lBan date: &f&l[date]";
    String guiLocale_bansGui_banDescriptionExpiredDate = "&6&lExpired date: &f&l[date]";
    String guiLocale_bansGui_banDescriptionComment = "&7&lComment: &c&l[comment]";

    String guiLocale_mutesGui_mutedBy = "&f&lMuted by: [playerName]";
    String guiLocale_mutesGui_expiredDate = "&f&lExpired date: [date]";
    String guiLocale_mutesGui_unMute = "&f&lUnmute: [playerName]";


    String guiLocale_logsGui_logsName = "&e&lLogs";
    String guiLocale_logsGui_selectPlayer = "&e&lSelect Player";
    String guiLocale_logsGui_title = "&b&lChoose time range";
    String guiLocale_logsGui_logsForAll = "&5&lLogs for all players";
    String guiLocale_logsGui_logsForOnePlayer = "&2&lGet logs for specified player";
    String guiLocale_logsGui_logsTimeGuiTitle = "&b&lChoose time range";
    String guiLocale_logsGui_logsTimeOneDay = "&2&lMerge logs from one day";
    String guiLocale_logsGui_logsTimeMultiDay = "&5&lMerge logs from many days";
    String guiLocale_logsGui_logsFromDay = "&b&lGet logs from specific day";
    String guiLocale_logsGui_logsFromDateInterval = "&3&lGet logs from date interval";

    String guiLocale_calendarGui_firstCalendarGuiTitle = "&d&lSelect first date";
    String guiLocale_calendarGui_secondCalendarGuiTitle = "&5&lSelect second date";
    String guiLocale_calendarGui_title = "&a&lSelect date";
    String guiLocale_calendarGui_firstDate = "&2&lFirst Date";
    String guiLocale_calendarGui_endDate = "&e&lEnd Date";

    String guiLocale_adminGuiWorldToolsGui_enterMessageInChat = "&e&lEnter message in chat";
    String guiLocale_adminGuiWorldToolsGui_worldToolsGuiPageName = "&2&lSelect player";
    String guiLocale_adminGuiWorldToolsGui_defaultGamemodeName = "&b&lSet default gamemode";
    String guiLocale_adminGuiWorldToolsGui_defaultGamemodeLore = "&f&lBy clicking this you can set default gamemode type for every player: [survival, creative, spectator, hardcore]";
    String guiLocale_adminGuiWorldToolsGui_worldDifficultyName = "&c&lSet difficulty";
    String guiLocale_adminGuiWorldToolsGui_worldDifficultyLore = "&f&lBy clicking this you can set world difficulty: [peaceful, easy, medium, hard]";
    String guiLocale_adminGuiWorldToolsGui_gamemodeName = "&e&lGamemode";
    String guiLocale_adminGuiWorldToolsGui_gamemodeLore = "&f&lSet your gamemode: [survival, creative, spectator, hardcore]";
    String guiLocale_adminGuiWorldToolsGui_reloadName = "&a&lReload server";
    String guiLocale_adminGuiWorldToolsGui_reloadLore = "&f&lBy clicking this you can reload your server";
    String guiLocale_adminGuiWorldToolsGui_sayName = "&9&lSay globally";
    String guiLocale_adminGuiWorldToolsGui_sayLore = "&f&lBy clicking this you can write in chat to say something globally";
    String guiLocale_adminGuiWorldToolsGui_seedName = "&2&lGet world seed";
    String guiLocale_adminGuiWorldToolsGui_seedLore = "&f&lBy clicking this you can display world seed";
    String guiLocale_adminGuiWorldToolsGui_setWorldSpawnName = "&6&lSet worldspawn";
    String guiLocale_adminGuiWorldToolsGui_setWorldSpawnLore = "&f&l(provided by Minecraft) By clicking this you can set world spawn in position when you are staying";
    String guiLocale_adminGuiWorldToolsGui_spawnPointName = "&4&lSet set spawn point";
    String guiLocale_adminGuiWorldToolsGui_spawnPointLore = "&f&l(provided by Minecraft) By clicking this you can set spawn point to yourself in position when you are staying";
    String guiLocale_adminGuiWorldToolsGui_timeName = "&d&lSet time";
    String guiLocale_adminGuiWorldToolsGui_timeLore = "&f&lBy clicking this you can change your world time";
    String guiLocale_adminGuiWorldToolsGui_weatherName = "&5&lSet weather";
    String guiLocale_adminGuiWorldToolsGui_weatherLore = "&f&lBy clicking this you can set your world weather";
    String guiLocale_adminGuiWorldToolsGui_worldBorderName = "&7&lSet world border";
    String guiLocale_adminGuiWorldToolsGui_worldBorderLore = "&f&lBy clicking this you can set you world border";
    String guiLocale_adminGuiWorldToolsGui_xpName = "&4&lGive xp";
    String guiLocale_adminGuiWorldToolsGui_xpLore = "&f&lBy clicking this you can add xp";
    String guiLocale_adminGuiWorldToolsGui_xpChatMessage = "&f&lEnter xp amount &c&l([cancelModel] to cancel)";
    String guiLocale_adminGuiWorldToolsGui_xpChatCanceledMessage = "&c&lCanceled";
    String guiLocale_adminGuiWorldToolsGui_titleName = "&5&lDisplay title to player";
    String guiLocale_adminGuiWorldToolsGui_titleLore = "&f&lBy clicking this you can send a screen title to specific player";
    String guiLocale_adminGuiWorldToolsGui_titleChatMessage = "&f&lEnter message to player &c&l([cancelModel] to cancel)";
    String guiLocale_adminGuiWorldToolsGui_titleChatCanceledMessage = "&c&lCanceled";
    String guiLocale_adminGuiWorldToolsGui_tellName = "&1&lSend private message";
    String guiLocale_adminGuiWorldToolsGui_tellLore = "&f&lby clicking this you can send a private message to a specific player";
    String guiLocale_adminGuiWorldToolsGui_tellChatMessage = "&f&lEnter message to player &c&l([cancelModel] to cancel)";
    String guiLocale_adminGuiWorldToolsGui_tellChatCanceledMessage = "&c&lCanceled";

    String guiLocale_worldToolsGui_selectPlayer = "&2&lSelect player";

    String guiLocale_adminGuiWeatherGui_weatherGuiPageName = "&b&lSet weather";
    String guiLocale_adminGuiWeatherGui_sunny = "&e&lSunny";
    String guiLocale_adminGuiWeatherGui_rainy = "&9&lRainy";
    String guiLocale_adminGuiWeatherGui_thunder = "&7&lThunder";

    String guiLocale_timeGui_pageName = "&5&lSelect Time";
    String guiLocale_timeGui_day = "&b&lDay";
    String guiLocale_timeGui_noon = "&e&lNoon";
    String guiLocale_timeGui_midNight = "&a&lMidnight";
    String guiLocale_timeGui_night = "&9&lNight";
    String guiLocale_timeGui_number = "&f&lTime value";
    String guiLocale_timeGui_chatResponse = "&f&lWrite message in chat";

    String guiLocale_adminGuiDifficulty_guiDifficultyGuiPageName = "&d&lSet difficulty";
    String guiLocale_adminGuiDifficulty_peaceful = "&a&lPeaceful";
    String guiLocale_adminGuiDifficulty_easy = "&2&lEasy";
    String guiLocale_adminGuiDifficulty_medium = "&e&lNormal";
    String guiLocale_adminGuiDifficulty_hard = "&4&lHard";

    String guiLocale_gameModeGui_gameModeGuiPageName = "&9&lSet your gamemode";
    String guiLocale_gameModeGui_survival = "&2&lSurvival";
    String guiLocale_gameModeGui_creative = "&b&lCreative";
    String guiLocale_gameModeGui_hardcore = "&c&lHardcore";
    String guiLocale_gameModeGui_spectator = "&6&lSpectator";

    String guiLocale_defaultGameModeGui_defaultGameModeGuiPageName = "&5&lSet default gamemode";
    String guiLocale_defaultGameModeGui_survival = "&2&lSurvival";
    String guiLocale_defaultGameModeGui_creative = "&b&lCreative";
    String guiLocale_defaultGameModeGui_hardcore = "&c&lHardcore";
    String guiLocale_defaultGameModeGui_spectator = "&6&lSpectator";

    String guiLocale_worldBorderGui_worldBorderGuiPageName = "&2&lConfigure your world border";
    String guiLocale_worldBorderGui_addToWorldBorderName = "&a&lAdd";
    String guiLocale_worldBorderGui_addToWorldBorderLore = "&f&l/worldborder add <sizeInBlocks> [timeInSeconds]";
    String guiLocale_worldBorderGui_addToWorldBorderChatMessage = "&f&lWrite message in chat";
    String guiLocale_worldBorderGui_getWorldBorderName = "&f&lActual border:";
    String guiLocale_worldBorderGui_getWorldBorderLore = "&f&lworldborder size: &6&l[worldBorderSize]";
    String guiLocale_worldBorderGui_worldBorderWarningName = "&e&lWarning";
    String guiLocale_worldBorderGui_worldBorderWarningLore = "&f&l/worldborder warning time &e&l<timeInSeconds>";
    String guiLocale_worldBorderGui_worldBorderWarningChatMessage = "&f&lWrite message in chat";
    String guiLocale_worldBorderGui_worldBorderDamageName = "&c&lDamage";
    String guiLocale_worldBorderGui_worldBorderDamageLore = "&f&l/worldborder damage buffer &d&l<sizeInBlocks>";
    String guiLocale_worldBorderGui_worldBorderDamageChatMessage = "&f&lWrite message in chat";
    String guiLocale_worldBorderGui_centerWorldBorderName = "&d&lCenter";
    String guiLocale_worldBorderGui_centerWorldBorderLore = "&f&l/worldborder center &c&l<x> <z>";
    String guiLocale_worldBorderGui_centerWorldBorderChatMessage = "&f&lWrite message in chat";
    String guiLocale_worldBorderGui_setWorldBorderName = "&3&lSet";
    String guiLocale_worldBorderGui_setWorldBorderLore = "&f&l/worldborder set &c&l<sizeInBlocks> [timeInSeconds]";
    String guiLocale_worldBorderGui_setWorldBorderChatMessage = "&f&lWrite message in chat";

    String guiLocale_singlePlayerGui_playerIsOffline = "&c&lPlayer is offline";

    public void init() {
        super.init("GuiLocale_en", "locale");
        this.yml.addDefaults(this.serialize());
        this.yml.options().copyDefaults(true);
        this.save();

        Map<String, Object> defaults = this.yml.getDefaults().getValues(true);
        this.yml = YamlConfiguration.loadConfiguration(this.file);

        Map<String, Object> map = this.yml.getConfigurationSection("").getValues(true);
        watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfigSerializator.injectTo(this,
                map,defaults, this.yml);
        this.save();
    }

    public Map<String, Object> serialize(){
        return watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfigSerializator.serialize(this);
    }

    public String getGuiLocale_singlePlayerGui_playerIsOffline() {
        return guiLocale_singlePlayerGui_playerIsOffline;
    }

    public String getGuiLocale_adminStaffGui_disableChat() {
        return guiLocale_adminStaffGui_disableChat;
    }

    public String getGuiLocale_adminStaffGui_disableChatCurrent() {
        return guiLocale_adminStaffGui_disableChatCurrent;
    }

    public String getGuiLocale_adminStaffGui_maintenanceCurrent() {
        return guiLocale_adminStaffGui_maintenanceCurrent;
    }

    public String getGuiLocale_singlePlayerGui_unbanPlayer() {
        return guiLocale_singlePlayerGui_unbanPlayer;
    }

    public String getGuiLocale_singlePlayerGui_tempUnbanPlayer() {
        return guiLocale_singlePlayerGui_tempUnbanPlayer;
    }

    public String getGuiLocale_singlePlayerGui_unMutePlayer() {
        return guiLocale_singlePlayerGui_unMutePlayer;
    }

    public String getSinglePlayerGuiLastActivity(String word) {
        return guiLocale_singlePlayerGui_lastActivity.replaceAll(LiteralType.LAST_ACTIVITY, word);
    }

    public String getGuiLocale_singlePlayerGui_playerLocationName() {
        return guiLocale_singlePlayerGui_playerLocationName;
    }

    public String getSinglePlayerGuiPlayerLocationX(String word) {
        return guiLocale_singlePlayerGui_playerLocationX.replaceAll(LiteralType.X, word);
    }

    public String getSinglePlayerGuiPlayerLocationY(String word) {
        return guiLocale_singlePlayerGui_playerLocationY.replaceAll(LiteralType.Y, word);
    }

    public String getSinglePlayerGuiPlayerLocationZ(String word) {
        return guiLocale_singlePlayerGui_playerLocationZ.replaceAll(LiteralType.Z, word);
    }

    public String getGuiLocale_singlePlayerGui_playerLocationClickToTeleportToPlayer() {
        return guiLocale_singlePlayerGui_playerLocationClickToTeleportToPlayer;
    }

    public String getGuiLocale_singlePlayerGui_playerLocationLocationPlayersOffline() {
        return guiLocale_singlePlayerGui_playerLocationLocationPlayersOffline;
    }

    public String getGuiLocale_singlePlayerGui_playerInfoMuted() {
        return guiLocale_singlePlayerGui_playerInfoMuted;
    }

    public String getGuiLocale_worldToolsGui_selectPlayer() {
        return guiLocale_worldToolsGui_selectPlayer;
    }

    public String getGuiLocale_serverControlGui_guiTitle() {
        return guiLocale_serverControlGui_guiTitle;
    }

    public String getGuiLocale_serverControlGui_pluginListName() {
        return guiLocale_serverControlGui_pluginListName;
    }

    public String getGuiLocale_serverControlGui_pluginListLore() {
        return guiLocale_serverControlGui_pluginListLore;
    }

    public String getGuiLocale_serverControlGui_manageCommandsName() {
        return guiLocale_serverControlGui_manageCommandsName;
    }

    public String getGuiLocale_serverControlGui_manageCommandsLore() {
        return guiLocale_serverControlGui_manageCommandsLore;
    }

    public String getSinglePluginGuiCreatePluginDescriptionItemLore(String word) {
        return guiLocale_singlePluginGui_createPluginDescriptionItemLore.replaceAll(LiteralType.PLUGIN_DESCRIPTION, word);
    }

    public String getSinglePluginGuiCreateAuthorsItemLore(String word) {
        return guiLocale_singlePluginGui_createAuthorsItemLore.replaceAll(LiteralType.PLUGIN_AUTHORS, word);
    }

    public String getSinglePluginGuiCreateWebsiteItemLore(String word) {
        return guiLocale_singlePluginGui_createWebsiteItemLore.replaceAll(LiteralType.PLUGIN_WEBSITE, word);
    }

    public String getSinglePluginGuiCreatePluginNameItemVersion(String word) {
        return guiLocale_singlePluginGui_createPluginNameItemVersion.replaceAll(LiteralType.PLUGIN_VERSION, word);
    }

    public String getGuiLocale_singlePluginGui_createPluginDescriptionItemDescription() {
        return guiLocale_singlePluginGui_createPluginDescriptionItemDescription;
    }

    public String getGuiLocale_singlePluginGui_createPluginDescriptionItemNotSpecified() {
        return guiLocale_singlePluginGui_createPluginDescriptionItemNotSpecified;
    }

    public String getGuiLocale_singlePluginGui_createAuthorsItemAuthors() {
        return guiLocale_singlePluginGui_createAuthorsItemAuthors;
    }

    public String getGuiLocale_singlePluginGui_createAuthorsItemNotSpecified() {
        return guiLocale_singlePluginGui_createAuthorsItemNotSpecified;
    }

    public String getGuiLocale_singlePluginGui_createWebsiteItemWebsite() {
        return guiLocale_singlePluginGui_createWebsiteItemWebsite;
    }

    public String getGuiLocale_singlePluginGui_createWebsiteItemNotSpecified() {
        return guiLocale_singlePluginGui_createWebsiteItemNotSpecified;
    }

    public String getGuiLocale_singlePluginGui_createPluginCommandsItemName() {
        return guiLocale_singlePluginGui_createPluginCommandsItemName;
    }

    public String getGuiLocale_singlePluginGui_createPluginCommandsItemCommandsLore() {
        return guiLocale_singlePluginGui_createPluginCommandsItemCommandsLore;
    }

    public String getGuiLocale_singlePluginGui_createPluginCommandsItemNoCommandsLore() {
        return guiLocale_singlePluginGui_createPluginCommandsItemNoCommandsLore;
    }

    public String getGuiLocale_singlePluginGui_createDependItemName() {
        return guiLocale_singlePluginGui_createDependItemName;
    }

    public String getGuiLocale_singlePluginGui_createDependItemLore() {
        return guiLocale_singlePluginGui_createDependItemLore;
    }

    public String getGuiLocale_pluginControlGui_getDescriptionItemLore() {
        return guiLocale_pluginControlGui_getDescriptionItemLore;
    }

    public String getCommandControlListenerShowError(String word) {
        return guiLocale_commandControlListener_showError.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getCommandControlListenerNewCommandAlias(String word1, String word2) {
        String str1 = guiLocale_commandControlListener_newCommandAlias.replace(LiteralType.COMMAND_ALIAS, word1);
        return str1.replaceAll(LiteralType.COMMAND_NAME, word2);
    }

    public String getCommandControlListenerLoadAddedAliases(String word1, String word2) {
        String str1 = guiLocale_commandControlListener_loadAddedAliases.replaceAll(LiteralType.COMMAND_ALIAS, word1);
        return str1.replaceAll(LiteralType.COMMAND_NAME, word2);
    }

    public String getCommandControlListenerEnableCommandNotExists(String word) {
        return guiLocale_commandControlListener_enableCommandNotExists.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getGuiLocale_commandControlListener_enableCommandCommandAlreadyExists() {
        return guiLocale_commandControlListener_enableCommandCommandAlreadyExists;
    }

    public String getCommandControlListenerAliasAlreadyExistsAlreadyExists(String word1, String word2) {
        String str1 = guiLocale_commandControlListener_aliasAlreadyExistsAlreadyExists.replaceAll(LiteralType.COMMAND_ALIAS, word1);
        return str1.replaceAll(LiteralType.COMMAND_NAME, word2);
    }

    public String getGuiLocale_commandControlListener_aliasAlreadyExistsSuccessfullyEnabled() {
        return guiLocale_commandControlListener_aliasAlreadyExistsSuccessfullyEnabled;
    }

    public String getGuiLocale_commandControlListener_changeLabelNotExists() {
        return guiLocale_commandControlListener_changeLabelNotExists;
    }

    public String getGuiLocale_commandControlListener_changeLabelCanNotBeChanged() {
        return guiLocale_commandControlListener_changeLabelCanNotBeChanged;
    }

    public String getGuiLocale_commandControlListener_changeLabelSuccessfullyChanged() {
        return guiLocale_commandControlListener_changeLabelSuccessfullyChanged;
    }

    public String getGuiLocale_commandControlListener_addAliasNotExists() {
        return guiLocale_commandControlListener_addAliasNotExists;
    }

    public String getGuiLocale_commandControlListener_addAliasSuccessfullyAdded() {
        return guiLocale_commandControlListener_addAliasSuccessfullyAdded;
    }

    public String getCommandControlListenerOnlyViableAliasMessage(String word) {
        return guiLocale_commandControlListener_onlyViableAliasMessage.replaceAll(LiteralType.COMMAND_PREFIX, word);
    }

    public String getGuiLocale_commandControlListener_commandHasThatAliasOrLabel() {
        return guiLocale_commandControlListener_commandHasThatAliasOrLabel;
    }

    public String getCommandControlListenerCommandHasThatAlias(String word) {
        return guiLocale_commandControlListener_commandHasThatAlias.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getGuiLocale_singleCommandGui_areYouSure() {
        return guiLocale_singleCommandGui_areYouSure;
    }

    public String getSingleCommandGuiReceiveChangeLabelResult(String word) {
        return guiLocale_singleCommandGui_receiveChangeLabelResult.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getGuiLocale_singleCommandGui_checkIsLabelEnterCancelCancelPhrase() {
        return guiLocale_singleCommandGui_checkIsLabelEnterCancelCancelPhrase;
    }

    public String getGuiLocale_singleCommandGui_receiveDisableResultCanNotDisable() {
        return guiLocale_singleCommandGui_receiveDisableResultCanNotDisable;
    }

    public String getGuiLocale_singleCommandGui_receiveDisableResultSuccessfullyDisabled() {
        return guiLocale_singleCommandGui_receiveDisableResultSuccessfullyDisabled;
    }

    public String getSingleCommandGuiSetCommandEnableEnterNewLabel(String word) {
        return guiLocale_singleCommandGui_setCommandEnableEnterNewLabel.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getSingleCommandGuiCreatePermissionItemName(String word) {
        return guiLocale_singleCommandGui_createPermissionItemName.replaceAll(LiteralType.COMMAND_PERMISSION, word);
    }

    public String getGuiLocale_singleCommandGui_createPermissionNotSpecified() {
        return guiLocale_singleCommandGui_createPermissionNotSpecified;
    }

    public String getSingleCommandGuiCreateNameItemName(String word) {
        return guiLocale_singleCommandGui_createNameItemName.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getSingleCommandGuiCreateNameItemLore_1(String word) {
        return guiLocale_singleCommandGui_createNameItemLore1.replaceAll(LiteralType.COMMAND_LABEL, word);
    }

    public String getGuiLocale_singleCommandGui_createNameItemLore2() {
        return guiLocale_singleCommandGui_createNameItemLore2;
    }

    public String getGuiLocale_singleCommandGui_createAliasesItemName() {
        return guiLocale_singleCommandGui_createAliasesItemName;
    }

    public String getGuiLocale_singleCommandGui_createAliasesItemLore() {
        return guiLocale_singleCommandGui_createAliasesItemLore;
    }

    public String getSingleCommandGuiCreatePluginItemNameSpecified(String word) {
        return guiLocale_singleCommandGui_createPluginItemNameSpecified.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getGuiLocale_singleCommandGui_createPluginItemNameNotSpecified() {
        return guiLocale_singleCommandGui_createPluginItemNameNotSpecified;
    }

    public String getSingleCommandGuiCreateUsageItemName(String word) {
        return guiLocale_singleCommandGui_createUsageItemName.replaceAll(LiteralType.COMMAND_USAGE, word);
    }

    public String getGuiLocale_singleCommandGui_createUsageItemNotSpecified() {
        return guiLocale_singleCommandGui_createUsageItemNotSpecified;
    }

    public String getSingleCommandGuiCreateDescriptionItemName(String word) {
        return guiLocale_singleCommandGui_createDescriptionItemName.replaceAll(LiteralType.COMMAND_DESCRIPTION, word);
    }

    public String getGuiLocale_singleCommandGui_createActiveStatusItemName() {
        return guiLocale_singleCommandGui_createActiveStatusItemName;
    }

    public String getGuiLocale_singleCommandGui_createDisableStatusItemName() {
        return guiLocale_singleCommandGui_createDisableStatusItemName;
    }


    public String getCommandControlGuiGetUsage(String word) {
        return guiLocale_commandControlGui_getUsage.replaceAll(LiteralType.COMMAND_USAGE, word);
    }

    public String getCommandControlGuiGetLabel(String word) {
        return guiLocale_commandControlGui_getLabel.replaceAll(LiteralType.COMMAND_LABEL, word);
    }

    public String getGuiLocale_commandControlGui_statusOn() {
        return guiLocale_commandControlGui_statusOn;
    }

    public String getGuiLocale_commandControlGui_statusOff() {
        return guiLocale_commandControlGui_statusOff;
    }

    public String getGuiLocale_commandControlGui_getAliases() {
        return guiLocale_commandControlGui_getAliases;
    }

    public String getCommandControlGuiGetPlugin(String word) {
        return guiLocale_commandControlGui_getPlugin.replaceAll(LiteralType.PLUGIN_NAME, word);
    }

    public String getGuiLocale_commandControlGui_getEditLabel() {
        return guiLocale_commandControlGui_getEditLabel;
    }

    public String getGuiLocale_commandControlGui_activeCommandsFilterItem() {
        return guiLocale_commandControlGui_activeCommandsFilterItem;
    }

    public String getGuiLocale_commandControlGui_disabledCommandsFilterItem() {
        return guiLocale_commandControlGui_disabledCommandsFilterItem;
    }

    public String getGuiLocale_commandControlGui_alphabeticOrderFilterItem() {
        return guiLocale_commandControlGui_alphabeticOrderFilterItem;
    }

    public String getGuiLocale_commandControlGui_pluginOrderFilterItem() {
        return guiLocale_commandControlGui_pluginOrderFilterItem;
    }

    public String getGuiLocale_commandControlGui_vanillaCommandsFilterItem() {
        return guiLocale_commandControlGui_vanillaCommandsFilterItem;
    }

    public String getGuiLocale_commandControlGui_pluginCommandsFilterItem() {
        return guiLocale_commandControlGui_pluginCommandsFilterItem;
    }

    public String getCommandControlGuiPageName(String word) {
        return guiLocale_commandControlGui_pageName.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getGuiLocale_commandControlGui_filterOn() {
        return guiLocale_commandControlGui_filterOn;
    }

    public String getGuiLocale_commandControlGui_filterOff() {
        return guiLocale_commandControlGui_filterOff;
    }

    public String getAliasGuiCommandNameAliasesPageName(String word) {
        return guiLocale_aliasGui_commandNameAliasesPageName.replaceAll(LiteralType.COMMAND_NAME, word);
    }

    public String getGuiLocale_aliasGui_addAliasItemName() {
        return guiLocale_aliasGui_addAliasItemName;
    }

    public String getGuiLocale_aliasGui_removeAliasItemName() {
        return guiLocale_aliasGui_removeAliasItemName;
    }

    public String getAliasGuiTypeNewAlias(String word) {
        return guiLocale_aliasGui_typeNewAlias.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getAliasGuiEnterAliasAgain(String word) {
        return guiLocale_aliasGui_enterAliasAgain.replaceAll(LiteralType.CANCEL_MODEL, word);
    }

    public String getGuiLocale_aliasGui_aliasRemoved() {
        return guiLocale_aliasGui_aliasRemoved;
    }

    public String getGuiLocale_aliasGui_canNotRemovedAlias() {
        return guiLocale_aliasGui_canNotRemovedAlias;
    }

    public String getGuiLocale_aliasGui_cancelPhrase() {
        return guiLocale_aliasGui_cancelPhrase;
    }

    public String getGuiLocale_commandMenu_pageName() {
        return guiLocale_commandMenu_pageName;
    }

    public String getGuiLocale_logsGui_selectPlayer() {
        return guiLocale_logsGui_selectPlayer;
    }

    public String getGuiLocale_adminGui_playersGuiShowOfflinePlayersName() {
        return guiLocale_adminGui_playersGuiShowOfflinePlayersName;
    }

    public String getGuiLocale_adminGui_playersGuiShowOfflinePlayersON() {
        return guiLocale_adminGui_playersGuiShowOfflinePlayersON;
    }

    public String getGuiLocale_adminGui_playersGuiShowOfflinePlayersOFF() {
        return guiLocale_adminGui_playersGuiShowOfflinePlayersOFF;
    }

    public String getGuiLocale_mainGui_players() {
        return guiLocale_mainGui_players;
    }

    public String getGuiLocale_adminGui_mainGuiManageServer() {
        return guiLocale_adminGui_mainGuiManageServer;
    }

    public String getGuiLocale_worldBorderGui_addToWorldBorderChatMessage() {
        return guiLocale_worldBorderGui_addToWorldBorderChatMessage;
    }

    public String getGuiLocale_worldBorderGui_worldBorderWarningChatMessage() {
        return guiLocale_worldBorderGui_worldBorderWarningChatMessage;
    }

    public String getGuiLocale_worldBorderGui_worldBorderDamageChatMessage() {
        return guiLocale_worldBorderGui_worldBorderDamageChatMessage;
    }

    public String getGuiLocale_worldBorderGui_centerWorldBorderChatMessage() {
        return guiLocale_worldBorderGui_centerWorldBorderChatMessage;
    }

    public String getGuiLocale_worldBorderGui_setWorldBorderChatMessage() {
        return guiLocale_worldBorderGui_setWorldBorderChatMessage;
    }

    public String getGuiLocale_worldBorderGui_worldBorderGuiPageName() {
        return guiLocale_worldBorderGui_worldBorderGuiPageName;
    }

    public String getGuiLocale_worldBorderGui_addToWorldBorderName() {
        return guiLocale_worldBorderGui_addToWorldBorderName;
    }

    public String getGuiLocale_worldBorderGui_addToWorldBorderLore() {
        return guiLocale_worldBorderGui_addToWorldBorderLore;
    }

    public String getGuiLocale_worldBorderGui_getWorldBorderName() {
        return guiLocale_worldBorderGui_getWorldBorderName;
    }

    public String getAdminGuiWorldBorderGuiGetWorldBorderLore(String message) {
        return guiLocale_worldBorderGui_getWorldBorderLore.replaceAll(LiteralType.WORLD_BORDER_SIZE, message);
    }

    public String getGuiLocale_worldBorderGui_worldBorderWarningName() {
        return guiLocale_worldBorderGui_worldBorderWarningName;
    }

    public String getGuiLocale_worldBorderGui_worldBorderWarningLore() {
        return guiLocale_worldBorderGui_worldBorderWarningLore;
    }

    public String getGuiLocale_worldBorderGui_worldBorderDamageName() {
        return guiLocale_worldBorderGui_worldBorderDamageName;
    }

    public String getGuiLocale_worldBorderGui_worldBorderDamageLore() {
        return guiLocale_worldBorderGui_worldBorderDamageLore;
    }

    public String getGuiLocale_worldBorderGui_centerWorldBorderName() {
        return guiLocale_worldBorderGui_centerWorldBorderName;
    }

    public String getGuiLocale_worldBorderGui_centerWorldBorderLore() {
        return guiLocale_worldBorderGui_centerWorldBorderLore;
    }

    public String getGuiLocale_worldBorderGui_setWorldBorderName() {
        return guiLocale_worldBorderGui_setWorldBorderName;
    }

    public String getGuiLocale_worldBorderGui_setWorldBorderLore() {
        return guiLocale_worldBorderGui_setWorldBorderLore;
    }

    public String getGuiLocale_defaultGameModeGui_defaultGameModeGuiPageName() {
        return guiLocale_defaultGameModeGui_defaultGameModeGuiPageName;
    }

    public String getGuiLocale_defaultGameModeGui_survival() {
        return guiLocale_defaultGameModeGui_survival;
    }

    public String getGuiLocale_defaultGameModeGui_creative() {
        return guiLocale_defaultGameModeGui_creative;
    }

    public String getGuiLocale_defaultGameModeGui_hardcore() {
        return guiLocale_defaultGameModeGui_hardcore;
    }

    public String getGuiLocale_defaultGameModeGui_spectator() {
        return guiLocale_defaultGameModeGui_spectator;
    }

    public String getGuiLocale_gameModeGui_gameModeGuiPageName() {
        return guiLocale_gameModeGui_gameModeGuiPageName;
    }

    public String getGuiLocale_gameModeGui_survival() {
        return guiLocale_gameModeGui_survival;
    }

    public String getGuiLocale_gameModeGui_creative() {
        return guiLocale_gameModeGui_creative;
    }

    public String getGuiLocale_gameModeGui_hardcore() {
        return guiLocale_gameModeGui_hardcore;
    }

    public String getGuiLocale_gameModeGui_spectator() {
        return guiLocale_gameModeGui_spectator;
    }

    public String getGuiLocale_adminGuiDifficulty_guiDifficultyGuiPageName() {
        return guiLocale_adminGuiDifficulty_guiDifficultyGuiPageName;
    }

    public String getGuiLocale_adminGuiDifficulty_peaceful() {
        return guiLocale_adminGuiDifficulty_peaceful;
    }

    public String getGuiLocale_adminGuiDifficulty_easy() {
        return guiLocale_adminGuiDifficulty_easy;
    }

    public String getGuiLocale_adminGuiDifficulty_medium() {
        return guiLocale_adminGuiDifficulty_medium;
    }

    public String getGuiLocale_adminGuiDifficulty_hard() {
        return guiLocale_adminGuiDifficulty_hard;
    }

    public String getGuiLocale_timeGui_chatResponse() {
        return guiLocale_timeGui_chatResponse;
    }

    public String getGuiLocale_timeGui_pageName() {
        return guiLocale_timeGui_pageName;
    }

    public String getGuiLocale_timeGui_day() {
        return guiLocale_timeGui_day;
    }

    public String getGuiLocale_timeGui_noon() {
        return guiLocale_timeGui_noon;
    }

    public String getGuiLocale_timeGui_midNight() {
        return guiLocale_timeGui_midNight;
    }

    public String getGuiLocale_timeGui_night() {
        return guiLocale_timeGui_night;
    }

    public String getGuiLocale_timeGui_number() {
        return guiLocale_timeGui_number;
    }

    public String getGuiLocale_adminGuiWeatherGui_weatherGuiPageName() {
        return guiLocale_adminGuiWeatherGui_weatherGuiPageName;
    }

    public String getGuiLocale_adminGuiWeatherGui_sunny() {
        return guiLocale_adminGuiWeatherGui_sunny;
    }

    public String getGuiLocale_adminGuiWeatherGui_rainy() {
        return guiLocale_adminGuiWeatherGui_rainy;
    }

    public String getGuiLocale_adminGuiWeatherGui_thunder() {
        return guiLocale_adminGuiWeatherGui_thunder;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_worldToolsGuiPageName() {
        return guiLocale_adminGuiWorldToolsGui_worldToolsGuiPageName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_defaultGamemodeName() {
        return guiLocale_adminGuiWorldToolsGui_defaultGamemodeName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_defaultGamemodeLore() {
        return guiLocale_adminGuiWorldToolsGui_defaultGamemodeLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_worldDifficultyName() {
        return guiLocale_adminGuiWorldToolsGui_worldDifficultyName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_worldDifficultyLore() {
        return guiLocale_adminGuiWorldToolsGui_worldDifficultyLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_gamemodeName() {
        return guiLocale_adminGuiWorldToolsGui_gamemodeName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_gamemodeLore() {
        return guiLocale_adminGuiWorldToolsGui_gamemodeLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_reloadName() {
        return guiLocale_adminGuiWorldToolsGui_reloadName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_reloadLore() {
        return guiLocale_adminGuiWorldToolsGui_reloadLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_sayName() {
        return guiLocale_adminGuiWorldToolsGui_sayName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_sayLore() {
        return guiLocale_adminGuiWorldToolsGui_sayLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_seedName() {
        return guiLocale_adminGuiWorldToolsGui_seedName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_seedLore() {
        return guiLocale_adminGuiWorldToolsGui_seedLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_setWorldSpawnName() {
        return guiLocale_adminGuiWorldToolsGui_setWorldSpawnName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_setWorldSpawnLore() {
        return guiLocale_adminGuiWorldToolsGui_setWorldSpawnLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_spawnPointName() {
        return guiLocale_adminGuiWorldToolsGui_spawnPointName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_spawnPointLore() {
        return guiLocale_adminGuiWorldToolsGui_spawnPointLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_timeName() {
        return guiLocale_adminGuiWorldToolsGui_timeName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_timeLore() {
        return guiLocale_adminGuiWorldToolsGui_timeLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_weatherName() {
        return guiLocale_adminGuiWorldToolsGui_weatherName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_weatherLore() {
        return guiLocale_adminGuiWorldToolsGui_weatherLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_worldBorderName() {
        return guiLocale_adminGuiWorldToolsGui_worldBorderName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_worldBorderLore() {
        return guiLocale_adminGuiWorldToolsGui_worldBorderLore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_xpName() {
        return guiLocale_adminGuiWorldToolsGui_xpName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_xpLore() {
        return guiLocale_adminGuiWorldToolsGui_xpLore;
    }

    public String getAdminGuiWorldToolsGuiXpChatMessage(String message) {
        return guiLocale_adminGuiWorldToolsGui_xpChatMessage.replaceAll(LiteralType.CANCEL_MODEL, message);
    }

    public String getGuiLocale_adminGuiWorldToolsGui_xpChatCanceledMessage() {
        return guiLocale_adminGuiWorldToolsGui_xpChatCanceledMessage;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_titleName() {
        return guiLocale_adminGuiWorldToolsGui_titleName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_titleLore() {
        return guiLocale_adminGuiWorldToolsGui_titleLore;
    }

    public String getAdminGuiWorldToolsGuiTitleChatMessage(String message) {
        return guiLocale_adminGuiWorldToolsGui_titleChatMessage.replaceAll(LiteralType.CANCEL_MODEL, message);
    }

    public String getGuiLocale_adminGuiWorldToolsGui_titleChatCanceledMessage() {
        return guiLocale_adminGuiWorldToolsGui_titleChatCanceledMessage;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_tellName() {
        return guiLocale_adminGuiWorldToolsGui_tellName;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_tellLore() {
        return guiLocale_adminGuiWorldToolsGui_tellLore;
    }

    public String getAdminGuiWorldToolsGuiTellChatMessage(String message) {
        return guiLocale_adminGuiWorldToolsGui_tellChatMessage.replaceAll(LiteralType.CANCEL_MODEL, message);
    }

    public String getGuiLocale_adminGuiWorldToolsGui_tellChatCanceledMessage() {
        return guiLocale_adminGuiWorldToolsGui_tellChatCanceledMessage;
    }

    public String getGuiLocale_logsGui_logsFromDay() {
        return guiLocale_logsGui_logsFromDay;
    }

    public String getGuiLocale_logsGui_logsFromDateInterval() {
        return guiLocale_logsGui_logsFromDateInterval;
    }

    public String getGuiLocale_bansGui_selectTime() {
        return guiLocale_bansGui_selectTime;
    }

    public String getGuiLocale_chooseTimeGui_seconds() {
        return guiLocale_chooseTimeGui_seconds;
    }

    public String getGuiLocale_chooseTimeGui_minutes() {
        return guiLocale_chooseTimeGui_minutes;
    }

    public String getGuiLocale_chooseTimeGui_hours() {
        return guiLocale_chooseTimeGui_hours;
    }

    public String getGuiLocale_chooseTimeGui_days() {
        return guiLocale_chooseTimeGui_days;
    }

    public String getGuiLocale_chooseTimeGui_weeks() {
        return guiLocale_chooseTimeGui_weeks;
    }

    public String getGuiLocale_chooseTimeGui_months() {
        return guiLocale_chooseTimeGui_months;
    }

    public String getGuiLocale_chooseTimeGui_years() {
        return guiLocale_chooseTimeGui_years;
    }

    public String getGuiLocale_singlePlayerGui_releasePlayer() {
        return guiLocale_singlePlayerGui_releasePlayer;
    }

    public String getMutesGuiMutedBy(String player) {
        return guiLocale_mutesGui_mutedBy.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getMutesGuiExpiredDate(String date) {
        return guiLocale_mutesGui_expiredDate.replaceAll(LiteralType.DATE, date);
    }

    public String getMutesGuiUnmute(String player) {
        return guiLocale_mutesGui_unMute.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getBanDescriptionBannedBy(String date) {
        return guiLocale_bansGui_banDescriptionBannedBy.replaceAll(LiteralType.DATE, date);
    }

    public String getBanDescriptionBannedDate(String date) {
        return guiLocale_bansGui_banDescriptionBannedDate.replaceAll(LiteralType.DATE, date);
    }

    public String getBanDescriptionExpiredDate(String date) {
        return guiLocale_bansGui_banDescriptionExpiredDate.replaceAll(LiteralType.DATE, date);
    }

    public String getGuiLocale_logsGui_logsName() {
        return guiLocale_logsGui_logsName;
    }

    public String getBanDescriptionComment(String comment) {
        return guiLocale_bansGui_banDescriptionComment.replaceAll(LiteralType.COMMENT, comment);
    }

    public String getBansGuiUnban(String player) {
        return guiLocale_bansGui_unban.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getGuiLocale_chooseTimeGui_exit() {
        return guiLocale_chooseTimeGui_exit;
    }

    public String getGuiLocale_adminGui_unknownStatus() {
        return guiLocale_adminGui_unknownStatus;
    }

    public String getGuiLocale_chooseTimeGui_pageName() {
        return guiLocale_chooseTimeGui_pageName;
    }

    public String getGuiLocale_chooseTimeGui_second() {
        return guiLocale_chooseTimeGui_second;
    }

    public String getGuiLocale_chooseTimeGui_minute() {
        return guiLocale_chooseTimeGui_minute;
    }

    public String getGuiLocale_chooseTimeGui_hour() {
        return guiLocale_chooseTimeGui_hour;
    }

    public String getGuiLocale_chooseTimeGui_day() {
        return guiLocale_chooseTimeGui_day;
    }

    public String getGuiLocale_chooseTimeGui_week() {
        return guiLocale_chooseTimeGui_week;
    }

    public String getGuiLocale_chooseTimeGui_month() {
        return guiLocale_chooseTimeGui_month;
    }

    public String getGuiLocale_chooseTimeGui_year() {
        return guiLocale_chooseTimeGui_year;
    }

    public String getGuiLocale_adminGui_expiredTime() {
        return guiLocale_adminGui_expiredTime;
    }

    public String getAdminGuiExecute(String title) {
        return guiLocale_adminGui_execute.replaceAll(LiteralType.TITLE, title);
    }

    public String getSinglePlayerGuiBanGuiPageName(String player) {
        return guiLocale_singlePlayerGui_banGuiPageName.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getSinglePlayerGuiPageName(String player) {
        return guiLocale_singlePlayerGui_pageName.replaceAll(LiteralType.PLAYER_NAME, player);
    }

    public String getGuiLocale_singlePlayerGui_statusOnline() {
        return guiLocale_singlePlayerGui_statusOnline;
    }

    public String getGuiLocale_singlePlayerGui_statusOffline() {
        return guiLocale_singlePlayerGui_statusOffline;
    }

    public String getGuiLocale_singlePlayerGui_killPlayer() {
        return guiLocale_singlePlayerGui_killPlayer;
    }

    public String getGuiLocale_singlePlayerGui_freezePlayer() {
        return guiLocale_singlePlayerGui_freezePlayer;
    }

    public String getGuiLocale_singlePlayerGui_teleportPlayer() {
        return guiLocale_singlePlayerGui_teleportPlayer;
    }

    public String getGuiLocale_singlePlayerGui_teleportToPlayer() {
        return guiLocale_singlePlayerGui_teleportToPlayer;
    }

    public String getGuiLocale_singlePlayerGui_banPlayer() {
        return guiLocale_singlePlayerGui_banPlayer;
    }

    public String getGuiLocale_singlePlayerGui_mutePlayer() {
        return guiLocale_singlePlayerGui_mutePlayer;
    }

    public String getGuiLocale_singlePlayerGui_inventory() {
        return guiLocale_singlePlayerGui_inventory;
    }

    public String getGuiLocale_singlePlayerGui_enderChest() {
        return guiLocale_singlePlayerGui_enderChest;
    }

    public String getGuiLocale_singlePlayerGui_hidePlayer() {
        return guiLocale_singlePlayerGui_hidePlayer;
    }

    public String getGuiLocale_singlePlayerGui_hidePlayerCurrent() {
        return guiLocale_singlePlayerGui_hidePlayerCurrent;
    }

    public String getGuiLocale_singlePlayerGui_kickPlayer() {
        return guiLocale_singlePlayerGui_kickPlayer;
    }

    public String getGuiLocale_singlePlayerGui_temporaryBanPlayer() {
        return guiLocale_singlePlayerGui_temporaryBanPlayer;
    }

    public String getGuiLocale_adminToolsGui_pageName() {
        return guiLocale_adminToolsGui_pageName;
    }

    public String getGuiLocale_adminToolsGui_adminAxe() {
        return guiLocale_adminToolsGui_adminAxe;
    }

    public String getGuiLocale_adminToolsGui_adminPickAxe() {
        return guiLocale_adminToolsGui_adminPickAxe;
    }

    public String getGuiLocale_adminToolsGui_adminShovel() {
        return guiLocale_adminToolsGui_adminShovel;
    }

    public String getGuiLocale_adminToolsGui_adminSword() {
        return guiLocale_adminToolsGui_adminSword;
    }

    public String getGuiLocale_adminToolsGui_adminBow() {
        return guiLocale_adminToolsGui_adminBow;
    }

    public String getGuiLocale_adminToolsGui_adminHoe() {
        return guiLocale_adminToolsGui_adminHoe;
    }

    public String getGuiLocale_adminStaff_guiPageName() {
        return guiLocale_adminStaff_guiPageName;
    }

    public String getGuiLocale_adminStaff_guiVanish() {
        return guiLocale_adminStaff_guiVanish;
    }

    public String getGuiLocale_adminStaff_guiVanishCurrent() {
        return guiLocale_adminStaff_guiVanishCurrent;
    }

    public String getGuiLocale_adminStaff_guiMaintenance() {
        return guiLocale_adminStaff_guiMaintenance;
    }

    public String getGuiLocale_adminStaff_adminTools() {
        return guiLocale_adminStaff_adminTools;
    }

    public String getGuiLocale_bansGui_pageName() {
        return guiLocale_bansGui_pageName;
    }

    public String getBansGuiBannedPlayersList() {
        return guiLocale_bansGui_bannedPlayersList;
    }

    public String getGuiLocale_bansGui_temporaryBannedPlayersList() {
        return guiLocale_bansGui_temporaryBannedPlayersList;
    }

    public String getGuiLocale_bansGui_mutedPlayers() {
        return guiLocale_bansGui_mutedPlayers;
    }

    public String getGuiLocale_bansGui_frozenPlayersList() {
        return guiLocale_bansGui_frozenPlayersList;
    }

    public String getGuiLocale_bansGui_hiddenPlayers() {
        return guiLocale_bansGui_hiddenPlayers;
    }

    public String getGuiLocale_mainGui_pageName() {
        return guiLocale_mainGui_pageName;
    }

    public String getGuiLocale_mainGui_bans() {
        return guiLocale_mainGui_bans;
    }

    public String getGuiLocale_mainGui_adminStaff() {
        return guiLocale_mainGui_adminStaff;
    }

    public String getGuiLocale_playersGui_pageName() {
        return guiLocale_playersGui_pageName;
    }

    public String getGuiLocale_adminGui_back() {
        return guiLocale_adminGui_back;
    }

    public String getGuiLocale_adminGui_close() {
        return guiLocale_adminGui_close;
    }

    public String getGuiLocale_logsGui_logsTimeGuiTitle() {
        return guiLocale_logsGui_logsTimeGuiTitle;
    }

    public String getGuiLocale_logsGui_logsTimeOneDay() {
        return guiLocale_logsGui_logsTimeOneDay;
    }

    public String getGuiLocale_logsGui_logsTimeMultiDay() {
        return guiLocale_logsGui_logsTimeMultiDay;
    }

    public String getGuiLocale_calendarGui_firstCalendarGuiTitle() {
        return guiLocale_calendarGui_firstCalendarGuiTitle;
    }

    public String getGuiLocale_calendarGui_secondCalendarGuiTitle() {
        return guiLocale_calendarGui_secondCalendarGuiTitle;
    }

    public String getGuiLocale_calendarGui_title() {
        return guiLocale_calendarGui_title;
    }

    public String getGuiLocale_logsGui_title() {
        return guiLocale_logsGui_title;
    }

    public String getGuiLocale_logsGui_logsForAll() {
        return guiLocale_logsGui_logsForAll;
    }

    public String getGuiLocale_logsGui_logsForOnePlayer() {
        return guiLocale_logsGui_logsForOnePlayer;
    }

    public String getGuiLocale_calendarGui_firstDate() {
        return guiLocale_calendarGui_firstDate;
    }

    public String getGuiLocale_calendarGui_endDate() {
        return guiLocale_calendarGui_endDate;
    }

    public String getGuiLocale_singlePlayerGui_statusOfflineNeverPlayerBefore() {
        return guiLocale_singlePlayerGui_statusOfflineNeverPlayerBefore;
    }

    public String getGuiLocale_adminGuiWorldToolsGui_enterMessageInChat() {
        return guiLocale_adminGuiWorldToolsGui_enterMessageInChat;
    }
}
