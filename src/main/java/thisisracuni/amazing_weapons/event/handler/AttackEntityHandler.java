package thisisracuni.amazing_weapons.event.handler;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.init.ModItems;
import thisisracuni.amazing_weapons.init.ModParticles;
import thisisracuni.amazing_weapons.init.ModSounds;
import thisisracuni.amazing_weapons.weapon.DaggerBloodyBladeTrue;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

public class AttackEntityHandler implements AttackEntityCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, /* Nullable */ EntityHitResult hitResult) {

        ItemStack playerStack = player.getStackInHand(Hand.MAIN_HAND);
        float playerHealth = player.getHealth();
    
        if(!world.isClient && playerStack.getItem().equals(ModItems.BLOODY_BLADE_TRUE) && entity instanceof Monster) {
            //player.sendMessage(Text.of("TRUE BLOODY BLADE ATTACK TO MONSTER"), false);
            if(playerHealth >= 10) {
                player.heal(DaggerBloodyBladeTrue.BLOODY_BLADE_TRUE_DRAIN_HEALTH);
            } else {
                player.heal(DaggerBloodyBladeTrue.BLOODY_BLADE_TRUE_DRAIN_HEALTH * 2);
            }
        }

        if(player.getAttackCooldownProgress(0) >= 1 && playerStack.getItem() instanceof DaggerItem && entity.isAlive()){
            System.out.println("DaggerItem Charged Attack!"); //Debugging Message

            //Spawn DaggerStabParticle when charged attack triggered.
            double d = (double)(-MathHelper.sin(player.yaw * 0.017453292F));
            double e = (double)MathHelper.cos(player.yaw * 0.017453292F);
            if (world instanceof ServerWorld) {
                ((ServerWorld)world).spawnParticles(ModParticles.DAGGER_STAB, player.getX() + d, player.getBodyY(0.7D) /*player.getBodyY(0.5D)*/, player.getZ() + e, 0, d, 0.0D, e, 0.0D);
                ((ServerWorld)world).playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.DAGGER_ATTACK_SOUND_EVENT, SoundCategory.PLAYERS, 1f, 1f); //Play Sound
            }
        }

        return ActionResult.PASS; 
    }

}
