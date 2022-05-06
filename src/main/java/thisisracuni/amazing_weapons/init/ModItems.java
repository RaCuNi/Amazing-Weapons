package thisisracuni.amazing_weapons.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import thisisracuni.amazing_weapons.AmazingWeapons;
import thisisracuni.amazing_weapons.item.ItemBloodDrop;
import thisisracuni.amazing_weapons.item.ItemRedOrb;
import thisisracuni.amazing_weapons.weapon.DaggerBloodyBladeTrue;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;
import thisisracuni.amazing_weapons.weapon.base.CustomToolMaterial;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;
import thisisracuni.amazing_weapons.weapon.tool.DaggerSacrifice;

public class ModItems {
    // CONSTANTS
	public static final int BLOODY_BLADE_TRUE_DAMAGE = 7;
	public static final float DAGGER_ITEM_REACH = -1;

	public static final int SUNLIGHT_GREATSWORD_DAMAGE = 8;
	public static final float GREATSWORD_ITEM_REACH = 2;
	public static final double SUNLIGHT_GREATSWORD_KB = 3;
	public static final double SUNLIGHT_GREATSWORD_KB_RESISTANCE = 5;
	public static final double SUNLIGHT_GREATSWORD_MV_SPEED = -0.035;

	
	
    // ItemGroups, Items, Tools, etc...
	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(new Identifier(AmazingWeapons.MOD_ID, "general"), () -> new ItemStack(Items.APPLE));
	public static final Item RED_ORB = new ItemRedOrb(new Item.Settings().group(MOD_GROUP));
	public static final Item BLOOD_DROP = new ItemBloodDrop(new Item.Settings().group(MOD_GROUP).maxCount(1));
	public static final ToolItem DAGGER_SACRIFICE = new DaggerSacrifice(CustomToolMaterial.BLOOD, 2, 0.4f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
	public static final ToolItem BLOODY_BLADE = new DaggerItem(CustomToolMaterial.BLOOD, 4, -2.0f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
	public static final ToolItem BLOODY_BLADE_TRUE = new DaggerBloodyBladeTrue(CustomToolMaterial.BLOOD, BLOODY_BLADE_TRUE_DAMAGE, -1.5f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
	public static final ToolItem SUNLIGHT_GREATSWORD = new GreatSwordSunlight(CustomToolMaterial.SUNSTONE, SUNLIGHT_GREATSWORD_DAMAGE, -3.25f, new Item.Settings().group(MOD_GROUP), GREATSWORD_ITEM_REACH, GREATSWORD_ITEM_REACH, SUNLIGHT_GREATSWORD_KB, SUNLIGHT_GREATSWORD_KB_RESISTANCE, SUNLIGHT_GREATSWORD_MV_SPEED);
    
    public static void init() {
        //Items & etc...
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "red_orb"), RED_ORB);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "blood_drop"), BLOOD_DROP);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "sacrifice_dagger"), DAGGER_SACRIFICE);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "bloody_blade"), BLOODY_BLADE);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "true_bloody_blade"), BLOODY_BLADE_TRUE);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "sunlight_greatsword"), SUNLIGHT_GREATSWORD);
    }
    
}
