package projects.Five;

import java.util.PriorityQueue;

/**
 * Created by jjrobertson on 29/03/17.
 */
public class Sorters {
    public Sorters() {

    }

    /*
     * in place mergesort
     */
    public void mergeSort(int[] A, int a, int b) {
        int n = b - a + 1;
        int m = (int)Math.ceil(n/2);
        if (n == 1) {
            return
        }
    }

    private int[] merge(int[] A, int a, int m, int b) {
        while (a < b) {
            if (A[a] < A[b]) {
                a++;
            } else {
                //put b into a, shift elements to right
                A[a] += A[b];
                A[b] = A[a] - A[b];
                A[a] = A[a] - A[b];

            }
        }
    }

    /* 1 2 4 5  | 8 9 6 10
                  a   b
     */
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
