package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.*;
import watchtowergui.wg.adminfun.listeners.DisableChatListener;
import watchtowergui.wg.adminfun.listeners.WhiteListListener;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.managers.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class AdminFunGui extends BasicGui {

    public final static int ONN = 1;
    public final static int OFF = 0;
    public static GuiLanguageConfig glc;
    static boolean isChatDisabled = false;
    private final WhiteListListener whiteListListener;
    private final DisableChatListener disableChatListener;
    private final Permissions permissions;
    public WatchTowerGui plugin;
    private ItemStack vanishOn;
    private ItemStack vanishOff;
    private ItemStack adminTools;
    private ItemStack backgroundOrange;
    private ItemStack backgroundBlack;
    private ItemStack close;
    private ItemStack goBack;
    private ItemStack worldToolsGui;

    public AdminFunGui(BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_adminStaff_guiPageName(), previousGui);
        this.plugin = WatchTowerGui.getInstance();
        glc = plugin.configsManager.guiLanguageConfig;
        setupGuiItems();
        this.permissions = this.plugin.permissions;
        this.whiteListListener = plugin.listenersManager.whiteListListener;
        this.disableChatListener = plugin.listenersManager.disableChatListener;
        init();
    }

    private void setupGuiItems() {
        worldToolsGui = BasicGui.createItem(Material.JUKEBOX, glc.getGuiLocale_adminGuiWorldToolsGui_worldToolsGuiPageName());
        vanishOn = BasicGui.createItem(Material.GLASS, glc.getGuiLocale_adminStaff_guiVanish(),
                BasicGui.splitLore(glc.getGuiLocale_adminStaff_guiVanishCurrent() + ChatColor.GREEN + ChatColor.BOLD + " ON"
                        , 20));

        vanishOff = BasicGui.createItem(Material.GLASS, glc.getGuiLocale_adminStaff_guiVanish(),
                BasicGui.splitLore(glc.getGuiLocale_adminStaff_guiVanishCurrent() + ChatColor.RED + ChatColor.BOLD + " OFF"
                        , 20));

        close = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        goBack = BasicGui.createItem(Material.ARROW, glc.getGuiLocale_adminGui_back());
        backgroundBlack = BasicGui.createBackground(Colors.BLACK);
        backgroundOrange = BasicGui.createBackground(Colors.ORANGE);
        adminTools = BasicGui.createItem(Material.DIAMOND_AXE, glc.getGuiLocale_adminStaff_adminTools());
    }

    @Override
    public void onClose() {
        super.onClose();
        whiteListListener.removeAdminFunGuis(this);
        disableChatListener.removeAdminFunGuis(this);
    }

    public void setDisableCharMode(int activity) {
        ItemStack redstoneLamp;
        if (activity == ONN)
            redstoneLamp = BasicGui.createItem(Material.LAVA_BUCKET, glc.getGuiLocale_adminStaffGui_disableChat(), BasicGui.splitLore(glc.getGuiLocale_adminStaffGui_disableChatCurrent() + ChatColor.GREEN + ChatColor.BOLD + " ON", 20));
        else if (activity == OFF)
            redstoneLamp = BasicGui.createItem(Material.BUCKET, glc.getGuiLocale_adminStaffGui_disableChat(), BasicGui.splitLore(glc.getGuiLocale_adminStaffGui_disableChatCurrent() + ChatColor.RED + ChatColor.BOLD + " OFF", 20));
        else
            redstoneLamp = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_unknownStatus());
        this.setItem(3, 1, redstoneLamp, player -> {
            isChatDisabled = disableChatListener.disabledChat;
            if (isChatDisabled) {
                setDisableCharMode(OFF);
                Bukkit.getPluginManager().callEvent(new ChatDisabledOFFEvent(player));
            } else {
                setDisableCharMode(ONN);
                Bukkit.getPluginManager().callEvent(new ChatDisabledOnEvent(player));
            }
        });
    }

    public void setMaintenanceMode(int activity) {
        ItemStack torch;
        if (activity == ONN)
            torch = BasicGui.createItem(Material.REDSTONE_TORCH_ON, glc.getGuiLocale_adminStaff_guiMaintenance(), BasicGui.splitLore(glc.getGuiLocale_adminStaffGui_maintenanceCurrent() + ChatColor.GREEN + ChatColor.BOLD + " ON", 20));
        else if (activity == OFF)
            torch = BasicGui.createItem(Material.LEVER, glc.getGuiLocale_adminStaff_guiMaintenance(), BasicGui.splitLore(glc.getGuiLocale_adminStaffGui_maintenanceCurrent() + ChatColor.RED + ChatColor.BOLD + " OFF", 20));
        else
            torch = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_unknownStatus());

        this.setItem(4, 1, torch, player -> {

            isChatDisabled = whiteListListener.maintenanceMode;

            if (isChatDisabled) {
                setMaintenanceMode(OFF);
                Bukkit.getPluginManager().callEvent(new WhiteListOffEvent(player));
            } else {
                setMaintenanceMode(ONN);
                Bukkit.getPluginManager().callEvent(new WhiteListOnEvent(player));
            }

            for (Player playerToWhitelist : Bukkit.getOnlinePlayers()) {

                if (playerToWhitelist.hasPermission(permissions.maintenancePerm)) {
                    if (!whiteListListener.isPlayerInMainteneceMode(playerToWhitelist)) {
                        Bukkit.getPluginManager().callEvent(new AddPlayerToWhiteListEvent(playerToWhitelist));
                    }
                } else {
                    Bukkit.getPluginManager().callEvent(new RemovePlayerFromWhiteListEvent(playerToWhitelist));
                }
            }
        });
    }

    @Override
    public void open(Player opener) {
        super.open(opener);
        setMaintenanceMode(whiteListListener.maintenanceValue());
        setDisableCharMode(disableChatListener.getDisableChatValueValue());
        whiteListListener.addToAdminFunGuis(this);
        disableChatListener.addOpenedGuis(this);
        this.setVanishMode(plugin.listenersManager.hidingPlayerListener.isHidden(getLastViewer().getUniqueId()));
    }

    protected void init() {

        if (previousGui != null) {
            this.setItem(8, 1, goBack, player -> {
                if (previousGui != null) {
                    previousGui.open(player);
                }
            });
        }

        this.setItem(8, 0, close, HumanEntity::closeInventory);

        this.setItem(6, 1, worldToolsGui,
                player -> new WorldToolsGui(AdminFunGui.this).open(player));

        this.setItem(5, 1, adminTools, player -> new AdminToolsGui(AdminFunGui.this).open(player));
        this.autoFill(backgroundBlack, backgroundOrange);
    }

    public void setVanishMode(boolean value) {
        this.setItem(2, 1, (value) ? vanishOn : vanishOff,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getADCommand("hide")));
    }
}
