import edu.princeton.cs.algs4.RedBlackBST;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

  public int id;

  public String name;

  public RedBlackBST<Date, PoI> poIs;

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

  //
  //
  //

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

}