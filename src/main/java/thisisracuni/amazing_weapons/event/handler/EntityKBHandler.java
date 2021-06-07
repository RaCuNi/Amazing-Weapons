package thisisracuni.amazing_weapons.event.handler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import thisisracuni.amazing_weapons.event.callback.EntityKBCallback;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

public class EntityKBHandler implements EntityKBCallback {

    public ActionResult onTakingKnockback(LivingEntity entity, float power, double dx, double dz) {

        //System.out.println(""+entity.getAttacker()); //Debugging

        if(entity.getAttacker() != null) { // Attacker Null Check
            if(entity.getAttacker().getStackInHand(Hand.MAIN_HAND).getItem() instanceof DaggerItem) { //NPE - when killing slime, entity.getAttacker() can be null? -> because of sweeping edge -> Make DaggerItem not to be SwordItem
                System.out.println("Canceling KB!"); //Debugging
                return ActionResult.FAIL;
            }
        }
        
        return ActionResult.PASS;
    }
    
}
