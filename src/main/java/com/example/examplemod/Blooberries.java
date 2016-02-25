package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

/**
 * Created by John on 7/16/2015.
 */
public class Blooberries extends ItemSeedFood {
    public Blooberries() {
        super(1, 0.1f, ExampleMod.blooberryBlock, Blocks.farmland);

        this.setUnlocalizedName("blooberries");
        this.setTextureName("examplemod:blooberries");
        this.setCreativeTab(CreativeTabs.tabFood);
    }
}
