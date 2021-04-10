package watchtowergui.wg.managers;

import org.bukkit.permissions.Permission;

public class Permissions {
    public final Permission allowWritingOnDisableChat = new Permission("watchTowerGui.utilities.allowSpamming.writingOnDisabledChat");
    public final Permission allowSpamming = new Permission("watchTowerGui.utilities.allowSpamming");
    public final Permission maintenancePerm = new Permission("watchTowerGui.utilities.maintenancePerm");
    public final Permission canSeeHiddenPerm = new Permission("watchTowerGui.utilities.canSeeOthers");
}
