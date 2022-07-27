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
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import thisisracuni.amazing_weapons.weapon.base.GreatSwordItem;

@Mixin(BipedEntityModel.class)
public abstract class SwingArmMixin<T extends LivingEntity> extends AnimalModel<T> implements ModelWithArms, ModelWithHead {

    @Shadow
    public ModelPart head;

    @Shadow
    public ModelPart body;

    @Shadow
    public ModelPart rightArm;

    @Shadow
    public ModelPart leftArm;

    @Shadow
    protected Arm getPreferredArm(T entity) {
        Arm arm = entity.getMainArm();
        return entity.preferredHand == Hand.MAIN_HAND ? arm : arm.getOpposite();
    }

    @Shadow
    protected ModelPart getArm(Arm arm) {
        return arm == Arm.LEFT ? this.leftArm : this.rightArm;
    }

    @Shadow
    @Inject(at = @At(value="HEAD"), method = "method_29353")
    protected void method_29353(T livingEntity, float f, CallbackInfo info) { //Revert swing motion
        if(livingEntity instanceof PlayerEntity && livingEntity.getMainHandStack().getItem() instanceof GreatSwordItem) {
            Arm arm = this.getPreferredArm(livingEntity);
            ModelPart modelPart = this.getArm(arm);
            float g = this.handSwingProgress;

            if (!(this.handSwingProgress <= 0.0F)) {
                this.body.yaw = 0F; //-MathHelper.sin(MathHelper.sqrt(g) * 6.2831855F) * 0.2F;
                //Important
                g = 1.0F - this.handSwingProgress;
                g *= g;
                g *= g;
                g = 1.0F - g;
                float h = MathHelper.sin(g * 3.1415927F);
                float i = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -(this.head.pitch - 0.7F) * 0.75F;
                modelPart.pitch = (float)((double)modelPart.pitch +/*-*/ ((double)h * 1.2D + (double)i));
                modelPart.yaw += -this.body.yaw * 2.0F;
                modelPart.roll += -MathHelper.sin(this.handSwingProgress * 3.1415927F) * -0.4F;
            }
        }
        
    }
    
}
