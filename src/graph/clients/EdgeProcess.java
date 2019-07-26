package graph.clients;

import graph.implementation.general.Edge;
import graph.api.AdjacencyListInterface;
import graph.api.EdgeInterface;
import graph.api.GraphInterface;

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
