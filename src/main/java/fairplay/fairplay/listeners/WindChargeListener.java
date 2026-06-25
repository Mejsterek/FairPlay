package fairplay.fairplay.listeners;

import fairplay.fairplay.FairPlay;
import fairplay.fairplay.utils.Utils;
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

        int time = plugin.getConfig().getInt("configuration.WindCharge-Cooldown");
        final long COOLDOWN_TIME = time * 1000;

        if (item != null && item.getType() == Material.WIND_CHARGE) {

            UUID playerId = player.getUniqueId();
            long currentTime = System.currentTimeMillis();

            if (cooldowns.containsKey(playerId) && currentTime - cooldowns.get(playerId) < COOLDOWN_TIME) {
                long timeLeft = (COOLDOWN_TIME - (currentTime - cooldowns.get(playerId))) / 1000;
                String message = plugin.getConfig().getString("messages.WindCharge-Cooldown").replace("%time%", String.valueOf(timeLeft));
                player.sendMessage(Utils.toColor(message) );
                event.setCancelled(true);
                return;
            }

            cooldowns.put(playerId, currentTime);
            String message = plugin.getConfig().getString("messages.WindCharge-Used");
            player.sendMessage(Utils.toColor(message));
        }
    }
}
