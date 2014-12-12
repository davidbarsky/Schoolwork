// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #3, Problem #5, October 13, 2013
// This program outputs a Fibonacci sequence.
// There are no known bugs.
import java.util.*;

public class Problem5 {
  public static void main(String[] args) {
    // Creates scanner object.
    Scanner console = new Scanner(System.in);

    // User prompt.
    System.out.println("Please enter a number - it will go to the nth digit of the Fibonacci sequence.");

    // Goes to the nth digit of the Fibonacci sequence.
    int n = console.nextInt();

    Fibonacci(n);
  }

  public static void Fibonacci (int n) {
    int first = 0;
    int second = 1;

    for (int i = 1; i <= n; i++) {
      System.out.println(first + " ");
      first = first + second;
      second = first - second;
    }

    System.out.println();
  }
}