import java.util.ArrayList;

//pares de chave/valor

public class Tag {

    public String key;

    public String value;

    public ArrayList<PoI> poIArrayList = new ArrayList<>();


    public Tag(String key, String value) {
        this.key = key;
        this.value = value;
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

    @Override
    public String toString() {
        return "Tag{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}