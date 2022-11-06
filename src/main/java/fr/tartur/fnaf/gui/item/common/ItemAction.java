package fr.tartur.fnaf.gui.item.common;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class ItemAction extends ItemStack {

    public ItemAction(ItemStack itemStack) {
        super(itemStack);
    }
    
    public abstract void onInteract(Player player, Action action);
    
}
