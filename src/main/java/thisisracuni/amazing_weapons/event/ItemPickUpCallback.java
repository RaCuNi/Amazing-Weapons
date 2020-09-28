package thisisracuni.amazing_weapons.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface ItemPickUpCallback {

    ActionResult interact(PlayerEntity player, ItemEntity itemEntity);

    Event<ItemPickUpCallback> EVENT = EventFactory.createArrayBacked(ItemPickUpCallback.class, 
            listeners -> (player, itemEntity) -> {
				for (ItemPickUpCallback event : listeners) {
					ActionResult result = event.interact(player, itemEntity);

					if(result != ActionResult.PASS) {
						return result;
					}
					
				}

				return ActionResult.PASS;
			}
	);
    
}
