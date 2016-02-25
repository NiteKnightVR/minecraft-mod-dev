package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by John on 6/16/2015.
 */
public class CopperSword extends ItemSword {

    public CopperSword(ToolMaterial tm) {
        super(tm);

        this.setUnlocalizedName("cu_sword");
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("examplemod:copper_sword");
    }

    @Override
    public boolean hitEntity(ItemStack itemHitting,
        EntityLivingBase target, EntityLivingBase player){

        //target.setFire(4);
        /*target.worldObj.createExplosion(null,
            target.posX, target.posY, target.posZ, 3.0f, true);
            */
        //target.addVelocity(0,1,0);

        EntityLightningBolt light = new EntityLightningBolt
                (target.worldObj, target.posX,
                        target.posY, target.posZ);
        //player.worldObj.addWeatherEffect(light);

        //Potion ID, Duration, Amplifier
        target.addPotionEffect(new PotionEffect(2,3,1,false));
        player.addPotionEffect(new PotionEffect(1,3,2,false));
        return true;
    }

    public ItemStack onItemRightClick(ItemStack itemStack,
           World current, EntityPlayer player)
    {
        return itemStack;
    }
}
