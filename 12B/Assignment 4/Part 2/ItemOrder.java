// stores information about about a particular item and the quantity ordered for said item.

public class ItemOrder implements Comparable<ItemOrder>{

  // fields
  private Item item;
  private int quantity;

  public ItemOrder(Item item, int quantity) {
    // for current instance of object
    this.item = item;
    this.quantity = quantity;
  }

  // gets price
  public double getPrice() {
    // calls item priceFor method, passing quanity from this object
    return item.priceFor(quantity);
  }

  // returns index of item from arraylist
  public Item getItem() {
    return item;
  }

  // returns string
  public String toString() {
    return "(" + item.getName() + "," + quantity + ")";
  }

  public int compareTo(ItemOrder other) {
    return quantity - other.quantity;
  }
}