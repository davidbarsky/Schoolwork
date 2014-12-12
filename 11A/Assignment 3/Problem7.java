// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #3, Problem #7, October 13, 2013
// This program prints out a grid of numbers.
// There are no known bugs.

import java.util.*;
public class Problem7 {
  public static void main(String[] args) {

    // Scanner object for user input
    Scanner console = new Scanner(System.in);

    // Sets number of rows
    System.out.println("How many rows?");
    int row = console.nextInt();

    // Sets number of columns
    System.out.println("How many columns?");
    int column = console.nextInt();

    // Creates grid
    grid(row, column);
  }

  public static void grid(int row, int column) {
    // Outer loop prints out new lines.
    System.out.println(row);
    for (int i = 1; i <= row; i++) {
      System.out.print(i);

      int temp = i;
      // Prints the numbers in the column
      for (int j = 1; j < column; j++) {
        temp = temp + row;
        System.out.printf(" " + temp);
      }
      System.out.println();
    }
  }
}