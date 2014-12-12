import java.io.*;     // For files
import java.util.*;   // for scanner and collections

public class Deleter {

  public static void main(String[] args) throws FileNotFoundException {

    // declaration for gibberish
    ArrayList<String> arrayListGib = new ArrayList<>();
    LinkedList<String> linkedListGib = new LinkedList<>();

    File gibberishText = new File("gibberish.txt");
    File deleteCodes = new File("deleteCodes.txt");

    // ArrayList version
    System.out.println("ArrayList");
    deleter(deleteCodes, gibberishImporter(gibberishText, arrayListGib));

    // LinkedList version
    System.out.println("LinkedList");
    deleter(deleteCodes, gibberishImporter(gibberishText, linkedListGib));
  }

  public static List gibberishImporter(File f, List<String> listiary) throws FileNotFoundException {
    // scanner
    Scanner input = new Scanner(f);

    long start = System.currentTimeMillis();
    // importer
    while (input.hasNext()) {
      listiary.add(input.next());
    }

    long end = System.currentTimeMillis();

    System.out.println("It took" + (end - start) + " milliseconds to import.");

    return listiary;
  }

  public static void deleter(File deleteCodes, List listiary) throws FileNotFoundException {
    Scanner input = new Scanner(deleteCodes);
    while (input.hasNextLine()) {
      int modifier = 0; // changes when dete
      Scanner toDelete = new Scanner(input.nextLine());
      while (toDelete.hasNextInt()) {
        listiary.remove(toDelete.nextInt() - modifier);
        modifier++;
      }
    }
  }
}