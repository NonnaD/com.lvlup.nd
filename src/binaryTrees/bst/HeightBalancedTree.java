package binaryTrees.bst;

import java.util.ArrayList;
import java.util.Arrays;

public class HeightBalancedTree {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(10);
        head.next.next.next = new SinglyLinkedListNode(15);
        head.next.next.next.next = new SinglyLinkedListNode(21);
        head.next.next.next.next.next = new SinglyLinkedListNode( 1000000000);
        //head.next.next.next.next.next.next = new SinglyLinkedListNode( 1000000000);

        sorted_list_to_bst(head);
    }


    static TreeNode sorted_list_to_bst(SinglyLinkedListNode head) {
        ArrayList<Integer> balance = new ArrayList();
        traverseLinkedList(head,balance);

        //System.out.println(Arrays.toString(balance.toArray()));

        TreeNode balancedTree = new TreeNode(balance.get(balance.size()/2 - 1));

        for(int i = balance.size()/2 - 2, k = balance.size()/2; i >= 0 || k < balance.size(); --i, ++k){
            if(i >= 0){
                insert(balancedTree, balance.get(i));
            }
            if(k < balance.size()){
                insert(balancedTree, balance.get(k));
            }
        }


       inOrderTraverse(balancedTree);
        return balancedTree;

    }

    public static void inOrderTraverse(TreeNode node){
        if (node == null) return;
        inOrderTraverse(node.left_ptr);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right_ptr);
    }

    public static void traverseLinkedList(SinglyLinkedListNode head, ArrayList<Integer> balance){
        if(head == null) return;
        balance.add(head.data);
        traverseLinkedList(head.next, balance);
    }


    public static void insert(TreeNode bal, int dataNew){
        if(bal == null) return;

        if(dataNew < bal.val){
            if(bal.left_ptr == null) bal.left_ptr = new TreeNode(dataNew);
            else insert(bal.left_ptr, dataNew);
        }

        if(dataNew > bal.val){
            System.out.println(dataNew);
            if(bal.right_ptr == null) bal.right_ptr = new TreeNode(dataNew);
            else insert(bal.right_ptr, dataNew);
        }
    }


    static class SinglyLinkedListNode {
        public Integer data;
        public SinglyLinkedListNode next;

        SinglyLinkedListNode(Integer node_data) {
            this.data = node_data;
            this.next = null;
        }
    };

    static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(int val){
            this.val = val;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    };


}
