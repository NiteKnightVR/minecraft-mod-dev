package com.example.examplemod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by John on 7/16/2015.
 */
public class BlooBush extends BlockCrops {

    @SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;

    public BlooBush() {
        this.setBlockName("blooberry_bush");
        this.setBlockTextureName("examplemod:blueberry_stage_0");
    }

    @Override
    public int quantityDropped(int metaData, int fortune, Random rand){
        return (metaData/2);
    }

    @Override
    public Item getItemDropped(int metaData, Random rand, int fortune){
        return (ExampleMod.blooberry);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int stage) {
        return iIcon[stage];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIR){
        iIcon = new IIcon[8];

        iIcon[0] = parIR.registerIcon("examplemod:blueberry_stage_0");
        iIcon[1] = parIR.registerIcon("examplemod:blueberry_stage_0");

        iIcon[2] = parIR.registerIcon("examplemod:blueberry_stage_1");
        iIcon[3] = parIR.registerIcon("examplemod:blueberry_stage_1");

        iIcon[4] = parIR.registerIcon("examplemod:blueberry_stage_2");
        iIcon[5] = parIR.registerIcon("examplemod:blueberry_stage_2");
        iIcon[6] = parIR.registerIcon("examplemod:blueberry_stage_2");

        iIcon[7] = parIR.registerIcon("examplemod:blueberry_stage_3");
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
                                         int meta, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(ExampleMod.blooberry));

        if (meta >= 7)
        {
            for(int i = 0; i < 3+fortune; ++i)
            {
                if(world.rand.nextInt(10) <= meta)
                {
                    ret.add(new ItemStack(ExampleMod.blooberry));
                }
            }
        }
        return ret;
    }
}
