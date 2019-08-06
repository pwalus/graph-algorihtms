package graph.weighted.utilities;

import graph.unweighted.api.EdgeInterface;
import graph.weighted.implementation.Graph;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    private final Graph graph;

    private final Deque<Integer> topologicalSort = new ArrayDeque<>();

    private final boolean[] visited;

    public TopologicalSort(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getNumberOfVertices()];
        process();
    }

    private void process() {
        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        for (EdgeInterface edge : graph.getAdjacencyList(v)) {
            if (!visited[edge.w()]) {
                dfs(edge.w());
            }
        }

        topologicalSort.push(v);
    }


    public Iterator<Integer> getTopologicalSort() {
        return topologicalSort.iterator();
    }

}
