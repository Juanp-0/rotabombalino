package net.idsquad.rotabombalinomod.block.custom;

import com.mojang.serialization.MapCodec;
import net.idsquad.rotabombalinomod.entity.ModEntities;
import net.idsquad.rotabombalinomod.entity.custom.TralaleroEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.ticks.TickPriority;
import org.jetbrains.annotations.Nullable;

public class InvocationAltarBlock extends HorizontalDirectionalBlock {
    public static BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public static final MapCodec<InvocationAltarBlock> CODEC = simpleCodec(InvocationAltarBlock::new);

    public InvocationAltarBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
    }
    @Override
    protected InteractionResult useWithoutItem (BlockState pState, Level pLevel, BlockPos pPos,
                                                Player pPlayer, BlockHitResult pHitResult){
        if (!pLevel.isClientSide()) {
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlockAndUpdate(pPos, pState.setValue(CLICKED, !currentState));

            TralaleroEntity tralalero = new TralaleroEntity(ModEntities.TRALALERO.get(), pLevel);
            tralalero.setPos(pPos.getX() + 0.5, pPos.getY() + 1, pPos.getZ() + 0.5);
            pLevel.addFreshEntity(tralalero);

            pLevel.scheduleTick(pPos, this, 20, TickPriority.NORMAL);
        }
        return InteractionResult.SUCCESS;
    }
    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        pLevel.sendParticles(ParticleTypes.SMOKE,
                pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5,
                20, 0.3, 0.3, 0.3, 0.05);

        pLevel.playSound(null, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5f, 1f);
        pLevel.removeBlock(pPos, false);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(CLICKED);
    }

}