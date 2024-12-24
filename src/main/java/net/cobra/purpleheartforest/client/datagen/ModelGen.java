package net.cobra.purpleheartforest.client.datagen;

import net.cobra.purpleheartforest.block.ModBlocks;
import net.cobra.purpleheartforest.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModelGen extends FabricModelProvider {
    public ModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool purpleHeartPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PURPLE_HEART_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THUNDER_CHARGE_BLOCK);
        blockStateModelGenerator.registerLog(ModBlocks.PURPLE_HEART_LOG).log(ModBlocks.PURPLE_HEART_LOG).wood(ModBlocks.PURPLE_HEART_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PURPLE_HEART_LOG).log(ModBlocks.STRIPPED_PURPLE_HEART_LOG).wood(ModBlocks.STRIPPED_PURPLE_HEART_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_HEART_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PURPLE_HEART_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        purpleHeartPool.stairs(ModBlocks.PURPLE_HEART_STAIRS);
        purpleHeartPool.slab(ModBlocks.PURPLE_HEART_SLAB);
        purpleHeartPool.fence(ModBlocks.PURPLE_HEART_FENCE);
        purpleHeartPool.fenceGate(ModBlocks.PURPLE_HEART_FENCE_GATE);
        purpleHeartPool.button(ModBlocks.PURPLE_HEART_BUTTON);
        purpleHeartPool.pressurePlate(ModBlocks.PURPLE_HEART_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.PURPLE_HEART_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PURPLE_HEART_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRYSTALLITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CRYSTALLITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CRYSTALLITE, Models.GENERATED);
    }
}
