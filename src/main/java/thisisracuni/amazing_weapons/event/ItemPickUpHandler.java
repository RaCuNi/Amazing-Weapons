package thisisracuni.amazing_weapons.event;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;
//import net.minecraft.text.Text;

public class ItemPickUpHandler implements ItemPickUpCallback {

    @Override
    public ActionResult interact(PlayerEntity player, ItemEntity itemEntity) {
        //player.sendMessage(Text.of("Item Picked Up!"), false);
        if(itemEntity.getStack().getItem() instanceof DaggerItem) {
            //player.sendMessage(Text.of("DaggerItem Picked Up!"), false);
            //((DaggerItem)itemEntity.getStack().getItem()).SetRange(true);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    
}
