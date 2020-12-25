package thisisracuni.amazing_weapons.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;

public interface EntityKBCallback {
    ActionResult onTakingKnockback(LivingEntity entity, float power, double dx, double dz);

    Event<EntityKBCallback> EVENT = EventFactory.createArrayBacked(EntityKBCallback.class, 
            listeners -> (entity, power, dx, dz) -> {
                for (EntityKBCallback event : listeners) {
                    ActionResult result = event.onTakingKnockback(entity, power, dx, dz);

                    if(result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            }
    );
    
}
