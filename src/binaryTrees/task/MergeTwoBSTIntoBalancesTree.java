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
            merged.add(o < 0 ||(t >= 0 && sortedTwo.get(t).getData() < sortedOne.get(o).getData())?sortedTwo.get(t--):sortedOne.get(o--));
        }

        //Step 4: Create new balanced tree out of merged sorted list
        //add 2 pointers to the middle of list
        //1 moves from mid --> begining second from mid --> end
        Tree balanced = new Tree();
        balanced.insert(merged.get(merged.size()/2).getData());
        for (int i = merged.size()/2, k = merged.size()/2; i > 0 || k < merged.size(); --i, ++k){
            if (i >= 0){
                balanced.insert(merged.get(i).getData());
            }
            if (k < merged.size()){
                balanced.insert(merged.get(k).getData());
            }
        }

        ArrayList<Node> balancedlist = new ArrayList<>();
        inOrderTraverse(balanced.getRoot(), balancedlist);

        balancedlist.forEach(kl -> System.out.print(kl.getData() + ","));

    }

    /**
     * In order traverse returns a sorted list of nodes
     */
    public static void inOrderTraverse(Node root, ArrayList<Node> list){
      if (root == null) return;

      inOrderTraverse(root.getRightChild(), list);
      list.add(root);
      inOrderTraverse(root.getLeftChild(), list);

    }
}
