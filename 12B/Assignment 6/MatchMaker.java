import java.util.*;
import java.io.*;

public class MatchMaker {
  public static void main(String[] args) throws FileNotFoundException {
 
    // sets up arraylists of people: integers are ID's of individuals. A later arraylist would be each person's preferences
    ArrayList<Person> men = new ArrayList<>();
    ArrayList<Person> women = new ArrayList<>();

    // calls importer
    importer(men, women);

    // men are prefered in the the first call, women in the second.
    stabilizer(men, women);

    print(men, women);
  }

  public static void importer(List<Person> men, List<Person> women) throws FileNotFoundException {

    // gets file name from user: either the short file or the long one
    Scanner console = new Scanner(System.in);
    System.out.println("Welcome to MatchMaker 3000(TM)! Please enter the file name of the lucky suiters!");
    String set = console.next();

    // sets up file import
    File f = new File(set);
    Scanner input = new Scanner(f);
    input.useDelimiter("[^a-zA-Z0-9]+"); // regex doesn't catch colon

    // assigns an ID to the person, and sets male-ness to be the default
    boolean isMale = true;
    int id = 0;

    while (input.hasNextLine()) {

      // what will be operated on
      String line = input.nextLine();
      Scanner lineScan = new Scanner(line);

      if (!line.contains("END")) {
        // gets name
        String name = lineScan.next();
        // list of partners
        ArrayList<Integer> partnerList = new ArrayList<>();
        // adds preferred partners
        while (lineScan.hasNextInt()) {
          partnerList.add(lineScan.nextInt());
        }

        // creates new person
        Person individual = new Person(name, partnerList, id);
        // sorts into seperate arraylists
        if (isMale) {
          men.add(individual);
        } else {
          women.add(individual);
        }

        // iterates id number
        id++;
      } else {
        isMale = false;
        id = 0;
      }
    }
  }

  public static void stabilizer(ArrayList<Person> list1, ArrayList<Person> list2) {

    boolean unmatched = true; // not a good idea. want to avoid on/off switches.
    int indexThroughlist1 = 0;

    while (unmatched) { // would be a good idea to not use the condition if the prefered list is empty.
      // current is the person that is being matched: the central
      Person current = list1.get(indexThroughlist1);
      int interestNum = current.partnerList.get(0);
      Person interest = list2.get(interestNum);

      // if their interest already has a partner, break them apart
      if (interest.partner != null) {
        interest.partner.isFree = true;
      }

      // set current person's partner to their interest and vice versa
      current.partner = interest;
      interest.partner = current;
      current.isFree = false;
      interest.isFree = false;

      // on the interest's list, find the index of their current partner
      int indexOnList = interest.partnerList.indexOf(indexThroughlist1);

      // for everyone on that list after that index, delete them from the interest's list and delete interest from their list
      if (indexOnList != -1) {
        for (int i = indexOnList; i < interest.partnerList.size(); i++) {
          for (int j = 0; j < list1.get(i).partnerList.size(); j++) {
            if (list1.get(i).partnerList.get(j)==interestNum)
              list1.get(i).partnerList.remove(j);
          }
          interest.partnerList.remove(i);
         }
      }

      int freeCount = 0;

      for (Person p : list1) {
        System.out.println("loop 1");
        if (p.isFree == false || p.partnerList.isEmpty()){
          freeCount++;
          System.out.println("loop 2");
        }
      }

      if (freeCount == list1.size()) {
        unmatched = false;
      } else {
        while (list1.get(indexThroughlist1).isFree == false) {
          indexThroughlist1++;
          if (indexThroughlist1 >= list1.size()) {
            indexThroughlist1 = 0;
          }
        }
      }
    }
    System.out.println("Eureka!");
  }

  // prints results of problem
  public static void print(ArrayList<Person> list1, ArrayList<Person> list2) {
    for (int i = 0; i < list1.size(); i++) {
      if (list1.get(i).isFree==false) {
        System.out.println(list1.get(i).name + " " + list1.get(i).partner.name);
      }
    }
  }
}