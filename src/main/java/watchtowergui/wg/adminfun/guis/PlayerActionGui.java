package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.examples.ConfirmGui;
import ad.guis.ultimateguis.multithreading.Operation;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.guis.CustomBansGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.logs.guis.LogsGui;
import watchtowergui.wg.managers.staticclasses.CalendarCalculator;

public class PlayerActionGui extends BasicGui {

    public final static int OFFLINE = 0;
    public final static int ONLINE = 1;
    private static ItemStack teleportPlayer;
    private static ItemStack kill;
    private static ItemStack ban;
    private static ItemStack vanishOnItem;
    private static ItemStack comeBack;
    private static ItemStack close;
    private static ItemStack mute;
    private static ItemStack logsDay;
    private static ItemStack logsDate;
    private static ItemStack inv;
    private static ItemStack enderChest;
    private static ItemStack kick;
    private static ItemStack tempBan;
    private static ItemStack vanishOffItem;
    private static ItemStack unbanItem;
    private static ItemStack tempUnbanItem;
    private static ItemStack unMuteItem;
    private static ItemStack backgroundBlack;
    private static boolean initFirstTime = true;
    private final WatchTowerGui plugin;
    public GuiLanguageConfig glc;
    OfflinePlayer offlinePlayer;

    public PlayerActionGui(OfflinePlayer offlinePlayer, BasicGui previousGui) {
        super(5, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getSinglePlayerGuiPageName(
                (offlinePlayer.getName() == null) ? "not exist" : offlinePlayer.getName()), previousGui);
        this.plugin = WatchTowerGui.getInstance();
        glc = plugin.configsManager.guiLanguageConfig;
        setupGui();
        this.offlinePlayer = offlinePlayer;
        init();
    }

    public static int toActivity(boolean value) {
        if (value) return ONLINE;
        return OFFLINE;
    }

    public void setActivity(int activity) {
        setActivity(activity, -1);
    }

    private void setActivity(int activity, long calculatedTime) {
        ItemStack wool;
        ItemMeta meta;
        if (activity == ONLINE) {
            wool = new ItemStack(Material.WOOL, 1, (short) 13);
            meta = wool.getItemMeta();
            meta.setDisplayName(glc.getGuiLocale_singlePlayerGui_statusOnline());
        } else if (activity == OFFLINE) {
            wool = new ItemStack(Material.WOOL, 1, (short) 14);
            meta = wool.getItemMeta();
            meta.setDisplayName(glc.getGuiLocale_singlePlayerGui_statusOffline());
            if (calculatedTime < 0) {
                //calc time in background
                new Operation<>(offlinePlayer::getLastPlayed).syncSubscribe(value -> {
                    setActivity(toActivity(offlinePlayer.isOnline()), value);
                }).run();
            } else if (calculatedTime == 0) {
                meta.setLore(splitLore(glc.getGuiLocale_singlePlayerGui_statusOfflineNeverPlayerBefore() + "\n", 30));
            } else {
                meta.setLore(splitLore(glc.getSinglePlayerGuiLastActivity(
                        CalendarCalculator.standardDateFormat(calculatedTime)) + "\n", 30));
            }
        } else {
            wool = new ItemStack(Material.WOOL, 1, (short) 15);
            meta = wool.getItemMeta();
            meta.setDisplayName(glc.getGuiLocale_adminGui_unknownStatus());
        }
        wool.setItemMeta(meta);

        this.setItem(0, 0, wool, null);
    }

