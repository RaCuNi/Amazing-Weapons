package thisisracuni.amazing_weapons.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    // Sounds
	public static final Identifier DAGGER_USE_SOUND_ID = new Identifier("amazing_weapons:dagger_sacrificing");
    public static final SoundEvent DAGGER_USE_SOUND_EVENT = new SoundEvent(DAGGER_USE_SOUND_ID);
    
    public static void init() {
        Registry.register(Registry.SOUND_EVENT, DAGGER_USE_SOUND_ID, DAGGER_USE_SOUND_EVENT);
    }
    
}
