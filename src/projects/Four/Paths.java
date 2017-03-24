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
    private Vertex[] mShortestPaths; //stores shortest paths to each Vertex, index is destination node id
    private PriorityQueue<Vertex> mPathPQ; //used to make greedy choices

    //initializes vars and PQ
    public Paths(Graph gr, Integer startVertex) {
        mGraph = gr;
        mGraphVector = mGraph.getGraph();
        mStartVertex = startVertex;
        mVertexCount = mGraph.getVertexCount();
        mCurVertex = mStartVertex;
        mShortestPaths = new Vertex[mVertexCount + 1];
        mPathPQ = new PriorityQueue<Vertex>(mVertexCount, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                if(o1.mDistance < o2.mDistance)
                    return -1;
                else //we can treat equal distances as greater than each other
                    return 1;
            }
        });


        //initialize the PQ with all vertexes having distance of infinity
        for (int i = 2; i <= mVertexCount; i++) {
            Vertex e = new Vertex();
            e.mVertId = i;
            e.mDistance = mVertexCount+1; //set to infinite distance
            mPathPQ.add(e);
            e.mVertId = mStartVertex;
            mShortestPaths[i] = e; //only known path to vertex i is from mStartVertex
        }
        //set distance to starting vertex to 0
        Vertex e = new Vertex();
        e.mVertId = mStartVertex;
        e.mDistance = 0;
        mPathPQ.add(e); //0 distance from mStartVertex to mStartVertex
        mShortestPaths[e.mVertId] = e;
        mPrevVertex = e;


//        while(!(mPathPQ.isEmpty())) {
//            System.out.println(mPathPQ.poll().mDistance);
//        }
        
    }

    //returns index value of next vertex at the top of the PQ
    public Integer getNextVertex() {
        if(mPathPQ.isEmpty())
            return null;
        Vertex nextVertex = mPathPQ.poll();
        mShortestPaths[nextVertex.mVertId] = mPrevVertex;
        mPrevVertex = nextVertex;
        return nextVertex.mVertId;
    }

    //iterate through the LinkedList of distances to vertexes from current vertex, update shortest paths
    public void applyRelaxation(Integer vert) {
        LinkedList<Vertex> curAdj = mGraph.getAdj(vert);
        for (Iterator<Vertex> vertEnum = curAdj.iterator();
             vertEnum.hasNext();)
        {

            Vertex toVertex = vertEnum.next();
            int newDist = toVertex.mDistance + mShortestPaths[vert].mDistance;
            int oldDist = mShortestPaths[toVertex.mVertId].mDistance;

            //new shortest path to toVert found, update entry with toVert's index in mShortestPaths
            if(newDist < oldDist) {
                mPathPQ.remove(toVertex);
                Vertex fromVertex = new Vertex();
                fromVertex.mVertId = vert;
                fromVertex.mDistance = newDist;
                mShortestPaths[toVertex.mVertId] = fromVertex;
                mPathPQ.add(toVertex);
            }
        }
    }

    //PROBLEM: mShortestPaths is not correct at this point with graph01, works with graph02 o.o
    public int printShortestPath(Integer endVert) {
        for (int i = 1; i < mShortestPaths.length; i++) {
            System.out.println(mShortestPaths[i].mVertId);
        }
        System.out.println("------------------");
        if(endVert == mStartVertex) {
            return endVert;
        }
        int curVert = printShortestPath(mShortestPaths[endVert].mVertId);
        System.out.print(curVert + ", ");
        System.out.print(endVert + ", ");
        return endVert;
    }
}
