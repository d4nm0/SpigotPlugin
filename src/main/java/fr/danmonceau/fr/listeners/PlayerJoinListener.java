package fr.danmonceau.fr.listeners;

import fr.danmonceau.fr.DanMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final Inventory inventory = player.getInventory();
        final ItemStack[] itemStacks = inventory.getContents();

        for (ItemStack itemStack : itemStacks) {
            if (itemStack != null) {
                if (itemStack.getType() == DanMain.COMPASS.getType()) {
                    if (itemStack.hasItemMeta()) {

                        if (itemStack.getItemMeta().getDisplayName().equals(DanMain.COMPASS.getItemMeta().getDisplayName())){
                            //System.out.println("found");
                            return;
                        }
                    }
                }
            }

        }

        inventory.setItem(4,DanMain.COMPASS);
    }
}
