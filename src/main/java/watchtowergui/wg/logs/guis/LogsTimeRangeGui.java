package watchtowergui.wg.logs.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;

public class LogsTimeRangeGui extends BasicGui {

    private final GuiLanguageConfig glc;

    public LogsTimeRangeGui(BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_logsGui_logsTimeGuiTitle(), previousGui);
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        init();
    }

    public LogsTimeRangeGui() {
        this(null);
    }

    protected void init() {
        ItemStack oneDayItem = createItem(Material.WATCH, glc.getGuiLocale_logsGui_logsTimeOneDay());
        ItemStack multiDayItem = createItem(Material.BEACON, glc.getGuiLocale_logsGui_logsTimeMultiDay());
        ItemStack yellowBackGround = createBackground(Colors.YELLOW);
        ItemStack redBackground = createBackground(Colors.RED);
        ItemStack exit = createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        ItemStack back = createItem(Material.WOOD_DOOR, glc.getGuiLocale_adminGui_back());

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
