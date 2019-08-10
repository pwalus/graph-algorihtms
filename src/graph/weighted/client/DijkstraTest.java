package graph.weighted.client;

import graph.general.Edge;
import graph.weighted.implementation.Graph;
import graph.weighted.utilities.BellmanFord;
import graph.weighted.utilities.Dijkstra;
import graph.weighted.utilities.PrintPath;

public class DijkstraTest {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.add(Edge.of(0, 1, 10));
        graph.add(Edge.of(0, 2, 5));

        graph.add(Edge.of(1, 2, 2));
        graph.add(Edge.of(1, 3, 1));

        graph.add(Edge.of(2, 1, 3));
        graph.add(Edge.of(2, 4, 7));
        graph.add(Edge.of(2, 3, 9));

        graph.add(Edge.of(3, 4, 4));

        graph.add(Edge.of(4, 3, 6));
        graph.add(Edge.of(4, 0, 7));

        Dijkstra dijkstra = new Dijkstra(graph);

        int[] path = dijkstra.search(0);
        System.out.print("3: ");
        PrintPath.print(path, 0, 3);
        System.out.print("4: ");
        PrintPath.print(path, 0, 4);
    }
}
