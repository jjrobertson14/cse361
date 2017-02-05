import homework.*;
import homework.Three.ExpressionFinder;
import projects.*;

/**
 * Created by Johnathon Robertson on 23/01/17.
 */
public class main {
    public static void main(String[] args) {
        long startTime; //set before starting each algorithm
        long endTime; //set after finishing each algorithm

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
