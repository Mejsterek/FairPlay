package fairplay.fairplay;

import fairplay.fairplay.listeners.EnchantListener;
import fairplay.fairplay.listeners.PotionBrewingListener;
import fairplay.fairplay.listeners.WindChargeListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FairPlay extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Register the WindChargeListener
        getServer().getPluginManager().registerEvents(new WindChargeListener(this),this);
        getServer().getPluginManager().registerEvents(new PotionBrewingListener(this), this);
        getServer().getPluginManager().registerEvents(new EnchantListener(this), this);


        this.getLogger().info("FairPlaySystem by Mejster has been enabled");
        this.getLogger().info("Contact:");
        this.getLogger().info("Discord: mejster");
        this.getLogger().info("Fiver: mejster");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("FairPlaySystem by Mejster has been disabled");
        this.getLogger().info("Contact:");
        this.getLogger().info("Discord: mejster");
        this.getLogger().info("Fiver: mejster");
    }
}
