package watchtowergui.wg.managers;

import watchtowergui.wg.adminfun.listeners.*;
import watchtowergui.wg.bans.listeners.CustomBansGuiListener;
import watchtowergui.wg.bans.listeners.TempBanListener;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.chat.chatguard.ReplaceBadWords;
import watchtowergui.wg.chat.mute.listeners.MuteListener;
import watchtowergui.wg.fileManager.sql.databaselisteners.logs.DatabaseLogsListenersManager;
import watchtowergui.wg.logs.utils.ConsoleChatListener;
import watchtowergui.wg.servercontrol.commandcontrol.listeners.AliasesGuiListener;
import watchtowergui.wg.servercontrol.commandcontrol.listeners.SingleCommandGuiListener;
import watchtowergui.wg.servercontrol.plugincontrol.PluginControlListener;

public class ListenersManager {

    public FreezeListener freezeListener;
    public PlayerActionGuiListener playerActionGuiListener;
    public TempBanListener tempBanListener;
    public ReplaceBadWords replaceBadWords;
    public CustomBansGuiListener customBansGuiListener;
    public MuteListener muteListener;
    public ChatManager chatManager;
    public HidingPlayerListener hidingPlayerListener;
    public WhiteListListener whiteListListener;
    public DisableChatListener disableChatListener;
    public ConsoleChatListener consoleChatListener;
    public DatabaseLogsListenersManager databaseLogsListenersManager;
    public SingleCommandGuiListener singleCommandGuiListener;
    public AliasesGuiListener aliasesGuiListener;
    public PluginControlListener pluginControlListener;

    public ListenersManager() {
        this.databaseLogsListenersManager = new DatabaseLogsListenersManager();
        this.chatManager = new ChatManager();
        this.freezeListener = new FreezeListener();
        this.playerActionGuiListener = new PlayerActionGuiListener();
        this.tempBanListener = new TempBanListener();
        this.replaceBadWords = new ReplaceBadWords();
        this.customBansGuiListener = new CustomBansGuiListener();
        this.muteListener = new MuteListener();
        this.hidingPlayerListener = new HidingPlayerListener();
        this.whiteListListener = new WhiteListListener();
        this.disableChatListener = new DisableChatListener();
        this.consoleChatListener = new ConsoleChatListener();
        this.singleCommandGuiListener = new SingleCommandGuiListener();
        this.aliasesGuiListener = new AliasesGuiListener();
        this.pluginControlListener = new PluginControlListener();
    }

    public void init() {
        this.databaseLogsListenersManager.init();
        this.chatManager.init();
        this.freezeListener.init();
        this.playerActionGuiListener.init();
        this.tempBanListener.init();
        this.replaceBadWords.init();
        this.customBansGuiListener.init();
        this.muteListener.init();
        this.hidingPlayerListener.init();
        this.whiteListListener.init();
        this.disableChatListener.init();
        this.consoleChatListener.init();
        this.singleCommandGuiListener.init();
        this.aliasesGuiListener.init();
        this.pluginControlListener.init();
    }

    public void disable() {
        this.hidingPlayerListener.disable();
    }
}
