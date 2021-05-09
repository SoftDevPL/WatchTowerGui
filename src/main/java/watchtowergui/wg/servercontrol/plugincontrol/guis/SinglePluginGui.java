package watchtowergui.wg.servercontrol.plugincontrol.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.servercontrol.commandcontrol.guis.CommandsControlGui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SinglePluginGui extends BasicGui {
    private final Plugin plugin;
    private final GuiLanguageConfig glc;
    private ItemStack backgroundBlue;
    private ItemStack backItem;
    private ItemStack closeItem;
    private List<Command> pluginCommands;

    public SinglePluginGui(Plugin plugin, BasicGui previousGui) {
        super(3, plugin.getName(), previousGui);
        this.plugin = plugin;
        this.glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        this.initPassiveItems();
        this.init();
    }

    private void initPassiveItems() {
        backgroundBlue = BasicGui.createBackground(Colors.LIGHT_BLUE);
        backItem = BasicGui.createItem(Material.WOOD_DOOR, glc.getGuiLocale_adminGui_back());
        closeItem = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
    }

    private ItemStack createPluginNameItem() {
        return BasicGui.createItem(Material.BOOKSHELF,
                ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + plugin.getName(),
                BasicGui.splitLore(glc.getSinglePluginGuiCreatePluginNameItemVersion(plugin.getDescription().getVersion()), 25));
    }

    private ItemStack createPluginDescriptionItem() {
        String description = plugin.getDescription().getDescription();
        return BasicGui.createItem(Material.PAPER, glc.getGuiLocale_singlePluginGui_createPluginDescriptionItemDescription(),
                BasicGui.splitLore(((description == null || description.isEmpty()) ? glc.getGuiLocale_singlePluginGui_createPluginDescriptionItemNotSpecified() : glc.getSinglePluginGuiCreatePluginDescriptionItemLore(description)), 25));
    }

    private ItemStack createAuthorsItem() {
        List<String> authors = plugin.getDescription().getAuthors();
        List<String> coloredAuthors = new ArrayList<>(authors.size());
        authors.forEach(author -> coloredAuthors.add(glc.getSinglePluginGuiCreateAuthorsItemLore(author)));
        return BasicGui.createItem(Material.DIAMOND_PICKAXE, glc.getGuiLocale_singlePluginGui_createAuthorsItemAuthors(),
                (coloredAuthors.isEmpty()) ? splitLore(glc.getGuiLocale_singlePluginGui_createAuthorsItemNotSpecified(), 25) : coloredAuthors);
    }

    private ItemStack createWebsiteItem() {
        String website = plugin.getDescription().getWebsite();
        return BasicGui.createItem(Material.EMPTY_MAP, glc.getGuiLocale_singlePluginGui_createWebsiteItemWebsite(),
                (website == null || website.isEmpty()) ? splitLore(glc.getGuiLocale_singlePluginGui_createWebsiteItemNotSpecified(), 25)
                        : splitLore(glc.getSinglePluginGuiCreateWebsiteItemLore(website), 25));
    }

    private ItemStack createPluginCommandsItem() {
        pluginCommands = WatchTowerGui.getInstance().commandsControlListener.getAllCommands().parallelStream()
                .filter(command -> command instanceof PluginIdentifiableCommand &&
                        ((PluginIdentifiableCommand) command).getPlugin().getName().equals(plugin.getName()))
                .collect(Collectors.toList());

        return BasicGui.createItem(Material.BOOK, glc.getGuiLocale_singlePluginGui_createPluginCommandsItemName(),
                splitLore(!pluginCommands.isEmpty() ? glc.getGuiLocale_singlePluginGui_createPluginCommandsItemCommandsLore()
                        : glc.getGuiLocale_singlePluginGui_createPluginCommandsItemNoCommandsLore(), 25));
    }

    private ItemStack createDependItem() {
        List<String> dependencies = plugin.getDescription().getDepend();
        List<String> softDependencies = plugin.getDescription().getSoftDepend();
        List<String> coloredDependencies = new ArrayList<>(dependencies.size());
        List<String> coloredSoftDependencies = new ArrayList<>(softDependencies.size());
        dependencies.forEach(dep -> coloredDependencies.add(ChatColor.GREEN + dep));
        softDependencies.forEach(sDep -> coloredSoftDependencies.add(ChatColor.DARK_GREEN + sDep));

        List<String> loreList = new ArrayList<>(coloredDependencies.size() + coloredSoftDependencies.size() + 1);
        loreList.addAll(coloredDependencies);
        loreList.add(glc.getGuiLocale_singlePluginGui_createDependItemLore());
        loreList.addAll(coloredSoftDependencies);

        return BasicGui.createItem(Material.COMPASS, glc.getGuiLocale_singlePluginGui_createDependItemName(), loreList);
    }

    public void init() {
        ItemStack pluginNameItem = createPluginNameItem();
        ItemStack pluginDescriptionItem = createPluginDescriptionItem();
        ItemStack pluginAuthorsItem = createAuthorsItem();
        ItemStack pluginWebsiteItem = createWebsiteItem();
        ItemStack pluginDependenciesItem = createDependItem();
        ItemStack pluginCommandsItem = createPluginCommandsItem();

        this.setItem(2, 0, pluginNameItem, null);
        this.setItem(4, 0, pluginDescriptionItem, null);
        this.setItem(0, 1, pluginWebsiteItem, null);
        this.setItem(6, 1, pluginCommandsItem, (!pluginCommands.isEmpty()) ? p -> {
            CommandsControlGui commandsControlGui = new CommandsControlGui(CommandsControlGui.DEFAULT_FILTERS, this,
                    glc.getCommandControlGuiPageName(plugin.getName()));
            commandsControlGui.setRefreshFunction(() -> pluginCommands);
            commandsControlGui.open(p);
        } : null);
        this.setItem(2, 2, pluginDependenciesItem, null);
        this.setItem(4, 2, pluginAuthorsItem, null);

        this.setItem(8, 0, closeItem, HumanEntity::closeInventory);
        if (previousGui != null) {
            this.setItem(8, 1, backItem, p -> {
                if (previousGui != null)
                    previousGui.open(p);
            });
        }
        this.autoFill(backgroundBlue);
    }

    @Override
    public void open(Player opener) {
        init();
        super.open(opener);
    }
}