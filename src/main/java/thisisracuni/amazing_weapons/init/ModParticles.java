package thisisracuni.amazing_weapons.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import thisisracuni.amazing_weapons.AmazingWeapons;
import thisisracuni.amazing_weapons.particle.BloodyStormParticle;
import thisisracuni.amazing_weapons.particle.DaggerStabParticle;

public class ModParticles {
    public static final DefaultParticleType BLOODY_STORM = FabricParticleTypes.simple();
    public static final DefaultParticleType DAGGER_STAB = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmazingWeapons.MOD_ID, "bloody_storm"), BLOODY_STORM);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(AmazingWeapons.MOD_ID, "dagger_stab"), DAGGER_STAB);
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ParticleFactoryRegistry.getInstance().register(BLOODY_STORM, BloodyStormParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(DAGGER_STAB, DaggerStabParticle.Factory::new);
    }
}
