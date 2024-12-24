package net.cobra.purpleheartforest.client.datagen;

import net.cobra.purpleheartforest.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagGen extends FabricTagProvider.ItemTagProvider {
    public ItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PURPLE_HEART_LOG.asItem())
                .add(ModBlocks.PURPLE_HEART_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PURPLE_HEART_LOG.asItem())
                .add(ModBlocks.STRIPPED_PURPLE_HEART_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.PURPLE_HEART_PLANKS.asItem());
    }
}
