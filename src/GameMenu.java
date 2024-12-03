import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    //GameMenuController controller;
    GameMenu gameMenu;
    SlidePuzzleBoard slidePuzzleBoard;
    PuzzleFrame puzzleFrame;
    Leaderboard leaderboard;

    // Constructor for the Game Menu
    public GameMenu() {
        setTitle("Puzzle Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create menu bar with Game options
        JMenuBar menuBar = new JMenuBar();
        JMenuItem startMenuItem = new JMenuItem("Start Game");
        JMenuItem leaderboardMenuItem = new JMenuItem("Leaderboard");


        // Create main panel with buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Title label
        JLabel titleLabel = new JLabel("Welcome to Puzzle Game!", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));

        // Start button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Serif", Font.PLAIN, 18));

        // Leaderboard button
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setFont(new Font("Serif", Font.PLAIN, 18));

        // Add components to panel
        panel.add(titleLabel);
        panel.add(startButton);
        panel.add(leaderboardButton);

        // Add the panel to the JFrame
        add(panel, BorderLayout.CENTER);

        //controller = new GameMenuController();

        // Action listeners for buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPuzzleFrame();  // Open the puzzle game when "Start Game" is clicked
            }
        });

        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLeaderboard();  // Open leaderboard when "Leaderboard" is clicked
            }
        });

        // Action listeners for menu items
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPuzzleFrame();  // Open puzzle game when "Start Game" menu item is clicked
            }
        });

        leaderboardMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLeaderboard();  // Open leaderboard when "Leaderboard" menu item is clicked
            }
        });
    }

    // Method to open the puzzle frame (your existing puzzle game logic)
    private void openPuzzleFrame() {
        SlidePuzzleBoard board = new SlidePuzzleBoard();  // Create an instance of your puzzle class
        PuzzleFrame puzzleFrame = new PuzzleFrame(board);  // Create the PuzzleFrame with the board
        puzzleFrame.setVisible(true);  // Make the puzzle frame visible
        this.setVisible(false);  // Hide the game menu window
    }

    // Method to open the leaderboard screen (this connects to your actual Leaderboard class)
    private void openLeaderboard() {
        Leaderboard leaderboard = new Leaderboard();  // Instantiate your existing Leaderboard class
        leaderboard.setVisible(true);  // Make the leaderboard window visible
        this.setVisible(false);  // Hide the game menu window
    }

}
