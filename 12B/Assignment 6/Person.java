import java.util.*;

public class Person {

  public String name;
  public int id;
  public ArrayList<Integer> partnerList;
  public Person partner; // should intially be null
  public Boolean isMale; // true by default. i'm a bad femenist
  public Boolean isFree = true; //

  public Person(String name, ArrayList<Integer> partnerList, int id) {
    this.name = name;
    this.partnerList = partnerList;
    this.id = id;
  }

  public getReminderOfList(int preference) {
    List<Integer> reminder = new ArrayList<>();
    int index = 0;
    for (Integer partner : partnerList) {
      if (preference == partner) {
        break;
      }
      index++;
    }
    for (int i = index; i < partList.size() i++) {
      reminder.add(partnerList.get(i));
    }
    return reminder;
  }
}