import java.util.*; // for scanner and collections
import java.io.*; // for files

public class EditDistance {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner console = new Scanner(System.in);

    // blathering about inputs
    System.out.println("Hello! Welcome to the Distance Between Words Counter (C 1997)!");
    System.out.println("Please enter the name of the file to be analyzed:");
    String fileName = console.next();

    // gets passed to importer
    Scanner input = new Scanner(new File(fileName));

    // used an arraylist because random access for starting words is fast
    ArrayList<String> list = importer(input);
    ArrayList<String> listToPrint = new ArrayList<>();

    // fixes scoping issue.
    String startingWord;
    String endingWord;

    do {
      // gets first word
      System.out.println("Enter the starting word:");
      startingWord = console.next();
    } while (!list.contains(startingWord));

    do {
      // gets second word
      System.out.println("Enter the ending word:");
      endingWord = console.next();
    } while (!list.contains(startingWord));

    // ends program if word length is different
    if (startingWord.length() != endingWord.length()) {
      System.out.println("Solution doesn't exist: the lengths of input words are different.");
    }

    int result = editDistanceCalculator(list, listToPrint, startingWord, endingWord);

    System.out.println("Edit distance was: " + result);
    transformationPathDisplayer(listToPrint);
  }

  public static int editDistanceCalculator(ArrayList<String> list, ArrayList<String> listToPrint, String startingWord, String endingWord) {
    // avoids call to check list size, which in the scope of this function, will never change. more efficient.
    int wordLength = startingWord.length(); // to skip over words that are not of the same length
    int startingIndex = list.indexOf(startingWord);
    int endingIndex = list.indexOf(endingWord);
    int editDistance = 0;

    if (startingIndex > endingIndex) {
      for (int i = startingIndex; i >= endingIndex; i--) {
        if (list.get(i).length() == wordLength) {
          editDistance--;
          listToPrint.add(list.get(i));
        }
      }
    } else {
      for (int i = startingIndex; i <= endingIndex; i++) {
        if (list.get(i).length() == wordLength) {
          editDistance++;
          listToPrint.add(list.get(i));
        }
      }
    }

    return editDistance;
  }

  public static void transformationPathDisplayer(ArrayList<String> listToPrint) {
    int listSize = listToPrint.size(); // avoids call during for loop

    for (int i = 0; i < listSize; i++) {
      System.out.println(listToPrint.get(i));
    }
  }


  // imports contents from file to a linked list
  public static ArrayList<String> importer(Scanner input) throws FileNotFoundException {
    ArrayList<String> wordList = new ArrayList<>();

    while (input.hasNextLine() && input.hasNext()) {
      String word = input.next();
      wordList.add(word);
    }
    return wordList;
  }
}