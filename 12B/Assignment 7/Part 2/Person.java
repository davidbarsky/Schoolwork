import java.util.*;

public class Person {
  private String name;
  private ArrayList<String> decendents = new ArrayList<>();
  private ArrayList<String> asendents = new ArrayList<>();

  public Person(String name) {
    this.name = name;
  }

  public void setDecendents(String name) {
    decendents.add(name);
  }

  public String getDecendents(int index) {
    return decendents.get(index);
  }

  public int getDecendentsLength() {
    return decendents.size();
  }

  public boolean hasDecendents() {
    if (decendents.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  public void setAsendents(String name) {
    asendents.add(name);
  }

  public String getAsendents(int index) {
    return asendents.get(index);
  }

  public int getAsendentsLength() {
    return asendents.size();
  }

  public boolean hasAsendents() {
    if (asendents.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}