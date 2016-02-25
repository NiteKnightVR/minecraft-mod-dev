package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by John on 6/16/2015.
 */
public class CopperPick extends ItemPickaxe{
    protected CopperPick(ToolMaterial tm) {
        super(tm);

        this.setCreativeTab(CreativeTabs.tabTools);
        this.setUnlocalizedName("cu_pick");
        this.setTextureName("examplemod:copper_pickaxe");
    }
}
