package com.chernobyte.testblock.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class FirstBlock extends DirectionalBlock {

    public static final BooleanProperty POWERED;

    public FirstBlock() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
                .lightValue(14)
        );
        setRegistryName("firstblock");
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateContainer.getBaseState()).with(FACING, Direction.SOUTH)).with(POWERED, false));
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new FirstBlockTile();
    }

//    @Override
//    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack)
//    {
//        if(entity != null)
//        {
//            world.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
//        }
//    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return (BlockState)this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
    }

    public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity)
    {
        return Direction.getFacingFromVector((float) (entity.posX - clickedBlock.getX()), (float) (entity.posY - clickedBlock.getY()), (float) (entity.posZ - clickedBlock.getZ()));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        super.fillStateContainer(builder);
        builder.add(new IProperty[]{FACING, POWERED});
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result)
    {
        if(!world.isRemote)
        {
            TileEntity tileEntity = world.getTileEntity(pos);
            if(tileEntity instanceof INamedContainerProvider)
            {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            }
        }
        return super.onBlockActivated(state, world, pos, player, hand, result);
    }

    static
    {
        POWERED = BlockStateProperties.POWERED;
    }
}
