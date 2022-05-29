import java.io.Serializable;

public class Location implements Serializable {

    public double x;

    public double y;

    public String localidade;

    public TypePoI typePoI;

    public double getX() {
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
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public TypePoI getTypePoI() {
        return typePoI;
    }

    public void setTypePoI(TypePoI typePoI) {
        this.typePoI = typePoI;
    }

    public Location(double x, double y, String localidade, TypePoI typePoI) {
        this.x = x;
        this.y = y;
        this.localidade = localidade;
        this.typePoI = typePoI;
    }

    public Location(double x, double y, String localidade) {
        this.x = x;
        this.y = y;
        this.localidade = localidade;
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", localidade='" + localidade + '\'' +
                '}';
    }

    //
    //
    //
    //


    /**
     * Calcular a distancia entre 2 localizações
     * @param location2 - a 2ª localização
     * @return a distancia
     */
    public double getDistanceFromLocations(Location location2) {

        return Math.sqrt((location2.getY() - this.y) * (location2.getY() - this.y) + (location2.getX() - this.x) * (location2.getX() - this.x));
    }

    /**
     * Calcular a distancia baseado nas coordenadas
     * @param x - latitude
     * @param y - longitude
     * @return a distancia
     */
    public double getDistanceFromCoordinates(int x, int y) {

        return Math.sqrt((y - this.y) * (y - this.y) + (x - this.x) * (x - this.x));
    }
}
