import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
    private SlidePuzzleBoard board;
    private PuzzleFrame frame;
    private Time time;
//    private Leaderboard leaderboard;
//    private String name;

    public StartButton(SlidePuzzleBoard b, PuzzleFrame f){
        super("Start");
        board = b;
        frame = f;
        time = new Time(this);
        addActionListener(this);
        setFont(new Font("Arial",Font.BOLD,16));

    }

    public void actionPerformed(ActionEvent e){
        board.createPuzzleBoard();
        frame.update();
        this.setText("Reshuffle");
        time.start();

        //--------------TESTING---------------
//        name = JOptionPane.showInputDialog("Input your name");
//        leaderboard = new Leaderboard(name, time);

    }
}
