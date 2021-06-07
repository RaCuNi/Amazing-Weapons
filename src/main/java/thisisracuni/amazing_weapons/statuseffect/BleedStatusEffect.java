package thisisracuni.amazing_weapons.statuseffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class BleedStatusEffect extends StatusEffect {
    public BleedStatusEffect() {
        super(
          StatusEffectType.HARMFUL, // whether beneficial or harmful for entities
          0xB50707); // color in RGB
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
        if (entity.getHealth() > 0) {
            entity.damage(DamageSource.MAGIC, 2.0F);
        }
    }
    
}
