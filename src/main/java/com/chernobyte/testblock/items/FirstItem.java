package com.chernobyte.testblock.items;

import com.chernobyte.testblock.TestBlock;
import net.minecraft.item.Item;

public class FirstItem extends Item
{
    public FirstItem()
    {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(TestBlock.setup.itemGroup));
        setRegistryName("firstitem");
    }
}
