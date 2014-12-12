// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #3, Problem #1, October 13, 2013
// This program transforms text to pig latin.
// There are no known bugs.

// Need to import library for scanner object.
import java.util.*;

public class Problem1 {
  public static void main(String[] args) {

    // Creates scanner object.
    Scanner console = new Scanner(System.in);

    // Get user's information
    System.out.println("Enter your first name.");
    String firstName = console.next();
    System.out.println("Enter your last name.");
    String lastName = console.next();

    // Prints out user name.
    String firstFinal = pigFirst(firstName);
    String lastFinal = pigLast(lastName);
    System.out.println(firstFinal + " " + lastFinal);

  }

  // Performs text transformation of the first name to Pig Latin.
  public static String pigFirst (String firstName) {
    // Converts to lower case.
    String lowerFirstName = firstName.toLowerCase();

    // Lowercase name will have have first (ID: 1) character truncated. That character will remain suspended in memory.
    String charID1 = lowerFirstName.substring(0,1);

    // Rest of lowerFirstName is assigned to nameRest1.
    String nameRest1 = firstName.substring(1);

    // New first character (ID 2) is also selected, and remains in memory.
    String charID2 = nameRest1.substring(0,1);

    String nameRest2 = nameRest1.substring(1);

    // Character with ID #2 turned uppercase, now ID #3.
    String charID3 = charID2.toUpperCase();

    // Uppercase character (ID #3) is appended to beginning of the string. Character with ID 1 is appended to end, and then "ay" is appended to end.

    String firstFinal = charID3 + nameRest2 + charID1 + "ay";
    return firstFinal;
  }

  // Performs text transformation of the last name to Pig Latin.
  public static String pigLast (String lastName) {
    // Converts to lower case.
    String lowerLastName = lastName.toLowerCase();

    // Lowercase name will have have first (ID: 1) character truncated. That character will remain suspended in memory.
    String charID1 = lowerLastName.substring(0,1);

    // Rest of lowerLastName is assigned to nameRest1.
    String nameRest1 = lastName.substring(1);

    // New first character (ID 2) is also selected, and remains in memory.
    String charID2 = nameRest1.substring(0,1);

    String nameRest2 = nameRest1.substring(1);

    // Character with ID #2 turned uppercase, now ID #3.
    String charID3 = charID2.toUpperCase();

    // Uppercase character (ID #3) is appended to beginning of the string. Character with ID 1 is appended to end, and then "ay" is appended to end.

    String lastFinal = charID3 + nameRest2 + charID1 + "ay";
    return lastFinal;
  }
}