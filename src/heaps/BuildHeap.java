package heaps;

import java.util.Arrays;

public class BuildHeap {

    public static void main(String[] args) {

        //BuildHeap
        //In heap leaves range start from n/2
        //so we can assume last internal-node, NOT leaf is n/2-1
        int[] arrBuild = new int[]{14, 22, 15, 5, 3, 4, 12, 13};
        System.out.println(Arrays.toString(arrBuild));
        int lastInternalNode = arrBuild.length/2 -1;
        buildHeap(arrBuild, lastInternalNode);
        //Output: [22, 14, 15, 13, 3, 4, 12, 5]
        System.out.println(Arrays.toString(arrBuild));

    }

    /**
     * Build heap
     * Converts array with random ints to heap
     * T(n) -
     * @param arr
     * @param internalNode
     */
    public static void buildHeap(int[] arr, int internalNode){
        if(internalNode < 0) return;
        heapify(arr, internalNode);
        internalNode--;
        buildHeap(arr, internalNode);
    }

    public static void heapify(int[] arr, int internalNode){
        int leftChild = findChildIndex(arr, internalNode, "left");
        int rightChild = findChildIndex(arr, internalNode, "right");
        if(hasBothChilds(arr, internalNode)){
            int maxChild = arr[rightChild] > arr[leftChild]? rightChild: leftChild;
            if (arr[maxChild] < arr[internalNode]) return;
            swap(arr, internalNode, maxChild);
            heapify(arr, maxChild);
        }
        if (hasLeftChild(arr, internalNode)){
            if (arr[leftChild] < arr[internalNode]) return;
            swap(arr, internalNode, leftChild);
        }
    }

    public static void swap(int[] arr, int src, int repl){
        int temp = arr[src];
        arr[src] = arr[repl];
        arr[repl] = temp;
    }

    public static int findChildIndex(int[] arr, int parentIndex, String child){
        //this adds additional comparation and increases T(n) replace with 2 function
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
