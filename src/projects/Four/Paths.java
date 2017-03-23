package projects.Four;

import java.util.*;
/**
 * Created by jjrobertson on 23/03/17.
 */
public class Paths {
    private Vector <LinkedList<Graph.Vertex>> mGraphList;
    private Graph mGraph;
    private Integer mStartVertex;
    private Integer vertexCount;

    public Paths(Graph gr, Integer startVertex) {
        mGraph = gr;
        mGraphList = mGraph.getGraph();
        mStartVertex = startVertex;
        vertexCount = mGraph.getVertexCount();
    }

    public Integer getNextVertex() {
        LinkedList<Graph.Vertex> vertList = mGraph.getAdj(1);
        return vertList.peek().mVertId;
    }

    public void applyRelaxation(Integer vert) {

    }

    public void printShortestPath(Integer endVert) {

    }
}
