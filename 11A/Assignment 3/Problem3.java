// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #3, Problem #3, October 13, 2013
// This program prints exponents.
// There are no known bugs.

import java.util.*;

public  class Problem3 {
  public static void main(String[] args) {
    // Sets up scanner system.
    Scanner console = new Scanner(System.in);

    // User input
    System.out.print("Please enter a number: ");
    double exponent = console.nextInt();

    for (int i = 0; i <= exponent; i++) {
      System.out.println(exponentCalc(i));
    }
  }

  // Calculates result of exponent. There are no integer exponentials in Java, only doubles.
  public static double exponentCalc (double exponent) {
    double result = Math.pow(2, exponent);
    return result;
  }
}