import java.io.Serializable;
import java.util.ArrayList;

import edu.princeton.cs.algs4.RedBlackBST;

public class PoI implements Serializable {

  //public double x;

  //public double y;

  public int id;

  public String localidade;

  public String info;

  public RedBlackBST<Date, User> users;

  public Location location;

  public PoI(int id, String info, Location location) {

    this.id = id;
    this.info = info;
    this.location = location;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  /*public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }*/

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public RedBlackBST<Date, User> getUsers() {
    return users;
  }

  public void setUsers(RedBlackBST<Date, User> users) {
    this.users = users;
  }

  public PoI(int id, String info, Location location, RedBlackBST<Date, User> users) {
    this.id = id;
    this.location = location;
    this.info = info;
    this.users = users;
  }

  public void remove() {

    for (Date date : this.users.keys()) {

      this.users.get(date).getPoIs().delete(date);
    }
  }
}
