package fr.tartur.fnaf.gui.inventories.common;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class InventoryContentBuilder<T extends ItemStack> {

    private final Map<Integer, T> itemPlaces;

    public InventoryContentBuilder() {
        this.itemPlaces = new HashMap<>();
    }

    public InventoryContentBuilder<T> setItemAt(int pos, T item) {
        this.itemPlaces.put(pos, item);
        return this;
    }

    public Map<Integer, T> build() {
        return this.itemPlaces;
    }

}
