import java.util.ArrayList;
import java.util.Collections;

public class ShoppingCart {

  // fields
  private ArrayList<ItemOrder> cart;
  private Boolean discount = false; // for default

  // constructor
  public ShoppingCart() {
    cart = new ArrayList<>();
  }

  // adds to shopping cart
  public void add(ItemOrder order) {

    // iterates through to see if an item is already there. If so, remove it.
    for (int i = 0; i < cart.size(); i++) {
      if (cart.get(i).getItem().getName().equals(order.getItem().getName())) {
        cart.remove(i);
      }
    }

    cart.add(order);
  }

  // sets discount
  public void setDiscount(Boolean value) {
    discount = value;
  }

  public double getTotal() {

    double totalPrice = 0;

    // get price for each item
    for (int i = 0; i < cart.size(); i++) {
      totalPrice += cart.get(i).getPrice();
    }

    if (discount) {
      return (totalPrice * .9);
    } else {
      return totalPrice;
    }
  }

  public void sortCart() {
    Collections.sort(cart);
  }

  public String toString() {
    String string = "";
    for (ItemOrder i : cart) {
      string += i.toString() + " | ";
    }
    return string;
  }
}