package graph.utilities;

import graph.api.AdjacencyListInterface;
import graph.api.GraphInterface;

public class GraphPath {

    private final GraphInterface graph;

    private final boolean found;

    private final boolean[] visited;

    public GraphPath(GraphInterface graph, int v, int w) {
        this.graph = graph;
        this.visited = new boolean[graph.numberOfVertices()];
        this.found = search(v, w);
    }

    private boolean search(int v, int w) {
        if (v == w) {
            return true;
        }

        visited[v] = true;
        AdjacencyListInterface adjacencyList = graph.getAdjacencyList(v);
        for (int t = adjacencyList.begin(); !adjacencyList.end(); t = adjacencyList.next()) {
            if (visited[t]) {
                continue;
            }

            if (search(t, w)) {
                return true;
            }
        }

        return false;
    }

    public boolean found() {
        return found;
    }

}
