package net.jx.elixir.world.feature.tree;

import net.jx.elixir.world.feature.ElixirConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PalmTreeGrower extends AbstractTreeGrower
{
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random pRandom, boolean pLargeHive)
    {
        return ElixirConfiguredFeatures.PALM_TREE;
    }
}