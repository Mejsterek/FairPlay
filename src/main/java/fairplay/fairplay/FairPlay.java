package fairplay.fairplay;

import fairplay.fairplay.listeners.EnchantListener;
import fairplay.fairplay.listeners.PotionBrewingListener;
import fairplay.fairplay.listeners.WindChargeListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FairPlay extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new WindChargeListener(this),this);
        getServer().getPluginManager().registerEvents(new PotionBrewingListener(), this);
        getServer().getPluginManager().registerEvents(new EnchantListener(), this);

        this.getLogger().info("FairPlay enabled");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("FairPlay disabled");
    }
}
