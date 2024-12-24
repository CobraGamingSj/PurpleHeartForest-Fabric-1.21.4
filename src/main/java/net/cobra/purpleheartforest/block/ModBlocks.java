package net.cobra.purpleheartforest.block;

import net.cobra.purpleheartforest.PurpleHeartForest;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block THUNDER_CHARGE_BLOCK = register("thunder_charge_block", new ThunderChargeBlock(AbstractBlock.Settings.create().registryKey(PurpleHeartForest.setBlockRegistryKey("thunder_charge_block"))));
    public static final Block PURPLE_HEART_LOG = register("purple_heart_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LOG).mapColor(MapColor.PURPLE).strength(3f).burnable().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_log"))));
    public static final Block PURPLE_HEART_WOOD = register("purple_heart_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(3f).mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_wood"))));
    public static final Block STRIPPED_PURPLE_HEART_LOG = register("stripped_purple_heart_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(3f).burnable().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_log"))));
    public static final Block STRIPPED_PURPLE_HEART_WOOD = register("stripped_purple_heart_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f).burnable().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_log"))));
    public static final Block PURPLE_HEART_LEAVES = register("purple_heart_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_leaves")).mapColor(MapColor.PURPLE).strength(0.2f).nonOpaque()));
    public static final Block PURPLE_HEART_SAPLING = register("purple_heart_sapling", new SaplingBlock(ModSaplingGenerator.PURPLE_HEART, AbstractBlock.Settings.create().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_sapling")).sounds(BlockSoundGroup.CHERRY_SAPLING)));

    public static final Block PURPLE_HEART_PLANKS = register("purple_heart_planks", new Block(AbstractBlock.Settings.create().strength(3f, 4f).burnable().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_planks"))));
    public static final Block PURPLE_HEART_STAIRS = register("purple_heart_stairs", new StairsBlock(PURPLE_HEART_PLANKS.getDefaultState(), AbstractBlock.Settings.create().strength(3f).requiresTool().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_stairs"))));
    public static final Block PURPLE_HEART_SLAB = register("purple_heart_slab", new SlabBlock(AbstractBlock.Settings.create().strength(3f, 4f).burnable().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_slab"))));

    public static final Block PURPLE_HEART_BUTTON = register("purple_heart_button", new ButtonBlock(BlockSetType.PALE_OAK, 4, AbstractBlock.Settings.create().strength(3f).noCollision().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_button"))));
    public static final Block PURPLE_HEART_PRESSURE_PLATE = register("purple_heart_pressure_plate", new PressurePlateBlock(BlockSetType.PALE_OAK, AbstractBlock.Settings.create().strength(3f).registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_pressure_plate"))));

    public static final Block PURPLE_HEART_FENCE = register("purple_heart_fence", new FenceBlock(AbstractBlock.Settings.create().strength(3f).requiresTool().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_fence"))));
    public static final Block PURPLE_HEART_FENCE_GATE = register("purple_heart_fence_gate", new FenceGateBlock(WoodType.PALE_OAK, AbstractBlock.Settings.create().strength(3f).requiresTool().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_fence_gate"))));

    public static final Block PURPLE_HEART_DOOR = register("purple_heart_door", new DoorBlock(BlockSetType.PALE_OAK, AbstractBlock.Settings.create().strength(3f).requiresTool().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_door"))));
    public static final Block PURPLE_HEART_TRAPDOOR = register("purple_heart_trapdoor", new TrapdoorBlock(BlockSetType.PALE_OAK, AbstractBlock.Settings.create().strength(3f).requiresTool().registryKey(PurpleHeartForest.setBlockRegistryKey("purple_heart_trapdoor"))));
    public static final Block CRYSTALLITE_ORE = register("crystallite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 10), AbstractBlock.Settings.create().strength(10F).strength(8F, 8F).registryKey(PurpleHeartForest.setBlockRegistryKey("crystallite_ore")).slipperiness(2F)));
    public static final Block DEEPSLATE_CRYSTALLITE_ORE = register("deepslate_crystallite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 6), AbstractBlock.Settings.create().strength(10.5F).strength(8.5F, 8.5F).registryKey(PurpleHeartForest.setBlockRegistryKey("deepslate_crystallite_ore")).slipperiness(1.5F)));

    public static Block register(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PurpleHeartForest.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, PurpleHeartForest.modId(name), new BlockItem(block, new Item.Settings().registryKey(PurpleHeartForest.setItemRegistryKey(name)).useBlockPrefixedTranslationKey()));
    }

    public static void register() {}

}
