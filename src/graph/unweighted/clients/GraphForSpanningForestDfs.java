package graph.unweighted.clients;

import graph.unweighted.api.GraphInterface;
import graph.unweighted.implementation.general.Edge;
import graph.unweighted.implementation.matrix.MatrixGraph;
import graph.unweighted.utilities.GraphDfsSpanningTree;

public class GraphForSpanningForestDfs {

    protected Integer sum = 0;

    public static void main(String[] args) {
        GraphInterface graph = MatrixGraph.of(13, false);

        graph.insert(Edge.of(0, 1));
        graph.insert(Edge.of(0, 9));

        graph.insert(Edge.of(1, 9));
        graph.insert(Edge.of(1, 4));

        graph.insert(Edge.of(8, 11));

        graph.insert(Edge.of(2, 10));
        graph.insert(Edge.of(2, 7));

        graph.insert(Edge.of(10, 7));
        graph.insert(Edge.of(10, 6));

        graph.insert(Edge.of(6, 12));

        graph.insert(Edge.of(12, 3));
        graph.insert(Edge.of(12, 5));

        GraphDfsSpanningTree graphDfsSpanningTree = new GraphDfsSpanningTree(graph);
        System.out.println(graphDfsSpanningTree.parentOf(4));
        System.out.println(graphDfsSpanningTree.parentOf(1));
        System.out.println(graphDfsSpanningTree.parentOf(9));
    }
}
