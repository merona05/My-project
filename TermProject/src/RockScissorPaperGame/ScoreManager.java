package RockScissorPaperGame;

public class ScoreManager {

    public void win(Player player) {
        player.winStreak++;

        int bonus = 0;

        if (player.winStreak >= 3) {
            bonus = (player.winStreak - 2) * 10;
        }

        int gained = 100 + bonus;
        player.score += gained;

        System.out.println("Win!");
    }

    public void lose(Player player) {
        player.winStreak = 0;
        System.out.println("Lose! Streak reset.");
    }

    public void draw(Player player) {
    	player.winStreak = 0;
        System.out.println("Draw!");
    }
}