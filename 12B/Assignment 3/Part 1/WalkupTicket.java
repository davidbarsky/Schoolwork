public class WalkupTicket extends RegularTicket {

  // constructor
  public WalkupTicket(int number) {
    super(number);
  }

  // returns ticket price
  public double getTicketPrice() {
    // calls super class
    double basePrice = super.getTicketPrice();
    return basePrice + 10;
  }

  public void print() {
    System.out.println("Walkup Ticket. Number: " + getTicketNumber() + " Cost: " + getTicketPrice());
  }
}