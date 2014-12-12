// David Barsky
// No known bugs

import java.util.*; // for scanner
import java.io.*; // for printsteam

public class Birthday {
  public static void main(String[] args) {
    // console declaration
    Scanner console = new Scanner(System.in);

    System.out.println("What month, day and year were you born?");

    // Fills out console declarations
    int month = console.nextInt();
    int day = console.nextInt();
    int year = console.nextInt();

    // date declaration: allows for all method calls later
    TeacherDate date = new TeacherDate(year, month, day); // represents specific date

    // prints out date person was born
    System.out.print("You were born on " + date.toString());

    // gets day of week
    System.out.print(", which was a " + date.getDayOfWeek() + ". \n");

    if (date.isLeapYear()) {
      System.out.println(year + " was a leap year.");
    }

    // For figuring out current date
    TeacherDate today = new TeacherDate();

    // prints out next birthday
    System.out.println((new StringBuilder()).append("Your next birthday is in ").append(calculateNext(date)).append(" days.").toString());
        checkBirthday(date);

     System.out.println((new StringBuilder()).append("You are ").append(calculateAge(date)).append(" days old.").toString());
  }

  public static int calculateAge(TeacherDate date) {
    // declartion
    TeacherDate today = new TeacherDate();

    // date from
    TeacherDate temp = new TeacherDate(date.getYear(), date.getMonth(), date.getDay());

    // for iteration later
    int age = 0;

    // bastarization of a poor for loop
    for (; !temp.equals(today); temp.nextDay()) {
      age++;
    }

    return age;
  }

  public static int calculateNext(TeacherDate date) {

    // declaration
    TeacherDate today = new TeacherDate();

    // initilaization
    int count = 0;

    if (date.getMonth() > today.getMonth() || date.getMonth() == today.getMonth() && date.getDay() > today.getDay()) {

      for (TeacherDate temp = new TeacherDate(date.getYear(), today.getMonth(), today.getDay()); !temp.equals(date);) {
        temp.nextDay();
        count++;
      }

      return count;
    }

    if (date.getMonth() < today.getMonth() || date.getMonth() == today.getMonth() && date.getDay() < today.getDay()) {
      TeacherDate temp1 = new TeacherDate();
      TeacherDate temp2 = new TeacherDate(today.getYear(), 12, 31);
      TeacherDate temp3 = new TeacherDate(date.getYear(), 1, 1);

      while(!temp1.equals(temp2)) {
        temp1.nextDay();
        count++;
      }

      while(!temp3.equals(date)) {
        temp3.nextDay();
        count++;
      }

    return count;

    } else {
      return 0;
    }
  }

  public static void checkBirthday(TeacherDate date) {

    /// another declations
    TeacherDate today = new TeacherDate();

    // prints brithday if it's today
    if (date.getMonth() == today.getMonth() && date.getDay() == today.getDay())  {
      System.out.print("Happy Birthday!");

      // prints current age
      System.out.println((new StringBuilder()).append("Your current age is ").append(today.getYear() - date.getYear()).toString());
    }
  }
}