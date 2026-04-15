package RockScissorPaperGame;

import java.io.*;

public class FileManager {
    private String fileName = "score.txt";

    public class ScoreData {
        String name;
        int score;

        public ScoreData(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
   
    public ScoreData loadScore() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            br.close();

            if (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int score = Integer.parseInt(parts[1]);

                return new ScoreData(name, score);
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void saveScore(String name, int score) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(name + "," + score);
            bw.close();

        } catch (Exception e) {
            System.out.println("Error saving score.");
        }
    }
    
}