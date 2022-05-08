import java.io.Serializable;

public class Date implements Serializable, Comparable<Date> {

  public Integer day;

  public Integer month;

  public Integer year;

  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Date(Integer day, Integer month, Integer year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  @Override
  public String toString() {
    return "Date{" +
            "day=" + day +
            ", month=" + month +
            ", year=" + year +
            '}';
  }

  @Override
  public int compareTo(Date d) {

    if (this.year == d.year && this.month == d.month && this.day == d.day) {

      return 0;
    } else if (this.year == d.year) {

      if (this.month == d.month) {

        return (this.day - d.day) / Math.abs(this.day - d.day);
      } else {

        return (this.month - d.month) / Math.abs(this.month - d.month);
      }
      } else {

        return (this.year - d.year) / Math.abs(this.year - d.year);
      }
  }


}