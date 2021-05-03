package watchtowergui.wg.fileManager.configsutils.configs;

import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;

import java.util.List;

public class DisabledCommandsForLogsConfig extends ConfigAccessor {

    public final String path = "Commands_excluded_from_logs";
    private String commandExcludeResponse;

    public void init() {
        super.init("CommandsConfig", "configuration");
        this.commandExcludeResponse = getStringPath(this.path + ".command_exclude_response");
    }

    public String getCommandExcludeResponse() {
        return commandExcludeResponse;
    }

    public List<String> getAllWordsFromConfig() {
        return getStringListPath(this.path + ".commands");
    }
}
