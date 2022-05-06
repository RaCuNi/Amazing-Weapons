package thisisracuni.amazing_weapons.weapon;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.weapon.base.GreatSwordItem;

public class GreatSwordSunlight extends GreatSwordItem {

    public GreatSwordSunlight(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings,
            double reachBonus, double attackReachBonus, double knockback, double knockbackResistance, double movementSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, settings, reachBonus, attackReachBonus, knockback, knockbackResistance, movementSpeed);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }
  
    public int getMaxUseTime(ItemStack stack) {
        return 25;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        playerEntity.setCurrentHand(hand);
        playerEntity.getItemCooldownManager().set(itemStack.getItem(), 60);
        return TypedActionResult.consume(itemStack);
    }
        

        /*ItemStack stack = playerEntity.getStackInHand(Hand.MAIN_HAND);

        if(!world.isClient) {
            if(playerEntity.isOnGround()) {
                playerEntity.getItemCooldownManager().set(this, 20);
                //AbilityGreatSwordSunlight.upper_attack_aoe(world, playerEntity);
                stack.damage(10, playerEntity, (p) -> {p.sendToolBreakStatus(hand);});
                world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.PLAYERS, 2f, 1f);
                
            } 
            
            else if(!playerEntity.getItemCooldownManager().isCoolingDown(this)){
                playerEntity.getItemCooldownManager().set(this, 40);
                stack.damage(20, playerEntity, (p) -> {p.sendToolBreakStatus(hand);});
                world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.BLOCK_ANVIL_DESTROY, SoundCategory.PLAYERS, 2f, 1f);
            }
            
        }*/

        /*if(world.isClient) {
            if(playerEntity.isOnGround()) {
                
            playerEntity.addVelocity(0, 1, 0);
            } else {
                playerEntity.addVelocity(0, -2, 0);
            }
        }*/
        //return TypedActionResult.pass(stack);
}
