package sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,1,2,3,1,2,3,4,5,6,7,6,7,4,8,9,1,2,3,4,6};

        countSort(arr, 0,9);
        System.out.println(Arrays.toString(arr));


    }

    public static void countSort(int[] arr, int min, int max){
        //1.define the range - diff between max and min + 1
        int range = (max - min) + 1;
        //2. create count arr
        int[] count = new int[range];
        //3. fill count arr
        for(int i = 0; i <= arr.length -1; i++){
            count[arr[i] - min]++;
        }

        //4. Put values from count array to initial array
        int t = 0;
        int arrL = 0;
        for (int k = min; k <= max; k++){
            t = count[k];
            while (t-- >0){
                arr[arrL++] = k;
            }
        }
    }

}
