package sorting;

import java.util.*;

public class Merge {

    public static void main(String[] args) {
       ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(6, 5 , 3 , 1, -10 , -11 ,-100));
        //{7,2,0,-4,-9,4,3,5,1,-5,8};

        merge_sort(arr);
//        System.out.println(Arrays.toString(arr) + " is Sorted");
//
//        int[] pt = new int[]{8, 2, 3, 9, 2, 3, -234, 5, 0, -3, -5, 2, 3, 56, 89, 0};
//        mergeSort(pt, 0 , pt.length);

//        for (int a : arr) {
//            System.out.print(a + " ");
//        }
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        int[] merged = new int[arr.size()];
        for (int i= 0; i < merged.length; i++) merged[i] = arr.get(i);
        mergeSort(merged, 0, merged.length);
        ArrayList<Integer> mergedList = new ArrayList<>(arr.size());
        for(int i: merged) mergedList.add(i);
        return mergedList;
    }


    static void mergeSort(int[] arr, int start, int end) {
        if(end - start < 2) return;

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end ){
        if (arr[mid -1] < arr[mid]) return;
        int[] aux = new int[end - start];
        int e = end -1, m = mid -1;
        int a = aux.length -1;

        while (a >= 0){
            aux[a--] = e < mid || (m >= start && arr[m] > arr[e])?arr[m--]:arr[e--];
        }

        System.arraycopy(aux, 0, arr, start, aux.length);
    }
}
