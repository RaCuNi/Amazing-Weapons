package thisisracuni.amazing_weapons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import thisisracuni.amazing_weapons.init.Particles;

@Environment(EnvType.CLIENT)
public class AmazingWeaponsClient implements ClientModInitializer {

    @Override
	public void onInitializeClient() {
        Particles.registerClient();
	}
    
}