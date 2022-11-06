package fr.tartur.fnaf.game;

public enum GameState {
    WAITING("§7En attente..."),
    PLAYING("§bEn cours");

    private final String state;

    GameState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return this.state;
    }
}
