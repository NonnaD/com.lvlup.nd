package sorting;

public class Sort2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 2, 3, 5, 8, -5, 3, -3, -4, 0, 3, -3, 4, 5, 7};
        int[] arr1 = bubbleSort(arr);
        int[] arr2 = selectionSort(arr);
        int[] arr3 = insertionSort(arr);
        int[] arr4 = bubbleSortFromLeftToRigth(arr);
        int[] arr5 = selectionSortLeftToRight(arr);
        int[][] multyArr = new int[][]{arr1, arr2, arr3, arr4, arr5};

        for (int[] m : multyArr) {
            for (int a : m) {
                System.out.print(a + ",");
            }
            System.out.println();
        }
    }

    //Brute force-algorithm best and worth case - On2
    //T(n) = (n-1) + (n-2) + (n-3) ... 0 = n(n-1) = n2 - n
    //where n arr.legth
    public static int[] bubbleSort(int[] ar) {
        int[] arr = new int[ar.length];
        System.arraycopy(ar, 0, arr, 0, arr.length);
        for (int lastUnsorted = arr.length - 1; lastUnsorted > 0; lastUnsorted--) {
            for (int n = 0; n < lastUnsorted; n++) {
                int temp;
                if (arr[n] > arr[n + 1]) {
                    temp = arr[n];
                    arr[n] = arr[n + 1];
                    arr[n + 1] = temp;
                }
            }
        }
        return arr;
    }

    //2,3,45,23,
    public static int[] bubbleSortFromLeftToRigth(int[] ar) {
        int[] arr = new int[ar.length];
        System.arraycopy(ar, 0, arr, 0, arr.length);
        for (int firstSorted = 0; firstSorted < arr.length - 1; firstSorted++) {
            for (int k = arr.length - 1; k > firstSorted; k--) {
                int temp;
                if (arr[k] < arr[k - 1]) {
                    temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                }
            }
        }
        return arr;
    }

    //Brute force algo
    //1,2,4,2,3,5,8,-5,3,-3,-4,0,3,-3,4,5,7
    //Best case =
    public static int[] selectionSort(int[] ar) {
        int[] arr = new int[ar.length];
        System.arraycopy(ar, 0, arr, 0, arr.length);
        for (int lastUnsorted = arr.length - 1; lastUnsorted > 0; lastUnsorted--) {
            int max = 0;
            int temp;
            for (int i = 1; i <= lastUnsorted; i++) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            temp = arr[max];
            arr[max] = arr[lastUnsorted];
            arr[lastUnsorted] = temp;
        }
        return arr;
    }

    //1,2,4,2,3,5,8,-5,3,-3,-4,0,3,-3,4,5,7,
    public static int[] selectionSortLeftToRight(int[] ar) {
        int[] arr = new int[ar.length];
        System.arraycopy(ar, 0, arr, 0, arr.length);
        for(int firstUnsorted = 0; firstUnsorted < arr.length -1; firstUnsorted++){
            int min = arr.length -1;
            int temp;
            for (int n = arr.length -1; n > firstUnsorted; n--){
                if (arr[min] > arr[n]){
                    min = n;
                }
            }
            temp = arr[min];
            arr[min] = arr[firstUnsorted];
            arr[firstUnsorted] = temp;

        }
        return arr;
    }

    //Decrease and concur
    //1,2,4,2,3,5,8,-5,3,-3,-4,0,3,-3,4,5,7
    public static int[] insertionSort(int[] arr) {
        for (int firstUnsorted = 1; firstUnsorted < arr.length; firstUnsorted ++){
            int elem = arr[firstUnsorted];
            int i;
            for (i = firstUnsorted; i > 0 && arr[i - 1] > elem; i--){
                arr[i] = arr[i-1];
            }
            arr[i] = elem;
        }
        return arr;
    }
}
