package net.jx.elixir.world.feature;

import net.jx.elixir.block.ElixirBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ElixirPlacedFeatures
{
    public static final Holder<PlacedFeature> PALM_PLACED = PlacementUtils.register("palm_placed", ElixirConfiguredFeatures.PALM_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25F, 1)));

}