    private void setupGui() {
        if (!initFirstTime) return;
        vanishOnItem = BasicGui.createItem(Material.GLASS, glc.getGuiLocale_singlePlayerGui_hidePlayer(),
                BasicGui.splitLore(glc.getGuiLocale_singlePlayerGui_hidePlayerCurrent()
                        + ChatColor.GREEN + "" + ChatColor.BOLD + "ON", 25));

        vanishOffItem = BasicGui.createItem(Material.GLASS, glc.getGuiLocale_singlePlayerGui_hidePlayer(),
                BasicGui.splitLore(glc.getGuiLocale_singlePlayerGui_hidePlayerCurrent()
                        + ChatColor.RED + "" + ChatColor.BOLD + "OFF", 25));

        kill = BasicGui.createItem(Material.SKULL_ITEM, glc.getGuiLocale_singlePlayerGui_killPlayer(), (short) 0);
        ban = BasicGui.createItem(Material.SKULL_ITEM, glc.getGuiLocale_singlePlayerGui_banPlayer(), (short) 1);
        comeBack = BasicGui.createItem(Material.ARROW, glc.getGuiLocale_adminGui_back());
        close = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        mute = BasicGui.createItem(Material.PAPER, glc.getGuiLocale_singlePlayerGui_mutePlayer());
        logsDay = BasicGui.createItem(Material.DAYLIGHT_DETECTOR, glc.getGuiLocale_logsGui_logsFromDay());
        logsDate = BasicGui.createItem(Material.BEACON, glc.getGuiLocale_logsGui_logsFromDateInterval());
        inv = BasicGui.createItem(Material.CHEST, glc.getGuiLocale_singlePlayerGui_inventory());
        enderChest = BasicGui.createItem(Material.ENDER_CHEST, glc.getGuiLocale_singlePlayerGui_enderChest());
        kick = BasicGui.createItem(Material.LEATHER_BOOTS, glc.getGuiLocale_singlePlayerGui_kickPlayer());
        tempBan = BasicGui.createItem(Material.WATCH, glc.getGuiLocale_singlePlayerGui_temporaryBanPlayer());
        teleportPlayer = BasicGui.createItem(Material.EYE_OF_ENDER, glc.getGuiLocale_singlePlayerGui_teleportPlayer());
        unbanItem = BasicGui.createSegmentedItem(Material.NETHER_STAR, glc.getGuiLocale_singlePlayerGui_unbanPlayer());
        tempUnbanItem = BasicGui.createSegmentedItem(Material.BED, glc.getGuiLocale_singlePlayerGui_tempUnbanPlayer());
        unMuteItem = BasicGui.createSegmentedItem(Material.EMPTY_MAP, glc.getGuiLocale_singlePlayerGui_unMutePlayer());
        backgroundBlack = BasicGui.createBackground(Colors.BLACK);
        initFirstTime = false;
    }

    public OfflinePlayer getOfflinePlayer() {
        return offlinePlayer;
    }

    public void setFreeze(boolean freezeFlag) {
        ItemStack freeze;
        ItemMeta meta;
        if (!freezeFlag) {
            freeze = new ItemStack(Material.PACKED_ICE);
            meta = freeze.getItemMeta();
            meta.setDisplayName(glc.getGuiLocale_singlePlayerGui_freezePlayer());
        } else {
            freeze = new ItemStack(Material.ICE);
            meta = freeze.getItemMeta();
            meta.setDisplayName(glc.getGuiLocale_singlePlayerGui_releasePlayer());
        }
        freeze.setItemMeta(meta);
        this.setItem(2, 1, freeze, playerWhoClicked ->
                playerWhoClicked.performCommand(plugin.commandsControlListener.getMainADCommandLabel("freeze")
                        + " " + offlinePlayer.getName()));
    }

    public void updateLocation() {
        Player onlinePlayer = offlinePlayer.getPlayer();
        ItemStack locationItem;
        if (onlinePlayer != null) {
            Location loc = onlinePlayer.getLocation();
            locationItem = BasicGui
                    .createSegmentedItem(Material.COMPASS, glc.getGuiLocale_singlePlayerGui_playerLocationName() + "\n"
                            + glc.getSinglePlayerGuiPlayerLocationX(String.valueOf((float) loc.getX())) + "\n"
                            + glc.getSinglePlayerGuiPlayerLocationY(String.valueOf((float) loc.getY())) + "\n"
                            + glc.getSinglePlayerGuiPlayerLocationZ(String.valueOf((float) loc.getZ())) + "\n"
                            + glc.getGuiLocale_singlePlayerGui_playerLocationClickToTeleportToPlayer());
        } else {
            locationItem = BasicGui.createSegmentedItem(Material.COMPASS, glc.getGuiLocale_singlePlayerGui_playerLocationLocationPlayersOffline());
        }
        this.setItem(4, 1, locationItem, playerWhoClicked -> playerWhoClicked
                .performCommand(plugin.commandsControlListener.getCommandLabel("minecraft:tp")
                        + " " + playerWhoClicked.getName() + " " + offlinePlayer.getName()));
    }

