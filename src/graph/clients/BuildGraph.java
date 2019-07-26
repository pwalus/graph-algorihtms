package graph.clients;

import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import graph.implementation.matrix.MatrixGraph;

public class BuildGraph {

    public static void main(String[] args) {
        GraphInterface graph = MatrixGraph.of(5, false);

        graph.insert(Edge.of(0,1));
        graph.insert(Edge.of(0,2));
        graph.insert(Edge.of(0,3));

        graph.insert(Edge.of(1,0));
        graph.insert(Edge.of(1,3));

        graph.insert(Edge.of(2,0));
        graph.insert(Edge.of(2,4));

        graph.insert(Edge.of(3,0));
        graph.insert(Edge.of(3,2));
        graph.insert(Edge.of(3,4));

        graph.insert(Edge.of(4,2));
        graph.insert(Edge.of(4,3));


    }
}
