package me.kotooriiii.events;

import org.bukkit.Bukkit;
import org.bukkit.TreeType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.StructureGrowEvent;

public class WorldStructureGrowListener implements Listener {

    @EventHandler
    public void onStructureGrowth(StructureGrowEvent structureGrowEvent)
    {

        if(TreeType.TREE.equals(structureGrowEvent.getSpecies()))
        {
            Bukkit.broadcastMessage("This is a tree.");
        }

        Bukkit.broadcastMessage(String.valueOf(TreeType.values()));
    }
}
