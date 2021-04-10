package watchtowergui.wg.servercontrol.commandcontrol;

import ad.guis.ultimateguis.engine.Pair;
import ad.guis.ultimateguis.engine.interfaces.BasicAction;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.databasescommands.AdminGuiDatabase;
import watchtowergui.wg.servercontrol.commandcontrol.events.*;
import watchtowergui.wg.servercontrol.commandcontrol.utilities.CommandIdentifier;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CommandsControlListener implements Listener {

    private final Map<Command, String> prefixMap = new HashMap<>();
    private final Set<Command> disableCommands = new HashSet<>();
    private final Set<CommandIdentifier> unchangeableCommands = new HashSet<>();
    private CommandMap commandMap;
    private Map<String, Command> activeCommands = new HashMap<>();
    private AdminGuiDatabase database;
    private GuiLanguageConfig glc;

    public void init() {
        if (!initCommandsContainers()) return;
        Bukkit.getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
        initUndisabableCommands();
        if (WatchTowerGui.getInstance().SQLmanager != null && WatchTowerGui.getInstance().SQLmanager.database != null)
            this.database = WatchTowerGui.getInstance().SQLmanager.database;
        try {
            glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        } catch (NullPointerException ignored) {
        }
        Bukkit.getScheduler().runTask(WatchTowerGui.getInstance(), this::loadCommandsChangesFromDatabase);
    }

    public void resetAllCommands() {
        this.database.clearAllCommandsTables();
    }


    private void showError(final CommandIdentifier id) {
        Bukkit.getConsoleSender().sendMessage(glc.getCommandControlListenerShowError(id.toString()));
    }

    private void loadCommandsChangesFromDatabase() {
        loadRemovedAliases();

        List<Pair<String, String>> labels = this.database.getCommandLabels();
        List<CommandIdentifier> disabledCommands = this.loadDisableCommandsFromDatabase();
        List<Pair<CommandIdentifier, String>> originalLabels = new ArrayList<>(labels.size());
        List<Pair<CommandIdentifier, String>> validLabels =
                labels.stream().filter(getIdentifiersFilter(this.database::deleteCommandIdentifiersLabel))
                        .map(this::pairConverter)
                        .filter(pair -> {
                            Command cmd = this.getCommand(pair.getFirsValue());
                            if (cmd == null) {
                                this.database.deleteCommandIdentifiersLabel(pair.getFirsValue().getNameWithPrefix());
                                return false;
                            }
                            if (cmd.getLabel().equalsIgnoreCase(pair.getSecondValue())) {
                                this.database.deleteCommandIdentifiersLabel(pair.getFirsValue().getNameWithPrefix());
                                return false;
                            }
                            originalLabels.add(new Pair<>(pair.getFirsValue(), cmd.getLabel()));
                            this.disableCommand(pair.getFirsValue());
                            return true;
                        }).collect(Collectors.toList());


        validLabels.forEach(pair -> {
            if (!this.changeLabel(pair.getFirsValue(), pair.getSecondValue()).getFirsValue()) {
                showError(pair.getFirsValue());
            }
        });

        validLabels.removeIf(pair -> {
            if (disabledCommands.contains(pair.getFirsValue())) {
                disabledCommands.remove(pair.getFirsValue());
                return true;
            }
            return false;
        });

        disabledCommands.forEach(id -> {
            if (!this.disableCommand(id)) {
                this.database.deleteCommandIdentifiers(id.getNameWithPrefix());
            }
        });

        validLabels.forEach(pair -> {
            if (this.enableCommand(pair.getFirsValue()).getFirsValue()) return;
            String originalLabel = originalLabels.stream().filter(pair2 -> pair2.getFirsValue()
                    .equals(pair.getFirsValue())).findAny()
                    .orElse(new Pair<>(null, null)).getSecondValue();
            if (originalLabel == null) {
                showError(pair.getFirsValue());
                return;
            }
            if (!this.changeLabel(pair.getFirsValue(), originalLabel).getFirsValue()) {
                showError(pair.getFirsValue());
                return;
            }
            if (!this.enableCommand(pair.getFirsValue()).getFirsValue()) {
                showError(pair.getFirsValue());
                return;
            }
            Bukkit.getConsoleSender().sendMessage(glc.getCommandControlListenerNewCommandAlias(pair.getSecondValue(), pair.getFirsValue().getNameWithPrefix()));
        });

        loadAddedAliases();
    }

    private Pair<CommandIdentifier, String> originalLabelMapper(Pair<CommandIdentifier, String> command) {
        return new Pair<>(command.getFirsValue(), this.getCommand(command.getFirsValue()).getLabel());
    }

    private Pair<CommandIdentifier, String> pairConverter(Pair<String, String> pair) {
        return new Pair<>(new CommandIdentifier(pair.getFirsValue()), pair.getSecondValue());
    }

    private Predicate<Pair<String, String>> getIdentifiersFilter(final BasicAction<String> filterFailedAction) {
        return s -> {
            if (!s.getFirsValue().contains(":")) {
                filterFailedAction.action(s.getFirsValue());
                return false;
            }
            return true;
        };
    }

    private void loadAddedAliases() {
        this.database.getCommandAddedAliases().stream()
                .filter(getIdentifiersFilter(this.database::deleteCommandIdentifiersAddedName))
                .map(this::pairConverter)
                .forEach(pair -> {
                    if (!this.addAlias(pair.getFirsValue(), pair.getSecondValue()).getFirsValue()) {
                        this.database.deleteCommandIdentifiersAddedName(pair.getFirsValue().getNameWithPrefix());
                        Bukkit.getConsoleSender().sendMessage(
                                glc.getCommandControlListenerLoadAddedAliases(pair.getSecondValue(), pair.getFirsValue().getNameWithPrefix()));
                    }
                });
    }

    private void loadRemovedAliases() {
        this.database.getCommandRemovedAliases().stream()
                .filter(getIdentifiersFilter(this.database::deleteCommandIdentifiersRemovedName))
                .forEach(pair -> {
                    if (!this.removeAlias(new CommandIdentifier(pair.getFirsValue()), pair.getSecondValue())) {
                        this.database.deleteCommandIdentifiersRemovedName(pair.getFirsValue());
                    }
                });
    }

    private List<CommandIdentifier> loadDisableCommandsFromDatabase() {
        return this.database.getCommandIdentifiers().stream()
                .filter(stringId -> {
                    if (!stringId.contains(":")) {
                        this.database.deleteCommandIdentifiers(stringId);
                        return false;
                    }
                    return true;
                }).map(CommandIdentifier::new)
                .filter(id -> {
                    if (!this.isCommandExist(id)) {
                        this.removeDisableCommandFromDatabase(id);
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }

    private void initUndisabableCommands() {
        unchangeableCommands.add(new CommandIdentifier("reload", "bukkit"));
        unchangeableCommands.add(new CommandIdentifier("ad", WatchTowerGui.getInstance().getName().toLowerCase()));
        unchangeableCommands.add(new CommandIdentifier("resetallcommands", WatchTowerGui.getInstance().getName().toLowerCase()));
    }

    @SuppressWarnings("unchecked")
    private boolean initCommandsContainers() {
        try {
            Field mapField = findUnderlying(Bukkit.getServer().getClass(), "commandMap");
            mapField.setAccessible(true);
            commandMap = (CommandMap) mapField.get(Bukkit.getServer());
            Field knownCommandField = findUnderlying(commandMap.getClass(), "knownCommands");
            knownCommandField.setAccessible(true);
            activeCommands = (Map<String, Command>) knownCommandField.get(commandMap);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot launch commands editor, please send us a feedback");
            return false;
        }
    }

    private Field findUnderlying(Class<?> clazz, String fieldName) {
        Class<?> current = clazz;
        do {
            try {
                return current.getDeclaredField(fieldName);
            } catch (Exception ignored) {
            }
        } while ((current = current.getSuperclass()) != null);
        return null;
    }

    public void removeActiveCommandsByPlugin(Plugin plugin) {
        this.activeCommands.entrySet().removeIf(entry -> entry.getValue() instanceof PluginIdentifiableCommand &&
                ((PluginIdentifiableCommand) entry.getValue()).getPlugin().equals(plugin));
    }

    public void removeActiveCommandsByPlugin(String pluginName) {
        this.activeCommands.entrySet().removeIf(entry -> entry.getValue() instanceof PluginIdentifiableCommand &&
                ((PluginIdentifiableCommand) entry.getValue()).getPlugin().getName().equals(pluginName));
    }

    public void removeDisabledCommandsByPlugin(Plugin plugin) {
        this.disableCommands.removeIf(command -> command instanceof PluginIdentifiableCommand &&
                ((PluginIdentifiableCommand) command).getPlugin().equals(plugin));
    }

    public void removeDisabledCommandsByPlugin(String pluginName) {
        this.disableCommands.removeIf(command -> command instanceof PluginIdentifiableCommand &&
                ((PluginIdentifiableCommand) command).getPlugin().getName().equals(pluginName));
    }

    public void removeCommandsByPlugin(String pluginName) {
        this.removeDisabledCommandsByPlugin(pluginName);
        this.removeActiveCommandsByPlugin(pluginName);
    }

    public void removeCommandsByPlugin(Plugin plugin) {
        this.removeDisabledCommandsByPlugin(plugin);
        this.removeActiveCommandsByPlugin(plugin);
    }


    public String getMainADCommandLabel(String name) {
        return getCommandLabel(new CommandIdentifier(name, WatchTowerGui.getInstance().getName().toLowerCase()));
    }

    public String getCommandLabel(String nameWithPrefix) {
        return getCommandLabel(new CommandIdentifier(nameWithPrefix));
    }

    public String getCommandLabel(final CommandIdentifier id) {
        Command cmd = this.getCommand(id);
        return (cmd == null) ? "" : cmd.getLabel();
    }

    public Set<Command> getActiveCommandsSet() {
        return new HashSet<>(this.activeCommands.values());
    }

    public Set<String> getActiveLabels() {
        return this.activeCommands.keySet();
    }

    public List<Command> getAllCommands() {
        List<Command> allCommand = new ArrayList<>(getDisabledCommandsSet());
        allCommand.addAll(getActiveCommandsSet());
        return allCommand;
    }

    public Set<Command> getAllCommandsSet() {
        HashSet<Command> allCommands = new HashSet<>(getDisabledCommandsSet());
        allCommands.addAll(getActiveCommandsSet());
        return allCommands;
    }

    public Command getCommand(final CommandIdentifier identifier) {
        return activeCommands.values().stream()
                .filter(cmd -> identifier.equals(new CommandIdentifier(cmd)))
                .findAny().orElse(disableCommands.stream()
                        .filter(cmd -> identifier.equals(new CommandIdentifier(cmd)))
                        .findAny().orElse(null));
    }

    public boolean isCommandExist(final CommandIdentifier id) {
        return this.activeCommands.values().stream().map(CommandIdentifier::new).anyMatch(id::equals)
                || this.disableCommands.stream().map(CommandIdentifier::new).anyMatch(id::equals);
    }

    public Set<Command> getDisabledCommandsSet() {
        return this.disableCommands;
    }

    //by label or alias
    public Set<Command> getDisableCommandsByLabelOrAlias(final String label) {
        final String lowerLabel = label.toLowerCase();
        return disableCommands.parallelStream().filter(command -> command.getLabel().equals(lowerLabel) ||
                command.getAliases().contains(lowerLabel)).collect(Collectors.toSet());
    }

    public Command getDisableCommandByAnything(final String label) {
        final String lowLabel = label.toLowerCase();
        return this.disableCommands.parallelStream()
                .filter(cmd -> cmd.getName().equals(lowLabel)).findAny()
                .orElse(this.disableCommands.parallelStream()
                        .filter(cmd -> cmd.getLabel().equals(lowLabel))
                        .findAny().orElse(this.disableCommands.parallelStream()
                                .filter(cmd -> cmd.getAliases().contains(lowLabel))
                                .findAny().orElse(null)));
    }

    public Set<String> getDisableCommandsPhrases() {
        Set<String> phraseList = new HashSet<>();
        this.disableCommands.forEach(cmd -> {
                    phraseList.add(cmd.getName());
                    phraseList.addAll(cmd.getAliases());
                    phraseList.add(cmd.getLabel());
                }
        );
        return phraseList;
    }

    public Set<Command> getDisableCommandsByName(String name) {
        final String lowerName = name.toLowerCase();
        return disableCommands.parallelStream().filter(command ->
                command.getName().equalsIgnoreCase(lowerName)).collect(Collectors.toSet());
    }

    public Command getDisabledCommand(final CommandIdentifier identifier) {
        return this.disableCommands.stream().filter(command ->
                identifier.equals(new CommandIdentifier(command))).findAny().orElse(null);
    }

    public Command getActiveCommand(String activeLabel) {
        return this.activeCommands.get(activeLabel.toLowerCase());
    }

    public Set<Command> getActiveCommandsByName(String name) {
        return this.activeCommands.values().stream()
                .filter(command -> command.getName().equalsIgnoreCase(name)).collect(Collectors.toSet());
    }

    public Command getActiveCommand(final CommandIdentifier identifier) {
        return this.activeCommands.values().stream().filter(command ->
                identifier.equals(new CommandIdentifier(command))).findAny().orElse(null);
    }

    public synchronized String getCommandPrefix(final Command command) {
        AtomicReference<String> prefix = new AtomicReference<>(this.prefixMap.get(command));
        if (prefix.get() != null) return prefix.get();

        activeCommands.entrySet().parallelStream()
                .filter(stringCommandEntry -> command.equals(stringCommandEntry.getValue()))
                .map(Map.Entry::getKey)
                .filter(s -> s.contains(":"))
                .findAny().ifPresent(requestPrefix -> {
            prefix.set(requestPrefix.split(":")[0]);
            prefixMap.put(command, prefix.get());
        });
        return prefix.get();
    }

    private boolean disableCommand(final Command command) {
        if (unchangeableCommands.contains(new CommandIdentifier(command))) return false;

        List<Map.Entry<String, Command>> commandLabels = this.activeCommands.entrySet().parallelStream()
                .filter(entry -> command.equals(entry.getValue())).collect(Collectors.toList());

        return this.disableCommand(commandLabels);
    }

    private boolean disableCommand(final CommandIdentifier identifier) {
        if (unchangeableCommands.contains(identifier)) return false;

        List<Map.Entry<String, Command>> commandLabels = this.activeCommands.entrySet().stream().filter(entry ->
                identifier.equals(new CommandIdentifier(entry.getValue()))).collect(Collectors.toList());

        return this.disableCommand(commandLabels);
    }

    private boolean disableCommand(final List<Map.Entry<String, Command>> commandLabels) {
        if (commandLabels.isEmpty()) return false;
        this.activeCommands.entrySet().removeAll(commandLabels);
        this.disableCommands.addAll(commandLabels.parallelStream().map(Map.Entry::getValue).collect(Collectors.toList()));
        return true;
    }

    private String withPrefix(String prefix, String alias) {
        return prefix + ":" + alias;
    }


    private Pair<Boolean, String> enableCommand(final CommandIdentifier identifier) {
        Command command = getDisabledCommand(identifier);
        if (command == null)
            return new Pair<>(false, glc.getCommandControlListenerEnableCommandNotExists(identifier.getNameWithPrefix()));
        return enableCommand(command);
    }

    private Pair<Boolean, String> enableCommand(final Command command) {
        if (this.activeCommands.containsValue(command)) {
            return new Pair<>(false, glc.getCommandControlListenerEnableCommandCommandAlreadyExists());
        }
        String prefix = this.getCommandPrefix(command);

        StringBuilder commentBuilder = new StringBuilder();
        List<String> aliases = command.getAliases();

        List<String> allAliasesAndLabel = new ArrayList<>(aliases);
        allAliasesAndLabel.add(command.getLabel());

        Function<String, String> wrapper = s -> withPrefix(prefix, s);
        allAliasesAndLabel.addAll(allAliasesAndLabel.parallelStream().filter(s -> !s.contains(":")).map(wrapper).collect(Collectors.toList()));


        for (String alias : allAliasesAndLabel) {
            Command actualCommand = this.activeCommands.get(alias);
            if (actualCommand != null) {
                commentBuilder.append(glc.getCommandControlListenerAliasAlreadyExistsAlreadyExists(alias, String.valueOf(new CommandIdentifier(actualCommand))));
                return new Pair<>(false, commentBuilder.toString());
            }
        }

        allAliasesAndLabel.forEach(alias -> this.activeCommands.put(alias, command));
        this.disableCommands.remove(command);
        commentBuilder.append(glc.getCommandControlListenerAliasAlreadyExistsSuccessfullyEnabled());

        return new Pair<>(true, commentBuilder.toString());
    }

    public boolean isActive(final String label) {
        return this.activeCommands.containsKey(label.toLowerCase());
    }

    public boolean isActive(final Command command) {
        return this.activeCommands.containsValue(command);
    }

    public boolean isActive(final CommandIdentifier identifier) {
        return activeCommands.values().stream()
                .anyMatch(command -> identifier.equals(new CommandIdentifier(command)));
    }

    public boolean isDisable(final CommandIdentifier identifier) {
        return disableCommands.stream()
                .anyMatch(command -> identifier.equals(new CommandIdentifier(command)));
    }

    public boolean isDisable(final String label) {
        final String lowLabel = label.toLowerCase();
        return disableCommands.stream()
                .anyMatch(command -> command.getLabel().equalsIgnoreCase(label)
                        || command.getAliases().contains(lowLabel));
    }

    public boolean isDisable(final Command command) {
        return this.disableCommands.contains(command);
    }

    private Pair<Boolean, String> changeLabel(CommandIdentifier identifier, String newLabel) {
        Command cmd = this.getCommand(identifier);
        return (cmd == null) ? new Pair<>(false, glc.getCommandControlListenerChangeLabelNotExists())
                : changeLabel(cmd, newLabel);
    }


    //LABELS AND ALIASES
    private Pair<Boolean, String> changeLabel(final Command command, String newLabel) {
        if (unchangeableCommands.contains(new CommandIdentifier(command)))
            return new Pair<>(false, glc.getCommandControlListenerChangeLabelCanNotBeChanged());

        newLabel = newLabel.toLowerCase();
        Pair<Boolean, String> result = addAliasOrLabelToMap(command, newLabel, true);
        if (!result.getFirsValue()) return result;

        changeLabelReflection(command, newLabel);
        return new Pair<>(true, glc.getCommandControlListenerChangeLabelSuccessfullyChanged());
    }

    private void changeLabelReflection(Command command, String newLabel) {
        try {
            Field labelField = Command.class.getDeclaredField("label");
            labelField.setAccessible(true);
            labelField.set(command, newLabel);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    private Pair<Boolean, String> addAlias(final CommandIdentifier identifier, String newAlias) {
        Command cmd = this.getCommand(identifier);
        return (cmd == null) ? new Pair<>(false, glc.getCommandControlListenerAddAliasNotExists())
                : this.addAlias(cmd, newAlias);
    }

    private Pair<Boolean, String> addAlias(final Command command, String newAlias) {
        newAlias = newAlias.toLowerCase();
        Pair<Boolean, String> result = addAliasOrLabelToMap(command, newAlias, false);
        if (!result.getFirsValue()) return result;

        command.getAliases().add(newAlias);
        return new Pair<>(true, glc.getCommandControlListenerAddAliasSuccessfullyAdded());
    }

    private Pair<Boolean, String> addAliasOrLabelToMap(final Command command, String newAlias, boolean removeOldLabel) {

        if (command.getLabel().equalsIgnoreCase(newAlias) || command.getAliases().stream().anyMatch(newAlias::equalsIgnoreCase))
            return new Pair<>(false, this.getCommandHasThatAliasOrLabel());

        boolean hasPrefix = newAlias.contains(":");
        String prefix = this.getCommandPrefix(command);

        if (hasPrefix && !newAlias.split(":")[0].equals(prefix))
            return new Pair<>(false, getOnlyViableAliasMessage(prefix));


        if (this.isActive(command)) {
            Command existingCommand = this.getActiveCommand(newAlias);
            if (existingCommand != null && !hasPrefix && !existingCommand.equals(command))
                return new Pair<>(false, getCommandHasThatAlias(existingCommand.getLabel()));
            if (removeOldLabel) this.removeAliasOrLabel(command, command.getLabel());

            this.activeCommands.put(newAlias, command);
            if (!hasPrefix) {
                this.activeCommands.put(withPrefix(prefix, newAlias), command);
            }
        }
        return new Pair<>(true, "");
    }


    private boolean removeAlias(CommandIdentifier identifier, String aliasToRemove) {
        Command cmd = this.getCommand(identifier);
        return cmd != null && removeAlias(cmd, aliasToRemove);
    }

    private boolean removeAlias(Command command, String aliasToRemove) {
        aliasToRemove = aliasToRemove.toLowerCase();
        if (command.getAliases().stream().noneMatch(aliasToRemove::equalsIgnoreCase)) return false;
        removeAliasOrLabel(command, aliasToRemove);
        return command.getAliases().remove(aliasToRemove);
    }

    private void removeAliasOrLabel(Command command, String aliasToRemove) {
        String prefix = getCommandPrefix(command);

        if (command.equals(this.activeCommands.get(aliasToRemove)))
            this.activeCommands.remove(aliasToRemove);

        this.activeCommands.remove(withPrefix(prefix, aliasToRemove));
    }


    private String getOnlyViableAliasMessage(String viableAlias) {
        return glc.getCommandControlListenerOnlyViableAliasMessage(viableAlias);
    }

    private String getCommandHasThatAliasOrLabel() {
        return glc.getCommandControlListenerCommandHasThatAliasOrLabel();
    }

    private String getCommandHasThatAlias(String label) {
        return glc.getCommandControlListenerCommandHasThatAlias(label);
    }


    //DATABASE
    private void saveDisableCommandToDatabase(final CommandIdentifier identifier) {
        this.database.insertIntoCommandsIdentifiersTable(identifier.getNameWithPrefix());
    }

    private void removeDisableCommandFromDatabase(final CommandIdentifier identifier) {
        this.database.deleteCommandIdentifiers(identifier.getNameWithPrefix());
    }

    private void saveAliasToDatabase(final CommandIdentifier identifier, String alias) {
        if (this.database.getCommandIdentifierRemovedNameExists(identifier.getNameWithPrefix())) {
            this.database.deleteCommandIdentifiersRemovedName(identifier.getNameWithPrefix());
        }
        this.database.insertIntoAddedCommandsTable(identifier.getNameWithPrefix(), alias);
    }

    private void removeAliasFromDatabase(final CommandIdentifier identifier, String alias) {
        if (this.database.getCommandIdentifierAddedNameExists(identifier.getNameWithPrefix())) {
            this.database.deleteCommandIdentifiersAddedName(identifier.getNameWithPrefix());
        } else
            this.database.insertIntoRemovedCommandsTable(identifier.getNameWithPrefix(), alias);
    }

    private void changeLabelInDatabase(final CommandIdentifier identifier, String label) {
        this.database.changeIntoCommandsLabelTable(identifier.getNameWithPrefix(), label);
    }


    //EVENT HANDLERS
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void disableCommandsHandler(CommandDisableEvent event) {
        if (this.unchangeableCommands.contains(new CommandIdentifier(event.getCommand())))
            return;
        boolean isDisableSuccessful = this.disableCommand(event.getCommand());
        if (isDisableSuccessful) event.done();

        if (isDisableSuccessful) this.saveDisableCommandToDatabase(new CommandIdentifier(event.getCommand()));
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void enableCommandsHandler(CommandEnableEvent event) {
        Pair<Boolean, String> result = this.enableCommand(event.getCommand());
        if (result.getFirsValue()) event.done();
        event.setComment(result.getSecondValue());

        if (result.getFirsValue()) this.removeDisableCommandFromDatabase(new CommandIdentifier(event.getCommand()));
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void addingAliasesHandler(CommandAliasAddEvent event) {
        Pair<Boolean, String> result = this.addAlias(event.getCommand(), event.getAlias());
        if (result.getFirsValue()) event.done();
        event.setComment(result.getSecondValue());

        if (result.getFirsValue())
            this.saveAliasToDatabase(new CommandIdentifier(event.getCommand()), event.getAlias());
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void removingAliasesHandler(CommandAliasRemoveEvent event) {
        boolean isAliasRemoved = this.removeAlias(event.getCommand(), event.getAlias());
        if (isAliasRemoved) event.done();

        if (isAliasRemoved) this.removeAliasFromDatabase(new CommandIdentifier(event.getCommand()), event.getAlias());
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void changingLabelHandler(CommandLabelChangeEvent event) {
        Pair<Boolean, String> result = this.changeLabel(event.getCommand(), event.getNewLabel());
        if (result.getFirsValue()) event.done();
        event.setComment(result.getSecondValue());

        if (result.getFirsValue())
            this.changeLabelInDatabase(new CommandIdentifier(event.getCommand()), event.getNewLabel());
    }
}
