package watchtowergui.wg.fileManager.configsutils.resourcesConfigGenerator;

import watchtowergui.wg.WatchTowerGui;
import com.google.common.base.Charsets;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ConfigGenerator {

    public WatchTowerGui pluginInstance;

    public void init() {
        this.pluginInstance = WatchTowerGui.getInstance();
       // generateAllConfigs("locale");
        generateAllConfigs("configuration");
    }

    private List<String> getAllFilesFromConfigFolder(File configsFolder) {
        List<String> fileListNames = new ArrayList<>();
        if (configsFolder.exists()) {
            for (File file : configsFolder.listFiles()) {
                fileListNames.add(file.getName());
            }
        }
        return fileListNames;
    }

    private void generateAllConfigs(String path) {
        File configsFolder = new File(this.pluginInstance.getDataFolder() + "/" + path);
        List<String> fileListNames = getAllFilesFromConfigFolder(configsFolder);
        CodeSource src = this.pluginInstance.getClass().getProtectionDomain().getCodeSource();
        if (src != null) {
            URL jar = src.getLocation();
            ZipInputStream zip = null;
            try {
                zip = new ZipInputStream(jar.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                ZipEntry e = null;
                try {
                    assert zip != null;
                    e = zip.getNextEntry();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (e == null)
                    break;
                String name = e.getName();
                if (name.startsWith(path + "/")) {
                    String[] separatedWords = name.split("/", 2);
                    if (!separatedWords[1].equals("")) {
                        if (!fileListNames.contains(separatedWords[1])) {
                            this.pluginInstance.saveResource(path + "/" + separatedWords[1], false);
                        } else {
                            if (configsFolder.exists()) {
                                File file = new File(configsFolder + "/" + separatedWords[1]);
                                reloadConfig(file.getName(), file, path);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Config source is null!");
        }
    }

    private void reloadConfig(String fileName, File configFile, String path) {
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(configFile);
        InputStream defConfigStream = this.pluginInstance.getResource(path + "/" + fileName);
        if (defConfigStream != null) {
            yml.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        }
    }
}
