/*
	Homework #4
	Due Date: 3/25/2019
	Names: Brett Barinaga
*/

// NOTE: This program works, other than the fact there is an annoying flicker when
// the window repaints. I talked to you in office hours and you said it wasn't
// a big deal, but in the mean time ill try to find a solution.

import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class hw4 extends JFrame {

  private final int WINDOW_WIDTH = 512; // Window width
  private final int WINDOW_HEIGHT = 384; // Window height

  private final int MID_X = WINDOW_WIDTH / 2;
  private final int MID_Y = WINDOW_HEIGHT / 2;

  private int currentX = 0; // Mouse cursor's X position
  private int currentY = 50; // Mouse cursor's Y position

  private paintPanel panel;
  private BufferedImage sky;
  private BufferedImage ground;
  private BufferedImage mtsClose;
  private BufferedImage mtsFar;
  private BufferedImage suns;
  private BufferedImage yellow_suns;

  private int sky_X = 0;
  private int sky_Y = 0;
  private int ground_X = 0;
  private int ground_Y = 0;
  private int mtsClose_X = 0;
  private int mtsClose_Y = 0;
  private int mtsFar_X = 0;
  private int mtsFar_Y = 0;
  private int suns_X = 0;
  private int suns_Y = 0;


  public static void main(String[] args) {
    new hw4();
  }

  public hw4() {
    setTitle("MotionParalax");
    setSize(WINDOW_WIDTH * 2,WINDOW_HEIGHT * 2);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    init();
    createPanel();
    add(panel);

    setResizable(false);
    setVisible(true);
  }


  public void init() {
     // Add a mouse listener and a mouse motion listener.
     addMouseListener(new MyMouseListener());
     addMouseMotionListener(new MyMouseMotionListener());
  }


  public void createPanel() {
    panel = new paintPanel();


    try {
      sky = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_sky.png"));
      ground = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_ground.png"));
      mtsClose = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_mts_close.png"));
      mtsFar = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_mts_far.png"));
      suns = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_suns.png"));

      yellow_suns = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_yellow_suns.png"));

    } catch(IOException e) {
      e.printStackTrace();
    }
  }
  /**
     paint method
     @param g The applet's Graphics object.
  */

  private class MyMouseListener implements MouseListener {
     boolean clicked = false;
     public void mousePressed(MouseEvent e) {

     }

     //
     // The following methods are unused, but still
     // required by the MouseListener interface.
     //

     public void mouseClicked(MouseEvent e) {
       clicked = !clicked;
       try {
         if (!clicked) {
           suns = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_suns.png"));
         } else {
           suns = ImageIO.read(getClass().getResourceAsStream("/hw4_layers_yellow_suns.png"));
         }
       } catch(IOException ee) {
         ee.printStackTrace();
       }
       repaint();

     }

     public void mouseReleased(MouseEvent e) {
     }

     public void mouseEntered(MouseEvent e) {
     }

     public void mouseExited(MouseEvent e) {
     }
  }
  private class MyMouseMotionListener implements MouseMotionListener {
    public void mouseDragged(MouseEvent e) {

    }

    public int moved = 0;
    public void mouseMoved(MouseEvent e) {
      moved++;

      if (moved % 5 == 0) {
        if (e.getX() > MID_X && ground_X > -512) {
          sky_X = sky_X - 1;
          suns_X = suns_X;
          mtsFar_X = mtsFar_X - 2;
          mtsClose_X = mtsClose_X - 4;
          ground_X = ground_X - 6;
        }
        if (ground_X > -512 && ground_X < 0) {
          repaint();
        }
        if (e.getX() < MID_X && ground_X < 0) {
          sky_X = sky_X + 1;
          suns_X = suns_X;
          mtsFar_X = mtsFar_X + 2;
          mtsClose_X = mtsClose_X + 4;
          ground_X = ground_X + 6;
        }
      }
    }
  }

  private class paintPanel extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(sky, sky_X, sky_Y, sky.getWidth() * 2, sky.getHeight() * 2, null );
      g.drawImage(suns, suns_X, suns_Y, suns.getWidth() * 2, suns.getHeight() * 2, null );
      g.drawImage(mtsFar, mtsFar_X, mtsFar_Y, mtsFar.getWidth() * 2, mtsFar.getHeight() * 2, null );
      g.drawImage(mtsClose, mtsClose_X, mtsClose_Y, mtsClose.getWidth() * 2, mtsClose.getHeight() * 2, null );
      g.drawImage(ground, ground_X, ground_Y, ground.getWidth() * 2, ground.getHeight() * 2, null );
      g.drawString("Move mouse on left or right of screen to move, Click anywhere to change sun color", 50, 50);
      g.dispose();
    }
  }




}
