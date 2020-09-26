package thisisracuni.amazing_weapons.init;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ZombieLoot {

    private static final Identifier ZOMBIE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/zombie");
    
    public void init() {

        LootTableLoadingCallback.EVENT.register((ResourceManager, LootManager, id, supplier, setter) -> {
            if(ZOMBIE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder()
                .rolls(ConstantLootTableRange.create(1))
                .withEntry(ItemEntry.builder(Items.ZOMBIE_HEAD).build());
                supplier.withPool(builder.build());
            }
        });

    }
    
}
