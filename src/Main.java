import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        teste();
    }

    public static void teste() {

        Admin admin = new Admin("Rita");

        Date d1 = new Date(20,04,2022);
        Date d2 = new Date(21, 04, 2022);
        Date d3 = new Date(22, 04, 2022);

        User filipa = new User(1, "Filipa Cunha");
        User catarina = new User(2, "Catarina Martins");
        User hugo = new User(3, "Hugo Silva");
        User rita = new User(4, "Rita Almeida");
        User dani = new User(5, "Daniela Oliveira");
        User roger = new User(6, "Rogerio Pereira");
        admin.addUserHash(filipa);
        admin.addUserHash(catarina);
        admin.addUserHash(hugo);
        admin.addUserHash(rita);
        admin.addUserHash(dani);
        admin.addUserHash(roger);

        admin.printUserHaspMap();
        /*rita.editUser(rita, "Ana Almeida");
        System.out.println("Edit 'Rita Almeida' to 'Ana Almeida'...");
        admin.printUserHaspMap();
        admin.removeUser(hugo);
        System.out.println("Remove user 'Hugo'...");
        admin.printUserHaspMap();
        System.out.println("");*/


        Location l1 = new Location(1234,2431);
        PoI p1 = new PoI(1,TypePoI.FireHydrants, "", l1);
        admin.addPoIHash(p1);
        Location l2 = new Location(5436, -1247);
        PoI p2 = new PoI(2, TypePoI.TrafficLights, "", l2);
        admin.addPoIHash(p2);
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
        /*System.out.println("Remove PoI2...");
        admin.removePoI(p2);
        admin.printPoIHashMap();*/
/*
        //Requisito 5 a)
        filipa.addPoItoUser(p1, d1);
        filipa.addPoItoUser(p5, d2);
        filipa.addPoItoUser(p1, d2);
        catarina.addPoItoUser(p2, d2);
        rita.addPoItoUser(p2, d2);
        hugo.addPoItoUser(p2, d1);
        hugo.addPoItoUser(p2, d2);
        hugo.addPoItoUser(p1, d3);
        dani.addPoItoUser(p2, d2);
        roger.addPoItoUser(p2, d3);
        dani.addPoItoUser(p3, d2);
        ArrayList<PoI> poIArrayListAux;
        poIArrayListAux = filipa.poiVisitedinTime(d1, d3);
        System.out.println("PoIs visited by Filipa between date 1 (20,04,2022) and date 3 (22, 04, 2022): ");
        for (PoI poI : poIArrayListAux) {

            System.out.println(poI.toString());
        }
        System.out.println("");

        //Requisito 5 b)
        System.out.println("PoIs not visited by Catarina (Just visited P2): ");
        System.out.println(catarina.poiNotVisitedInTime(admin.getPoIs(), d1, d2).toString());
        System.out.println("");

        //Requisito 5 c)
        p1.addUserToPoi(rita, d1);
        p2.addUserToPoi(hugo, d3);
        p2.addUserToPoi(dani, d2);
        p2.addUserToPoi(rita, d1);
        p2.addUserToPoi(filipa, d1);
        p2.addUserToPoi(catarina, d2);
        p2.addUserToPoi(filipa, d1);
        p1.addUserToPoi(roger, d2);
        ArrayList<User> userArrayListAux;
        userArrayListAux = p2.userVisitedInTime(d1, d3);
        System.out.println("Users that visited PoI2 between date 1 (20,04,2022) and date 3 (22, 04, 2022): ");
        for (User user : userArrayListAux) {

            System.out.println(user.toString());
        }
        System.out.println("");

        //Requisito 5 d) nao funciona
        //System.out.println(admin.poiNotVisitedInTime(admin.poIs, d1, d3).toString());

        //Requisito 5 e)
        System.out.println("Top 5 Users that visited more PoIs: ");
        System.out.println(filipa.top5UsersinPoiInTime(admin.getUsers(), d1, d3));
        System.out.println("");

        //Requisito 5 f)
        System.out.println("Top 5 PoIs visited: ");
        System.out.println(p1.top5PoiInTime(admin.getPoIs(), d1, d3).toString());
        System.out.println("");*/

        //Requisito 6
        /*p1.addUserToPoi(rita, d1);
        rita.addPoItoUser(p1, d1);
        p1.addUserToPoi(filipa, d3);
        filipa.addPoItoUser(p1, d3);
        p1.addUserToPoi(hugo, d2);
        hugo.addPoItoUser(p1, d2);
        p2.addUserToPoi(dani, d3);
        dani.addPoItoUser(p2, d3);

        admin.now();*/

        System.out.println("");

        Tag tag1 = new Tag("1", "tag1");
        Tag tag2 = new Tag("2", "tag2");
        ArrayList<Tag> tagArrayList = new ArrayList<>();
        tagArrayList.add(tag1);
        tagArrayList.add(tag2);

        Node n1 = new Node(1,null, p1);
        Node n2 = new Node (2,tagArrayList, p2);
        Node n3 = new Node (3,null, p3);
        Node n4 = new Node(4,tagArrayList, p4);
        Node n5 = new Node(0,null, p5);

        Way w1 = new Way(1, n1, n2,7.3,null);
        Way w2 = new Way(2, n2, n3,5,null);
        Way w3 = new Way(3, n3, n4,2.5,null);
        Way w4 = new Way(4, n4, n5,3,null);
        Way w5 = new Way(0, n5, n1,10,null);
        Way w6 = new Way(5, n2, n4,1,null);

        Network network = new Network();

        network.addNode(n1);
        network.addNode(n2);
        network.addNode(n3);
        network.addNode(n4);
        network.addNode(n5);
        //network.createGraph();

        network.createEdge(w1);
        network.createEdge(w2);
        network.createEdge(w3);
        network.createEdge(w4);
        network.createEdge(w5);
        network.createEdge(w6);

        System.out.println("");

        //Requisito 11 c)
        //network.isConnected(network.getDigraph());

        //Requisito 11 a)
        /*System.out.println("");
        System.out.println("Shortest Path (in distance) Between N2 and N5: ");
        network.shortestPathBetween(n2, n5, network.getDigraph(), Cost.DISTANCE);
        System.out.println("\nShortest Path (in time) Between N1 and N4: ");
        network.shortestPathBetween(n1, n4, network.getDigraph(), Cost.TIME);*/


        //FICHEIROS
        //output todos users e pois
        //admin.userPoitxt();
        //network.saveNodesToBin();

    }

}
