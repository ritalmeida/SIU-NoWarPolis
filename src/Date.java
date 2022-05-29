import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Serializable, Comparable<Date> {

  public Integer day;

  public Integer month;

  public Integer year;

  public int hour;

  public int minute;

  public int second;

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
  }

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

  public Date(int year, int month, int day){
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = 0;
    this.minute = 0;
    this.second = 0;
  }
  public Date(int year, int month, int day, int hour, int minute, int second) {
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }
  public Date(Date d){
    this.year = d.year;
    this.month = d.month;
    this.day = d.day;
    this.hour = d.hour;
    this.minute = d.minute;
    this.second = d.second;
  }
  public Date(){
    GregorianCalendar g = new GregorianCalendar();
    this.year = g.get(Calendar.YEAR);
    this.month = g.get(Calendar.MONTH) + 1;
    this.day = g.get(Calendar.DAY_OF_MONTH);
    this.hour = g.get(Calendar.HOUR_OF_DAY);
    this.minute = g.get(Calendar.MINUTE);
    this.second = g.get(Calendar.SECOND);
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

  public boolean beforeDate(Date d) {

    return this.compareTo(d) < 0;
  }
  public static boolean isLeapYear(int year) {

    return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

  }

  public boolean afterDate(Date d) {

    return this.compareTo(d) > 0;
  }

  public void incrementDate() {

    if(daysMonth(this.month, this.year) == this.day){
      if(this.month == 12){
        //last day of the year
        this.year++;
        this.month = 1;
        this.day = 1;
        return;
      }
      //last day of the month
      this.month++;
      this.day = 1;
      return;
    }
    //any other day
    this.day++;
  }

  public static int daysMonth(Integer month, int year) {

    switch (month){
      case 11:
      case 4:
      case 6:
      case 9:
        return 30;
      case 2:
        return (Date.isLeapYear(year)) ? 29 : 28;
      default:
        return 31;
    }

  }
  public static int daysBetweenDates(Date begin, Date end){

    if(begin.afterDate(end))
      return -1;

    if(begin.year == end.year)
      return Date.daysBetweenMonths(begin.day, begin.month, end.day, end.month, end.year);


    Date aux = new Date(begin);
    int days = Date.daysBetweenMonths(aux.day, aux.month, 31, 12, end.year);
    while (++aux.year < end.year)
      days += (isLeapYear(aux.year) ? 366 : 365);

    return days + Date.daysBetweenMonths(1, 1, end.day, end.month, end.year);

  }
  private static int daysBetweenMonths(int beginDay, int beginMonth, int endDay, int endMonth, int year) {

    if(beginMonth == endMonth)
      return endDay - beginDay;

    int days = Date.daysMonth((int) beginMonth, year) - beginDay;
    while(++beginMonth < endMonth)
      days += Date.daysMonth((int) beginMonth, year);

    return days + endDay;
  }

}