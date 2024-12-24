package net.cobra.purpleheartforest.world.gen.trunk;

import net.cobra.purpleheartforest.mixin.TrunkPlacerTypeMixin;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerType {

    public static final TrunkPlacerType<PurpleHeartTrunkPlacer> PURPLE_HEART_TRUNK_PLACER_TYPE = TrunkPlacerTypeMixin.register("purple_heart_trunk_placer",PurpleHeartTrunkPlacer.CODEC);

    public static void register() {

    }

}
