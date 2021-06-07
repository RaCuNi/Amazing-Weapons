package thisisracuni.amazing_weapons.event.handler;

import java.util.Random;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
//import net.minecraft.text.Text;
import thisisracuni.amazing_weapons.event.callback.EntityDropCallback;
import thisisracuni.amazing_weapons.init.ModItems;

public class EntityDropHandler implements EntityDropCallback {
    @Override
    public boolean onEntityDrop(LivingEntity entity, DamageSource damageSource) {

        if (damageSource.getAttacker() instanceof PlayerEntity) {

            Item attackerItem = damageSource.getAttacker().getItemsHand().iterator().next().getItem();
            //damageSource.getAttacker().sendSystemMessage(Text.of(attackerItem.toString()), null);

            if(entity instanceof Monster) {
                
                Random rand = new Random();
                int randNumber = rand.nextInt(100); // 0 =< randNumber < 100

                if(attackerItem.equals(ModItems.DAGGER_SACRIFICE)) {
                    if (randNumber < 3) {entity.dropItem(ModItems.BLOOD_DROP);}
                       
                    if(entity instanceof ZombieEntity && randNumber < 5) {
                           entity.dropItem(Items.ZOMBIE_HEAD); 
                    }
       
                    if(entity instanceof WitherSkeletonEntity && randNumber < 20) {
                           entity.dropItem(Items.WITHER_SKELETON_SKULL);
                    }
               }

               if(attackerItem.equals(ModItems.BLOODY_BLADE)) {
                   if(randNumber < 12) {entity.dropItem(ModItems.BLOOD_DROP);}
               }

               if(attackerItem.equals(ModItems.BLOODY_BLADE_TRUE)) {
                   if(randNumber < 25) {entity.dropItem(ModItems.BLOOD_DROP);}
               }
            }
        }
        return false;
    }
    
}
