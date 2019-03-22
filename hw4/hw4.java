import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class hw4 extends JFrame {

  private final int WINDOW_WIDTH = 512; // Window width
  private final int WINDOW_HEIGHT = 384; // Window height
  private JPanel panel;
  private BufferedImage sky;
  private BufferedImage ground;
  private BufferedImage mts_close;
  private BufferedImage mts_far;
  private BufferedImage suns;

  public static void main(String[] args) {
    new hw4();
  }

  public hw4() {
    setTitle("MotionParalax");
    setSize(WINDOW_WIDTH * 2,WINDOW_HEIGHT * 2);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // init();
    createPanel();
    setVisible(true);
  }



  // public void init() {
  //   ImageIcon sky = new ImageIcon("hw4_layers_sky.png");
  //   ImageIcon ground = new ImageIcon("hw4_layers_ground.png");
  //   ImageIcon mts_close = new ImageIcon("hw4_layers_mts_close.png");
  //   ImageIcon mts_far = new ImageIcon("hw4_layers_mts_far.png");
  //   ImageIcon suns = new ImageIcon("hw4_layers_suns.png");
  // }

  public void createPanel() {
    panel = new JPanel();

    try {
      sky = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_sky.png"));
      ground = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_ground.png"));
      mts_close = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_mts_close.png"));
      mts_far = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_mts_far.png"));
      suns = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_suns.png"));

    } catch(IOException e) {
      e.printStackTrace();
    }

    repaint();
  }
  /**
     paint method
     @param g The applet's Graphics object.
  */

  public void paint(Graphics g)
  {
    g.drawImage(sky, 0, 0, sky.getWidth() * 2, sky.getHeight() * 2, null );
    g.drawImage(suns, 0, 50, suns.getWidth() * 2, suns.getHeight() * 2, null );
    g.drawImage(mts_far, 0, 0, mts_far.getWidth() * 2, mts_far.getHeight() * 2, null );
    g.drawImage(mts_close, 0, 0, mts_close.getWidth() * 2, mts_close.getHeight() * 2, null );
    g.drawImage(ground, 0, 0, ground.getWidth() * 2, ground.getHeight() * 2, null );
  }
}