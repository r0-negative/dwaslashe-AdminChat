package xyz.dwaslashe.adminchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.dwaslashe.adminchat.utils.Api;

public class Main extends JavaPlugin implements Listener {
    public Main() {
    }

    @Override
    public void onEnable() {
        if (getDescription().getName().contains("dwaslashe-AdminChat") && getDescription().getAuthors().contains("dwaslashe")) {
            System.out.println("    /     /     Made in Poland");
            System.out.println("   /     /      by dwaslashe (//)");
            System.out.println("  /     /       nie wiem nudzi mi sie");
            System.out.println(" /     /        pozdrawiam z rodzina");
            System.out.println("/     /         miniserv.pl/rf/wywrotkamc polecam");
            System.out.println("Jakbys chcial jakis plugin to do mnie pisz xD //#1013");
            getServer().getPluginManager().registerEvents(this, this);
            getConfig().addDefault("adminchat.permission", "dwaslashe.adminchat");
            getConfig().addDefault("adminchat.prefix", "@");
            getConfig().addDefault("adminchat.message", "&8[&c&l@&8] &7{player}&f: ");
            getConfig().options().copyDefaults(true);
            saveConfig();
        } else {
            getPluginLoader().disablePlugin((Plugin) this);
            System.out.println(Api.fixColor("Dowidzenia panu NAURA"));
        }
    }

    @Override
    public void onDisable() {
        System.out.println("    /     /     Made in Poland");
        System.out.println("   /     /      by dwaslashe (//)");
        System.out.println("  /     /       nie wiem nudzi mi sie");
        System.out.println(" /     /        pozdrawiam z rodzina");
        System.out.println("/     /         miniserv.pl/rf/wywrotkamc polecam");
        System.out.println("Jakbys chcial jakis plugin to do mnie pisz xD //#1013");
    }

    @EventHandler
    public void onAdminChat1(AsyncPlayerChatEvent e) {
        String message = e.getMessage().replace(getConfig().getString("adminchat.prefix"), "");
        Player p = e.getPlayer();
        for (Player admins : Bukkit.getOnlinePlayers()) {
            if (admins.hasPermission(getConfig().getString("adminchat.permission")) && p.hasPermission(getConfig().getString("adminchat.permission"))) {
                if (e.getMessage().startsWith(getConfig().getString("adminchat.prefix"))) {
                    e.setCancelled(true);
                    admins.sendMessage(Api.fixColor(getConfig().getString("adminchat.message") + message).replace("{player}", p.getName()));
                    System.out.println(Api.fixColor(getConfig().getString("adminchat.message") + message).replace("{player}", p.getName()));
                }
            }
        }
    }
    @EventHandler
    public void TestGithuba(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        event.setJoinMessage(null);
        p.sendMessage("witoj testowa");
    }
}
