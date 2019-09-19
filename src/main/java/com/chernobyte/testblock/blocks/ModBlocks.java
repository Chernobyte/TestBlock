package com.chernobyte.testblock.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
    @ObjectHolder("testblock:firstblock")
    public static FirstBlock FIRSTBLOCK;

    @ObjectHolder("testblock:firstblock")
    public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;
}
