package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by John on 7/14/2015.
 */
public class MyBlock extends Block {
    protected MyBlock(Material mat) {
        super(mat);

        this.setBlockName("my_block");
        this.setBlockTextureName("examplemod:myBlock");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2.5F);
        this.setHarvestLevel("pickaxe", 1); //wood=0
                                            //stone=1
                                            //iron=2
                                            //diamond=3
        this.setStepSound(Block.soundTypeAnvil);
        this.setLightLevel(1.0f);
        this.setLightOpacity(1);
    }
}
