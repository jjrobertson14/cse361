package homework;

/**
 * Created by jjrobertson14 on 1/26/2017.
 */
public class homework2_1c25 {
    public int[][] genArray (int size) {
        int[][] randBinArray = new int[size][size];
        boolean zeroFound = false;

        for (int j = 0; j < size; j++) { //gen bottom row
            if(Math.random() < .8 && zeroFound == false) {
                randBinArray[size-1][j] = 1;
                System.out.print("1 ");
            } else {
                randBinArray[size-1][j] = 0;
                zeroFound = true;
                System.out.print("0 ");
            }
        }
        System.out.println();
        zeroFound = false;

        for (int i = size - 2; i >= 0; i--) { //start at second bottom row
            for (int j = 0; j < size; j++) {
                if(randBinArray[i+1][j] == 1) {
                    randBinArray[i][j] = 1;
                } else if(Math.random() < .5 && zeroFound == false) {
                    randBinArray[i][j] = 1;
                } else {
                    randBinArray[i][j] = 0;
                    zeroFound = true;
                }
            }
            zeroFound = false;
        }
        homework2_1c24.print2DArray(randBinArray);
        return randBinArray;
    }

    public int findNumOnes (int[][] A) {
        int numOnes = 0; //accumulates number of 1s
        int size = A.length; //size of the array
        int curCol = 0; //holds value of current column
        int curRow = size - 1; //starts at bottom row

        /*
         * Start at the bottom row, iterate through the columns of that row until a 0 is found, adding the row number
         * (plus 1) to numOnes, as each row above the current row will have a 1 in that column. Repeat for every row
         * in the array.
         */
//        for (int i = size-1; i >= 0; i--) {
//            while (curCol < size && A[i][curCol] == 1) {
//                curCol++;
//                numOnes += i + 1;
//            }
//            if(curCol == size)
//                break;
//        }

        while (curCol <  size && curRow >= 0) {
            if(A[curRow][curCol] == 1) {
                numOnes += curRow + 1;
                curCol++;
            }
            else {
                curRow--;
            }
        }

        return numOnes;
    }
}
