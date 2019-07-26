package graph.implementation.matrix;

import graph.api.AdjacencyListInterface;

public class MatrixAdjacencyList implements AdjacencyListInterface {

    private final int[] adjacencyList;

    private int actualElement = 0;

    public static AdjacencyListInterface of(int[] adjacencyList) {
        return new MatrixAdjacencyList(adjacencyList);
    }

    private MatrixAdjacencyList(int[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    @Override
    public int begin() {
        if (adjacencyList.length == 0) {
            return actualElement;
        }

        return adjacencyList[0];
    }

    @Override
    public int next() {
        return adjacencyList[actualElement++];
    }

    @Override
    public boolean end() {
        if (adjacencyList.length == 0) {
            return true;
        }

        return actualElement == adjacencyList.length || adjacencyList[actualElement] == 0;
    }
}
