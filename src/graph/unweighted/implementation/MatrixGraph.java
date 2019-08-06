package graph.unweighted.implementation;

import graph.unweighted.api.AdjacencyListInterface;
import graph.unweighted.api.EdgeInterface;
import graph.unweighted.api.GraphInterface;

public class MatrixGraph implements GraphInterface {

    private final boolean[][] adjacencyMatrix;

    private final boolean isDirected;

    private final int numberOfVertices;

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
    public boolean isEdge(int v, int w) {
        return adjacencyMatrix[v][w];
    }

    @Override
    public AdjacencyListInterface getAdjacencyList(int v) {
        return new AdjacencyArray(v);
    }

    private class AdjacencyArray implements AdjacencyListInterface {

        private final int v;

        private int actualVertex = -1;

        AdjacencyArray(int v) {
            this.v = v;
        }

        @Override
        public int begin() {
            actualVertex = -1;
            return next();
        }

        @Override
        public int next() {
            for (actualVertex++; actualVertex < numberOfVertices; actualVertex++) {
                if (isEdge(v, actualVertex)) {
                    return actualVertex;
                }
            }

            return -1;
        }

        @Override
        public boolean end() {
            return actualVertex >= numberOfVertices;
        }
    }
}
