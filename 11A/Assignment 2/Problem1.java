// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #2, Problem #1, Wednesday, September 25, 2013
// This program reads out a four-digit number as an integer, and then displays it, one digit per line. The four digit number is entered by the user.
// There are no known bugs.

// Need to import library for scanner object.
import java.util.*;

public class Problem1 {
  public static void main(String[] args) {

      // Creates scanner object that reads user input from terminal.
      Scanner console = new Scanner(System.in);

      // User input
      System.out.print("Type in a four digit number: ");
      int four = console.nextInt();

      // Calculations for the numbers.
      int firstNumber = four / 1000;
      int secondNumber = (four % 1000) / 100;
      int thirdNumber = (four % 100) / 10;
      int fourthNumber = four % 10;

      // Prints out numbers.
      System.out.println(firstNumber);
      System.out.println(secondNumber);
      System.out.println(thirdNumber);
      System.out.println(fourthNumber);
  }
}