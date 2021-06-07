package thisisracuni.amazing_weapons.init;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import thisisracuni.amazing_weapons.AmazingWeapons;
import thisisracuni.amazing_weapons.statuseffect.AnemiaStatusEffect;
import thisisracuni.amazing_weapons.statuseffect.BleedStatusEffect;
import thisisracuni.amazing_weapons.statuseffect.BloodyStatusEffect;

public class ModStatusEffects {

    // Status Effects
	public static final StatusEffect BLEED = new BleedStatusEffect();
	public static final StatusEffect BLOODY = new BloodyStatusEffect();
    public static final StatusEffect ANEMIA = new AnemiaStatusEffect();
    
    public static void init() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(AmazingWeapons.MOD_ID, "bleed"), BLEED);
		Registry.register(Registry.STATUS_EFFECT, new Identifier(AmazingWeapons.MOD_ID, "anemia"), ANEMIA);
		Registry.register(Registry.STATUS_EFFECT, new Identifier(AmazingWeapons.MOD_ID, "bloody"), BLOODY);
    }
    
}