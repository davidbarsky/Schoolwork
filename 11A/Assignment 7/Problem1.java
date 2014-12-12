// David Barsky, dbarsky@brandeis.edu
// Assigngment 7, Problem 1
// This program that counts the number of words, lines, and total characters (not including whitespace) in a paper, assuming that consecutive words are separated either by spaces or end-of-line characters
// Bugs: none known

import java.io.*;     // For file
import java.util.*;   // For scanner

public class Problem1 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner console = new Scanner(System.in);

    System.out.println("Please enter a file to be counted:");
    String name = console.next();

    // Sets up scanner object and gets object
    File f = new File(name);
    Scanner input = new Scanner(f);

    // Word Count Method Call
    System.out.println("There are " + wordCount(f) + " words.");

    // Line Count Method Call
    System.out.println("There are " + lineCount(f) + " lines.");

    // Character Count (No whitespace)
    System.out.println("There are " + charCount(f) + " characters.");
  }

  public static int wordCount(File f) throws FileNotFoundException {
    Scanner input = new Scanner(f);
    int count = 0;
    // Counts words
    while (input.hasNext()) {
      String word = input.next();
      count++;
    }
    return count;
  }

  public static int lineCount(File f) throws FileNotFoundException {
    Scanner input = new Scanner(f);
    int count = 0;
    // Counts lines
    while (input.hasNextLine()) {
      String line = input.nextLine();
      count++;
    }
    return count;
  }

  public static int charCount(File f) throws FileNotFoundException {
    Scanner input = new Scanner(f);

    // Finds and removes whitespace. Result is then substeacted from charCount.
    int count = 0;
    while (input.hasNextLine()) {
      Scanner line = new Scanner(input.nextLine());
      while(line.hasNext()){
        String token = line.next();
        int tokenLength = token.length();

        // Thankfully, whitespace isn't counted as a token
        count = count + tokenLength;
      }
    }
    return count;
  }
}