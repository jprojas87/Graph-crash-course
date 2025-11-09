package graph;

public class Main {
    public static void main(String[] args) {
        Graph transmilleno = new Graph(true, true);
        Vertex estacionBanderas = transmilleno.addVertex("Banderas");
        Vertex estacionRicaurte = transmilleno.addVertex("Ricaurte");

        transmilleno.addEdge(estacionBanderas, estacionRicaurte, 1000);

        transmilleno.print();
    }
}

