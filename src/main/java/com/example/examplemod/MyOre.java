package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by John on 7/14/2015.
 */
public class MyOre extends Block {
    protected MyOre(Material mat) {
        super(mat);
        this.setBlockName("my_ore");
        this.setBlockTextureName("examplemod:myOre");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5.0f);
    }
}
