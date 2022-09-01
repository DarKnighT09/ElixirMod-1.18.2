package net.jx.elixir.block;

import net.jx.elixir.Elixir;
import net.jx.elixir.item.ElixirCreativeModeTab;
import net.jx.elixir.item.ElixirItems;
import net.jx.elixir.world.feature.tree.PalmTreeGrower;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ElixirBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Elixir.MOD_ID);

    public static final RegistryObject<Block> MORTAR_PESTLE = registerBlock("mortar_pestle", () -> new MortarPestleBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2F).requiresCorrectToolForDrops()), ElixirCreativeModeTab.ELIXIR_TAB);

    public static final RegistryObject<Block> DRAGON_SCALES = registerBlock("dragon_scales", () -> new Block(BlockBehaviour.Properties.of(Material.EGG).strength(5F).requiresCorrectToolForDrops()), ElixirCreativeModeTab.ELIXIR_TAB);

    public static final RegistryObject<Block> CLOVER_PATCH = registerBlock("clover_patch", () -> new CloverPatchBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)), ElixirCreativeModeTab.ELIXIR_TAB);
    //public static final RegistryObject<Block> POTTED_CLOVER = registerBlockWithoutItem("potted_clover", () -> new FlowerPotBlock(null, ElixirBlocks.CLOVER_PATCH, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> PALM_PLANKS = registerBlock("palm_planks", () -> new ElixirPlanksBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.QUARTZ).strength(2.0F, 3.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_SAPLING = registerBlock("palm_sapling", () -> new PalmTreeSaplingBlock(new PalmTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_LOG = registerBlock("palm_log", () -> new ElixirLogBlock(BlockBehaviour.Properties.of(Material.WOOD, (blockState) -> {
        return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.QUARTZ : MaterialColor.PODZOL;
    }).strength(2.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", () -> new ElixirLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.QUARTZ).strength(2.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_WOOD = registerBlock("palm_wood", () -> new ElixirLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood", () -> new ElixirLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.QUARTZ).strength(2.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_LEAVES = registerBlock("palm_leaves", () -> new ElixirLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_STAIRS = registerBlock("palm_stairs", () -> new StairBlock(() -> ElixirBlocks.PALM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ElixirBlocks.PALM_PLANKS.get())), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_DOOR = registerBlock("palm_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, ElixirBlocks.PALM_PLANKS.get().defaultMaterialColor()).strength(3.0F).sound(SoundType.WOOD).noOcclusion()), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, ElixirBlocks.PALM_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_FENCE = registerBlock("palm_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, ElixirBlocks.PALM_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_TRAPDOOR = registerBlock("palm_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, ElixirBlocks.PALM_PLANKS.get().defaultMaterialColor()).strength(3.0F).sound(SoundType.WOOD).noOcclusion()), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_FENCE_GATE = registerBlock("palm_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, ElixirBlocks.PALM_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_BUTTON = registerBlock("palm_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);
    public static final RegistryObject<Block> PALM_SLAB = registerBlock("palm_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, ElixirBlocks.PALM_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)), ElixirCreativeModeTab.ELIXIR_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> returnBlock = BLOCKS.register(name, block);
        registerBlockItem(name, returnBlock, tab);
        return returnBlock;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block)
    {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ElixirItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}