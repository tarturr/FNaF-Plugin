package fr.tartur.fnaf.events;

import fr.tartur.fnaf.game.Game;
import fr.tartur.fnaf.game.GameCharacter;
import fr.tartur.fnaf.game.GameState;
import fr.tartur.fnaf.gui.inventories.common.InventoryContentBuilder;
import fr.tartur.fnaf.gui.item.ChooseCharacterItem;
import fr.tartur.fnaf.gui.item.common.ItemAction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class GameEvents implements Listener {

    private final Game game;

    private final Map<Integer, ItemAction> joinItems;

    public GameEvents() {
        this.game = new Game();
        this.joinItems = new InventoryContentBuilder<ItemAction>()
                .setItemAt(4, new ChooseCharacterItem())
                .build();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();

        joinItems.forEach((pos, item) -> player.getInventory().setItem(pos, item));

        if (Game.getState() == GameState.PLAYING) {
            this.game.join(player, GameCharacter.SPECTATOR);
            event.setJoinMessage("");
        } else {
            this.game.join(player, GameCharacter.UNDEFINED);
            event.setJoinMessage("§f[§a+§f] §e" + player.getName());
        }

        this.game.getPlayers().forEach(fnafPlayer -> fnafPlayer.getScoreboard().update());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        this.game.leave(player);
        event.setQuitMessage(Game.getState() != GameState.PLAYING ? "§f[§4-§f] §e" + player.getName() : "");

        this.game.getPlayers().forEach(fnafPlayer -> fnafPlayer.getScoreboard().update());
    }


    // FIXME: Essayer d'améliorer la gestion d'events avec les items.
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (item == null || !item.hasItemMeta()) return;

        this.joinItems.forEach((pos, itemAction) -> {
            if (item.getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
                event.setCancelled(true);
                itemAction.onInteract(player, action);
            }
        });
    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent event) {
        // TODO: Implémenter les events.
        event.setCancelled(true);
    }

}
