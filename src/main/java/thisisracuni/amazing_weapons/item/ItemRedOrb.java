package thisisracuni.amazing_weapons.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class ItemRedOrb extends Item {
    public ItemRedOrb(final Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(final ItemStack itemStack, final World world, final List<Text> tooltip,
            final TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.amazing_weapons.red_orb.tooltip"));
    }

}