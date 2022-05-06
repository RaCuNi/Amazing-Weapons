package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;

@Mixin(HeldItemRenderer.class)
public abstract class HeldItemRendererMixin {

    @Shadow
    private final MinecraftClient client = MinecraftClient.getInstance();
    
    @Shadow
    private void applyEquipOffset(MatrixStack matrices, Arm arm, float equipProgress) {
        int i = arm == Arm.RIGHT ? 1 : -1;
        matrices.translate((double)((float)i * 0.56F), (double)(-0.52F + equipProgress * -0.6F), -0.7200000286102295D);
    }
    
    @Inject(at = @At(value="HEAD"), method = "renderFirstPersonItem")
    private void renderFirstPersonItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo info) {
        if(item.getItem() instanceof GreatSwordSunlight && player.isSneaking() && player.handSwinging) {
            Arm arm = Arm.RIGHT;
            this.applyEquipOffset(matrices, arm, equipProgress);

            //System.out.println(swingProgress);
            int o = 1;
            matrices.translate((double)((float)o * -0.5F), 0.699999988079071D, 0.10000000149011612D);
            //matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(110F));
            //matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float)o * 110F));
            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion((float)o * 80F));
            //float u = (float)item.getMaxUseTime() - ((float)this.client.player.getItemUseTimeLeft() - tickDelta + 1.0F);

            
                  
        }
    }
    
}
