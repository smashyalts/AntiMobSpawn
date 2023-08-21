package net.craftsupport.antimobspawn;

import net.craftsupport.antimobspawn.commands.reloadCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public final class AntiMobSpawn extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("amsr").setExecutor(new reloadCommand());
    }
    @EventHandler
    public void onSpawnEvent(CreatureSpawnEvent event) {
        List<String> entitytype = getConfig().getStringList("entitytype");
        if (entitytype.contains(event.getEntityType().toString()) && event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER)) {
            event.setCancelled(true);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
