import java.io.*;     // For files
import java.util.*;   // for scanner and collections

public class TreasureHunter {

  // main method, harks back to the glory days of 11a
  public static void main(String[] args) throws FileNotFoundException {
    for (int i = 1; i <= 8; i++) {
      File f = new File("tmap" + i + ".txt");

      System.out.println("\nTreasure Map: " + i);
      goForTreasureHunt(f);
    }
  }

  // This method takes in a file, and uses that file to go on the treasure hunt in that file, and prints out the output as shown above.
  public static void goForTreasureHunt(File f) throws FileNotFoundException {

    ArrayList<Integer> arrayListiary = new ArrayList<>();
    LinkedList<Integer> linkedListiary = new LinkedList<>();

    // ArrayList version
    System.out.println("ArrayList:");
    importFileIntoList(f, arrayListiary);

    // LinkedList Version
    System.out.println("LinkedList:");
    importFileIntoList(f, linkedListiary);
  }

  // This method should take in a list and a file, and should return the list with all of the elements in the file added to it.
  public static void importFileIntoList(File f, List<Integer> listiary) throws FileNotFoundException {

    // start timer
    long start = System.currentTimeMillis();

    Scanner input = new Scanner(f);

    while (input.hasNext()) {
      listiary.add(input.nextInt());
    }

    // end timer
    long end = System.currentTimeMillis();

    // time elapsed
    System.out.println("Time Elapsed Importing: " + (end - start) + " milliseconds.");

    findTreasureLocation(listiary);
    findTreasurePathLength(listiary);
  }

  // This method should take in a list, and use it to find the treasure as described above.
  public static int findTreasureLocation(List<Integer> listiary) {
    long start = System.currentTimeMillis();

    int index = 0;
    while (listiary.get(index) > 0) {
      index = listiary.get(index);
    }

    long end = System.currentTimeMillis();

    System.out.println("Finding treasure took this long: " + (end - start) + " milliseconds.");

    System.out.println("Treasure was found at this location: " + index);

    return index;
  }

  // This method should take in a list, and use it to find the number of steps taken to reach the treasure.
  public static int findTreasurePathLength(List<Integer> listiary) {

    int steps = 0;
    int index = 0;
    while (listiary.get(index) > 0) {
      index = listiary.get(index);
      steps++;
    }

    System.out.println("Finding treasure took amount of steps: " + steps);

    return index;
  }
}