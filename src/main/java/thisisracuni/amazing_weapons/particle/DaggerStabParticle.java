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

@Environment(EnvType.CLIENT)
public class DaggerStabParticle extends SpriteBillboardParticle {
    private final FabricSpriteProvider spriteProvider;

    private DaggerStabParticle(ClientWorld world, double x, double y, double z, double scaleMultiplier, FabricSpriteProvider spriteProvider) {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.spriteProvider = spriteProvider;
        this.maxAge = 3;
        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.colorRed = f;
        this.colorGreen = f;
        this.colorBlue = f;
        this.scale = 0.3F - (float)scaleMultiplier * 0.5F;
        this.setSpriteForAge(spriteProvider);
    }

    public int getBrightness(float tint) {
        return 15728880;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.setSpriteForAge(this.spriteProvider);
        }
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final FabricSpriteProvider spriteProvider;

        public Factory(FabricSpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new DaggerStabParticle(clientWorld, d, e, f, g, this.spriteProvider);
        }
    }
}
