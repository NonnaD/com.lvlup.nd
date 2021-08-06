package binaryTrees.task;

import binaryTrees.bst.Node;
import binaryTrees.bst.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LevelOrderTraverse {
    public static void main(String[] args) {
        //Offer - add returns true or false
        //Peek - get returns FIFO value
        //Pool - delete removes and returns FIFO - value
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.offer(3);
        que.offer(4);
        que.offer(5);
//        System.out.println(que.peek());
//        System.out.println(que.poll());
//        System.out.println(que.peek());


        /**
         * Level order traversal
         * See illustration --> src/binaryTrees/bst/visual/level-order-traversal.png
         */
        int[] pt = new int[]{25, 20, 15, 27,30,29,26,22,32, 17};

        Tree tree = new Tree();
        Queue<Node> nodeKeeper = new LinkedList<>();
        Arrays.stream(pt).forEach(tree::insert);
        levelOrderTraverse(tree.getRoot(), nodeKeeper);
    }

    public static void levelOrderTraverse(Node root, Queue<Node> keep){
        //Step 1: we inserted first root node
        keep.offer(root);
        //Since we continue inserting children of deleted element at step 3 and 4
        //queue will not be empty until all elements in binary tree traversed
        while (!keep.isEmpty()) {
            //Step 2: than we removed it from queue. And saved at temp deleted variable
            Node deleted = keep.poll();
            System.out.println(deleted.getData());
            //Step 3: here we insert left child of deleted element
            if (deleted.getLeftChild() != null) {
                keep.offer(deleted.getLeftChild());
            }
            //Step 4: we insert right child of deleted element
            if (deleted.getRightChild() != null) {
                keep.offer(deleted.getRightChild());
            }
        }

    }
}
