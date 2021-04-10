package watchtowergui.wg.fileManager.configsutils;

import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigGenerator;
import watchtowergui.wg.logs.utils.LogsYmlGenerator;
import watchtowergui.wg.fileManager.configsutils.configs.*;

public class ConfigsManager {
    public LanguageConfig languageConfig;
    public MainConfig mainConfig;
    public DisabledCommandsForLogsConfig disabledCommandsForLogsConfig;
    public BadWordsConfig badWordsConfig;
    public GuiLanguageConfig guiLanguageConfig;
    public LogsYmlGenerator logsYmlGenerator;
    public ConfigGenerator configGenerator;

    public ConfigsManager() {
        this.configGenerator = new ConfigGenerator();
        this.logsYmlGenerator = new LogsYmlGenerator();
        this.guiLanguageConfig = new GuiLanguageConfig();
        this.languageConfig = new LanguageConfig();
        this.mainConfig = new MainConfig();
        this.badWordsConfig = new BadWordsConfig();
        this.disabledCommandsForLogsConfig = new DisabledCommandsForLogsConfig();
    }

    public void init() {
        this.configGenerator.init();
        this.logsYmlGenerator.init();
        this.guiLanguageConfig.init();
        this.languageConfig.init();
        this.mainConfig.init();
        this.badWordsConfig.init();
        this.disabledCommandsForLogsConfig.init();
    }

    public void saveAllConfigs() {
    }
}
