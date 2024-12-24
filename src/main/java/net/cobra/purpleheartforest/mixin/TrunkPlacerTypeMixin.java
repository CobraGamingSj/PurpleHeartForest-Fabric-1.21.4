package net.cobra.purpleheartforest.mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrunkPlacerType.class)
public interface TrunkPlacerTypeMixin {
    @Invoker("register")
    static <T extends TrunkPlacer> TrunkPlacerType<T> register(String id, MapCodec<T> codec) {
        throw new IllegalStateException();
    }
}
