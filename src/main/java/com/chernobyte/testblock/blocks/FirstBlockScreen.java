package com.chernobyte.testblock.blocks;

import com.chernobyte.testblock.TestBlock;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FirstBlockScreen extends ContainerScreen<FirstBlockContainer>
{

    private ResourceLocation GUI = new ResourceLocation(TestBlock.MODID, "textures/gui/firstblock_gui.png");

    public FirstBlockScreen(FirstBlockContainer p_i51105_1_, PlayerInventory inv, ITextComponent name)
    {
        super(p_i51105_1_, inv, name);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
//        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
//        this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
//        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        //bind texture
        this.minecraft.getTextureManager().bindTexture(GUI);
        //keep aspect ratio of screen if window is resized
        int relX = (this.width  - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
