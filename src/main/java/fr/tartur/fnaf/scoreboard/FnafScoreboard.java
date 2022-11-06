package fr.tartur.fnaf.scoreboard;

import fr.mrmicky.fastboard.FastBoard;
import fr.tartur.fnaf.game.Game;

import fr.tartur.fnaf.game.player.FnafPlayer;
import org.bukkit.Bukkit;

public class FnafScoreboard extends FastBoard {

    private final FnafPlayer player;

    public FnafScoreboard(FnafPlayer player) {
        super(player.get());
        this.player = player;

        super.updateTitle("§4FNaF");
        update();
    }

    public void update() {
        super.updateLines(
                "",
                "§a§nRôle§f: " + this.player.getRole(),
                "§6Partie§f: " + Game.getState(),
                "",
                "§6Joueurs§f: " + Bukkit.getOnlinePlayers().size() // FIXME: Le scoreboard ne s'update pas (correctement ?) quand des joueurs supplémentaires arrivent.
        );
    }

}
