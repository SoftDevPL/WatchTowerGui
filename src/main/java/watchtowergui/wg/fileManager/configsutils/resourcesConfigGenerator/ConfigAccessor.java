package watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator;

import lombok.Getter;
import watchtowergui.wg.WatchTowerGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigAccessor {

    protected WatchTowerGui plugin;
    protected YamlConfiguration yml;
    private File file;

    public void init(String filename, String path) {
        this.initConfig(filename, path);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void initConfig(String filename, String path) {
        this.plugin = WatchTowerGui.getInstance();
        file = new File(this.plugin.getDataFolder(), path);
        file.mkdirs();
        file = new File(this.plugin.getDataFolder(), path + File.separator + filename + ".yml");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        yml = YamlConfiguration.loadConfiguration(file);
    }

    public boolean save(){
        try {
            this.yml.save(file);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public String getStringPath(String path) {
        if (yml == null) {
            return String.format(
                    "Sorry but |=> %s <=| or path: |=> %s <=| doesn't exists, Check if you have a literal mistake."
                    , file.getName()
                    , path);
        }
        String string = yml.getString(path);
        if (string == null) {
            Bukkit.getConsoleSender().sendMessage(WatchTowerGui.convertColors(
                    "&cSome config is incorrect, please check this path &f==> " + path + " <== &cor remove that config to return to defaults."));
            return "unknown";
        }
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public boolean getBooleanPath(String path) {
        if (yml == null) {
            return false;
        }
        return yml.getBoolean(path);
    }

    public int getIntPath(String path) {
        if (yml == null) {
            return 0;
        }
        return yml.getInt(path);
    }

    public List<String> getStringListPath(String path) {
        if (yml == null) {
            return new ArrayList<>();
        }
        return yml.getStringList(path);
    }

}
