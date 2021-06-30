package xyz.dwaslashe.adminchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.dwaslashe.adminchat.utils.Api;

public class Main extends JavaPlugin implements Listener {
    private String prefix;
    private String permission;

    @Override
    public void onEnable() {
        if (!getDescription().getName().contains("dwaslashe-AdminChat") && !getDescription().getAuthors().contains("dwaslashe")) {
            getPluginLoader().disablePlugin(this);
            System.out.println("Nazwe pluginu ustaw na dwaslashe-AdminChat, a autora na dwaslashe");
            return;
        }
        getConfig().addDefault("adminchat.permission", "dwaslashe.adminchat");
        getConfig().addDefault("adminchat.prefix", "@");
        getConfig().addDefault("adminchat.message", "&8[&c&l@&8] &7{player}&f: ");
        getConfig().options().copyDefaults(true);
        saveConfig();

        prefix = getConfig().getString("adminchat.prefix");
        permission = getConfig().getString("adminchat.permission");

        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onMessageSent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (!e.getMessage().startsWith(prefix) && p.hasPermission(permission)) return;
        String message = e.getMessage().replace(prefix, "");
        e.setCancelled(true);

        Bukkit.getOnlinePlayers()
                .stream().filter(player -> player.hasPermission(permission))
                .forEach(player -> {
                    String text = Api.fixColor(getConfig().getString("adminchat.message") + message).replace("{player}", p.getName());
                    player.sendMessage(text);
                    System.out.println(text);
                });
    }
}
