package com.example.examplemod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final Item.ToolMaterial BLOO = EnumHelper.addToolMaterial
            ("bloo_tool", 2, 1200, 8.0F, 3.0F, 22);
            // Name, harvest level, durability, block dmg, ent dmg, ench
    public static final ItemArmor.ArmorMaterial BLOOA =
                    EnumHelper.addArmorMaterial("bloo_armor", 30,
                    new int[]{3, 7, 4, 3}, 22);
    //name, durability, armor points per piece, enchantability
    //      (dia is 33), helmet -> boots, how easily get good enchant

    public static MyOre mOre;
    public static BlooSword bSword;
    public static BlooIngot bloo;

    public static Strawberries strawberry;
    public static StrawberryBush strawberryBush;
    public static ChocoStrawberry chocoSBerry;

    public static BlooBush blooberryBlock;
    public static Blooberries blooberry;

    //Armor
    public static Item bHelmet;
    public static Item bChest;
    public static Item bLeggings;
    public static Item bBoots;

    //Bows and Arrows
    public static Item explodingBow;
    public static Item explodingArrow;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		MyBlock mBlock = new MyBlock(Material.ice);
        GameRegistry.registerBlock(mBlock, "my_block");

        mOre = new MyOre(Material.rock);
        GameRegistry.registerBlock(mOre, "my_ore");

        bloo = new BlooIngot();
        GameRegistry.registerItem(bloo, "bloo_ingot");

        bSword = new BlooSword(BLOO);
        GameRegistry.registerItem(bSword, "bloo_sword");

        blooberryBlock = new BlooBush();
        GameRegistry.registerBlock(blooberryBlock, "blooBlock");

        blooberry = new Blooberries();
        GameRegistry.registerItem(blooberry, "blooberry");

        strawberryBush = new StrawberryBush();
        GameRegistry.registerBlock(strawberryBush, "strawberry_bush");

        strawberry = new Strawberries();
        GameRegistry.registerItem(strawberry, "strawberry");

        chocoSBerry = new ChocoStrawberry(8, 06f, false);
        GameRegistry.registerItem(chocoSBerry, "chocoSBerry");

        BlooPick bPick = new BlooPick(BLOO);
        GameRegistry.registerItem(bPick, "bloo_pick");

        //Armor
        bHelmet = new BlooArmor(BLOOA, 0, "bloo_helmet");
        bChest = new BlooArmor(BLOOA, 1, "bloo_chestplate");
        bLeggings = new BlooArmor(BLOOA, 2, "bloo_leggings");
        bBoots = new BlooArmor(BLOOA, 3, "bloo_boots");

        GameRegistry.registerItem(bHelmet, "bHelm");
        GameRegistry.registerItem(bChest, "bChest");
        GameRegistry.registerItem(bLeggings, "bLegs");
        GameRegistry.registerItem(bBoots, "bBoots");

        SteakSandwich ss = new SteakSandwich(12, 0.9f, true);
        GameRegistry.registerItem(ss, "steak_sandwich");

        //BOWS AND ARROWS
        explodingBow = new ItemExplodingBow();
        GameRegistry.registerItem(explodingBow, "explodingBow");

        explodingArrow = new ItemExplodingArrow();
        GameRegistry.registerItem(explodingArrow, "explodingArrow");

        //bow rendering
        RenderingRegistry.registerEntityRenderingHandler(
                EntityExplodingArrow.class, new RenderExplodingArrow());

        EntityRegistry.registerGlobalEntityID(EntityExplodingArrow.class,
                "exploding_arrow", EntityRegistry.findGlobalUniqueEntityId());

        EntityRegistry.registerModEntity(EntityExplodingArrow.class,
                "exploding_arrow", 1, "examplemod", 128, 1, true);
        //Raise right Thumb

        /*RenderingRegistry.registerEntityRenderingHandler(
                EntityExplodingArrow.class, new RenderExplodingArrow());
        EntityRegistry.registerModEntity(EntityExplodingArrow.class,
                "mystery_arrow", 1, this, 128, 1, true);*/

        GameRegistry.addShapelessRecipe(
                new ItemStack(ss),
                new ItemStack(Items.bread),
                new ItemStack(Items.bread),
                new ItemStack(Items.cooked_beef),
                new ItemStack(Items.baked_potato)
        );

        //Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(bloo, 9),
                new ItemStack(mBlock), new ItemStack(Items.stick));

        GameRegistry.addShapedRecipe(new ItemStack(mBlock),
                "iii",
                "iii",
                "iii",
                'i', new ItemStack(bloo));

        GameRegistry.addShapedRecipe(new ItemStack(bSword),
                " i ",
                " i ",
                " s ",
                'i', new ItemStack(bloo),
                's', new ItemStack(Items.stick));

        GameRegistry.addShapedRecipe(new ItemStack(chocoSBerry),
                "ccc",
                "csc",
                "ccc",
                'c', new ItemStack(Items.dye, 1, 3),
                's', new ItemStack(strawberry));

        GameRegistry.addSmelting(mOre, new ItemStack(bloo, 1), 10.1f);

        OreManager om = new OreManager();
        GameRegistry.registerWorldGenerator(om, 0); //int = order
    }
}
