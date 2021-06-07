package thisisracuni.amazing_weapons.weapon.ability;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class AbilityGreatSwordSunlight {
    // Cause mobs to target themselves
    public static void upper_attack_aoe(World world, PlayerEntity player, Entity target) {
        // Scan for LivingEntities
        Box targetBox = target.getBoundingBox().expand(1.2, 0.25, 1.2);
        List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, targetBox);
        Iterator<LivingEntity> iterator = list.iterator();
        LivingEntity targetInAOE;

        // Cycle through and effect entities
        while (iterator.hasNext()) {
            targetInAOE = iterator.next();
            if (targetInAOE != player /*HostileEntity*/) {
                targetInAOE.damage(DamageSource.player(player), 3.0f);
                targetInAOE.addVelocity(0, 0.45, 0);
			}
        }
    }

    public static void takedown_attack_aoe(World world, PlayerEntity player, Entity target) {
        // Scan for LivingEntities
        Box targetBox = target.getBoundingBox().expand(1.5, 0.25, 1.5);
        List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, targetBox);
        Iterator<LivingEntity> iterator = list.iterator();
        LivingEntity targetInAOE;

        // Cycle through and effect entities
        while (iterator.hasNext()) {
            targetInAOE = iterator.next();
            if (targetInAOE != player /*HostileEntity*/) {
                targetInAOE.damage(DamageSource.player(player), 5.5f);
                targetInAOE.addVelocity(0, -0.6, 0);
			}
        }
    }
}
