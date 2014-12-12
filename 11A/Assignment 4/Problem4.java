// This program prompts for two people’s birthday (month and day), along with today’s month and day. The program should figure out how many days remain until each user’s birthday and which birthday is sooner.


import java.util.*;

public class Problem4 {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);

    // Establishes current day

    System.out.println("What date is it today (Just the number)?");
    int day = console.nextInt();

    System.out.println("What month is it? (please write a number — no 0 before it)");
    int month = console.nextInt();

    // Establishes person one's birthday

    System.out.println("What day is your birthday?");
    int birthday1 = console.nextInt();

    System.out.println("What month is your birthday?");
    int birthmonth1 = console.nextInt();

    // Establishes person two's birthday

    System.out.println("What day is your birthday?");
    int birthday2 = console.nextInt();

    System.out.println("What month is your birthday?");
    int birthmonth2 = console.nextInt();

    // Prints out dates.

    System.out.println("There are " + (absolutedDate(day, month) - absolutedDate(birthday1, birthmonth1)) + " days left until the first birthday.");

    System.out.println("There are " + (absolutedDate(day, month) - absolutedDate(birthday2, birthmonth2)) + " days left until the second birthday.");

    if (absolutedDate(day, month) - absolutedDate(birthday1, birthmonth1) > absolutedDate(day, month) - absolutedDate(birthday2, birthmonth2)) {
      System.out.println("The first birthday is closer.");
    } else {
      System.out.println("The second birthday is closer.");
    }
  }

  // Calculates absolute date
  public static int absolutedDate(int day, int month) {
    // All elapsed since January 1st.

    // January
    if (month == 1) {
      int actual = 0 + day;
      return actual;
    }

    // Feb
    else if (month == 2) {
      int actual = 31 + day;
      return actual;
    }

    // March
    else if (month == 3) {
      int actual = 59 + day;
      return actual;
    }

    // April
    else if (month == 4 ) {
      int actual = 90 + day;
      return actual;
    }

    // May
    else if (month == 5 ) {
      int actual = 120 + day;
      return actual;
    }

    // June
    else if (month == 6 ) {
      int actual = 151 + day;
      return actual;
    }

    // July
    else if (month == 7) {
      int actual = 181 + day;
      return actual;
    }

    // August
    else if (month == 8) {
      int actual = 212 + day;
      return actual;
    }

    // September
    else if (month == 9) {
      int actual = 243 + day;
      return actual;
    }

    // October
    else if (month == 10) {
      int actual = 273 + day;
      return actual;
    }

    // November
    else if (month == 11) {
      int actual = 304 + day;
      return actual;
    }

    // December
    else {
      int actual = 334 + day;
      return actual;
    }
  }
}