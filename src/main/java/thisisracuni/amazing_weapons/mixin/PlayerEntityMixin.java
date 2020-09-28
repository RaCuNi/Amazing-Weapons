package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    
    private ItemStack selectedItem;

    @Inject(at = @At("HEAD"), method = "dropSelectedItem")
    public void dropSelectedItem(CallbackInfoReturnable info) {
        System.out.println("Item dropped");
        if(this.selectedItem.getItem() instanceof DaggerItem) {
            System.out.println("DaggerItem dropped");
            //((DaggerItem)this.selectedItem.getItem()).SetRange(false);
        }
    }
    
}
