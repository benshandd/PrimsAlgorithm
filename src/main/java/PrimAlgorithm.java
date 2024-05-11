import java.util.List;
public class PrimAlgorithm {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);


        System.out.println("Minimum Spanning Tree:");
        List<Edge> spanningTree = graph.primMST();

        // Print the spanning tree
        for (Edge edge : spanningTree) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + " Weight: " + edge.weight);
        }
    }
}