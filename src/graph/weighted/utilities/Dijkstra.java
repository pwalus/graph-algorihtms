package graph.weighted.utilities;

import graph.unweighted.api.EdgeInterface;
import graph.weighted.implementation.Graph;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class Dijkstra {

    private final Graph graph;

    private final PriorityQueue<Node> queue;

    private final int[] verticesParent;

    private final Float[] verticesWeight;

    private final boolean[] visited;

    public Dijkstra(Graph graph) {
        this.graph = graph;
        queue = new PriorityQueue<>(2 * graph.getNumberOfVertices());
        verticesParent = new int[graph.getNumberOfVertices()];
        verticesWeight = new Float[graph.getNumberOfVertices()];
        visited = new boolean[graph.getNumberOfVertices()];
    }

    public int[] search(Integer mainVertex) {
        return search(mainVertex, -1);
    }

    public int[] search(Integer mainVertex, Integer endVertex) {
        Arrays.fill(verticesParent, -1);
        Arrays.fill(verticesWeight, Float.POSITIVE_INFINITY);
        verticesWeight[0] = 0.0f;
        queue.add(new Node(mainVertex, 0.0f));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.v] = true;
            if (verticesWeight[node.v] < node.weight) {
                continue;
            }
            for (EdgeInterface edge : graph.getAdjacencyList(node.v)) {
                if (visited[edge.w()]) {
                    continue;
                }
                relax(edge);
            }

            if (node.v == endVertex) {
                return verticesParent;
            }
        }

        return verticesParent;
    }

    private void relax(EdgeInterface edge) {
        if (verticesWeight[edge.w()] > verticesWeight[edge.v()] + edge.weight()) {
            verticesParent[edge.w()] = edge.v();
            verticesWeight[edge.w()] = verticesWeight[edge.v()] + edge.weight();
            queue.add(new Node(edge.w(), verticesWeight[edge.w()]));
        }
    }

    private class Node implements Comparable<Node> {

        public final Integer v;

        public final Float weight;

        public Node(Integer v, Float weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (weight - o.weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return v.equals(node.v);
        }

        @Override
        public int hashCode() {
            return Objects.hash(v);
        }
    }
}
