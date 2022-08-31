package net.jx.elixir.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.Map;

public class EnchantingOilItem extends Item
{
    public EnchantingOilItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if (pUsedHand.equals(InteractionHand.MAIN_HAND))
        {
            ItemStack thisItem = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
            ItemStack itemToEnchant = pPlayer.getItemInHand(InteractionHand.OFF_HAND);
            Enchantment enchantment = Enchantments.PIERCING;
            int enchantmentLevel = 2;
            if (itemToEnchant.canApplyAtEnchantingTable(enchantment))
            {
                Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemToEnchant);
                map.putIfAbsent(enchantment, enchantmentLevel);
                EnchantmentHelper.setEnchantments(map, itemToEnchant);
                pPlayer.setItemSlot(EquipmentSlot.OFFHAND, itemToEnchant);
                if (!pPlayer.getAbilities().instabuild)
                {
                    thisItem.shrink(1);
                }
            }
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
        }
        else
        {
            ItemStack thisItem = pPlayer.getItemInHand(InteractionHand.OFF_HAND);
            ItemStack itemToEnchant = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);
            Enchantment enchantment = Enchantments.PIERCING;
            int enchantmentLevel = 2;
            if (itemToEnchant.canApplyAtEnchantingTable(enchantment))
            {
                Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemToEnchant);
                map.putIfAbsent(enchantment, enchantmentLevel);
                EnchantmentHelper.setEnchantments(map, itemToEnchant);
                pPlayer.setItemSlot(EquipmentSlot.MAINHAND, itemToEnchant);
                if (!pPlayer.getAbilities().instabuild)
                {
                    thisItem.shrink(1);
                }
            }
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
        }
    }
}