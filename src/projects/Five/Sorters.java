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
        if(a < b) {
            int n = b - a + 1;
            int m = n / 2 + a;
            mergeSort(A, a, m-1);
            mergeSort(A, m, b);
            merge(A,a,m,b);
        }

        //TEST
//        int[] test = new int[6];
//        test[0] = 5;
//        test[1] = 15;
//        test[2] = 30;
//        test[3] = 4;
//        test[4] = 7;
//        test[5] = 18;
//        merge(test,0,3,5);

    }

    private void merge(int[] A, int a, int m, int b) {
        int left = a;
        int right = m;
        int n = b - a + 1;
        int[] mergedArray = new int[n];
        for (int i = 0; i < n; i++) { //both sides have elements remaining
            if(left < m && right <= b) {

                if (A[left] <= A[right]) {
                    mergedArray[i] = A[left];
                    left++;
                } else {
                    mergedArray[i] = A[right];
                    right++;
                }
            }
            else if(left < m) { //left side has elements remaining
                mergedArray[i] = A[left];
                left++;
            }
            else { //right side has elements remaining
                mergedArray[i] = A[right];
                right++;
            }
        }

        //modify original array to reflect the merge
        for (int i = 0; i < n; i++) {
            A[i + a] = mergedArray[i];
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

    public void quickSort(int[] A, int a, int b) {
        if(a >= b) {
            return;
        }
        int p = quickPartition(A,a,b);
        quickSort(A,a,p-1);
        quickSort(A,p+1,b);
    }

    private int quickPartition(int[] A, int a, int b) {
        int left = a;
        int right = b - 1;
        int p = A[b];

        while (left <= right) {
            if(left == -1 || right == -1)
                System.out.println("stop");
            while (A[left] <= p && left <= right) {
                left++;
            }
            while (left <= right && A[right] >= p) {
                right--;
            }
            if(left < right) {
                A[left] += A[right];
                A[right] = A[left] - A[right];
                A[left] = A[left] - A[right];
            }
        }
        int temp = A[b];
        A[b] = A[left];
        A[left] = temp;
        return left;
    }
}
