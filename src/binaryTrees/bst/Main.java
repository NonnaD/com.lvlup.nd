package binaryTrees.bst;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] pt = new int[]{25, 20, 15, 27,30,29,26,22,32, 17};

        Tree tree = new Tree();
        Arrays.stream(pt).forEach(tree::insert);
//        tree.inOrderTraverse();
//        System.out.println();
//        System.out.println("Min elem = " + tree.getMin());
//        System.out.println("Max elem = " + tree.getMax());
//        System.out.println(" elem = " + tree.get(25).getData());
//        System.out.println(" elem = " + tree.get(30).getData());
//        System.out.println(" elem = " + tree.get(26).getData());
//        System.out.println(" elem = " + tree.get(29).getData());
//
//        System.out.println(" elem = " + tree.get(17).getData());
//        System.out.println(" elem = " + tree.get(15).getRightChild().getData());
//
        tree.inOrderTraverse();
        tree.delete(15);
        System.out.println(tree.get(15) + " fjghjfkdfjgfkd");
        tree.inOrderTraverse();
    //    Arrays.stream(pt).forEach(tree::insert);

//        System.out.println(tree.successor(22));


        //Level by level traverse - BFS - uses quee DS
        //Delete node -
        //Reconstruct binary tree from traverasl  - to reconstruct the tree from traversal we need 2 pre order and in order

    }
}
