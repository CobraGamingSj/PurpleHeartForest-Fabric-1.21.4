package net.cobra.purpleheartforest.registry.tag;

import net.cobra.purpleheartforest.PurpleHeartForest;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModBlockTags {

    public static final TagKey<Block> PURPLE_HEART_LOG = of("purple_heart_log");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, PurpleHeartForest.modId(id));
    }

}
