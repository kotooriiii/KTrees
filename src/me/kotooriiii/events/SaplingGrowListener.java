package me.kotooriiii.events;

import me.kotooriiii.trees.KOakTree;
import me.kotooriiii.trees.KTree;
import me.kotooriiii.trees.KTreeBlueprint;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Sapling;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;

public class SaplingGrowListener implements Listener {

    @EventHandler
    public void onSaplingGrow(SaplingGrowEvent saplingGrowEvent)
    {
        Location location = saplingGrowEvent.getLocation();
        Material material = saplingGrowEvent.getMaterial();

        KTree tree = KTree.getTreeType(location, material);

        if(tree.hasTreeSpace())
        {
            KTreeBlueprint[] blueprints = tree.getBlueprints();
            Random random = new Random();
            int randomNumber = random.nextInt(blueprints.length);

            KTreeBlueprint blueprint = blueprints[randomNumber];

            tree.generate(blueprint);


        }
    }





}
