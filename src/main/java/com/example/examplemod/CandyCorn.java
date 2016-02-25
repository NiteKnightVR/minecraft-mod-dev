package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 * Created by John on 6/24/2015.
 */

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class CandyCorn extends ItemFood implements IPlantable
{
    private Block plantedBlock;
    /** Block ID of the soil this seed food should be planted on. */
    private Block soilId;
    private static final String __OBFID = "CL_00000060";

    public CandyCorn(int num, float flo, Block b1, Block b2)
    {
        super(num, flo, false);
        this.plantedBlock = b1;
        this.soilId = b2;
        this.setCreativeTab(CreativeTabs.tabFood);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int shouldbe1, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (shouldbe1 != 1)
        {
            return false;
        }
        else if (player.canPlayerEdit(x, y, z, shouldbe1, stack) && player.canPlayerEdit(x, y + 1, z, shouldbe1, stack))
        {
            if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z))
            {
                world.setBlock(x, y + 1, z, this.plantedBlock);
                --stack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return plantedBlock;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
}