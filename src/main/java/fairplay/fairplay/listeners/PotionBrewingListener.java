package fairplay.fairplay.listeners;

import fairplay.fairplay.FairPlay;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public class PotionBrewingListener implements Listener {

    private final FairPlay plugin;

    public PotionBrewingListener(FairPlay plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPotionBrew(BrewEvent event) {
        BrewerInventory inventory = event.getContents();

        // Loop through all the result slots
        for (ItemStack item : event.getResults()) {
            if (item != null && item.getType() == Material.POTION) {
                PotionMeta meta = (PotionMeta) item.getItemMeta();

                assert meta != null;

                String potionType = meta.getBasePotionType().name();

                if (isRestrictedPotion(potionType)) {
                    dropAllItems(inventory);
                    event.setCancelled(true);
                    return;
                }
            }
        }
    }
    private void dropAllItems(Inventory inventory) {
        // Loop through all the brewing stand inventory slots and drop the items
        for (ItemStack item : inventory.getContents()) {
            if (item != null) {
                inventory.getLocation().getWorld().dropItemNaturally(inventory.getLocation(), item);
            }
        }

        // Clear the brewing stand's inventory after dropping the items
        inventory.clear();
    }
    private boolean isRestrictedPotion(String potionType) {
        return potionType.equalsIgnoreCase("FIRE_RESISTANCE") ||
                potionType.equalsIgnoreCase("STRONG_STRENGTH") ||
                potionType.equalsIgnoreCase("STRONG_SWIFTNESS");
    }
}
