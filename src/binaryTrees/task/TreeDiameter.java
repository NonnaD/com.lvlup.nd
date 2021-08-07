package binaryTrees.task;

import binaryTrees.bst.Node;
import binaryTrees.bst.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TreeDiameter {

    public static void main(String[] args) {
        int[] pt = new int[]{25, 20, 15, 27,30,29,26,22,32, 17};

        Tree tree = new Tree();
        Arrays.stream(pt).forEach(tree::insert);
        ArrayList<Integer> arr = new ArrayList<>();
        //I add 0 to the list of diameters
        //in case if root is null or root is a leaf node
        //collection is not empty and Collections.max(arr) return 0
        arr.add(0);
        diameter(tree.getRoot(), arr);
        System.out.println(Collections.max(arr));

    }

    private static int diameter(Node root, ArrayList<Integer> arr){
        //when we encounter leaf node
       if (root == null || root.getRightChild() == null && root.getLeftChild()==null){
           return 0;
       }

       int leftSum = 0;
       int rightSum = 0;
       int maxOfPaths = 0;

       if (root.getRightChild() != null){
           //for very last call - leaf node this will return 0
           //we add 1 with each recursion
           rightSum = diameter(root.getRightChild(), arr) + 1;
       }
       if (root.getLeftChild() != null){
           //for very last call - leaf node this will return 0
           //we add 1 with each recursion
           leftSum = diameter(root.getLeftChild(), arr) + 1;
       }

       //i need to find max path to recursively return it to the parent node
       maxOfPaths = Math.max(leftSum, rightSum);
       //and i want to save diameter for this subtree
       //maybe it will be the max diameter
       arr.add(leftSum + rightSum);

       return maxOfPaths;
    }
}
