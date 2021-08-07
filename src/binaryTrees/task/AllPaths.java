package binaryTrees.task;

import binaryTrees.bst.Node;
import binaryTrees.bst.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPaths {

    public static void main(String[] args) {

        int[] pt = new int[]{300, 200, 100, 400};

        Tree tree = new Tree();
        Arrays.stream(pt).forEach(tree::insert);
        allPathsOfABinaryTree(tree.getRoot());


    }
    static List<List<Integer>> allPathsOfABinaryTree(Node root){
        List<List<Integer> > list = new ArrayList();
        ArrayList<Integer> temp = new ArrayList();
        if (root == null) return null;
        allPath(root, list, temp );

        for (List<Integer> l: list) {
            l.stream().forEach(System.out::println);
            System.out.println();
        }
        return list;
    }

    public static void allPath(Node root, List<List<Integer>> list, ArrayList<Integer> temp){
        temp.add(root.getData());
        if (root.getLeftChild() == null && root.getRightChild() == null){
            //if i add temp i add reference to temp and when next recursion change the temp it will change al it references
            list.add(new ArrayList<>(temp));
            return;
        }

        if (root.getLeftChild() != null){
            allPath(root.getLeftChild(), list, temp);
            //IMPORTANT! Backtracking - remove last inserted node
            temp.remove(temp.size() - 1);
        }

        if (root.getRightChild() != null){
            allPath(root.getRightChild(), list, temp);
            //IMPORTANT! Backtracking - remove last inserted node
            temp.remove(temp.size() - 1);
        }
    }
}
