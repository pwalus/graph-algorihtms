package graph.unweighted.clients;

import graph.unweighted.api.GraphInterface;
import graph.unweighted.implementation.MatrixGraph;
import graph.unweighted.utilities.GraphIO;
import graph.unweighted.utilities.GraphRandom;

public class RandomGraph {

    public static void main(String[] args) {
        GraphInterface graph = MatrixGraph.of(5, false);
        GraphRandom.generate(graph, 5);
        GraphIO.show(graph);
    }
}
