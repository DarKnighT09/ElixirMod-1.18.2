package net.jx.elixir;

import com.mojang.logging.LogUtils;
import net.jx.elixir.block.ElixirBlocks;
import net.jx.elixir.item.ElixirItems;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Elixir.MOD_ID)
public class Elixir
{
    public static final String MOD_ID = "elixir";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Elixir()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ElixirBlocks.register(eventBus);
        ElixirItems.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::registerBlockColors);
        eventBus.addListener(this::registerItemColors);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ElixirBlocks.CLOVER_PATCH.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(ElixirBlocks.POTTED_CLOVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ElixirBlocks.PALM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ElixirBlocks.PALM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ElixirBlocks.PALM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ElixirBlocks.PALM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ElixirBlocks.PALM_LEAVES.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        /*event.enqueueWork(() -> {
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ElixirBlocks.CLOVER_PATCH.getId(), ElixirBlocks.POTTED_CLOVER);
        });*/
    }

    public void registerBlockColors(final ColorHandlerEvent.Block event)
    {
        event.getBlockColors().register((blockState, level, blockPos, tintIndex) -> {
            return level != null && blockPos != null ? BiomeColors.getAverageFoliageColor(level, blockPos) : FoliageColor.getDefaultColor();
        }, ElixirBlocks.PALM_LEAVES.get());
        System.out.println("Register Block Colors");
    }

    public void registerItemColors(final ColorHandlerEvent.Item event)
    {
        event.getItemColors().register((p_92687_, p_92688_) -> {
            BlockState blockstate = ((BlockItem)p_92687_.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, p_92688_);
        }, ElixirBlocks.PALM_LEAVES.get());
        System.out.println("Register Item Colors");
    }
}