package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by John on 7/15/2015.
 */
public class BlooArmor extends ItemArmor {

    public BlooArmor(ArmorMaterial am, int armorPiece,
                     String name)
    {
        super(am, 0, armorPiece);

        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("examplemod:" + name);
    }

    @Override
    public String getArmorTexture(ItemStack stack,
                                  Entity entity, int slot,
                                  String type)
    {
        if(stack.getItem() == ExampleMod.bLeggings)
            return "examplemod:models/armor/bloo_layer_2.png";
        else
            return "examplemod:models/armor/bloo_layer_1.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player,
                            ItemStack armor)
    {
        player.addPotionEffect(new PotionEffect(
                Potion.waterBreathing.getId(), 2, 3));
    }

    @Override
    public CreativeTabs[] getCreativeTabs() {
        return new CreativeTabs[] { CreativeTabs.tabCombat,
                CreativeTabs.tabDecorations };
    }

    @Override
    public boolean getIsRepairable(ItemStack armor, ItemStack repair) {
        return repair.getItem() == ExampleMod.bloo;
    }
}
