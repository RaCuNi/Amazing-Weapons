package thisisracuni.amazing_weapons.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import thisisracuni.amazing_weapons.AmazingWeapons;

public class ModBlocks {

    public static final OreBlock SUNSTONE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool().strength(3.0f, 3.0f));

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(AmazingWeapons.MOD_ID, "sunstone_ore"), SUNSTONE_ORE);
        Registry.register(Registry.ITEM, new Identifier(AmazingWeapons.MOD_ID, "sunstone_ore"), new BlockItem(SUNSTONE_ORE, new FabricItemSettings().group(ModItems.MOD_GROUP)));
    }    
}
