package net.cobra.purpleheartforest.world.biome;

import net.cobra.purpleheartforest.world.gen.feature.ModFeatures;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModOverworldBiomeCreator {

    public static Biome createPurpleHeartForest(RegistryEntryLookup<PlacedFeature> placedFeatureRegistryEntryLookup, RegistryEntryLookup<ConfiguredCarver<?>> configuredCarverRegistryEntryLookup) {
        Biome.Builder builder = new Biome.Builder();
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        BiomeEffects biomeEffects = new BiomeEffects.Builder().music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_DEEP_DARK)).grassColor(6314911).fogColor(14539515).foliageColor(9590783).waterFogColor(11840197).skyColor(5832959).waterColor(6663127).build();
        GenerationSettings.LookupBackedBuilder lookupBackedBuilder = new GenerationSettings.LookupBackedBuilder(placedFeatureRegistryEntryLookup, configuredCarverRegistryEntryLookup);
        DefaultBiomeFeatures.addAmethystGeodes(lookupBackedBuilder);
        DefaultBiomeFeatures.addMineables(lookupBackedBuilder);
        DefaultBiomeFeatures.addDefaultOres(lookupBackedBuilder);
        DefaultBiomeFeatures.addEmeraldOre(lookupBackedBuilder);
        addCrystalliteOres(lookupBackedBuilder);
        return builder
                .precipitation(true)
                .effects(biomeEffects)
                .downfall(0.5f)
                .temperature(0.5f)
                .spawnSettings(spawnBuilder.build())
                .generationSettings(lookupBackedBuilder.build())
                .build();
    }

    public static void addCrystalliteOres(GenerationSettings.LookupBackedBuilder lookupBackedBuilder) {
        lookupBackedBuilder.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModFeatures.Placer.ORE_CRYSTALLITE);
        lookupBackedBuilder.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModFeatures.Placer.ORE_CRYSTALLITE_MEDIUM);
        lookupBackedBuilder.feature(GenerationStep.Feature.UNDERGROUND_ORES, ModFeatures.Placer.ORE_CRYSTALLITE_LARGE);
    }
}
