package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by John on 7/14/2015.
 */
public class BlooIngot extends Item {
    public BlooIngot() {
        this.setUnlocalizedName("bloo_ingot");
        this.setTextureName("examplemod:blooIngot");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
}
