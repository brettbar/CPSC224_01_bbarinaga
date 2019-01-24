import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class class_1_22 {
  public static void main (String args[]) throws Exception{

  }
  public static void secondBreakfast() {
    JOptionPane.showMessageDialog(null, "We've had one yes,");
    JOptionPane.showMessageDialog(null, "But what about second message window?");
  }
  public static void printMessage() {
    JOptionPane.showMessageDialog(null, "Greetings Earthling.");
    int num;
    String input;
    input = JOptionPane.showInputDialog("Enter a number.");
    num = Integer.parseInt(input);
    JOptionPane.showMessageDialog(null, num);
  }
  public static void faramirsQuality() throws Exception {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
         FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
     long start = System.currentTimeMillis();
     for (int i = 0; i < 1000000; i++) {
       out.write("Faramir, Captain of Gondor's Quality: ");
       out.write(String.valueOf(i));
       out.write('\n');
     }
     out.flush();
     System.err.println("Loop time: " +
       (System.currentTimeMillis() - start));
  }
  public static void ended() {
    int x = 10;
    while (x > 0) {
      JOptionPane.showMessageDialog(null, "MY LINE HAS ENDED!!!");
      x--;
    }
  }
}
