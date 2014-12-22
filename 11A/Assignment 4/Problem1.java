// This program calculates and prints the sum of the even integers from 2 to 30, with each integer on its own line.

public class Problem1 {
  public static void main(String[] args) {
    // Calls counter method
    counter();
  }

  public static void counter() {
    // Outside so it can be accessed inside the for loop
    int sum = 0;
    // Made to depend on i
    for (int i = 2; i <= 30; i += 2) {
      sum += i;
      System.out.println(sum);
    }
  }
}
