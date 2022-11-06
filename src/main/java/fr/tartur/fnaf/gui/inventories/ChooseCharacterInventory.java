package fr.tartur.fnaf.gui.inventories;

import fr.tartur.fnaf.game.GameCharacter;
import fr.tartur.fnaf.gui.inventories.common.InventoryBuilder;
import fr.tartur.fnaf.gui.inventories.common.InventoryContentBuilder;
import fr.tartur.fnaf.gui.item.common.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class ChooseCharacterInventory {

    private final Inventory inventory;

    public ChooseCharacterInventory() {
        this.inventory = new InventoryBuilder()
                .setTitle("§6Choisir un personnage")
                .setSize(3)
                .setItems(new InventoryContentBuilder<>()
                        .setItemAt(10, new ItemStackBuilder()
                                .setName(GameCharacter.FREDDY.toString())
                                .setMaterial(Material.LEATHER_HELMET)
                                .addDescriptionLine("Je veux jouer ce rôle !")
                                .addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
                                .build()
                        )
                        .setItemAt(11, new ItemStackBuilder()
                                .setName(GameCharacter.BONNIE.toString())
                                .setMaterial(Material.DIAMOND_HELMET)
                                .addDescriptionLine("Je veux jouer ce rôle !")
                                .addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
                                .build()
                        )
                        .setItemAt(13, new ItemStackBuilder()
                                .setName(GameCharacter.NIGHTGUARD.toString())
                                .setMaterial(Material.NETHERITE_HELMET)
                                .addDescriptionLine("Je veux jouer ce rôle !")
                                .addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
                                .build()
                        )
                        .setItemAt(15, new ItemStackBuilder()
                                .setName(GameCharacter.CHICA.toString())
                                .setMaterial(Material.GOLDEN_HELMET)
                                .addDescriptionLine("Je veux jouer ce rôle !")
                                .addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
                                .build()
                        )
                        .setItemAt(16, new ItemStackBuilder()
                                .setName(GameCharacter.FOXY.toString())
                                .setMaterial(Material.CHAINMAIL_HELMET)
                                .addDescriptionLine("Je veux jouer ce rôle !")
                                .addItemFlag(ItemFlag.HIDE_ATTRIBUTES)
                                .build()
                        ).build()
                ).build();
    }

    public Inventory get() {
        return this.inventory;
    }
}
