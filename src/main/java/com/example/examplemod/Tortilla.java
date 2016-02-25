package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by John on 6/17/2015.
 */
public class Tortilla extends ItemFood {
    public Tortilla(int foodValue, float satMod, boolean wolfEat) {
        super(foodValue, satMod, wolfEat);

        this.setCreativeTab(CreativeTabs.tabFood);
        this.setUnlocalizedName("tortilla");
        this.setTextureName("examplemod:tortilla");
    }

    protected void onFoodEaten
            (ItemStack stack, World w, EntityPlayer player){
        if(!w.isRemote)
            player.addPotionEffect(new PotionEffect(1,2,0, false));
    }
}
