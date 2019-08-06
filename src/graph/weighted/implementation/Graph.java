package graph.weighted.implementation;

import graph.unweighted.api.EdgeInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Graph {

    private final Map<Integer, List<EdgeInterface>> adjacencyList = new HashMap<>();

    private final int numberOfVertices;

    private int numberOfEdges = 0;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        for (int v = 0; v < numberOfVertices; v++) {
            adjacencyList.put(v, new LinkedList<>());
        }
    }

    public void add(EdgeInterface edge) {
        adjacencyList.get(edge.v()).add(edge);
        numberOfEdges++;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public List<EdgeInterface> getAdjacencyList(Integer v) {
        return adjacencyList.get(v);
    }
}
