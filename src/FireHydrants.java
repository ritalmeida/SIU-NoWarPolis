import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

import java.io.Serializable;
import java.util.ArrayList;

public class FireHydrants extends PoI implements Serializable {


    public FireHydrants(double x, double y, int id, String localidade, String info, RedBlackBST<Date, User> users) {
        super(x, y, id, localidade, info, users);
    }
}