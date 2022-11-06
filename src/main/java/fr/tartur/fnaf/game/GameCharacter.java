package fr.tartur.fnaf.game;

import net.md_5.bungee.api.ChatColor;

public enum GameCharacter {
    FREDDY(ChatColor.of("#a06b11") + "Freddy"),
    BONNIE(ChatColor.of("#6e69ff") + "Bonnie"),
    CHICA(ChatColor.of("#fff521") + "Chica"),
    FOXY(ChatColor.of("#ff4a2d") + "Foxy"),
    NIGHTGUARD(ChatColor.of("#7c00ff") + "Gardien de nuit"),
    SPECTATOR("§fSpectator"),
    UNDEFINED("§7Non choisi");

    private final String name;

    GameCharacter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
