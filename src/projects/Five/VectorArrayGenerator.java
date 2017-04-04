package projects.Five;

import java.util.Random;
import java.util.Vector;

/**
 * Created by jjrobertson on 29/03/17.
 */
public class VectorArrayGenerator {
    int mSmall;
    int mMedium;
    int mLarge;
    int mNumTests;

    public VectorArrayGenerator(int small, int medium, int large) {
        mSmall = small;
        mMedium = medium;
        mLarge = large;
        mNumTests = 5;
    }

    public Vector<Vector<int[]>> Generate() {
        Random r = new Random();
        Vector<Vector <int[]>> arrays = new Vector<>();

        //generate arrays
        Vector<int[]> sArrays = new Vector<>();
        for (int i = 1; i <= mNumTests; i++) {
            int[] tempArray = new int[mSmall];
            for (int j = 0; j < mSmall; j++)
                tempArray[j] = r.nextInt(mSmall);
            sArrays.add(tempArray);
        }
        arrays.add(sArrays);

        Vector<int[]> mArrays = new Vector<>();
        for (int i = 1; i <= mNumTests; i++) {
            int[] tempArray = new int[mMedium];
            for (int j = 0; j < mMedium; j++)
                tempArray[j] = r.nextInt(mMedium);
            mArrays.add(tempArray);
        }
        arrays.add(mArrays);

        Vector<int[]> lArrays = new Vector<>();
        for (int i = 1; i <= mNumTests; i++) {
            int[] tempArray = new int[mLarge];
            for (int j = 0; j < mLarge; j++)
                tempArray[j] = r.nextInt(mLarge);
            lArrays.add(tempArray);
        }
        arrays.add(lArrays);

        return arrays;
    }
}
