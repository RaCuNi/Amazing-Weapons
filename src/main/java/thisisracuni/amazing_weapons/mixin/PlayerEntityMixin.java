package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.AmazingWeapons;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    private ItemStack selectedItem;

    @Inject(at = @At("HEAD"), method = "dropSelectedItem")
    public void dropSelectedItem(CallbackInfoReturnable info) {
        System.out.println("Item dropped");
        if (this.selectedItem.getItem() instanceof DaggerItem) {
            System.out.println("DaggerItem dropped");
            // ((DaggerItem)this.selectedItem.getItem()).SetRange(false);
        }
    }
}
