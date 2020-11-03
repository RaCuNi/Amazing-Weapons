package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    /*@ModifyVariable(at = @At(value = "STORE"), method = "attack", ordinal = 2)
    private int attack(int j) {
        if(!((PlayerEntity) (Object)this).world.isClient && ((PlayerEntity) (Object)this).getStackInHand(Hand.MAIN_HAND).getItem() instanceof DaggerItem) {
            j = DaggerItem.dagger_knockback;
            System.out.println("Dagger Knockback!");
            return j;
        }
        
        return j;
    }*/

    /*@Inject(at = @At(value = "TAIL"), method = "attack", locals = LocalCapture.PRINT)
    private void attack(Entity target, CallbackInfo ci) {
        
    }*/
}
