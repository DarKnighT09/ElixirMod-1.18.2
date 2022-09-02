package net.jx.elixir.item;

import net.jx.elixir.Elixir;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElixirItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Elixir.MOD_ID);

    public static final RegistryObject<Item> DRAGON_SCALE = ITEMS.register("dragon_scale", () -> new Item(new Item.Properties().tab(ElixirCreativeModeTab.ELIXIR_TAB)));

    public static final RegistryObject<Item> ENCHANTING_OIL = ITEMS.register("enchanting_oil", () -> new EnchantingOilItem(new Item.Properties().stacksTo(1).tab(ElixirCreativeModeTab.ELIXIR_TAB)));

    public static final RegistryObject<Item> CLOVER = ITEMS.register("clover", () -> new Item(new Item.Properties().tab(ElixirCreativeModeTab.ELIXIR_TAB)));
    public static final RegistryObject<Item> FOUR_LEAF_CLOVER = ITEMS.register("four_leaf_clover", () -> new Item(new Item.Properties().tab(ElixirCreativeModeTab.ELIXIR_TAB)));

    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut", () -> new Item(new Item.Properties().tab(ElixirCreativeModeTab.ELIXIR_TAB)));
    public static final RegistryObject<Item> COCONUT_MEAT = ITEMS.register("coconut_meat", () -> new Item(new Item.Properties().tab(ElixirCreativeModeTab.ELIXIR_TAB).food(ElixirFoods.COCONUT_MEAT)));
    public static final RegistryObject<Item> COCONUT_MILK = ITEMS.register("coconut_milk", () -> new CoconutMilkItem(new Item.Properties().stacksTo(1).tab(ElixirCreativeModeTab.ELIXIR_TAB).food(ElixirFoods.COCONUT_MILK)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}