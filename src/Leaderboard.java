//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Leaderboard {
//    private String name;
//    private Time time;
//
//    Leaderboard(String n, Time t){
//        name = n;
//        time = t;
//
//        File file = new File("ranking.txt");
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            FileWriter writer = new FileWriter(file, true);
//            FileReader reader = new FileReader(file);
//
//            int data, count = 1;
//            while ((data = reader.read()) != -1) {
//                if (data == '\n') {
//                    count++;
//                }
//            }
//
//            reader.close();
//
//            if (this.time == null){
//                writer.write(count + ". " + name +"\n");
//                System.out.println("this.time is null");
//            }else {
//                writer.write(count + ". " + name + "\t\t" + time.getTime() +"\n");
//                System.out.println("this.time not null");
//            }
//            writer.close();
//
//            // --------------DEBUGGING--------------
//            FileReader reader2 = new FileReader(file);
//            int read;
//            while( (read = reader2.read()) != -1){
//                System.out.print((char)read);
//            }
//            System.out.println("ok");
//            reader2.close();
//            //--------------------------------------
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("----------------END----------------");
//    }
//}





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Leaderboard extends JFrame {

    private Font font;
    private JTextArea leaderboardTextArea;
    private List<String> leaderboardEntries;
    private JButton mainMenuButton;
    private String filePath = "ranking.txt";

    public Leaderboard() {
        setTitle("Leaderboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        font = new Font("Monospaced", Font.PLAIN, 18);

        leaderboardTextArea = new JTextArea();
        leaderboardTextArea.setEditable(false);
        add(new JScrollPane(leaderboardTextArea), BorderLayout.CENTER);

        leaderboardEntries = new ArrayList<>();

        // Load existing leaderboard entries from file
        loadLeaderboard();

        // Display leaderboard
        displayLeaderboard();

        // Create and add "Main Menu" button
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Serif", Font.PLAIN, 18));
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameMenu();  // Go back to the main menu
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mainMenuButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

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
        displayLeaderboard();
    }

    // Load leaderboard from the file
    private void loadLeaderboard() {
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

    // Display the leaderboard in the text area
    private void displayLeaderboard() {
        leaderboardTextArea.setText("");
        for (String entry : leaderboardEntries) {
            leaderboardTextArea.append(entry + "\n");
        }
        leaderboardTextArea.setFont(font);
    }

    // Method to return to the GameMenu
    private void openGameMenu() {
        GameMenu gameMenu = new GameMenu();  // Create the GameMenu instance
        gameMenu.setVisible(true);  // Show the GameMenu
        this.setVisible(false);  // Hide the Leaderboard window
    }

}