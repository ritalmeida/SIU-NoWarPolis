import java.io.Serializable;
import java.util.ArrayList;

public class Way extends Tag implements Serializable {

  public double km;

  public int time;

  public double getKm() {
    return km;
  }

  public void setKm(double km) {
    this.km = km;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public Way(String key, String value, ArrayList<PoI> poIArrayList, int sensors, String streetName, String streetType, String trafficVolume, double km, int time) {
    super(key, value, poIArrayList, sensors, streetName, streetType, trafficVolume);
    this.km = km;
    this.time = time;
  }

  public Way(String key, String value, ArrayList<PoI> poIArrayList, double km, int time) {
    super(key, value, poIArrayList);
    this.km = km;
    this.time = time;
  }


}