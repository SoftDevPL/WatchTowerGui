package watchtowergui.wg.adminfun.listeners;

import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.adminfun.events.PlayerFreezeEvent;
import watchtowergui.wg.adminfun.events.PlayerHideEvent;
import watchtowergui.wg.adminfun.events.PlayerUnHideEvent;
import watchtowergui.wg.adminfun.events.PlayerUnfreezeEvent;
import watchtowergui.wg.adminfun.guis.PlayerActionGui;
import watchtowergui.wg.bans.event.PlayerGetTempBanEvent;
import watchtowergui.wg.bans.event.PlayerRemoveTempBanEvent;
import watchtowergui.wg.chat.mute.events.PlayerGetMuteEvent;
import watchtowergui.wg.chat.mute.events.PlayerRemoveMuteEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

public class PlayerActionGuiListener implements Listener {
    private final Set<PlayerActionGui> playerActionGuiList = new HashSet<>();
    private final int schedulerDelay = 20;

    public void init() {
        WatchTowerGui.getInstance().getServer().getPluginManager().registerEvents(this, WatchTowerGui.getInstance());
        Bukkit.getScheduler().scheduleSyncRepeatingTask(WatchTowerGui.getInstance(), this::updatingLocation,
                this.schedulerDelay, this.schedulerDelay);
    }

    private void updatingLocation() {
        playerActionGuiList.forEach(PlayerActionGui::updateLocation);
    }

    public void addPlayerActionGui(PlayerActionGui gui) {
        playerActionGuiList.add(gui);
    }

    public void removeActionGui(PlayerActionGui gui) {
        playerActionGuiList.remove(gui);
    }

    private Stream<PlayerActionGui> filteredGuis(UUID playerUUID) {
        return playerActionGuiList.stream().filter(gui -> gui.getOfflinePlayer().getUniqueId().
                equals(playerUUID));
    }


    @EventHandler
    private void joinEvent(PlayerJoinEvent e) {
        filteredGuis(e.getPlayer().getUniqueId()).forEach(gui -> gui.setActivity(PlayerActionGui.ONLINE));
    }

    @EventHandler
    private void leaveEvent(PlayerQuitEvent e) {
        filteredGuis(e.getPlayer().getUniqueId()).forEach(gui -> gui.setActivity(PlayerActionGui.OFFLINE));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void freezeEvent(PlayerFreezeEvent e) {
        filteredGuis(e.getFrozenPlayer().getUniqueId()).forEach(gui -> gui.setFreeze(true));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void freezeEvent(PlayerUnfreezeEvent e) {
        filteredGuis(e.getFrozenPlayer().getUniqueId()).forEach(gui -> gui.setFreeze(false));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void vanishOnEvent(PlayerHideEvent e) {
        filteredGuis(e.getPlayer().getUniqueId()).forEach(gui -> gui.setVanished(true));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void vanishOffEvent(PlayerUnHideEvent e) {
        filteredGuis(e.getPlayer().getUniqueId()).forEach(gui -> gui.setVanished(false));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void banEvent(PlayerGetTempBanEvent e) {
        filteredGuis(e.getBannedPlayer().getUniqueId()).forEach(gui -> gui.setTempBanned(true));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void unbanEvent(PlayerRemoveTempBanEvent e) {
        filteredGuis(e.getUnBannedPlayer().getUniqueId()).forEach(gui -> gui.setTempBanned(false));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void muteEvent(PlayerGetMuteEvent e) {
        filteredGuis(e.getMutedPlayer().getUniqueId()).forEach(gui -> gui.setMuted(true));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void unMuteEvent(PlayerRemoveMuteEvent e) {
        filteredGuis(e.getUnMutedPlayer().getUniqueId()).forEach(gui -> gui.setMuted(false));
    }

}
