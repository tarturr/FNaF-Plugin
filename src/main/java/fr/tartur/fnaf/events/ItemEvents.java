package fr.tartur.fnaf.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemEvents implements Listener {

    @EventHandler
    public void onPlayerPickup(EntityPickupItemEvent event) {
        if (event.getEntityType() == EntityType.PLAYER) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

}
