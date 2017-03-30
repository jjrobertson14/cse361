package projects.Five;

import java.util.PriorityQueue;

/**
 * Created by jjrobertson on 29/03/17.
 */
public class Sorters {
    public Sorters() {

    }

    public void mergeSort(int[] A) {
        
    }


    public void heapSort(int[] A) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            PQ.add(A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = PQ.poll();
        }

    }

    public void quickSort(int[] A) {

    }
}
