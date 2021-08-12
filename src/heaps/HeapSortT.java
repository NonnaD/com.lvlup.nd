package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSortT {

    public static void main(String[] args) {
        int[] arr = new int[]{22, 8, 7, 15, 9, 11, 12, 17};
        PriorityQueue<Integer> qu = new PriorityQueue<>();

        buildHeap(arr, arr.length/2);
        System.out.println(Arrays.toString(arr));
        sortHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void buildHeap(int[] arr, int lastUnsorted){
        if (lastUnsorted < 0) return;
        heapify(arr, lastUnsorted);
        lastUnsorted--;
        buildHeap(arr, lastUnsorted);
    }

    /**
     * More elegant way to heapify
     * @param arr
     * @param lastUnsorted
     */
    public static void heapify(int[] arr, int lastUnsorted){
        int leftChild = 2*lastUnsorted + 1 < arr.length?(2*lastUnsorted + 1):lastUnsorted;
        int rightChild = 2*lastUnsorted + 2 < arr.length?(2*lastUnsorted + 2):lastUnsorted;
        int maxChild = arr[leftChild] >= arr[rightChild]?leftChild:rightChild;
        int max = arr[maxChild] > arr[lastUnsorted]?maxChild:lastUnsorted;


        if (!(lastUnsorted == max)){
            int temp  = arr[lastUnsorted];
            arr[lastUnsorted] = arr[max];
            arr[max] = temp;
            heapify(arr, max);
        }
    }

    public static void sortHeap(int[] arr, int l){
        if (l <= 0) return;
        int temp = arr[--l];
        arr[l] = arr[0];
        arr[0] = temp;
        heapify(arr, 0);
        sortHeap(arr, l);
    }
}
