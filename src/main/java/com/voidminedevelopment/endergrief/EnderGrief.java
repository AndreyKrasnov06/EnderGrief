package com.voidminedevelopment.endergrief;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnderGrief extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("EnderGrief - включён");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("EnderGrief - отключён");
    }

    @EventHandler
    public void onEntityChangedBlock(EntityExplodeEvent event) {
        if (event.getEntityType() == EntityType.ENDER_DRAGON) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEndermanPickup(EntityChangeBlockEvent event) {
        if (event.getEntityType() == EntityType.ENDERMAN) {
            event.setCancelled(true);
        }
    }
}
