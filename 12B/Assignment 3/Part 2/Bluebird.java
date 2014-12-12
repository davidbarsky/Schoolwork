import java.awt.Color;
import java.awt.Point;

public class Bluebird extends AbstractBird {

  private Color BirdColor;

  // for flying method. Not static to avoid a nasty bug that will be described in person
  public int xDirection = 1; // right
  public int yDirection = 1; // up

  // constructor
  public Bluebird(int x, int y) {

    // passed to abstractbird
    super(x, y);
    BirdColor = Color.BLUE;
  }

  // placed here due to inheritance issue
  public Color getColor() {
    return BirdColor;
  }

  public void fly() {

    // for getting previous position
    double x = getPosition().getX();
    double y = getPosition().getY();

    // for turning around
    if (x >= 19 || x == 1) {
      xDirection = xDirection * (-1);
    }

    // switcher
    x = x + xDirection;
    y = y + yDirection;

    // change position call
    changePosition(x, y);

    // for inversing
    if (yDirection == 1) {
      yDirection = -1;
    } else if (yDirection == -1) {
      yDirection = 1;
    }
  }
}