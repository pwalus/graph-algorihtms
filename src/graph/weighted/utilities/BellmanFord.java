package graph.weighted.utilities;

import graph.unweighted.api.EdgeInterface;
import graph.weighted.utilities.EdgeProcess;
import graph.weighted.implementation.Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

    private final Graph graph;

    private final List<Float> verticesWeight;

    private final int[] verticesParent;

    public BellmanFord(Graph graph) {
        this.graph = graph;
        verticesWeight = new ArrayList<>(graph.getNumberOfVertices());
        verticesParent = new int[graph.getNumberOfVertices()];
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            verticesWeight.add(i, Float.POSITIVE_INFINITY);
        }

        verticesWeight.set(0, (float) 0);
    }

    public boolean search() {
        List<EdgeInterface> edges = EdgeProcess.edges(graph);

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            for (EdgeInterface edge : edges) {
                relax(edge);
            }
        }

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            for (EdgeInterface edge : edges) {
                if (verticesWeight.get(edge.w()) > verticesWeight.get(edge.v()) + edge.weight()) {
                    return false;
                }
            }
        }

        return true;
    }

    private void relax(EdgeInterface edge) {
        int w = edge.w();
        int v = edge.v();
        float weight = edge.weight();

        if (verticesWeight.get(w) + weight < verticesWeight.get(v)) {
            verticesWeight.set(v, verticesWeight.get(w) + weight);
            verticesParent[v] = w;
        }
    }

    public int[] getVerticesParent() {
        return verticesParent;
    }
}
