package graph.utilities;

import graph.api.AdjacencyListInterface;
import graph.api.EdgeInterface;
import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBfsSearch {

    private final Queue<EdgeInterface> vertexQueue;

    private final GraphInterface graph;

    private final boolean[] visited;

    private final int[] parentLink;

    private int count = 0;

    public GraphBfsSearch(GraphInterface graph) {
        this.graph = graph;
        this.vertexQueue = new LinkedList<>();
        this.visited = new boolean[graph.numberOfVertices()];
        this.parentLink = new int[graph.numberOfVertices()];

        for (int v = 0; v < graph.numberOfVertices(); v++) {
            if (!visited[v]) {
                search(Edge.of(v, v));
            }
        }
    }

    private void search(EdgeInterface edge) {
        vertexQueue.offer(edge);
        while (!vertexQueue.isEmpty()) {
            EdgeInterface adjacentEdge = vertexQueue.poll();
            int v = adjacentEdge.v();
            int w = adjacentEdge.w();
            visited[v] = true;
            parentLink[v] = w;
            AdjacencyListInterface adjacencyList = graph.getAdjacencyList(v);
            for (int t = adjacencyList.begin(); !adjacencyList.end(); t = adjacencyList.next()) {
                if (visited[t]) {
                    continue;
                }
                vertexQueue.add(Edge.of(t, v));
            }
        }
    }

    public int parent(int v) {
        return parentLink[v];
    }
}
