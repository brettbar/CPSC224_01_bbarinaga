/***************
Inclass Assignment 1
Due Date: 1/26/2019
Names: Brett Barinaga
********************/
// Im sorry I forgot to submit this. thank you
// for accepting this
import java.io.*;
import java.awt.*;
import java.util.*;

public class ICA1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean done = false;
    int choice;
    int meters;
    while (!done) {
      System.out.print("Enter a distance in meters: ");
      meters = input.nextInt();
      menu();
      choice = input.nextInt();
      if (choice == 1) {
        showKilometers(meters);
      } else if (choice == 2) {
        showInches(meters);
      } else if (choice == 3) {
        showFeet(meters);
      } else if (choice == 4) {
        done = true;
      } else {
        System.out.print("Error, invalid input");
      }
    }
  }

  public static void showKilometers(int numMeters) {
    System.out.println(numMeters + " meters is " + numMeters * 0.001 + " kilometers.");
  }

  public static void showInches(int numMeters) {
    System.out.println(numMeters + " meters is " + numMeters * 39.37 + " inches.");
  }

  public static void showFeet(int numMeters) {
    System.out.println(numMeters + " meters is " + numMeters * 3.28 + " feet.");
  }

  public static void menu() {
    System.out.println("1. Convert to kilometers");
    System.out.println("2. Convert to inches");
    System.out.println("3. Convert to feet");
    System.out.println("4. Quit the program");
    System.out.println();
    System.out.print("Enter your choice: ");

  }

}
