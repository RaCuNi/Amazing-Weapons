package thisisracuni.amazing_weapons.statuseffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import thisisracuni.amazing_weapons.weapon.DaggerBloodyBladeTrue;

public class AnemiaStatusEffect extends StatusEffect {

    public AnemiaStatusEffect() {
        super(StatusEffectType.HARMFUL, 0x98D982);
    }

    // This method is called every tick to check weather it should apply the status effect or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return duration == 4 * 20;
    }
     
    // This method is called when it applies the status effect. We implement custom functionality here.
    //Based on StatusEffect.class - Poison Effect. Unlike that, it kills.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        DaggerBloodyBladeTrue.BLOODY_BLADE_TRUE_DRAIN_HEALTH = 1; //Reset Drain

        //entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 4*20, 4*4*2)); //POISON
        if (entity.getHealth() > 1.0F) {
            entity.damage(DamageSource.MAGIC, 2.0F);
        }
        
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 4 * 20, 4*2)); //SLOWNESS
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 4 * 20, 4*2)); //WEAKNESS
        //entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA)); //NAUSEA
    }
}
