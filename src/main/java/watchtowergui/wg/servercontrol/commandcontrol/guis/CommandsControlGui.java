package watchtowergui.wg.servercontrol.commandcontrol.guis;

import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.engine.basics.ListGui;
import ad.guis.ultimateguis.engine.interfaces.RefreshFunction;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CommandsControlGui extends ListGui<Command> {

    public final static int ACTIVE_COMMANDS = 0b1;
    public final static int DISABLE_COMMANDS = 0b10;
    public final static int ALPHABETIC_ORDER = 0b100;
    public final static int PLUGIN_ORDER = 0b1000;
    public final static int VANILLA_COMMANDS = 0b10000;
    public final static int PLUGINS_COMMANDS = 0b100000;
    public final static int DEFAULT_FILTERS = 0b100111;
    private final CommandsControlListener commandsControlListener;
    private final GuiLanguageConfig glc;

    private int filters;
    private ItemStack activeCommandsFilterItem;
    private ItemStack disabledCommandsFilterItem;
    private ItemStack alphabeticOrderFilterItem;
    private ItemStack pluginOrderFilterItem;
    private ItemStack vanillaCommandsFilterItem;
    private ItemStack pluginCommandsFilterItem;

    public CommandsControlGui(String title) {
        this(DEFAULT_FILTERS, null, title);
    }

    public CommandsControlGui(int filters) {
        this(filters, null);
    }

    public CommandsControlGui(int filters, BasicGui previousGui) {
        this(filters, previousGui, null);
    }

    public CommandsControlGui(int filters, BasicGui previousGui, String title) {
        super(previousGui, title);
        this.setAction(this::commandAction);
        super.setRefreshFunction(this::refreshFunction);
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        this.filters = filters;
        this.commandsControlListener = WatchTowerGui.getInstance().commandsControlListener;
        this.initFilterItems();
        this.setFiltersItems();
    }

    public static void sortCommands(@NotNull List<Command> list) {
        list.sort(Comparator.comparing(Command::getName));
    }

    @Override
    public void setRefreshFunction(final RefreshFunction<Command> refreshFunction) {
        super.setRefreshFunction(() -> applyFilters(refreshFunction.getList(), true));
    }

    private void commandAction(Command cmd) {
        new SingleCommandGui(cmd, this).open(this.getLastClicker());
    }

    private void setFilters(int filters) {
        this.filters = filters;
    }

    private void addFilters(int filters) {
        this.filters |= filters;
    }

    private void removeFilters(int filters) {
        this.filters &= ~filters;
    }

    private void switchFilters(int filters) {
        this.filters ^= filters;
    }

    private boolean hasFilters(int filters) {
        return (this.filters & filters) == filters;
    }

    private List<Command> applyFilters(Collection<? extends Command> list, boolean activityFilters) {
        Stream<? extends Command> stream = list.parallelStream();
        stream = vanillaCommandsFilter(stream);
        stream = pluginCommandsFilter(stream);
        stream = alphabeticOrderFilter(stream);
        stream = pluginOrderFilter(stream);
        if (activityFilters) {
            stream = activeCommandsFilter(stream);
            stream = disabledCommandsFilter(stream);
        }
        return stream.collect(Collectors.toList());
    }

    private Stream<? extends Command> activeCommandsFilter(Stream<? extends Command> stream) {
        if (hasFilters(ACTIVE_COMMANDS)) return stream;
        return stream.filter(command -> !commandsControlListener.isActive(command));
    }

    private Stream<? extends Command> disabledCommandsFilter(Stream<? extends Command> stream) {
        if (hasFilters(DISABLE_COMMANDS)) return stream;
        return stream.filter(command -> !commandsControlListener.isDisable(command));
    }

    private Stream<? extends Command> pluginOrderFilter(Stream<? extends Command> stream) {
        if (!hasFilters(PLUGIN_ORDER)) return stream;
        return stream.sorted((o1, o2) -> {
            boolean isPlugin1 = o1 instanceof PluginIdentifiableCommand;
            boolean isPlugin2 = o2 instanceof PluginIdentifiableCommand;
            if (!(isPlugin1 || isPlugin2)) return 0;
            if (!isPlugin2) return 1;
            if (!isPlugin1) return -1;
            String plugin1 = ((PluginIdentifiableCommand) o1).getPlugin().getName();
            String plugin2 = ((PluginIdentifiableCommand) o2).getPlugin().getName();
            return plugin1.compareToIgnoreCase(plugin2);
        });
    }

    private Stream<? extends Command> alphabeticOrderFilter(Stream<? extends Command> stream) {
        if (!hasFilters(ALPHABETIC_ORDER)) return stream;
        return stream.sorted(Comparator.comparing(Command::getName, String.CASE_INSENSITIVE_ORDER));
    }

    private Stream<? extends Command> vanillaCommandsFilter(Stream<? extends Command> stream) {
        if (hasFilters(VANILLA_COMMANDS)) return stream;
        return stream.filter(command -> command instanceof PluginIdentifiableCommand);
    }

    private Stream<? extends Command> pluginCommandsFilter(Stream<? extends Command> stream) {
        if (hasFilters(PLUGINS_COMMANDS)) return stream;
        return stream.filter(command -> !(command instanceof PluginIdentifiableCommand));
    }

    public ItemStack setLore(ItemStack item, boolean onOff) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>(1);
        if (onOff)
            lore.add(ChatColor.RESET + glc.getCommandControlGuiFilterOn());
        else
            lore.add(ChatColor.RESET + glc.getCommandControlGuiFilterOff());
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }


    private void setFiltersItems() {
        this.setActionItem(setLore(activeCommandsFilterItem, hasFilters(ACTIVE_COMMANDS)),
                player -> {
                    switchFilters(ACTIVE_COMMANDS);
                    this.open(player);
                }, 0);

        this.setActionItem(setLore(disabledCommandsFilterItem, hasFilters(DISABLE_COMMANDS)), player -> {
            switchFilters(DISABLE_COMMANDS);
            this.open(player);
        }, 1);

        this.setActionItem(setLore(alphabeticOrderFilterItem, hasFilters(ALPHABETIC_ORDER)), player -> {
            switchFilters(ALPHABETIC_ORDER);
            this.open(player);
        }, 2);

        this.setActionItem(setLore(pluginOrderFilterItem, hasFilters(PLUGIN_ORDER)), player -> {
            switchFilters(PLUGIN_ORDER);
            this.open(player);
        }, 4);

        this.setActionItem(setLore(pluginCommandsFilterItem, hasFilters(PLUGINS_COMMANDS)), player -> {
            switchFilters(PLUGINS_COMMANDS);
            this.open(player);
        }, 5);

        this.setActionItem(setLore(vanillaCommandsFilterItem, hasFilters(VANILLA_COMMANDS)), player -> {
            switchFilters(VANILLA_COMMANDS);
            this.open(player);
        }, 6);
    }


    private void initFilterItems() {
        activeCommandsFilterItem = BasicGui.createItem(Material.REDSTONE_TORCH_ON, glc.getCommandControlGuiActiveCommandsFilterItem());
        disabledCommandsFilterItem = BasicGui.createItem(Material.LEVER, glc.getCommandControlGuiDisabledCommandsFilterItem());
        alphabeticOrderFilterItem = BasicGui.createItem(Material.BOOK, glc.getCommandControlGuiAlphabeticOrderFilterItem());
        pluginOrderFilterItem = BasicGui.createItem(Material.BOOKSHELF, glc.getCommandControlGuiPluginOrderFilterItem());
        vanillaCommandsFilterItem = BasicGui.createItem(Material.EGG, glc.getCommandControlGuiVanillaCommandsFilterItem());
        pluginCommandsFilterItem = BasicGui.createItem(Material.DRAGON_EGG, glc.getCommandControlGuiPluginCommandsFilterItem());

    }

    private List<String> getUsage(Command cmd) {
        return BasicGui.splitLore(glc.getCommandControlGuiGetUsage(cmd.getUsage()), 20);
    }

    private String getLabel(Command cmd) {
        return glc.getCommandControlGuiGetLabel(cmd.getLabel());
    }

    private String getStatus(Command cmd) {
        if (commandsControlListener.isActive(cmd)) {
            return glc.getCommandControlGuiStatusOn();
        }
        return glc.getCommandControlGuiStatusOff();
    }

    private List<String> getAliases(Command cmd) {
        List<String> aliases = cmd.getAliases();
        if (!aliases.isEmpty()) {
            List<String> aliasesStrings = new ArrayList<>();
            aliasesStrings.add(glc.getCommandControlGuiGetAliases());
            for (String alias : aliases)
                aliasesStrings.add(ChatColor.GOLD + alias);
            return aliasesStrings;

        }
        return new ArrayList<>();
    }

    @Nullable
    private String getPluginName(Command cmd) {
        if (cmd instanceof PluginIdentifiableCommand) {
            PluginIdentifiableCommand idn = (PluginIdentifiableCommand) cmd;
            return glc.getCommandControlGuiGetPlugin(idn.getPlugin().getName());
        }
        return null;
    }

    private String getEditLabel() {
        return glc.getCommandControlGuiGetEditLabel();
    }

    @Override
    public ItemStack getDescriptionItem(Command cmd) {
        ItemStack item = new ItemStack(Material.PAPER);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + cmd.getName());

        ArrayList<String> lore = new ArrayList<>(getUsage(cmd));
        lore.add(getLabel(cmd));
        lore.add(getStatus(cmd));
        lore.addAll(getAliases(cmd));
        String pluginName = getPluginName(cmd);
        if (pluginName != null) lore.add(getPluginName(cmd));
        lore.add(getEditLabel());
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public List<Command> refreshFunction() {
        List<Command> commands;
        if (this.hasFilters(ACTIVE_COMMANDS) && this.hasFilters(DISABLE_COMMANDS)) {
            commands = applyFilters(commandsControlListener.getAllCommands(), false);
        } else if (this.hasFilters(ACTIVE_COMMANDS)) {
            commands = applyFilters(new ArrayList<>(commandsControlListener.getActiveCommandsSet()), false);
        } else if (this.hasFilters(DISABLE_COMMANDS)) {
            commands = applyFilters(new ArrayList<>(commandsControlListener.getDisabledCommandsSet()), false);
        } else {
            commands = new ArrayList<>();
        }
        return commands;
    }

    @Override
    public void open(Player player) {
        this.setFiltersItems();
        super.open(player);
    }
}