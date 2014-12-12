public class TestTicket {
  public static void main(String[] args) {

    // Array for tickets.
    RegularTicket[] tickets = new RegularTicket[15];

    // for days ahead of time
    int[] daysAhead = {30, 15, 3};

    // tickets 1 - 3
    for (int i = 0; i <= 2; i++) {
      tickets[i] = new RegularTicket(i + 1);
    }

    // ticket 4 and 5
    for (int i = 3; i <= 4; i++) {
      tickets[i] = new WalkupTicket(i + 1);
    }

    // tickets 6 through 8
    for (int i = 5; i <= 7; i++) {
      tickets[i] = new AdvanceTicket(i + 1, daysAhead[i - 5]);
    }

    // tickets 9 through 11
    for (int i = 8; i <= 10; i++) {
      tickets[i] = new StudentAdvanceTicket(i + 1, daysAhead[i - 8]);
    }

    // tickets 12 though 15
    for (int i = 11; i < 15; i++) {
      tickets[i] = new RegularTicket(i + 1);
    }

    // prints ticket information
    Printer(tickets);

    // prints ticket profits
    System.out.println("\n" + "Total Profit:");
    System.out.println("$" + Profit(tickets));
  }

  public static void Printer (RegularTicket[] tickets) {
    for (int i = 0; i < 15; i++) {
      // calls object print method
      tickets[i].print();
    }
  }

  public static double Profit (RegularTicket[] tickets) {
    // Profit Counter
    double profit = 0;

    // gets price of each ticket
    for (int i = 0; i <= 14; i++) {
      profit += tickets[i].getTicketPrice();
    }

    return profit;
  }
}