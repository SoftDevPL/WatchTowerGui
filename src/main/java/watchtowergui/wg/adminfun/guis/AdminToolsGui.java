package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminToolsGui extends BasicGui {

    public static GuiLanguageConfig glc;
    private static ItemStack adminShovel;
    private static ItemStack adminPickaxe;
    private static ItemStack adminSword;
    private static ItemStack adminBow;
    private static ItemStack adminAxe;
    private static ItemStack adminHoe;
    private static ItemStack backItem;
    private static ItemStack closeItem;
    private static ItemStack backGroundBlue;
    public WatchTowerGui plugin;

    public AdminToolsGui(BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getAdminToolsGuiPageName(), previousGui);
        this.plugin = WatchTowerGui.getInstance();
        glc = plugin.configsManager.guiLanguageConfig;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        ItemMeta meta;

        adminShovel = new ItemStack(Material.DIAMOND_SPADE);
        meta = adminShovel.getItemMeta();
        meta.setDisplayName(glc.getAdminToolsGuiAdminShovel());
        meta.addEnchant(Enchantment.DIG_SPEED, 32000, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setUnbreakable(true);
        adminShovel.setItemMeta(meta);

        adminPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        meta = adminPickaxe.getItemMeta();
        meta.setDisplayName(glc.getAdminToolsGuiAdminPickAxe());
        meta.addEnchant(Enchantment.DIG_SPEED, 32000, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setUnbreakable(true);
        adminPickaxe.setItemMeta(meta);

        adminSword = new ItemStack(Material.DIAMOND_SWORD);
        meta = adminSword.getItemMeta();
        meta.setDisplayName(glc.getAdminToolsGuiAdminSword());
        meta.addEnchant(Enchantment.DAMAGE_ALL, 32000, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setUnbreakable(true);
        adminSword.setItemMeta(meta);

        adminBow = new ItemStack(Material.BOW);
        meta = adminBow.getItemMeta();
        meta.setDisplayName(glc.getAdminToolsGuiAdminBow());
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 32000, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setUnbreakable(true);
        adminBow.setItemMeta(meta);

        adminAxe = new ItemStack(Material.DIAMOND_AXE);
        meta = adminAxe.getItemMeta();
        meta.setDisplayName(glc.getAdminToolsGuiAdminAxe());
        meta.addEnchant(Enchantment.DIG_SPEED, 32000, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setUnbreakable(true);
        adminAxe.setItemMeta(meta);

        adminHoe = new ItemStack(Material.DIAMOND_HOE);
        meta = adminHoe.getItemMeta();
        meta.setDisplayName(glc.getAdminToolsGuiAdminHoe());
        meta.addEnchant(Enchantment.KNOCKBACK, 32, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setUnbreakable(true);
        adminHoe.setItemMeta(meta);

        backItem = new ItemStack(Material.ARROW);
        meta = backItem.getItemMeta();
        meta.setDisplayName(glc.getAdminGuiBack());
        backItem.setItemMeta(meta);

        closeItem = new ItemStack(Material.WOOD_DOOR);
        meta = closeItem.getItemMeta();
        meta.setDisplayName(glc.getAdminGuiClose());
        closeItem.setItemMeta(meta);

        backGroundBlue = new ItemStack(Material.STAINED_GLASS_PANE, 1, Colors.BLUE);
        meta = backGroundBlue.getItemMeta();
        meta.setDisplayName(ChatColor.BOLD + "");
        backGroundBlue.setItemMeta(meta);
    }

    protected void init() {
        this.setItem(1, 1, adminAxe, player -> player.getInventory().addItem(adminAxe));
        this.setItem(2, 1, adminPickaxe, player -> player.getInventory().addItem(adminPickaxe));
        this.setItem(3, 1, adminShovel, player -> player.getInventory().addItem(adminShovel));
        this.setItem(4, 1, adminSword, player -> player.getInventory().addItem(adminSword));
        this.setItem(5, 1, adminBow, player -> player.getInventory().addItem(adminBow));
        this.setItem(6, 1, adminHoe, player -> player.getInventory().addItem(adminHoe));

        this.setItem(8, 0, closeItem, HumanEntity::closeInventory);
        if (previousGui != null) {
            this.setItem(8, 1, backItem, player -> {
                if (previousGui != null) {
                    previousGui.open(player);
                }
            });
        }
        this.autoFill(backGroundBlue);
    }
}
