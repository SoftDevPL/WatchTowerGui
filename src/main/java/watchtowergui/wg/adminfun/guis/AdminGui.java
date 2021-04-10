package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.logs.guis.LogsTimeRangeGui;
import watchtowergui.wg.servercontrol.plugincontrol.guis.ServerControlGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

public class AdminGui extends BasicGui {

    public GuiLanguageConfig glc;

    public AdminGui(BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getMainGuiPageName(), previousGui);
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        init();
    }

    protected void init() {
        ItemStack ban = BasicGui.createItem(Material.REDSTONE_BLOCK, glc.getMainGuiBans());
        ItemStack staffAdminMenu = BasicGui.createItem(Material.ENCHANTMENT_TABLE, glc.getMainGuiAdminStaff());
        ItemStack playersGuiItem = BasicGui.createItem(Material.SKULL_ITEM, glc.getMainGuiPlayers(), (short) 3);
        ItemStack close = BasicGui.createItem(Material.BARRIER, glc.getAdminGuiClose());
        ItemStack backgroundBlack = BasicGui.createBackground(Colors.BLACK);
        ItemStack backgroundRed = BasicGui.createBackground(Colors.RED);
        ItemStack logsItem = BasicGui.createItem(Material.BOOK_AND_QUILL, glc.getLogsName());
        ItemStack manageServer = BasicGui.createItem(Material.REDSTONE_COMPARATOR, glc.getAdminGuiMainGuiManageServer());

        this.setItem(2, 1, ban, player ->
                new BansGui(AdminGui.this).open(player));

        this.setItem(3, 1, staffAdminMenu, player -> {
            AdminFunGui adminFunGui = new AdminFunGui(AdminGui.this);
            adminFunGui.open(player);
        });

        this.setItem(4, 1, playersGuiItem, playerWhoClicked -> {
            AllPlayersGui playersGui = new AllPlayersGui(AdminGui.this, glc.getPlayersGuiPageName() + ChatColor.BOLD + "" + ChatColor.RED);
            playersGui.setAction(playerFromHead -> {
                PlayerActionGui playerActionGui = new PlayerActionGui(Bukkit.getOfflinePlayer(playerFromHead),
                        playersGui);
                playerActionGui.open(playerWhoClicked);
            });
            playersGui.open(playerWhoClicked);
        });

        this.setItem(5, 1, logsItem, player ->
                new LogsTimeRangeGui(AdminGui.this).open(player));

        this.setItem(6, 1, manageServer,
                player -> new ServerControlGui(AdminGui.this).open(player));

        this.setItem(8, 1, close, HumanEntity::closeInventory);
        this.autoFill(backgroundBlack, backgroundRed);
    }
}
