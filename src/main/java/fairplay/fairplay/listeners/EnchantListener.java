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
        ItemStack item = event.getItem();

        if (event.getEnchantsToAdd().containsKey(Enchantment.FLAME)) {
            event.setCancelled(true);
            String message = plugin.getConfig().getString("messages.Enchant-Flame");
            event.getEnchanter().sendMessage(Utils.toColor(message) );
        } else if (event.getEnchantsToAdd().containsKey(Enchantment.FIRE_ASPECT)) {
            event.setCancelled(true);
            String message = plugin.getConfig().getString("messages.Enchant-FireAspect");
            event.getEnchanter().sendMessage(Utils.toColor(message));
        }
    }
}
