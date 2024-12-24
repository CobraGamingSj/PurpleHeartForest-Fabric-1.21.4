package net.cobra.purpleheartforest.world.gen.feature;

import net.cobra.purpleheartforest.PurpleHeartForest;
import net.cobra.purpleheartforest.block.ModBlocks;
import net.cobra.purpleheartforest.world.gen.foliage.PurpleHeartFoliagePlacer;
import net.cobra.purpleheartforest.world.gen.trunk.PurpleHeartTrunkPlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModFeatures {

    public static class Configure {

        public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_HEART_TREE = of("purple_heart_tree");
        public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CRYSTALLITE_SMALL = of("ore_crystallite_small");
        public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CRYSTALLITE_MEDIUM = of("ore_crystallite_medium");
        public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_CRYSTALLITE_LARGE = of("ore_crystallite_large");

        public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> registerable) {
            RuleTest stoneOre = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
            RuleTest deepslateOre = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
            List<OreFeatureConfig.Target> list = List.of(OreFeatureConfig.createTarget(stoneOre, ModBlocks.CRYSTALLITE_ORE.getDefaultState()), OreFeatureConfig.createTarget(deepslateOre, ModBlocks.DEEPSLATE_CRYSTALLITE_ORE.getDefaultState()));

            ConfiguredFeatures.register(registerable, PURPLE_HEART_TREE, Feature.TREE, (new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.PURPLE_HEART_LOG), new StraightTrunkPlacer(10, 5, 7),
                    BlockStateProvider.of(ModBlocks.PURPLE_HEART_LEAVES),
                    new BlobFoliagePlacer(
                            ConstantIntProvider.create(6), ConstantIntProvider.create(2), 4),
                    new TwoLayersFeatureSize(1, 1, 2))).build());

            ConfiguredFeatures.register(registerable, ORE_CRYSTALLITE_SMALL, Feature.ORE, new OreFeatureConfig(list, 4, 0.5F));
            ConfiguredFeatures.register(registerable, ORE_CRYSTALLITE_MEDIUM, Feature.ORE, new OreFeatureConfig(list, 8, 0.7F));
            ConfiguredFeatures.register(registerable, ORE_CRYSTALLITE_LARGE, Feature.ORE, new OreFeatureConfig(list, 10, 1.0F));
        }

        public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
            registerable.register(key, new ConfiguredFeature<>(feature, config));
        }

        private static RegistryKey<ConfiguredFeature<?,?>> of(String id) {
            return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, PurpleHeartForest.modId(id));
        }

    }

    public static class Placer {

        public static final RegistryKey<PlacedFeature> PURPLE_HEART_TREE = of("purple_heart_tree");
        public static final RegistryKey<PlacedFeature> ORE_CRYSTALLITE = of("ore_crystallite");
        public static final RegistryKey<PlacedFeature> ORE_CRYSTALLITE_MEDIUM = of("ore_crystallite_medium");
        public static final RegistryKey<PlacedFeature> ORE_CRYSTALLITE_LARGE = of("ore_crystallite_large");

        public static void bootstrap(Registerable<PlacedFeature> registerable) {
            RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
            RegistryEntry<ConfiguredFeature<?, ?>> purpleHeartConfig = registryEntryLookup.getOrThrow(Configure.PURPLE_HEART_TREE);
            RegistryEntry<ConfiguredFeature<?, ?>> registryEntry20 = registryEntryLookup.getOrThrow(Configure.ORE_CRYSTALLITE_SMALL);
            RegistryEntry<ConfiguredFeature<?, ?>> registryEntry21 = registryEntryLookup.getOrThrow(Configure.ORE_CRYSTALLITE_MEDIUM);
            RegistryEntry<ConfiguredFeature<?, ?>> registryEntry22 = registryEntryLookup.getOrThrow(Configure.ORE_CRYSTALLITE_LARGE);

            register(registerable, PURPLE_HEART_TREE, purpleHeartConfig,
                    VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                            PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.PURPLE_HEART_SAPLING));

            register(
                    registerable,
                    ORE_CRYSTALLITE,
                    registryEntry20,
                    OrePlacementModifier.modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));

            register(registerable, ORE_CRYSTALLITE_MEDIUM, registryEntry21, OrePlacementModifier.modifiersWithCount(1, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-64), YOffset.aboveBottom(-4))));

            register(registerable,
                    ORE_CRYSTALLITE_LARGE,
                    registryEntry22,
                    OrePlacementModifier.modifiersWithRarity(5, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
        }

        public static void register(Registerable<PlacedFeature> featureRegisterable, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
            featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
        }

        public static void register(Registerable<PlacedFeature> featureRegisterable, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
            register(featureRegisterable, key, feature, List.of(modifiers));
        }

        private static RegistryKey<PlacedFeature> of(String id) {
            return RegistryKey.of(RegistryKeys.PLACED_FEATURE, PurpleHeartForest.modId(id));
        }

    }

    public static class OrePlacementModifier {
        private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
            return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
            return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

        private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
            return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
        }
    }
}
