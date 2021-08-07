package binaryTrees.task;

import binaryTrees.bst.Node;
import binaryTrees.bst.Tree;

import java.util.*;

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
//        levelOrderTraverse(tree.getRoot(), nodeKeeper);


        level_order_traversal(tree.getRoot());
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


    /**
     * Level order traverse
     * Add nodes to arrays level by level
     * @param root
     * @return
     */
    public static List<List<Integer>> level_order_traversal(Node root) {
        List<List<Integer>> keeper = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        levelOrder(root, keeper, queue);

        for (List<Integer> ke:keeper){
            ke.stream().forEach(n-> System.out.println(n));
            System.out.println();
        }
        return keeper;
    }

    public static void levelOrder(Node root, List<List<Integer>> keep, Queue<Node> qu) {
        qu.offer(root);
        while (!qu.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = qu.size();
            for (int i = 0; i < size; i++){
                Node temp = qu.poll();
                level.add(temp.getData());
                if (temp.getLeftChild() != null){
                    qu.offer(temp.getLeftChild());
                }
                if (temp.getRightChild() != null){
                    qu.offer(temp.getRightChild());
                }
            }
            //if i change this     keep.add(level); ->     keep.add(0, level);
            //instead of adding to the end it will add to the beginning of list
            //and we will get level order from bottom up
            keep.add(level);
        }
    }
}
