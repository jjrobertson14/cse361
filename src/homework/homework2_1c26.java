package homework;

/**
 * Created by jjrobertson14 on 1/27/2017.
 */
public class homework2_1c26 {
    public int[][] genArray (int numRows, int numCols, int min, int max) {
        int[][] rand2DArray = new int[numRows][numCols];
        int randomNum = 0;

        for (int i = 0; i < numRows; i++) { //start at second bottom row
            for (int j = 0; j < numCols; j++) {
                randomNum = (int) (min + Math.random() * (max - min));
                rand2DArray[i][j] = randomNum;
            }
        }
        homework2_1c24.print2DArray(rand2DArray);
        System.out.println();
        return rand2DArray;
    }

    /*
     * Multiply Matrices n x m A and m x p B represented by arrays A and B. Store the result in n x p matrix C, return.
     */
    public int[][] arrayMultiply (int[][] A, int[][] B) {
        int n = A.length; //number of rows in A, number of rows in C
        int m = A[0].length; //number of cols in A, number of rows in B
        int p = B[0].length; //number of cols in B, number of cols in C

        int ops = 0;

        int[][] C = new int[n][p]; //resultant matrix

        for(int i = 0; i < n; i++) { //iterate rows of C
            for(int j = 0; j < p; j++) { //iterate cols of C
                for(int k = 0; k < m; k++) { //iterate over each row of A, and each col of B
                    C[i][j] += A[i][k] * B[k][j];
                    ops+=5;
                }
            }
        }

        homework2_1c24.print2DArray(C);
        System.out.println("\n" + ops);
        return C;
    }
}
