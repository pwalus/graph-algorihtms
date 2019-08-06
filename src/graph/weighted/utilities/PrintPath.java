package graph.weighted.utilities;

public class PrintPath {

    public static void print(int[] verticesParent, Integer source, Integer v) {
        if (v.equals(source)) {
            System.out.println();
            return;
        }

        Integer parent = verticesParent[v];
        System.out.print(verticesParent[v]);
        print(verticesParent, source, parent);
    }
}
