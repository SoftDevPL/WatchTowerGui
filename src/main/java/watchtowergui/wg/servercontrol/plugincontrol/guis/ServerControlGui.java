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
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getServerControlGuiGuiTitle(), previousGui);
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        this.init();
    }

    public void init() {
        ItemStack managePluginsItem = BasicGui.createItem(Material.BOOKSHELF,
                glc.getServerControlGuiPluginListName(),
                splitLore(glc.getServerControlGuiPluginListLore(), 25));
        ItemStack manageCommandsItem = BasicGui.createItem(Material.PAPER,
                glc.getServerControlGuiManageCommandsName(),
                splitLore(glc.getServerControlGuiManageCommandsLore(),
                        25));
        ItemStack backgroundRed = BasicGui.createBackground(Colors.RED);
        ItemStack backgroundOrange = BasicGui.createBackground(Colors.ORANGE);
        ItemStack closeItem = BasicGui.createItem(Material.BARRIER, glc.getAdminGuiClose());

        this.setItem(3, 1, manageCommandsItem, player -> new CommandsControlGui(CommandsControlGui.DEFAULT_FILTERS,
                ServerControlGui.this, glc.getServerControlGuiManageCommandsName()).open(player));

        this.setItem(5, 1, managePluginsItem, player ->
                new PluginControlGui(ServerControlGui.this, glc.getServerControlGuiPluginListName()).open(player));


        this.setItem(8, 0, closeItem, HumanEntity::closeInventory);

        if (previousGui != null) {
            ItemStack backItem = BasicGui.createItem(Material.WOOD_DOOR, glc.getAdminGuiBack());
            this.setItem(8, 1, backItem, p -> previousGui.open(p));
        }

        this.autoFill(backgroundOrange, backgroundRed);
    }
}