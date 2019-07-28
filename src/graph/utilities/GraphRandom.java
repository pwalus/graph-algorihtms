package graph.utilities;

import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import java.util.Random;

public class GraphRandom {

    public static GraphInterface generate(GraphInterface graph, int numberOfEdges) {
        for (int i = 0; i < numberOfEdges; i++) {
            int v = (int) (Math.random() * graph.numberOfVertices());
            int w = (int) (Math.random() * graph.numberOfVertices());
            graph.insert(Edge.of(v, w));
        }

        return graph;
    }

}
