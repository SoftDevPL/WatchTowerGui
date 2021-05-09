package watchtowergui.wg.bans.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.examples.ConfirmGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.managers.staticclasses.CustomMath;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomBansGui extends BasicGui {

    public static final int SECOND = 0;
    public static final int MINUTES = 1;
    public static final int HOURS = 2;
    public static final int DAYS = 3;
    public static final int WEEKS = 4;
    public static final int MONTHS = 5;
    public static final int YEARS = 6;
    public static final int BAN_GUI = 0;
    public static final int MUTE_GUI = 1;
    private static final DateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
    private static final DateFormat format2 = new SimpleDateFormat("HH:mm:ss");
    private final int guiType;
    private final OfflinePlayer playerToBan;
    private final List<String> loreList = new ArrayList<>();
    public GuiLanguageConfig glc;
    public WatchTowerGui plugin;
    private ItemStack secondsItem;
    private ItemStack minutesItem;
    private ItemStack hoursItem;
    private ItemStack daysItem;
    private ItemStack weeksItem;
    private ItemStack monthItem;
    private ItemStack yearsItem;
    private ItemStack closeItem;
    private ItemStack backItem;
    private ItemStack executeItem;
    private ItemStack backGroundBlack;
    private ItemStack clockItem;
    private ItemStack add1Item;
    private ItemStack add10Item;
    private ItemStack add50Item;
    private ItemStack sub1Item;
    private ItemStack sub10Item;
    private ItemStack sub50Item;
    private int mod = DAYS;
    private long time = 0;
    private String command;

    public CustomBansGui(OfflinePlayer playerToBan, BasicGui previousGui, int guiType) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_chooseTimeGui_pageName(), previousGui);
        this.plugin = WatchTowerGui.getInstance();
        if (guiType < 0 || guiType > 1) this.guiType = BAN_GUI;
        else this.guiType = guiType;
        glc = plugin.configsManager.guiLanguageConfig;
        setupGuis();
        this.playerToBan = playerToBan;
        init();
    }

    public CustomBansGui(OfflinePlayer playerToBan, BasicGui previousGui) {
        this(playerToBan, previousGui, BAN_GUI);
    }

    private void setupGuis() {
        ItemMeta meta;

        add1Item = new ItemStack(Material.STAINED_GLASS_PANE, 1, Colors.GREEN);
        add10Item = new ItemStack(Material.STAINED_GLASS_PANE, 1, Colors.GREEN);
        add50Item = new ItemStack(Material.STAINED_GLASS_PANE, 1, Colors.GREEN);
        sub1Item = new ItemStack(Material.STAINED_GLASS_PANE, 1, Colors.RED);
        sub10Item = new ItemStack(Material.STAINED_GLASS_PANE, 1, Colors.RED);
        sub50Item = new ItemStack(Material.STAINED_GLASS_PANE, 1, Colors.RED);
        clockItem = new ItemStack(Material.WATCH);

        meta = clockItem.getItemMeta();
        meta.setDisplayName(glc.getGuiLocale_adminGui_expiredTime());
        clockItem.setItemMeta(meta);

        secondsItem = BasicGui.createItem(Material.STAINED_GLASS_PANE, glc.getGuiLocale_chooseTimeGui_second(), Colors.GRAY);

        minutesItem = BasicGui.createItem(Material.STAINED_GLASS_PANE, glc.getGuiLocale_chooseTimeGui_minute(), Colors.BLUE);

        hoursItem = BasicGui.createItem(Material.STAINED_GLASS_PANE, glc.getGuiLocale_chooseTimeGui_hour(), Colors.LIGHT_BLUE);
        daysItem = BasicGui.createItem(Material.STAINED_GLASS_PANE, glc.getGuiLocale_chooseTimeGui_day(), Colors.MAGENTA);
        weeksItem = BasicGui.createItem(Material.STAINED_GLASS_PANE, glc.getGuiLocale_chooseTimeGui_week(), Colors.PURPLE);
        monthItem = BasicGui.createItem(Material.STAINED_GLASS_PANE, glc.getGuiLocale_chooseTimeGui_month(), Colors.YELLOW);
        yearsItem = BasicGui.createItem(Material.STAINED_GLASS_PANE, glc.getGuiLocale_chooseTimeGui_year(), Colors.ORANGE);
        closeItem = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        backItem = BasicGui.createItem(Material.ARROW, glc.getGuiLocale_adminGui_back());
        executeItem = BasicGui.createItem(Material.NETHER_STAR, glc.getAdminGuiExecute(""));
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);

    }

    protected void init() {
        String title;
        if (guiType == MUTE_GUI) {
            title = "Mute";
            command = WatchTowerGui.getInstance().commandsControlListener.getMainADCommandLabel("mute") + " ";
        } else {
            title = "Ban";
            command = WatchTowerGui.getInstance().commandsControlListener.getMainADCommandLabel("tmban") + " ";
        }
        setMod(DAYS);
        this.setItem(0, 2, secondsItem, player -> setMod(SECOND));
        this.setItem(1, 2, minutesItem, player -> setMod(MINUTES));
        this.setItem(2, 2, hoursItem, player -> setMod(HOURS));
        this.setItem(3, 2, daysItem, player -> setMod(DAYS));
        this.setItem(4, 2, weeksItem, player -> setMod(WEEKS));
        this.setItem(5, 2, monthItem, player -> setMod(MONTHS));
        this.setItem(6, 2, yearsItem, player -> setMod(YEARS));
        this.setItem(8, 0, closeItem, player -> {
            if (time > 0) {
                new ConfirmGui(glc.getGuiLocale_chooseTimeGui_exit(), playerWhoAccept ->
                        player.closeInventory(), CustomBansGui.this::open).open(player);
            } else {
                player.closeInventory();
            }
        });
        ItemMeta meta = executeItem.getItemMeta();
        meta.setDisplayName(glc.getAdminGuiExecute(title));
        executeItem.setItemMeta(meta);
        this.setItem(8, 1, executeItem, player -> {
            if (time > 0) {
                long t = time;
                long years = t / 31557600000L;
                t %= 31557600000L;
                long months = t / 2629800000L;
                t %= 2629800000L;
                long weeks = t / 604800017L;
                weeks %= 604800017L;
                long days = t / 86400000L;
                days %= 86400000L;
                long hours = t / 3600000L;
                t %= 3600000L;
                long minutes = t / 60000L;
                t %= 60000L;
                long seconds = t / 1000;
                player.closeInventory();
                player.performCommand(command + playerToBan.getName() + " "
                        + seconds + " " + minutes
                        + " " + hours + " "
                        + days + " "
                        + weeks + " " + months
                        + " " + years);
            } else {
                player.sendMessage(glc.getGuiLocale_bansGui_selectTime());
            }
        });
        if (previousGui != null) {
            this.setItem(7, 0, backItem, player -> {
                if (previousGui != null) {
                    if (time > 0) {
                        new ConfirmGui(glc.getGuiLocale_adminGui_back(), playerWhoAccept ->
                                previousGui.open(player), CustomBansGui.this::open).open(player);
                    } else {
                        previousGui.open(player);
                    }
                }
            });
        }
        reloadDate();
        this.autoFill(backGroundBlack);
    }

    public void setMod(int value) {
        this.mod = value;
        switch (value) {
            case SECOND:
                changeTexts(glc.getGuiLocale_chooseTimeGui_second(), glc.getGuiLocale_chooseTimeGui_seconds());
                break;
            case MINUTES:
                changeTexts(glc.getGuiLocale_chooseTimeGui_minute(), glc.getGuiLocale_chooseTimeGui_minutes());
                break;
            case HOURS:
                changeTexts(glc.getGuiLocale_chooseTimeGui_hour(), glc.getGuiLocale_chooseTimeGui_hours());
                break;
            case DAYS:
                changeTexts(glc.getGuiLocale_chooseTimeGui_day(), glc.getGuiLocale_chooseTimeGui_days());
                break;
            case WEEKS:
                changeTexts(glc.getGuiLocale_chooseTimeGui_week(), glc.getGuiLocale_chooseTimeGui_weeks());
                break;
            case MONTHS:
                changeTexts(glc.getGuiLocale_chooseTimeGui_month(), glc.getGuiLocale_chooseTimeGui_months());
                break;
            case YEARS:
                changeTexts(glc.getGuiLocale_chooseTimeGui_year(), glc.getGuiLocale_chooseTimeGui_years());
                break;
        }
    }

    private void addToTime(long value) {
        switch (this.mod) {
            case SECOND:
                this.time += CustomMath.calcMilliseconds(value, 0, 0, 0, 0, 0, 0);
                break;
            case MINUTES:
                this.time += CustomMath.calcMilliseconds(0, value, 0, 0, 0, 0, 0);
                break;
            case HOURS:
                this.time += CustomMath.calcMilliseconds(0, 0, value, 0, 0, 0, 0);
                break;
            case DAYS:
                this.time += CustomMath.calcMilliseconds(0, 0, 0, value, 0, 0, 0);
                break;
            case WEEKS:
                this.time += CustomMath.calcMilliseconds(0, 0, 0, 0, value, 0, 0);
                break;
            case MONTHS:
                this.time += CustomMath.calcMilliseconds(0, 0, 0, 0, 0, value, 0);
                break;
            case YEARS:
                this.time += CustomMath.calcMilliseconds(0, 0, 0, 0, 0, 0, value);
                break;
        }
        if (this.time < 0) {
            this.time = 0;
        }
    }

    private void changeTexts(String singleText, String pluralText) {
        ItemMeta meta;
        meta = add1Item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "+1 " + singleText);
        add1Item.setItemMeta(meta);
        this.setItem(0, 0, add1Item, player -> {
            addToTime(1);
            reloadDate();
        });

        meta = add10Item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "+10 " + pluralText);
        add10Item.setItemMeta(meta);
        this.setItem(1, 0, add10Item, player -> {
            addToTime(10);
            reloadDate();
        });

        meta = add50Item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "+50 " + pluralText);
        add50Item.setItemMeta(meta);
        this.setItem(2, 0, add50Item, player -> {
            addToTime(50);
            reloadDate();
        });

        meta = sub1Item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "-1 " + singleText);
        sub1Item.setItemMeta(meta);
        this.setItem(3, 0, sub1Item, player -> {
            addToTime(-1);
            reloadDate();
        });

        meta = sub10Item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "-10 " + pluralText);
        sub10Item.setItemMeta(meta);
        this.setItem(4, 0, sub10Item, player -> {
            addToTime(-10);
            reloadDate();
        });

        meta = sub50Item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "-50 " + pluralText);
        sub50Item.setItemMeta(meta);
        this.setItem(5, 0, sub50Item, player -> {
            addToTime(-50);
            reloadDate();
        });
    }

    public void reloadDate() {
        Date date = new Date(System.currentTimeMillis() + this.time);
        String date1 = format1.format(date);
        String date2 = format2.format(date);
        this.loreList.add(ChatColor.WHITE + "" + ChatColor.BOLD + date1);
        this.loreList.add(ChatColor.WHITE + "" + ChatColor.BOLD + date2);
        ItemMeta meta = clockItem.getItemMeta();
        meta.setLore(this.loreList);
        clockItem.setItemMeta(meta);
        loreList.clear();

        this.setItem(8, 2, clockItem, null);
    }

    @Override
    public void open(Player opener) {
        super.open(opener);
        this.plugin.listenersManager.customBansGuiListener.addGui(this);
    }

    @Override
    public void onClose() {
        super.onClose();
        this.plugin.listenersManager.customBansGuiListener.removeGui(this);
    }
}
