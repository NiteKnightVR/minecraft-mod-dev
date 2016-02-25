package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by John on 6/15/2015.
 */
public class CopperBlock extends Block {
    protected CopperBlock(Material mat) {
        super(mat);

        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("cu_block");
        this.setBlockTextureName("examplemod:copper_block");
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public Item getItemDropped(int meta, Random ran, int fortune)
    {
        return MyMod.cuIngot;
    }

    public int quantityDropped(Random rand)
    {
        return 9;
    }
}
