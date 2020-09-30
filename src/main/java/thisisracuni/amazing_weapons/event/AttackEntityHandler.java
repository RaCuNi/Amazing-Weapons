package thisisracuni.amazing_weapons.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.AmazingWeapons;

public class AttackEntityHandler implements AttackEntityCallback {
    
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, /* Nullable */ EntityHitResult hitResult) {

        ItemStack playerStack = player.getStackInHand(Hand.MAIN_HAND);
        float playerHealth = player.getHealth();
        float BLOODY_BLADE_TRUE_DRAIN_HEALTH = AmazingWeapons.BLOODY_BLADE_TRUE_DAMAGE / 7;

        if(!world.isClient && playerStack.getItem().equals(AmazingWeapons.BLOODY_BLADE_TRUE) && entity instanceof Monster) {
            //player.sendMessage(Text.of("TRUE BLOODY BLADE ATTACK TO MONSTER"), false);
            if(playerHealth >= 10) {
                player.heal(BLOODY_BLADE_TRUE_DRAIN_HEALTH);
            } else {
                player.heal(BLOODY_BLADE_TRUE_DRAIN_HEALTH * 2);
            }
        }

        return ActionResult.PASS; 
    }
}
