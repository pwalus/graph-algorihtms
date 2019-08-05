package graph.unweighted.clients;

import graph.unweighted.api.GraphInterface;
import graph.unweighted.implementation.general.Edge;
import graph.unweighted.implementation.matrix.ListGraph;
import graph.unweighted.utilities.GraphIO;
import graph.unweighted.utilities.GraphPath;

public class BuildGraph {

    public static void main(String[] args) {
        GraphInterface graph = ListGraph.of(6, false);

        graph.insert(Edge.of(0, 1));
        graph.insert(Edge.of(0, 2));
        graph.insert(Edge.of(0, 3));

        graph.insert(Edge.of(1, 0));
        graph.insert(Edge.of(1, 3));

        graph.insert(Edge.of(2, 0));
        graph.insert(Edge.of(2, 4));

        graph.insert(Edge.of(3, 0));
        graph.insert(Edge.of(3, 1));
        graph.insert(Edge.of(3, 4));

        graph.insert(Edge.of(4, 2));
        graph.insert(Edge.of(4, 3));

        GraphIO.show(graph);

        GraphPath graphPath = new GraphPath(graph, 1, 4);

        System.out.println(graphPath.found());
    }
}
