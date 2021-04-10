package watchtowergui.wg.servercontrol.commandcontrol.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.engine.interfaces.Action;
import ad.guis.ultimateguis.examples.ConfirmGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.chat.chatguard.PlayerChatAction;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandDisableEvent;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandEnableEvent;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandLabelChangeEvent;
import watchtowergui.wg.servercontrol.commandcontrol.listeners.SingleCommandGuiListener;
import watchtowergui.wg.servercontrol.plugincontrol.guis.SinglePluginGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SingleCommandGui extends BasicGui {

    private static final ItemStack backgroundGreen;
    private static final ItemStack backgroundRed;

    static {
        backgroundGreen = BasicGui.createBackground(Colors.GREEN);
        backgroundRed = BasicGui.createBackground(Colors.RED);
    }

    private final CommandsControlListener commandsControlListener;
    private final SingleCommandGuiListener singleCommandGuiListener;
    private final ChatManager chatManager;
    private final Command command;
    private final GuiLanguageConfig glc;
    private Player actualPlayer;
    private ItemStack backItem;
    private ItemStack exitItem;
    private ItemStack nameItem;
    private ItemStack aliasesItem;
    private ItemStack usageItem;
    private ItemStack pluginItem;
    private ItemStack statusItemDisable;
    private ItemStack statusItemActive;
    private ItemStack descriptionItem;
    private ItemStack permissionItem;
    private PlayerChatAction labelEnterAction;
    private boolean chatActionReturnValue = true;

    public SingleCommandGui(@NotNull Command cmd, BasicGui previousGui) {
        super(3, cmd.getName(), previousGui);
        this.command = cmd;
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        this.commandsControlListener = WatchTowerGui.getInstance().commandsControlListener;
        this.singleCommandGuiListener = WatchTowerGui.getInstance().listenersManager.singleCommandGuiListener;
        this.chatManager = WatchTowerGui.getInstance().listenersManager.chatManager;
        initPassiveItems();
        initChatActions();
    }

    public Command getCommand() {
        return this.command;
    }

    public void initPassiveItems() {
        backItem = BasicGui.createItem(Material.WOOD_DOOR, glc.getAdminGuiBack());
        exitItem = BasicGui.createItem(Material.BARRIER, glc.getAdminGuiClose());
        statusItemActive = createActiveStatusItem();
        statusItemDisable = createDisableStatusItem();
    }

    private ItemStack createPermissionItem() {
        return BasicGui.createSegmentedItem(Material.TRIPWIRE_HOOK,
                ((command.getPermission() == null) ?
                        glc.getSingleCommandGuiCreatePermissionNotSpecified() :
                        glc.getSingleCommandGuiCreatePermissionItemName(command.getPermission())));
    }

    private ItemStack createNameItem() {
        List<String> lore = simpleSplitLore(
                glc.getSingleCommandGuiCreateNameItemLore_1(command.getLabel()));
        lore.addAll(splitLore(glc.getSingleCommandGuiCreateNameItemLore_2(), 25));
        return BasicGui.createItem(Material.PAPER, glc.getSingleCommandGuiCreateNameItemName(command.getName()), lore);
    }

    private ItemStack createAliasesItem() {
        List<String> lore = new ArrayList<>(command.getAliases().size() + 1);
        command.getAliases().forEach(alias -> lore.add(ChatColor.GREEN + alias));
        lore.add(glc.getSingleCommandGuiCreateAliasesItemLore());
        return BasicGui.createItem(Material.SIGN, glc.getSingleCommandGuiCreateAliasesItemName() , lore);
    }

    private ItemStack createPluginItem() {
        if (command instanceof PluginIdentifiableCommand && ((PluginIdentifiableCommand) command).getPlugin() != null)
            return BasicGui.createSegmentedItem(Material.BOOKSHELF, glc.getSingleCommandGuiCreatePluginItemNameSpecified(((PluginIdentifiableCommand) command).getPlugin().getName()));
        else
            return BasicGui.createSegmentedItem(Material.BOOKSHELF, glc.getSingleCommandGuiCreatePluginItemNameNotSpecified());
    }

    private ItemStack createUsageItem() {
        return BasicGui.createSegmentedItem(Material.BOOK_AND_QUILL,
                ((command.getUsage().isEmpty()) ? glc.getSingleCommandGuiCreateUsageItemNotSpecified() : glc.getSingleCommandGuiCreateUsageItemName(command.getUsage())));
    }

    private ItemStack createDescriptionItem() {
        return BasicGui.createSegmentedItem(Material.BOOK, glc.getSingleCommandGuiCreateDescriptionItemName(command.getDescription()));
    }

    private ItemStack createActiveStatusItem() {
        return BasicGui.createSegmentedItem(Material.WOOL, glc.getSingleCommandGuiCreateActiveStatusItemName(), Colors.GREEN);
    }

    private ItemStack createDisableStatusItem() {
        return BasicGui.createSegmentedItem(Material.WOOL, glc.getSingleCommandGuiCreateDisableStatusItemName(), Colors.RED);
    }

    public void initItems() {
        nameItem = createNameItem();
        aliasesItem = createAliasesItem();
        pluginItem = createPluginItem();
        usageItem = createUsageItem();
        descriptionItem = createDescriptionItem();
        permissionItem = createPermissionItem();
    }

    public void init() {
        gui.clear();
        this.setItem(2, 0, nameItem, player -> {
            player.closeInventory();
            player.sendMessage(glc.getSingleCommandGuiSetCommandEnableEnterNewLabel("\"" + AliasesGui.CANCEL_PHRASE + "\""));
            chatManager.setTask(player.getUniqueId(), this.labelEnterAction);
        });

        this.setItem(4, 0, usageItem, null);
        this.setItem(0, 0, aliasesItem, player -> {
            new AliasesGui(command, SingleCommandGui.this, glc.getAliasGuiCommandNameAliasesPageName(command.getName())).open(player);
        });
        this.setItem(0, 2, permissionItem, null);
        this.setItem(2, 2, descriptionItem, null);
        this.setItem(4, 2, pluginItem, player -> {
            if (command instanceof PluginIdentifiableCommand) {
                new SinglePluginGui(((PluginIdentifiableCommand) command).getPlugin(), this)
                        .open(player);
            }
        });
        this.setItem(8, 0, exitItem, HumanEntity::closeInventory);
        if (previousGui != null) {
            this.setItem(8, 1, backItem, player -> {
                if (previousGui != null) previousGui.open(player);
            });
        }
    }

    private void setCommandEnable(boolean enable) {
        Action enableAction = player -> {
            setWaitingStatus(player);
            Bukkit.getPluginManager().callEvent(new CommandEnableEvent(command, player));

        };
        Action disableAction = player -> new ConfirmGui(glc.getSingleCommandGuiAreYouSure(), p -> {
            singleCommandGuiListener.addGui(this);
            this.setWaitingStatus(p);
            Bukkit.getPluginManager().callEvent(new CommandDisableEvent(command, p));
            this.open(p);
        }, this::open).open(player);

        this.setItem(6, 1, (enable) ? this.statusItemActive : this.statusItemDisable,
                (enable) ? disableAction : enableAction);

        this.autoFill((enable) ? backgroundGreen : backgroundRed);
    }


    public boolean isWaitingForResult() {
        return actualPlayer != null;
    }

    public void receiveEnableResult(boolean result, String comment) {
        if (!isWaitingForResult()) return;
        this.actualPlayer.sendMessage(comment);
        resetWaitingStatus();
        reinit();
    }

    public void receiveDisableResult(boolean result) {
        if (!isWaitingForResult()) return;
        if (!result)
            this.actualPlayer.sendMessage(glc.getSingleCommandGuiReceiveDisableResultCanNotDisable());
        else
            this.actualPlayer.sendMessage(glc.getSingleCommandGuiReceiveDisableResultSuccessfullyDisabled());
        resetWaitingStatus();
        reinit();
    }

    public void receiveChangeLabelResult(boolean result, String newLabel, String comment) {
        if (!isWaitingForResult()) return;
        this.actualPlayer.sendMessage(comment);
        this.chatActionReturnValue = result;
        if (!result)
            this.actualPlayer.sendMessage(glc.getSingleCommandGuiReceiveChangeLabelResult("\"" + AliasesGui.CANCEL_PHRASE + "\""));
        else this.open(this.actualPlayer);
        this.resetWaitingStatus();
    }

    private void resetWaitingStatus() {
        this.actualPlayer = null;
    }

    private void setWaitingStatus(Player actualPlayer) {
        this.actualPlayer = actualPlayer;
    }


    private boolean checkIsLabelEnterCancel(String message, Player player) {
        if (message.equals(AliasesGui.CANCEL_PHRASE)) {
            this.chatActionReturnValue = true;
            player.sendMessage(glc.getSingleCommandGuiCheckIsLabelEnterCancelCancelPhrase());
            SingleCommandGui.this.open(player);
            return true;
        }
        return false;
    }

    public void initChatActions() {
        labelEnterAction = (chatMessage, player) -> {
            if (!checkIsLabelEnterCancel(chatMessage, player)) {
                this.setWaitingStatus(player);
                this.singleCommandGuiListener.addGui(SingleCommandGui.this);
                Bukkit.getPluginManager().callEvent(new CommandLabelChangeEvent(chatMessage, command, player));
            } else
                this.singleCommandGuiListener.removeGui(SingleCommandGui.this);
            return chatActionReturnValue;
        };
    }

    private void reinit() {
        initItems();
        init();
        setCommandEnable(commandsControlListener.isActive(command));
    }

    @Override
    public void open(Player player) {
        reinit();
        singleCommandGuiListener.addGui(this);
        super.open(player);
    }

    @Override
    public void onClose() {
        singleCommandGuiListener.removeGui(this);
        super.onClose();
    }


}
