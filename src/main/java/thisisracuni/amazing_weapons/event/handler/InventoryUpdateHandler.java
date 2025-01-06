package thisisracuni.amazing_weapons.event.handler;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import io.github.ladysnake.locki.DefaultInventoryNodes;
import io.github.ladysnake.locki.InventoryLock;
import io.github.ladysnake.locki.Locki;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import thisisracuni.amazing_weapons.AmazingWeapons;
import thisisracuni.amazing_weapons.event.callback.InventoryUpdateCallback;
import thisisracuni.amazing_weapons.init.ModItems;
import thisisracuni.amazing_weapons.weapon.GreatSwordSunlight;
import thisisracuni.amazing_weapons.weapon.base.DaggerItem;
import thisisracuni.amazing_weapons.weapon.base.GreatSwordItem;

public class InventoryUpdateHandler implements InventoryUpdateCallback {

    PlayerEntity player;
    boolean dagger_active = false;
    boolean greatSword_active = false;

    //Locki
	public static final InventoryLock LOCK = Locki.registerLock(new Identifier(AmazingWeapons.MOD_ID, "lock"));
    boolean isLocked = false;

    public ActionResult interact(PlayerInventory inventory) {

        player = inventory.player;
        World world = inventory.player.world;
        
        if (!world.isClient) {
            if (dagger_active != inventory.getMainHandStack().getItem() instanceof DaggerItem) {
                SetRangeDagger(inventory.getMainHandStack().getItem() instanceof DaggerItem);
            }
            dagger_active = inventory.getMainHandStack().getItem() instanceof DaggerItem;

            if(greatSword_active != inventory.getMainHandStack().getItem() instanceof GreatSwordItem) {
                SetRangeGreatSword(inventory.getMainHandStack().getItem() instanceof GreatSwordItem);
            }
            greatSword_active = inventory.getMainHandStack().getItem() instanceof GreatSwordItem;
        }
        
        if(!world.isClient) {
            if(inventory.getMainHandStack().getItem() instanceof GreatSwordSunlight && !isLocked) {
                if(!inventory.offHand.isEmpty()) {
                    ItemStack stack = inventory.offHand.get(0);
                    player.dropStack(stack);
                    inventory.offHand.clear();
                }
                LOCK.lock(player, DefaultInventoryNodes.OFF_HAND);
                isLocked = true;
            }
            
            if(!(inventory.getMainHandStack().getItem() instanceof GreatSwordSunlight) && isLocked) {
                LOCK.unlock(player, DefaultInventoryNodes.OFF_HAND);
                isLocked = false;
            }
        }

        return ActionResult.PASS;
        
    }

    public void SetRangeDagger(boolean change_range_dagger) {
        if(change_range_dagger) {
            System.out.println("DaggerItem On");
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(ModItems.DAGGER_ITEM_REACH);
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(ModItems.DAGGER_ITEM_REACH);
        } else {
            System.out.println("DaggerItem Off");
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    }

    public void SetRangeGreatSword(boolean change_range_greatSword) {
        if(change_range_greatSword) {
            System.out.println("GreatSwordItem On");
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(ModItems.GREATSWORD_ITEM_REACH);
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(ModItems.GREATSWORD_ITEM_REACH);
        } else {
            System.out.println("GreatSwordItem Off");
            player.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            player.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    }
    
}
