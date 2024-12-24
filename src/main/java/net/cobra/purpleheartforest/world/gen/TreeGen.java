package net.cobra.purpleheartforest.world.gen;

import net.cobra.purpleheartforest.world.biome.ModBiomeKeys;
import net.cobra.purpleheartforest.world.gen.feature.ModFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class TreeGen {
    public static void treeGen() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomeKeys.PURPLE_HEART_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModFeatures.Placer.PURPLE_HEART_TREE);
    }
}
