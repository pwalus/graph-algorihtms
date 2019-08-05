package graph.unweighted.clients;

import graph.unweighted.api.GraphInterface;
import graph.unweighted.implementation.general.Edge;
import graph.unweighted.implementation.matrix.ListGraph;
import graph.unweighted.utilities.GraphHamiltonPath;
import graph.unweighted.utilities.GraphIO;

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
