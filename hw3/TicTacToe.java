/*
	Homework #3
	Due Date: 2/24/2019
	Names: Brett Barinaga
*/

// <Java Libraries>
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
// </Java Libraries>

// <Custom Classes>
// </Custom Classes>


/*
  Button layout in
  reference to buttons and lables arrays:
  0 1 2
  3 4 5
  6 7 8
*/

public class TicTacToe extends JFrame {
  private final int WINDOW_WIDTH = 500; // Window width
  private final int WINDOW_HEIGHT = 500; // Window height

  private JPanel outerPanel;

  private JPanel mainPanel;

  private JPanel topPanel;
  private PlayerInfo player1Info;
  private PlayerInfo player2Info;

  private JPanel gridPanel;
  private JButton[] buttons;
  private JLabel imageLabel;

  private JPanel bottomPanel;
  private JButton newGame;
  private JButton reset;
  private JButton exit;

  private JLabel bottomLabel;

  private int[] gameGrid;




  boolean turn = true; // player 1 is true, player 2 is false

  public TicTacToe(int player1wins, int player2wins, String player1name, String player2name) {
    setTitle("Tic Tac Toe");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);


    gameGrid = new int[9];
    for (int i = 0; i < 9; i++) {
      gameGrid[i] = 0;
    }

    outerPanel = new JPanel();
    outerPanel.setLayout(new BorderLayout());

    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // <topPanel>
    topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 7));

    if (player1wins > 0 || player2wins > 0) { // ie if its not a new reseted game
      player1Info = new PlayerInfo(1, player1wins, player2wins, player1name);
      player2Info = new PlayerInfo(2, player2wins, player1wins, player2name);
    } else {
      player1Info = new PlayerInfo(1, 0, 0, "");
      player2Info = new PlayerInfo(2, 0, 0, "");
    }

    topPanel.add(player1Info);
    topPanel.add(player2Info);
    // </topPanel>

    // <gridPanel>
    gridPanel = new JPanel();
    gridPanel.setLayout(new GridLayout(3,3));
    buttons = new JButton[9];
    for (int i = 0; i < 9; i++) {
       buttons[i] = new JButton();
       buttons[i].addActionListener(new ButtonListener());
       buttons[i].setEnabled(false);
       gridPanel.add(buttons[i]);
    }
    // </gridPanel>

    // <bottomPanel>
    bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 7));
    newGame = new JButton("New Game");
    newGame.addActionListener(new NewGameListener());
    bottomPanel.add(newGame, BorderLayout.SOUTH);
    reset = new JButton("Reset");
    reset.addActionListener(new ResetListener());
    bottomPanel.add(reset, BorderLayout.SOUTH);
    exit = new JButton("Exit");
    exit.addActionListener(new ExitListener());
    bottomPanel.add(exit, BorderLayout.SOUTH);
    // </bottomPanel>

    mainPanel.add(gridPanel, BorderLayout.CENTER);
    mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    mainPanel.add(topPanel, BorderLayout.NORTH);

    outerPanel.add(mainPanel, BorderLayout.CENTER);

    bottomLabel = new JLabel("Welcome to Tic-Tac-Toe!");
    outerPanel.add(bottomLabel, BorderLayout.SOUTH);

    add(outerPanel);

    setVisible(true);
  }


  public int checkForWin(int player/*1 or 2*/) {
    for (int i = 0; i < 9; i++) {
      if (gameGrid[0] == player && gameGrid[1] == player && gameGrid[2] == player) {
        return player;
      }
      if (gameGrid[3] == player && gameGrid[4] == player && gameGrid[5] == player) {
        return player;
      }
      if (gameGrid[6] == player && gameGrid[7] == player && gameGrid[8] == player) {
        return player;
      }
      if (gameGrid[0] == player && gameGrid[3] == player && gameGrid[6] == player) {
        return player;
      }
      if (gameGrid[1] == player && gameGrid[4] == player && gameGrid[7] == player) {
        return player;
      }
      if (gameGrid[2] == player && gameGrid[5] == player && gameGrid[8] == player) {
        return player;
      }
      if (gameGrid[0] == player && gameGrid[4] == player && gameGrid[8] == player) {
        return player;
      }
      if (gameGrid[2] == player && gameGrid[4] == player && gameGrid[6] == player) {
        return player;
      }
    }
    return 0;
  }

  // Borrowed from this source:https://www.techiedelight.com/find-index-element-array-java/
  public static<T> int find(T[] a, T target) {
  	for (int i = 0; i < a.length; i++)
  		if (target.equals(a[i]))
  			return i;
  	return -1;
  }

  public void enableButtons() {
    for (int i = 0; i < buttons.length; i++) {
      buttons[i].setEnabled(true);
    }
  }

  public void beginGame(PlayerInfo player1, PlayerInfo player2) {
    if (player1Info.playerName == null || player2Info.playerName == null) {
      JOptionPane.showMessageDialog(null, "Please make sure both players have entered their names");
    } else {
      enableButtons();
    }
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      ImageIcon jerry = new ImageIcon("jerry.png");
      ImageIcon newman = new ImageIcon("newman2.jpg");

      JButton button = (JButton)e.getSource();
      int win = 0;

      if (turn) {
        button.setIcon(jerry);
        turn = false;
        gameGrid[find(buttons, button)] = 1;
        bottomLabel.setText(player2Info.playerName + "'s turn.");
        win = checkForWin(1);
      } else {
        button.setIcon(newman);
        turn = true;
        gameGrid[find(buttons, button)] = 2;
        bottomLabel.setText(player1Info.playerName + "'s turn.");
        win = checkForWin(2);
      }

      if (win == 1) {
        JOptionPane.showMessageDialog(null, player1Info.playerName + " Wins!");
        player1Info.playerWins++;
        player2Info.playerLosses++;
        new TicTacToe(player1Info.playerWins, player2Info.playerWins, player1Info.playerName, player2Info.playerName);
        dispose();
      } else if (win == 2) {
        JOptionPane.showMessageDialog(null, player2Info.playerName + " Wins!");
        player2Info.playerWins++;
        player1Info.playerLosses++;
        new TicTacToe(player1Info.playerWins, player2Info.playerWins, player1Info.playerName, player2Info.playerName);
        dispose();
      } else {
        boolean zeroFound = false;
        for (int i = 0; i < buttons.length; i++) {
          if (gameGrid[i] == 0) {
            zeroFound = true;
          }
        }
        if (zeroFound == false) {
          JOptionPane.showMessageDialog(null, "Cat's Game!!!... Resetting board.");
          new TicTacToe(player1Info.playerWins, player2Info.playerWins, player1Info.playerName, player2Info.playerName);
          dispose();
        }
      }
      button.removeActionListener(this);
    }
  }

  private class NewGameListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton pressed = (JButton)e.getSource();
      beginGame(player1Info, player2Info);
    }
  }

  private class ResetListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton pressed = (JButton)e.getSource();
      int result = JOptionPane.showConfirmDialog(null,
      "This will end the game and set the win/loss stats to 0. Are you sure?",null, JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.YES_OPTION) {
        dispose();
        new TicTacToe(0,0,"player1", "player2");
      }
    }
  }

  private class ExitListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton pressed = (JButton)e.getSource();
      int result = JOptionPane.showConfirmDialog(null,
      "This will end the game and close the program. Are you sure?",null, JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.YES_OPTION) {
        System.exit(0);
      }
    }
  }

  public static void main(String[] args) {
    new TicTacToe(0,0,"player1", "player2");
  }

}
