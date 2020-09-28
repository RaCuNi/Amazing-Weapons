package thisisracuni.amazing_weapons.weapon.base;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DaggerItem extends SwordItem {

    public static double reach = 0;
    public static double attack_range = 0;
    //private static LivingEntity liver = null;
    //private static boolean active_state = false;

    public DaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, double reachBonus, double attackReachBonus) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        reach = reachBonus;
        attack_range = attackReachBonus;
    }
    /*
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient) {
            if(active_state != (((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() instanceof DaggerItem)) {
                System.out.println("New enitiy reaching: " + entity);
                liver = (LivingEntity)entity;
                SetRange(((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() instanceof DaggerItem);
            }
            active_state = ((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() instanceof DaggerItem;
        }
    }

    public void SetRange(boolean change_range) {
        if(change_range) {
            System.out.println("DaggerItem On");
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(reach);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(attack_range);
        } else {
            System.out.println("DaggerItem Off");
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    } */
    
}
