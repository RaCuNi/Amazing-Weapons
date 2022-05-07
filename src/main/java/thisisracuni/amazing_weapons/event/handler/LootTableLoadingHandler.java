package thisisracuni.amazing_weapons.event.handler;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import thisisracuni.amazing_weapons.init.ModBlocks;
import thisisracuni.amazing_weapons.init.ModItems;

public class LootTableLoadingHandler implements LootTableLoadingCallback {
    private static final Identifier SUNSTONE_ORE_LOOT_TABLE_ID = ModBlocks.SUNSTONE_ORE.getLootTableId();

    @Override
    public void onLootTableLoading(ResourceManager resourceManager, LootManager manager, Identifier id, FabricLootSupplierBuilder supplier, LootTableSetter setter) {
        if(SUNSTONE_ORE_LOOT_TABLE_ID.equals(id)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                .rolls(ConstantLootTableRange.create(1))
                .with(ItemEntry.builder(ModItems.SUNSTONE));

            supplier.pool(poolBuilder);
            System.out.println("Loot Table Loaded. IF=true");
        }
    }
}
