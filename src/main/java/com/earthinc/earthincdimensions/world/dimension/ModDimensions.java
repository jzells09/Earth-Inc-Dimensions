package com.earthinc.earthincdimensions.world.dimension;

import com.earthinc.earthincdimensions.EarthIncDimensions;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions
{
    public  static RegistryKey<World> OverworldMiningDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(EarthIncDimensions.MOD_ID,"overworld_mining"));

    public  static RegistryKey<World> NetherMiningDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(EarthIncDimensions.MOD_ID,"nether_mining"));
}

