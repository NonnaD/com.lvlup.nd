package heaps;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] heap = new int[]{22,17,15, 12,11,9,8,7};
        int[] arr = new int[]{22, 8, 7, 15, 9, 11, 12, 17};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr){
        //given random arr - build it to covert to heap
        buildHeap(arr, arr.length/2);
        //take root element and swap with lastUnsorted
        for (int lastUnsorted = arr.length -1; lastUnsorted >= 0; lastUnsorted--){
            swap(arr, 0, lastUnsorted);
            heapify(arr, 0);
        }

    }


    public static void buildHeap(int[] arr, int internalNode){
       if(internalNode < 0) return;
       heapify(arr, internalNode);
       internalNode--;
       buildHeap(arr, internalNode);
    }

    public static void heapify(int[] arr, int elemIndex){
        int leftChild = leftChildIndex(arr, elemIndex);
        int rightChild = rightChildIndex(arr, elemIndex);
        int maxChild;
        if(hasBothChilds(arr, elemIndex)){
            maxChild = arr[leftChild] >= arr[rightChild]? leftChild: rightChild;
            if (arr[maxChild] > arr[elemIndex]){
                swap(arr, elemIndex, maxChild);
                heapify(arr, maxChild);
            }
        }else if (hasLeftChild(arr, elemIndex)){
            if(arr[leftChild] > arr[elemIndex]){
                swap(arr, leftChild, elemIndex);
            }
        }
    }

    public static boolean hasBothChilds(int[] arr, int index){
        return  (leftChildIndex(arr, index) <= arr.length -1 && rightChildIndex(arr, index) <= arr.length -1);
    }

    public static boolean hasLeftChild(int[] arr, int index){
        return leftChildIndex(arr, index) <= arr.length -1;
    }

    public static void swap(int[] arr, int src, int target){
        int temp= arr[src];
        arr[src] = arr[target];
        arr[target] = temp;
    }


    public static int rightChildIndex(int[] arr, int parent){
        return 2*parent + 2;
    }

    public static int leftChildIndex(int[] arr, int parent){
        return 2*parent +1;
    }
}
