package net.cobra.purpleheartforest.block;

import net.cobra.purpleheartforest.world.gen.feature.ModFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator PURPLE_HEART = new SaplingGenerator("purple_heart", 0f, Optional.empty(), Optional.empty(),
            Optional.of(ModFeatures.Configure.PURPLE_HEART_TREE), Optional.empty(), Optional.empty(), Optional.empty());

}
