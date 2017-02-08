package projects;

import java.util.Vector;

/**
 * Created by jjrobertson on 06/02/17.
 */
public class TreeNode {
    private String element;
    private TreeNode parent;
    private Vector<TreeNode> children;

    public TreeNode (String initElement, TreeNode initParent, Vector<TreeNode> initChildren) {
        element = initElement;
        parent = initParent;
        children = initChildren;
    }
}
