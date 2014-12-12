// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #3, Problem #2, October 13, 2013
// This program calculates a customer's order, and formats it nicely.
// There are no known bugs.

// Need to import library for scanner object.
import java.util.*;

public class Problem2 {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    // Monster input code ahead. Ye who enter here, abandon all hope. Might want to fold this code like an origami swan.

    // Item 1 Input
    System.out.println("Input name of item 1:");
    String item1 = console.nextLine();
    System.out.println("Input quantity of item 1:");
    int quantity1 = console.nextInt();
    System.out.println("Input price of item 1:");
    double price1 = console.nextDouble();
    console.nextLine();

    // Item 2 Input
    System.out.println("Input name of item 2:");
    String item2 = console.nextLine();
    System.out.println("Input quantity of item 2:");
    int quantity2 = console.nextInt();
    System.out.println("Input price of item 2:");
    Double price2 = console.nextDouble();
    console.nextLine();

    // Item 3 Input
    System.out.println("Input name of item 3:");
    String item3 = console.nextLine();
    System.out.println("Input quantity of item 3:");
    int quantity3 = console.nextInt();
    System.out.println("Input price of item 3:");
    double price3 = console.nextDouble();
    console.nextLine();

    System.out.println();
    System.out.println("Your bill:");

    // Table Header
    System.out.printf("%-15s", "Item");
    System.out.printf("%15s", "Quantity");
    System.out.printf("%15s", "Price");
    System.out.printf("%15s", "Total\n");

    // First Data Row
    System.out.printf("%-15s", item1);
    System.out.printf("%15s", quantity1);
    System.out.printf("%15s", price1);
    System.out.printf("%15s", subtotal1(quantity1, price1) + "\n");

    // Second Data Row
    System.out.printf("%-15s", item2);
    System.out.printf("%15s", quantity2);
    System.out.printf("%15s", price2);
    System.out.printf("%15s", subtotal2(quantity2, price2) + "\n");

    // Third Data Row
    System.out.printf("%-15s", item3);
    System.out.printf("%15s", quantity3);
    System.out.printf("%15s", price3);
    System.out.printf("%15s", subtotal3(quantity3, price3) + "\n");

    // Space between item list
    System.out.println("");

    // Subtotal
    System.out.printf("%-15s", "Subtotal");
    System.out.printf("%45s", subtotal1(quantity1, price1) + subtotal2(quantity2, price2) + subtotal3(quantity3, price3) + "\n");

    // Prints out sales tax
    System.out.printf("%-15s", "6.25% sale tax");
    System.out.printf("%44.4s", taxTotal(quantity1, price1, quantity2, price2, quantity3, price3));

    System.out.println("");

    // Prints out total
    System.out.printf("%-15s", "Total");
    System.out.printf("%44.4s", Total(quantity1, price1, quantity2, price2, quantity3, price3));

  }

  // These methods are separate because I couldn't figure out, based off what was done in class, how to return separate methods.

  // Calculates prices for item 1.
  public static double subtotal1 (int quantity1, double price1) {

    // Price for item 1
    double totalFinal1 = quantity1 * price1;
    return totalFinal1;
  }

  // Calculates prices for item 2.
  public static double subtotal2 (int quantity2, double price2) {

    // Price for item 2
    double totalFinal2 = quantity2 * price2;
    return totalFinal2;
  }

  // Calculates prices for item 3.
  public static double subtotal3 (int quantity3, double price3) {

    // Price for item 3
    double totalFinal3 = quantity3 * price3;
    return totalFinal3;
  }

  // Calculates tax total
  public static double taxTotal (int quantity1, double price1, int quantity2, double price2, int quantity3, double price3) {

    double tax = 1.0625;
    double taxedtotal = tax * ((quantity1 + price1) + (quantity2 + price2) + (quantity3 + price3));
    return taxedtotal;
  }

  // Calculates total
  public static double Total (int quantity1, double price1, int quantity2, double price2, int quantity3, double price3) {

    double tax = 1.0625;
    double total = tax * (quantity1 + price1 + quantity2 + price2 + quantity3 + price3);
    return total;
  }
}