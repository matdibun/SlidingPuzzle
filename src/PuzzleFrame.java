import javax.swing.*;
import java.awt.*;

public class PuzzleFrame extends JFrame {
    private SlidePuzzleBoard board;
    private PuzzleButton[][] button_board;
    private Time timer;

    Font font = new Font("Arial", Font.BOLD, 24);

    public PuzzleFrame(SlidePuzzleBoard b) {
        board = b;
        button_board = new PuzzleButton[4][4];

        setTitle("Sliding Puzzle Game");
        setLayout(new BorderLayout());
        setSize(400, 400);
        //setJMenuBar(new Menu_Bar());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        StartButton startButton = new StartButton(board,this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);

        timer = new Time(startButton);
        timer.setFont(font);
        JPanel timerPanel = new JPanel();
        timerPanel.add(timer);

        add(timerPanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);
        JPanel gridPanel = new JPanel(new GridLayout(4, 4));

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                button_board[row][col] = new PuzzleButton(board,this,row,col,timer);
                button_board[row][col].setFocusable(false);
                button_board[row][col].setMargin(new Insets(0, 0, 0, 0));
                gridPanel.add(button_board[row][col]);
            }
        }
        add(gridPanel,BorderLayout.CENTER);
        update();
        setVisible(true);
    }

    public void update(){
        PuzzlePiece[][] boardState = board.contents();


        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                PuzzlePiece piece = boardState[row][col];
                if (piece == null) {
                    button_board[row][col].setText("");
                    button_board[row][col].setEnabled(false);
                } else {
                    button_board[row][col].setText(String.valueOf(piece.faceValue()));
                    button_board[row][col].setFont(font);
                    button_board[row][col].setEnabled(true);
                }
            }
        }

    }

    //if the inital shown board is the same as solved shuffle board than write done on the blank piece
    public void finish(){
        if (board.gameOver()){
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    if (board.getPuzzlePiece(row,col)==null){
                        button_board[row][col].setText("Done");
                    }else{
                        button_board[row][col].setEnabled(false);
                    }
                }
            }
        }
    }
}
