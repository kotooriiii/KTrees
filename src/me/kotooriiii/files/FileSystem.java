package me.kotooriiii.files;

import me.kotooriiii.KTreesMain;

import java.io.File;

public class FileSystem {

    private static File pluginFolder;
    private static File errorFolder;
    private static File configFolder;

    public static void init()
    {
         pluginFolder = KTreesMain.plugin.getDataFolder();
        if(!pluginFolder.exists())
            pluginFolder.mkdir();

         errorFolder = new File(pluginFolder + "/error");
        if(!errorFolder.exists())
            errorFolder.mkdir();

         configFolder = new File(pluginFolder + "/config");
        if(!configFolder.exists())
            configFolder.mkdir();
    }

    public static File getPluginFolder()
    {
        return pluginFolder;
    }

    public static File getErrorFolder()
    {
        return errorFolder;
    }

    public static File getConfigFolder()
    {
        return configFolder;
    }

}
