 // import statemetns

import java.util.*;
import java.io.*;

public class WarmUp {
  public static void main(String[] args) {

    ArrayList<Integer> arrayList = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();

    test(arrayList);
    test(linkedList);
  }

  public static void test(List<Integer> list) {

    // timer start
    long addl1 = System.currentTimeMillis();

    // adder
    for (int i = 0; i < 2000000; i++) {
      list.add(i);
    }
    // timer end
    long addl2 = System.currentTimeMillis();

    // timer start
    long removel1 = System.currentTimeMillis();

    for (int i = 0; i < 100000; i++) {
      list.remove(i);
    }

    long removel2 = System.currentTimeMillis();

    System.out.println("Time elapsed to add: "  + ((addl2 - addl1)) + " milliseconds.");
    System.out.println("Time elapsed to remove: "  + ((removel2 - removel1)) + " milliseconds.");

  }
}