import java.awt.Color;
import java.awt.Point;

public class Cardinal extends AbstractBird {

  private Color BirdColor;

  // for flying method
  public static int direction = -1;

  public Cardinal(int x, int y) {

    // passed to abstractbird
    super(x, y);
    BirdColor = Color.RED;
  }

  // placed here due to inheritance issue
  public Color getColor() {
    return BirdColor;
  }

  // for tracking direction of the bird

  public void fly() {

    double x = getPosition().getX();
    double y = getPosition().getY();
    if (y == 19) {
      direction = -1;
    }

    if (y == 1) {
      direction = 1;
    }

    y = y + direction;

    changePosition(x, y);
  }
}