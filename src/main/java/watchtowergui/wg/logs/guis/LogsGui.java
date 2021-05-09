package watchtowergui.wg.logs.guis;

import ad.guis.ultimateguis.Colors;
import ad.guis.ultimateguis.engine.basics.BasicGui;
import ad.guis.ultimateguis.examples.PlayersGui;
import ad.guis.ultimateguis.examples.calendargui.CalendarGui;
import ad.guis.ultimateguis.examples.calendargui.SpecialDate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import watchtowergui.wg.WatchTowerGui;
import watchtowergui.wg.fileManager.configsutils.configs.GuiLanguageConfig;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LogsGui extends BasicGui {

    public final static int ONE_DAY = 0;
    public final static int MULTI_DAY = 1;
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final GuiLanguageConfig glc;
    private int timeRange = ONE_DAY;

    public LogsGui(int timeRange, BasicGui previousGui) {
        super(3, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_logsGui_title(), previousGui);
        glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;
        this.timeRange = timeRange;
        init();
    }

    public LogsGui(int timeRange) {
        this(timeRange, null);
    }

    public LogsGui() {
        this(ONE_DAY);
    }

    public static CalendarGui logsOneDay(BasicGui previousGui) {
        return new CalendarGui(YearMonth.now(), (date, player, cGui) -> {
            player.performCommand("glday " + format.format(date));
            player.closeInventory();
        }, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_calendarGui_title(), previousGui);
    }

    public static CalendarGui logsOneDayForPlayer(String playerName, BasicGui previousGui) {
        return new CalendarGui(YearMonth.now(), (date, player, cGui) -> {
            player.performCommand("gluday " + playerName + " " + format.format(date));
            player.closeInventory();

        }, WatchTowerGui.getInstance().configsManager.guiLanguageConfig.getGuiLocale_calendarGui_title(), previousGui);
    }

    public static CalendarGui logsManyDays(BasicGui previousGui) {
        return logsManyDaysCommand(previousGui, "gldate ### 00:00:00 " +
                "### 00:00:00");
    }

    public static CalendarGui logsManyDaysForPlayer(String playerName, BasicGui previousGui) {
        return logsManyDaysCommand(previousGui, "gludate " + playerName + " ### 00:00:00 " +
                "### 00:00:00");
    }

    private static CalendarGui logsManyDaysCommand(BasicGui previousGui, String command) {
        GuiLanguageConfig glc = WatchTowerGui.getInstance().configsManager.guiLanguageConfig;

        return new CalendarGui(YearMonth.now(), (firstDate, player1, cGui) -> {
            CalendarGui secCalendarGui = new CalendarGui(YearMonth.from(firstDate), (secondDate, player2, cGui2) -> {
            },
                    glc.getGuiLocale_calendarGui_secondCalendarGuiTitle(), previousGui);

            secCalendarGui.setCalendarGuiAction((secondDate, player, cGui3) -> {
                if (secondDate.equals(firstDate)) return;
                cGui3.setSecondSpecialDate(new SpecialDate(secondDate, glc.getGuiLocale_calendarGui_endDate()));
                cGui3.setAcceptAction(player3 -> {
                    player3.performCommand(command.replaceFirst("###", format.format(firstDate)).
                            replaceFirst("###", format.format(secondDate)));
                    player3.closeInventory();
                });
            });

            secCalendarGui.setFirstSpecialDate(new SpecialDate(firstDate, glc.getGuiLocale_calendarGui_firstDate()));
            secCalendarGui.open(player1);

        }, glc.getGuiLocale_calendarGui_firstCalendarGuiTitle(), previousGui);
    }

    protected void init() {
        ItemStack exit = createItem(Material.BARRIER, glc.getGuiLocale_adminGui_close());
        ItemStack back = createItem(Material.WOOD_DOOR, glc.getGuiLocale_adminGui_back());
        ItemStack forAllPlayer = createItem(Material.NETHER_STAR, glc.getGuiLocale_logsGui_logsForAll());
        ItemStack forOnePlayer = createItem(Material.SKULL_ITEM, glc.getGuiLocale_logsGui_logsForOnePlayer());
        ItemStack backgroundWhite = createBackground(Colors.WHITE);
        ItemStack backgroundBlack = createBackground(Colors.BLACK);

        this.setItem(2, 1, forAllPlayer, player -> {
            CalendarGui calendarGui;
            if (timeRange == 0) {
                calendarGui = logsOneDay(LogsGui.this);
            } else {
                calendarGui = logsManyDays(LogsGui.this);
            }
            calendarGui.open(player);
        });

        this.setItem(5, 1, forOnePlayer, player -> {
            PlayersGui playersGui = new PlayersGui(offlinePlayer -> {
                String name = Bukkit.getOfflinePlayer(offlinePlayer).getName();
                CalendarGui calendarGui;
                if (timeRange == ONE_DAY) {
                    calendarGui = logsOneDayForPlayer(name, LogsGui.this);
                } else {
                    calendarGui = logsManyDaysForPlayer(name, LogsGui.this);
                }
                calendarGui.open(player);

            }, () -> Arrays.stream(Bukkit.getOfflinePlayers()).map(OfflinePlayer::getUniqueId).collect(Collectors.toList())
                    , this, glc.getGuiLocale_logsGui_selectPlayer());
            playersGui.open(player);
        });

        this.setItem(7, 1, back, player -> {
            if (previousGui != null) previousGui.open(player);
        });
        this.setItem(8, 1, exit, HumanEntity::closeInventory);

        this.autoFill(backgroundWhite, backgroundBlack);
    }

    public void setTimeRange(int timeRange) {
        this.timeRange = timeRange;
    }
}
