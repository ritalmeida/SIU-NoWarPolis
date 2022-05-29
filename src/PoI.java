import java.io.Serializable;
import java.util.*;

import edu.princeton.cs.algs4.RedBlackBST;

import javax.naming.ldap.HasControls;

public class PoI implements Serializable {

  //public double x;

  //public double y;

  public int id;

  public String localidade;

  public String info;

  public RedBlackBST<Date, User> users;

  public Location location;

  public TypePoI typePoI;

  public PoI(int id, String localidade, String info, RedBlackBST<Date, User> users, Location location, TypePoI typePoI) {

    this.id = id;
    this.localidade = localidade;
    this.info = info;
    this.users = users;
    this.location = location;
    this.typePoI = typePoI;
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

  public TypePoI getTypePoI() {
    return typePoI;
  }

  public void setTypePoI(TypePoI typePoI) {
    this.typePoI = typePoI;
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

  public PoI(int id, TypePoI typePoI, String info, Location location) {

    this.id = id;
    this.typePoI = typePoI;
    this.info = info;
    this.location = location;
  }

  /**
   * Adicionar um user na nossa RedBlack de users de um PoI
   * @param user  - user que visitou o PoI
   * @param date -  a data da visita
   */
  public void addUserToPoi(User user, Date date) {

    this.users.put(date, user);
  }


  /**
   * Remover uma visita a um PoI numa determinada data
   * @param date - a data a remover
   */
  public void removeUserOfPoi(Date date) {

    if (this.users.contains(date)) {

      this.users.delete(date);
    }
  }

  /**
   * remove um ponto de interesse percorrendo a nossa RB
   */
  public void removePoI() {

    for (Date date : this.users.keys()) {

      this.users.get(date).getPoIs().delete(date);
    }
  }

  /**
   * Editar o tipo de PoI de um determinado ponto de interesse
   * @param typePoI - novo tipo de PoI
   */
  public void editTypePoI(TypePoI typePoI) {

    if (typePoI != null) {
      this.setTypePoI(typePoI);
    }
  }

  /**
   * Editar a localização de um PoI
   * @param location - a nova localizacao
   */
  public void editLocationPoI(Location location) {

    if (location != null) {

      this.setLocation(location);
    }
  }

  /**
   * Editar a info de um PoI
   * @param info - a nova info
   */
  public void editInfoPoI(String info) {

    if (info != null) {

      this.setInfo(info);
    }
  }

  /**
   * Editar o id de um PoI
   * @param id
   */
  public void editIdPoI(int id) {

    if (id != 0) {

      this.setInfo(info);
    }
  }

  /**
   * Editar a localidade de um PoI
   * @param localidade - a nova localidade
   */
  public void editLocalidade(String localidade) {

    if (localidade != null) {

      this.setLocalidade(localidade);
    }
  }

  /**
   * Para ver os users que visitaram um PoI num intervalo de tempo
   * @param date1 - dia 1 do intervalo
   * @param date2 - ultimo dia do intervalo
   * @return um arraylist com todos os users que visitaram a PoI no intervalo de tempo
   */
  public ArrayList<User> userVisitedInTime(Date date1, Date date2) {

    ArrayList<User> userArrayList = new ArrayList<>();

    for (Date date : this.users.keys(date1, date2)) {

      userArrayList.add(this.users.get(date));
    }
    return userArrayList;
  }

  public ArrayList<PoI> top5PoiInTime(HashMap<Integer, PoI> pois, Date date1, Date date2) {

    HashMap<PoI,Integer> top5 = new HashMap<>();
    ArrayList<PoI> end = new ArrayList<>();
    ArrayList<PoI> top5PoIs = new ArrayList<>();    //array final

    int size;

    for (Map.Entry<Integer,PoI> set:pois.entrySet()){

      size = set.getValue().userVisitedInTime(date1,date2).size();
      top5.put(set.getValue(),size);
    }

    // Create a list from elements of HashMap
    List<Map.Entry<PoI,Integer>> list = new LinkedList<Map.Entry<PoI,Integer>>(top5.entrySet());
    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<PoI, Integer>>() {
      @Override
      public int compare(Map.Entry<PoI, Integer> o1, Map.Entry<PoI, Integer> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });
    // put data from sorted list to hashmap

    for (Map.Entry<PoI,Integer> aa:list){
      end.add(aa.getKey());

    }
    for (int i= end.size()-1;i>= end.size()-5;i--){
      top5PoIs.add(end.get(i));
    }
    return top5PoIs; }
  }



