package projects;

/**
 * Created by Johnathon Robertson on 25/01/17.
 */
//import org.jfree.chart.plot.Plot;

public class Project1A12 {
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
        int[] S = new int[n + 1]; //array of index sums, +1 to make room for S[0] = 0
        S[0] = 0; //initial prefix sum

        int curSum; //current subbarray sum
        int max = 0; //maximum found so far

        for (int i = 1; i <= n; i++) {
            S[i] = S[i-1] + A[i-1];
        }

        for (int j = 1; j <= n; j++) {
            for (int k = j; k <= n; k++) {
                curSum = S[k] - S[j-1];
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
        int[] M = new int[n + 1]; //array of suffix sums, +1 to make room for M[0] = 0
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
