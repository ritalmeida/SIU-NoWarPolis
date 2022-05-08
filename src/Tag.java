import java.util.ArrayList;

public class Tag {

    public String key;

    public String value;

    public ArrayList<PoI> poIArrayList = new ArrayList<>();

    public int sensors;

    public String streetName;

    public String streetType;

    public String TrafficVolume;

    public Tag(String key, String value, int sensors, String streetName, String streetType, String trafficVolume) {
        this.key = key;
        this.value = value;
        this.sensors = sensors;
        this.streetName = streetName;
        this.streetType = streetType;
        TrafficVolume = trafficVolume;
    }

    public Tag(String key, String value, ArrayList<PoI> poIArrayList) {
        this.key = key;
        this.value = value;
        this.poIArrayList = poIArrayList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<PoI> getPoIArrayList() {
        return poIArrayList;
    }

    public void setPoIArrayList(ArrayList<PoI> poIArrayList) {
        this.poIArrayList = poIArrayList;
    }

    public int getSensors() {
        return sensors;
    }

    public void setSensors(int sensors) {
        this.sensors = sensors;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getTrafficVolume() {
        return TrafficVolume;
    }

    public void setTrafficVolume(String trafficVolume) {
        TrafficVolume = trafficVolume;
    }


}