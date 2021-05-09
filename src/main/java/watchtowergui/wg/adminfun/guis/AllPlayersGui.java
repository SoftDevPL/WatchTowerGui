package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.examples.PlayersGui;
import watchtowergui.wg.WatchTowerGui;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AllPlayersGui extends PlayersGui {

    @Getter
    private boolean showOfflinePlayers = false;

    public AllPlayersGui(BasicGui previousGui, String title) {
        super(previousGui, title);
        this.setRefreshFunction(this::refreshFunction);
    }

    private void addFilterItem() {
        this.setActionItem(BasicGui.createSegmentedItem(Material.WATCH,
                WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_adminGui_playersGuiShowOfflinePlayersName() + "\n" +
                        ((showOfflinePlayers)
                                ? WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_adminGui_playersGuiShowOfflinePlayersON()
                                : WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_adminGui_playersGuiShowOfflinePlayersOFF())), player -> {
            showOfflinePlayers = !showOfflinePlayers;
            open(player);
        }, 5);
    }

    private List<UUID> refreshFunction() {
        return ((showOfflinePlayers) ? Arrays.stream(Bukkit.getOfflinePlayers()) : Bukkit.getOnlinePlayers().stream())
                .sorted(Comparator.comparing(OfflinePlayer::getName, String.CASE_INSENSITIVE_ORDER))
                .map(OfflinePlayer::getUniqueId)
                .collect(Collectors.toList());
    }

    @Override
    public void open(Player opener) {
        addFilterItem();
        super.open(opener);
    }
}
