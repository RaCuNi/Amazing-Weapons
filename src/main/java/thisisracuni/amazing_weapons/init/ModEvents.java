package thisisracuni.amazing_weapons.init;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import thisisracuni.amazing_weapons.event.callback.EntityDropCallback;
import thisisracuni.amazing_weapons.event.callback.EntityKBCallback;
import thisisracuni.amazing_weapons.event.callback.InventoryUpdateCallback;
import thisisracuni.amazing_weapons.event.handler.AttackEntityHandler;
import thisisracuni.amazing_weapons.event.handler.EntityDropHandler;
import thisisracuni.amazing_weapons.event.handler.EntityKBHandler;
import thisisracuni.amazing_weapons.event.handler.InventoryUpdateHandler;
import thisisracuni.amazing_weapons.event.handler.KeyPressHandler;
import thisisracuni.amazing_weapons.event.handler.LootTableLoadingHandler;
import thisisracuni.amazing_weapons.event.handler.UseEntityHandler;
import thisisracuni.amazing_weapons.event.handler.UseItemHandler;

public class ModEvents {
    public static void init() {
        //Events
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		EntityDropCallback.EVENT.register(new EntityDropHandler());
        InventoryUpdateCallback.EVENT.register(new InventoryUpdateHandler());
        
        EntityKBCallback.EVENT.register(new EntityKBHandler());
        UseItemCallback.EVENT.register(new UseItemHandler());
        //UseEntityCallback.EVENT.register(new UseEntityHandler());

        ClientTickEvents.END_CLIENT_TICK.register(new KeyPressHandler());

        //LootTableLoadingCallback.EVENT.register(new LootTableLoadingHandler());
    }
    
}
