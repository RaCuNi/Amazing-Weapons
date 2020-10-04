package thisisracuni.amazing_weapons.statuseffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import thisisracuni.amazing_weapons.weapon.DaggerBloodyBladeTrue;

public class BloodyStatusEffect extends StatusEffect {

    public BloodyStatusEffect() {
        super(StatusEffectType.BENEFICIAL, 0x98D982);
    }

    // This method is called every tick to check weather it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }
     
    // This method is called when it applies the status effect. We implement custom functionality here.
    //Based on StatusEffect.class - Poison Effect. Unlike that, it kills.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //Dagger Healing BOOST!!
        DaggerBloodyBladeTrue.BLOODY_BLADE_TRUE_DRAIN_HEALTH = 4; // Quadraple Drain
        
        //entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION)); //REGENERATION
        if (entity.getHealth() < entity.getMaxHealth()) {
            entity.heal(1.0F);
        }

        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE)); //HASTE
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST)); //JUMP_BOOST
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION)); //NIGHT VISION
    }
    
}
