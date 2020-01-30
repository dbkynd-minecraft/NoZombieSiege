package com.dbkynd.nozombiesiege;

import com.dbkynd.nozombiesiege.bstats.Metrics;
import com.dbkynd.nozombiesiege.listeners.CreatureSpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoZombieSiege extends JavaPlugin {

    @Override
    public void onEnable() {
        new Metrics(this, 6385);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new CreatureSpawnListener(this), this);
    }
}
