package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

public class DifficultyGui extends BasicGui {

    private static GuiLanguageConfig glc;
    private static ItemStack peaceful;
    private static ItemStack easy;
    private static ItemStack medium;
    private static ItemStack hard;
    private static ItemStack close;
    private static ItemStack back;
    private static ItemStack backGroundPurple;
    private static ItemStack backGroundBlack;
    public WatchTowerGui watchTowerGui;

    public DifficultyGui(BasicGui previousGui) throws IllegalArgumentException {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_adminGuiDifficulty_guiDifficultyGuiPageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        close = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        back = BasicGui.createItem(Material.ARROW, glc.getGuiLocale_adminGui_back());
        backGroundPurple = BasicGui.createBackground(Colors.PURPLE);
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        peaceful = BasicGui.createItem(Material.PUMPKIN, glc.getGuiLocale_adminGuiDifficulty_peaceful());
        easy = BasicGui.createItem(Material.NETHER_BRICK, glc.getGuiLocale_adminGuiDifficulty_easy());
        medium = BasicGui.createItem(Material.SOUL_SAND, glc.getGuiLocale_adminGuiDifficulty_medium());
        hard = BasicGui.createItem(Material.BEDROCK, glc.getGuiLocale_adminGuiDifficulty_hard());
    }

    protected void init() {
        this.setItem(3, 1, peaceful,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("difficulty") + " peaceful"));
        this.setItem(4, 1, easy,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("difficulty") + " easy"));
        this.setItem(5, 1, medium,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("difficulty") + " normal"));
        this.setItem(2, 1, hard,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("difficulty") + " hard"));

        this.setItem(8, 0, close, HumanEntity::closeInventory);
        this.setItem(8, 2, back, player -> {
            if (previousGui != null) {
                previousGui.open(player);
            }
        });
        this.autoFill(backGroundPurple, backGroundBlack);
    }
}
