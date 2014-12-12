import java.awt.Color;
import java.awt.Point;

public class Vulture extends AbstractBird {

  private Color BirdColor;

  // for keeping track of what position the
  public int flightCase = 1;

  // constructor
  public Vulture(int x, int y) {

    // passed to abstractbird
    super(x, y);
    BirdColor = Color.BLACK;
  }

  // gets the color
  public Color getColor() {
    return BirdColor;
  }

  public void fly() {

    // for getting position
    double x = getPosition().getX();
    double y = getPosition().getY();

    // movements of vulture (up, down, left, right)
    if (flightCase == 1) {
      y = y + 1;
    } else if (flightCase == 2) {
      x = x + 1;
    } else if (flightCase == 3) {
      y = y - 1;
    } else if (flightCase == 4) {
      x = x - 1;
    }

    flightCase++;

    // loops flightcase around
    if (flightCase > 4) {
      flightCase = 1;
    }

    changePosition(x, y);
  }
}