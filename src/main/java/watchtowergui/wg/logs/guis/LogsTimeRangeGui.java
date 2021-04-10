package watchtowergui.wg.logs.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

public class LogsTimeRangeGui extends BasicGui {

    private final GuiLanguageConfig glc;

    public LogsTimeRangeGui(BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getLogsTimeGuiTitle(), previousGui);
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        init();
    }

    public LogsTimeRangeGui() {
        this(null);
    }

    protected void init() {
        ItemStack oneDayItem = createItem(Material.WATCH, glc.getLogsTimeOneDay());
        ItemStack multiDayItem = createItem(Material.BEACON, glc.getLogsTimeMultiDay());
        ItemStack yellowBackGround = createBackground(Colors.YELLOW);
        ItemStack redBackground = createBackground(Colors.RED);
        ItemStack exit = createItem(Material.BARRIER, glc.getAdminGuiClose());
        ItemStack back = createItem(Material.WOOD_DOOR, glc.getAdminGuiBack());

        this.setItem(5, 1, oneDayItem, player -> {
            new LogsGui(LogsGui.ONE_DAY, LogsTimeRangeGui.this).open(player);
        });

        this.setItem(2, 1, multiDayItem, player -> {
            new LogsGui(LogsGui.MULTI_DAY, LogsTimeRangeGui.this).open(player);
        });

        this.setItem(7, 1, back, player -> {
            if (previousGui != null) previousGui.open(player);
        });
        this.setItem(8, 1, exit, HumanEntity::closeInventory);

        this.autoFill(redBackground, yellowBackGround);
    }
}
