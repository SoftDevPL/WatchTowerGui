package watchtowergui.wg.servercontrol.commandcontrol.events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

public class CommandDisableEvent extends CommandEvent {

    @Override
    public String getDescription() {
        return "Command " + command.getName() + " has been disabled"
                + ((sender != null) ? " by " + sender.getName() : "");
    }

    public CommandDisableEvent(Command commandToDisable, @Nullable CommandSender executor) {
        super(commandToDisable, executor);
    }

}
