import java.util.ArrayList;

public class TileList {

  // fields
  private ArrayList<Tile> tiles;

  // constuctor
  public TileList() {
    tiles = new ArrayList<>();
  }

  // inserts tile at the end
  public void insertBack(Tile t) {
    tiles.add(t);
  }

  // returns the number of tiles in this list
  public int size() {
    return tiles.size();
  }

  // returns the Tile at the given index
  public Tile get(int index) {
    return tiles.get(index);
  }

  // searches through the list of tiles and returns a reference (i.e, an object) to the last tile for which (x, y) is inside the tile; returns null if (x, y) is not inside any tile of the list; moves the found tile to the back of the list

  public Tile moveToBack(int x, int y) {
    int i = -1;

    for (Tile t : tiles) {
      if (t.inside(x, y)) {
        i = tiles.indexOf(t);
      }
    }

    if (i == -1) {
      return null;
    } else {
      tiles.add(tiles.get(i));
      return tiles.get(i);
      // Tile t = tiles.get(i);
      // tiles.add(t);
      // return t;
    }
  }
}