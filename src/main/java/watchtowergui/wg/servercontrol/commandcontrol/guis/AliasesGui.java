package watchtowergui.wg.servercontrol.commandcontrol.guis;

import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.engine.basics.ListGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.servercontrol.commandcontrol.CommandsControlListener;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandAliasAddEvent;
import watchtowergui.wg.servercontrol.commandcontrol.events.CommandAliasRemoveEvent;
import watchtowergui.wg.servercontrol.commandcontrol.listeners.AliasesGuiListener;

import java.util.ArrayList;
import java.util.List;

public class AliasesGui extends ListGui<String> {

    public final static String CANCEL_PHRASE = "###";
    public final static String FORBIDDEN_PHRASE = ":";
    private final AliasesGuiListener aliasesGuiListener;
    private final CommandsControlListener commandsControlListener;
    private final ChatManager chatManager;
    private final GuiLanguageConfig glc;
    private final Command command;
    private Player actualPlayer;

    public AliasesGui(Command command, BasicGui previousGui, String title) {
        super(previousGui, title);
        this.command = command;
        this.commandsControlListener = WatchTowerGui.getInstance().commandsControlListener;
        this.aliasesGuiListener = WatchTowerGui.getInstance().listenersManager.aliasesGuiListener;
        this.chatManager = WatchTowerGui.getInstance().listenersManager.chatManager;
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        this.setRefreshFunction(this::refreshFunction);
        this.setAction(this::itemAction);
    }

    public boolean isWaitingForResult() {
        return this.actualPlayer != null;
    }

    public Command getCommand() {
        return command;
    }


    private ItemStack createAddItem() {
        return BasicGui.createItem(Material.INK_SACK,
                glc.getAliasGuiAddAliasItemName(), (short) 10);
    }

    private ItemStack createAliasItem(String alias) {
        return BasicGui.createItem(Material.PAPER, ChatColor.GOLD + "" + ChatColor.BOLD + alias,
                BasicGui.splitLore(glc.getAliasGuiRemoveAliasItemName(), 100));
    }


    private List<String> refreshFunction() {
        List<String> copy = new ArrayList<>(command.getAliases());
        copy.add(FORBIDDEN_PHRASE);
        return copy;
    }

    @Override
    public ItemStack getDescriptionItem(String s) {
        if (s.equals(FORBIDDEN_PHRASE))
            return createAddItem();
        return createAliasItem(s);
    }

    private void itemAction(String alias) {
        Player player = this.getLastClicker();
        if (alias.equals(FORBIDDEN_PHRASE)) {
            chatManager.setTask(player.getUniqueId(), this::setAliasFromChat);
            player.sendMessage(glc.getAliasGuiTypeNewAlias("\"" + CANCEL_PHRASE + "\""));
            player.closeInventory();
        } else {
            this.setWaitingStatus(player);
            Bukkit.getPluginManager().callEvent(new CommandAliasRemoveEvent(alias, this.command, player));
            this.open(player);
        }
    }

    private boolean setAliasFromChat(String chatMessage, Player player) {

        if (chatMessage.equals(CANCEL_PHRASE)) {
            player.sendMessage(glc.getAliasGuiCancelPhrase());
            this.open(player);
        } else {
            setWaitingStatus(player);
            this.aliasesGuiListener.addGui(this);
            Bukkit.getScheduler().scheduleSyncDelayedTask(WatchTowerGui.getInstance(), () ->
                    Bukkit.getPluginManager().callEvent(new CommandAliasAddEvent(chatMessage, this.command, player)));
        }
        return true;
    }

    public void receiveAliasAdded(boolean isSuccessful, String alias, String comment) {
        if (!isWaitingForResult()) return;
        this.actualPlayer.sendMessage(comment);
        if (!isSuccessful) {
            this.actualPlayer.sendMessage(glc.getAliasGuiEnterAliasAgain("\"" + CANCEL_PHRASE + "\""));
            chatManager.setTask(this.actualPlayer.getUniqueId(), this::setAliasFromChat);
        } else AliasesGui.this.open(this.actualPlayer);
        resetWaitingStatus();
    }

    public void receiveAliasRemoved(boolean isSuccessful, String alias) {
        if (!isWaitingForResult()) return;
        if (isSuccessful) {
            this.actualPlayer.sendMessage(glc.getAliasGuiAliasRemoved());
            this.open(actualPlayer);
        } else this.actualPlayer.sendMessage(glc.getAliasGuiCantRemovedAlias());
        resetWaitingStatus();
    }

    private void resetWaitingStatus() {
        this.actualPlayer = null;
    }

    private void setWaitingStatus(Player actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

}
