public class AdvanceTicket extends RegularTicket {
  private int daysAheadofTime;

  // constuctor
  public AdvanceTicket(int number, int days) {
    // only number gets passed the super class — how many days walkup/regular tickets are purchased before aren't releveant
    super(number);

    daysAheadofTime = days;
  }

  // double to include cents
  public double getTicketPrice() {
    if (daysAheadofTime >= 20) {
      return 15;
    } else if (daysAheadofTime > 10 && daysAheadofTime < 20) {
      return 20;
    } else {
      return 40;
    }
  }

  // returns how many days ahead tickets were purchased
  public int getDaysAheadofTime() {
    return daysAheadofTime;
  }

  // print method
  public void print() {
    System.out.println("Advance Ticket. Number: " + getTicketNumber() + " Cost: " + getTicketPrice() + ". Purchased " + getDaysAheadofTime() + " days ahead of time.");
  }
}