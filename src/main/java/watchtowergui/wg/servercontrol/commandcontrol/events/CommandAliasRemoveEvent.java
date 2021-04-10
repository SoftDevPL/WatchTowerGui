package watchtowergui.wg.servercontrol.commandcontrol.events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

public class CommandAliasRemoveEvent extends CommandEvent {
    private String alias;

    public CommandAliasRemoveEvent(String alias, Command command, @Nullable CommandSender executor) {
        super(command, executor);
        this.alias = alias;
    }

    @Override
    public String getDescription() {
        return "Command " + command.getName() + "-> alias " + alias + " has been removed"
                + ((sender != null) ? " by " + sender.getName() : "");
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
