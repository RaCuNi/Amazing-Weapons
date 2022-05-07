package thisisracuni.amazing_weapons.init;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import thisisracuni.amazing_weapons.AmazingWeapons;

public class ModOreGens {
    private static ConfiguredFeature<?, ?> ORE_SUNSTONE = Feature.ORE
    .configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.SANDSTONE), ModBlocks.SUNSTONE_ORE.getDefaultState(), 9))
    .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(40, 0, 70)))
    .spreadHorizontally()
    .repeat(10);

    public static void init() {
        RegistryKey<ConfiguredFeature<?, ?>> oreSunstone = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
        new Identifier(AmazingWeapons.MOD_ID, "ore_sunstone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreSunstone.getValue(), ORE_SUNSTONE);
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.DESERT), GenerationStep.Feature.UNDERGROUND_ORES, oreSunstone);
    }
}
