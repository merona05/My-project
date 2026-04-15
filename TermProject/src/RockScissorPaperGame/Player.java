package RockScissorPaperGame;

public class Player {
    String name;
    int score;
    int winStreak;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.winStreak = 0;
    }
}