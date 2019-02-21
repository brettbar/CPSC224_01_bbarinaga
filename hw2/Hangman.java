/*
	Homework #2
	Due Date: 2/11
	Names: Brett Barinaga

  This program plays a basic version of 6-strike HANGMAN.
  You can either play from an existing list of words
  or enter a character unique lower case word to have
  another person guess.
*/
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
        playGame(word);

      } else if (choice == 2) {
        word = JOptionPane.showInputDialog("Other person, please enter your (all lower case with unique letters) word for your friend to guess: ");
        playGame(word);
      } else {
        JOptionPane.showMessageDialog(null, "Thanks for playing!");
      }
    }
  }

  // This method handles the actual game being played
  public static void playGame(String theWord) {
    String currentWordProg = new String();
    String alreadyUsed = new String();
    boolean done = false;

    String guess;
    int strikes = 0;
    for (int i = 0; i < theWord.length(); i++) {
      currentWordProg += "-";
    }
    while (!done) {
      if (strikes >= 6) {
        JOptionPane.showMessageDialog(null, "6 Strikes, you lose");
        done = true;
        break;
      }
      guess = JOptionPane.showInputDialog("**HANGMAN**\n***********\n-----------\n" + currentWordProg + "\n-----------\n***********");
      if (Character.isUpperCase(guess.charAt(0))) {
        JOptionPane.showMessageDialog(null, "Please only enter lower case letter");
      }
      else if (alreadyUsed.contains(guess)) {
        JOptionPane.showMessageDialog(null, "That letter has already been guessed");
      }
      else if(theWord.contains(guess.toLowerCase())) {
        int index = theWord.indexOf(guess);
        char[] wordProg = currentWordProg.toCharArray();
        wordProg[index] = guess.charAt(0);
        currentWordProg = String.valueOf(wordProg);
        alreadyUsed += guess;
      }
      else {
        strikes++;
        JOptionPane.showMessageDialog(null, "Current strikes, you lose at 6: " + strikes);
      }
      if (currentWordProg.equals(theWord)) {
        JOptionPane.showMessageDialog(null, "You win!");
        done = true;
        break;
      }
    }
  }

  // This method displays the menu to the user
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
  // This method picks a random word from the preset list of words
  public static String chooseWord(List<String> words) {
    Random rand = new Random();
    int n = rand.nextInt(words.size());
    return words.get(n);
  }

  // help from here https://stackoverflow.com/questions/18551251/how-to-open-a-text-file
  // Opens a file, and creates a list of words from said file
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
