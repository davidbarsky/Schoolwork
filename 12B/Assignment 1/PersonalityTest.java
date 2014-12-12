// David Barsky
// barskydavid@gmail.com
// Assignment One
// Due Friday, January 24

import java.io.*;
import java.util.*;

public class PersonalityTest {
  // handles files input and output
  public static void main(String[] args) throws FileNotFoundException {

    // object declarations
    File f;
    String input;
    Scanner console = new Scanner(System.in);

    // gets name of file to analyse
    do {
      System.out.println("Enter the name of the file to be analysed:");
      input = console.next();
      f = new File(input);
    } while (!f.exists());

    // gets name of output file
    System.out.println("Enter the name of output file.");
    String output = console.next();

    PrintStream out = new PrintStream(new File(output));

    // starts a long, nightmarish chain of method calls. toot toot!
    stringmaker(out, f);
  }

  public static void stringmaker(PrintStream out, File f) throws FileNotFoundException {
    Scanner parser = new Scanner(f);

    // gets names/answer data from strings
    while (parser.hasNext()) {
      String name = parser.nextLine();
      String answers = parser.nextLine();

      // turns uppercase for ease of use
      answers = answers.toUpperCase();

      // first stop. arrived late, as amtrak does
      count(out, name, answers);
    }
  }

  public static void count(PrintStream out, String name, String answers) {

    // array to store the values of A and B
    int[][] answersArray = new int[4][2];

    // declaration
    char current;

    // outer loop goes through groups
    for (int i = 0; i < 10; i++) {
      // inner loop goes for through questions
      for (int j = 0; j < 7; j++) {

        // state tracking
        current = answers.charAt(i * 7 + j);

        // red pill or blue pill ain't 90's references great
        if (current == 'A') {
          answersArray[(j + j % 2)/ 2][0]++;
        } else if (current == 'B') {
          answersArray[(j + j % 2)/ 2][1]++;
        }
      }
    }

    // café car was disappointing as usual
    typographer(out, answersArray, name); // is it bad my method names are puns
  }

  public static void typographer(PrintStream out, int[][] answersArray, String name) {
  // yes

    // b / (b + a) * 100 aka percent
    int[] pct = new int[4];

    // honestly, he's just not my type
    String[] typeA = {"E", "S", "T", "J"};
    String[] typeB = {"I", "N", "F", "P"};

    // gets percent
    for (int i = 0; i < 4; i++) {
      pct[i]=(int) ((double) answersArray[i][1] / (answersArray[i][1] + answersArray[i][0]) * 100);
    }

    // prints out results
    // name
    out.print(name + ":" + "\n");

    // raw data
    for (int i = 0; i < 4; i++) {
      out.print(answersArray[i][0] + "A-" + answersArray[i][1] + "B ");
    }

    out.print("\n");

    // percentage
    out.print("[" + pct[0] + "%, " + pct[1] + "%, " + pct[2] + "%, " + pct[3] + "%] = ");

    // type
    for (int i = 0; i < 4; i++) {
      if (pct[i]>50) {
        out.print(typeB[i]);
      } else if (pct[i]<50) {
        out.print(typeA[i]);
      } else if (pct[i]==50) {
        out.print("X");
      }
    }
    // breathing room
    out.print("\n" + "\n");
  }
}

// go to hell this assignment
// or take just amtrak