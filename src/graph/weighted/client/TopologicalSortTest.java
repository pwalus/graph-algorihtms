package graph.weighted.client;

import graph.general.Edge;
import graph.weighted.implementation.Graph;
import graph.weighted.utilities.TopologicalSort;

public class TopologicalSortTest {

    public static void main(String[] args) {
        Graph graph= new Graph(5);
        graph.add(Edge.of(0, 1, 5));
        graph.add(Edge.of(0, 2, 3));
        graph.add(Edge.of(1, 3, 3));
        graph.add(Edge.of(1, 4, 3));
        graph.add(Edge.of(2, 4, 3));

        TopologicalSort topologicalSort = new TopologicalSort(graph);
        topologicalSort.getTopologicalSort().forEachRemaining(System.out::println);
    }
}
