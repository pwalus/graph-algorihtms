package graph.clients;

import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import graph.implementation.matrix.ListGraph;
import graph.implementation.matrix.MatrixGraph;
import graph.utilities.GraphIO;
import graph.utilities.GraphRandom;

public class RandomGraph {

    public static void main(String[] args) {
        GraphInterface graph = MatrixGraph.of(5, false);
        GraphRandom.generate(graph, 5);
        GraphIO.show(graph);
    }
}
