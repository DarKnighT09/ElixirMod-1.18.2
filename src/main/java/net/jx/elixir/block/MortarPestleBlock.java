package net.jx.elixir.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MortarPestleBlock extends Block
{
    public MortarPestleBlock(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit)
    {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item resultItem = Items.BONE_MEAL;
        ItemStack resultItemStack = new ItemStack(resultItem, 6);
        if (itemstack.is(Items.BONE))
        {
            itemstack.shrink(1);
            if (itemstack.isEmpty())
            {
                pPlayer.setItemInHand(pHand, resultItemStack);
            } else if (!pPlayer.getInventory().add(resultItemStack))
            {
                pPlayer.drop(resultItemStack, false);
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}