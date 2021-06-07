package thisisracuni.amazing_weapons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import thisisracuni.amazing_weapons.event.AttackEntityHandler;
import thisisracuni.amazing_weapons.event.EntityDropCallback;
import thisisracuni.amazing_weapons.event.EntityDropHandler;
import thisisracuni.amazing_weapons.event.InventoryUpdateCallback;
import thisisracuni.amazing_weapons.event.InventoryUpdateHandler;
import thisisracuni.amazing_weapons.event.ItemPickUpCallback;
import thisisracuni.amazing_weapons.event.ItemPickUpHandler;
import thisisracuni.amazing_weapons.item.ItemBloodDrop;
import thisisracuni.amazing_weapons.item.ItemRedOrb;
import thisisracuni.amazing_weapons.weapon.CustomToolMaterial;
import thisisracuni.amazing_weapons.weapon.DaggerBloodyBladeTrue;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;
import thisisracuni.amazing_weapons.weapon.tool.DaggerSacrifice;

//import thisisracuni.amazing_weapons.init.ZombieLoot;

public class AmazingWeapons implements ModInitializer {
	public static final String MOD_ID = "amazing_weapons";
	
	public static final Tag<Item> DAGGERS_TAG = TagRegistry.item(new Identifier("amazing_weapons", "daggers"));

	//CONSTANTS
	public static final float BLOODY_BLADE_TRUE_DAMAGE = 7;
	public static final float DAGGER_ITEM_REACH = -1;

	// Sounds
	public static final Identifier DAGGER_USE_SOUND_ID = new Identifier("amazing_weapons:dagger_sacrificing");
	public static final SoundEvent DAGGER_USE_SOUND_EVENT = new SoundEvent(DAGGER_USE_SOUND_ID);

	// ItemGroups, Items, Tools, etc...
	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(Items.APPLE));
	public static final Item RED_ORB = new ItemRedOrb(new Item.Settings().group(MOD_GROUP));
	public static final Item BLOOD_DROP = new ItemBloodDrop(new Item.Settings().group(MOD_GROUP));
	public static final ToolItem DAGGER_SACRIFICE = new DaggerSacrifice(CustomToolMaterial.BLOOD, 2, 0.4f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
	public static final ToolItem BLOODY_BLADE = new DaggerItem(CustomToolMaterial.BLOOD, 4, -2.0f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);
	public static final ToolItem BLOODY_BLADE_TRUE = new DaggerBloodyBladeTrue(CustomToolMaterial.BLOOD, (int)BLOODY_BLADE_TRUE_DAMAGE, -1.5f, new Item.Settings().group(MOD_GROUP), DAGGER_ITEM_REACH, DAGGER_ITEM_REACH);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.

		// Loot Tables
		//ZombieLoot zombieloot = new ZombieLoot();
		//zombieloot.init();

		//Events
		//UseItemCallback.EVENT.register(new UseItemHandler());
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		EntityDropCallback.EVENT.register(new EntityDropHandler());
		//ItemPickUpCallback.EVENT.register(new ItemPickUpHandler());
		InventoryUpdateCallback.EVENT.register(new InventoryUpdateHandler());


		//Sounds
		Registry.register(Registry.SOUND_EVENT, AmazingWeapons.DAGGER_USE_SOUND_ID, DAGGER_USE_SOUND_EVENT);


		//Items, Blocks, etc...
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "red_orb"), RED_ORB);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blood_drop"), BLOOD_DROP);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sacrifice_dagger"), DAGGER_SACRIFICE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bloody_blade"), BLOODY_BLADE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "true_bloody_blade"), BLOODY_BLADE_TRUE);
	}
}
