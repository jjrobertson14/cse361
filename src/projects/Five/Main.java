package projects.Five;

/**
 * Created by jjrobertson on 4/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        String grFile = args[0];

        // Create Graph Object

        Graph graph = new Graph(grFile);
        graph.PrintGraph();
        DAG dag = new DAG(graph);
        dag.TopologicalSort();
        dag.Print();
    }
}