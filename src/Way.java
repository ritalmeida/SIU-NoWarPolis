import edu.princeton.cs.algs4.DirectedEdge;

import java.io.Serializable;
import java.util.ArrayList;

//arestas ou ramos caracterizados com diferentes tipos de pesos (distância e tempo)

public class Way extends DirectedEdge implements Serializable {

  public int id;

  public Node n1, n2;

  public ArrayList<Tag> tags;

  public Way(int id, Node n1, Node n2, double weight, ArrayList<Tag> tags) {

    super(n1.getId(), n2.getId(), weight);
    this.id = id;
    this.n1 = n1;
    this.n2 = n2;
    this.tags = tags;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Node getN1() {
    return n1;
  }

  public void setN1(Node n1) {
    this.n1 = n1;
  }

  public Node getN2() {
    return n2;
  }

  public void setN2(Node n2) {
    this.n2 = n2;
  }

  public ArrayList<Tag> getTags() {
    return tags;
  }

  public void setTags(ArrayList<Tag> tags) {
    this.tags = tags;
  }

  public Way(int v, int w, double weight, int id, Node n1, Node n2, ArrayList<Tag> tags) {

    super(n1.getId(), n2.getId(), weight);
    this.id = id;
    this.n1 = n1;
    this.n2 = n2;
    this.tags = tags;
  }

  public void addTag(Tag tag) {

    this.tags.add(tag);
    System.out.println("Tag added!");
  }

  public void removeTag(Tag tag) {

    if (this.tags.contains(tag)) {

      this.tags.remove(tag);
      System.out.println("Tag removed!");
    }
  }

  @Override
  public String toString() {
    return "Way{" +
            "id=" + id +
            ", n1=" + n1 +
            ", n2=" + n2 +
            ", tags=" + tags +
            '}';
  }
}