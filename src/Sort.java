public class Sort {


    public static void main(String[] args) {
        int[] arr1 = bubbleSort(new int[]{1, 2, 3, 9, 2, 3, -234, 5, 0, -3, -5, 2, 3, 56, 89, 0});
        int[] arr = insertionSort(new int[]{1, 2, 3, 9, 2, 3, -234, 5, 0, -3, -5, 2, 3, 56, 89, 0});
        //int[] arr = selectionSort(new int[]{1,2,3,9,-45,-345,2,3,5,0,-3,-5,2,3,56,89,0});
        for (int a : arr) {
            System.out.print(a + " ");
        }

    }

    //Brute force alghoritm
    // 3 2 5 4 2 5 9 -2 2 -1 9
    //swap adjacent elements if n > n+1
    public static int[] bubbleSort(int[] arr) {
        for (int lu = arr.length -1; lu > 0; lu--){ //n
            int temp;
            for (int i = 0; i < lu; i++){
                if(arr[i] > arr[i+1]) { // (n-1) + (n-2) + (n-3) ... 1 = n(n+1)/2 = n2
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    //Brute force alghoritm
    // 3 2 5 4 2 5 9 -2 2 -1 9
    //we traverse thru the array and look for the largest element in unsorted partition if it's grather than max me awap it with the las element
    public static int[] selectionSort(int[] arr) {
       for (int lu = arr.length -1; lu > 0; lu--){
           int max = 0;
           int temp;
           for (int i = 1; i < lu; i++){
               if (arr[i] > arr[max]){
                   max = i;
               }
           }
           temp = arr[lu];
           arr[lu] = arr[max];
           arr[max] = temp;
       }
        return arr;
    }

    // 3 2 5 4 12 2 5 9 -2 2 -1 9
    //we loop thru the array of unsorted elements from last unsorted to 0, and shift all elements th the right until find right  place for our preserved elem
    public static int[] insertionSort(int[] arr) {
        for (int fs = 1; fs < arr.length; fs++){ //n
            int elem = arr[fs];
            int i;
            for (i = fs; i > 0 && arr[i - 1] > elem; i--){ // n
                arr[i] = arr[i-1];
            }
            arr[i] = elem;
        }
        return arr;
    }

}

