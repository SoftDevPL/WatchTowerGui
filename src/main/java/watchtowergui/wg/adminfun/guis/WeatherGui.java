package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

public class WeatherGui extends BasicGui {

    private static GuiLanguageConfig glc;
    private static ItemStack rainy;
    private static ItemStack clear;
    private static ItemStack thunder;
    private static ItemStack close;
    private static ItemStack back;
    private static ItemStack backGroundBlack;
    private static ItemStack backGroundRed;
    public WatchTowerGui watchTowerGui;

    public WeatherGui(BasicGui previousGui) throws IllegalArgumentException {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getAdminGuiWeatherGuiWeatherGuiPageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        close = BasicGui.createItem(Material.BARRIER, glc.getAdminGuiClose());
        back = BasicGui.createItem(Material.ARROW, glc.getAdminGuiBack());
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        backGroundRed = BasicGui.createBackground(Colors.GREEN);
        rainy = BasicGui.createItem(Material.MAGMA_CREAM, glc.getAdminGuiWeatherGuiRainy());
        clear = BasicGui.createItem(Material.EYE_OF_ENDER, glc.getAdminGuiWeatherGuiSunny());
        thunder = BasicGui.createItem(Material.ENDER_PEARL, glc.getAdminGuiWeatherGuiThunder(), (short) 0);

    }

    protected void init() {
        this.setItem(3, 1, rainy,
                player -> player.performCommand(CommandsManager.getMCCommand("weather") + " rain"));
        this.setItem(4, 1, clear,
                player -> player.performCommand(CommandsManager.getMCCommand("weather") + " clear"));
        this.setItem(5, 1, thunder,
                player -> player.performCommand(CommandsManager.getMCCommand("weather") + " thunder"));
        this.setItem(8, 0, close, HumanEntity::closeInventory);
        this.setItem(8, 2, back, player -> {
            if (previousGui != null) {
                previousGui.open(player);
            }
        });
        this.autoFill(backGroundBlack, backGroundRed);
    }
}
