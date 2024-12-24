package net.cobra.purpleheartforest.client.datagen;

import net.cobra.purpleheartforest.block.ModBlocks;
import net.cobra.purpleheartforest.registry.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGen extends FabricTagProvider.BlockTagProvider {
    public BlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.PURPLE_HEART_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PURPLE_HEART_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.PURPLE_HEART_LEAVES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CRYSTALLITE_ORE)
                .add(ModBlocks.DEEPSLATE_CRYSTALLITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CRYSTALLITE_ORE)
                .add(ModBlocks.DEEPSLATE_CRYSTALLITE_ORE);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.PURPLE_HEART_LOG)
                .add(ModBlocks.PURPLE_HEART_WOOD)
                .add(ModBlocks.STRIPPED_PURPLE_HEART_LOG)
                .add(ModBlocks.STRIPPED_PURPLE_HEART_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .forceAddTag(ModBlockTags.PURPLE_HEART_LOG);

        getOrCreateTagBuilder(ModBlockTags.PURPLE_HEART_LOG)
                .add(ModBlocks.PURPLE_HEART_LOG)
                .add(ModBlocks.PURPLE_HEART_WOOD)
                .add(ModBlocks.STRIPPED_PURPLE_HEART_LOG)
                .add(ModBlocks.STRIPPED_PURPLE_HEART_WOOD);
    }
}
