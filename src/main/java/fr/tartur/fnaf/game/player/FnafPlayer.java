package fr.tartur.fnaf.game.player;

import fr.tartur.fnaf.game.GameCharacter;
import fr.tartur.fnaf.scoreboard.FnafScoreboard;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class FnafPlayer {

    private final Player player;
    private GameCharacter role;
    private final FnafScoreboard scoreboard;
    private final Set<GameCharacter> wantedRoles;

    public FnafPlayer(Player player) {
        this(player, GameCharacter.UNDEFINED);
    }

    public FnafPlayer(Player player, GameCharacter role) {
        this.player = player;
        this.role = role;
        this.scoreboard = new FnafScoreboard(this);
        this.wantedRoles = new HashSet<>();
    }

    public Player get() {
        return player;
    }

    public FnafScoreboard getScoreboard() {
        return scoreboard;
    }

    public Set<GameCharacter> getWantedRoles() {
        return wantedRoles;
    }

    public GameCharacter getRole() {
        return role;
    }

    public void setRole(GameCharacter role) {
        this.role = role;
    }
}
