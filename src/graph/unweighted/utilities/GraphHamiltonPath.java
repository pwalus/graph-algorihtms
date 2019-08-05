package graph.unweighted.utilities;

import graph.unweighted.api.AdjacencyListInterface;
import graph.unweighted.api.GraphInterface;

public class GraphHamiltonPath {

    private final GraphInterface graph;

    private final boolean found;

    private final boolean[] visited;

    private final int maxLength;

    public GraphHamiltonPath(GraphInterface graph, int v, int w, int maxLength) {
        this.graph = graph;
        this.visited = new boolean[graph.numberOfVertices()];
        this.maxLength = maxLength;
        this.found = search(v, w, 0);
    }

    private boolean search(int v, int w, int length) {
        if (v == w) {
            return length == maxLength;
        }

        visited[v] = true;
        AdjacencyListInterface adjacencyList = graph.getAdjacencyList(v);
        for (int t = adjacencyList.begin(); !adjacencyList.end(); t = adjacencyList.next()) {
            if (visited[t]) {
                continue;
            }

            if (search(t, w, length + 1)) {
                return true;
            }

            visited[t] = false;
        }

        return false;
    }

    public boolean found() {
        return found;
    }

}
