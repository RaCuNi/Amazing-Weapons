package thisisracuni.amazing_weapons.event.handler;

import java.util.Random;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import thisisracuni.amazing_weapons.init.ModItems;
import thisisracuni.amazing_weapons.init.ModKeybinds;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;

public class KeyPressHandler implements ClientTickEvents.EndTick {

    public static int dash_cooldown = 0;
    public static int parry_cooldown = 0;
    
    public boolean wasPressed = false;

    @Override
    public void onEndTick(MinecraftClient client) {

        if(dash_cooldown > 0) {

            if(dash_cooldown % 60 == 0 && client.player != null) {
                client.player.sendMessage(Text.of("DASH: Cooling down! "+" "+dash_cooldown/20+" "+"seconds left!"), false);
            }

            if(dash_cooldown == 2 && client.player != null) { client.player.sendMessage(Text.of("DASH: READY!"), false); }

            dash_cooldown--;
            return;
        }

        if(client.player == null) {
            return;
        }

        //Player Dash
        if(ModKeybinds.ABILITY.isPressed() && client.player.isOnGround() && client.player.getMainHandStack().getItem().equals(ModItems.BLOODY_BLADE_TRUE)) {

            Random random = client.world.random;
            float w = client.player.getWidth();
            float h = client.player.getHeight();
            Vec3d vec_player = client.player.getRotationVecClient();

            //Dash Particles
            for (int i = 0; i < 25; ++i) {
				double g = random.nextGaussian() * 0.05D;
                client.world.addParticle(new DustParticleEffect(1, 0, 0, 2f), client.player.getX() + random.nextFloat() * 2 - g * 6 - w * 2, client.player.getEyeY() + random.nextFloat() * 2 + g * 2 - h, client.player.getZ() + random.nextFloat() * 2 - g * 6 - w * 2, g, g, g);
                client.world.addParticle(new DustParticleEffect(1, 0, 0, 2f), client.player.getX() + vec_player.x * 2.5 + random.nextFloat() * 2 - g * 6 - w * 2, client.player.getEyeY() + random.nextFloat() * 2 + g * 2 - h, client.player.getZ() + vec_player.z * 2.5 + random.nextFloat() * 2 - g * 6 - w * 2, g, g, g);
                client.world.addParticle(new DustParticleEffect(1, 0, 0, 2f), client.player.getX() + vec_player.x * 5 + random.nextFloat() * 2 - g * 6 - w * 2, client.player.getEyeY() + random.nextFloat() * 2 + g * 2 - h, client.player.getZ() + vec_player.z * 5 + random.nextFloat() * 2 - g * 6 - w * 2, g, g, g);
                client.world.addParticle(new DustParticleEffect(1, 0, 0, 2f), client.player.getX() + vec_player.x * 7.5 + random.nextFloat() * 2 - g * 6 - w * 2, client.player.getEyeY() + random.nextFloat() * 2 + g * 2 - h, client.player.getZ() + vec_player.z * 7.5 + random.nextFloat() * 2 - g * 6 - w * 2, g, g, g);
                client.world.addParticle(new DustParticleEffect(1, 0, 0, 2f), client.player.getX() + vec_player.x * 10 + random.nextFloat() * 2 - g * 6 - w * 2, client.player.getEyeY() + random.nextFloat() * 2 + g * 2 - h, client.player.getZ() + vec_player.z * 10 + random.nextFloat() * 2 - g * 6 - w * 2, g, g, g);

            }

            client.player.addVelocity(vec_player.x * 5, 0, vec_player.z * 5);

            client.world.playSound(client.player, client.player.getX(), client.player.getY(), client.player.getZ(), SoundEvents.ENTITY_WITHER_SKELETON_HURT, SoundCategory.PLAYERS, 1f, 0.5f);

            dash_cooldown = 20 * 3;
        }

        boolean isPressed = ModKeybinds.ABILITY.isPressed();


        if(client.player.getMainHandStack().getItem() instanceof GreatSwordSunlight) {
            if(!isPressed && wasPressed) {
                client.player.sendChatMessage("key release");
            }
        }

        wasPressed = isPressed;
    }
}
