package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.item.HeldItemRenderer;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;

@Mixin(HeldItemRenderer.class)
public class SwingOffsetMixin {

    @Shadow
    private MinecraftClient client;
    
    @Shadow
    @Inject(at = @At(value = "HEAD"), method = "applySwingOffset", cancellable = true)
    private void applySwingOffset(CallbackInfo info) {
        if(client.player.getMainHandStack().getItem() instanceof GreatSwordSunlight && client.player.isSneaking()) {
            info.cancel();
        }
        
    }
    
}
