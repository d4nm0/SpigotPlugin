package fr.danmonceau.fr.listeners;

import fr.danmonceau.fr.DanMain;
import fr.danmonceau.fr.Servers;
import fr.danmonceau.fr.itemStackHelper;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event) {

        //System.out.println("onPlayerInteract");
        final Player player = event.getPlayer();
        final Action action = event.getAction();

        final ItemStack is = player.getInventory().getItemInMainHand();

        if (player.getGameMode() == GameMode.ADVENTURE) {

            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK ) {
                if (player.getInventory().getItemInMainHand().getType().equals(DanMain.COMPASS.getType())) {
                    if (is.hasItemMeta()) {
                        if (is.getItemMeta().getDisplayName().equals(DanMain.COMPASS.getItemMeta().getDisplayName())){
                            //System.out.println(player.getGameMode());
                            final Inventory menu = Bukkit.createInventory(player, InventoryType.CHEST, "Liste des serveurs");

                            for(Servers servers : Servers.values()) {
                                menu.addItem(itemStackHelper.buildItemstack(servers.getIs(), servers.getDisplayName(), servers.getDescription()));
                            }

                            player.openInventory(menu);
                        }
                    }
                }
            }

        }
    }
}
