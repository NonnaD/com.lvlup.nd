package binaryTrees;

import binaryTrees.bst.Node;
import binaryTrees.bst.Tree;

import java.util.Arrays;

public class isBST {

    public static void main(String[] args) {

        int[] pt = new int[]{300, 200, 400, 100, 400};

        Tree tree = new Tree();
        Arrays.stream(pt).forEach(tree::insert);
        //Modify tree to make it invalid BST - fot testing purpose
        tree.get(200).setLeftChild(8000);
        System.out.println(isBST(tree.get(300)));


    }

    /*
       BT considered BST when all values in left subtree < root
       && all values in right subtree > root
    */
    static boolean isBST(Node root) {
        //NULL tree is a BST
      if (root == null) return true;
       return bstHelp(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean bstHelp(Node root, int min, int max){
        if(root == null) return true;

        //All nodes values of left subtree are less than or equal to parent node value
        //All nodes values of right subtree are greater than or equal to parent node value
        //IMPORTANT: each right child of left child should not only be grater than it parent but also less than its grandparent
        //          3000
        //         /   \
        //      2000   4000
        //     /    \
        //   3000  4000
        // Example above: lvl 3 4000 greater than its parent 2000 but should be smaller than 3000
        if (root.getData() < min || root.getData() > max) return false;

        return bstHelp(root.getLeftChild(), min, root.getData()) && bstHelp(root.getRightChild(), root.getData(), max);
    }



}