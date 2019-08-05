package graph.unweighted.utilities.shortest_path;

import graph.unweighted.api.GraphInterface;
import graph.unweighted.clients.EdgeProcess;
import java.util.Arrays;

public class BellmanFord {

    private final float[] vertexWeight;

    private final int[] vertexParent;

    private final GraphInterface graph;

    public BellmanFord(GraphInterface graph) {
        this.graph = graph;
        this.vertexParent = new int[graph.numberOfVertices()];
        this.vertexWeight = new float[graph.numberOfVertices()];
        Arrays.fill(this.vertexWeight, Float.MAX_VALUE);
    }

    public boolean search(int v) {
        vertexWeight[v] = 0;
        EdgeProcess.edges(graph);
        for ()
    }

    public void relax(int v, int w, float weight) {
        if (vertexWeight[w] > vertexWeight[v] + weight) {
            vertexWeight[w] = vertexWeight[v] + weight;
            vertexParent[w] = v;
        }
    }


}
