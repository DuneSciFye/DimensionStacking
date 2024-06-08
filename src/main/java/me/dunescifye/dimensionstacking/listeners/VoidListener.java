package me.dunescifye.dimensionstacking.listeners;

import me.dunescifye.dimensionstacking.DimensionStacking;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class VoidListener implements Listener {

    public void voidHandler(DimensionStacking plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.getWorld().getEnvironment() == World.Environment.NORMAL) {
                    if (p.getY() > 500) {
                        Location location = new Location(Bukkit.getWorld("world_the_end"), p.getX(), -10, p.getZ());
                        p.teleport(location);
                    } else if (p.getY() < -80) {
                        Location location = new Location(Bukkit.getWorld("world_nether"), p.getX() / 8, 320, p.getZ() / 8);
                        p.teleport(location);
                    }
                } else if (p.getWorld().getEnvironment() == World.Environment.NETHER) {
                    if (p.getY() > 320) {
                        Location location = new Location(Bukkit.getWorld("world"), p.getX() * 8, -60, p.getZ());
                        p.teleport(location);
                    } else if (p.getY() < -20) {
                        Location location = new Location(Bukkit.getWorld("world_the_end"), p.getX() * 8, 320, p.getZ() * 8);
                        p.teleport(location);
                    }
                } else if (p.getWorld().getEnvironment() == World.Environment.THE_END) {
                    if (p.getY() > 320) {
                        Location location = new Location(Bukkit.getWorld("world_nether"), p.getX() / 8, -10, p.getZ() / 8);
                        p.teleport(location);
                    } else if (p.getY() < -20) {
                        Location location = new Location(Bukkit.getWorld("world"), p.getX(), 500, p.getZ());
                        p.teleport(location);
                    }
                }
            }
        }, 0L, 20L);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            Player p = (Player) e.getEntity();
            if (p.getWorld().getEnvironment() == World.Environment.THE_END) {
                e.setCancelled(true);
                Location location = new Location(Bukkit.getWorld("world"), p.getX(), 500, p.getZ());
                p.teleport(location);
            } else if (p.getWorld().getEnvironment() == World.Environment.NORMAL) {
                e.setCancelled(true);
                Location location = new Location(Bukkit.getWorld("world_nether"), p.getX() / 8, 320, p.getZ() / 8);
                p.teleport(location);
            } else if (p.getWorld().getEnvironment() == World.Environment.NETHER) {
                e.setCancelled(true);
                Location location = new Location(Bukkit.getWorld("world_the_end"), p.getX() * 8, 320, p.getZ() * 8);
                p.teleport(location);
            }
        }
    }

}
