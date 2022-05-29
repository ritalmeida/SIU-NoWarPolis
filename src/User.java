import edu.princeton.cs.algs4.RedBlackBST;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {

  public int id;

  public String name;

  public RedBlackBST<Date, PoI> poIs;

  public HashMap<Integer, User> users;

  public HashMap<Integer, User> getUsers() {
    return users;
  }

  public void setUsers(HashMap<Integer, User> users) {
    this.users = users;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RedBlackBST<Date, PoI> getPoIs() {
    return poIs;
  }

  public void setPoIs(RedBlackBST<Date, PoI> poIs) {
    this.poIs = poIs;
  }

  public User(int id, String name) {
    this.id = id;
    this.name = name;
    poIs = new RedBlackBST<>();
  }

  @Override
  public String toString() {
    return "UserBasic{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", poIs=" + poIs +
            '}';
  }

  /**
   * função para remover utilizador! auxiliar!
   */
  public void remove() {

    for (Date date : this.poIs.keys()) {

      this.poIs.get(date).getUsers().delete(date);
    }
  }

  /**
   * Adicionar um PoI na redblack no user
   * @param poI - poi a ser adicionado
   * @param date - date em que o user esteve no poi
   */
  public void addPoItoUser(PoI poI, Date date) {

    this.poIs.put(date, poI);
  }

  /**
   * Remover uma visita numa determinada data
   * @param date - a data a analizar
   */
  public void remocePoItoUser(Date date) {

    if (this.poIs.contains(date)) {

      this.poIs.delete(date);
    }
  }

  /**
   * Editar um user
   * @param name - o novo nome do user
   */
  public void editUser(String name) {

    if (name != null) {

      this.setName(name);
    }
  }

  /**
   * Os PoIs visitados pelo User num intervalo de 2 datas
   * @param d1 - data 1
   * @param d2 - data 2
   * @return o array com todos os pontos de interesse que o user visitou
   */
  public ArrayList<PoI> poiVisitedinTime(Date d1, Date d2) {

    ArrayList<PoI> poIArrayList = new ArrayList<>();

    for (Date date : this.poIs.keys(d1, d2)) {

      poIArrayList.add(this.poIs.get(date));
    }
    return poIArrayList;
  }

  /**
   * Eliminar um user
   */
  public void removeUser() {

    for (Date date : this.poIs.keys()) {

      this.poIs.get(date).getUsers().delete(date);
    }
  }

  /**
   * Editar um utilizador
   * @param user - utilizador a editar
   * @param name - nome a editar
   */
  public void editUser(User user, String name) {

    if (name != null) {

      this.setName(name);
    }
  }

  /**
   * Imprimir os users
   */
  public void printUsers() {

    System.out.println(this.users.toString());
  }

  /**
   * Top 5 utilizadores que visitaram o maior num de pois num intervalo de tempo
   * @param users - os utilizadores
   * @param date1 - data de inicio do intervalo de tempo
   * @param date2 - data de fim do intervalo de tempo
   * @return um arraylist com o top 5
   */
  public ArrayList<User> top5UsersinPoiInTime(HashMap<Integer, User> users, Date date1, Date date2) {

    HashMap<User, Integer> top5 = new HashMap<>();
    ArrayList<User> end = new ArrayList<>();
    ArrayList<User> top5Users = new ArrayList<>();

    int size;

    for (Map.Entry<Integer, User> set:users.entrySet()){

      size = set.getValue().poiVisitedinTime(date1, date2).size();
      top5.put(set.getValue(), size);
    }

    List<Map.Entry<User, Integer>> list = new LinkedList<>(top5.entrySet());    //lista para os elementos do HashMap

    Collections.sort(list, new Comparator<Map.Entry<User, Integer>>() {
      @Override
      public int compare(Map.Entry<User, Integer> o1, Map.Entry<User, Integer> o2) {

        return (o1.getValue()).compareTo(o2.getValue());
      }
    });

    for (Map.Entry<User, Integer> u : list) {       //passar os dados da lista para o hashmap

      end.add(u.getKey());
    }

    for (int i = end.size()-1; i >= end.size()-5; i--) {

      top5Users.add(end.get(i));
    }

    return top5Users;
  }

}