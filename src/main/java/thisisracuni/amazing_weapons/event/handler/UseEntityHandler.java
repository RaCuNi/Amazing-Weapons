package thisisracuni.amazing_weapons.event.handler;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;
import thisisracuni.amazing_weapons.weapon.ability.AbilityGreatSwordSunlight;

public class UseEntityHandler implements UseEntityCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, /*@Nullable*/ EntityHitResult hitResult) {
        if(!world.isClient && !player.isSpectator()) { //It's necessary.
            if(player.getMainHandStack().getItem() instanceof GreatSwordSunlight && entity instanceof LivingEntity && !player.getItemCooldownManager().isCoolingDown(player.getMainHandStack().getItem())) {
                if(player.isOnGround()) {
                    AbilityGreatSwordSunlight.upper_attack_aoe(world, player, entity);
                } else {
                    AbilityGreatSwordSunlight.takedown_attack_aoe(world, player, entity);
                }
            }
        }

        if(world.isClient && !player.isSpectator()) {
            if(player.getMainHandStack().getItem() instanceof GreatSwordSunlight && entity instanceof LivingEntity && !player.getItemCooldownManager().isCoolingDown(player.getMainHandStack().getItem())) {
                if(player.isOnGround()) {
                    player.addVelocity(0, 0.6, 0);
                } else {
                    player.addVelocity(0, -1.5, 0);
                }
            }
        }
        return ActionResult.PASS;
    }
    
}
