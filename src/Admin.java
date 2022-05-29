import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

public class Admin implements Serializable {


  public HashMap<Integer, PoI> poIs;
  public HashMap<Integer, User> users;
  public String name;

  public static final Logger LOGGER = Logger.getLogger(Admin.class.getName());

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Admin(String name) {

    this.poIs = new HashMap<Integer, PoI>();
    this.users = new HashMap<Integer, User>();
    this.name = name;
  }

  public HashMap<Integer, PoI> getPoIs() {
    return poIs;
  }

  public void setPoIs(HashMap<Integer, PoI> poIs) {
    this.poIs = poIs;
  }

  public HashMap<Integer, User> getUsers() {
    return users;
  }

  public void setUsers(HashMap<Integer, User> users) {
    this.users = users;
  }

  /**
   * Adicionar um poi ao hashmap de pois
   * @param poI - o pto a adicionar
   */
  public void addPoIHash(PoI poI) {

    this.poIs.put(poI.getId(), poI);
    System.out.println("Point added!");
  }

  /**
   * Imprimir a hash map de pois
   */
  public void printPoIHashMap() {

    System.out.println("Pois: ");
    System.out.println(this.poIs.toString());
  }

  /**
   * Remover um poi da hash
   * @param poI - poi a remover
   */
  public void removePoI(PoI poI) {

    if (this.poIs.containsValue(poI)) {

      this.poIs.remove(poI.getId(), poI);
      poI.removePoI();
    }
  }

  /**
   * Adicionar um user ao hashmap de users
   * @param user - o user a adicionar
   */
  public void addUserHash(User user) {

    this.users.put(user.getId(), user);
    System.out.println("User added!");
  }

  /**
   * Imprimir hash dos users
   */
  public void printUserHaspMap() {

    System.out.println("Users: ");
    System.out.println(this.users.toString());
  }

  /**
   * Remover um user
   * @param user - user a remover
   */
  public void removeUser(User user) {

    if (this.users.containsValue(user)) {

      this.users.remove(user.getId(), user);
      user.removeUser();
    }
  }

  /**
   * Esta função vai gerar um snapshot do sistema dos PoIs naquele momento
   */
  public void now() {

    Date date1 = new Date(01, 01, 1900);
    Date date2 = new Date(31,12,3000);

    LOGGER.info("Status now: ");

    for (Map.Entry<Integer, PoI> poI : this.poIs.entrySet()) {

      System.out.println(poI.getValue().userVisitedInTime(date1, date2).toString());
    }
  }


}