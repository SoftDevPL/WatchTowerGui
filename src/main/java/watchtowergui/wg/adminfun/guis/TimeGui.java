package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

public class TimeGui extends BasicGui {

    private static GuiLanguageConfig glc;
    private static ChatManager chatManager;
    private static ItemStack day;
    private static ItemStack noon;
    private static ItemStack midNight;
    private static ItemStack night;
    private static ItemStack number;
    private static ItemStack close;
    private static ItemStack back;
    private static ItemStack backGroundBlue;
    private static ItemStack backGroundBlack;
    public WatchTowerGui watchTowerGui;

    public TimeGui(BasicGui previousGui) throws IllegalArgumentException {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_timeGui_pageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        chatManager = watchTowerGui.listenersManager.chatManager;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        close = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        back = BasicGui.createItem(Material.ARROW, glc.getGuiLocale_adminGui_back());
        backGroundBlue = BasicGui.createBackground(Colors.BLUE);
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        day = BasicGui.createItem(Material.BANNER, glc.getGuiLocale_timeGui_day(), (short) 12);
        noon = BasicGui.createItem(Material.BANNER, glc.getGuiLocale_timeGui_noon(), (short) 11);
        midNight = BasicGui.createItem(Material.BANNER, glc.getGuiLocale_timeGui_midNight(), (short) 0);
        night = BasicGui.createItem(Material.BANNER, glc.getGuiLocale_timeGui_night(), (short) 4);
        number = BasicGui.createItem(Material.BANNER, glc.getGuiLocale_timeGui_number(), (short) 15);

    }

    protected void init() {
        this.setItem(2, 1, day,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("time") + " set day"));
        this.setItem(3, 1, noon,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("time") + " set 6000"));

        this.setItem(5, 1, midNight,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("time") + " set 18000"));
        this.setItem(4, 1, night,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("time") + " set 13000"));

        this.setItem(6, 1, number, player -> {
            player.closeInventory();
            player.sendMessage(glc.getGuiLocale_timeGui_chatResponse());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("time") + " set " + chatMessage);
                new TimeGui(TimeGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(8, 0, close, HumanEntity::closeInventory);
        this.setItem(8, 2, back, player -> {
            if (previousGui != null) {
                previousGui.open(player);
            }
        });
        this.autoFill(backGroundBlue, backGroundBlack);
    }
}
