package fr.tartur.fnaf.gui.item;

import fr.tartur.fnaf.gui.inventories.ChooseCharacterInventory;
import fr.tartur.fnaf.gui.item.common.ItemAction;
import fr.tartur.fnaf.gui.item.common.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;

public class ChooseCharacterItem extends ItemAction {

    private final Inventory waitingInventory;

    public ChooseCharacterItem() {
        super(new ItemStackBuilder()
                .setName("§6Choisir un personnage")
                .setMaterial(Material.ENDER_EYE)
                .addDescriptionLine("Fais clic droit pour")
                .addDescriptionLine("ouvrir le menu et choisir")
                .addDescriptionLine("le personnage que tu souhaiterais")
                .addDescriptionLine("jouer cette partie !")
                .build()
        );

        this.waitingInventory = new ChooseCharacterInventory().get();
    }

    @Override
    public void onInteract(Player player, Action action) {
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            player.openInventory(this.waitingInventory);
        }
    }
}
