import java.util.List;

public class PoILogs {

  public Date date;

  public int userID;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public PoILogs(Date date, int userID) {
    this.date = date;
    this.userID = userID;
  }

  @Override
  public String toString() {
    return "PoILogs{" +
            "date=" + date +
            ", userID=" + userID +
            '}';
  }
}