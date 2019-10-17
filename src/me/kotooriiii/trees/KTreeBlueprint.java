package me.kotooriiii.trees;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;

public class KTreeBlueprint {

    ArrayList<Block> blocks;

    public KTreeBlueprint(ArrayList<Block> blocks)
    {
        this.blocks = blocks;
    }

    private void reduce()
    {
        for(Block block : blocks)
        {
            if(block.getType().equals(Material.AIR))
            {
                blocks.remove(block);
            }
        }
    }

    private void isBlockOccupied()
    {

    }


}
