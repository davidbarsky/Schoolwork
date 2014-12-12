// David Barsky
// barskydavid@gmail.com
// This program plays rock paper scissors
// There are no known bugs.

import java.util.*;

public class Problem3 {
  public static void main(String[] args) {

    // Initializes necessary objects.
    Scanner console = new Scanner(System.in);

    // Introduces user to the game. Explains what's going to happen. Crappy Doctor Who reference included.
    System.out.println("Welcome to Rock Paper Scissors!");
    System.out.println("There's a couple of ways we could play. I could select my moves at random, or I could use a pattern. If you want the first, type '1'. If you want the second, type '2'.");
    int choice = console.nextInt();

    // Selects method to be used for each user.
    if (choice == 1) {
      randomChoice();
    } else {
      patternChoice();
    }
  }

  // Choices are made randomly.
  public static void randomChoice() {
    // Debugging canary
    System.out.println("You picked choice 1!");

    // Declares variable for computer moves
    String computerMove = "h"; // dummy value

    // Has to be redeclared again. Whoopee.
    Scanner console = new Scanner(System.in);
    Random rand = new Random();

    // Tells user what to do.
    System.out.println("Select one of the following: \n \nRock ('R') \nPaper ('P')\nScissors ('S')");
    String userPlay = console.nextLine();

    // random number generator for user's play.
    int computerInt = rand.nextInt(3) + 1;

    // Converts to a valid move
    if (computerInt == 1) {
      computerMove = "R"; // Rock
    }
    else if (computerInt == 2) {
      computerMove = "P"; // Paper
    }
    else if (computerInt == 3) {
      computerMove = "S"; // Scissors
    }

    // Game logic. No error checking done here.
    if (userPlay.equals(computerMove)) {
      System.out.println("It's a tie!");
    }
    else if (userPlay.equals("R")) {
      if (computerMove.equals("S"))
        System.out.println("Rock beats scissors. You win!");
      else if (computerMove.equals("P"))
        System.out.println("Paper beats rock. You lose!");
    }
    else if (userPlay.equals("P")) {
      if (computerMove.equals("S"))
        System.out.println("Scissor beats paper. You lose!");
      else if (computerMove.equals("R"))
        System.out.println("Paper beats rock. You win!");
    }
    else if (userPlay.equals("S")) {
      if (computerMove.equals("P"))
        System.out.println("Scissor beats paper. You win!");
      else if (computerMove.equals("R"))
        System.out.println("Rock beats scissors. You lose!");
    }
  }

  // Choices are made off a pattern.
  public static void patternChoice() {
    // Debugging canary
    System.out.println("You picked choice 2!");

    // Declares variable for computer moves
    String computerMove = "h"; // dummy value

    // Has to be redeclared again.
    Scanner console = new Scanner(System.in);
    Random rand = new Random();

    // Tells user what to do.
    System.out.println("Select one of the following: \n \nRock ('R') \nPaper ('P')\nScissors ('S')");
    String userPlay = console.nextLine();

    // Game logic - selects randomly from a weighed sample
    String characters = "RRRRRRPPPPSS";

    System.out.println(characters.length);

    // Converts to a valid move
    if (computerInt == 1) {
      computerMove = "R"; // Rock
    }
    else if (computerInt == 2) {
      computerMove = "P"; // Paper
    }
    else if (computerInt == 3) {
      computerMove = "S"; // Scissors
    }

    // Game logic. No error checking done here.
    if (userPlay.equals(computerMove)) {
      System.out.println("It's a tie!");
    }
    else if (userPlay.equals("R")) {
      if (computerMove.equals("S"))
        System.out.println("Rock beats scissors. You win!");
      else if (computerMove.equals("P"))
        System.out.println("Paper beats rock. You lose!");
    }
    else if (userPlay.equals("P")) {
      if (computerMove.equals("S"))
        System.out.println("Scissor beats paper. You lose!");
      else if (computerMove.equals("R"))
        System.out.println("Paper beats rock. You win!");
    }
    else if (userPlay.equals("S")) {
      if (computerMove.equals("P"))
        System.out.println("Scissor beats paper. You win!");
      else if (computerMove.equals("R"))
        System.out.println("Rock beats scissors. You lose!");
    }
  }
}