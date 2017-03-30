package projects.Four;

import java.util.*;

/**
 * Created by jjrobertson on 23/03/17.
 */
public class Paths {
    private Graph mGraph;
    private Vector<LinkedList<Vertex>> mGraphVector;
    private Integer mStartVertex;
    private Vertex mPrevVertex;
    private int mVertexCount;
    private int mCurVertex;
    private int mInf;
    private Vertex[] mShortestPathsFrom; //stores shortest paths to each Vertex, index is destination vertex id, stores fromVertex's
    private Vertex[] mShortestPathsTo; //stores shortest paths to each vertex, index is destination vertex id, stores toVertex's
    private PriorityQueue<Vertex> mPathPQ; //used to make greedy choices, stores toVertex's

    //initializes vars and PQ
    public Paths(Graph gr, Integer startVertex) {
        mGraph = gr;
        mGraphVector = mGraph.getGraph();
        mStartVertex = startVertex;
        mVertexCount = mGraph.getVertexCount();
        mCurVertex = mStartVertex;
        mInf = Integer.MAX_VALUE;
        mShortestPathsFrom = new Vertex[mVertexCount + 1];
        mShortestPathsTo = new Vertex[mVertexCount + 1];
        mPathPQ = new PriorityQueue<Vertex>(mVertexCount, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                if(o1.mDistance < o2.mDistance)
                    return -1;
                else //we can treat equal distances as greater than each other
                    return 1;
            }
        });


        //initialize the PQ
        for (int i = 1; i <= mVertexCount; i++) {
            //start vertex to start vertex distance is zero
            Vertex toVertex = new Vertex();
            if(i == mStartVertex) {
                toVertex.mVertId = mStartVertex;
                toVertex.mDistance = 0;
                mPathPQ.add(toVertex);
                mPrevVertex = toVertex;
            }
            //start vertex to every other vertex distance is unknown (infinite)
            else {
                toVertex.mVertId = i;
                toVertex.mDistance = mInf; //set to infinite distance
                mPathPQ.add(toVertex);
            }

            //update mShortestPathsFrom
            Vertex fromVertex = new Vertex();
            fromVertex.mVertId = mStartVertex;
            fromVertex.mDistance = toVertex.mDistance;
            mShortestPathsFrom[i] = fromVertex; //only known path to vertex i is from mStartVertex
            mShortestPathsTo[i] = toVertex;
        }


//        while(!(mPathPQ.isEmpty())) {
//            System.out.println(mPathPQ.poll().mDistance);
//        }
        
    }

    //returns index value of next vertex at the top of the PQ
    public Integer getNextVertex() {
        if(mPathPQ.isEmpty())
            return null;
        Vertex nextVertex = mPathPQ.poll();
        mPrevVertex = nextVertex;
        return nextVertex.mVertId;
    }

    //iterate through the LinkedList of distances to vertexes from current vertex, update shortest paths
    public void applyRelaxation(Integer vert) {
        LinkedList<Vertex> curAdj = mGraph.getAdj(vert);
        for (Iterator<Vertex> vertEnum = curAdj.iterator();
             vertEnum.hasNext();)
        {
            //toVertex in current adj of the graph object
            Vertex toVertex = vertEnum.next();
            int newDist = toVertex.mDistance + mShortestPathsTo[vert].mDistance;
            int oldDist = mShortestPathsTo[toVertex.mVertId].mDistance;

            //new shortest path to toVert found, update appropriate elements in the PQ, mShortestPaths[To/From]
            if(newDist < oldDist) {
                toVertex = mShortestPathsTo[toVertex.mVertId];
                mPathPQ.remove(toVertex);
                toVertex.mDistance = newDist;
                mPathPQ.add(toVertex);
                Vertex fromVertex = new Vertex();
                fromVertex.mVertId = vert;
                fromVertex.mDistance = newDist;
                mShortestPathsFrom[toVertex.mVertId] = fromVertex;

            }
        }
    }

    //PROBLEM: mShortestPathsFrom is not correct at this point with graph01, works with graph02 o.o
    public void printShortestPath(Integer endVert) {
        recurseShortestPath(endVert);
        System.out.println(endVert);
        System.out.println("shortest path distance: " + mShortestPathsFrom[endVert].mVertId);
    }

    private int recurseShortestPath(Integer endVert) {
        if(endVert == mStartVertex) {
            return endVert;
        }
        int curVert = recurseShortestPath(mShortestPathsFrom[endVert].mVertId);
        System.out.print(curVert + " --> ");
        //System.out.print(endVert + "--> ");
        return endVert;
    }
}
