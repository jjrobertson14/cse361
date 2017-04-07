package projects.Five;

import java.util.*;

/**
 * Created by jjrobertson on 4/3/2017.
 */
public class DAG {
    private Graph mGraph;
    private Vector<LinkedList<Graph.Vertex>> mGraphVector;
    private Vector<DAGVertex> mVertexVector;
    private Vector<DAGVertex> mResultVector;



    public DAG(Graph graph) {
        mGraph = graph;
        mGraphVector = mGraph.getGraph();
        mVertexVector = new Vector<>(mGraphVector.size()+1);
        mResultVector = new Vector<>(mVertexVector.size());
        makeDAG();
    }

    //performs a topological sort on the list of vertices
    public void TopologicalSort() {
        //will function as a queue
        LinkedList<DAGVertex> Q = new LinkedList<>();
        for (DAGVertex v : mVertexVector) {
            if(v.mIn == 0) {
                Q.add(Q.size(),v);
            }
        }

        while( !(Q.isEmpty())) {
            DAGVertex v = Q.removeFirst();
            pushBack(v,Q);
        }

    }

    public void Print() {
        System.out.println("TOPOLOGICAL ORDERING OF VERTICES .. ");
        for (DAGVertex v : mResultVector) {
            System.out.print(v.mVertId + " --> ");
        }
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
    }

    // done n times
    private void pushBack (DAGVertex v, LinkedList Q) {
        LinkedList<Graph.Vertex> adj = mGraphVector.get(v.mVertId);
        //iterate through each edge starting at v
        for (Graph.Vertex w : adj) {
            DAGVertex curIn = mVertexVector.get(w.mVertId);
            curIn.mIn--;
            if(curIn.mIn == 0) {
                Q.add(Q.size(),curIn);
            }
        }
        //mVertexVector.remove(v);
        mResultVector.add(v);
    }
}
