package net.jx.elixir.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ElixirCreativeModeTab
{
    public static final CreativeModeTab ELIXIR_TAB = new CreativeModeTab("elixir_tab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ElixirItems.DRAGON_SCALE.get());
        }
    };
}