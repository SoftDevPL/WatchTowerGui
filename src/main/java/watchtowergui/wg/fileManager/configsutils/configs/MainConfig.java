package watchtowergui.wg.fileManager.configsutils.configs;

import app.annotations.ConfigYml;
import lombok.ToString;
import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;
import java.util.Map;

@ConfigYml
@ToString
public class MainConfig extends ConfigAccessor {

    int countOfTries = 4;
    int cooldown = 3;
    boolean allowBadWords = false;
    int countOfTriesToBan = 3;
    String banTime = "%S10 %Mi0 %H0 %D0 %W0 %Mo0 %Y0";

    public void init() {
        super.init("Config", "configuration");
        this.yml.addDefaults(this.serialize());
        this.yml.options().copyDefaults(true);
        this.save();
        watchtowergui.wg.fileManager.configsutils.configs.MainConfigSerializator
                .injectTo(this, this.yml.getConfigurationSection("").getValues(true));
        System.out.println(this);
    }

    public int getCountOfTriesToBan() {
        return countOfTriesToBan;
    }

    public String getBanTime() {
        return banTime;
    }

    public boolean getAllowedBadWords() {
        return this.allowBadWords;
    }

    public int getCountOfTries() {
        return this.countOfTries;
    }

    public int getCountdown() {
        return this.cooldown;
    }

    public Map<String, Object> serialize(){
        return watchtowergui.wg.fileManager.configsutils.configs.MainConfigSerializator.serialize(this);
    }

    public static MainConfig deserialize(Map<String, Object> map){
        return watchtowergui.wg.fileManager.configsutils.configs.MainConfigSerializator.deserialize(map);
    }
}
