package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by John on 6/17/2015.
 */
public class CopperArmor extends ItemArmor {
    public CopperArmor(ArmorMaterial am, int type, String name) {
        super(am, 0, type);

        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("examplemod:" + getUnlocalizedName().substring(5)); 
    }

    @Override
    public String getArmorTexture
            (ItemStack stack, Entity entity, int slot, String type)
    {
        if (stack.getItem() == MyMod.cuLeg)
            return MyMod.MODID + ":models/armor/copper_layer_2.png";
        //  return "examplemod:models/armor/copper_layer_2.png"

        else
            return MyMod.MODID + ":models/armor/copper_layer_1.png";

    }
}
