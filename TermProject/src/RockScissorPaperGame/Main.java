package RockScissorPaperGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RSP game = new RSP();
        ScoreManager scoreManager = new ScoreManager();
        FileManager fileManager = new FileManager();
    	
        while(true) {
	        System.out.print("Enter your name: ");
	        String name = sc.next();
	        Player player = new Player(name);
	        int life = 3;        
	        
	        while (life > 0) {
	            System.out.print("Enter (rock/paper/scissors): ");
	            String user = sc.next();
	
	            String computer = game.getComputerChoice();
	            System.out.println("Computer: " + computer);
	
	            int result = game.decideWinner(user, computer);
	
	            if (result == 1) {
	                scoreManager.win(player);
	                System.out.println("Total Score: " + player.score);
	            }
	            else if (result == 0) {
	                scoreManager.draw(player);
	            }
	            else {
	                life--;
	                scoreManager.lose(player);
	                System.out.println("Remaining life: " + life);
	            }
	        }    
	        System.out.println("\nGame Over!");
	        System.out.println("Player: " + player.name);
	        System.out.println("Final Score: " + player.score);
	        
	        FileManager.ScoreData best = fileManager.loadScore();

	        if (best != null) {
	            System.out.println("Current Best: " + best.name + " (" + best.score + ")");
	        }
	        else {
	            System.out.println("No record yet.");
	        }
	        
	        if (best == null || player.score > best.score) {
	            System.out.println("New High Score! Save it? (yes/no): ");
	            String answer = sc.next();
	
	            if (answer.equalsIgnoreCase("yes")) {
	                fileManager.saveScore(player.name, player.score);
	                System.out.println("Saved!");
	            }
	        } else {
	            System.out.println("Good Game!");
	        }   
	        System.out.print("Play again? (yes/no): ");
	        String again = sc.next();

	        if (!again.equalsIgnoreCase("yes")) {
	            break;
	        }
	    }
	}
}
