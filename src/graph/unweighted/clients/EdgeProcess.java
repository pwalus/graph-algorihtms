package graph.unweighted.clients;

import graph.general.Edge;
import graph.unweighted.api.AdjacencyListInterface;
import graph.unweighted.api.EdgeInterface;
import graph.unweighted.api.GraphInterface;

public class EdgeProcess {

    public static EdgeInterface[] edges(GraphInterface graph) {
        int edgeCount = 0;
        EdgeInterface[] edges = new Edge[graph.numberOfEdges()];
        for (int v = 0; v < graph.numberOfVertices(); v++) {
            AdjacencyListInterface adjacencyList = graph.getAdjacencyList(v);

            for (int w = adjacencyList.begin(); !adjacencyList.end(); w = adjacencyList.next()) {
                if (graph.isDirected() || v < w) {
                    edges[edgeCount++] = Edge.of(v, w);
                }
            }
        }

        return edges;
    }

    public static void main(String[] args) {

    }
}
