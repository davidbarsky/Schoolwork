// for scanner, file, and collections
import java.util.*;
import java.io.*;

public class Relatives {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner console = new Scanner(System.in);

    System.out.println("Please enter the file to be analysed:");
    String fileName = console.next();

    System.out.println("Which person's family should be analysed?");
    String personName = console.next();

    Scanner input = new Scanner(new File(fileName));

    Map<String, Person> list = importer(input);

    makesFamily(input, list);

    int indent = 0;

    familyTreeFinder(list, indent, personName);
  }

  public static void familyTreeFinder(Map<String, Person> list, int indent, String personName) {
    if (list.get(personName).hasDecendents() || list.get(personName).hasAsendents()) {
      for (int i = 0; i < list.get(personName).getAsendentsLength(); i++ ) {
        for (int j = 0; j < indent; j++) {
          System.out.print(" ");
        }
        System.out.println(list.get(personName).getAsendents(i));
      }
    } else {
      for (int i = 0; i < list.get(personName).getAsendentsLength(); i++) {
        System.out.println(list.get(personName).getAsendents(i));
      }
      familyTreeFinder(list, indent + 2, personName);
    }
  }

  // sets up family relationships
  public static void makesFamily(Scanner input, Map<String, Person> list) {
    // while list is not empty
    //    let n be the next person in the list
    //    add the parents of n to n's person object acedent field
    //    add n to the parents decendent's fields

    // to iterate through
    ArrayList<String> toMakeFamily = new ArrayList<>();

    while (input.hasNextLine() && input.hasNext()) {
      String name = input.nextLine();

      toMakeFamily.add(name);
    }

    // removes "END"
    if (toMakeFamily.contains("END")) {
      toMakeFamily.remove("END");
    }

    // to avoid another call in the loop. besides, this is never going to change in length.
    int length = toMakeFamily.size();

    System.out.println(length);

    for (int i = 0; i < length; i+=3) {
      // person of focus
      String name = toMakeFamily.get(i);

      // adds to parents list
      list.get(name).setAsendents(toMakeFamily.get(i + 1)); // mother
      list.get(name).setAsendents(toMakeFamily.get(i + 2)); // father

      // adds kid to parent's decendent list
      list.get(toMakeFamily.get(i + 1)).setDecendents(name); // adds to mother's decendent's list
      list.get(toMakeFamily.get(i + 2)).setDecendents(name); // adds to father's decendent's list
    }
  }

  // imports contents from file to a linked list
  public static Map<String, Person> importer(Scanner input) throws FileNotFoundException {
    Map<String, Person> list = new HashMap<>();

    while (input.hasNextLine() && input.hasNext()) {
      String name = input.nextLine();

      // quickest and easiest way to stop scanner. Otherwise, the while condition would be poluted with too many conditions.
      if (name.contains("END")) {
        break;
      }

      Person person = new Person(name);

      list.put(name, person);
    }
    return list;
  }
}