package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by John on 7/17/2015.
 */
public class ItemExplodingArrow extends Item {
    public ItemExplodingArrow(){
        this.setUnlocalizedName("exploding_arrow");
        this.setTextureName("examplemod:exploding_arrow");
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
}
