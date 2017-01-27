package projects;

/**
 * Created by jjrobertson on 25/01/17.
 */
public class devProject1A12 {
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
     * 1st algorithm in book for finding maximum subarray sum, using brute force
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

    /*
     * 2nd algorithm in book for finding maximum subarray sum, using prefix sums
     */
    public int MaxsubFaster(int[] A) {
        int n = A.length;
        int[] S = new int[n + 1]; //array of prefix sums, +1 to make room for S[0] = 0
        S[0] = 0; //initial prefix sum

        int curSum; //current subbarray sum
        int max = 0; //maximum found so far


        for (int i = 1; i <= n; i++) {
            S[i] = S[i - 1] + A[i - 1];
            System.out.println(i - 1 + " " + A[i - 1] + " " + S[i - 1]);
        }
        System.out.println(n + " " + "N/A " + S[n]);

        for (int j = 1; j <= n; j++) {
            for (int k = j; k <= n; k++) {
                curSum = S[k] - S[j - 1];
                if (curSum > max) {
                    max = curSum;
                }
            }

        }
        return max;
    }

    /*
     * 3rd algorithm in book for finding maximum subarray sum, using suffix sums
     */
    public int MaxsubFastest(int[] A) {
        int n = A.length;
        int[] M = new int[n + 1]; //array of suffix sums, +1 to make room for S[0] = 0
        M[0] = 0;
        int max = 0; //maximum found so far

        for (int t = 1; t <= n; t++) {
            M[t] = Math.max(0, M[t-1] + A[t-1]);
        }

        for (int t = 1; t <= n; t++) {
            max = Math.max(max, M[t]);
        }

        return max;
    }
}