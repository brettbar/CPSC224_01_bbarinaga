/***************
Inclass Assignment 3
Due Date: 2/15/2019
Names: Brett Barinaga
********************/

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;


public class LatinTranslator extends JFrame {
  private final int WINDOW_WIDTH = 400; // Window width
  private final int WINDOW_HEIGHT = 300; // Window height
  private JPanel panel;
  private JButton button1;
  private JButton button2;
  private JButton button3;
  private JLabel label;

  public LatinTranslator() {
    setTitle("Latin Translator");

    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button1 = new JButton("SINISTER");
    button2 = new JButton("DEXTER");
    button3 = new JButton("MEDIUM");

    label = new JLabel("English");


    button1.addActionListener(new ButtonListener());
    button2.addActionListener(new ButtonListener());
    button3.addActionListener(new ButtonListener());

    panel = new JPanel();

    panel.setLayout(new BorderLayout());

    panel.add(label = new JLabel("English"), BorderLayout.SOUTH);


    panel.add(button1, BorderLayout.WEST);
    panel.add(button2, BorderLayout.EAST);
    panel.add(button3, BorderLayout.CENTER);

    add(panel);

    setVisible(true);
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String actionCommand = e.getActionCommand();
      if (actionCommand.equals("SINISTER")) {
        label.setText("Left");
      }
      else if (actionCommand.equals("DEXTER")) {
        label.setText("Right");
      }
      else if (actionCommand.equals("MEDIUM")) {
        label.setText("Center");
      }
    }
  }

  public static void main(String[] args) {
    new LatinTranslator();
  }
}
