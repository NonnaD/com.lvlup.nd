package heaps;

import java.util.Arrays;

/**
 * Heap is a complete binary tree
 * Must satisfy the heap property
 * Max heap: every param greater or equal its child
 * Min heap: every param less than or equal it's child
 */
public class Heap {
    //Heaps usually implemented as arrays
    private int[] heap;
    private int size = 0;

    public Heap(int capacity){
        heap = new int[capacity];
    }

    public boolean isFull(){
        return size == heap.length;
    }

    //automatically extend heap size - 10 if it's full
    private void extend() {
        int[] extended = new int[heap.length + 10];
        System.arraycopy(heap, 0, extended, 0, heap.length);
        heap = extended;
    }

    public int getParent(int index){
        //formula for parent = floor((i-1)/2)
        //we don't need to use floor because we use integers
        //division with ints rounded down automatically
        return (index-1)/2;
    }

    public int getLeftChild(int index){
        //formula for left child 2*i + 1
        return 2*index + 1;
    }

    public int getRightChild(int index){
        //formula for right child 2*i +2
        return 2*index + 2;
    }

    public void insert(int elem){
        if (isFull()){
            this.extend();
        }
        heap[size] = elem;
        this.heapifyAbove(size);
        size++;
    }

    private void heapifyAbove(int index){
        if(heap[this.getParent(index)] > heap[index]){
            System.out.println(heap[this.getParent(index)] + "- parent: elem: "+ heap[index] );
            return;}
        int temp;
        if(size > 0){
            System.out.println(heap[index] + " -> parent: " + heap[this.getParent(index)]);
            if(heap[this.getParent(index)] <  heap[index]){
                temp = heap[getParent(index)];
                heap[getParent(index)] = heap[size];
                heap[size] = temp;
                //if elem was > than parent and they swap
                // i want to recursively compare this element with grandparent ...  until it reaches the root
                heapifyAbove(getParent(index));
            }
        }
    }

    private void delete(int elem){
        //TODO implement delete function
        //find elem
        //swap element with left most elem in the tree (heap.length -1) elem
        //remove leaf element which wa replaced
        //heapify above replaced elem
        //heapify below replaced elem
    }

    @Override
    public String toString() {
        return "Heap{" +
                "heap=" + Arrays.toString(heap) +
                ", size=" + size +
                '}';
    }
}
