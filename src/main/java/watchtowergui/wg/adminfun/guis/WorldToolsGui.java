package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.examples.OnlinePlayersGui;
import ad.guis.ultimateguis.examples.PlayersGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WorldToolsGui extends BasicGui {

    private static GuiLanguageConfig glc;
    private static ChatManager chatManager;
    private static ItemStack defaultGamemode;
    private static ItemStack difficulty;
    private static ItemStack gamemode;
    private static ItemStack reload;
    private static ItemStack say;
    private static ItemStack seed;
    private static ItemStack setWorldSpawn;
    private static ItemStack spawnPoint;
    private static ItemStack time;
    private static ItemStack weather;
    private static ItemStack worldBorder;
    private static ItemStack xp;
    private static ItemStack title;
    private static ItemStack tell;
    private static ItemStack close;
    private static ItemStack back;
    private static ItemStack backGroundBlack;
    private static boolean initFirstTime = true;
    public WatchTowerGui watchTowerGui;

    public WorldToolsGui(BasicGui previousGui) throws IllegalArgumentException {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_adminGuiWorldToolsGui_worldToolsGuiPageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        chatManager = watchTowerGui.listenersManager.chatManager;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        if (!initFirstTime) return;
        initFirstTime = false;
        close = BasicGui.createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        back = BasicGui.createItem(Material.ARROW, glc.getGuiLocale_adminGui_back());
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        defaultGamemode = BasicGui.createItem(
                Material.HOPPER,
                glc.getGuiLocale_adminGuiWorldToolsGui_defaultGamemodeName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_defaultGamemodeLore(), 25));
        difficulty = BasicGui.createItem(
                Material.CHEST,
                glc.getGuiLocale_adminGuiWorldToolsGui_worldDifficultyName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_worldDifficultyLore(), 25));
        gamemode = BasicGui.createItem(
                Material.ANVIL,
                glc.getGuiLocale_adminGuiWorldToolsGui_gamemodeName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_gamemodeLore(), 25));
        reload = BasicGui.createItem(
                Material.LEVER,
                glc.getGuiLocale_adminGuiWorldToolsGui_reloadName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_reloadLore(), 25));
        say = BasicGui.createItem(
                Material.PAPER,
                glc.getGuiLocale_adminGuiWorldToolsGui_sayName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_sayLore(), 25));
        seed = BasicGui.createItem(
                Material.GRASS,
                glc.getGuiLocale_adminGuiWorldToolsGui_seedName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_seedLore(), 25));
        setWorldSpawn = BasicGui.createItem(
                Material.BEDROCK,
                glc.getGuiLocale_adminGuiWorldToolsGui_setWorldSpawnName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_setWorldSpawnLore(), 25));
        spawnPoint = BasicGui.createItem(
                Material.COMPASS,
                glc.getGuiLocale_adminGuiWorldToolsGui_spawnPointName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_spawnPointLore(), 25));
        time = BasicGui.createItem(
                Material.WATCH,
                glc.getGuiLocale_adminGuiWorldToolsGui_timeName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_timeLore(), 25));
        weather = BasicGui.createItem(
                Material.WATER_LILY,
                glc.getGuiLocale_adminGuiWorldToolsGui_weatherName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_weatherLore(), 25));
        worldBorder = BasicGui.createItem(
                Material.IRON_BARDING,
                glc.getGuiLocale_adminGuiWorldToolsGui_worldBorderName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_worldBorderLore(), 25));
        xp = BasicGui.createItem(
                Material.EXP_BOTTLE,
                glc.getGuiLocale_adminGuiWorldToolsGui_xpName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_xpLore(), 25));
        title = BasicGui.createItem(
                Material.JACK_O_LANTERN,
                glc.getGuiLocale_adminGuiWorldToolsGui_titleName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_titleLore(), 25));
        tell = BasicGui.createItem(
                Material.ENDER_PEARL,
                glc.getGuiLocale_adminGuiWorldToolsGui_tellName(),
                BasicGui.splitLore(glc.getGuiLocale_adminGuiWorldToolsGui_tellLore(), 25));
    }

    protected void init() {
        this.setItem(2, 0, defaultGamemode, player -> new DefaultGamemodeGui(WorldToolsGui.this).open(player));

        this.setItem(2, 1, difficulty, player -> new DifficultyGui(WorldToolsGui.this).open(player));
        this.setItem(2, 2, gamemode, player -> new GamemodeGui(WorldToolsGui.this).open(player));

        this.setItem(3, 0, reload,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getAnyCommand("bukkit:reload")));
        this.setItem(3, 1, say, player -> {
            player.closeInventory();
            player.sendMessage(glc.getGuiLocale_adminGuiWorldToolsGui_enterMessageInChat());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("say") + " " + chatMessage);
                new WorldToolsGui(WorldToolsGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(3, 2, seed,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("seed")));

        this.setItem(4, 0, setWorldSpawn,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("setworldspawn")));

        this.setItem(5, 0, spawnPoint,
                player -> player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("setspawnpoint")));
        this.setItem(5, 1, time, player -> new TimeGui(WorldToolsGui.this).open(player));
        this.setItem(5, 2, weather, player -> new WeatherGui(WorldToolsGui.this).open(player));

        this.setItem(6, 0, xp, player -> {
            PlayersGui playersGui = new OnlinePlayersGui(this, glc.getGuiLocale_worldToolsGui_selectPlayer());
            playersGui.setAction(offlinePlayer -> {
                player.sendMessage(glc.getAdminGuiWorldToolsGuiXpChatMessage("\"###\""));
                player.closeInventory();
                chatManager.setTask(player.getUniqueId(), (chatMessage, player1) -> {
                    if (chatMessage.equals("###")) {
                        player1.sendMessage(glc.getGuiLocale_adminGuiWorldToolsGui_xpChatCanceledMessage());
                        return true;
                    }
                    player1.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("xp")
                            + " " + chatMessage + "L " + Bukkit.getOfflinePlayer(offlinePlayer).getName());
                    return true;
                });
            });
            playersGui.open(player);
        });
        this.setItem(6, 1, title, player -> {
            PlayersGui playersGui = new OnlinePlayersGui(this, glc.getGuiLocale_worldToolsGui_selectPlayer());
            playersGui.setAction(offlinePlayer -> {
                player.sendMessage(glc.getAdminGuiWorldToolsGuiTitleChatMessage("\"###\""));
                player.closeInventory();
                chatManager.setTask(player.getUniqueId(), (chatMessage, player1) -> {
                    if (chatMessage.equals("###")) {
                        player1.sendMessage(glc.getGuiLocale_adminGuiWorldToolsGui_titleChatCanceledMessage());
                        return true;
                    }
                    Player onlinePlayer = Bukkit.getPlayer(offlinePlayer);
                    if (onlinePlayer == null) {
                        player.sendMessage(glc.getGuiLocale_singlePlayerGui_playerIsOffline());
                        return true;
                    }
                    onlinePlayer.sendTitle(
                            ChatColor.translateAlternateColorCodes('&', chatMessage), "", 10, 90, 30);
                    return true;
                });
            });
            playersGui.open(player);
        });
        this.setItem(6, 2, tell, player -> {
            PlayersGui playersGui = new OnlinePlayersGui(this, glc.getGuiLocale_worldToolsGui_selectPlayer());
            playersGui.setAction(offlinePlayer -> {
                player.sendMessage(glc.getAdminGuiWorldToolsGuiTellChatMessage("\"###\""));
                player.closeInventory();
                chatManager.setTask(player.getUniqueId(), (chatMessage, player1) -> {
                    if (chatMessage.equals("###")) {
                        player1.sendMessage(glc.getGuiLocale_adminGuiWorldToolsGui_tellChatCanceledMessage());
                        return true;
                    }
                    player.performCommand(watchtowergui.wg.manager.CommandsManager.getMCCommand("tell")
                            + " " + Bukkit.getOfflinePlayer(offlinePlayer).getName() + " "
                            + ChatColor.translateAlternateColorCodes('&', chatMessage));
                    return true;
                });
            });
            playersGui.open(player);
        });

        this.setItem(4, 2, worldBorder, player -> new WorldBorderGui(WorldToolsGui.this).open(player));

        this.setItem(8, 0, close, HumanEntity::closeInventory);
        this.setItem(8, 2, back, player -> {
            if (previousGui != null) {
                previousGui.open(player);
            }
        });
        this.autoFill(backGroundBlack);
    }
}
