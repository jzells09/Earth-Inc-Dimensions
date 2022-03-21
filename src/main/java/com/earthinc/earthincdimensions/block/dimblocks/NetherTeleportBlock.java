package com.earthinc.earthincdimensions.block.dimblocks;

import com.earthinc.earthincdimensions.world.dimension.DimensionTeleporterNetherMining;
import com.earthinc.earthincdimensions.world.dimension.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class NetherTeleportBlock extends Block {
    public NetherTeleportBlock(Properties properties) {
        super(properties);
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == ModDimensions.NetherMiningDim) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new DimensionTeleporterNetherMining(pos, false));
                        }
                    } else {
                        ServerWorld futureDim = server.getWorld(ModDimensions.NetherMiningDim);
                        if (futureDim != null) {
                            player.changeDimension(futureDim, new DimensionTeleporterNetherMining(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}

