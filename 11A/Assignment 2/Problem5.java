// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #5, Problem #5, Wednesday, September 25, 2013
// This program converts a binary number to a decimal, reading a the binary number as a string.
// There are no known bugs.

// Need to import library for scanner object.
import java.util.*;

public class Problem5 {
  public static void main(String[] args) {

    // Creates scanner object
    Scanner console = new Scanner(System.in);

    // Asks user for binary number as a string
    System.out.println("What's the binary number you want to convert?");
    String num = console.next();

    // Converts from the string to an integer. Because ASCII, 48 had to be subtracted from from each converted string, as the decimal value of 0 in ASCII is 48, and every decimal number above that is incremented by one.
    int firstNum = num.charAt(0) - 48;
    int secondNum = num.charAt(1) - 48;
    int thirdNum = num.charAt(2) - 48;
    int fourthNum = num.charAt(3) - 48;

    // Calculates decimal number.
    int calcDecimal = firstNum * (2 * 2 * 2 ) + secondNum * (2 * 2) + thirdNum * 2 + fourthNum;

    // Prints out calculated decimal number. Avoided placing line 28 into the printout statement for visual clarity.
    System.out.println(calcDecimal);
  }
}