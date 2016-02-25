package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

/**
 * Created by John on 7/16/2015.
 */
public class Strawberries extends ItemSeedFood {
    public Strawberries() {
        super(1, 0.1f, ExampleMod.strawberryBush, Blocks.farmland);

        this.setUnlocalizedName("strawberries");
        this.setTextureName("examplemod:strawberries");
        this.setCreativeTab(CreativeTabs.tabFood);
    }
}
