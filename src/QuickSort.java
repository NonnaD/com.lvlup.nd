public class QuickSort {

    public static void main(String[] args) {
        //int[] pt = new int[]{8, 2, 3, 9, 2, 3, -234, 5, 0, -3, -5, 2, 3, 56, 89, 0};
        int[] pt = new int[]{8, 2, 3, 9,  3, -234, 5, -3, -5, 3, 56, 89};
        quickSort(pt, 0 , pt.length);

        for (int a : pt) {
            System.out.print(a + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if((end - start) < 2) return;

        int pivot = quickSortPartition(arr, start, end);
        quickSort(arr, start, pivot);
        quickSort(arr, pivot + 1, end);
    }

    //1, 2, 3, 9, 2, 3, 1, -234, 5, 0, -3, -5,    1
    public static int quickSortPartition(int[] arr, int start, int end){
        int i = start;
        int j = end;
        int pivot = arr[start];

        while(i < j) {

            while (i < j && arr[--j] > pivot) ;
            arr[i] = arr[j];

            while (i < j && arr[++i] < pivot) ;
            arr[j] = arr[i];
        }
        arr[j] = pivot;
        return j;
    }
}
