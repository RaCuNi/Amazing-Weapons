package thisisracuni.amazing_weapons.init;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class ModKeybinds {
    public static KeyBinding BLOODY_DASH = new KeyBinding("key.amazing_weapons.bloody_dash", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_V, "key.category.amazing_weapons");

    public static void initClient() {
        KeyBindingHelper.registerKeyBinding(BLOODY_DASH);
    }
}
