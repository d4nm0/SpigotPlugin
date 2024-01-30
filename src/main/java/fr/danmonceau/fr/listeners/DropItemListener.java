package fr.danmonceau.fr.listeners;

import fr.danmonceau.fr.DanMain;
import fr.danmonceau.fr.Servers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropItemListener implements Listener {
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        if (droppedItem.getType().equals(DanMain.COMPASS.getType())) {
            event.setCancelled(true); // Annule le drop de l'item si c'est un compas
        }
    }
}
