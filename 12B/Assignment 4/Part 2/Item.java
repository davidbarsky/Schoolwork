import java.util.ArrayList;
import java.text.*;

public class Item {

  // fields
  private String name;
  private double price;
  private int bulkQuantity;
  private double bulkPrice;

  // constructor 1
  public Item(String name, double price) {
    if (price < 0) {
      throw new IllegalArgumentException();
    }

    this.name = name;
    this.price = price;
  }

  // constructor 2
  public Item(String name, double price, int bulkQuantity, double bulkPrice) {
    if (price < 0 || bulkQuantity < 0 || bulkPrice < 0) {
      throw new IllegalArgumentException();
    }

    this.name = name;
    this.price = price;
    this.bulkQuantity = bulkQuantity;
    this.bulkPrice = bulkPrice;
  }

  // bulk pricing y'all (per unit pricing)
  public double priceFor(int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException();
    }

    int remainder = 0;

    // if statement avoids divide by zero errors
    if (bulkQuantity != 0) {
      // quantityQuotient is how many of the orders end up on the bulk pricing
      int quanityQuotient = quantity / bulkQuantity;

      // how many don't fit on the bulk pricing
      remainder = quantity % bulkQuantity;

      return (quanityQuotient * bulkPrice) + (remainder * price);
    } else {
      return remainder * price;
    }
  }

  // to string
  public String toString() {
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    if (bulkPrice == 0) {
      return name + ", $" + nf.format(price);
    } else {
      return name + ", $" + nf.format(price) + " (" + bulkQuantity + " for " + bulkPrice + ")";
    }
  }

  // returns name
  public String getName() {
    return name;
  }
}