package me.dunescifye.dimensionstacking;

import me.dunescifye.dimensionstacking.listeners.VoidListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DimensionStacking extends JavaPlugin {

    @Override
    public void onEnable() {
        new VoidListener().voidHandler(this);
        Bukkit.getLogger().info("Plugin enabled.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
