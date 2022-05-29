import java.io.Serializable;
import java.util.ArrayList;

//nós ou vértices, pontos ou interseções de vias como ruas ou avenidas

public class Node implements Serializable {

    public int id;

    public Location location;

    public PoI poI;

    public ArrayList<Tag> tags;     //pares de chave/valor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PoI getPoI() {
        return poI;
    }

    public void setPoI(PoI poI) {
        this.poI = poI;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public Node(int id, Location location) {

        this.id = id;
        this.location = location;
        this.tags = new ArrayList<>();
        this.poI = null;
    }

    public Node(int id, ArrayList<Tag> tags, PoI poI) {

        this.id = id;
        this.tags = tags;
        this.poI = poI;
    }

    public Node(int id, Location location, PoI poI, ArrayList<Tag> tags) {
        this.id = id;
        this.location = location;
        this.poI = poI;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", location=" + location +
                ", poI=" + poI +
                ", tags=" + tags +
                '}';
    }

    /**
     * Remove uma tag do nosso array de tags
     * @param tag - a tag a remover
     */
    public void removeTag(Tag tag) {

        if (this.tags.contains(tag)) {

            this.tags.remove(tag);
            System.out.println("Tag removed!");
        }
    }
}














