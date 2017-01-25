/**
 * Created by jjrobertson on 25/01/17.
 */
//import org.jfree.chart.plot.Plot;

public class project1A12 {
    private int startIndex; //tracks starting position of max sum subbarray
    private int endIndex;   //tracks ending position of max sum subbarray

    /*
     * generates a 1D array randArray, setting elements to int values between min and max
     */
    public int[] generateArray(int size, int min, int max) {
        int[] randArray = new int[size];
        int randomNum;
        for (int i = 0; i < size; i++) {
            randomNum = (int) (min + Math.random() * (max - min));
            randArray[i] = randomNum;
        }
        return randArray;
    }

    /*
     * prints a 1D array A
     */
    public void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " | ");
        }
    }

    /*
     * prints a subarray of array A
     */
    public void printSubArray(int[] A) {
        int n = A.length; //size of A

        //formatting
        for (int i = 0; i < startIndex; i++) {
            if (0 <= A[i]  && A[i] < 10)
                System.out.print(" " + " | ");
            else if ( (-10 <= A[i] && A[i] < 0) || (A[i] >= 10) )
                System.out.print("  " + " | ");
            else
                System.out.print("   " + " | ");
        }

        //prints subarray
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(A[i] + " | ");
        }

        //formating
        for (int i = endIndex + 1; i < n; i++) {
            if (0 <= A[i]  && A[i] < 10)
                System.out.print(" " + " | ");
            else if ( (-10 <= A[i] && A[i] < 0) || (A[i] >= 10) )
                System.out.print("  " + " | ");
            else
                System.out.print("   " + " | ");
        }
        System.out.println();
    }

    /*
     * 1st algorithm in book for finding maximum subarray sum
     */
    public int MaxsubSlow(int[] A) {

        int n = A.length; //size of array
        int max = 0; //maximum subarray sum
        int partSum = 0; //partial sum for certain start and end index
        for (int j = 0; j < n; j++) {
            for (int k = j; k < n; k++) {
                partSum = 0;
                for (int i = j; i <= k; i++) {
                    partSum = partSum + A[i];
                }
                if (partSum > max) {
                    max = partSum;
                    startIndex = j;
                    endIndex = k;
                }
            }
        }
        return max;

    }
    //better
    //best

}
