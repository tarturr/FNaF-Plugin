package fr.tartur.fnaf.gui.inventories.common;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class InventoryBuilder {

    private int size;
    private String title;
    private Map<Integer, ItemStack> items;

    public InventoryBuilder() {
        this.size = 0;
        this.title = "§4UNKNOWN";
        this.items = new HashMap<>();
    }

    public InventoryBuilder setSize(int size) {
        assert size >= 1 && size <= 6 : "The inventory size cannot be smaller than 1 or larger than 6.";
        this.size = size * 9;
        return this;
    }

    public InventoryBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public InventoryBuilder setItems(Map<Integer, ItemStack> itemPlaces) {
        this.items = itemPlaces;
        return this;
    }

    public Inventory build() {
        Inventory inv = Bukkit.createInventory(null, this.size, this.title);
        this.items.forEach(inv::setItem);

        return inv;
    }

}
