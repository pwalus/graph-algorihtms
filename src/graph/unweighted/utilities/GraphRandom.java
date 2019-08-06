package graph.unweighted.utilities;

import graph.general.Edge;
import graph.unweighted.api.GraphInterface;

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
