package net.cobra.purpleheartforest.world.gen.foliage;

import net.cobra.purpleheartforest.mixin.FoliagePlacerTypeMixin;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerType {

    public static final FoliagePlacerType<PurpleHeartFoliagePlacer> PURPLE_HEART_FOLIAGE_PLACER_TYPE = FoliagePlacerTypeMixin.register("purple_heart_foliage_placer",PurpleHeartFoliagePlacer.CODEC);

    public static void register() {

    }
}
