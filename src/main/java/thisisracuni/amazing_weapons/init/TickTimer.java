package thisisracuni.amazing_weapons.init;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class TickTimer {

    int timer = 40;
    
    public void init() {
        ServerTickEvents.START_SERVER_TICK.register(tick -> {
            timer--;
            if(timer == 0) {
            System.out.println("2 secs later!");
            timer = 40;
            }
        });
    }
}
