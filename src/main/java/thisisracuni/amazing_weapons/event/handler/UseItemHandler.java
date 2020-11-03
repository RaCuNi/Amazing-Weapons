package thisisracuni.amazing_weapons.event.handler;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.init.ModStatusEffects;

public class UseItemHandler implements UseItemCallback {

    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        ItemStack stack = player.getStackInHand(Hand.MAIN_HAND);

        if((stack.getItem() instanceof MilkBucketItem) && (player.hasStatusEffect(ModStatusEffects.ANEMIA) || player.hasStatusEffect(ModStatusEffects.BLEED))) {
            System.out.println("U can't eat milk! while U have certain status effects!");
            return TypedActionResult.fail(stack);
        }
        return TypedActionResult.pass(stack);
    }
    
}
