package me.kotooriiii.trees;

import org.bukkit.Location;
import org.bukkit.Material;

public class KDarkOakTree extends KTree {

    public KDarkOakTree(Location saplingLocation, Material saplingType) {
        super(saplingLocation, saplingType);
    }

    @Override
    public boolean hasTreeSpace() {
        return false;
    }

    @Override
    public KTreeBlueprint[] getBlueprints() {
        return new KTreeBlueprint[0];
    }
}
