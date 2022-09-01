package net.jx.elixir.world.feature;

import net.jx.elixir.block.ElixirBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ElixirConfiguredFeatures
{
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> PALM_TREE =
            FeatureUtils.register("palm", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ElixirBlocks.PALM_LOG.get()),
                    new StraightTrunkPlacer(12, 8, 4), BlockStateProvider.simple(ElixirBlocks.PALM_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> PALM_CHECKED = PlacementUtils.register("palm_checked", PALM_TREE, PlacementUtils.filteredByBlockSurvival(ElixirBlocks.PALM_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PALM_SPAWN =
            FeatureUtils.register("palm_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PALM_CHECKED, 0.5F)), PALM_CHECKED));
}