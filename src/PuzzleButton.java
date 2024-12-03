import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleButton extends JButton implements ActionListener {
    private SlidePuzzleBoard board;
    private PuzzleFrame frame;
    private int row;
    private int col;
    private Leaderboard leaderboard;
    private String name;
    private Time time;


    public PuzzleButton(SlidePuzzleBoard b, PuzzleFrame f, int row, int col, Time time) {
        board = b;
        frame = f;
        this.row = row;
        this.col = col;
        this.time = time;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //PuzzlePiece piece = board.contents()[row][col];
        PuzzlePiece piece1 = board.getPuzzlePiece(row,col);
        if (piece1 != null) {
            boolean moved = board.move(piece1.faceValue());
            if (moved) {
                frame.update();
            }
        }
        if (board.gameOver()){
            frame.finish();
            time.stop();

            String input = JOptionPane.showInputDialog("Input your name");
            if(input != null){
                name = input;
            }else{
                name = "Unknown";
            }

            leaderboard = new Leaderboard();
            leaderboard.getLeaderboardModel().addScore(name, time.getTime());

            time.reset();

        }
    }
}
