// Assigment 6
// Problem 2
// David Barsky, barskydavid@gmail.com
// Write a program that multiplies two matrices, one of dimensions a × b and the other of dimension x × y, to form a matrix a × y. The user provides the matrices.
// Considered array decleration in a seperate method, but that would make variables confusing.

// Imports libraries
import java.util.*;
import java.lang.Math.*;

public class Problem2 {
  public static void main(String[] args) {

    // Object Decleration
    Scanner console = new Scanner(System.in);

    // Following is for arrayA
    System.out.println("This is for array A.");

    // Amount of rows
    System.out.println("Enter the number of rows:");
    int a = console.nextInt();

    // Amount of columns
    System.out.println("Enter the amount of columns:");
    int b = console.nextInt();

    // Declares array
    int[][] arrayA = new int[a][b];

    // Fills array A
    System.out.println("Enter the members of the array, seperated by a space.");

    for (int i = 0; i < arrayA.length; i++) {
      for (int j = 0; j < arrayA[0].length; j++) {
        arrayA[i][j] = console.nextInt();
      }
    }

    // Makes data entry more legible.
    System.out.println();

    // Following is for ArrayB
    System.out.println("This is for array B.");

    // Amount of rows
    System.out.println("Enter the number of rows:");
    int x = console.nextInt();

    // Amount of columns
    System.out.println("Enter the amount of columns:");
    int y = console.nextInt();

    // Declares array
    int[][] arrayB = new int[x][y];

    // Fills array b
    System.out.println("Enter the members of the array, seperated by a space.");

    for (int i = 0; i < arrayB.length; i++) {
      for (int j = 0; j < arrayB[0].length; j++) {
        arrayB[i][j] = console.nextInt();
      }
    }

    // All array declarations are done in main method for organization. arrayC is therefore declared
    int[][] arrayC = new int[a][y];

    multiplier(a, y, x, arrayA, arrayB, arrayC);

    // Prints out final array
    System.out.println(Arrays.deepToString(arrayC));
  }

  public static void multiplier(int a, int y, int x, int[][] arrayA, int[][] arrayB, int[][] arrayC) {
    for (int i = 0; i < a; ++i) {
      for (int j = 0; j < y; ++j) {
        for (int k = 0; k < x; ++k) {
          arrayC[i][k] += arrayA[i][k] * arrayB[k][j];
        }
      }
    }
  }
}