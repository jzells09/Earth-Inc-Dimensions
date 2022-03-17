package com.earthinc.earthincdimensions.world.biome;

import com.earthinc.earthincdimensions.EarthIncDimensions;
import com.earthinc.earthincdimensions.block.ModBlocks;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, EarthIncDimensions.MOD_ID);

    public static final RegistryObject<Biome> OVERWORLD_MINING = BIOMES.register("overworld_mining",
            () -> makeOverworldMineBiome(() -> ModConfiguredSurfaceBuilders.OVERWORLD_MINING_SURFACE, 0.0f, 0.0f));

    public static final RegistryObject<Biome> NETHER_MINING = BIOMES.register("nether_mining",
            () -> makeNetherMineBiome(() -> ModConfiguredSurfaceBuilders.NETHER_MINING_SURFACE, 0.0f, 0.0f));

    private static Biome makeOverworldMineBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withPassiveMobs(mobspawninfo$builder);

        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withClayDisks(biomegenerationsettings$builder);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIRT);
        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.PLAINS).depth(depth).scale(scale)
                .temperature(0.0F).downfall(0.9F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4445678).setWaterFogColor(270131)
                        .setFogColor(12638463)
                        .withFoliageColor(-43690)
                        .withGrassColor(43520)
                        .withSkyColor(8103167)
                        .build())
                .withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }

    private static Biome makeNetherMineBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();


        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(surfaceBuilder);
        DefaultBiomeFeatures.withDebrisOre(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withCommonNetherBlocks(biomegenerationsettings$builder);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_QUARTZ_NETHER);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_QUARTZ_DELTAS);
        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).category(Biome.Category.PLAINS).depth(depth).scale(scale)
                .temperature(0.0F).downfall(0.9F).setEffects((new BiomeAmbience.Builder()).setWaterColor(11141120).setWaterFogColor(11141120)
                        .setFogColor(16733525)
                        .withFoliageColor(11141120)
                        .withGrassColor(11141120)
                        .withSkyColor(11141120)
                        .build())
                .withMobSpawnSettings(mobspawninfo$builder.build()).withGenerationSettings(biomegenerationsettings$builder.build()).build();
    }







    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
