import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMenu().setVisible(true);  // Show the game menu window
            }
        });
    }
}

/*
TODO FX:1. Solvability                                                      DONE
        2. Arrange ranking
        3. Leaderboard kinda weird - try to use JPanel instead of JTextArea
        4. After done button change to "New Game"
        5. Back to "Main Menu" button after Done game
        6. Leaderboard pane invoked after game end

TODO UI:1. Leaderboard: (timer not shown);   problem: this.timer > null     DONE
        2. Button press --> timer go, done --> timer stop && reset timer    DONE
        3. Put leaderboard inside JFrame;                                   DONE
        4. Leaderboard pane invoked after leaderboard selected              DONE
        5. Leaderboard ui:  1.      Player1         00:00                   DONE
                            2.      Player2         01:10
        6.

TODO BUG FIX:   1. Player can click tiles before start game                 DEBUGGING PROCESS (DONT TERMINATE YET)

*/