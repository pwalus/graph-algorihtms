package graph.clients;

import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import graph.implementation.matrix.ListGraph;
import graph.implementation.matrix.MatrixGraph;
import graph.utilities.GraphDfs;
import graph.utilities.GraphIO;
import graph.utilities.GraphPath;

public class GraphForDfs {

    public static void main(String[] args) {
        GraphInterface graph = ListGraph.of(8 , false);

        graph.insert(Edge.of(0, 2));
        graph.insert(Edge.of(0, 5));
        graph.insert(Edge.of(0, 7));

        graph.insert(Edge.of(2, 6));

        graph.insert(Edge.of(6, 4));

        graph.insert(Edge.of(4, 7));
        graph.insert(Edge.of(4, 3));
        graph.insert(Edge.of(4, 5));

        graph.insert(Edge.of(5, 3));

        graph.insert(Edge.of(1, 7));

        new GraphDfs(graph).startFrom(0);
    }
}
