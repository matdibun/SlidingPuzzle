import javax.swing.*;
import java.io.*;
import java.util.List;

public class LeaderboardModel {
    private String filePath = "ranking.txt";
    private List<String> leaderboardEntries;

    private Leaderboard leaderboard;

    // Add a new score to the leaderboard
    public void addScore(String name, String time) {
        int count  = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        leaderboardEntries.add(count + ". \t" + name + "\t\t" + time);
        saveLeaderboard();
        leaderboard.displayLeaderboard();
    }

    // Load leaderboard from the file
    public void loadLeaderboard() {
        File file = new File(filePath);
        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    leaderboardEntries.add(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save leaderboard to the file
    private void saveLeaderboard() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (String entry : leaderboardEntries) {
                writer.write(entry);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
