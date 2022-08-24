package net.jx.elixir.item;

import net.jx.elixir.Elixir;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElixirItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Elixir.MOD_ID);

    public static final RegistryObject<Item> DRAGON_SCALE = ITEMS.register("dragon_scale", () -> new Item(new Item.Properties().tab(ElixirCreativeModeTab.ELIXIR_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}