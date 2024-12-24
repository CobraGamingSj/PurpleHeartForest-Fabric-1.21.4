package net.cobra.purpleheartforest.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class PurpleHeartLeavesBlock extends LeavesBlock {
    protected static final MapCodec<PurpleHeartLeavesBlock> CODEC = PurpleHeartLeavesBlock.createCodec(PurpleHeartLeavesBlock::new);
    public PurpleHeartLeavesBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean shouldDecay(BlockState state) {
        System.out.println("Decay");
        return true;
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        System.out.println("Has Random Ticks");
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        if (world.isClient && random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.CHERRY_LEAVES, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0, 0);
        }
    }

    @Override
    public MapCodec<PurpleHeartLeavesBlock> getCodec() {
        return CODEC;
    }
}
