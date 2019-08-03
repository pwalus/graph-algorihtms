package graph.clients;

import graph.api.GraphInterface;
import graph.implementation.general.Edge;
import graph.implementation.matrix.ListGraph;
import graph.utilities.GraphBfsSearch;
import graph.utilities.GraphDfs;

public class GraphForBfs {

    public static void main(String[] args) {
        GraphInterface graph = ListGraph.of(8, false);

        graph.insert(Edge.of(0, 2));
        graph.insert(Edge.of(0, 5));
        graph.insert(Edge.of(0, 7));

        graph.insert(Edge.of(2, 6));

        graph.insert(Edge.of(6, 4));

        graph.insert(Edge.of(4, 7));
        graph.insert(Edge.of(4, 3));
        graph.insert(Edge.of(4, 5));

        graph.insert(Edge.of(5, 3));

        graph.insert(Edge.of(1, 7));

        GraphBfsSearch graphBfsSearch = new GraphBfsSearch(graph);
        printParentLink(graph, graphBfsSearch);
    }

    private static void printParentLink(GraphInterface graph, GraphBfsSearch graphBfsSearch) {
        for (int v = 0; v < graph.numberOfVertices(); v++) {
            System.out.print(v + ": ");
            int parent = -1;
            int tmpNode = v;
            while (parent != tmpNode) {
                parent = graphBfsSearch.parent(tmpNode);
                System.out.print(parent + " ");
                tmpNode = parent;
                parent = graphBfsSearch.parent(tmpNode);
            }
            System.out.println();
        }
    }
}
