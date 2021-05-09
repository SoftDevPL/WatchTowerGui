package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WorldBorderGui extends BasicGui {

    private static GuiLanguageConfig glc;
    private static ChatManager chatManager;
    private static ItemStack setWorldBorder;
    private static ItemStack centerWorldBorder;
    private static ItemStack damage;
    private static ItemStack warning;
    private static ItemStack add;
    private static ItemStack close;
    private static ItemStack back;
    private static ItemStack backGroundYellow;
    private static ItemStack backGroundBlack;
    public WatchTowerGui watchTowerGui;

    public WorldBorderGui(BasicGui previousGui) throws IllegalArgumentException {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_worldBorderGui_worldBorderGuiPageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        chatManager = watchTowerGui.listenersManager.chatManager;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        close = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        back = BasicGui.createItem(Material.ARROW, glc.getGuiLocale_adminGui_back());
        backGroundYellow = BasicGui.createBackground(Colors.YELLOW);
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        setWorldBorder = BasicGui.createItem(Material.WOOD_STEP,
                glc.getGuiLocale_worldBorderGui_setWorldBorderName(),
                BasicGui.splitLore(glc.getGuiLocale_worldBorderGui_setWorldBorderLore(), 25),
                (short) 4);
        centerWorldBorder = BasicGui.createItem(Material.LOG_2, glc.getGuiLocale_worldBorderGui_centerWorldBorderName(),
                BasicGui.splitLore(glc.getGuiLocale_worldBorderGui_centerWorldBorderLore(), 25), (short) 0);
        damage = BasicGui.createItem(Material.WOOD, glc.getGuiLocale_worldBorderGui_worldBorderDamageName(),
                BasicGui.splitLore(glc.getGuiLocale_worldBorderGui_worldBorderDamageLore(), 25), (short) 4);
        warning = BasicGui.createItem(Material.ACACIA_FENCE, glc.getGuiLocale_worldBorderGui_worldBorderWarningName(),
                BasicGui.splitLore(glc.getGuiLocale_worldBorderGui_worldBorderWarningLore(), 25));
        add = BasicGui.createItem(Material.ACACIA_FENCE_GATE, glc.getGuiLocale_worldBorderGui_addToWorldBorderName(),
                BasicGui.splitLore(glc.getGuiLocale_worldBorderGui_addToWorldBorderLore(), 25));

    }

    private void setGetItem(double size) {
        ItemStack get = BasicGui.createItem(Material.ACACIA_STAIRS, glc.getGuiLocale_worldBorderGui_getWorldBorderName(),
                BasicGui.splitLore(glc.getAdminGuiWorldBorderGuiGetWorldBorderLore(String.valueOf((int) size)), 25));

        this.setItem(2, 1, get,
                player -> setGetItem(player.getWorld().getWorldBorder().getSize()));
    }

    protected void init() {
        this.setItem(1, 1, setWorldBorder, player -> {
            player.closeInventory();
            player.sendMessage(glc.getGuiLocale_worldBorderGui_setWorldBorderChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("worldborder") + " set " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(4, 1, centerWorldBorder, player -> {
            player.closeInventory();
            player.sendMessage(glc.getGuiLocale_worldBorderGui_centerWorldBorderChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("worldborder") + " center " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(3, 1, damage, player -> {
            player.closeInventory();
            player.sendMessage(glc.getGuiLocale_worldBorderGui_worldBorderDamageChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("worldborder") + " damage buffer " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(5, 1, warning, player -> {
            player.closeInventory();
            player.sendMessage(glc.getGuiLocale_worldBorderGui_worldBorderWarningChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("worldborder") + " warning time " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(6, 1, add, player -> {
            player.closeInventory();
            player.sendMessage(glc.getGuiLocale_worldBorderGui_addToWorldBorderChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("worldborder") + " add " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(8, 0, close, HumanEntity::closeInventory);
        this.setItem(8, 2, back, player -> {
            if (previousGui != null) {
                previousGui.open(player);
            }
        });
        this.autoFill(backGroundYellow, backGroundBlack);
    }

    @Override
    public void open(Player opener) {
        setGetItem(opener.getWorld().getWorldBorder().getSize());
        super.open(opener);
    }
}
