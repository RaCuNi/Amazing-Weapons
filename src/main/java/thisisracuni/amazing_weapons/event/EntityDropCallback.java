package thisisracuni.amazing_weapons.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public interface EntityDropCallback {

	boolean onEntityDrop(LivingEntity entity, DamageSource damageSource);

    Event<EntityDropCallback> EVENT = EventFactory.createArrayBacked(EntityDropCallback.class,
			listeners -> (entity, damageSource) -> {
				for (EntityDropCallback event : listeners) {
					if (event.onEntityDrop(entity, damageSource)) {
						return true;
					}
				}

				return false;
			}
	);
}
