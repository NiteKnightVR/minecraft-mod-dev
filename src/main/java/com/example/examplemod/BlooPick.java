package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by John on 7/15/2015.
 */
public class BlooPick extends ItemPickaxe {
    protected BlooPick(ToolMaterial tm) {
        super(tm);

        this.setTextureName("examplemod:blooPick");
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setUnlocalizedName("bloo_pick");
    }
}
