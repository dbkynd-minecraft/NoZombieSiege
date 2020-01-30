package com.dbkynd.nozombiesiege.listeners;

import com.dbkynd.nozombiesiege.NoZombieSiege;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnListener implements Listener {

    final NoZombieSiege plugin;

    public CreatureSpawnListener(NoZombieSiege plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason().toString().equals("VILLAGE_INVASION")) {
            event.setCancelled(true);
            if (plugin.getConfig().getBoolean("logCancelledSpawns")) {
                String name = event.getEntity().getName();
                String uuid = event.getEntity().getUniqueId().toString();
                String world = event.getEntity().getWorld().getName();
                int x = event.getEntity().getLocation().getBlockX();
                int y = event.getEntity().getLocation().getBlockY();
                int z = event.getEntity().getLocation().getBlockZ();
                plugin.getLogger().info("CANCELED VILLAGE_INVASION SPAWN - " + name + ", uuid=" + uuid + ", l='" + world + "', x=" + x + ", y=" + y + ", z=" + z);
            }
        }
    }
}
