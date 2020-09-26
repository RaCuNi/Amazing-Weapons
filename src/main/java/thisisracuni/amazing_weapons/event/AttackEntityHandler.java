package thisisracuni.amazing_weapons.event;

import java.util.Random;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        Random rand = new Random();
        Boolean isAlive = entity.isAlive();
        ItemStack stack = new ItemStack(Items.WITHER_SKELETON_SKULL);
        player.sendMessage(Text.of(isAlive.toString()), false);
        if(!world.isClient && playerStack.getItem().equals(AmazingWeapons.DAGGER_SACRIFICE) && entity instanceof ZombieEntity) {
            player.sendMessage(Text.of("TEST!"), false);
            int randNumber = rand.nextInt(2);
            if(randNumber == 1 && entity.removed) {
                entity.dropStack(stack);
                return ActionResult.SUCCESS;
            }
        }
            return ActionResult.PASS; 
    }
}
