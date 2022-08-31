package net.jx.elixir.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CoconutMilkItem extends Item
{
    public CoconutMilkItem(Properties pProperties)
    {
        super(pProperties);
    }

    public UseAnim getUseAnimation(ItemStack pStack)
    {
        return UseAnim.DRINK;
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? itemstack : new ItemStack(ElixirItems.COCONUT_MEAT.get());
    }
}