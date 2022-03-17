package com.earthinc.earthincdimensions.item;

import com.earthinc.earthincdimensions.EarthIncDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EarthIncDimensions.MOD_ID);


    public static final RegistryObject<Item> MINING_CORE = ITEMS.register("mining_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.EARTHINCDIMS_GROUP)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}