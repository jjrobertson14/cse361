/**
 * Created by jjrobertson on 23/01/17.
 */
public class main {
    public static void main(String[] args) {
//        magicSquare ms = new magicSquare();
//        ms.findSquare();
        long startTime; //set before starting each algorithm
        long endTime; //set after finishing each algorithm

        Project1A12 pj1 = new Project1A12();
        int[] test = pj1.generateArray(5000, -25, 25);
//        pj1.printArray(test);
//        System.out.println();
//        System.out.println();

        //start timing algorithm 1 (MaxsubSlow)
        startTime = System.nanoTime();
        System.out.println(pj1.MaxsubSlow(test));
        endTime = System.nanoTime();
        System.out.println("Algorithm 1 took " + (endTime-startTime) + " nano seconds");
        //end timing

        //start timing algorithm 2 (MaxsubFaster)
        startTime = System.nanoTime();
        System.out.println(pj1.MaxsubFaster(test));
        endTime = System.nanoTime();
        System.out.println("Algorithm 2 took " + (endTime-startTime) + " nano seconds");
        //end timing

        //start timing algorithm 3 (MaxsubFastest)
        startTime = System.nanoTime();
        System.out.println(pj1.MaxsubFastest(test));
        endTime = System.nanoTime();
        System.out.println("Algorithm 3 took " + (endTime-startTime) + " nano seconds");
        //end timing

    }
}
