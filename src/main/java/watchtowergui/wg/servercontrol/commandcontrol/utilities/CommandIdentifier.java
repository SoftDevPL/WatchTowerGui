package watchtowergui.wg.servercontrol.commandcontrol.utilities;

import org.bukkit.command.Command;
import watchtowergui.wg.WatchTowerGui;

import java.util.Objects;

public class CommandIdentifier {

    private final String name;
    private final String defaultPrefix;


    public CommandIdentifier(String prefixWithName) {
        String[] splited = prefixWithName.split(":", 2);
        this.name = splited[1];
        this.defaultPrefix = splited[0];
    }

    public CommandIdentifier(String name, String commandDefaultPrefix) {
        this.name = name;
        this.defaultPrefix = commandDefaultPrefix;
    }

    public CommandIdentifier(Command command) {
        this.name = command.getName();
        this.defaultPrefix = WatchTowerGui.getInstance().commandsControlListener.getCommandPrefix(command);
    }

    public String getName() {
        return name;
    }

    public String getNameWithPrefix() {
        return defaultPrefix + ':' + name;
    }

    public String getDefaultPrefix() {
        return defaultPrefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandIdentifier that = (CommandIdentifier) o;
        return name.equalsIgnoreCase(that.name) &&
                comparePrefixes(this.defaultPrefix, that.defaultPrefix);

    }

    @Override
    public String toString() {
        return getNameWithPrefix();
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultPrefix, name);
    }

    private boolean comparePrefixes(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }
}
