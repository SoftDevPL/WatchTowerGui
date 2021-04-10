package watchtowergui.wg.fileManager.configsutils.configs;

import watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator.ConfigAccessor;

public class MainConfig extends ConfigAccessor {

    public String path = "Configurations" + ".";
    private int countOfTries;
    private int cooldown;
    private boolean allowBadWords;
    private int countOfTriesToBan;
    private String banTime;

    public void init() {
        super.init("MainConfig", "configuration/");
        this.countOfTriesToBan = getIntPath(path + "chat.spamming.countOfTriesToBan");
        this.banTime = getStringPath(path + "chat.spamming.banTime");
        this.countOfTries = getIntPath(path + "chat.spamming.countOfTries");
        this.cooldown = getIntPath(path + "chat.spamming.cooldown");
        this.allowBadWords = getBooleanPath(path + "chat.allowBadWords");
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
}
