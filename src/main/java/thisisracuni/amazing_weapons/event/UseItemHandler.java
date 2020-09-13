package thisisracuni.amazing_weapons.event;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.weapon.tool.DaggerSacrifice;

public class UseItemHandler implements UseItemCallback {

    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if(stack.getItem() instanceof DaggerSacrifice) {
            player.sendMessage(Text.of("Test Right clicking Event!"), false);
            return TypedActionResult.success(stack);
        } 
        
        else {
            return TypedActionResult.pass(stack);
        }
    }
    
}
