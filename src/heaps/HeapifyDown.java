package heaps;

import java.util.Arrays;

public class HeapifyDown {

    public static void main(String[] args) {
        int[] arr = new int[]{22, 19, 18, 15, 3, 14, 4, 12};

        //NOTE: To heapify down in max heap - new Element should be < or equal element we replace

        //I have max heap  - I want to replace elem at index=0 (root) -  22 with 5 - vithout violating heap property
        //1. Replace elem
        //2. Check if elem has both childs
        //2.1 If true compare 2 childs and swap my element with max
        //2.2 if only left child present - it means the left child is a leaf otherwise it wouldn't be a heap
        // Swap my element with left child

        //Test child check methods
        System.out.println(hasBothChilds(arr, 1));
        System.out.println(hasBothChilds(arr, arr.length -1));
        System.out.println(hasLeftChild(arr, 3));
        System.out.println(hasLeftChild(arr, 4));

        //Print original array
        System.out.println(Arrays.toString(arr));
        //replace root element with val=5
        replaceByHeapifyDown(arr, 0,5);
        System.out.println(Arrays.toString(arr));
        //replace element at position 2 with val=13
        replaceByHeapifyDown(arr, 2, 13);
        System.out.println(Arrays.toString(arr));
        //replace element at position 2 with val=13
        replaceByHeapifyDown(arr, 2, 15);
        System.out.println(Arrays.toString(arr));
    }

    public static void replaceByHeapifyDown(int[] arr, int replaceIndex, int val){
        //NOTE: To heapify down in max heap - new Element should be < or equal element we replace
        //if it's not we need to heapify up
        if (arr[replaceIndex] < val) {
           // replaceByHeapifyUp();
        }

        //return from recursion if reached last element - leaf node
        //we know that elements from n/2 -> n -1 are leaf elements so they have no children
        //to optimize algo we can return as soon as replaceIndex reaches n/2 + 1
        if (replaceIndex >= arr.length/2 + 1) return;
        int updatedIndex = replaceIndex;
        arr[updatedIndex] = val;

        int leftCh = findChildIndex(arr, replaceIndex, "left");
        int rightCh = findChildIndex(arr, replaceIndex, "right");

        if(hasBothChilds(arr, replaceIndex)){
            int replaceWith = arr[leftCh] >= arr[rightCh] ? leftCh:rightCh;
            //if my value greater than its max child
            //value at it's correct position so we can return
            if (val > arr[replaceWith]) return;

            swap(arr, replaceIndex, replaceWith);
            updatedIndex = replaceWith;
        }else if(hasLeftChild(arr, replaceIndex)){
            //if my value greater than its left child
            //value at it's correct position so we can return
            if (val > arr[leftCh]) return;

            swap(arr, replaceIndex, leftCh);
            //this return statement will break recursion
            return;
        }
        replaceByHeapifyDown(arr, updatedIndex, val);
    }

    public static void swap(int[] arr, int src, int repl){
        int temp = arr[src];
        arr[src] = arr[repl];
        arr[repl] = temp;
    }

    public static int findChildIndex(int[] arr, int parentIndex, String child){
        //this adds additional compration and increases T(n) replace with 2 function
        int sideIndex = child.equals("left")?1:2;
        return 2*parentIndex + sideIndex;
    }

    public static boolean hasBothChilds(int[] arr, int index){
        int leftChild = 2*index +1;
        int rightChild = 2*index +2;
        if(leftChild <= arr.length -1 && rightChild <= arr.length-1) return true;
        return false;
    }

    public static boolean hasLeftChild(int[] arr, int index){
        if ((2*index + 1) <= arr.length -1) return true;
        return false;
    }
}
