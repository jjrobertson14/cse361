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

        //mergesorts
        System.out.println("enter mergesort:");
        for (Vector<int[]> v : arrays) {
            for (int[] a : v) {
                int[] b = a.clone();
                start = System.nanoTime();
                s.mergeSort(b,0,b.length-1);
                end = System.nanoTime();
                for(int i = 0; i < b.length-2; i++)
                    if(b[i]>b[i+1]) { System.out.println("fail");}
                total += end - start;
            }
            //print the average
            System.out.println("average for n = " + v.get(0).length + ":\t" + total / v.size());
            total = 0;
        }

        //heapsorts
        System.out.println("enter heapsort:");
        for (Vector<int[]> v : arrays) {
            for (int[] a : v) {
                int[] b = a.clone();
                start = System.nanoTime();
                s.heapSort(b);
                end = System.nanoTime();
                for(int i = 0; i < b.length-2; i++)
                    if(b[i]>b[i+1]) { System.out.println("fail");}
                total += end - start;
            }
            //print the average
            System.out.println("average for n = " + v.get(0).length + ":\t" + total / v.size());
            total = 0;
        }

        //quicksorts
        System.out.println("enter quicksort:");
        for (Vector<int[]> v : arrays) {
            for (int[] a : v) {
                int[] b = a.clone();
                start = System.nanoTime();
                s.quickSort(b,0,b.length-1);
                end = System.nanoTime();
                for(int i = 0; i < b.length-2; i++)
                    if(b[i]>b[i+1]) { System.out.println("fail");}
                total += end - start;
            }
            //print the average
            System.out.println("average for n = " + v.get(0).length + ":\t" + total / v.size());
            total = 0;
        }
    }
}
