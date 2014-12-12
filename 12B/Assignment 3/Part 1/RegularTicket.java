public class RegularTicket {

  // fields
  private int TicketNumber;

  // constructor
  public RegularTicket(int number) {
    TicketNumber = number;
  }

  // gets ticket number
  public int getTicketNumber() {
    return TicketNumber;
  }

  // returns ticket price
  public double getTicketPrice() {
    int TicketPrice = 40;
    return TicketPrice;
  }

  // print method
  public void print() {
    System.out.println("Regular Ticket. Number: " + TicketNumber + " Cost: " + getTicketPrice());
  }
}