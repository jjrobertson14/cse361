package homework.Three;

/**
 * Created by 1234r_000 on 2/4/2017.
 */
public class ExpressionFinder {
    private int[] initVals = null;
    private String initOps = null;

    public ExpressionFinder(int[] vals, String ops) {
        initVals = vals;
        initOps = ops;
    }

    public int[] bruteForceExpress () {
        combineOperators(initOps);
        //1 +; 2 -; 3 /; 4 *;
        return initVals;
    }

    /*
     * generates each combination of the string given, sending each combination to the values permutation method
     */
    private void combineOperators (String ops) {
        int size = ops.length();
        String curCombination = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    curCombination = ops.charAt(i) + "" + ops.charAt(j) + "" + ops.charAt(k);
                    permuteValues(curCombination, initVals);
                    System.out.println(curCombination);
                }
            }
        }
    }

    //recursively find all permutations of array of integers
    private void permuteValues (String curOps, int[] curValues) {
        evaluateExpression(curValues, curOps);
        
    }

    private int evaluateExpression(int[] curValues, String curOps) {
        return 0;
    }
}
