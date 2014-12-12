// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #2, Problem #3, Saturday, September 28, 2013
// This program determines the amount of change to be dispensed from a vending machine.
// There are no known bugs.

// Need to import library for scanner object.
import java.util.*;

public class Problem3 {
  public static void main(String[] args) {

    // Establishes scanner object.
    Scanner console = new Scanner(System.in);

    // Asks user for item price.
    System.out.println("Put in the price of an item (from 25 cents to a dollar, increasing in 5 cent intervals):");
    int price = console.nextInt();

    // Calculates how much money needs to be returned.
    int returnValue = 100 - price;

    // Establishes worth of coins.
    int quarter = 25;
    int dime = 10;
    int nickle = 5;

    // Calculates how many coins are needed to return.
    int quarterReturn = returnValue / quarter; // Returns quarters
    int dimeReturn = (returnValue - (quarterReturn * quarter)) / dime; // From the leftovers of the quarters.
    int nickleReturn = (returnValue - ((dimeReturn * dime) + (quarterReturn * quarter))) / nickle; // Leftovers from the dime return and quarter return.

    // Coin output.
    System.out.printf("You bought an item for %d. Your coin return is:\n", price);
    System.out.printf("%d Quarters\n", quarterReturn);
    System.out.printf("%d Dimes\n", dimeReturn);
    System.out.printf("%d Nickles\n", nickleReturn);
  }
}