// Assigment 6
// Problem 1
// David Barsky, barskydavid@gmail.com
// This progrma finds information of a set of data.

// Imports required stuff
import java.util.*;
import java.lang.Math.*;

public class Problem1 {
  public static void main(String[] args) {
    // Initialized objects
    Scanner console = new Scanner(System.in);

    // Ask user to import data.
    System.out.println("Please enter the amount of integers.");

    // Declares array, intialized to null
    int array[] = new int[10];

    // Fills array, storing each day's temperature.
    for (int i = 0; i < 10; i++) {
      System.out.println("Number " + (i + 1) + ":");
      array[i] = console.nextInt();
    }

    // Sorts array using bubble sort.
    bubble(array);

    // Calculates Sum
    System.out.println("The sum is: " + sum(array));

    // Calcualtes Max
    System.out.println("The max is: " + max(array));

    // Calcualtes Min
    System.out.println("The min is: " + min(array));

    // Calculates Mean
    System.out.println("The mean is: " + mean(array));

    // Calculates Mode
    System.out.println("The mode is: " + mode(array));

    // Calculates Median
    System.out.println("The median is: " + median(array));

    // Calculates Standard Deviation
    System.out.println("The standard deviation is: " + standardDeviation(array, mean(array)));
  }

  // Sorts array
  public static void bubble (int[] array) {
    int didSwap = 1; // Dummy value to start loop
    int temp = 0;
    while (didSwap == 1) {
      didSwap = 0; // If array is sorted, didSwap will stay 0, ending the loop.
      for (int i = 1; i < array.length; i++) {
        if (array[i - 1] > array[i]) {
          temp = array[i - 1];
          array[i - 1] = array[i];
          array[i] = temp;
          didSwap = 1;
        }
      }
    }
  }

  // Calculates Sum
  public static int sum(int[] array) {
    // Intialization to a dummy value
    int sum = 0;

    // Traveres array, get sum
    for (int i = 0; i < 10; i++) {
      int value = array[i];
      sum = sum + value;
    }
    return sum;
  }

  // Calculates Max
  public static int max(int[] array) {
    // Initilization to a dummy value
    int max = array[0];

    // Traveres array, get max
    for (int i = 0; i <10; i++) {
      if (max < array[i]) {
        max = array[i];
      }
    }
    return max;
  }

  // Calculates Min
  public static int min(int[] array) {
    // Initilization to a dummy value
    int min = array[0];

    // Traveres array, get min
    for (int i = 0; i <10; i++) {
      if (min > array[i]) {
        min = array[i];
      }
    }
    return min;
  }

  // Calculates Mean
  public static int mean(int[] array) {
    // Intialization to a dummy value
    int mean = 0;

    // Traverses array, gets mean
    for (int i = 0; i < 10; i++) {
      int value = array[i];
      mean = mean + value;
    }
    mean = mean/10;
    return mean;
  }

  // Calculates Mode
  public static int mode(int[] array) {
    // modeCount is only used inside the loop. modeValue is returned to outside.
    int modeValue = 0;
    int modeCount = 0;

    // Goes through array. Outer array goes through array.
    for (int i = 0; i < array.length; i++) {
      int count = 0;
      // Loop checks to see count can be increased.
      for (int j = 0; j < array.length; j++) {
        if (array[j] == array[i]) {
          count++;
        }
      }
      // Checks to see if a new mode can be overwritten
      if (count > modeCount) {
        modeCount = count;
        modeValue = array[i];
      }
    }
  return modeValue;
  }

  // Calculates Median
  public static double median(int[] array) {
    // Allows for decimal means.
    double median = (array[4] + array[5])/2;
    return median;
  }

  // Calculates Standard Deviation
  public static double standardDeviation(int[] array, int mean) {
    // Does math operations as per order of operations
    double SD = 0.0;
    // Does sigma calculations
    for (int i = 0; i < array.length; i++) {
      SD = array[i] - mean;
    }
    SD = Math.pow(SD, 2);
    SD = SD/(array.length - 1);
    SD = Math.sqrt(SD);
    return SD;
  }
}