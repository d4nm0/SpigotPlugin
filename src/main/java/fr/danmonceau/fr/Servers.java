package fr.danmonceau.fr;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public enum Servers {

    Create("PanKiCreate",new ItemStack(Material.COMPASS),"Serveur creatif", new ArrayList<>(Collections.singletonList("test crea"))),
    Survie("PanKiCraft",new ItemStack(Material.IRON_PICKAXE),"Serveur survie", new ArrayList<>(Collections.singletonList("test survie")));
    private final String bungeeName;
    private final ItemStack is;
    private final String displayName;
    private final ArrayList<String> description;

    Servers(String bungeeName, ItemStack is, String displayName, ArrayList<String> description) {
        this.bungeeName = bungeeName;
        this.is = is;
        this.displayName = displayName;
        this.description = description;
    }

    public String getBungeeName() {
        return bungeeName;
    }

    public ItemStack getIs() {
        return is;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ArrayList<String> getDescription() {
        return description;
    }
}
