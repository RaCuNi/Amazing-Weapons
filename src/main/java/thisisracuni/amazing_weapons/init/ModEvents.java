package thisisracuni.amazing_weapons.init;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import thisisracuni.amazing_weapons.event.callback.EntityDropCallback;
import thisisracuni.amazing_weapons.event.callback.EntityKBCallback;
import thisisracuni.amazing_weapons.event.callback.InventoryUpdateCallback;
import thisisracuni.amazing_weapons.event.handler.AttackEntityHandler;
import thisisracuni.amazing_weapons.event.handler.EntityDropHandler;
import thisisracuni.amazing_weapons.event.handler.EntityKBHandler;
import thisisracuni.amazing_weapons.event.handler.InventoryUpdateHandler;

public class ModEvents {
    public static void init() {
        //Events
		AttackEntityCallback.EVENT.register(new AttackEntityHandler());
		EntityDropCallback.EVENT.register(new EntityDropHandler());
        InventoryUpdateCallback.EVENT.register(new InventoryUpdateHandler());
        
        EntityKBCallback.EVENT.register(new EntityKBHandler());
    }
    
}
