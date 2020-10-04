package thisisracuni.amazing_weapons.event;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.AmazingWeapons;
import thisisracuni.amazing_weapons.init.TickTimer;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

public class InventoryUpdateHandler implements InventoryUpdateCallback {

    PlayerEntity player;
    boolean dagger_active = false;

    public ActionResult interact(PlayerInventory inventory) {

        player = inventory.player;
        World world = inventory.player.world;
        
        if (!world.isClient) {
            if (dagger_active != inventory.getMainHandStack().getItem() instanceof DaggerItem) {
                SetRange(inventory.getMainHandStack().getItem() instanceof DaggerItem);
            }
            dagger_active = inventory.getMainHandStack().getItem() instanceof DaggerItem;
        }
        

        return ActionResult.PASS;
        
    }

    public void SetRange(boolean change_range) {
        if(change_range) {
            System.out.println("DaggerItem On");
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(AmazingWeapons.DAGGER_ITEM_REACH);
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(AmazingWeapons.DAGGER_ITEM_REACH);
        } else {
            System.out.println("DaggerItem Off");
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    }
    
}
