package watchtowergui.wg.servercontrol.commandcontrol.events;

import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

public class CommandLabelChangeEvent extends CommandEvent {

    @Getter
    private final String oldLabel;
    private String newLabel;
    private String comment;

    public CommandLabelChangeEvent(String newLabel, Command command, @Nullable CommandSender executor) {
        super(command, executor);
        this.newLabel = newLabel;
        this.oldLabel = command.getLabel();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNewLabel() {
        return newLabel;
    }

    public void setNewLabel(String newLabel) {
        this.newLabel = newLabel;
    }

    @Override
    public String getDescription() {
        return "Command " + command.getName() + "-> label has been changed from " + oldLabel + " to " + newLabel
                + ((sender != null) ? " by " + sender.getName() : "");
    }
}
