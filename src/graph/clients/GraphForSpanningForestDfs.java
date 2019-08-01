package graph.clients;

import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import graph.implementation.matrix.ListGraph;
import graph.implementation.matrix.MatrixGraph;
import graph.utilities.GraphDfs;
import graph.utilities.GraphDfsSpanningTree;

public class GraphForSpanningForestDfs {

    public static void main(String[] args) {
        GraphInterface graph = MatrixGraph.of(13 , false);

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
