package net.cobra.purpleheartforest;

import net.cobra.purpleheartforest.client.datagen.*;
import net.cobra.purpleheartforest.world.biome.ModBiomeKeys;
import net.cobra.purpleheartforest.world.gen.feature.ModFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class PurpleHeartForestDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(DynamicRegistryGen::new);
		pack.addProvider(ModelGen::new);
		pack.addProvider(BlockTagGen::new);
		pack.addProvider(ItemTagGen::new);
		pack.addProvider(BlockLootGen::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomeKeys::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModFeatures.Configure::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModFeatures.Placer::bootstrap);
	}
}
