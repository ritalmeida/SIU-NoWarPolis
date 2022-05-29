import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        milestone1();
    }

    public static void milestone1() {

        Admin admin = new Admin("Rita");

        Date d1 = new Date(20,04,2022);
        Date d2 = new Date(21, 04, 2022);
        Date d3 = new Date(22, 04, 2022);

        ArrayList<PoI> poIArrayList = new ArrayList<>();
        //node
        //Tag t1 = new Tag("1", "1", poIArrayList);
        //way
        //Tag t2 = new Tag("2", "1", 3, "Rua da Constituicao", "Rua", "movimentado");

        User filipa = new User(1, "Filipa Cunha");
        User catarina = new User(2, "Catarina Martins");
        User hugo = new User(3, "Hugo Silva");
        User rita = new User(3, "Rita Almeida");
        User dani = new User(3, "Daniela Oliveira");
        User roger = new User(3, "Rogerio Pereira");
        admin.addUserHash(filipa);
        admin.addUserHash(catarina);
        admin.addUserHash(hugo);
        admin.addUserHash(rita);
        admin.addUserHash(dani);
        admin.addUserHash(roger);

        admin.printUserHaspMap();

        rita.editUser(rita, "Ana Almeida");

        admin.printUserHaspMap();

        Location l1 = new Location(1234,2431);
        PoI p1 = new PoI(1,TypePoI.FireHydrants, "", l1);
        admin.addPoIHash(p1);
        //PoI p1 = new PoI(1, "Semaforo", l1);
        //admin.addPoI(p1);
        Location l2 = new Location(5436, -1247);
        PoI p2 = new PoI(2, TypePoI.TrafficLights, "", l2);
        admin.addPoIHash(p2);
        //PoI p2 = new PoI(2, "Estacao de carregamento", l2);
        //admin.addPoI(p2);
        Location l3 = new Location(1234, -6421);
        PoI p3 = new PoI(3, TypePoI.ChargingStation, "Cars",l3);
        admin.addPoIHash(p3);
        Location l4 = new Location(1432, 3400);
        PoI p4 = new PoI(4, TypePoI.TrafficLights, "", l4);
        admin.addPoIHash(p4);
        Location l5 = new Location(3042, -2345);
        PoI p5 = new PoI(5, TypePoI.FireHydrants, "", l5);
        admin.addPoIHash(p5);

        admin.printPoIHashMap();

        System.out.println(filipa.poiVisitedinTime(d1, d2));

        ArrayList<User> users;
        ArrayList<PoI> poIs;

        p1.addUserToPoi(filipa, d1);
        p2.addUserToPoi(catarina, d1);
        p1.addUserToPoi(rita, d2);
        poIs = filipa.poiVisitedinTime(d1, d3);
        for (PoI poI : poIs) {
            System.out.println(poI.toString());
        }

        Node n1 = new Node(1, null, p1);
        Node n2 = new Node(2, null, p2);
        Node n3 = new Node(3, null, p3);
        Node n4 = new Node(4, null, p4);
        Node n5 = new Node(5, null, p5);
        Way w1 = new Way(1, n1, n2, 5, null);
        Way w2 = new Way(2, n1, n3, 3, null);
        Way w3 = new Way(3, n3, n4, 10, null);
        Way w4 = new Way(4, n2, n5, 7.4, null);
        Way w5 = new Way(5, n4, n5, 5.2, null);

        Network network = new Network();
        network.addNode(n1);
        network.addNode(n2);
        network.addNode(n3);
        network.addNode(n4);
        network.addNode(n5);
        network.createEdge(w1);
        network.createEdge(w2);
        network.createEdge(w3);
        network.createEdge(w4);
        network.createEdge(w5);
        network.createGraph();
        network.isConnected(network.getDigraph());

    }

}
