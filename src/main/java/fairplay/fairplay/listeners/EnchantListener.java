package fairplay.fairplay.listeners;

import fairplay.fairplay.FairPlay;
import fairplay.fairplay.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantListener implements Listener {
    private FairPlay plugin;
    public EnchantListener(FairPlay plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        // Get the item being enchanted
        ItemStack item = event.getItem();

        if (event.getEnchantsToAdd().containsKey(Enchantment.FLAME)) {
            event.setCancelled(true);
            event.getEnchanter().sendMessage(Utils.toColor("&cYou cannot enchant items with Flame!") );
        } else if (event.getEnchantsToAdd().containsKey(Enchantment.FIRE_ASPECT)) {
            event.setCancelled(true);
            event.getEnchanter().sendMessage(Utils.toColor("&cYou cannot enchant items with Fire Aspect!"));
        }
    }
}
