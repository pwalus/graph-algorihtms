package graph.clients;

import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import graph.implementation.matrix.ListGraph;
import graph.implementation.matrix.MatrixGraph;
import graph.utilities.GraphHamiltonPath;
import graph.utilities.GraphIO;
import graph.utilities.GraphPath;

public class HamiltonGraph {

    public static void main(String[] args) {
        GraphInterface graph = ListGraph.of(7, false);

        graph.insert(Edge.of(0, 1));
        graph.insert(Edge.of(0, 2));
        graph.insert(Edge.of(0, 5));
        graph.insert(Edge.of(0, 6));

        graph.insert(Edge.of(1, 2));

        graph.insert(Edge.of(2, 3));
        graph.insert(Edge.of(2, 4));

        graph.insert(Edge.of(3, 4));

        graph.insert(Edge.of(4, 5));
        graph.insert(Edge.of(4, 6));

        GraphIO.show(graph);
        GraphHamiltonPath graphPath = new GraphHamiltonPath(graph, 0, 6, 5);

        System.out.println(graphPath.found());
    }
}
