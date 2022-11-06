package fr.tartur.fnaf.game;

import fr.tartur.fnaf.game.player.FnafPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.*;

public class Game {

    private static GameState gameState = GameState.WAITING;
    private final List<FnafPlayer> players;
    private final List<FnafPlayer> spectators;

    public Game() {
        this.players = new ArrayList<>();
        this.spectators = new ArrayList<>();
    }

    public void start() {
    }

    public void join(Player player, GameCharacter role) {
        FnafPlayer fnafPlayer = new FnafPlayer(player, role);

        if (role == GameCharacter.SPECTATOR) {
            player.setGameMode(GameMode.SPECTATOR);
            player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 3.0f, 3.0f);
            player.sendTitle("§cEN JEU", "§bLa partie est déjà lancée !", 1, 5, 1);

            this.spectators.add(fnafPlayer);
        } else {
            player.setGameMode(GameMode.SURVIVAL);
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 3.0f, 3.0f);
            player.sendTitle("§aBIENVENUE !", "§6Vote pour l'animatronique que tu veux jouer !", 1, 5, 1);

            this.players.add(fnafPlayer);
        }
    }

    public void leave(Player player) {
        if (gameState == GameState.PLAYING) {
            boolean wasSpectator = false;

            for (FnafPlayer fnafPlayer : this.spectators) {
                if (fnafPlayer.get() == player) {
                    this.spectators.remove(fnafPlayer);
                    wasSpectator = true;
                }
            }

            if (!wasSpectator) {
                for (FnafPlayer fnafPlayer : this.players) {
                    if (fnafPlayer.get() == player) {
                        this.players.remove(fnafPlayer);
                        Bukkit.broadcastMessage(fnafPlayer.getRole().name() + "§ca quitté la partie !");
                    }
                }
            }
        } else {
            this.players.removeIf(fnafPlayer -> fnafPlayer.get() == player);
        }
    }

    public static GameState getState() {
        return gameState;
    }

    public FnafPlayer getPlayer(Player player) {
        for (FnafPlayer fnafPlayer : this.players) {
            if (fnafPlayer.get() == player) {
                return fnafPlayer;
            }
        }

        return null;
    }

    public FnafPlayer getSpectator(Player player) {
        for (FnafPlayer fnafPlayer : this.spectators) {
            if (fnafPlayer.get() == player) {
                return fnafPlayer;
            }
        }

        return null;
    }

    public List<FnafPlayer> getPlayers() {
        return players;
    }

    public List<FnafPlayer> getSpectators() {
        return spectators;
    }
}
