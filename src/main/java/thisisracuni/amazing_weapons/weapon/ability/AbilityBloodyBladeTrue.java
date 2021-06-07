package thisisracuni.amazing_weapons.weapon.ability;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.init.ModStatusEffects;

public class AbilityBloodyBladeTrue {

    // Cause mobs to target themselves, disable AI on creepers and skeleton
    public static void check_attack_Mobs(World world, PlayerEntity player, int radius) {
        // Scan for LivingEntities
        BlockPos boxCeterPos = player.getBlockPos().add(0, 2, 0);
        Box mobBox = (new Box(boxCeterPos)).expand(radius, 2.0f, radius);
        List<Entity> list = world.getNonSpectatingEntities(Entity.class, mobBox);
        Iterator<Entity> iterator = list.iterator();
        Entity targetEntity;

        // Cycle through and effect entities
        while (iterator.hasNext()) {
            targetEntity = (Entity) iterator.next();
            if (targetEntity instanceof LivingEntity && targetEntity != player /*HostileEntity*/) {
                ((LivingEntity)targetEntity).applyStatusEffect(new StatusEffectInstance(ModStatusEffects.BLEED, 6 * 20, 4/2));
                ((LivingEntity)targetEntity).applyStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION/*.addAttributeModifier(EntityAttributes.GENERIC_FLYING_SPEED -> PlayerEntity doesn't have it, "8592ff4b-6a0a-410a-b0bb-fae68811be3c", -0.4000000059604645D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)*/, 5 * 20, 1));
                ((LivingEntity)targetEntity).applyStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5 * 20, 4));
                ((LivingEntity)targetEntity).applyStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 5 * 20, 1));
			}
        }
    }
}
