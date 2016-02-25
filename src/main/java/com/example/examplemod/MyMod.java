package com.example.examplemod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = MyMod.MODID, version = MyMod.VERSION)
public class MyMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final Item.ToolMaterial COPPER =
            EnumHelper.addToolMaterial("copper_tool",
            1, 300, 2.0F, 1.0F, 16);
    //harvest level, durability, dmg to blocks, dmg to ent, ench
    public static final ItemArmor.ArmorMaterial CUARMOR = EnumHelper.addArmorMaterial("copper_armor",
            10, new int[]{2,6,5,2}, 12);
    //durability, [armor per piece], ench

    public static ClientProxy clientProxy;
    public static CommonProxy commonProxy;
    //Blocks
    public static CopperBlock cuBlock;

    //Items
    public static CopperIngot cuIngot;
    public static MyBow coolBow;
    public static MyArrow coolArrow;

    //Tools
    public static CopperSword cuSword;
    public static CopperPick  cuPick;

    //Armor
    public static CopperArmor cuHelmet;
    public static CopperArmor cuChest;
    public static CopperArmor cuLeg;
    public static CopperArmor cuBoots;

    //Food
    public static Tortilla tort;
    public static CandyCorn cc;

    public static Block metalworkingBench;
    public static final int guiIDMetalworkingBench = 1;

    @Mod.Instance(MODID)
    public static MyMod instance;


    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
        cuBlock = new CopperBlock(Material.iron);
        GameRegistry.registerBlock
                (   cuBlock, cuBlock.getUnlocalizedName()    );

        cuIngot = new CopperIngot();
        GameRegistry.registerItem
                (   cuIngot, cuIngot.getUnlocalizedName()    );

        coolBow = new MyBow();
        coolBow.setUnlocalizedName("my_bow");
        GameRegistry.registerItem
                (   coolBow, coolBow.getUnlocalizedName()    );

        coolArrow = new MyArrow();
        GameRegistry.registerItem
                (   coolArrow, coolArrow.getUnlocalizedName());

        cuPick = new CopperPick(COPPER);
        GameRegistry.registerItem
                (   cuPick, cuPick.getUnlocalizedName()      );

        cuSword = new CopperSword(COPPER);
        GameRegistry.registerItem
                (   cuSword, cuSword.getUnlocalizedName()    );
        //Armor
        cuHelmet = new CopperArmor(CUARMOR, 0, "copper_helmet");
        cuChest = new CopperArmor(CUARMOR, 1, "copper_chest");
        cuLeg = new CopperArmor(CUARMOR, 2, "copper_leg");
        cuBoots = new CopperArmor(CUARMOR, 3, "copper_boots");

        GameRegistry.registerItem
                (cuHelmet, cuHelmet.getUnlocalizedName());
        GameRegistry.registerItem
                (cuChest, cuChest.getUnlocalizedName());
        GameRegistry.registerItem
                (cuLeg, cuLeg.getUnlocalizedName());
        GameRegistry.registerItem
                (cuBoots, cuBoots.getUnlocalizedName());


        //Food
        tort = new Tortilla(2, 0.1F, false);
        GameRegistry.registerItem
                (tort, tort.getUnlocalizedName());
        cc = new CandyCorn(1, 1.0f, cuBlock, Blocks.dirt);
        GameRegistry.registerItem(cc, "cc");

        GameRegistry.registerWorldGenerator(new OreManager(), 0);

        metalworkingBench = new BlockMetalworkingBench();
        GameRegistry.registerBlock(metalworkingBench, "mwb");

////////////////////////////////////////////////////////////////////////
        //Arrow
        RenderingRegistry.registerEntityRenderingHandler
                (EntityMyArrow.class, new ArrowRenderer());

        EntityRegistry.registerGlobalEntityID(EntityMyArrow.class, "my_arrow",
                EntityRegistry.findGlobalUniqueEntityId());

        EntityRegistry.registerModEntity(EntityMyArrow.class, "my_arrow", 1,
                MyMod.MODID, 128, 1, true);

/////////////////////////////////////////////////////////////////////////

        GameRegistry.addShapelessRecipe
                (new ItemStack(cuIngot, 9), new ItemStack(cuBlock));

        GameRegistry.addShapedRecipe(new ItemStack(cuBlock),
                "iii",
                "iii",
                "iii",
                'i', new ItemStack(cuIngot));

        GameRegistry.addShapedRecipe(new ItemStack(cuPick),
                "iii",
                " s ",
                " s ",
                'i', new ItemStack(cuIngot),
                's', new ItemStack(Items.stick));

        GameRegistry.addShapedRecipe(new ItemStack(cuSword),
                " i ",
                " i ",
                " s ",
                'i', new ItemStack(cuIngot),
                's', new ItemStack(Items.stick));

        NetworkRegistry.INSTANCE.registerGuiHandler
                (this, new GuiHandler());
    }
}












