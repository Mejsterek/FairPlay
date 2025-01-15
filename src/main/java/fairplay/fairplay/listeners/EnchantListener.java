package fairplay.fairplay.listeners;

import fairplay.fairplay.FairPlay;
import fairplay.fairplay.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantListener implements Listener {
    private FairPlay plugin;
    public EnchantListener(FairPlay plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onEnchantItem(PrepareItemEnchantEvent event) {

        ItemStack item = event.getItem();
        for (int i = 0; i < event.getOffers().length; i++) {
            if (event.getOffers()[i] != null && event.getOffers()[i].getEnchantment() == Enchantment.FLAME) {
                event.getOffers()[i] = null;
            }
            if (event.getOffers()[i] != null && event.getOffers()[i].getEnchantment() == Enchantment.FIRE_ASPECT) {
                event.getOffers()[i] = null;
            }
        }

    }
    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {

        if (event.getEnchantsToAdd().containsKey(Enchantment.FLAME)) {
            event.getEnchantsToAdd().remove(Enchantment.FLAME);
        }
        if (event.getEnchantsToAdd().containsKey(Enchantment.FIRE_ASPECT)) {
            event.getEnchantsToAdd().remove(Enchantment.FIRE_ASPECT);
        }
    }
}
