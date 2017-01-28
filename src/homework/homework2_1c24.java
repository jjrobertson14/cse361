package homework;

/**
 * Created by 1234r_000 on 1/26/2017.
 * can generate array with rules shown in C-1.24
 * then finds row with most 1s
 */
public class homework2_1c24 {
    public int[][] genArray (int size) {
        int[][] randBinArray = new int[size][size];
        boolean zeroFound = false;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                if(Math.random() < .8 && zeroFound == false) {
                    randBinArray[i][j] = 1;
                } else {
                    randBinArray[i][j] = 0;
                    zeroFound = true;
                }
            }
            zeroFound = false;
        }
        print2DArray(randBinArray);
        return randBinArray;
    }

    public int findMaxRow(int[][] A) {
        int maxRow = 0;
        int curCol = 0;
        int size = A.length;

        for (int i = 0; i < size; i++) {
            while (curCol < size && A[i][curCol] == 1) {
                curCol++;
                maxRow = i;
            }
            if(curCol == size)
                break;
        }

        System.out.println("maxRow = " + maxRow);
        return maxRow;
    }

    static public void print2DArray (int[][] A) {
        int n = A.length; //number of rows
        int m = A[0].length; //number of cols

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
