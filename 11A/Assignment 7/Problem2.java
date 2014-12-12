// David Barsky, dbarsky@brandeis.edu
// Assigngment 7, Problem 2
// This program diffs files
// Bugs: none known

import java.io.*;
import java.util.*;

public class Problem2 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner console = new Scanner(System.in);

    // User interactions
    System.out.println("Please enter one file:");
    String name1 = console.nextLine();
    System.out.println("Please enter another file:");
    String name2 = console.nextLine();

    // For legibility
    System.out.println();

    // File operations
    File a = new File(name1);
    File b = new File(name2);
    Scanner inputA = new Scanner(a);
    Scanner inputB = new Scanner(b);

    // Method call
    diff(a, b);
  }

  // diffs the two files entered by the user
  public static void diff(File a, File b) throws FileNotFoundException {
    // Redeclaration
    Scanner inputA = new Scanner(a);
    Scanner inputB = new Scanner(b);

    // for keeping track of line position
    int lineCount = 0;
    while (inputA.hasNextLine() && inputA.hasNextLine()) {
      while (inputA.hasNext() && inputB.hasNext()) {

        // For line counters
        lineCount++;

        // For equality
        String lineTokenA = inputA.nextLine();
        String lineTokenB = inputB.nextLine();

        // Prints out differences
        if (!lineTokenA.equals(lineTokenB)) {
          System.out.println("Difference at line" + lineCount + ":");
          System.out.println(lineTokenA);
          System.out.println(lineTokenB);

          // For legibility
          System.out.println();
        }
      }
    }
  }
}