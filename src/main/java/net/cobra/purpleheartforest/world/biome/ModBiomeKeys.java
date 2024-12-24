package net.cobra.purpleheartforest.world.biome;

import net.cobra.purpleheartforest.PurpleHeartForest;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModBiomeKeys {

    public static final RegistryKey<Biome> PURPLE_HEART_FOREST = of("purple_heart_forest");

    public static void bootstrap(Registerable<Biome> registerable) {
        RegistryEntryLookup<PlacedFeature> placedFeatureRegistryEntryLookup = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> carverRegistryEntryLookup = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        registerable.register(PURPLE_HEART_FOREST, ModOverworldBiomeCreator.createPurpleHeartForest(placedFeatureRegistryEntryLookup, carverRegistryEntryLookup));
    }

    private static RegistryKey<Biome> of(String id) {
        return RegistryKey.of(RegistryKeys.BIOME, PurpleHeartForest.modId(id));
    }

}
