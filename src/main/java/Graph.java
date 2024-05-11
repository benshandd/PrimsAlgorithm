import java.util.*;
class Graph {
    int vertices;
    List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(new Edge(destination, source, weight)); // for undirected graph
    }

    // Prim's algorithm
    public List<Edge> primMST() {
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Edge> fringe = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Set<Integer> visitedNodes = new HashSet<>();
        List<Edge> spanningTree = new ArrayList<>();

        // Start with node 0
        visitedNodes.add(0);
        visited[0] = true;

        while (visitedNodes.size() < vertices) {
            int minWeight = Integer.MAX_VALUE;
            Edge minEdge = null;

            // Find the minimum edge
            for (int node : visitedNodes) {
                for (Edge edge : adjacencyList.get(node)) {
                    if (!visited[edge.destination] && edge.weight < minWeight) {
                        minWeight = edge.weight;
                        minEdge = edge;
                    }
                }
            }

            // Add the minimum edge to the spanning tree
            if (minEdge != null) {
                visited[minEdge.destination] = true;
                visitedNodes.add(minEdge.destination);
                fringe.addAll(adjacencyList.get(minEdge.destination));
                spanningTree.add(minEdge);
            }
        }

        return spanningTree;
    }
}