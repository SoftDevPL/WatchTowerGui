package watchtowergui.wg.fileManager.configsutils.configs.models;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

@ConfSerializable
public class MainConfigModel implements ConfigurationSerializable {
    private int countOfTries;
    private int cooldown;
    private boolean allowBadWords;
    private int countOfTriesToBan;
    private String banTime;

    public MainConfigModel(Map<String, Object> map){
        this.countOfTries = (int) map.get("countOfTries");
        this.cooldown = (int) map.get("cooldown");
        this.allowBadWords = (boolean) map.get("allowBadWords");
        this.countOfTriesToBan = (int) map.get("countOfTriesToBan");
        this.banTime = (String) map.get("banTime");
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> mapped = new HashMap<>();
        mapped.put("countOfTries", countOfTries);
        mapped.put("cooldown", cooldown);
        mapped.put("allowBadWords", allowBadWords);
        mapped.put("countOfTriesToBan", countOfTriesToBan);
        mapped.put("banTime", banTime);
        return mapped;
    }

    public static MainConfigModel deserialize(Map<String, Object> map){
        return new MainConfigModel(map);
    }

}
