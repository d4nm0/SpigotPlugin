package fr.danmonceau.fr.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.danmonceau.fr.DanMain;
import fr.danmonceau.fr.Servers;
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
        System.out.println("click");
        final Player player = (Player)event.getWhoClicked();
        final Inventory inventory = event.getClickedInventory();

                System.out.println("if menu du serveur");
                final int clickedSlot = event.getSlot();
                final ItemStack itemStack = inventory.getItem(clickedSlot);
                if (itemStack != null) {
                    System.out.println("pas nul");
                    if (itemStack.hasItemMeta()){
                        final ItemMeta meta = itemStack.getItemMeta();

                        if (meta.hasDisplayName()) {
                            System.out.println("display name");
                            final String displayName = meta.getDisplayName();
                            for (Servers servers : Servers.values()) {
                                if (servers.getDisplayName().equals(displayName)){
                                    // Send signal a bungee
                                    final ByteArrayDataOutput out = ByteStreams.newDataOutput();

                                    out.writeUTF("Connect");
                                    out.writeUTF(servers.getBungeeName());

                                    player.sendPluginMessage(DanMain.INSTANCE,"BungeeCord",out.toByteArray());
                                }
                            }
                        }
                    }
                }



            event.setCancelled(true);


    }
}
