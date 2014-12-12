import java.util.TimeZone;

public class Date {

  // local variables
  private int year;
  private int month;
  private int day;
  public static final int firstYear = 1970;

  // final variables
  private static final int startYear = 1753;
  private static final int daysPerWeek = 7;

  // -1 to account for zero indexing.
  private static final int daysPerMonth[] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  // constructor
  public Date(int year, int month, int day) {
    // this.[date] fixes varible shadowing
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public Date() {
    this(1970, 1, 1);
    int daysSinceEpoch = getDaysSinceEpoch();
    for (int i = 0; i < daysSinceEpoch; i++) {
      // next days keep track of days: non eed for
      nextDay();
    }
  }

  // gets days since January 1, 1970
  public static int getDaysSinceEpoch() {
    int daysSinceEpoch = (int) ((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);

    return daysSinceEpoch;
  }

  // returns day
  public int getDay() {
    return day;
  }

  // returns month
  public int getMonth() {
    return month;
  }

  // returns year
  public int getYear() {
    return year;
  }

  // returns day of year
  public String getDayOfWeek() {
    int dayOfWeek = 1;

    for ( Date temp = new Date(1753, 1, 1); !temp.equals(this);) {
      temp.nextDay();
      dayOfWeek = (dayOfWeek + 1) % 7;
    }

    String dayOfWeekList[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    return dayOfWeekList[dayOfWeek];
  }


  // returns leap year status
  public boolean isLeapYear() {
    return year % 4 == 0 || year % 400 == 0 && year % 100 != 0;
  }

  // for method isLeapYear()
  private int getDaysInMonth() {
    int result = daysPerMonth[month];
    if (month == 2 && isLeapYear()) {
      // adds
      result++;
    }
    return result;
  }

  // returns next day
  public void nextDay() {
    day++;

    // handles month to month changes
    if (day > getDaysInMonth()) {
      month++;
      day = 1;

      // handles year to year changes
      if (month > 12) {
        year++;
        // goes to january
        month = 1;
      }
    }
  }

  // returns string verison
  public String toString() {
    return (new StringBuilder()).append(year).append("/").append(month).append("/").append(day).toString();
  }

  // equality
  public boolean equals(Object o) {
    if (o instanceof Date) {
      Date other = (Date) o;
      return year == other.year && month == other.month && day == other.day;
    } else {
      return false;
    }
  }
}