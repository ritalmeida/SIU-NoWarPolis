import edu.princeton.cs.algs4.RedBlackBST;


import java.io.Serializable;
import java.util.HashMap;

public class Admin implements Serializable {


  public HashMap<Integer, PoI> poIs;
  public HashMap<Integer, User> users;

  public String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Admin(String name) {
    this.name = name;
  }

  public Admin(RedBlackBST<String, PoI> poIs, HashMap<Integer, PoI> poIs1, HashMap<Integer, User> users) {
    this.poIs = poIs1;
    this.users = users;
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


  /**********************************************************/

  /**
   * Adicionar um utilizador ao Hash Map
   * @param userBasic - o user a adicionar
   */
  public void addUser(User userBasic) {

    this.users.put(userBasic.getId(), userBasic);
  }

  /**
   * Adicionar um PoI a Hash Map
   * @param poI - o PoI a adicionar
   */
  public void addPoI(PoI poI) {

    this.poIs.put(poI.getId(), poI);
  }

  /**
   * Imprimir o hash map de PoIs
   */
  public void printPoIs() {

    System.out.println(this.poIs.toString());
  }

  /**
   * Imprimir os users
   */
  public void printUsers() {

    System.out.println(this.users.toString());
  }

  /**
   * Remover um user da hash map de users
   * @param userBasic - o user a remover
   */
  public void removeUser(User userBasic) {

    if (this.users.containsValue(userBasic)) {

      this.users.remove(userBasic.getId(), userBasic);
      userBasic.remove();
    }
  }

  /**
   * Remover um PoI da Hash Map de PoIs
   * @param poI - o pto de interesse a remover
   */
  public void removePoI(PoI poI) {

    if (this.poIs.containsValue(poI)) {

      this.poIs.remove(poI.getId(), poI);
      poI.remove();
    }
  }

  public void now() {

    //FAZER!!
  }

}