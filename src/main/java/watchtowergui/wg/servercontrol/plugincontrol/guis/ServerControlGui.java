package watchtowergui.wg.servercontrol.plugincontrol.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.servercontrol.commandcontrol.guis.CommandsControlGui;

public class ServerControlGui extends BasicGui {

    GuiLanguageConfig glc;

    public ServerControlGui(BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_serverControlGui_guiTitle(), previousGui);
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        this.init();
    }

    public void init() {
        ItemStack managePluginsItem = BasicGui.createItem(Material.BOOKSHELF,
                glc.getGuiLocale_serverControlGui_pluginListName(),
                splitLore(glc.getGuiLocale_serverControlGui_pluginListLore(), 25));
        ItemStack manageCommandsItem = BasicGui.createItem(Material.PAPER,
                glc.getGuiLocale_serverControlGui_manageCommandsName(),
                splitLore(glc.getGuiLocale_serverControlGui_manageCommandsLore(),
                        25));
        ItemStack backgroundRed = BasicGui.createBackground(Colors.RED);
        ItemStack backgroundOrange = BasicGui.createBackground(Colors.ORANGE);
        ItemStack closeItem = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());

        this.setItem(3, 1, manageCommandsItem, player -> new CommandsControlGui(CommandsControlGui.DEFAULT_FILTERS,
                ServerControlGui.this, glc.getGuiLocale_serverControlGui_manageCommandsName()).open(player));

        this.setItem(5, 1, managePluginsItem, player ->
                new PluginControlGui(ServerControlGui.this, glc.getGuiLocale_serverControlGui_pluginListName()).open(player));


        this.setItem(8, 0, closeItem, HumanEntity::closeInventory);

        if (previousGui != null) {
            ItemStack backItem = BasicGui.createItem(Material.WOOD_DOOR, glc.getGuiLocale_adminGui_back());
            this.setItem(8, 1, backItem, p -> previousGui.open(p));
        }

        this.autoFill(backgroundOrange, backgroundRed);
    }
}