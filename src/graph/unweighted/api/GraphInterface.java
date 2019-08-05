package graph.unweighted.api;

public interface GraphInterface {

    public int numberOfVertices();

    public int numberOfEdges();

    public boolean isDirected();

    public void insert(EdgeInterface edge);

    public void remove(EdgeInterface edge);

    public boolean isEdge(int v, int w);

    public AdjacencyListInterface getAdjacencyList(int v);

}
