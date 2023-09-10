package me.erisos.qsystem.listeners;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class QJoinEvent implements Listener {

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();


        if(!player.hasPermission("qsystem.admin")) {

            player.setWalkSpeed(0);
            player.setFlySpeed(0);
            player.setGameMode(GameMode.ADVENTURE);
            player.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(600,1));
            player.setFoodLevel(20);
        }

    }
    @EventHandler
    public void OnJump(PlayerMoveEvent e) {

       Player player = e.getPlayer();
      if(e.getTo().getBlockY() - e.getFrom().getBlockY() >= 1) { //Oyuncunun 1 veya 2 blok yukarı çıkıp çıkmadığını kontrol ediyoruz.
          if(!player.hasPermission("qsystem.admin")) { e.setCancelled(true);
          }
      }
  }

}

