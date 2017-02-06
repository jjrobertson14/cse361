package projects;
import java.util.*;

/**
 * Created by 1234r_000 on 2/5/2017.
 */
public class TreeTest {
    public static void main (String[] args)
    {
        Tree<String> tree = new Tree<String> (args[0]);
        for (Iterator<String> e = tree.iterator(); e.hasNext();) {
            System.out.println(e.next());
        }
    }
}
