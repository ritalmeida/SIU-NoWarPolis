import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class TrafficLights extends PoI {

    public Location location;

    public TrafficLights(int id, String localidade, String info, RedBlackBST<Date, User> users, Location location) {
        super(id, localidade, info, users);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}