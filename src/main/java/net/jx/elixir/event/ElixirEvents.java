package net.jx.elixir.event;

import net.jx.elixir.Elixir;
import net.jx.elixir.item.ElixirItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixir.MOD_ID)
public class ElixirEvents
{
    @SubscribeEvent
    public static void dolphinTest (LivingEquipmentChangeEvent event)
    {
        if (event.getEntityLiving() instanceof Dolphin)
        {
            if (event.getSlot().equals(EquipmentSlot.MAINHAND))
            {
                if (event.getFrom().isEmpty() && event.getTo().is(ElixirItems.DRAGON_SCALE.get()))
                {
                    if (event.getEntityLiving().getRandom().nextFloat() < 0.15F)
                    {
                        int amount = event.getTo().getCount();
                        ItemStack convertedItem = new ItemStack(Items.DIAMOND_BLOCK, amount);
                        event.getEntityLiving().setItemSlot(EquipmentSlot.MAINHAND, convertedItem);
                    }
                }
            }
        }
    }
}