package me.erisos.qsystem.listeners;

import me.erisos.qsystem.QSystem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class QCommandEvent implements Listener {

    private QSystem plugin;
    public QCommandEvent(QSystem plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){

        Player player = e.getPlayer();
        List<String> allow_commands = plugin.getConfig().getStringList("allow_commands");
        String error_message = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("error_message"));

         if(!player.hasPermission("qsystem.admin")) {
             for (String command : allow_commands) {
                 if (!e.getMessage().startsWith("/" + command)) {
                     e.setCancelled(true);
                     player.sendMessage(error_message);
                 }
             }
         }

    }

}
