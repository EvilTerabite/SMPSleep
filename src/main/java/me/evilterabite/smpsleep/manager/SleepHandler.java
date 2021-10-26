package me.evilterabite.smpsleep.manager;

import me.evilterabite.smpsleep.SMPSleep;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
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
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "weather clear 500000");
                Title title = Title.title(Component.empty(), Component.text(SMPSleep.fromComponentToLegacy(player.displayName()) + " went to sleep!", NamedTextColor.GOLD));
                for(Player p : Bukkit.getOnlinePlayers()) {
                    p.showTitle(title);
                }
            }, 20L * 5);
        }
    }

}
