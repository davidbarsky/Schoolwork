// David Barsky, dbarsky@brandeis.edu
// Assignment 7, Problem 4
// This program lets you search through a name file and find out the popularity of name during the 20th century
// Bugs: none known

// Import declarations
import java.util.*;
import java.io.*;

public class Problem4 {
  public static void main(String[] args) throws FileNotFoundException{
    // Console declaration
    Scanner console = new Scanner(System.in);

    // User interaction
    System.out.println("Please enter name to search the Social Security Database:");
    String name = console.next();

    // Sanitizes input
    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();

    // Method Call
    search(name);
  }

  public static void search(String name) throws FileNotFoundException {
    // file object declaration
    File f = new File("names.txt");
    Scanner input = new Scanner(f);

    // First year. Increases every 10 for the census. Set below to allow to avoid
    int year = 1890;

    while (input.hasNextLine()) {
      while (input.hasNext()) {

        // Name that's being searched for
        String token = input.next();

        if (token.equals(name)) {
          System.out.println("Here's the data on the popularity of the name" + name + ":");
          while (input.hasNextInt()) {

            // Stores data as the year
            int tokenPop = input.nextInt();

            year = year + 10;

            System.out.println(year + ": " + tokenPop);
          } // ending
        } // still going
      } // wow such brackets
    } // heavens hurry up already
  } // omg how is this still going
} // finally nbd