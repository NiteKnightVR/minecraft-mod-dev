package com.example.examplemod;

/**
 * Created by atvaccaro on 8/21/14.
 */

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    //Provides containers when request by a server
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);


        //No tile entity
        if(ID == MyMod.guiIDMetalworkingBench) {
            return ID == MyMod.guiIDMetalworkingBench && world.getBlock(x, y, z) == MyMod.metalworkingBench
                    ? new ContainerMetalworkingBench(player.inventory, world, x, y, z) : null;
        }

        return null;
    } //end getServerGuiElement

    //Provides GUIs when requested by a client
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);


        //No tile entity
        if(ID == MyMod.guiIDMetalworkingBench) {
            return ID == MyMod.guiIDMetalworkingBench && world.getBlock(x, y, z) == MyMod.metalworkingBench
                    ? new GuiMetalworkingBench(player.inventory, world, x, y, z) : null;
        }

        return null;
    } //end get ClientGuiElement
}

