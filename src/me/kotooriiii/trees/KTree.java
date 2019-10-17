package me.kotooriiii.trees;

import org.bukkit.Location;
import org.bukkit.Material;

public abstract class KTree {

    private Location saplingLocation;
    private Material saplingType;

    public KTree(Location saplingLocation, Material saplingType) {
        this.saplingLocation = saplingLocation;
        this.saplingType = saplingType;
    }

    public abstract boolean hasTreeSpace();

    public abstract KTreeBlueprint[] getBlueprints();

    public void generate(KTreeBlueprint blueprint) {
        //todo
    }

    public Location getSaplingLocation() {
        return saplingLocation;
    }

    public Material getSaplingType() {
        return saplingType;
    }

    public static KTree getTreeType(Location saplingLocation, Material saplingType) {
        switch (saplingType) {
            case OAK_SAPLING:
                return new KOakTree(saplingLocation, saplingType);
            case SPRUCE_SAPLING:
                return new KSpruceTree(saplingLocation, saplingType);
            case BIRCH_SAPLING:
                return new KBirchTree(saplingLocation, saplingType);
            case JUNGLE_SAPLING:
                return new KJungleTree(saplingLocation, saplingType);
            case DARK_OAK_SAPLING:
                return new KDarkOakTree(saplingLocation, saplingType);
            case ACACIA_SAPLING:
                return new KAcaciaTree(saplingLocation, saplingType);
        }
        return null;
    }
}
