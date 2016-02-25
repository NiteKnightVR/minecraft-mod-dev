package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by John on 6/15/2015.
 */
public class CopperIngot extends Item {
    public CopperIngot(){
        super();

        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setUnlocalizedName("copper_ingot");
        this.setTextureName("examplemod:better_copper_ingot");
    }
}
