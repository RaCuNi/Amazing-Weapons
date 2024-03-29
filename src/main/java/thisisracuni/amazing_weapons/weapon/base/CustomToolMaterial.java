package thisisracuni.amazing_weapons.weapon.base;

import com.google.common.base.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import thisisracuni.amazing_weapons.init.ModItems;

public enum CustomToolMaterial implements ToolMaterial {
    BLOOD(1, 44, 1.5f, 0.5f, 0, () -> {
        return Ingredient.ofItems(ModItems.BLOOD_DROP);
    }),
    
    SUNSTONE(1, 5778, 1, 1, 0, () -> {return Ingredient.ofItems(ModItems.SUNSTONE);});

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    CustomToolMaterial(int miningLevel, int itemDurability, float miningSpeedMultiplier, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

	@Override
	public int getDurability() {
		return this.itemDurability;
	}

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
