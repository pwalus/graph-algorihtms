package graph.implementation.matrix;

import graph.api.AdjacencyListInterface;
import graph.api.EdgeInterface;
import graph.api.GraphInterface;

public class ListGraph implements GraphInterface {

    private final Node[] adjacencyList;

    private final boolean isDirected;

    private final int numberOfVertices;

    private int numberOfEdges = 0;

    public static GraphInterface of(int numberOfVertices, boolean isDirected) {
        return new ListGraph(numberOfVertices, isDirected);
    }

    private ListGraph(int numberOfVertices, boolean isDirected) {
        this.numberOfVertices = numberOfVertices;
        this.isDirected = isDirected;
        this.adjacencyList = new Node[numberOfVertices];
    }

    @Override
    public int numberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int numberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    @Override
    public void insert(EdgeInterface edge) {
        adjacencyList[edge.v()] = new Node(edge.w(), adjacencyList[edge.v()]);
        if (!isDirected) {
            adjacencyList[edge.w()] = new Node(edge.v(), adjacencyList[edge.w()]);
        }
        numberOfEdges++;
    }

    @Override
    public void remove(EdgeInterface edge) {
        removeByVertex(edge.v(), edge.w());
        if (!isDirected) {
            removeByVertex(edge.w(), edge.v());
        }
    }

    private void removeByVertex(int v, int w) {
        Node parent = null;
        Node actualNode = adjacencyList[v];

        while (actualNode != null) {
            if (actualNode.value == w) {
                if (parent == null) {
                    adjacencyList[v] = actualNode.next;
                } else {
                    parent.next = actualNode.next;
                }
            }

            parent = actualNode;
            actualNode = actualNode.next;
        }
    }

    @Override
    public boolean isEdge(int v, int w) {
        AdjacencyListInterface adjacencyList = getAdjacencyList(v);
        for (int vertex = adjacencyList.begin(); !adjacencyList.end(); vertex = adjacencyList.next()) {
            if (vertex == w) {
                return true;
            }
        }

        return false;
    }

    @Override
    public AdjacencyListInterface getAdjacencyList(int v) {
        return new AdjacencyArray(v);
    }

    private class Node {

        private final int value;

        private Node next;

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private class AdjacencyArray implements AdjacencyListInterface {

        private final int v;

        private Node actualNode;

        AdjacencyArray(int v) {
            this.v = v;
        }

        @Override
        public int begin() {
            actualNode = adjacencyList[v];
            return actualNode == null ? -1 : actualNode.value;
        }

        @Override
        public int next() {
            actualNode = actualNode.next;
            return actualNode == null ? -1 : actualNode.value;
        }

        @Override
        public boolean end() {
            return actualNode == null;
        }
    }
}
