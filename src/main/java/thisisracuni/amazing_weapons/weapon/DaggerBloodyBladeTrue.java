package thisisracuni.amazing_weapons.weapon;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.weapon.ability.AbilityBloodyBladeTrue;
import thisisracuni.amazing_weapons.init.ModItems;
import thisisracuni.amazing_weapons.init.ModParticles;
import thisisracuni.amazing_weapons.init.ModStatusEffects;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

public class DaggerBloodyBladeTrue extends DaggerItem {

    public static float BLOODY_BLADE_TRUE_DRAIN_HEALTH = 1;//AmazingWeapons.BLOODY_BLADE_TRUE_DAMAGE / 7;


    public DaggerBloodyBladeTrue(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, double reachBonus, double attackReachBonus) {
        super(toolMaterial, attackDamage, attackSpeed, settings, reachBonus, attackReachBonus);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack thisStack = player.getStackInHand(Hand.MAIN_HAND);
        ItemStack bloodStack = new ItemStack(ModItems.BLOOD_DROP, 1);

        player.getItemCooldownManager().set(this, 100);

        if(player.inventory.count(ModItems.BLOOD_DROP) >= 4) {

            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_WITHER_HURT, SoundCategory.PLAYERS, 0.5f, 1f);

            for(int i = 0; i < 4; i++) {
                int slot = player.inventory.getSlotWithStack(bloodStack);
                player.inventory.setStack(slot, new ItemStack(Items.AIR));
            }

            if (!world.isClient) {
                player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BLOODY, 200)); //buff
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 180));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 180));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 180));

                player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.ANEMIA, 280)); //debuff

                AbilityBloodyBladeTrue.check_attack_Mobs(world, player, 3); //actual ability
            }
    
    
            if(world.isClient) {
                Vec3d middle = player.getPos(); //get player location (x, y, z)
                float base_radius = 2f; //1.5f; - default
                
                for(Vec3d vec : getCircle(middle, base_radius, 360f, 10f)) {
                    for(float i = 0; i <= 1; i+=0.1) {
                        world.addParticle(ModParticles.BLOODY_STORM, vec.x, vec.y+i, vec.z, 0, 0, 0); //1
                    }
                }
                
                for(Vec3d vec : getCircle(middle, base_radius+0.5f, 360f, 10f)) {
                    for(float i = 0; i <= 1.5; i+=0.1) {
                        world.addParticle(ModParticles.BLOODY_STORM, vec.x, vec.y+i+1, vec.z, 0, 0, 0); //2.5
                    }
                }
    
                for(Vec3d vec : getCircle(middle, base_radius+1f, 360f, 10f)) {
                    for(float i = 0; i <= 3; i+=0.1) {
                        world.addParticle(ModParticles.BLOODY_STORM, vec.x, vec.y+i+2.5, vec.z, 0, 0, 0); // 5.5
                    }
                }
    
                for(Vec3d vec : getCircle(middle, base_radius+1.5f, 360f, 10f)) {
                    for(float i = 0; i <= 2.5; i+=0.1) {
                        world.addParticle(ModParticles.BLOODY_STORM, vec.x, vec.y+i+5.5, vec.z, 0, 0, 0); // 8
                    }
                }

                
            }
        } else {
            if(!world.isClient) {
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_ANVIL_DESTROY, SoundCategory.PLAYERS, 0.4f, 0.5f);
                player.sendMessage(Text.of("You don't have enough blood drops! To cast special ability, You should have that at least 4!"), false);
            }
        }
        return TypedActionResult.pass(thisStack);
    }

    public static List<Vec3d> getCircle(Vec3d middle, float radius, float maxAngle, float angle) {
        List<Vec3d> positions = new ArrayList<Vec3d>();
        for(float i = 0; i <= maxAngle; i+=angle) {
            double x = Math.cos(i) * radius;
            double z = Math.sin(i) * radius;
            Vec3d pos = new Vec3d(middle.getX() + x, middle.getY(), middle.getZ() + z);
            positions.add(pos);
        }
        return positions;
    }


}
