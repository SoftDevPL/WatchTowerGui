package watchtowergui.wg.servercontrol.commandcontrol.events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

public class CommandAliasAddEvent extends CommandEvent {
    String alias = "";
    String comment = "comment";

    public CommandAliasAddEvent(String alias, Command command, @Nullable CommandSender executor) {
        super(command, executor);
        this.alias = alias;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String getDescription() {
        return "Command " + command.getName() + "-> alias " + alias + " has been added"
                + ((sender != null) ? " by " + sender.getName() : "");
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
