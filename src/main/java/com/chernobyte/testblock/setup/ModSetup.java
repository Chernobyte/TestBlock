package com.chernobyte.testblock.setup;

import com.chernobyte.testblock.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("testblock")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.FIRSTBLOCK);
        }
    };

    public void init()
    {

    }
}
