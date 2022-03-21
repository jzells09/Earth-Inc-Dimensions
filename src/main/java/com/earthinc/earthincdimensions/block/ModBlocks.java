package com.earthinc.earthincdimensions.block;

import com.earthinc.earthincdimensions.EarthIncDimensions;
import com.earthinc.earthincdimensions.block.dimblocks.NetherTeleportBlock;
import com.earthinc.earthincdimensions.block.dimblocks.OceanTeleportBlock;
import com.earthinc.earthincdimensions.block.dimblocks.OverworldTeleportBlock;
import com.earthinc.earthincdimensions.item.ModItemGroup;
import com.earthinc.earthincdimensions.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, EarthIncDimensions.MOD_ID);

    public static final RegistryObject<Block> OVERWORLD_MINING_PORTAL = registerBlock("overworld_mining_portal",
            () -> new OverworldTeleportBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));

    public static final RegistryObject<Block> NETHER_MINING_PORTAL = registerBlock("nether_mining_portal",
            () -> new NetherTeleportBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));

    public static final RegistryObject<Block> OCEAN_MINING_PORTAL = registerBlock("ocean_mining_portal",
            () -> new OceanTeleportBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));

//end
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.EARTHINCDIMS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}