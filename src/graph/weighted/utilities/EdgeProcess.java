package graph.weighted.utilities;

import graph.general.Edge;
import graph.unweighted.api.AdjacencyListInterface;
import graph.unweighted.api.EdgeInterface;
import graph.unweighted.api.GraphInterface;
import graph.weighted.implementation.Graph;
import java.util.ArrayList;
import java.util.List;

public class EdgeProcess {

    public static List<EdgeInterface> edges(Graph graph) {
        List<EdgeInterface> edges = new ArrayList<>();

        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            edges.addAll(graph.getAdjacencyList(v));
        }

        return edges;
    }
}
