package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> extends AnimalModel<T> implements ModelWithArms, ModelWithHead {
    @Shadow 
    public ModelPart rightArm;
    
    @Shadow 
    public ModelPart leftArm;

    @Shadow
    public ModelPart head;

    @Shadow
    public BipedEntityModel.ArmPose rightArmPose;

    public boolean SUNLIGHT_GREATSWORD = false;

    @Inject(at = @At(value="HEAD"), method = "method_30154")
	 private void method_30154(T livingEntity, CallbackInfo info) {
        if(livingEntity instanceof PlayerEntity && livingEntity.getMainHandStack().getItem() instanceof GreatSwordSunlight) {

            this.leftArm.yaw = 0.1F /*+ this.head.yaw*/ + 0.2F;
            this.leftArm.pitch = -1.3307964F /*+ this.head.pitch*/;

            if(livingEntity.isSneaking() && livingEntity.handSwinging) {
                //float dt = MinecraftClient.getInstance().getTickDelta();
                System.out.println("BipedEntityModelMixin");
                float start = this.rightArm.pitch;
                float end = this.rightArm.pitch * 0.5F - 3.1415927F;
                float dist = Math.abs(end - start);

                System.out.println(dist);

                for(float i = 0;i<dist;i+=0.1) {
                    float progress = i/dist;
                    float current = MathHelper.lerp(start,end, progress);

                    this.rightArm.pitch = current;
                    this.rightArm.yaw = 0.0F;
                }
            }
        }
    }
}
