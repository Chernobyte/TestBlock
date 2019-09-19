package com.chernobyte.testblock.blocks;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class FirstBlockScreen extends ContainerScreen<FirstBlockContainer>
{
    public FirstBlockScreen(FirstBlockContainer p_i51105_1_, PlayerInventory inv, ITextComponent name)
    {
        super(p_i51105_1_, inv, name);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {

    }
}
