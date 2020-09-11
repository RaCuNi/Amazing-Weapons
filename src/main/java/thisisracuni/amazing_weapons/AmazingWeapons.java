package thisisracuni.amazing_weapons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import thisisracuni.amazing_weapons.item.ItemBloodDrop;
import thisisracuni.amazing_weapons.item.ItemRedOrb;
import thisisracuni.amazing_weapons.weapon.CustomToolMaterial;
import thisisracuni.amazing_weapons.weapon.SwordBloodyBlade;

public class AmazingWeapons implements ModInitializer {

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(new Identifier("amazing_weapons", "general"), () -> new ItemStack(Items.APPLE));
	public static final Item RED_ORB = new ItemRedOrb(new Item.Settings().group(MOD_GROUP));
	public static final Item BLOOD_DROP = new ItemBloodDrop(new Item.Settings().group(MOD_GROUP));
	public static final ToolItem BLOODY_BLADE = new SwordBloodyBlade(CustomToolMaterial.BLOOD, 8, 5.0f, new Item.Settings().group(MOD_GROUP));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.

		System.out.println("Hello Fabric world!");

		Registry.register(Registry.ITEM, new Identifier("amazing_weapons", "red_orb"), RED_ORB);
		Registry.register(Registry.ITEM, new Identifier("amazing_weapons", "blood_drop"), BLOOD_DROP);
		Registry.register(Registry.ITEM, new Identifier("amazing_weapons", "bloody_blade"), BLOODY_BLADE);
	}
}
