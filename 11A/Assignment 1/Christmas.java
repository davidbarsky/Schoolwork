// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #1, Sunday, September 14, 2013
// This program prints out part of the lyrics of "The Twelve Days of Christmas", while testing the programmer's knowledge of print statements and static methods.
// There are no known bugs.

public class Christmas {
  public static void main(String[] args) {
    one();
    two();
    three();
    four();
    five();
    six();
  }

  // The gifts

  public static void pear() {
    System.out.println("a partridge in a pear tree.");
  }

  public static void doves() {
   System.out.println("two turtle doves, and");
  }

  public static void hens() {
    System.out.println("three French hens,");
  }

  public static void birds() {
    System.out.println("four calling birds,");
  }

  public static void rings() {
    System.out.println("five golden rings,");
  }

  public static void geese() {
    System.out.println("six geese a-laying,");
  }

  // A space. Wanted to avoid println statements in the main method, so this was made its own static method.

  public static void space() {
    System.out.println();
  }

  // Day Group. Initially, "my true love sent to me" was a separate method that was called after each day, but that was now put into the day methods.

  public static void one(){
    System.out.println("On the 1st day of \"Xmas\", my true love sent to me");
    pear();
    space();
  }

  public static void two(){
    System.out.println("On the 2nd day of \"Xmas\", my true love sent to me");
    doves();
    pear();
    space();
  }

  public static void three(){
    System.out.println("On the 3rd day of \"Xmas\", my true love sent to me");
    hens();
    doves();
    pear();
    space();
  }

  public static void four(){
    System.out.println("On the 4th day of \"Xmas\", my true love sent to me");
    birds();
    hens();
    doves();
    pear();
    space();
  }

  public static void five(){
    System.out.println("On the 5th day of \"Xmas\", my true love sent to me");
    rings();
    birds();
    hens();
    doves();
    pear();
    space();
  }

  public static void six(){
    System.out.println("On the 6th day of \"Xmas\", my true love sent to me");
    geese();
    rings();
    birds();
    hens();
    doves();
    pear();
    space();
  }
}