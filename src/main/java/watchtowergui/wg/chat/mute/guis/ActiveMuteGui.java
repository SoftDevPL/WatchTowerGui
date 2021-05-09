package watchtowergui.wg.chat.mute.guis;

import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.engine.basics.ListGui;
import ad.guis.ultimateguis.engine.interfaces.Action;
import ad.guis.ultimateguis.examples.ConfirmGui;
import ad.guis.ultimateguis.examples.PlayersGui;
import ad.guis.ultimateguis.multithreading.Operation;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.mute.listeners.PlayerMuteData;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ActiveMuteGui extends ListGui<PlayerMuteData> {

    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public GuiLanguageConfig glc;
    public WatchTowerGui plugin;

    public ActiveMuteGui(BasicGui previousGui) {
        super(previousGui, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_bansGui_mutedPlayers());
        this.plugin = WatchTowerGui.getInstance();
        glc = plugin.configsManager.guiLanguageConfig;
        this.setRefreshFunction(this::refreshFunction);
        this.setAction(this::clickFunction);
    }

    private List<? extends PlayerMuteData> refreshFunction() {
        return WatchTowerGui.getInstance().listenersManager.muteListener.getMuteDataList();
    }

    private void clickFunction(PlayerMuteData data) {
        OfflinePlayer mutedPlayer = Bukkit.getOfflinePlayer(data.getMutedPlayer());
        new ConfirmGui(glc.getMutesGuiUnmute(mutedPlayer.getName()), new Action() {
            @Override
            public void action(Player playerWhoAccept) {
                playerWhoAccept.performCommand(plugin.commandsControlListener.getMainADCommandLabel("unmute")
                        + " " + mutedPlayer.getName());

                ActiveMuteGui.this.open(playerWhoAccept);
            }
        }, ActiveMuteGui.this::open).open(this.getLastClicker());
    }

    @Override
    public ItemStack getDescriptionItem(PlayerMuteData data) {
        OfflinePlayer playerFromData = Bukkit.getOfflinePlayer(data.getMutedPlayer());
        if (PlayersGui.isHeadCalc(data.getMutedPlayer())) {
            return modifyLore(PlayersGui.calcHead(data.getMutedPlayer()), data);
        }
        new Operation<>(() -> modifyLore(PlayersGui.calcHead(data.getMutedPlayer()), data))
                .asyncSubscribe((item) -> {
                    this.replaceItem(data, item);
                    PlayersGui.addUUIDtoHeads(data.getMutedPlayer());
                });
        return modifyLore(BasicGui.createItem(Material.SKULL_ITEM, playerFromData.getName(), (short) 3), data);

    }

    private ItemStack modifyLore(ItemStack item, PlayerMuteData data) {
        return BasicGui.modifyLore(item, BasicGui.simpleSplitLore(glc.getMutesGuiMutedBy(data.getWhoMuted()),
                glc.getMutesGuiExpiredDate(dateFormat.format(data.getExpiryTime()))));
    }
}
