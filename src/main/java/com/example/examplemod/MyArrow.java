package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by John on 6/18/2015.
 */
public class MyArrow extends Item {
    public MyArrow() {
        super();

        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setUnlocalizedName("my_arrow");
        this.setTextureName("examplemod:my_arrow");
    }
}
