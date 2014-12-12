import java.util.*;

public class Problem5 {
  public static void main(String[] args) {

    // Sets up scanner system
    Scanner console = new Scanner(System.in);

    // Ask user for phrase that will be later assigned
    System.out.print("Please enter a phrase:");
    String original = console.nextLine();

    // Calls method and prints out reversed string
    reverse(original);
  }

  public static void reverse (String original) {

    // gets length of string - used for the loop later on.
    int phraseLength = original.length();

    // Setting reversed to a empty string prevents the original string being added to the reversed one.
    String reversed = "";

    // Reveres string
    for ( int i = phraseLength - 1 ; i >= 0 ; i-- ) {
      reversed = reversed + original.charAt(i);
    }

    // Prints out final result
    System.out.println(reversed);
  }
}