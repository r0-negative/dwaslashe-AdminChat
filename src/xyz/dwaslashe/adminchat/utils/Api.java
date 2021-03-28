package xyz.dwaslashe.adminchat.utils;

import org.bukkit.ChatColor;

public class Api {
    public Api() {
    }

    public static String fixColor(String message){
        return message == null ? "" : ChatColor.translateAlternateColorCodes('&', message).replace(">>", "»").replace("<<", "«").replace("**", "•").replace(":unlimited:", "∞").replace("<3", "♥").replace(":skull:", "☠").replace(":toxic:", "☢").replace(":crown:", "♚").replace(":stop1:", "▂").replace(":stop2:", "▃").replace(":stop3:", "▄").replace(":stop4:", "▅").replace(":stop5:", "▆").replace(":stop6:", "▇").replace(":stop7:", "█").replace(":ok:", "✔").replace(":no:", "✗");
    }
}
