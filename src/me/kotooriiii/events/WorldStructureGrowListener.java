package me.kotooriiii.events;

import me.kotooriiii.files.FileSystem;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Sapling;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WorldStructureGrowListener implements Listener {

    @EventHandler
    public void onStructureGrowth(StructureGrowEvent structureGrowEvent) {

        // The location with a potential sapling
        Location saplingLocation = structureGrowEvent.getLocation();
        //The material of the sapling.
        Material saplingType = getSaplingType(saplingLocation);

        //If it's not a sapling type, then return and do no custom event behavior.
        if(saplingType.equals(Material.AIR))
        {
            return;
        } else {
            //if it's a sapling, cancel the growth of the tree!
            Sapling sapling = (Sapling) saplingLocation.getBlock().getBlockData();

            if(sapling.getMaximumStage() == sapling.getStage())
            {
                structureGrowEvent.setCancelled(true);
                saplingLocation.getBlock().setBlockData(sapling);
                SaplingGrowEvent saplingGrowEvent = new SaplingGrowEvent(saplingLocation, saplingType);
                Bukkit.getPluginManager().callEvent(saplingGrowEvent);
            }
        }

        //Call the event and pass location and material type.

    }

    public Material getSaplingType(Location saplingLocation) {

        //Block location of where the supposed sapling is
        Block block = saplingLocation.getBlock();
        //All properties of the block in string format since Block#getType() was returning a legacy sapling.
        String rawBlockProperties = String.valueOf(block);
        //All properties in an array based on commas.
        String[] blockProperties = rawBlockProperties.split(",");
        //Sapling type. for example: sapling | dark oak | jungle | etc excluding chorus plants and mushrooms
        String saplingType = "";

        //Loop all block properties
        for (String blockProperty : blockProperties) {
            //Look for the block type
            if (blockProperty.startsWith("type=")) {
                //Replace the data that is not needed
                saplingType = blockProperty.replace("type=", "");
                break;
            }
        }

        //This variable will hold the material type of that sapling.
        Material saplingMaterialType;

        //Converts the string format based sapling into a Material object.
        switch (saplingType) {
            case "OAK_SAPLING":
                saplingMaterialType = Material.OAK_SAPLING;
                break;
            case "SPRUCE_SAPLING":
                saplingMaterialType = Material.SPRUCE_SAPLING;
                break;
            case "JUNGLE_SAPLING":
                saplingMaterialType = Material.JUNGLE_SAPLING;
                break;
            case "ACACIA_SAPLING":
                saplingMaterialType = Material.ACACIA_SAPLING;
                break;
            case "BIRCH_SAPLING":
                saplingMaterialType = Material.BIRCH_SAPLING;
                break;
            case "DARK_OAK_SAPLING":
                saplingMaterialType = Material.DARK_OAK_SAPLING;
                break;
            default:
                //Creates a new error file due to unrecognizable sapling.
                try {
                    int size = FileSystem.getErrorFolder().listFiles().length;
                    File errorFile = new File(FileSystem.getErrorFolder() + "/error-log-" + size + ".txt");

                    if (errorFile.exists())
                        errorFile.delete();

                    PrintWriter pw = new PrintWriter(errorFile);

                    pw.println("Error: \n\n" + String.valueOf(block) + "\n|\n----> was not recognized by its location as a sapling. Inform developer for a potential fix.");
                    pw.close();

                    errorFile.createNewFile();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                saplingMaterialType = Material.AIR; // <--- Material.AIR will be used to show error!
                break;
        }

        return saplingMaterialType;
    }

}
