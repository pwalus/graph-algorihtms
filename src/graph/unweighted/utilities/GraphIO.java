package graph.unweighted.utilities;

import graph.unweighted.api.AdjacencyListInterface;
import graph.unweighted.api.GraphInterface;

public class GraphIO {

    public static void show(GraphInterface graph) {
        for (int v = 0; v < graph.numberOfVertices(); v++) {
            AdjacencyListInterface adjacencyList = graph.getAdjacencyList(v);
            System.out.print(v + ": ");
            for (int w = adjacencyList.begin(); !adjacencyList.end(); w = adjacencyList.next()) {
                System.out.print(w + " ");
            }

            System.out.println();
        }
    }
}
