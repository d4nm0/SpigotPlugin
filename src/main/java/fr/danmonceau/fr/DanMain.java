package fr.danmonceau.fr;

import fr.danmonceau.fr.listeners.InventoryClickListener;
import fr.danmonceau.fr.listeners.PlayerInteractListener;
import fr.danmonceau.fr.listeners.PlayerJoinListener;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.Arrays;


public class DanMain extends JavaPlugin {

    public static DanMain INSTANCE;

    public static final ItemStack COMPASS = itemStackHelper.buildItemstack(new ItemStack(Material.COMPASS,1),"Selection de serveur", new ArrayList<>(Arrays.asList("Ligne 1"," ligne 2")));

    public void onEnable() {
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        INSTANCE = this;
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);

        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        System.out.println("Plugin Activate");
    }

    public void onDisable() {

        System.out.println("Plugin DesActivate");
    }
}
