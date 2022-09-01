package net.jx.elixir.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class CloverPatchBlock extends BushBlock implements BonemealableBlock
{
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);

    protected CloverPatchBlock(Properties pProperties)
    {
        super(pProperties);
    }

    public VoxelShape getShape(BlockState p_152917_, BlockGetter p_152918_, BlockPos p_152919_, CollisionContext p_152920_) {
        return SHAPE;
    }

    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific direction passed in.
     */
    public BlockState updateShape(BlockState p_152926_, Direction p_152927_, BlockState p_152928_, LevelAccessor p_152929_, BlockPos p_152930_, BlockPos p_152931_) {
        return !p_152926_.canSurvive(p_152929_, p_152930_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_152926_, p_152927_, p_152928_, p_152929_, p_152930_, p_152931_);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient)
    {
        return pLevel.getBlockState(pPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, Random pRandom, BlockPos pPos, BlockState pState)
    {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, Random pRandom, BlockPos pPos, BlockState pState)
    {
        boolean flag = false;
        for(BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-1, 0, -1), pPos.offset(1, 0, 1)))
        {
            if (pLevel.isEmptyBlock(blockpos) && pState.canSurvive(pLevel, blockpos))
            {
                flag = true;
                pLevel.setBlock(blockpos, pState, 2);
            }

            if (flag)
            {
                return;
            }
        }
    }
}