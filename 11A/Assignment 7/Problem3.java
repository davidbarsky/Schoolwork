// David Barsky, dbarsky@brandeis.edu
// Assigngment 7, Problem 3
// This program indents brackets.
// Bugs: none known

import java.io.*;
import java.util.*;

public class Problem3 {
  public static void main(String[] args) throws FileNotFoundException {

    // User interaction declerations
    Scanner console = new Scanner(System.in);

    // Gets information from user. I re
    System.out.println("Please enter a file:");
    String name = console.next();

    // file object declarations
    File f = new File(name);
    Scanner input = new Scanner(f);

    // Method calls
    indenter(f, name);
  }

  public static void indenter(File f, String name) throws FileNotFoundException {
    // Input object declaration
    Scanner input = new Scanner(f);

    // PrintStream object declarations
    PrintStream out = new PrintStream(new File(name + "_edited.java"));

    int count = 0;
    while (input.hasNextLine()) {
      String line = input.nextLine();

      // Indenter
      if (line.contains("{")) {
        for (int i = 1; i <= count; i++) {
          out.print(" ");
        }

        out.print(line);
        out.println();
        count = count + 4;
      }

      // Dedenter
      else if (line.contains("}")) {
        // Moved before for loop to ensure the closing brackets end up on the same starting line as the openign ones
        count = count - 4;

        for (int i = 1; i <= count; i++) {
          out.print(" ");
        }

        out.print(line);
        out.println();
      }

      // Line indenter
      else {
        for (int i = 1; i <= count; i++) {
          out.print(" ");
        }

        out.println(line);
      }
    }
  }
}