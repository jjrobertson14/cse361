/**
 * Created by jjrobertson on 23/01/17.
 */
public class main {
    public static void main(String[] args) {
//        magicSquare ms = new magicSquare();
//        ms.findSquare();

        project1A12 pj1 = new project1A12();
        int[] test = pj1.generateArray(10, -25, 25);
        pj1.printArray(test);
        System.out.println();
        System.out.println();

        //start timing
        System.out.println(pj1.MaxsubSlow(test)); //algorithm 1
        //end timing
        pj1.printSubArray(test);
        System.out.println();

        //start timing
//        System.out.println(pj1.MaxsubFaster(test)); //algorithm 2
        //end timing
        System.out.println();

        //start timing
//        System.out.println(pj1.MaxsubFastest(test)); //algorithm 3
        //end timing

    }
}
