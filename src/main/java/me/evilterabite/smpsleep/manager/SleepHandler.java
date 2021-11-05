package me.evilterabite.smpsleep.manager;

import me.evilterabite.smpsleep.SMPSleep;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.Objects;

public class SleepHandler implements Listener {

    @EventHandler
    void onSleepEvent(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        PlayerBedEnterEvent.BedEnterResult result = event.getBedEnterResult();
        if(result == PlayerBedEnterEvent.BedEnterResult.OK) {
            Bukkit.getScheduler().runTaskLater(SMPSleep.getProvidingPlugin(SMPSleep.class), () -> {
                Objects.requireNonNull(Bukkit.getServer().getWorld("world")).setTime(1000);
                Bukkit.broadcastMessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.YELLOW + " went to sleep! Sweet Dreams...");
            }, 20L * 5);
        }
    }

}
