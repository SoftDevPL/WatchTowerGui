package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.examples.PlayersGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.guis.ActiveTempBansGui;
import watchtowergui.wg.chat.mute.guis.ActiveMuteGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BansGui extends BasicGui {

    private static ItemStack tempBanItem;
    private static ItemStack mutedPlayersItem;
    private static ItemStack hiddenPlayersItem;
    public GuiLanguageConfig glc;
    public WatchTowerGui plugin;

    public BansGui(BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getBansGuiPageName(), previousGui);
        this.plugin = WatchTowerGui.getInstance();
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        setupGuis();
        init();
    }

    private void setupGuis() {
        hiddenPlayersItem = BasicGui.createItem(Material.GLASS, glc.getBansGuiHiddenPlayers());
        tempBanItem = BasicGui.createItem(Material.WATCH, glc.getBansGuiTemporaryBannedPlayersList());
        mutedPlayersItem = BasicGui.createItem(Material.PAPER, glc.getBansGuiMutedPlayers());
    }

    protected void init() {
        ItemStack frozenPlayers = BasicGui.createItem(Material.PACKED_ICE, glc.getBansGuiFrozenPlayersList());
        ItemStack banPlayers = BasicGui.createItem(Material.SKULL_ITEM, glc.getBansGuiBannedPlayersList(), (short) 1);
        ItemStack previous = BasicGui.createItem(Material.ARROW, glc.getAdminGuiBack());

        this.setItem(2, 1, banPlayers, player -> {
            PlayersGui playersGui = new PlayersGui(this, glc.getBansGuiBannedPlayersList());

            playersGui.setRefreshFunction(() ->
                    Bukkit.getBannedPlayers().stream()
                            .sorted(Comparator.comparing(OfflinePlayer::getName, String.CASE_INSENSITIVE_ORDER))
                            .map(OfflinePlayer::getUniqueId)
                            .collect(Collectors.toList()));

            playersGui.setAction(playerFromHead -> {
                new PlayerActionGui(Bukkit.getOfflinePlayer(playerFromHead),
                        playersGui).open(playersGui.getLastClicker());
            });
            playersGui.open(player);
        });

        this.setItem(3, 1, tempBanItem, player -> {
            ActiveTempBansGui tempBansGui = new ActiveTempBansGui(BansGui.this);
            tempBansGui.setAction(banData -> {
                new PlayerActionGui(Bukkit.getOfflinePlayer(banData.getBannedPlayer()),
                        tempBansGui).open(tempBansGui.getLastClicker());
            });
            tempBansGui.open(player);
        });

        this.setItem(4, 1, mutedPlayersItem,
                player -> {
                    ActiveMuteGui muteGui = new ActiveMuteGui(BansGui.this);
                    muteGui.setAction(muteData -> {
                        new PlayerActionGui(Bukkit.getOfflinePlayer(muteData.getMutedPlayer()),
                                muteGui).open(muteGui.getLastClicker());
                    });
                    muteGui.open(player);
                });

        this.setItem(5, 1, frozenPlayers, player -> {
            PlayersGui frozenPlayersGui = new PlayersGui(this, glc.getBansGuiFrozenPlayersList());
            frozenPlayersGui.setAction(playerFromHead ->
                    new PlayerActionGui(Bukkit.getOfflinePlayer(playerFromHead), frozenPlayersGui).open(player));

            frozenPlayersGui.setRefreshFunction(() ->
                    sortedPlayers(WatchTowerGui.getInstance().listenersManager.freezeListener.getFrozenPlayers()));

            frozenPlayersGui.open(player);
        });

        if (previousGui != null) {
            this.setItem(8, 1, previous, player -> {
                if (previousGui != null) {
                    previousGui.open(player);
                }
            });
        }

        this.setItem(6, 1, hiddenPlayersItem, player -> {
            PlayersGui hiddenPlayersGui = new PlayersGui(BansGui.this, glc.getBansGuiHiddenPlayers());

            hiddenPlayersGui.setRefreshFunction(() ->
                    sortedPlayers(WatchTowerGui.getInstance().listenersManager.hiddingPlayerListener.getHiddenPlayers()));

            hiddenPlayersGui.setAction(playerFromHead -> {
                new PlayerActionGui(Bukkit.getOfflinePlayer(playerFromHead),
                        hiddenPlayersGui).open(hiddenPlayersGui.getLastClicker());
            });

            hiddenPlayersGui.open(player);
        });

        ItemStack frame = BasicGui.createBackground(Colors.BLACK);

        ItemStack backgroundBlue = BasicGui.createBackground(Colors.RED);


        this.autoFrame(frame);
        this.autoFill(backgroundBlue);
    }

    private List<UUID> sortedPlayers(Collection<UUID> c) {
        return c.stream().map(Bukkit::getOfflinePlayer)
                .sorted(Comparator.comparing(OfflinePlayer::getName, String.CASE_INSENSITIVE_ORDER))
                .map(OfflinePlayer::getUniqueId).collect(Collectors.toList());
    }


}
