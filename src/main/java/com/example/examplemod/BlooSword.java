package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;

/**
 * Created by John on 7/15/2015.
 */
public class BlooSword extends ItemSword {
    public BlooSword(ToolMaterial tm) {
        super(tm);

        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("examplemod:blooSword");
        this.setUnlocalizedName("bloo_sword");
    }

    public boolean hitEntity(ItemStack item, EntityLivingBase target,
                              EntityLivingBase player) {
        //target.setFire(3);  //sets fire to target
        //player.setFire(1);  //sets fire to player

        //target.worldObj.createExplosion(null, target.posX, target.posY,
        //        target.posZ, 3.0F, true);

        /*EntityLightningBolt light = new EntityLightningBolt(target.worldObj,
                target.posX, target.posY, target.posZ);
        player.worldObj.addWeatherEffect(light);*/

        target.addVelocity(0, 1, 0);
        player.addPotionEffect(new PotionEffect(1, 20, 0)); //time in ticks
        // potion ID, duration, amplifier
        return true;
    }
}
