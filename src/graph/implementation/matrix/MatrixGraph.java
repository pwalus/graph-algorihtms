package graph.implementation.matrix;

import graph.api.AdjacencyListInterface;
import graph.api.EdgeInterface;
import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import java.util.Arrays;

public class MatrixGraph implements GraphInterface {

    private final boolean[][] adjacencyMatrix;

    private int numberOfVertices;

    private final boolean isDirected;

    private int numberOfEdges = 0;

    public static GraphInterface of(int numberOfVertices, boolean isDirected) {
        return new MatrixGraph(numberOfVertices, isDirected);
    }

    private MatrixGraph(int numberOfVertices, boolean isDirected) {
        adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
        this.numberOfVertices = numberOfVertices;
        this.isDirected = isDirected;
    }

    @Override
    public int numberOfVertices() {
        return this.numberOfVertices;
    }

    @Override
    public int numberOfEdges() {
        return this.numberOfEdges;
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    @Override
    public void insert(EdgeInterface edge) {
        if (!adjacencyMatrix[edge.v()][edge.w()]) {
            numberOfEdges++;
        }
        adjacencyMatrix[edge.v()][edge.w()] = true;
        if (!isDirected()) {
            adjacencyMatrix[edge.w()][edge.v()] = true;
        }
    }

    @Override
    public void remove(EdgeInterface edge) {
        if (adjacencyMatrix[edge.v()][edge.w()]) {
            numberOfEdges--;
        }
        adjacencyMatrix[edge.v()][edge.w()] = false;
        if (!isDirected()) {
            adjacencyMatrix[edge.w()][edge.v()] = false;
        }
    }

    @Override
    public EdgeInterface getEdge(int v, int w) {
        return Edge.of(v, w);
    }

    @Override
    public AdjacencyListInterface getAdjacencyList(int v) {
        int[] adjacencyList = new int[numberOfVertices];
        Arrays.fill(adjacencyList, -1);

        int adjacencyListCount = 0;
        for (int i = 0; i < numberOfVertices; i++) {
            if (adjacencyMatrix[v][i]) {
                adjacencyList[adjacencyListCount++] = i;
            }
        }

        return MatrixAdjacencyList.of(adjacencyList);
    }
}
