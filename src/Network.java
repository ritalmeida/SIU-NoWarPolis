//Uma rede, para gerir os nós

import edu.princeton.cs.algs4.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Network {

    public EdgeWeightedDigraph digraph;         //vai ser a nossa rede geral, de gestão de todos os sub grafos

    public ArrayList<Node> nodes;               //vértices dos grafos

    public ArrayList<Way> ways;                 //ramos dos grafos

    public ArrayList<SubGraph> subGraphs;       //os diversos grafos dentro da rede do grafo principal

    public Cost cost;

    public EdgeWeightedDigraph getDigraph() {
        return digraph;
    }

    public void setDigraph(EdgeWeightedDigraph digraph) {
        this.digraph = digraph;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Way> getWays() {
        return ways;
    }

    public void setWays(ArrayList<Way> ways) {
        this.ways = ways;
    }

    public ArrayList<SubGraph> getSubGraphs() {
        return subGraphs;
    }

    public void setSubGraphs(ArrayList<SubGraph> subGraphs) {
        this.subGraphs = subGraphs;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    //public int min, km;

    public Network() {

        this.nodes = new ArrayList<>();
        this.ways = new ArrayList<>();
        this.subGraphs = new ArrayList<>();
    }


    /**
     * Criar um sub grafo
     *
     * @param subGraph - subgrafo a ser criado
     */
    public void createSubGraph(SubGraph subGraph) {

        if (this.subGraphs.contains(subGraph)) {

            System.out.println("This sub graph already exists!");
            return;
        }
        this.subGraphs.add(subGraph);
        System.out.println("Sub graph created!");
    }

    public void createGraph() {

        this.digraph = new EdgeWeightedDigraph(this.nodes.size());
        System.out.println("Graph created!");
    }

    /**
     * Adicionar um novo no
     *
     * @param node - no a ser adicionado a nossa lista
     */
    public void addNode(Node node) {

        if (this.nodes.contains(node)) {

            System.out.println("The node already exists!");
            return;
        }

        this.nodes.add(node);
        //System.out.println("Node added!");
    }

    /**
     * Criar uma aresta
     *
     * @param way - aresta a ser criada
     */
    public void createEdge(Way way) {

        if (this.digraph != null) {

            this.digraph.addEdge(way);
            this.ways.add(way);

            System.out.println("New edge added: " + way.getN1() + " -> " + way.getN2() + " and weight: " + way.weight());
        }
    }

    /**
     * funçao generica
     *
     * @param g
     * @return
     */
    public boolean isConnected(EdgeWeightedDigraph g) {

        int s = 0;
        int flag = 0;
        DijkstraSP sp = new DijkstraSP(g, s);
        for (int t = 0; t < g.V(); t++) {
            if (!sp.hasPathTo(t)) {
                System.out.println("Not connected in -> " + t);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("The graph is connected!");
            return true;
        }
        System.out.println("The graph is not connected!");
        return false;
    }

    /**
     * funçao generica
     *
     * @param source      - no de origem
     * @param destination - no de destino
     * @param g           - grafo onde estao os nós
     * @param type        - o tipo de custo
     */
    public void shortestPathBetween(Node source, Node destination, EdgeWeightedDigraph g, Cost type) {

        cost = type;
        DijkstraSP dijkstraSP = new DijkstraSP(g, source.getId());

        if (dijkstraSP.hasPathTo(destination.getId())) {
            StdOut.printf("Cost between Node id %d to Node id %d is -> %.2f \n", source.getId(), destination.getId(), dijkstraSP.distTo(destination.getId()));
            for (DirectedEdge e : dijkstraSP.pathTo(destination.getId())) {
                StdOut.print((e.toString()));
            }
            StdOut.println();
        } else {
            StdOut.printf("%d to %d         no path\n", source.getId(), destination.getId());
        }
    }


    public void saveNodesToBin() {

        try {
            File fp = new File("/Users/Ritaa/Documents/FACULDADE/SIU-NoWarPolis/data/NodesBin.bin");
            FileOutputStream fos = new FileOutputStream(fp);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.nodes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}












