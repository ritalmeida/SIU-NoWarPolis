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
        Tag t1 = new Tag("1", "1", poIArrayList);
        //way
        Tag t2 = new Tag("2", "1", 3, "Rua da Constituicao", "Rua", "movimentado");


        Location l1 = new Location(1234,2431);
        PoI p1 = new PoI(1, "Semaforo", l1);
        admin.addPoI(p1);

        Location l2 = new Location(5436, -1247);
        PoI p2 = new PoI(2, "Estacao de carregamento", l2);
        admin.addPoI(p2);

        User u1 = new User(1, "Filipa Cunha");
        User u2 = new User(2, "Catarina Martins");
        User u3 = new User(3, "Hugo Silva");
        admin.addUser(u1);
        admin.addUser(u2);
        admin.addUser(u3);
    }

}
