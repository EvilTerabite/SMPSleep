package me.evilterabite.smpsleep;

import me.evilterabite.smpsleep.manager.SleepHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SMPSleep extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new SleepHandler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
