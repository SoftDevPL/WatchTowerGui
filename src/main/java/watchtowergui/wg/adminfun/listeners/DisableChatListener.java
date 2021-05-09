package watchtowergui.wg.adminfun.listeners;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.ChatDisabledOFFEvent;
import watchtowergui.wg.adminfun.events.ChatDisabledOnEvent;
import watchtowergui.wg.adminfun.guis.AdminFunGui;
import watchtowergui.wg.fileManager.configsutils.configs.LanguageConfig;
import watchtowergui.wg.fileManager.sql.sqlUtils.Database;
import watchtowergui.wg.managers.Permissions;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class DisableChatListener implements Listener {

    public LanguageConfig languageConfig;
    public Permissions permissions;
    public Database database;
    public boolean disabledChat;
    List<AdminFunGui> openedGuis = new ArrayList<>();
    @Getter
    private WatchTowerGui watchTowerGui;
    private int disableChatValue;

    public void init() {
        this.watchTowerGui = WatchTowerGui.getInstance();
        permissions = watchTowerGui.permissions;
        this.database = watchTowerGui.SQLmanager.database;
        this.disableChatValue = this.database.getDisableChatSwitched();
        this.disabledChat = isDisabledChatSwitched();
        setDisabledChatForEveryGui();
        languageConfig = watchTowerGui.configsManager.languageConfig;
        watchTowerGui.getServer().getPluginManager().registerEvents(this, this.watchTowerGui);
    }

    private boolean isDisabledChatSwitched() {
        return this.disableChatValue == 1;
    }

    public int getDisableChatValueValue() {
        return disabledChat ? 1 : 0;
    }

    public boolean addOpenedGuis(AdminFunGui gui) {
        if (!openedGuis.contains(gui)) {
            return openedGuis.add(gui);
        }
        return false;
    }

    public boolean removeAdminFunGuis(AdminFunGui gui) {
        return openedGuis.remove(gui);
    }

    public void setDisabledChatForEveryGui() {
        if (disabledChat) {
            for (AdminFunGui adminFunGui : openedGuis) {
                adminFunGui.setDisableCharMode(AdminFunGui.ONN);
            }
        } else {
            for (AdminFunGui adminFunGui : openedGuis) {
                adminFunGui.setDisableCharMode(AdminFunGui.OFF);
            }
        }
    }

    @EventHandler
    private void chatDisabledON(ChatDisabledOnEvent event) {
        database.deleteDisableChatSwitchValue();
        database.insertIntoDisableChatTableSwitchTable(1);
        disabledChat = true;
        for (AdminFunGui adminFunGui : openedGuis) {
            adminFunGui.setDisableCharMode(AdminFunGui.ONN);
        }
    }

    @EventHandler
    private void chatDisabledOFF(ChatDisabledOFFEvent event) {
        database.deleteDisableChatSwitchValue();
        database.insertIntoDisableChatTableSwitchTable(0);
        disabledChat = false;
        for (AdminFunGui adminFunGui : openedGuis) {
            adminFunGui.setDisableCharMode(AdminFunGui.OFF);
        }
    }

    @EventHandler
    private void disableChat(AsyncPlayerChatEvent event) {
        if (disabledChat) {
            if (!event.getPlayer().hasPermission(this.permissions.allowWritingOnDisableChat)) {
                event.getPlayer().sendMessage(languageConfig.getSpecialLocale_adminStaff_chat_disabledChat());
                event.setCancelled(true);
            }
        }
    }
}
