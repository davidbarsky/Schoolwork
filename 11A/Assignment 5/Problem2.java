// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013
// Programming Assignment #5, Problem #2
// Program plays hangman.
// There are no known bugs.

import java.util.*;

public class Problem2 {
  public static void main(String[] args) {

    // Initializes necessary object.
    Scanner console = new Scanner(System.in);
    Random rand = new Random();

    // Source from which the selector selects from.
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // Max amount of things that can be printed out.
    int alphabetLength = alphabet.length();

    Random randomChar = new Random();

    for (int i = 0; i < 50; i++) {
      // Ain't that print statement a doozy
      System.out.print(alphabet.charAt(randomChar.nextInt(alphabetLength)));
    }
  }
}