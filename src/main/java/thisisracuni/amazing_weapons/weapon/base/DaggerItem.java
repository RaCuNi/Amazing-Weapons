package thisisracuni.amazing_weapons.weapon.base;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class DaggerItem extends SwordItem {

    public static double reach = 0;
    public static double attack_range = 0;

    public DaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, double reachBonus, double attackReachBonus) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        reach = reachBonus;
        attack_range = attackReachBonus;
    }
}
