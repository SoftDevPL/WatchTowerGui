package watchtowergui.wg.servercontrol.commandcontrol.events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

public class CommandEnableEvent extends CommandEvent {
    private String comment = "";

    @Override
    public String getDescription() {
        return "Command " + command.getName() + " has been enabled"
                + ((sender != null) ? " by " + sender.getName() : "");
    }

    public CommandEnableEvent(Command commandToEnable, @Nullable CommandSender sender) {
        super(commandToEnable, sender);
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
