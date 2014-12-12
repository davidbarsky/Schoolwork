// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #3, Problem #4, October 13, 2013
// This program outputs the result of a factorial.
// There are no known bugs.

import java.util.*;

public class Problem4 {
  // Main Method. Prints out results of methods below.
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    // Asks user for
    System.out.println("Please enter a number: ");
    int n = console.nextInt();

    for (int i = 1; i <= n; ++i) {
      System.out.println(i + "! = " + factorial(i));
    }
  }

  public static int factorial (int n) {
    int f = 1;
    for (int i = 1; i <= n; ++i) {
      f *= i;
    }
    return f;
  }
}