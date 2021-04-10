package watchtowergui.wg.adminfun.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.examples.OnlinePlayersGui;
import ad.guis.ultimateguis.examples.PlayersGui;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.chat.chatguard.ChatManager;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;
import watchtowergui.wg.managers.CommandsManager;
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
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getAdminGuiWorldToolsGuiWorldToolsGuiPageName(), previousGui);
        this.watchTowerGui = WatchTowerGui.getInstance();
        glc = watchTowerGui.configsManager.guiLanguageConfig;
        chatManager = watchTowerGui.listenersManager.chatManager;
        setupGuiItems();
        init();
    }

    private void setupGuiItems() {
        if (!initFirstTime) return;
        initFirstTime = false;
        close = BasicGui.createItem(Material.BARRIER, glc.getAdminGuiClose());
        back = BasicGui.createItem(Material.ARROW, glc.getAdminGuiBack());
        backGroundBlack = BasicGui.createBackground(Colors.BLACK);
        defaultGamemode = BasicGui.createItem(
                Material.HOPPER,
                glc.getAdminGuiWorldToolsGuiDefaultGamemodeName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiDefaultGamemodeLore(), 25));
        difficulty = BasicGui.createItem(
                Material.CHEST,
                glc.getAdminGuiWorldToolsGuiWorldDifficultyName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiWorldDifficultyLore(), 25));
        gamemode = BasicGui.createItem(
                Material.ANVIL,
                glc.getAdminGuiWorldToolsGuiGamemodeName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiGamemodeLore(), 25));
        reload = BasicGui.createItem(
                Material.LEVER,
                glc.getAdminGuiWorldToolsGuiReloadName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiReloadLore(), 25));
        say = BasicGui.createItem(
                Material.PAPER,
                glc.getAdminGuiWorldToolsGuiSayName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiSayLore(), 25));
        seed = BasicGui.createItem(
                Material.GRASS,
                glc.getAdminGuiWorldToolsGuiSeedName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiSeedLore(), 25));
        setWorldSpawn = BasicGui.createItem(
                Material.BEDROCK,
                glc.getAdminGuiWorldToolsGuiSetWorldSpawnName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiSetWorldSpawnLore(), 25));
        spawnPoint = BasicGui.createItem(
                Material.COMPASS,
                glc.getAdminGuiWorldToolsGuiSpawnPointName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiSpawnPointLore(), 25));
        time = BasicGui.createItem(
                Material.WATCH,
                glc.getAdminGuiWorldToolsGuiTimeName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiTimeLore(), 25));
        weather = BasicGui.createItem(
                Material.WATER_LILY,
                glc.getAdminGuiWorldToolsGuiWeatherName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiWeatherLore(), 25));
        worldBorder = BasicGui.createItem(
                Material.IRON_BARDING,
                glc.getAdminGuiWorldToolsGuiWorldBorderName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiWorldBorderLore(), 25));
        xp = BasicGui.createItem(
                Material.EXP_BOTTLE,
                glc.getAdminGuiWorldToolsGuiXpName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiXpLore(), 25));
        title = BasicGui.createItem(
                Material.JACK_O_LANTERN,
                glc.getAdminGuiWorldToolsGuiTitleName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiTitleLore(), 25));
        tell = BasicGui.createItem(
                Material.ENDER_PEARL,
                glc.getAdminGuiWorldToolsGuiTellName(),
                BasicGui.splitLore(glc.getAdminGuiWorldToolsGuiTellLore(), 25));
    }

    protected void init() {
        this.setItem(2, 0, defaultGamemode, player -> new DefaultGamemodeGui(WorldToolsGui.this).open(player));

        this.setItem(2, 1, difficulty, player -> new DifficultyGui(WorldToolsGui.this).open(player));
        this.setItem(2, 2, gamemode, player -> new GamemodeGui(WorldToolsGui.this).open(player));

        this.setItem(3, 0, reload,
                player -> player.performCommand(CommandsManager.getAnyCommand("bukkit:reload")));
        this.setItem(3, 1, say, player -> {
            player.closeInventory();
            player.sendMessage(glc.getAdminGuiWorldToolsGuiEnterMessageInChat());
            chatManager.setTask(player.getUniqueId(), (chatMessage, chatPlayer) -> {
                chatPlayer.performCommand(CommandsManager.getMCCommand("say") + " " + chatMessage);
                new WorldToolsGui(WorldToolsGui.this).open(chatPlayer);
                return true;
            });
        });
        this.setItem(3, 2, seed,
                player -> player.performCommand(CommandsManager.getMCCommand("seed")));

        this.setItem(4, 0, setWorldSpawn,
                player -> player.performCommand(CommandsManager.getMCCommand("setworldspawn")));

        this.setItem(5, 0, spawnPoint,
                player -> player.performCommand(CommandsManager.getMCCommand("setspawnpoint")));
        this.setItem(5, 1, time, player -> new TimeGui(WorldToolsGui.this).open(player));
        this.setItem(5, 2, weather, player -> new WeatherGui(WorldToolsGui.this).open(player));

        this.setItem(6, 0, xp, player -> {
            PlayersGui playersGui = new OnlinePlayersGui(this, glc.getWorldToolsGuiSelectPlayer());
            playersGui.setAction(offlinePlayer -> {
                player.sendMessage(glc.getAdminGuiWorldToolsGuiXpChatMessage("\"###\""));
                player.closeInventory();
                chatManager.setTask(player.getUniqueId(), (chatMessage, player1) -> {
                    if (chatMessage.equals("###")) {
                        player1.sendMessage(glc.getAdminGuiWorldToolsGuiXpChatCanceledMessage());
                        return true;
                    }
                    player1.performCommand(CommandsManager.getMCCommand("xp")
                            + " " + chatMessage + "L " + Bukkit.getOfflinePlayer(offlinePlayer).getName());
                    return true;
                });
            });
            playersGui.open(player);
        });
        this.setItem(6, 1, title, player -> {
            PlayersGui playersGui = new OnlinePlayersGui(this, glc.getWorldToolsGuiSelectPlayer());
            playersGui.setAction(offlinePlayer -> {
                player.sendMessage(glc.getAdminGuiWorldToolsGuiTitleChatMessage("\"###\""));
                player.closeInventory();
                chatManager.setTask(player.getUniqueId(), (chatMessage, player1) -> {
                    if (chatMessage.equals("###")) {
                        player1.sendMessage(glc.getAdminGuiWorldToolsGuiTitleChatCanceledMessage());
                        return true;
                    }
                    Player onlinePlayer = Bukkit.getPlayer(offlinePlayer);
                    if (onlinePlayer == null) {
                        player.sendMessage(WatchTowerGui.getInstance().configsManager.languageConfig.getPlayerIsOffline());
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
            PlayersGui playersGui = new OnlinePlayersGui(this, glc.getWorldToolsGuiSelectPlayer());
            playersGui.setAction(offlinePlayer -> {
                player.sendMessage(glc.getAdminGuiWorldToolsGuiTellChatMessage("\"###\""));
                player.closeInventory();
                chatManager.setTask(player.getUniqueId(), (chatMessage, player1) -> {
                    if (chatMessage.equals("###")) {
                        player1.sendMessage(glc.getAdminGuiWorldToolsGuiTellChatCanceledMessage());
                        return true;
                    }
                    player.performCommand(CommandsManager.getMCCommand("tell")
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
