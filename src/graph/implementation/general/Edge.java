package graph.implementation.general;

import graph.api.EdgeInterface;

public class Edge implements EdgeInterface {

    private final int v;

    private final int w;

    private Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public static EdgeInterface of(int v, int w) {
        return new Edge(v,w);
    }

    @Override
    public int v() {
        return 0;
    }

    @Override
    public int w() {
        return 0;
    }
}
