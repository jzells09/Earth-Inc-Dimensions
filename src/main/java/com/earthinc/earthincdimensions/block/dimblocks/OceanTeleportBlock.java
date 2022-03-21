package com.earthinc.earthincdimensions.block.dimblocks;

import com.earthinc.earthincdimensions.world.dimension.DimensionTeleporterOceanMining;
import com.earthinc.earthincdimensions.world.dimension.DimensionTeleporterOverworldMining;
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

public class OceanTeleportBlock extends Block {
    public OceanTeleportBlock(Properties properties) {
        super(properties);
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == ModDimensions.OceanMiningDim) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new DimensionTeleporterOceanMining(pos, false));
                        }
                    } else {
                        ServerWorld futureDim = server.getWorld(ModDimensions.OceanMiningDim);
                        if (futureDim != null) {
                            player.changeDimension(futureDim, new DimensionTeleporterOceanMining(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
