package fr.danmonceau.fr.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.danmonceau.fr.DanMain;
import fr.danmonceau.fr.Servers;
import org.bukkit.GameMode;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

           //System.out.println("onInventoryClick");
            final Player player = (Player) event.getWhoClicked();
            //System.out.println(player);
            final Inventory inventory = event.getClickedInventory();

            final int clickedSlot = event.getSlot();
            if (clickedSlot >= 1){
                final ItemStack itemStack = inventory.getItem(clickedSlot);


                if (player.getGameMode() == GameMode.ADVENTURE) {
                    if (itemStack != null) {
                        if (itemStack.hasItemMeta()) {
                            final ItemMeta meta = itemStack.getItemMeta();

                            if (meta.hasDisplayName()) {
                                final String displayName = meta.getDisplayName();
                                for (Servers servers : Servers.values()) {
                                    if (servers.getDisplayName().equals(displayName)) {
                                        final ByteArrayDataOutput out = ByteStreams.newDataOutput();

                                        out.writeUTF("Connect");
                                        out.writeUTF(servers.getBungeeName());

                                        player.sendPluginMessage(DanMain.INSTANCE, "BungeeCord", out.toByteArray());
                                    }
                                }
                            }
                        }
                    }


                    event.setCancelled(true);

                }
            }
    }
}
