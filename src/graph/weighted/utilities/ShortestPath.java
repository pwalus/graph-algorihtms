package graph.weighted.utilities;

import graph.unweighted.api.EdgeInterface;
import graph.weighted.implementation.Graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.function.Consumer;

public class ShortestPath {

    private final Graph graph;

    private final int[] verticesParent;

    private final float[] verticesWeight;

    public ShortestPath(Graph graph) {
        this.graph = graph;
        verticesParent = new int[graph.getNumberOfVertices()];
        verticesWeight = new float[graph.getNumberOfVertices()];
        Arrays.fill(verticesWeight, Float.POSITIVE_INFINITY);
        verticesWeight[0] = 0;
        process();
    }

    private void process() {
        Iterator<Integer> topologicalSort = new TopologicalSort(graph).getTopologicalSort();
        topologicalSort.forEachRemaining(new TopologicalSortRelaxation());
        System.out.println("end");
    }

    public int[] getVerticesParent() {
        return verticesParent;
    }

    private class TopologicalSortRelaxation implements Consumer<Integer> {

        @Override
        public void accept(Integer vertex) {
            for (EdgeInterface edge : graph.getAdjacencyList(vertex)) {
                relax(edge);
            }
        }

        private void relax(EdgeInterface edge) {
            if (verticesWeight[edge.w()] > verticesWeight[edge.v()] + edge.weight()) {
                verticesParent[edge.w()] = edge.v();
                verticesWeight[edge.w()] = verticesWeight[edge.v()] + edge.weight();
            }
        }
    }

}
