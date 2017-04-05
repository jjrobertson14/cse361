package projects.Five;

import java.util.*;

/**
 * Created by jjrobertson on 4/3/2017.
 */
public class DAG {
    private Graph mGraph;
    private Vector<LinkedList<Graph.Vertex>> mGraphVector;
    private Vector<DAGVertex> mVertexVector;



    public DAG(Graph graph) {
        mGraph = graph;
        mGraphVector = mGraph.getGraph();
        mVertexVector = new Vector<>(mGraphVector.size()+1);
        makeDAG();
    }

    //performs a topological sort on the list of vertices
    public void TopologicalSort() {
        //so we can remove vertices we are done with from consideration
        Vector<DAGVertex> resultVector = new Vector<>();
        //will function as a queue
        LinkedList<DAGVertex> Q = new LinkedList<>();
        for (DAGVertex v : mVertexVector) {
            if(v.mIn == 0) {
                Q.add(Q.size(),v);
                System.out.println(v.mVertId);
            }
        }

        while( !(Q.isEmpty())) {
            DAGVertex v = Q.removeFirst();
            pushBack(v,resultVector);
        }

    }

    public void Print() {

    }

    /*
     * creates mVertexVector of DAGVertexes, containing one of each vertex in the graph
     */
    private void makeDAG () {
        //initialize DAGVertexes list
        for (int i = 0; i < mGraphVector.size(); i++) {
            DAGVertex dVert = new DAGVertex();
            dVert.mVertId = i;
            if (i == 0) {
                dVert.mIn = -1;
            }
            else {
                dVert.mIn = 0;
                dVert.mOut = 0;
            }
            mVertexVector.add(i, dVert);
        }

        for (int i = 1; i < mGraphVector.size(); i++) {
            LinkedList<Graph.Vertex> adj = mGraphVector.get(i);
            DAGVertex fromVert = mVertexVector.get(i);
            for (Iterator<Graph.Vertex> vertEnum = adj.iterator();
                 vertEnum.hasNext();)
            {
                Graph.Vertex toVert = vertEnum.next();
                fromVert.mOut++;
                mVertexVector.get(toVert.mVertId).mIn++;
            }
        }

        for (DAGVertex fromVert : mVertexVector) {
            System.out.println(fromVert.mVertId + " in = " + fromVert.mIn + " out = " + fromVert.mOut);
        }

    }

    private void pushBack (DAGVertex v, Vector<DAGVertex> resultVector) {
        LinkedList<Graph.Vertex> adj = mGraphVector.get(v.mVertId);
        //iterate through each edge starting at v
        for (Graph.Vertex w : adj) {
            curIn = 
            mVertexVector.get(w.mVertId).mIn--;
            if(mVertexVector.get(w.mVertId))
        }
        mVertexVector.remove(v);
        resultVector.add(v);
        System.out.println("done with vertex " + v.mVertId);
    }
}
