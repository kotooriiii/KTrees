package me.kotooriiii;

import me.kotooriiii.events.SaplingGrowListener;
import me.kotooriiii.events.WorldStructureGrowListener;
import me.kotooriiii.files.FileSystem;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class KTreesMain extends JavaPlugin {

    public static Plugin plugin;
    public static Logger logger;
    public static PluginDescriptionFile pluginDescriptionFile;

    @Override
    public void onEnable() {

        //Console logger, plugin, and description file are all ready for public use
        logger = Logger.getLogger("Minecraft");
        plugin = this;
        pluginDescriptionFile = this.getDescription();

        //initialize file system
        FileSystem.init();

        //Registers the commands and events from this plugin
        registerCommands();
        registerEvents();

        //All was successfully enabled
        logger.info(pluginDescriptionFile.getName() + " has been successfully enabled on the server.");
    }

    @Override
    public void onDisable() {

        logger.info(pluginDescriptionFile.getName() + " has been successfully disabled on the server.");

        plugin = null;
        logger = null;
        pluginDescriptionFile = null;
    }


    public void registerCommands() {
      //  getCommand("calendar").setExecutor(new CalendarCommand());
    }

    public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new WorldStructureGrowListener(), this);
        pm.registerEvents(new SaplingGrowListener(), this);


       // pm.registerEvents(new NewDayListener(), this);
    }
}
