package net.cobra.purpleheartforest.effect;

import net.cobra.purpleheartforest.PurpleHeartForest;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModStatusEffects {

    public static final StatusEffect LIGHTENED = register("lightened", new LightenedEffect(StatusEffectCategory.HARMFUL, 0x317465));

    private static StatusEffect register(String id, LightenedEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, PurpleHeartForest.modId(id),statusEffect);
    }

    public static void register() {

    }
}
