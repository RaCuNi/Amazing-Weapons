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
import thisisracuni.amazing_weapons.weapon.base.CustomToolMaterial;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;
import thisisracuni.amazing_weapons.weapon.tool.DaggerSacrifice;

public class ModItems {
    // CONSTANTS
	public static final float BLOODY_BLADE_TRUE_DAMAGE = 7;
    public static final float DAGGER_ITEM_REACH = -1;
    
    // ItemGroups, Items, Tools, etc...
	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(new Identifier(AmazingWeapons.MOD_ID, "general"), () -> new ItemStack(Items.APPLE));
	public static final Item RED_ORB = new ItemRedOrb(new Item.Settings().group(MOD_GROUP));
	public static final Item BLOOD_DROP = new ItemBloodDrop(new Item.Settings().group(MOD_GROUP).maxCount(1));
	public static final ToolItem DAGGER_SACRIFICE = new DaggerSacrifice(CustomToolMaterial.BLOOD, 2, 0.4f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
	public static final ToolItem BLOODY_BLADE = new DaggerItem(CustomToolMaterial.BLOOD, 4, -2.0f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
    public static final ToolItem BLOODY_BLADE_TRUE = new DaggerBloodyBladeTrue(CustomToolMaterial.BLOOD, (int)BLOODY_BLADE_TRUE_DAMAGE, -1.5f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
    
    public static void init() {
        //Items & etc...
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "red_orb"), RED_ORB);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "blood_drop"), BLOOD_DROP);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "sacrifice_dagger"), DAGGER_SACRIFICE);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "bloody_blade"), BLOODY_BLADE);
		Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "true_bloody_blade"), BLOODY_BLADE_TRUE);
    }
    
}
