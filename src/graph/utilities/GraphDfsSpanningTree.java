package graph.utilities;

import graph.api.AdjacencyListInterface;
import graph.api.GraphInterface;
import java.util.Arrays;

public class GraphDfsSpanningTree {

    private final boolean[] visited;

    private final int[] parentLink;

    private final GraphInterface graph;

    public GraphDfsSpanningTree(GraphInterface graph) {
        this.visited = new boolean[graph.numberOfVertices()];
        this.parentLink = new int[graph.numberOfVertices()];
        this.graph = graph;
        search();
    }

    protected void search() {
        for (int v = 0; v < graph.numberOfVertices(); v++) {
            if (!visited[v]) {
                searchFrom(v, v);
            }
        }
    }

    private void searchFrom(int v, int parent) {
        visited[v] = true;
        parentLink[v] = parent;
        AdjacencyListInterface adjacencyList = graph.getAdjacencyList(v);
        for (int w = adjacencyList.begin(); !adjacencyList.end(); w = adjacencyList.next()) {
            if (visited[w]) {
                continue;
            }
            searchFrom(w, v);
        }
    }

    public int parentOf(int v) {
        return parentLink[v];
    }
}


