package watchtowergui.wg.servercontrol.plugincontrol.guis;

import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.engine.basics.ListGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PluginControlGui extends ListGui<Plugin> {
    private final GuiLanguageConfig glc;

    public PluginControlGui(BasicGui previousGui, String title) {
        super(previousGui, title);
        this.setRefreshFunction(() -> Arrays.stream(Bukkit.getPluginManager().getPlugins())
                .sorted(Comparator.comparing(Plugin::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList()));
        this.setAction(plugin -> new SinglePluginGui(plugin, this).open(getLastClicker()));
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
    }

    @Override
    public ItemStack getDescriptionItem(Plugin plugin) {
        return BasicGui.createItem(Material.BOOKSHELF, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + plugin.getName(),
                BasicGui.splitLore(glc.getPluginControlGuiGetDescriptionItemLore(), 25));
    }
}
