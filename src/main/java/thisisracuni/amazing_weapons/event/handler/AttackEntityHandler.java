package thisisracuni.amazing_weapons.event.handler;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.init.ModItems;
import thisisracuni.amazing_weapons.init.ModParticles;
import thisisracuni.amazing_weapons.init.ModSounds;
import thisisracuni.amazing_weapons.weapon.DaggerBloodyBladeTrue;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;
import thisisracuni.amazing_weapons.weapon.ability.AbilityGreatSwordSunlight;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

public class AttackEntityHandler implements AttackEntityCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, /* Nullable */ EntityHitResult hitResult) {

        ItemStack playerStack = player.getStackInHand(Hand.MAIN_HAND);
        float playerHealth = player.getHealth();
    
        if(!world.isClient && playerStack.getItem().equals(ModItems.BLOODY_BLADE_TRUE) && entity instanceof LivingEntity) {
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

        if(!world.isClient && !player.isSpectator()) { //It's necessary.
            if(player.getMainHandStack().getItem() instanceof GreatSwordSunlight && entity instanceof LivingEntity && !player.getItemCooldownManager().isCoolingDown(player.getMainHandStack().getItem()) && player.isSneaking()) {
                ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);
                if(player.isOnGround()) {
                    AbilityGreatSwordSunlight.upper_attack_aoe(world, player, entity);
                    player.getItemCooldownManager().set(stack.getItem(), 20);
                    //AbilityGreatSwordSunlight.upper_attack_aoe(world, playerEntity);
                    stack.damage(10, player, (p) -> {p.sendToolBreakStatus(hand);});
                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.PLAYERS, 2f, 1f);
                } else {
                    AbilityGreatSwordSunlight.takedown_attack_aoe(world, player, entity);
                    if(!player.getItemCooldownManager().isCoolingDown(stack.getItem())){
                        player.getItemCooldownManager().set(stack.getItem(), 40);
                        stack.damage(20, player, (p) -> {p.sendToolBreakStatus(hand);});
                        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_ANVIL_DESTROY, SoundCategory.PLAYERS, 2f, 1f);
                    }
                }
            }
        }

        if(world.isClient && !player.isSpectator()) {
            if(player.getMainHandStack().getItem() instanceof GreatSwordSunlight && entity instanceof LivingEntity && !player.getItemCooldownManager().isCoolingDown(player.getMainHandStack().getItem()) && player.isSneaking()) {
                if(player.isOnGround()) {
                    player.addVelocity(0, 1.2, 0);
                } else {
                    player.addVelocity(0, -1.5, 0);
                }
            }
        }

        return ActionResult.PASS; 
    }

}
