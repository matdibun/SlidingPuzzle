import javax.swing.*;

public class Menu_Bar extends JMenuBar {
    Menu_Bar() {
        JMenu difficultyMenu = new JMenu("Difficulty");
        JMenuItem easy = new JMenuItem("Easy");
        JMenuItem medium = new JMenuItem("Medium");
        JMenuItem hard = new JMenuItem("Hard");

        difficultyMenu.add(easy);
        difficultyMenu.add(medium);
        difficultyMenu.add(hard);

        add(difficultyMenu);

    }
}
