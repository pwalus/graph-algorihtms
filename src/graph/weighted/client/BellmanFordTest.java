package graph.weighted.client;

import graph.general.Edge;
import graph.weighted.implementation.Graph;
import graph.weighted.utilities.BellmanFord;

public class BellmanFordTest {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.add(Edge.of(0, 1, 6));
        graph.add(Edge.of(0, 2, 7));

        graph.add(Edge.of(1, 2, 8));

        graph.add(Edge.of(1, 3, 5));
        graph.add(Edge.of(3, 1, -2));
        graph.add(Edge.of(1, 4, -4));

        graph.add(Edge.of(2, 3, -3));
        graph.add(Edge.of(2, 4, 9));

        graph.add(Edge.of(4, 0, 2));
        graph.add(Edge.of(4, 3, 7));

        BellmanFord bellmanFord = new BellmanFord(graph);

        System.out.println(bellmanFord.search());
        bellmanFord.printPath(0, 3);
    }
}
