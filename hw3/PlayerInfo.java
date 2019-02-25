import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class PlayerInfo extends JPanel {
  private JTextField name;
  private JTextField wins;
  private JTextField losses;
  private JLabel nameLabel;
  private JLabel winsLabel;
  private JLabel lossesLabel;

  public String playerName;
  public int playerWins;
  public int playerLosses;


  public PlayerInfo (int playerNumber, int pWins, int pLosses, String pName) {
    setLayout(new GridLayout(3, 2));

    playerName = pName;
    playerWins = pWins;
    playerLosses = pLosses;


    name = new JTextField(8);
    if (pName.equals("")) {
      name.setEditable(true);
      name.addActionListener(new EnterListener());
    } else {
      name.setText(pName);
      name.setEditable(false);
    }

    wins = new JTextField(8);
    wins.setEditable(false);
    wins.setText(playerWins + "");

    losses = new JTextField(8);
    losses.setEditable(false);
    losses.setText(playerLosses + "");

    if (playerNumber == 1)
      setBorder(BorderFactory.createTitledBorder("Player 1: (Jerry)"));
    else
      setBorder(BorderFactory.createTitledBorder("Player 2: (Newman)"));

    nameLabel = new JLabel("Name: ");
    winsLabel = new JLabel("Wins: ");
    lossesLabel = new JLabel("Losses: ");

    add(nameLabel);
    add(name);
    add(winsLabel);
    add(wins);
    add(lossesLabel);
    add(losses);
  }

  private class EnterListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      playerName = name.getText();
      name.setEditable(false);
    }
  }


}
