package dev.j3fftw.extrautils.objects;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

/**
 * A class that can be used to register {@link SlimefunItem}
 * that can interact with hoppers. Items registered using
 * this class can not interact with the material hopper.
 *
 * @author NCBPFluffyBear
 */
public class NonHopperableBlock extends SlimefunItem {

    public NonHopperableBlock(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @EventHandler
    public void onHopper(InventoryMoveItemEvent e) {
        if (e.getSource().getType() == InventoryType.HOPPER
            && e.getDestination().getLocation() != null
            && BlockStorage.hasBlockInfo(e.getDestination().getLocation())
            && BlockStorage.check(e.getDestination().getLocation()) instanceof NonHopperableBlock) {
            e.setCancelled(true);
        }
    }
}
