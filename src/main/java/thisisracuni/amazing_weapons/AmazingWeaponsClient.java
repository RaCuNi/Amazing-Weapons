package thisisracuni.amazing_weapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import thisisracuni.amazing_weapons.init.ModKeybinds;
import thisisracuni.amazing_weapons.init.ModParticles;

@Environment(EnvType.CLIENT)
public class AmazingWeaponsClient implements ClientModInitializer {

    @Override
	public void onInitializeClient() {
        ModParticles.initClient();
        ModKeybinds.initClient();
	}
    
}