package sorting;

import java.util.Arrays;

public class QuickSelect_Kth_Largest {

    public static void main(String[] args) {
        int[] pt1 = new int[]{5, 1, 10, 3, 2};
        //arr starts at 0 k starts from 1
        int k = 2 - 1;
        quickSelect(pt1,0, pt1.length, k);
        System.out.println(kelem);
        System.out.println(Arrays.toString(pt1));
    }

   /**
    * K-th largest in array
    *
    * Given an array of integers and a number k,
    * find the number that will be at the kth index
    * after sorting the array in non-increasing order.
    *
    * I will use quick sort algorithm and stp when I know k'th index filled with correct element
    * Wht qs? - it can be stopped before completed
    * How do i know k'th filled? - when k'th is pivot
    */
   static int kelem = 0;
   public static void quickSelect(int[] arr, int start, int end, int k){
       if (end - start < 2){
           kelem = arr[k];
           return;
       }
       int pivot = partition(arr, start, end);
       if (pivot == k) {
           kelem = arr[k];
           return;
       }
       //IMPORTANT:  if k is less than pivot i can ignore the right part of arr
       //because all elements < pivot lay at left part of array
       if (pivot > k) {
           quickSelect(arr, start, pivot, k);
       }
       // if k is grater than pivot I can ignore left part of array
       //because all elements > pivot lay at right part of array
       if (pivot < k) {
           quickSelect(arr, pivot + 1, end, k);
       }
   }

   public static int partition(int[] arr, int start, int end){
      int i = start;
      int j = end;
      int pivot = arr[start];

      while (i < j){
          while (i < j && arr[--j] <= pivot);
          if (i < j) arr[i] = arr[j];

          while (i < j && arr[++i] >= pivot);
          if (i < j) arr[j] = arr[i];
      }

      arr[j] = pivot;
      return j;
   }
}

