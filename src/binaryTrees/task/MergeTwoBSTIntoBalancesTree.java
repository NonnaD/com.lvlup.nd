package binaryTrees.task;

import binaryTrees.bst.Node;
import binaryTrees.bst.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoBSTIntoBalancesTree {
    public static void main(String[] args) {
        int[] one = new int[]{5, 3, 6, 2, 4, 7};
        int[]  two = new int[]{8, 1, 9};

        Tree treOne = new Tree();
        Tree treTwo = new Tree();
        Arrays.stream(one).forEach(treOne::insert);
        Arrays.stream(two).forEach(treTwo::insert);

        mergeAndBalance(treOne.getRoot(), treTwo.getRoot());
    }

    public static void mergeAndBalance(Node one, Node two){
        ArrayList<Node> sortedOne = new ArrayList<>();
        ArrayList<Node> sortedTwo = new ArrayList<>();
        ArrayList<Node> merged = new ArrayList<>();

        //Step 1: Convert both trees into sorted lists
        inOrderTraverse(one, sortedOne);
        inOrderTraverse(two, sortedTwo);

        //Step 2: Merge both trees into single sorted list
        int m = sortedOne.size() + sortedTwo.size() -1;
        int o = sortedOne.size() -1;
        int t = sortedTwo.size() -1;
        while (m-- >= 0){
            merged.add(o < 0 ||(t >= 0 && sortedTwo.get(t).getData() >= sortedOne.get(o).getData())?sortedTwo.get(t--):sortedOne.get(o--));
        }

        //merged.forEach(kl -> System.out.println(kl.getData() + ","));

        //Step 4: Create new balanced tree out of merged sorted list
        //TODO:
    }

    /**
     * In order traverse returns a sorted list of nodes
     */
    public static void inOrderTraverse(Node root, ArrayList<Node> list){
        if (root == null) return;

        if (root.getRightChild()!= null) {
            inOrderTraverse(root.getLeftChild(), list);
        }
        list.add(root);
        if (root.getRightChild()!=null) {
            inOrderTraverse(root.getRightChild(), list);
        }
    }
}
