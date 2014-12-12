import java.util.*;

public class Problem2 {
  public static void main(String[] args) {
    // Sets up scanner object.
    Scanner console = new Scanner(System.in);

    // Asks user for input.
    System.out.print("Please enter a positive integer: ");
    int num = console.nextInt();

    // Validates that the number is greater than one.
    if (num < 1) {
      System.out.println("Error! You didn't enter a positive integer!");
    } else {
      one(num);
    }
  }

  public static void one (int num) {

    // Sets up a counter for how many iterations are performed
    int tries = 0;

    // Prints out initial value
    System.out.println("Initial value is: " + num);
    // Iterates number
    for (; num > 1;) { // No need for an iterator.

      // This pattern was chosen because there more than two paths this can take.
      if (num % 2 == 0) { // If even
        num = num / 2;
      }
      else { // If odd
        num = (num * 3) + 1;
      }

      tries++;
      System.out.println("Next value is: " + num);
    }
    System.out.println("Final value is: " + num);
    System.out.println("Number of operations performed: " + tries);
  }
}