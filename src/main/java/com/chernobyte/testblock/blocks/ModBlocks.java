package com.chernobyte.testblock.blocks;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
    @ObjectHolder("testblock:firstblock")
    public static FirstBlock FIRSTBLOCK;

    @ObjectHolder("testblock:firstblock")
    public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;

    @ObjectHolder("testblock:firstblock")
    public static ContainerType<FirstBlockContainer> FIRSTBLOCK_CONTAINER;
}
