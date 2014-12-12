David Barsky
Assignment 3

## Class Hierarchy

The most general ticket is `RegularTicket.java`. `WalkupTicket.java` and `AdvanceTicket.java` inherit properties from `RegularTicket.java`. The constructor in `AdvanceTicket.java` accepts another parameter, the integer `days`. That integer is used in client code to indicate how many days before the event the ticket was purchased.

`AdvanceTicket.java` has a subclass — `StudentAdvanceTicket.java`. The sole difference between the two is that `StudentAdvanceTicket.java` has half the price for each purchase interval.

`TestTicket.java` uses an array with the type RegularTicket. Since all the other tickets are subclasses of RegularTicket, the array would store those subclasses.

The `printer` and the `profit` methods get the profit from the classes.