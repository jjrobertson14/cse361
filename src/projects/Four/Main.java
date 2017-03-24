package projects.Four;

public class Main {

    public static void main(String[] args) {

        String  grFile = args[0];
        Integer startVertex = Integer.parseInt(args[1]);
        Integer endVertex =  Integer.parseInt(args[2]);

        // Create Graph Object

        Graph   graph = new Graph(grFile);
//        graph.PrintGraph();
        System.out.println("=================================================");
        Paths   paths = new Paths(graph, startVertex);

        // Go through the relaxation process taking closest vertex from PQ

        Integer w;
        while ((w = paths.getNextVertex()) != null)
        {
            paths.applyRelaxation(w);
        }

        // Print the shortest path

        paths.printShortestPath (endVertex);
    }
}
