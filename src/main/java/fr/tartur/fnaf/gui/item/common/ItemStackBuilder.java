package fr.tartur.fnaf.gui.item.common;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStackBuilder {

    private String name;
    private int amount;
    private Material material;
    private final List<String> description;
    private final Map<Enchantment, Integer> enchantments;
    private final List<ItemFlag> itemFlags;

    public ItemStackBuilder() {
        this.name = "§4UNKNOWN";
        this.amount = 1;
        this.material = Material.BEDROCK;
        this.description = new ArrayList<>();
        this.enchantments = new HashMap<>();
        this.itemFlags = new ArrayList<>();
    }

    public ItemStackBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemStackBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemStackBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ItemStackBuilder addDescriptionLine(String line) {
        this.description.add("§9" + line);
        return this;
    }

    public ItemStackBuilder addEnchant(Enchantment enchantment) {
        return this.addEnchant(enchantment, 1);
    }

    public ItemStackBuilder addEnchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);
        return this;
    }

    public ItemStackBuilder addItemFlag(ItemFlag itemFlag) {
        this.itemFlags.add(itemFlag);
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(this.material, this.amount);

        ItemMeta meta = item.getItemMeta();
        assert meta != null : "The provided ItemMeta is null.";

        meta.setDisplayName(this.name);
        meta.setLore(this.description);
        this.enchantments.forEach((enchant, level) -> meta.addEnchant(enchant, level, true));
        this.itemFlags.forEach(meta::addItemFlags);

        item.setItemMeta(meta);
        return item;
    }

}
