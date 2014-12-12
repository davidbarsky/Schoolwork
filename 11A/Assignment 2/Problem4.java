// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #2, Problem #4, Friday, September 27, 2013
// This program calculates the amount of money needed to be reimbursed after driving.
// There are no known bugs.

// Imports library for scanner object.
import java.util.*;

public class Problem4 {
  public static void main(String[] args) {

    // Creates scanner object
    Scanner console = new Scanner(System.in);

    System.out.println("MILEAGE REIMBURSEMENT CALCULATOR");

    // Reads beginning mileage.
    System.out.println("Enter beginning odometer reading:");
    double beginningOdo = console.nextDouble();

    // Reads ending mileage.
    System.out.println("Enter ending odometer reading:");
    double endingOdo = console.nextDouble();

    // Finds the difference traveled.
    double changedOdo = endingOdo - beginningOdo;

    // Find how much should be reimbursed
    double reimbursement = changedOdo * .35;

    // Prints out money return.
    System.out.printf("You have traveled %.2f miles. At $.35 per mile,\n", changedOdo);
    System.out.printf("Your reimbursement is $%.2f \n", reimbursement);
  }
}