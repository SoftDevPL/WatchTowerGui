package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

public class DefaultGamemodeGui extends BasicGui {

    private static GuiLanguageConfig glc;
    private static ItemStack survival;
    private static ItemStack creative;
    private static ItemStack hardcore;
    private static ItemStack spectator;
    private static ItemStack close;
    private static ItemStack back;
    private static ItemStack backGroundGreen;
    private static ItemStack backGroundBlack;
    public WatchTowerGui watchTowerGui;
    private String commandSurvival;
    private String commandCreative;
    private String commandSpectator;
    private String commandHardcore;

    public DefaultGamemodeGui(BasicGui previousGui) throws IllegalArgumentException {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getAdminGuiDefaultGamemodeGuiDefaultGamemodeGuiPageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        setSpecificCommandVersion();
        setupGuiItems();
        init();
    }

    private static String getMinecraftVersion(Server server) {
        String version = server.getVersion();
        int start = version.indexOf("MC: ") + 4;
        int end = version.length() - 1;
        return version.substring(start, end);
    }

    private void setSpecificCommandVersion() {
        this.commandSurvival = versionHigherThan12() ? "survival" : "0";
        this.commandCreative = versionHigherThan12() ? "creative" : "1";
        this.commandSpectator = versionHigherThan12() ? "spectator" : "3";
        this.commandHardcore = versionHigherThan12() ? "adventure" : "2";
    }

    private boolean versionHigherThan12() {
        return Integer.parseInt(getMinecraftVersion(Bukkit.getServer()).split("\\.")[1]) >= 12;
    }

    private void setupGuiItems() {
        close = BasicGui.createItem(Material.BARRIER, glc.getAdminGuiClose());
        back = BasicGui.createItem(Material.ARROW, glc.getAdminGuiBack());
        backGroundGreen = BasicGui.createBackground(Colors.GREEN);
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        survival = BasicGui.createItem(Material.IRON_BLOCK, glc.getAdminGuiDefaultGamemodeGuiSurvival());
        creative = BasicGui.createItem(Material.GOLD_BLOCK, glc.getAdminGuiDefaultGamemodeGuiCreative());
        hardcore = BasicGui.createItem(Material.MOSSY_COBBLESTONE, glc.getAdminGuiDefaultGamemodeGuiHardcore());
        spectator = BasicGui.createItem(Material.DIAMOND_BLOCK, glc.getAdminGuiDefaultGamemodeGuiSpectator());
    }

    protected void init() {
        this.setItem(3, 1, survival,
                player -> player.performCommand(CommandsManager.getMCCommand("defaultgamemode") + " " + this.commandSurvival));
        this.setItem(4, 1, creative,
                player -> player.performCommand(CommandsManager.getMCCommand("defaultgamemode") + " " + this.commandCreative));
        this.setItem(5, 1, hardcore,
                player -> player.performCommand(CommandsManager.getMCCommand("defaultgamemode") + " " + this.commandHardcore));
        this.setItem(2, 1, spectator,
                player -> player.performCommand(CommandsManager.getMCCommand("defaultgamemode") + " " + this.commandSpectator));
        this.setItem(8, 0, close, HumanEntity::closeInventory);
        this.setItem(8, 2, back, player -> {
            if (previousGui != null) {
                previousGui.open(player);
            }
        });
        this.autoFill(backGroundGreen, backGroundBlack);
    }
}
