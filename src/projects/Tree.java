package projects;
import java.util.*;
import java.util.Iterator;

/**
 * Created by jjrobertson on 2/5/2017.
 */
public class Tree<E> implements Iterable<String> {
    private ArrayList<String> nodes;

    /*
     * Constructor of Iterable Tree objects. Accounts for two different possible syntax errors.
     * 1) unequal numbers of '('s and ')'s, keep track of depth variable to check.
     * 2) empty internal nodes, two consecutive '('s signifies an empty internal node
     */
    public Tree(String spec) {
        nodes = new ArrayList<String> ();
        int depth = 0;
        int specSize = spec.length();
        String curNode = ""; //append characters to this before adding to the tree
        boolean emptyNode = false; //will be set to true if an empty node is found in the specification

        for(int i = 0; i < specSize; i++) {
            switch (spec.charAt(i)) {
                case '(' :
                    //check for empty internal node
                    if(spec.charAt(i+1) == '(') {
                        emptyNode = true;
                    }
                    if(!(curNode.isEmpty())) {
                        nodes.add(curNode);
                        curNode = "";
                    }
                    depth++;
                    break;
                case ')' :
                    if(!(curNode.isEmpty())) {
                        nodes.add(curNode);
                        curNode = "";
                    }
                    depth--;
                    break;
                default :
                    curNode = curNode + spec.charAt(i);
            }
        }

        if(emptyNode) {
            System.out.println("Invalid tree specification, empty parent node");
            nodes.clear();
        }
        if(depth < 0) {
            System.out.println("Invalid tree specification, too many end parentheses");
            nodes.clear();
        }
        if(depth > 0) {
            System.out.println("Invalid tree specification, add more end parentheses");
            nodes.clear();
        }
        //turn string into tree?
    }

    public Iterator<String> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator <String> {
        private int index;
        private int size;

        public TreeIterator() {
            index = 0;
            size = nodes.size();
        }

        public boolean hasNext() {
            return (index < size); //current index is the index of the next element
        }

        public String next() {
            if (this.hasNext()) {
                int tempIndex = index;
                index++;
                return nodes.get(tempIndex);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}