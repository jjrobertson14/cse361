import homework.*;
import homework.Three.ExpressionFinder;
import projects.*;

/**
 * Created by jjrobertson14 on 23/01/17.
 */
public class main {
    public static void main(String[] args) {
//        homework2_1c24 hw2 = new homework2_1c24();
//        int[][] test = hw2.genArray(50);
//        hw2.findMaxRow(test);
//
        homework2_1c25 hw225 = new homework2_1c25();
        int[][] test25 = hw225.genArray(5);
        System.out.println(hw225.findNumOnes(test25));
//
//        homework2_1c26 hw226 = new homework2_1c26();
//        int[][] test26A = hw226.genArray(3,3,0, 3);
//        int[][] test26B = hw226.genArray(3, 1, 0, 3);
//        int[][] test26C = hw226.arrayMultiply(test26A, test26B);

        int[] vals = new int[4];
        vals[0] = 1;
        vals[1] = 5;
        vals[2] = 6;
        vals[3] = 7;
        ExpressionFinder expFinder = new ExpressionFinder();
        expFinder.bruteForceExpress(vals, "*/+-");
//
//        Project1A12 pj1 = new Project1A12();
//        int[] test = pj1.generateArray(20, -25, 25);
//
//        //start timing algorithm 1 (MaxsubSlow)
//        startTime = System.nanoTime();
//        System.out.println(pj1.MaxsubSlow(test));
//        endTime = System.nanoTime();
//        System.out.println("Algorithm 1 took " + (endTime-startTime) + " nano seconds");
//        //end timing
//
//        //start timing algorithm 2 (MaxsubFaster)
//        startTime = System.nanoTime();
//        System.out.println(pj1.MaxsubFaster(test));
//        endTime = System.nanoTime();
//        System.out.println("Algorithm 2 took " + (endTime-startTime) + " nano seconds");
//        //end timing
//
//        //start timing algorithm 3 (MaxsubFastest)
//        startTime = System.nanoTime();
//        System.out.println(pj1.MaxsubFastest(test));
//        endTime = System.nanoTime();
//        System.out.println("Algorithm 3 took " + (endTime-startTime) + " nano seconds");
//        //end timing
    }
}
