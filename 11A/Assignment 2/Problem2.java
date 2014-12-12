// David Barsky
// dbarsky@brandeis.edu
// COSI 11A, Fall 2013, Section 2
// Programming Assignment #2, Problem #2, Thursday, September 25, 2013
// This program converts degrees between Fahrenheit and Celsius.
// There are no known bugs.

// Need to import library for scanner object.
import java.util.*;

public class Problem2 {
  public static void main(String[] args) {

    // Creates scanner object
    Scanner console = new Scanner(System.in);

    // Asks user for temperature
    System.out.println("What is the current temperature, in Fahrenheit?");
    int temperatureF = console.nextInt();

    // Casts as double, and multiplies by 10
    double temperatureC = (5*(double)(temperatureF - 32)/9) * 10;

    // TemperatureReal is cast as an integer, so it'll be a 3 digit integer.
    int temperatureReal= (int)temperatureC;

    // Divides the integer by 10 and recasts it as a double so it'll have one decimal place.
    double temperatureCalc = (double)temperatureReal / 10;

    // Prints out results.
    System.out.println("You've put in " + temperatureF + ". The Celsius temperature is " + temperatureCalc + ".");
  }
}