package graph.weighted.client;

import graph.general.Edge;
import graph.weighted.implementation.Graph;
import graph.weighted.utilities.PrintPath;
import graph.weighted.utilities.ShortestPath;
import graph.weighted.utilities.TopologicalSort;

public class ShortestPathDagTest {

    public static void main(String[] args) {
        Graph graph= new Graph(7);
        graph.add(Edge.of(0, 1, 1));
        graph.add(Edge.of(0, 2, 5));
        graph.add(Edge.of(1, 3, 4));
        graph.add(Edge.of(1, 4, 1));
        graph.add(Edge.of(2, 4, 2));
        graph.add(Edge.of(3, 5, 10));
        graph.add(Edge.of(4, 5, 3));
        graph.add(Edge.of(4, 6, 1));

        ShortestPath shortestPath = new ShortestPath(graph);
        PrintPath.print(shortestPath.getVerticesParent(), 0, 1);
        PrintPath.print(shortestPath.getVerticesParent(), 0, 2);
        PrintPath.print(shortestPath.getVerticesParent(), 0, 3);
        PrintPath.print(shortestPath.getVerticesParent(), 0, 4);
        PrintPath.print(shortestPath.getVerticesParent(), 0, 5);
        PrintPath.print(shortestPath.getVerticesParent(), 0, 6);
    }
}
