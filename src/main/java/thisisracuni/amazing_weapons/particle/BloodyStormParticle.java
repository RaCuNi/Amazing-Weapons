package thisisracuni.amazing_weapons.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class BloodyStormParticle extends SpriteBillboardParticle {
    private final FabricSpriteProvider spriteProvider;

    protected BloodyStormParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, FabricSpriteProvider spriteProvider) {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.spriteProvider = spriteProvider;
        //float g = 2.5F;
        this.velocityX *= 0.10000000149011612D;
        this.velocityY *= 0.10000000149011612D;
        this.velocityZ *= 0.10000000149011612D;
        this.velocityX += velocityX;
        this.velocityY += velocityY;
        this.velocityZ += velocityZ;
        float h = 1.0F - (float)(Math.random() * 0.30000001192092896D);
        this.colorRed = h;
        this.colorGreen = h;
        this.colorBlue = h;
        //this.scale *= 1.875F;
        this.scale *= 2.5F;
        int i = (int)(8.0D / (Math.random() * 0.8D + 0.3D));
        this.maxAge = (int)Math.max((float)i * 2.5F, 1.0F) * 2; // about 5 ~ 7 sec.
        //this.maxAge = 80;
        //int i = (int)(Math.random() * 3);

        //this.maxAge = 20 * 7; // about 7 sec.
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Override
    public float getSize(float tickDelta) {
        return this.scale * MathHelper.clamp(((float)this.age + tickDelta) / (float)this.maxAge * 32.0F, 0.0F, 1.0F);
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.setSpriteForAge(this.spriteProvider);
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= 0.9599999785423279D;
            this.velocityY *= 0.9599999785423279D;
            this.velocityZ *= 0.9599999785423279D;
            if (this.onGround) {
                this.velocityX *= 0.699999988079071D;
                this.velocityZ *= 0.699999988079071D;
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final FabricSpriteProvider spriteProvider;

        public Factory(FabricSpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new BloodyStormParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);
        }
    }


        /*super(world, x, y, z, velocityX, velocityY, velocityZ);
        float f = this.random.nextFloat() * 0.1F + 0.2F;
        this.colorRed = f;
        this.colorGreen = f;
        this.colorBlue = f;
        this.setBoundingBoxSpacing(0.02F, 0.02F);
        this.scale *= this.random.nextFloat() * 0.6F + 0.5F;
        this.velocityX *= 0.019999999552965164D;
        this.velocityY *= 0.019999999552965164D;
        this.velocityZ *= 0.019999999552965164D;
        this.maxAge = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
    }*/
}
