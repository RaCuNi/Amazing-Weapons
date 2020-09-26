package thisisracuni.amazing_weapons.weapon.tool;

import java.util.Random;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
//import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.AmazingWeapons;

public class DaggerSacrifice extends SwordItem {

    public DaggerSacrifice(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        ItemStack stack = playerEntity.getStackInHand(Hand.MAIN_HAND);
        Random rand = new Random(); // To drop BLOOD_DROP item by random.

        if(!world.isClient && !playerEntity.isCreative() && playerEntity.getHealth() > 1) {
            //playerEntity.sendMessage(Text.of("Your HP is more than half heart now."), false);
            playerEntity.setHealth(playerEntity.getHealth()-1);
            //playerEntity.sendMessage(Text.of(Boolean.toString(stack.isDamageable())), false);
            stack.damage(1, playerEntity, (p) -> {p.sendToolBreakStatus(hand);});
            world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), AmazingWeapons.DAGGER_USE_SOUND_EVENT, SoundCategory.PLAYERS, 2f, 1f);

            int randNumber = rand.nextInt(25); // 0 <= randNumber < 25, randNumber is int.
            //playerEntity.sendMessage(Text.of(Integer.toString(randNumber)), false);

            if(randNumber == 1) {
                ItemStack stackBlood = new ItemStack(AmazingWeapons.BLOOD_DROP);
                ItemEntity itemEntity = new ItemEntity(world, playerEntity.getX(), playerEntity.getY() + 1, playerEntity.getZ(), stackBlood);
                world.spawnEntity(itemEntity);
                //playerEntity.sendMessage(Text.of("randNumber is 1, spawned blood drop!"), false);
                return TypedActionResult.success(stack);
            }
        }

        return TypedActionResult.pass(stack);
    }

    
    
}
