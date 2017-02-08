import homework.Three.ExpressionFinder;

import java.util.ArrayList;

/**
 * Created by jjrobertson on 08/02/17.
 */
public class main {

    public static void main(String[] args) {
        int[] vals = new int[4];
        vals[0] = 1;
        vals[1] = 5;
        vals[2] = 6;
        vals[3] = 7;
        ExpressionFinder expFind = new ExpressionFinder(vals ,"*/+-");
        ArrayList<Integer> results = new ArrayList<>();
        results = expFind.bruteForceExpress();
        for (int x : results) {
            if(x == 20)
                System.out.println(x);
        }
    }
}
