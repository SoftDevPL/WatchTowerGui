package watchtowergui.wg.bans.guis;

import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.engine.basics.ListGui;
import ad.guis.ultimateguis.examples.ConfirmGui;
import ad.guis.ultimateguis.examples.PlayersGui;
import ad.guis.ultimateguis.multithreading.Operation;
import org.bukkit.ChatColor;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.bans.listeners.PlayerBanData;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.managers.staticclasses.CalendarCalculator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActiveTempBansGui extends ListGui<PlayerBanData> {
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public GuiLanguageConfig glc;
    public WatchTowerGui plugin;

    public ActiveTempBansGui(BasicGui previousGui) {
        super(previousGui, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getBansGuiTemporaryBannedPlayersList());
        this.setAction(this::dataBanAction);
        this.plugin = WatchTowerGui.getInstance();
        glc = plugin.configsManager.guiLanguageConfig;
        this.previousGui = previousGui;
        this.setRefreshFunction(this::refreshFunction);
    }

    private List<PlayerBanData> refreshFunction() {
        return WatchTowerGui.getInstance().listenersManager.tempBanListener.getBanDataList();
    }

    private void dataBanAction(PlayerBanData data) {
        String playerName = Bukkit.getOfflinePlayer(data.getBannedPlayer()).getName();
        new ConfirmGui(glc.getBansGuiUnban(playerName), playerWhoAccept -> {
            playerWhoAccept.performCommand(plugin.commandsControlListener.getMainADCommandLabel("tmunban")
                    + " " + playerName);
            ActiveTempBansGui.this.open(playerWhoAccept);
        }, ActiveTempBansGui.this::open).open(this.getLastClicker());
    }

    public List<? extends PlayerBanData> getPlayerBanDataList() {
        return this.getList();
    }

    @Override
    public ItemStack getDescriptionItem(PlayerBanData data) {
        ItemStack item;
        if (PlayersGui.isHeadCalc(data.getBannedPlayer())) {
            item = PlayersGui.calcHead(data.getBannedPlayer());
        } else {
            item = BasicGui.createItem(Material.SKULL_ITEM, Bukkit.getOfflinePlayer(data.getBannedPlayer()).getName(),
                    (short) SkullType.PLAYER.ordinal());
            new Operation<>(() -> modifyItemLore(PlayersGui.calcHead(data.getBannedPlayer()), data))
                    .asyncSubscribe((head) -> {
                        this.replaceItem(data, head);
                        PlayersGui.addUUIDtoHeads(data.getBannedPlayer());
                    }).run();
        }
        return modifyItemLore(item, data);
    }

    private ItemStack modifyItemLore(ItemStack item, PlayerBanData data) {
        ItemMeta meta;
        List<String> loreList = new ArrayList<>();
        meta = item.getItemMeta();
        loreList.add(glc.getBanDescriptionBannedBy(data.getBanExecutor()));
        Date date = new Date(data.getBannedTime());
        loreList.add(glc.getBanDescriptionBannedDate(CalendarCalculator.standardDateFormat(date.getTime())));
        date.setTime(data.getExpiredTime());
        loreList.add(glc.getBanDescriptionExpiredDate(CalendarCalculator.standardDateFormat(date.getTime())));
        ArrayList<String> list = (ArrayList<String>) BasicGui.splitLore(glc.getBanDescriptionComment(data.getComment()), 20);
        ArrayList<String> list2 = (ArrayList<String>) Stream.concat(loreList.stream(), list.stream()).collect(Collectors.toList());
        meta.setLore(list2);
        item.setItemMeta(meta);
        return item;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }
}
