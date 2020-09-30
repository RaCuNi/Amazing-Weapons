package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import thisisracuni.amazing_weapons.event.ItemPickUpCallback;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {

    @Inject(at = @At(value ="INVOKE",target="net/minecraft/entity/player/PlayerInventory.insertStack(Lnet/minecraft/item/ItemStack;)Z"),  method = "onPlayerCollision", cancellable = true)
    public void onPlayerCollision(PlayerEntity player, CallbackInfo info) {
        ActionResult result = ItemPickUpCallback.EVENT.invoker().interact(player, (ItemEntity) (Object)this);

        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }    
}
