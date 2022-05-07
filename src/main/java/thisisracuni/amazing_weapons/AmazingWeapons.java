package thisisracuni.amazing_weapons;

import net.fabricmc.api.ModInitializer;
//import software.bernie.geckolib3.GeckoLib;
import thisisracuni.amazing_weapons.init.ModBlocks;
import thisisracuni.amazing_weapons.init.ModEvents;
import thisisracuni.amazing_weapons.init.ModItems;
import thisisracuni.amazing_weapons.init.ModOreGens;
import thisisracuni.amazing_weapons.init.ModParticles;
import thisisracuni.amazing_weapons.init.ModSounds;
import thisisracuni.amazing_weapons.init.ModStatusEffects;
public class AmazingWeapons implements ModInitializer {

	// MOD ID
	public static final String MOD_ID = "amazing_weapons";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.

		//Libraries
		//GeckoLib.initialize();

		//Events
		ModEvents.init();

		//Sounds
		ModSounds.init();

		//Particles
		ModParticles.init();

		//Items & Blocks & etc...
		ModItems.init();
		ModBlocks.init();

		//World Gens
		ModOreGens.init();

		//Status Effects
		ModStatusEffects.init();

	}
}
