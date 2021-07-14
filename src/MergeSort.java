import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {7,2,0,-4,-9,4,3,5,1,-5,8};

        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr) + " is Sorted");

        int[] pt = new int[]{8, 2, 3, 9, 2, 3, -234, 5, 0, -3, -5, 2, 3, 56, 89, 0};
        mergeSort(pt, 0 , pt.length);

        for (int a : pt) {
            System.out.print(a + " ");
        }
    }


    public static void mergeSort(int[] arr, int start, int end){
        if(end - start < 2) return;

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    public static void  merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start];
        int t = temp.length - 1;
        int s = start;
        int m = mid - 1;
        int e = end - 1;

        while (t >= 0){
            temp[t--] = e < mid ||(m >= start && arr[m] > arr[e])?arr[m--]: arr[e--];
        }

        System.arraycopy(temp,  0, arr, start, temp.length);
    }

}
