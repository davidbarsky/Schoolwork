import java.util.ArrayList;

public class Catalog {

  // fields
  private ArrayList<Item> items;
  private String name;

  // constructor
  public Catalog(String name) {
    name = name;
    items = new ArrayList<>();
  }

  // adds item to end of list
  public void add(Item item) {
    items.add(item);
  }

  // returns size
  public int size() {
    return items.size();
  }

  // returns item at given index
  public Item get(int index) {
    return items.get(index);
  }

  // returns name
  public String getName() {
    return name;
  }
}