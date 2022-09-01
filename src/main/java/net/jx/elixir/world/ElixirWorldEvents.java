package net.jx.elixir.world;

import net.jx.elixir.Elixir;
import net.jx.elixir.world.gen.ElixirTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Elixir.MOD_ID)
public class ElixirWorldEvents
{
    @SubscribeEvent
    public static void biomeLoadingEvent(BiomeLoadingEvent event)
    {
        ElixirTreeGeneration.generateTrees(event);
    }
}