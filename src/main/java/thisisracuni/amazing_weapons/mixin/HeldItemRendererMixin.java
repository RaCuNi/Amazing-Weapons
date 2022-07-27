package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Final;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;

@Mixin(HeldItemRenderer.class)
public abstract class HeldItemRendererMixin {

    @Shadow
    @Final
    private final MinecraftClient client = MinecraftClient.getInstance();
    
    @Shadow
    private void applyEquipOffset(MatrixStack matrices, Arm arm, float equipProgress) {
        int i = arm == Arm.RIGHT ? 1 : -1;
        matrices.translate((double)((float)i * 0.56F), (double)(-0.52F + equipProgress * -0.6F), -0.7200000286102295D);
    }

    
    
    //boolean wasOnGround = false;

    //First Person View
    //Custom motions for Sunlight Greatsword
    @Shadow
    @Inject(at = @At(value="HEAD"), method = "renderFirstPersonItem")
    private void renderFirstPersonItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo info) {
        //System.out.println(player.verticalCollision);

        if(item.getItem() instanceof GreatSwordSunlight && player.isSneaking() && player.handSwinging) {
            //Revert swing motion
            Arm arm = Arm.RIGHT;
            int i = arm == Arm.RIGHT ? 1 : -1;
            float v = -0.4F * -MathHelper.sin(MathHelper.sqrt(swingProgress) * 3.1415927F);
            float w = 0.2F * -MathHelper.sin(MathHelper.sqrt(swingProgress) * 6.2831855F);
            float x = -0.2F * -MathHelper.sin(swingProgress * 3.1415927F);
            matrices.translate((double)((float)i * v), (double)w, (double)x); 

            float f = MathHelper.sin(swingProgress * swingProgress * 3.1415927F); //Slow start
            float g = MathHelper.sin(swingProgress * 3.1415927F); //Normal
            float h = MathHelper.sin(MathHelper.sqrt(swingProgress) * 3.1415927F); //Fast start

            System.out.println(player.isOnGround());

            if((!player.isOnGround() && player.getVelocity().y > 0.5)) {
                //Custom swing motion - on the ground
                matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(MathHelper.sin((MathHelper.sqrt(swingProgress) + 1) * 1.5707964F) * -20F));
                matrices.translate(0, 0.6 * f, -0.4 * g);

            } else {
                //Custom swing motion - in the air
                matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(h * -45F));
                matrices.translate(0, -0.4 * f, -0.4 * g);

            }
        }
    }
    
}
