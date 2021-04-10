package watchtowergui.wg.fileManager.configsutils.configs;

import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;

import java.util.List;

public class BadWordsConfig extends ConfigAccessor {

    public final String path = "BadWords";

    public void init() {
        super.init("BadWordsConfig", "configuration/");
    }

    public List<String> getAllWordsFromConfig() {
        return getStringListPath(this.path + ".words");
    }
}
