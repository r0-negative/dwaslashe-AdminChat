package xyz.dwaslashe.adminchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TEST implements Listener {


    @EventHandler
    public void Sada(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
    }
}
