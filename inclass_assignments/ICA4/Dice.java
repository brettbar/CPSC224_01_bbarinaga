/***************
Inclass Assignment 4
Due Date: 2/21/2019
Names: Brett Barinaga
********************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Dice extends JFrame {
  private JPanel imagePanel;     // To hold the label
  private JPanel buttonPanel;    // To hold a button
  private JLabel imageLabel;     // To show an image
  private JLabel imageLabel2;     // To show an image
  private JButton button;        // To get an image

  public static void main(String[] args) {
    new Dice();
  }

  public Dice() {
    setTitle("Dice Simulator");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new BorderLayout());

    buildImagePanel();
    buildButtonPanel();

    add(imagePanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    pack();
    setVisible(true);

  }
  private void buildImagePanel() {
    imagePanel = new JPanel();

    imageLabel = new JLabel("");
    imageLabel2 = new JLabel("");

    imagePanel.add(imageLabel);
    imagePanel.add(imageLabel2);
  }
  private void buildButtonPanel() {
    buttonPanel = new JPanel();

    button = new JButton("Roll the Dice");

    button.addActionListener(new ButtonListener());

    buttonPanel.add(button);
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Random rand = new Random();
      int choice = rand.nextInt(6) + 1;
      int choice2 = rand.nextInt(6) + 1;
      // Read the image file into an ImageIcon object.
      ImageIcon diceImage1 = new ImageIcon("Die1.png");
      ImageIcon diceImage2 = new ImageIcon("Die2.png");
      ImageIcon diceImage3 = new ImageIcon("Die3.png");
      ImageIcon diceImage4 = new ImageIcon("Die4.png");
      ImageIcon diceImage5 = new ImageIcon("Die5.png");
      ImageIcon diceImage6 = new ImageIcon("Die6.png");

      switch(choice) {
        case 1:
          imageLabel.setIcon(diceImage1);
          break;
        case 2:
          imageLabel.setIcon(diceImage2);
          break;
        case 3:
          imageLabel.setIcon(diceImage3);
          break;
        case 4:
          imageLabel.setIcon(diceImage4);
          break;
        case 5:
          imageLabel.setIcon(diceImage5);
          break;
        case 6:
          imageLabel.setIcon(diceImage6);
          break;
        default:
          imageLabel.setIcon(null);
          break;
      }
      switch(choice2) {
        case 1:
          imageLabel2.setIcon(diceImage1);
          break;
        case 2:
          imageLabel2.setIcon(diceImage2);
          break;
        case 3:
          imageLabel2.setIcon(diceImage3);
          break;
        case 4:
          imageLabel2.setIcon(diceImage4);
          break;
        case 5:
          imageLabel2.setIcon(diceImage5);
          break;
        case 6:
          imageLabel2.setIcon(diceImage6);
          break;
        default:
          imageLabel2.setIcon(null);
          break;
      }
      pack();
    }
  }
}
