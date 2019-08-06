package graph.general;

import graph.unweighted.api.EdgeInterface;

public class Edge implements EdgeInterface {

    private final int v;

    private final int w;

    private final float weight;

    private Edge(int v, int w, float weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public static EdgeInterface of(int v, int w) {
        return new Edge(v, w, 0);
    }

    public static EdgeInterface of(int v, int w, float weight) {
        return new Edge(v, w, weight);
    }

    @Override
    public int v() {
        return v;
    }

    @Override
    public int w() {
        return w;
    }

    @Override
    public float weight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
            "v=" + v +
            ", w=" + w +
            '}';
    }
}
