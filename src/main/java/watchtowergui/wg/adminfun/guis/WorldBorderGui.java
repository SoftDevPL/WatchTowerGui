package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
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
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getAdminGuiWorldBorderGuiWorldBorderGuiPageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        chatManager = watchTowerGui.listenersManager.chatManager;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        close = BasicGui.createItem(Material.BARRIER, glc.getAdminGuiClose());
        back = BasicGui.createItem(Material.ARROW, glc.getAdminGuiBack());
        backGroundYellow = BasicGui.createBackground(Colors.YELLOW);
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        setWorldBorder = BasicGui.createItem(Material.WOOD_STEP,
                glc.getAdminGuiWorldBorderGuiSetWorldBorderName(),
                BasicGui.splitLore(glc.getAdminGuiWorldBorderGuiSetWorldBorderLore(), 25),
                (short) 4);
        centerWorldBorder = BasicGui.createItem(Material.LOG_2, glc.getAdminGuiWorldBorderGuiCenterWorldBorderName(),
                BasicGui.splitLore(glc.getAdminGuiWorldBorderGuiCenterWorldBorderLore(), 25), (short) 0);
        damage = BasicGui.createItem(Material.WOOD, glc.getAdminGuiWorldBorderGuiWorldBorderDamageName(),
                BasicGui.splitLore(glc.getAdminGuiWorldBorderGuiWorldBorderDamageLore(), 25), (short) 4);
        warning = BasicGui.createItem(Material.ACACIA_FENCE, glc.getAdminGuiWorldBorderGuiWorldBorderWarningName(),
                BasicGui.splitLore(glc.getAdminGuiWorldBorderGuiWorldBorderWarningLore(), 25));
        add = BasicGui.createItem(Material.ACACIA_FENCE_GATE, glc.getAdminGuiWorldBorderGuiAddToWorldBorderName(),
                BasicGui.splitLore(glc.getAdminGuiWorldBorderGuiAddToWorldBorderLore(), 25));

    }

    private void setGetItem(double size) {
        ItemStack get = BasicGui.createItem(Material.ACACIA_STAIRS, glc.getAdminGuiWorldBorderGuiGetWorldBorderName(),
                BasicGui.splitLore(glc.getAdminGuiWorldBorderGuiGetWorldBorderLore(String.valueOf((int) size)), 25));

        this.setItem(2, 1, get,
                player -> setGetItem(player.getWorld().getWorldBorder().getSize()));
    }

    protected void init() {
        this.setItem(1, 1, setWorldBorder, player -> {
            player.closeInventory();
            player.sendMessage(glc.getAdminGuiWorldBorderGuiSetWorldBorderChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(CommandsManager.getMCCommand("worldborder") + " set " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(4, 1, centerWorldBorder, player -> {
            player.closeInventory();
            player.sendMessage(glc.getAdminGuiWorldBorderGuiCenterWorldBorderChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(CommandsManager.getMCCommand("worldborder") + " center " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(3, 1, damage, player -> {
            player.closeInventory();
            player.sendMessage(glc.getAdminGuiWorldBorderGuiWorldBorderDamageChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(CommandsManager.getMCCommand("worldborder") + " damage buffer " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(5, 1, warning, player -> {
            player.closeInventory();
            player.sendMessage(glc.getAdminGuiWorldBorderGuiWorldBorderWarningChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(CommandsManager.getMCCommand("worldborder") + " warning time " + chatMessage);
                new WorldBorderGui(WorldBorderGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(6, 1, add, player -> {
            player.closeInventory();
            player.sendMessage(glc.getAdminGuiWorldBorderGuiAddToWorldBorderChatMessage());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(CommandsManager.getMCCommand("worldborder") + " add " + chatMessage);
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
