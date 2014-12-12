import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Hummingbird extends AbstractBird {

  private Color BirdColor;

  public Hummingbird(int x, int y) {

    // passed to abstractbird
    super(x, y);
    BirdColor = Color.MAGENTA;
  }

  // returns bird color
  public Color getColor() {
    return BirdColor;
  }

  public void fly() {
    Random rand = new Random();

    // generate random x/y coordinates for Hummingbird to go to
    int randomX = rand.nextInt(20);
    int randomY = rand.nextInt(20);

    changePosition(randomX, randomY);
  }
}