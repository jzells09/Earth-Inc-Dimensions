package com.earthinc.earthincdimensions.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModItemGroup {

    public static final ItemGroup EARTHINCDIMS_GROUP = new ItemGroup("earthIncDimensionsTab") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.MINING_CORE.get());
        }
    };

}
