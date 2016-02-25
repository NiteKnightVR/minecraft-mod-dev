package com.example.examplemod;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by John on 7/14/2015.
 */
public class OreManager implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ,
                         World world, IChunkProvider chunkGenerator,
                         IChunkProvider chunkProvider)
    {
        switch(world.provider.dimensionId)
        {
            case -1: generateNether(world, random, chunkX*16, chunkZ*16);
                break;
            case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
                break;
            case 1: generateEnd(world, random, chunkX*16, chunkZ*16);
                break;
        }
    }   //end generate

    private void generateNether(World world, Random random, int x, int z) {

    }

    private void generateSurface(World world, Random random, int x, int z) {
        this.addOreSpawn(ExampleMod.mOre, world, random, x, z,
                16, 16, 10, 128, 15, 100);
    }

    private void generateEnd(World world, Random random, int x, int z) {

    }

    public void addOreSpawn(Block block, World world, Random rand,
                            int blockXPos, int blockZPos,
                            int maxX, int maxZ,
                            int maxVeinSize, int chancesToSpawn,
                            int minY, int maxY)
    {
        assert maxY > minY :
                "addOreSpawn: maxY must be greater than minY";
        assert minY > 0 :
                "addOreSpawn: minY must be greater than 0";
        assert maxY < 256 && maxY > 0 :
                "addOreSpawn: 0 < maxY < 256 not met";
        assert maxX > 0 && maxX <= 16 :
                "addOreSpawn: maxX > 0 and maxX <= 16 not met";
        assert maxZ > 0 && maxZ <= 16 :
                "addOreSpawn: 0 < maxZ <= 16 not met";

        int diffY = maxY - minY;
        for (int i = 0; i < chancesToSpawn; i++) {
            int posX = blockXPos + rand.nextInt(maxX);
            int posY = minY + rand.nextInt(diffY);
            int posZ = blockZPos + rand.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize, Blocks.dirt))
                    .generate(world, rand, posX, posY, posZ);
        }
    }
}
