import java.util.*;

public class Problem3 {
  public static void main(String[] args) {
    // Sets up scanner object.
    Scanner console = new Scanner(System.in);

    // Asks for x coordinate.
    System.out.println("Please enter the x-coordinate.");
    double x = console.nextDouble();

    // Asks for y coordinate.
    System.out.println("Please enter the y-coordinate.");
    double y = console.nextDouble();

    // Calls method
    quadrant(x, y);
  }

  // Evaluates location of quadrants.
  public static void quadrant(double x, double y) {
    // I chose this continuous if structure because there are a total of six possible paths. Other structures are optimized for 0, 1, or 0 or 1 paths.
    if ((x > 0) && (y > 0)) {
      System.out.println("(" + x + ", " + y + ")" + " is in quadrant 1.");
    }
    if ((x < 0) && (y > 0)) {
      System.out.println("(" + x + ", " + y + ")" + " is in quadrant 2.");
    }
    if ((x < 0) && (y < 0)) {
      System.out.println("(" + x + ", " + y + ")" + " is in quadrant 3.");
    }
    if ((x > 0) && (y > 0)) {
      System.out.println("(" + x + ", " + y + ")" + " is in quadrant 4.");
    }
    if (x == 0) {
      System.out.println("(" + x + ", " + y + ")" + " is on the y-axis.");
    }
    if (y == 0) {
      System.out.println("(" + x + ", " + y + ")" + " is on the x-axis.");
    }
  }
}