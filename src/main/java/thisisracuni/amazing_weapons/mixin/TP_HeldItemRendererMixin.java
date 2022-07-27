package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;

@Mixin(HeldItemRenderer.class)
public class TP_HeldItemRendererMixin {
    @Shadow
    @Final
    private ItemRenderer itemRenderer;
    
    @Inject(at = @At(value = "HEAD"), method="renderItem")
    public void renderItem(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo info) {
        //float f = MathHelper.sin(entity.handSwingProgress * entity.handSwingProgress * 3.1415927F); //Slow start
        if(stack.getItem() instanceof GreatSwordSunlight && entity instanceof PlayerEntity && entity.isSneaking() && entity.isOnGround() && entity.handSwinging) {
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-20F * MathHelper.sin(entity.handSwingProgress * 3.1415927F)));
            this.itemRenderer.renderItem(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, entity.world, light, OverlayTexture.DEFAULT_UV);
        }
    }
    
}
