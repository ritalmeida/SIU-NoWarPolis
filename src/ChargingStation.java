import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

import java.io.Serializable;
import java.util.ArrayList;

public class ChargingStation extends PoI implements Serializable {


  public VehicleType vehicleType;

  public ChargingStation(double x, double y, int id, String localidade, String info, RedBlackBST<Date, User> users) {
    super(x, y, id, localidade, info, users);
  }
}