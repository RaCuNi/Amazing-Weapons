package thisisracuni.amazing_weapons.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
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

    //Third Person View (Frontal Standard?)
    @Shadow
    @Inject(at = @At(value="TAIL"), method = "method_30154")
	private void method_30154(T livingEntity, CallbackInfo info) {
        if(livingEntity instanceof PlayerEntity && livingEntity.getMainHandStack().getItem() instanceof GreatSwordSunlight) {

            //Holding motion (Two-handed)
            this.rightArm.yaw = -0.1F + (this.head.yaw)/2 - 0.3F;
            this.leftArm.yaw = 0.1F + (this.head.yaw)/2 + 0.3F;
            this.rightArm.pitch = -1.5707964F + 0.3F + (this.head.pitch)/2;
            this.leftArm.pitch = -1.5707964F + 0.3F + (this.head.pitch)/2;


            float g = this.handSwingProgress;
            g = 1.0F - this.handSwingProgress;
            g *= g;
            g *= g;
            g = 1.0F - g;
            float m = MathHelper.sqrt(g);
            float h = MathHelper.sin(g * 3.1415927F);
            float i = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -(this.head.pitch - 0.7F) * 0.75F;
            float k = MathHelper.sin(this.handSwingProgress * 6.2831855F);
            float f = MathHelper.sin(m * 3.1415927F);
            float l = MathHelper.sin(MathHelper.sqrt(this.handSwingProgress) * 6.2831855F);

            //Attacking motion (Normal / Upper / Takedown)
            if(livingEntity.handSwinging && !livingEntity.isSneaking()) { //Normal
                
                //this.rightArm.pitch = (float)((double)this.rightArm.pitch + ((double)h * 1.2D + (double)i));
                //modelPart.yaw += -this.body.yaw * 2.0F;
                //modelPart.roll += -MathHelper.sin(this.handSwingProgress * 3.1415927F) * -0.4F;
                this.rightArm.pitch = this.rightArm.pitch - k * 0.8F; 
                this.leftArm.pitch = this.leftArm.pitch - k * 0.8F; 
                
            } else if(livingEntity.handSwinging && livingEntity.isSneaking() && (!livingEntity.isOnGround() && livingEntity.getVelocity().y > 0.5)) { //Upper

                this.rightArm.pitch = this.rightArm.pitch - 1.6F * m;
                this.leftArm.pitch = this.leftArm.pitch - 1.6F * m;
                this.rightArm.yaw = this.rightArm.yaw + 0.4F * m;
                this.leftArm.yaw = this.leftArm.yaw + 0.2F * m;

            } else { //Takedown

                this.rightArm.pitch = this.rightArm.pitch + 1F * -l;
                this.leftArm.pitch = this.leftArm.pitch + 1F * -l;
                this.rightArm.yaw = this.rightArm.yaw + 0.6F * g;
                this.leftArm.yaw = this.leftArm.yaw + 0.2F * g;

            }
        }
    }
}
