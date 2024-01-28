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

    public static final ItemStack COMPASS = itemStackHelper.buildItemstack(new ItemStack(Material.COMPASS,1),"Clique ta mere", new ArrayList<>(Arrays.asList("Si tu clique pas ta mere"," c'est une pute")));

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