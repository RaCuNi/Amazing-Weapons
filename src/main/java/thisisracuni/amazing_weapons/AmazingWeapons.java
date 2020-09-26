package thisisracuni.amazing_weapons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
//import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
//import thisisracuni.amazing_weapons.event.AttackEntityHandler;
import thisisracuni.amazing_weapons.event.EntityDropCallback;
import thisisracuni.amazing_weapons.event.EntityDropHandler;
//import thisisracuni.amazing_weapons.init.ZombieLoot;
import thisisracuni.amazing_weapons.item.ItemBloodDrop;
import thisisracuni.amazing_weapons.item.ItemRedOrb;
import thisisracuni.amazing_weapons.weapon.CustomToolMaterial;
import thisisracuni.amazing_weapons.weapon.tool.DaggerSacrifice;

public class AmazingWeapons implements ModInitializer {

	// Sounds
	public static final Identifier DAGGER_USE_SOUND_ID = new Identifier("amazing_weapons:dagger_sacrificing");
	public static SoundEvent DAGGER_USE_SOUND_EVENT = new SoundEvent(DAGGER_USE_SOUND_ID);

	// ItemGroups, Items, Tools, etc...
	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(new Identifier("amazing_weapons", "general"),
			() -> new ItemStack(Items.APPLE));
	public static final Item RED_ORB = new ItemRedOrb(new Item.Settings().group(MOD_GROUP));
	public static final Item BLOOD_DROP = new ItemBloodDrop(new Item.Settings().group(MOD_GROUP));
	public static final ToolItem BLOODY_BLADE = new SwordItem(CustomToolMaterial.BLOOD, 8, -2.0f,
			new Item.Settings().group(MOD_GROUP));
	public static final ToolItem DAGGER_SACRIFICE = new DaggerSacrifice(CustomToolMaterial.BLOOD, 3, 0.4f,
			new Item.Settings().group(MOD_GROUP));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Test Message
		System.out.println("Hello Fabric world!");


		// Loot Tables
		//ZombieLoot zombieloot = new ZombieLoot();
		//zombieloot.init();

		//Events
		//UseItemCallback.EVENT.register(new UseItemHandler());
		//AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		EntityDropCallback.EVENT.register(new EntityDropHandler());


		//Sounds
		Registry.register(Registry.SOUND_EVENT, AmazingWeapons.DAGGER_USE_SOUND_ID, DAGGER_USE_SOUND_EVENT);


		//Items, Blocks, etc...
		Registry.register(Registry.ITEM, new Identifier("amazing_weapons", "red_orb"), RED_ORB);
		Registry.register(Registry.ITEM, new Identifier("amazing_weapons", "blood_drop"), BLOOD_DROP);
		Registry.register(Registry.ITEM, new Identifier("amazing_weapons", "bloody_blade"), BLOODY_BLADE);
		Registry.register(Registry.ITEM, new Identifier("amazing_weapons", "sacrifice_dagger"), DAGGER_SACRIFICE);
	}
}
