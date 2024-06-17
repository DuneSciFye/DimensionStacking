package me.dunescifye.dimensionstacking.listeners;

import dev.geco.gsit.api.GSitAPI;
import dev.geco.gsit.api.event.PlayerPlayerSitEvent;
import dev.geco.gsit.api.event.PrePlayerGetUpPlayerSitEvent;
import dev.geco.gsit.objects.GetUpReason;
import me.dunescifye.dimensionstacking.DimensionStacking;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import java.util.*;

import static me.dunescifye.dimensionstacking.DimensionStacking.getPlugin;

public class VoidListener implements Listener {

    private static final Map<Player, Player> players = new HashMap<>(); //Bottom player, top player

    public void voidHandler(DimensionStacking plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (!players.containsValue(p)) {
                    if (p.getWorld().getEnvironment() == World.Environment.NORMAL) {
                        if (p.getY() > 400) {
                            if (players.containsKey(p)) { //If player has player on head
                                Player topPlayer = players.get(p);

                                Location location = new Location(Bukkit.getWorld("world_the_end"), p.getX(), -10, p.getZ());
                                //Obtain a list of players in order from bottom to top
                                List<Player> playerStack = new ArrayList<>(Arrays.asList(p, topPlayer));
                                while (players.containsKey(topPlayer)) {
                                    topPlayer = players.get(topPlayer);
                                    playerStack.add(topPlayer);
                                }
                                //Teleport players in stack from top to bottom
                                for (int i = playerStack.size() - 1; i >= 0; i--) {
                                    Player player = playerStack.get(i);
                                    location.setYaw(player.getYaw());
                                    location.setPitch(player.getPitch());
                                    player.teleport(location);
                                }
                                //Stack players bottom to top
                                for (int i = 1; i < playerStack.size(); i++) {
                                    GSitAPI.sitOnPlayer(playerStack.get(i), playerStack.get(i - 1));
                                }

                            } else {
                                Vector vec = p.getVelocity();
                                Location location = new Location(Bukkit.getWorld("world_the_end"), p.getX(), -10, p.getZ());
                                location.setYaw(p.getYaw());
                                location.setPitch(p.getPitch());
                                p.setFallDistance(0);
                                p.teleport(location);
                                Bukkit.getScheduler().runTask(getPlugin(), () -> p.setVelocity(vec.multiply(3)));
                            }
                        } else if (p.getY() < -80) {
                            if (players.containsKey(p)) { //If player has player on head
                                Player topPlayer = players.get(p);

                                Location location = new Location(Bukkit.getWorld("world_nether"), p.getX() / 8, 320, p.getZ() / 8);
                                //Obtain a list of players in order from bottom to top
                                List<Player> playerStack = new ArrayList<>(Arrays.asList(p, topPlayer));
                                while (players.containsKey(topPlayer)) {
                                    topPlayer = players.get(topPlayer);
                                    playerStack.add(topPlayer);
                                }
                                //Teleport players in stack from top to bottom
                                for (int i = playerStack.size() - 1; i >= 0; i--) {
                                    Player player = playerStack.get(i);
                                    location.setYaw(player.getYaw());
                                    location.setPitch(player.getPitch());
                                    player.teleport(location);
                                }
                                //Stack players bottom to top
                                for (int i = 1; i < playerStack.size(); i++) {
                                    GSitAPI.sitOnPlayer(playerStack.get(i), playerStack.get(i - 1));
                                }

                            } else {
                                Vector vec = p.getVelocity();
                                Location location = new Location(Bukkit.getWorld("world_nether"), p.getX() / 8, 320, p.getZ() / 8);
                                location.setYaw(p.getYaw());
                                location.setPitch(p.getPitch());
                                p.setFallDistance(0);
                                p.teleport(location);
                                Bukkit.getScheduler().runTask(getPlugin(), () -> p.setVelocity(vec.multiply(3)));
                            }
                        }
                    } else if (p.getWorld().getEnvironment() == World.Environment.NETHER) {
                        if (p.getY() > 320) {
                            if (players.containsKey(p)) { //If player has player on head
                                Player topPlayer = players.get(p);

                                Location location = new Location(Bukkit.getWorld("world"), p.getX() * 8, -60, p.getZ() * 8);
                                //Obtain a list of players in order from bottom to top
                                List<Player> playerStack = new ArrayList<>(Arrays.asList(p, topPlayer));
                                while (players.containsKey(topPlayer)) {
                                    topPlayer = players.get(topPlayer);
                                    playerStack.add(topPlayer);
                                }
                                //Teleport players in stack from top to bottom
                                for (int i = playerStack.size() - 1; i >= 0; i--) {
                                    Player player = playerStack.get(i);
                                    location.setYaw(player.getYaw());
                                    location.setPitch(player.getPitch());
                                    player.teleport(location);
                                }
                                //Stack players bottom to top
                                for (int i = 1; i < playerStack.size(); i++) {
                                    GSitAPI.sitOnPlayer(playerStack.get(i), playerStack.get(i - 1));
                                }

                            } else {
                                Vector vec = p.getVelocity();
                                Location location = new Location(Bukkit.getWorld("world"), p.getX() * 8, -60, p.getZ() * 8);
                                location.setYaw(p.getYaw());
                                location.setPitch(p.getPitch());
                                p.setFallDistance(0);
                                p.teleport(location);
                                Bukkit.getScheduler().runTask(getPlugin(), () -> p.setVelocity(vec.multiply(3)));
                            }
                        } else if (p.getY() < -20) {
                            if (players.containsKey(p)) { //If player has player on head
                                Player topPlayer = players.get(p);

                                Location location = new Location(Bukkit.getWorld("world_the_end"), p.getX() / 8, 320, p.getZ() / 8);
                                //Obtain a list of players in order from bottom to top
                                List<Player> playerStack = new ArrayList<>(Arrays.asList(p, topPlayer));
                                while (players.containsKey(topPlayer)) {
                                    topPlayer = players.get(topPlayer);
                                    playerStack.add(topPlayer);
                                }
                                //Teleport players in stack from top to bottom
                                for (int i = playerStack.size() - 1; i >= 0; i--) {
                                    Player player = playerStack.get(i);
                                    location.setYaw(player.getYaw());
                                    location.setPitch(player.getPitch());
                                    player.teleport(location);
                                }
                                //Stack players bottom to top
                                for (int i = 1; i < playerStack.size(); i++) {
                                    GSitAPI.sitOnPlayer(playerStack.get(i), playerStack.get(i - 1));
                                }

                            } else {
                                Vector vec = p.getVelocity();
                                Location location = new Location(Bukkit.getWorld("world_the_end"), p.getX() / 8, 320, p.getZ() / 8);
                                location.setYaw(p.getYaw());
                                location.setPitch(p.getPitch());
                                p.setFallDistance(0);
                                p.teleport(location);
                                Bukkit.getScheduler().runTask(getPlugin(), () -> p.setVelocity(vec.multiply(3)));
                            }
                        }
                    } else if (p.getWorld().getEnvironment() == World.Environment.THE_END) {
                        if (p.getY() > 320) {
                            if (players.containsKey(p)) { //If player has player on head
                                Player topPlayer = players.get(p);

                                Location location = new Location(Bukkit.getWorld("world_nether"), p.getX() / 8, -10, p.getZ() / 8);
                                //Obtain a list of players in order from bottom to top
                                List<Player> playerStack = new ArrayList<>(Arrays.asList(p, topPlayer));
                                while (players.containsKey(topPlayer)) {
                                    topPlayer = players.get(topPlayer);
                                    playerStack.add(topPlayer);
                                }
                                //Teleport players in stack from top to bottom
                                for (int i = playerStack.size() - 1; i >= 0; i--) {
                                    Player player = playerStack.get(i);
                                    location.setYaw(player.getYaw());
                                    location.setPitch(player.getPitch());
                                    player.teleport(location);
                                }
                                //Stack players bottom to top
                                for (int i = 1; i < playerStack.size(); i++) {
                                    GSitAPI.sitOnPlayer(playerStack.get(i), playerStack.get(i - 1));
                                }

                            } else {
                                Vector vec = p.getVelocity();
                                Location location = new Location(Bukkit.getWorld("world_nether"), p.getX() / 8, -10, p.getZ() / 8);
                                location.setYaw(p.getYaw());
                                location.setPitch(p.getPitch());
                                p.setFallDistance(0);
                                p.teleport(location);
                                Bukkit.getScheduler().runTask(getPlugin(), () -> p.setVelocity(vec.multiply(3)));
                            }
                        } else if (p.getY() < -30) {
                            if (players.containsKey(p)) { //If player has player on head
                                Player topPlayer = players.get(p);

                                Location location = new Location(Bukkit.getWorld("world"), p.getX(), 399, p.getZ());
                                //Obtain a list of players in order from bottom to top
                                List<Player> playerStack = new ArrayList<>(Arrays.asList(p, topPlayer));
                                while (players.containsKey(topPlayer)) {
                                    topPlayer = players.get(topPlayer);
                                    playerStack.add(topPlayer);
                                }
                                //Teleport players in stack from top to bottom
                                for (int i = playerStack.size() - 1; i >= 0; i--) {
                                    Player player = playerStack.get(i);
                                    location.setYaw(player.getYaw());
                                    location.setPitch(player.getPitch());
                                    player.teleport(location);
                                }
                                //Stack players bottom to top
                                for (int i = 1; i < playerStack.size(); i++) {
                                    GSitAPI.sitOnPlayer(playerStack.get(i), playerStack.get(i - 1));
                                }

                            } else {
                                Vector vec = p.getVelocity();
                                Location location = new Location(Bukkit.getWorld("world"), p.getX(), 399, p.getZ());
                                location.setYaw(p.getYaw());
                                location.setPitch(p.getPitch());
                                p.setFallDistance(0);
                                p.teleport(location);
                                Bukkit.getScheduler().runTask(getPlugin(), () -> p.setVelocity(vec.multiply(3)));
                            }
                        }
                    }
                }
            }
        }, 0L, 1L);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            Entity entity = e.getEntity();
            if (entity.getWorld().getEnvironment() == World.Environment.THE_END) {
                e.setCancelled(true);
                Location location = new Location(Bukkit.getWorld("world"), entity.getX(), 399, entity.getZ());
                entity.teleport(location);
            } else if (entity.getWorld().getEnvironment() == World.Environment.NORMAL) {
                e.setCancelled(true);
                Location location = new Location(Bukkit.getWorld("world_nether"), entity.getX() / 8, 320, entity.getZ() / 8);
                entity.teleport(location);
            } else if (entity.getWorld().getEnvironment() == World.Environment.NETHER) {
                e.setCancelled(true);
                Location location = new Location(Bukkit.getWorld("world_the_end"), entity.getX() * 8, 320, entity.getZ() * 8);
                entity.teleport(location);
            }
        }
    }

    @EventHandler
    public void prePlayerGetUpPlayerSit(PrePlayerGetUpPlayerSitEvent e) {
        if (e.getReason() == GetUpReason.TELEPORT) e.setCancelled(true);
        else players.remove(e.getPlayer());
    }

    @EventHandler
    public void onPlayerPlayerSet(PlayerPlayerSitEvent e) {
        players.put(e.getTarget(), e.getPlayer());
    }


}