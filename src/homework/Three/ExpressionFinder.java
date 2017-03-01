package homework.Three;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 1234r_000 on 2/4/2017.
 */
public class ExpressionFinder {
    private int[] initVals = null;
    private String initOps = null;
    private int numValNodes;
    private int numOpNodes;
    ArrayList<int[]> valPermutations;
    ArrayList<String> opCombinations;


    public ExpressionFinder(int[] vals, String ops) {
        initVals = vals;
        initOps = ops;
        numValNodes = vals.length;
        numOpNodes = 3;
        valPermutations= new ArrayList<>();
        opCombinations = new ArrayList<>();
    }

    public ArrayList<Integer> bruteForceExpress () {
        combineOperators(initOps);
        permuteValues(initVals);
        System.out.println(evaluateExpressionOne(initVals, "+++"));
        ArrayList<Integer> results = new ArrayList<>();
        genExpresions(results);
        return results;
    }

    /*
     * generates each combination of the string given, sending each combination to the values permutation method
     */
    private void combineOperators (String ops) {
        int numOpCombinations = (int) Math.pow((double)ops.length(),(double)numOpNodes);
        int size = ops.length();
        String curCombination = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    curCombination = ops.charAt(i) + "" + ops.charAt(j) + "" + ops.charAt(k);
                    opCombinations.add(curCombination);
                    System.out.println(curCombination);
                }
            }
        }
    }

    //recursively find all permutations of array of integers
    private void permuteValues (int[] vals) {
        //hard coding, so so so sorry
        int[] tempArray = new int[24];

        tempArray[0] = 1;
        //tempArray[1] =


        //can't get the recursion to work properly
//        permutation(vals,0,0);
////        System.out.println(valPermutations.size());
//
//        for(int[] perm : valPermutations) {
//            System.out.print(perm);
//            for (int i = 0; i < perm.length; i++) {
//                System.out.print(perm[i]);
//            }
//            System.out.println();
//        }
    }

    private void permutation(int[] vals, int i, int j) {
        for (; j < vals.length && i < vals.length; j++) {
            int[] tempArray = null;
            if (i != j) {
                tempArray = vals;
                int tempVal = tempArray[i];
                tempArray[i] = tempArray[j];
                tempArray[j] = tempVal;
                for (int w = 0; w < tempArray.length; w++) {
                    System.out.print(tempArray[w]);
                }
                System.out.println();
                valPermutations.add(tempArray);
            }else{
                tempArray = vals;
            }
            permutation(tempArray, i + 1, i + 1);
        }
    }

    private void genExpresions(ArrayList<Integer> results) {
        for (String curOpCombination : opCombinations) {
            for (int[] curValPermutation : valPermutations) {
                int curResult = evaluateExpressionTwo(curValPermutation,curOpCombination);
                if(curResult == 21)
                    System.out.println(curResult);
                results.add(curResult);
            }
        }
    }

    /*
     * tree organization one
     *              3
     *             / \
     *            1   2
     *           / \ /\
     *          v  v v v
     */
    private int evaluateExpressionOne(int[] valPermutation, String opCombination) {

        int internOne = operate(valPermutation[0],valPermutation[1],opCombination.charAt(0));
        int internTwo = operate(valPermutation[2], valPermutation[3], opCombination.charAt(1));
        int internThree = operate(internOne,internTwo,opCombination.charAt(2));
        return internThree;

    }

    /*
     * tree organization two
     *              3
     *             / \
     *            2   v
     *           / \
     *          1  v
     *         /\
     *        v v
     */
    private int evaluateExpressionTwo(int[] valPermutation, String opCombination) {

        int internOne = operate(valPermutation[0],valPermutation[1],opCombination.charAt(0));
        int internTwo = operate(internOne, valPermutation[2], opCombination.charAt(1));
        int internThree = operate(internTwo, valPermutation[3], opCombination.charAt(2));
        return internThree;

    }



    private int operate(int a, int b, char op) {
        switch (op) {
            case '*' :
                return a * b;
            case '/' :
                if (b != 0) {
                    return a / b;
                }
                else {
//                    System.out.println("divided by zero, disregard");
                    return -99999;
                }
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            default :
                System.out.println("operate() failed");
                return 0;
        }
    }
}
