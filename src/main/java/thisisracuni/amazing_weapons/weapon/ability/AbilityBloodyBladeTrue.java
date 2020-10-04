package thisisracuni.amazing_weapons.weapon.ability;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.init.ModStatusEffects;

public class AbilityBloodyBladeTrue {

    // Cause mobs to target themselves, disable AI on creepers and skeleton
    public static void check_attack_Mobs(World world, PlayerEntity player, int radius) {
        // Scan for hostile mobs
        Box mobBox = (new Box(player.getBlockPos())).expand(radius, 4.0f, radius);
        List<Entity> list2 = world.getNonSpectatingEntities(Entity.class, mobBox);
        Iterator iterator2 = list2.iterator();

        Entity targetEntity;

        // Cycle through and effect entities
        while (iterator2.hasNext()) {
            targetEntity = (Entity) iterator2.next();
            if (targetEntity instanceof HostileEntity) {
                ((LivingEntity)targetEntity).applyStatusEffect(new StatusEffectInstance(ModStatusEffects.BLEED, 6 * 20, 4/2));
                ((LivingEntity)targetEntity).applyStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 5 * 20, 1));
			}
		}
    }
}