    protected void init() {

        this.setItem(1, 1, kill, playerWhoClicked ->
                playerWhoClicked.performCommand(plugin.commandsControlListener.getCommandLabel("minecraft:kill")
                        + " " + offlinePlayer.getName()));

        updateBanned();
        setTempBanned(WatchTowerGui.getInstance().listenersManager.tempBanListener.isPlayerBanned(offlinePlayer.getUniqueId()));
        setMuted(WatchTowerGui.getInstance().listenersManager.muteListener.isPlayerMuted(offlinePlayer.getUniqueId()));
        updateLocation();
        setFreeze(this.plugin.listenersManager.freezeListener.isFrozen(offlinePlayer));

        this.setItem(3, 1, teleportPlayer, playerWhoClicked -> playerWhoClicked
                .performCommand(plugin.commandsControlListener.getCommandLabel("minecraft:tp")
                        + " " + offlinePlayer.getName() + " " + playerWhoClicked.getName()));

        this.setItem(1, 2, logsDay, playerWhoClicked ->
                LogsGui.logsOneDayForPlayer(offlinePlayer.getName(), this).open(playerWhoClicked));
        this.setItem(4, 2, inv, playerWhoClicked -> {
            Player p = offlinePlayer.getPlayer();
            if (p != null)
                playerWhoClicked.openInventory(p.getInventory());
            else playerWhoClicked.sendMessage(glc.getGuiLocale_singlePlayerGui_playerIsOffline());
        });
        this.setItem(3, 2, enderChest, playerWhoClicked -> {
            Player p = offlinePlayer.getPlayer();
            if (p != null)
                playerWhoClicked.openInventory(p.getEnderChest());
            else playerWhoClicked.sendMessage(glc.getGuiLocale_singlePlayerGui_playerIsOffline());
        });
        this.setItem(2, 2, logsDate, playerWhoClicked ->
                LogsGui.logsManyDaysForPlayer(offlinePlayer.getName(), this).open(playerWhoClicked));
        this.setItem(5, 2, kick, playerWhoClicked ->
                playerWhoClicked.performCommand(plugin.commandsControlListener.getCommandLabel("minecraft:kick")
                        + " " + offlinePlayer.getName()));
        if (previousGui != null) {
            this.setItem(8, 1, comeBack, player -> {
                if (previousGui != null) previousGui.open(player);
            });
        }
        this.setItem(8, 2, close, HumanEntity::closeInventory);
        setActivity(toActivity(offlinePlayer.isOnline()));
        setVanished(WatchTowerGui.getInstance().listenersManager.hidingPlayerListener.isHidden(offlinePlayer.getUniqueId()));

        this.autoFill(backgroundBlack);
    }

    public void updateBanned() {
        if (offlinePlayer.isBanned()) {
            this.setItem(5, 1, unbanItem, player -> {
                new ConfirmGui(glc.getBansGuiUnban(offlinePlayer.getName()),
                        acceptPlayer -> {
                            player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("pardon") + " " + offlinePlayer.getName());
                            updateBanned();
                            this.open(acceptPlayer);
                        }, this::open).open(player);
            });
        } else {
            this.setItem(5, 1, ban, player -> new ConfirmGui(glc.getSinglePlayerGuiBanGuiPageName(offlinePlayer.getName()), playerWhoAccept -> {
                playerWhoAccept.performCommand(plugin.commandsControlListener.getCommandLabel("minecraft:ban")
                        + " " + offlinePlayer.getName());
                PlayerActionGui.this.open(playerWhoAccept);
                updateBanned();
            }, PlayerActionGui.this::open).open(player));
        }
    }

    public void setTempBanned(boolean value) {
        if (value) {
            this.setItem(6, 2, tempUnbanItem, player -> {
                new ConfirmGui(glc.getBansGuiUnban(offlinePlayer.getName()), acceptPlayer -> {
                    this.addGuiToListener();
                    acceptPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getADCommand("tmunban")
                            + " " + offlinePlayer.getName());
                    this.open(acceptPlayer);
                }, this::open).open(player);

            });
        } else {
            this.setItem(6, 2, tempBan, playerWhoClicked ->
                    new CustomBansGui(offlinePlayer, PlayerActionGui.this).open(playerWhoClicked));
        }
    }

    public void setMuted(boolean value) {
        if (value) {
            this.setItem(6, 1, unMuteItem, player -> {
                new ConfirmGui(glc.getMutesGuiUnmute(offlinePlayer.getName()), acceptPlayer -> {
                    this.addGuiToListener();
                    acceptPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getADCommand("unmute")
                            + " " + offlinePlayer.getName());
                    this.open(acceptPlayer);
                }, this::open).open(player);
            });
        } else {
            this.setItem(6, 1, mute, player ->
                    new CustomBansGui(offlinePlayer, PlayerActionGui.this,
                            CustomBansGui.MUTE_GUI).open(player));
        }
    }

    private void addGuiToListener() {
        this.plugin.listenersManager.playerActionGuiListener.addPlayerActionGui(this);
    }

    private void removeGuiFromListener() {
        this.plugin.listenersManager.playerActionGuiListener.removeActionGui(this);
    }

    @Override
    public void onClose() {
        this.removeGuiFromListener();
        super.onClose();
    }

    @Override
    public void open(Player player) {
        this.addGuiToListener();
        super.open(player);
    }

    public void setVanished(boolean value) {
        this.setItem(1, 3, (value) ? vanishOnItem : vanishOffItem, player ->
                player.performCommand(plugin.commandsControlListener.getMainADCommandLabel("hide")
                        + " " + offlinePlayer.getName()));
    }
}
