package thisisracuni.amazing_weapons.event;

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
import thisisracuni.amazing_weapons.AmazingWeapons;

public class EntityDropHandler implements EntityDropCallback {
    @Override
    public boolean onEntityDrop(LivingEntity entity, DamageSource damageSource) {

        if (damageSource.getAttacker() instanceof PlayerEntity) {

            Item attackerItem = damageSource.getAttacker().getItemsHand().iterator().next().getItem();
            //damageSource.getAttacker().sendSystemMessage(Text.of(attackerItem.toString()), null);

            if(attackerItem.equals(AmazingWeapons.DAGGER_SACRIFICE)) {
                Random rand = new Random();
                int randNumber = rand.nextInt(100); // 0 =< randNumber < 100

                if(entity instanceof Monster) {
                    if (randNumber < 3) {entity.dropItem(AmazingWeapons.BLOOD_DROP);}
                    

                    if(entity instanceof ZombieEntity && randNumber < 5) {
                        entity.dropItem(Items.ZOMBIE_HEAD); 
                        return true;
                    }
    
                    if(entity instanceof WitherSkeletonEntity && randNumber < 20) {
                        entity.dropItem(Items.WITHER_SKELETON_SKULL);
                        return true;
                    }
                }

            }   
        }
        return false;
    }
    
}
