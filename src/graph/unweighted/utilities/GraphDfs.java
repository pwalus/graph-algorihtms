package graph.unweighted.utilities;

import graph.unweighted.api.AdjacencyListInterface;
import graph.unweighted.api.GraphInterface;
import java.util.Arrays;

public class GraphDfs {

    private final boolean[] visited;

    private final int[] visitedVertexOrder;

    private final GraphInterface graph;

    private int order = 0;

    public GraphDfs(GraphInterface graph) {
        this.visited = new boolean[graph.numberOfVertices()];
        this.visitedVertexOrder = new int[graph.numberOfVertices()];
        this.graph = graph;
    }

    public void startFrom(int v) {
        walk(v);

        System.out.println(Arrays.toString(visitedVertexOrder));
    }

    protected void walk(int v) {
        visited[v] = true;
        visitedVertexOrder[order++] = v;
        AdjacencyListInterface adjacencyList = graph.getAdjacencyList(v);
        for (int w = adjacencyList.begin(); !adjacencyList.end(); w = adjacencyList.next()) {
            if (visited[w]) {
                continue;
            }

            walk(w);
        }
    }
}


