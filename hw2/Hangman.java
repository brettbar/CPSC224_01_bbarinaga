import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;

public class Hangman {
  public static void main(String[] args) {
    int choice = 0;
    List<String> gameList;
    String word;
    while (choice != 3) {
      choice = menu();
      if (choice == 1) {
        gameList = generateList();
        word = chooseWord(gameList);
      } else if (choice == 2) {

      }

    }
  }
  public static int menu() {
    String input = JOptionPane.showInputDialog("Enter your choice:\n1. Play game from a randomly chosen word in a list\n2. Play game from a word entered by another user\n3. Exit Game");
    int choice = 0;

    choice = Integer.parseInt(input);
    if (choice != 1 && choice != 2 && choice != 3) {
      JOptionPane.showMessageDialog(null, "Invalid input");
      return 3;
    }
    return choice;
  }
  public static String chooseWord(List<String> words) {
    Random rand = new Random();
    int n = rand.nextInt(words.size());
    return words.get(n);
  }

  // help from here https://stackoverflow.com/questions/18551251/how-to-open-a-text-file
  public static List<String> generateList() {
    List<String> myList = new ArrayList<>();
    String line;
    BufferedReader in;
    try {
      int index = 0;
      in = new BufferedReader(new FileReader("words.txt"));
      line = in.readLine();
      myList.add(index, line);
      while(line != null) {
        line = in.readLine();
        if (line == null)
          break;
        myList.add(++index, line);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Something didn't work fam");
    }
    return myList;
  }




}
