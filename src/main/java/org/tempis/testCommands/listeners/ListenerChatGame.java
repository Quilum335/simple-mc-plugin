package org.tempis.testCommands.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;



public class ListenerChatGame implements Listener {
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().equalsIgnoreCase("/chatgame.win")) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage("Вы выиграли!");
        }
    }
}