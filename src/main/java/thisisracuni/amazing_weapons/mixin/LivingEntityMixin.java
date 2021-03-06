package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.event.callback.EntityDropCallback;
import thisisracuni.amazing_weapons.event.callback.EntityKBCallback;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;dropInventory()V"), method = "drop", cancellable = true)
    private void onDrop(DamageSource damageSource, CallbackInfo info) {
        boolean result = EntityDropCallback.EVENT.invoker().onEntityDrop((LivingEntity) (Object) this, damageSource);

        if(result == false) {
            info.cancel();
        }
    }

    @Inject(at = @At(value = "HEAD"), method = "takeKnockback", cancellable = true)
    private void onTakingKnockback(float power, double dx, double dz, CallbackInfo info) {
        ActionResult result = EntityKBCallback.EVENT.invoker().onTakingKnockback((LivingEntity)(Object)this, power, dx, dz);

        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }
    
}
