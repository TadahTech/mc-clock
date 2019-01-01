package com.tadahtechnologies.mctest;

import com.tadahtechnologies.mctest.world.BlockClock;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.ZonedDateTime;

public final class MCTest extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        //This is just for example display purposes
        World world = getServer().getWorlds().get(0);

        Location spawn = world.getSpawnLocation();

        BlockClock clock = new BlockClock(ZonedDateTime.now(), spawn.clone().add(5, 5, 0));
        clock.spawnClock();

        world.setSpawnLocation(spawn.subtract(10, 0, 0));
        world.setSpawnLocation(world.getSpawnLocation().add(0, 5, 0));

        new BukkitRunnable() {
            @Override
            public void run() {
                clock.setDateTime(ZonedDateTime.now());
            }
        }.runTaskTimer(this, 20L, 20L);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void join(PlayerJoinEvent event) {
        event.getPlayer().teleport(getServer().getWorlds().get(0).getSpawnLocation());
    }
}
