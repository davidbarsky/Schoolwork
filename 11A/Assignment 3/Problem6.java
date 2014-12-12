// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #3, Problem #6, October 13, 2013
// This program prints out a pretty pattern.
// There are no known bugs.

public class Problem6 {
  // All print statements are placed into the
  public static void main(String[] args) {
    pattern();
  }

  // All variables are named after what they're printing out. While more verbose, I find it to be more readable. I'm not writing Perl, after all.
  public static void pattern() {
    // Asterisks on left side
    for (int line = 1; line <= 6; line++) {
      for (int asterisk = 1; asterisk <= (-1 * line + 6); asterisk++) {
        System.out.print("*");
      }

      // Spaces after Asterisks
      for (int space = 0; space <= (line - 1); space++) {
        System.out.print(" ");
      }

      // Forward slashes
      for (int slashes = 4; slashes >= (line - 1); slashes--) {
        System.out.print("//");
      }

      // Back slashes
      for (int slashes = 1; slashes <= (line - 1); slashes++) {
        System.out.print("\\\\");
      }

      // Spaces after slashes
      for (int space = 0; space <= (line - 1); space++) {
        System.out.print(" ");
      }

      // Asterisks on left side
      for (int asterisk = 1; asterisk <= (-1 * line + 6 ); asterisk++ ) {
        System.out.print("*");
      }

      // Starts new line
      System.out.println();
    }
  }
}