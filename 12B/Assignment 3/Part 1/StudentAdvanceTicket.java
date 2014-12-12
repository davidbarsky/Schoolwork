public class StudentAdvanceTicket extends AdvanceTicket {

  // constructor
  public StudentAdvanceTicket(int number, int days) {

    // number goes to RegularTicket, days to AdvanceTicket
    super(number, days);
  }

  // returns a double because of pricing. half price of
  public double getTicketPrice(int daysAheadofTime) {
    if (daysAheadofTime >= 20) {
      return 7.5;
    } else if (daysAheadofTime > 10 && daysAheadofTime < 20) {
      return 10;
    } else {
      return 20;
    }
  }

  // print method
  public void print() {
    System.out.println("Student Advance Ticket. Number: " + getTicketNumber() + " Cost: " + getTicketPrice() + ". Purchased " + getDaysAheadofTime() + " days ahead of time.");
  }
}