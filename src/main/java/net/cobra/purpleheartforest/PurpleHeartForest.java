package net.cobra.purpleheartforest;

import net.cobra.purpleheartforest.block.ModBlocks;
import net.cobra.purpleheartforest.effect.ModStatusEffects;
import net.cobra.purpleheartforest.item.ModItems;
import net.cobra.purpleheartforest.world.gen.WorldGen;
import net.cobra.purpleheartforest.world.gen.foliage.ModFoliagePlacerType;
import net.cobra.purpleheartforest.world.gen.trunk.ModTrunkPlacerType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurpleHeartForest implements ModInitializer {
	public static final String MOD_ID = "forest";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier modId(String path) {
		return Identifier.of(MOD_ID, path);
    }

	public static RegistryKey<Block> setBlockRegistryKey(String id) {
		return RegistryKey.of(RegistryKeys.BLOCK, modId(id));
	}

	public static RegistryKey<Item> setItemRegistryKey(String id) {
		return RegistryKey.of(RegistryKeys.ITEM, modId(id));
	}

    @Override
	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries) -> {
			entries.addAfter(Blocks.PALE_OAK_LOG, ModBlocks.PURPLE_HEART_LOG);
			entries.addAfter(Blocks.PALE_OAK_WOOD, ModBlocks.PURPLE_HEART_WOOD);
			entries.addAfter(Blocks.PALE_OAK_PLANKS, ModBlocks.PURPLE_HEART_PLANKS);
			entries.addAfter(Blocks.STRIPPED_PALE_OAK_LOG, ModBlocks.STRIPPED_PURPLE_HEART_LOG);
			entries.addAfter(Blocks.STRIPPED_PALE_OAK_WOOD, ModBlocks.STRIPPED_PURPLE_HEART_WOOD);
			entries.addAfter(Blocks.PALE_OAK_STAIRS, ModBlocks.PURPLE_HEART_STAIRS);
			entries.addAfter(Blocks.PALE_OAK_SLAB, ModBlocks.PURPLE_HEART_SLAB);
			entries.addAfter(Blocks.PALE_OAK_DOOR, ModBlocks.PURPLE_HEART_DOOR);
			entries.addAfter(Blocks.PALE_OAK_TRAPDOOR, ModBlocks.PURPLE_HEART_TRAPDOOR);
			entries.addAfter(Blocks.PALE_OAK_FENCE, ModBlocks.PURPLE_HEART_FENCE);
			entries.addAfter(Blocks.PALE_OAK_FENCE_GATE, ModBlocks.PURPLE_HEART_FENCE_GATE);
		});
		ModBlocks.register();
		ModItems.register();
		WorldGen.worldGen();
		ModStatusEffects.register();
		ModFoliagePlacerType.register();
		ModTrunkPlacerType.register();

		StrippableBlockRegistry.register(ModBlocks.PURPLE_HEART_LOG, ModBlocks.STRIPPED_PURPLE_HEART_LOG);
		StrippableBlockRegistry.register(ModBlocks.PURPLE_HEART_WOOD, ModBlocks.STRIPPED_PURPLE_HEART_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURPLE_HEART_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURPLE_HEART_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PURPLE_HEART_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PURPLE_HEART_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURPLE_HEART_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURPLE_HEART_LEAVES, 30, 60);
	}
}