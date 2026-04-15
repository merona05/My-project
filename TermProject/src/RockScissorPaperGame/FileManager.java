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
    // 최고 점수 불러오기
    // return format: "name,score"
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
            // 파일 없으면 null
        }
        return null;
    }

    // 최고 점수 저장
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