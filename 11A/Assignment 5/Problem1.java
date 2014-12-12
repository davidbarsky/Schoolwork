// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013
// Programming Assignment #5, Problem #1
// This program plays guesses numbers
// There are no known bugs.

// "He's an importer."
// "Just imports? No exports?"
// "He's an importer-exporter. Okay?"
import java.util.*;

public class Problem1 {
  public static void main(String[] args) {

    // Explains to user what's gonna go down.
    System.out.println("Think of an integer between 1 and 1000. Don't tell me what it is!");
    System.out.println("I'm going to make guesses of it, and you're going to tell me if I'm too high, too low, or correct.");
    System.out.println("Type in 1 for too high, 2 for too low, and 0 for correct.");

    guesser();
  }

  public static void guesser() {
    // Initializes necessary objects.
    Scanner console = new Scanner(System.in);
    Random rand = new Random();

    // Counter
    int tries = 0;

    // Sets up max and min with dummy values
    int max = 1001; // Exclusive value
    int min = 1; // Inclusive value

    // Generates random number
    int randomNumber = rand.nextInt(1001) + 1;

    // Random number guesser
    int check = 1; // Dummy value to start the loop.
    do {
      // Prints random number
      System.out.println(randomNumber);

      System.out.println("Is that too high, too low, or correct?");
      check = console.nextInt();
      if (check == 1) { // Too high
        max = randomNumber;
        randomNumber = rand.nextInt(max - min) + min;
      } else if (check == 2) { // Too low
        min = randomNumber;
        randomNumber = rand.nextInt(max - min) + min;
      } else {
        System.out.println("Yay! I've guessed the number.");
      }
      tries++;
    } while (check != 0);
    System.out.println("It took me " + tries + " tries to get it right.");
  }
}