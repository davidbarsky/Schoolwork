import java.awt.Color;
import java.awt.Point;

public abstract class AbstractBird implements Bird {

  private Point Position = new Point(0,0);

  public AbstractBird(int x, int y) {
    Position.setLocation(x, y);
  }

  // same for every bird
  // returns bird's position
  public Point getPosition() {
    return Position;
  }

  // needed to properly encapsulate the Position Field
  public void changePosition(double x, double y) {
    Position.setLocation(x, y);
  }
}