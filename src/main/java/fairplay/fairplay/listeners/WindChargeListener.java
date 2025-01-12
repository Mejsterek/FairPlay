package fairplay.fairplay.listeners;

import fairplay.fairplay.FairPlay;
import fairplay.fairplay.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class WindChargeListener implements Listener {

    private final FairPlay plugin;

    public WindChargeListener(FairPlay plugin) {
        this.plugin = plugin;
    }

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private static final long COOLDOWN_TIME = 10 * 1000; // 10 seconds in milliseconds

    @EventHandler
    public void onPlayerUseWindCharge(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        Action action = event.getAction();
        if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        // Check if the item is the "Wind Charge"
        if (item != null && item.getType() == Material.WIND_CHARGE) {

            UUID playerId = player.getUniqueId();
            long currentTime = System.currentTimeMillis();

            // Check if the player is on cooldown
            if (cooldowns.containsKey(playerId) && currentTime - cooldowns.get(playerId) < COOLDOWN_TIME) {
                long timeLeft = (COOLDOWN_TIME - (currentTime - cooldowns.get(playerId))) / 1000;
                player.sendMessage(Utils.toColor("&cYou must wait " + timeLeft + " seconds to use the Wind Charge again.") );
                event.setCancelled(true);
                return;
            }

            // Apply cooldown
            cooldowns.put(playerId, currentTime);
            player.sendMessage(Utils.toColor("&aYou used the Wind Charge!"));
            // Custom logic for Wind Charge effect can go here
        }
    }
}
