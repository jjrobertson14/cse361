package projects.Five;
import java.util.*;

/**
 * Created by jjrobertson on 29/03/17.
 */
public class SortMain {
    public static void main(String [] args) {
        VectorArrayGenerator g = new VectorArrayGenerator(1000,10000,100000);
        Sorters s = new Sorters();
        long start;
        long end;
        long[] times;
        long total = 0;

        //generate arrays
        Vector<Vector <int[]>> arrays = g.Generate();
//        for (Vector<int[]> v : arrays) {
//            for (int[] a : v) {
//                System.out.println(a.length);
//            }
//        }

        //mergesorts
        System.out.println("enter mergesort:");
        for (Vector<int[]> v : arrays) {
            times = new long[v.size()];
            for (int[] a : v) {
                int[] b = a.clone();
                start = System.nanoTime();
                s.mergeSort(b);
                end = System.nanoTime();
                total += end - start;
            }
            //print the average
            System.out.println("average for n = " + v.get(0).length + " = " + total / times.length);
        }

        //heapsorts
        System.out.println("enter heapsort:");
        for (Vector<int[]> v : arrays) {
            times = new long[v.size()];
            for (int[] a : v) {
                int[] b = a.clone();
                start = System.nanoTime();
                s.heapSort(b);
                end = System.nanoTime();
                total += end - start;
            }
            //print the average
            System.out.println("average for n = " + v.get(0).length + " = " + total / times.length);
        }

        //quicksorts
    }
}
