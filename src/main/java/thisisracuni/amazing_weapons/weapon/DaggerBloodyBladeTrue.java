package thisisracuni.amazing_weapons.weapon;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.AmazingWeapons;
import thisisracuni.amazing_weapons.ability.AbilityBloodyBladeTrue;
import thisisracuni.amazing_weapons.init.Particles;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

public class DaggerBloodyBladeTrue extends DaggerItem {

    public static float BLOODY_BLADE_TRUE_DRAIN_HEALTH = 1;//AmazingWeapons.BLOODY_BLADE_TRUE_DAMAGE / 7;


    public DaggerBloodyBladeTrue(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, double reachBonus, double attackReachBonus) {
        super(toolMaterial, attackDamage, attackSpeed, settings, reachBonus, attackReachBonus);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack thisStack = player.getStackInHand(Hand.MAIN_HAND);

            if (!world.isClient) {
                player.addStatusEffect(new StatusEffectInstance(AmazingWeapons.BLOODY, 10 * 20)); //buff
                player.addStatusEffect(new StatusEffectInstance(AmazingWeapons.ANEMIA, 14 * 20)); //debuff
                AbilityBloodyBladeTrue.check_attack_Mobs(world, player, 3);
            }
    
    
            if(world.isClient) {
                Vec3d middle = player.getPos(); //get player location (x, y, z)
                float base_radius = 2f; //1.5f; - default
                
                for(Vec3d vec : getCircle(middle, base_radius, 360f, 10f)) {
                    for(float i = 0; i <= 1; i+=0.1) {
                        world.addParticle(Particles.BLOODY_STORM, vec.x, vec.y+i, vec.z, 0, 0, 0); //1
                    }
                }
                
                for(Vec3d vec : getCircle(middle, base_radius+0.5f, 360f, 10f)) {
                    for(float i = 0; i <= 1.5; i+=0.1) {
                        world.addParticle(Particles.BLOODY_STORM, vec.x, vec.y+i+1, vec.z, 0, 0, 0); //2.5
                    }
                }
    
                for(Vec3d vec : getCircle(middle, base_radius+1f, 360f, 10f)) {
                    for(float i = 0; i <= 3; i+=0.1) {
                        world.addParticle(Particles.BLOODY_STORM, vec.x, vec.y+i+2.5, vec.z, 0, 0, 0); // 5.5
                    }
                }
    
                for(Vec3d vec : getCircle(middle, base_radius+1.5f, 360f, 10f)) {
                    for(float i = 0; i <= 2.5; i+=0.1) {
                        world.addParticle(Particles.BLOODY_STORM, vec.x, vec.y+i+5.5, vec.z, 0, 0, 0); // 8
                    }
                }
                //return TypedActionResult.success(thisStack);
    
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
