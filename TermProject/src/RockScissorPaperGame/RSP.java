package RockScissorPaperGame;

import java.util.Random;
public class RSP {
    private String[] choices = {"rock", "paper", "scissors"};
    private Random rand = new Random();

    public String getComputerChoice() {
        return choices[rand.nextInt(3)];
    }

    public int decideWinner(String user, String computer) {
        if (user.equals(computer)) return 0;

        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return 1;
        }

        return -1;
    }
}
