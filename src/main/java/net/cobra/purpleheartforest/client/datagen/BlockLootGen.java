package net.cobra.purpleheartforest.client.datagen;

import net.cobra.purpleheartforest.block.ModBlocks;
import net.cobra.purpleheartforest.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockLootGen extends FabricBlockLootTableProvider {
    public BlockLootGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CRYSTALLITE_ORE, oreDrops(ModBlocks.CRYSTALLITE_ORE, ModItems.CRYSTALLITE));
        addDrop(ModBlocks.DEEPSLATE_CRYSTALLITE_ORE, oreDrops(ModBlocks.DEEPSLATE_CRYSTALLITE_ORE, ModItems.CRYSTALLITE));
    }
}
