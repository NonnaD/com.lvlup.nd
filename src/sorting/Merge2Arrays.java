package sorting;

import java.util.Arrays;

public class Merge2Arrays {

    public static void main(String[] args) {
//        int[] arr = {2,3};
//        int[] arr1 = {1,2,3,4,5,0,0};

            int[] arr = {3,4,5};
            int[] arr1 = { 6,7,8,9,0,0,0};

        merger_first_into_second(arr, arr1);


        for (int a : arr1
        ) {
            System.out.print(a + " ");
        }
    }

    static void merger_first_into_second(int[] arr1, int[] arr2) {
        int[] temp = new int[arr2.length];
        int a1 = arr1.length - 1;
        int a2 = arr2.length - arr1.length - 1;
        int t = temp.length -1;


        if(arr1[0] >= arr2[a2]) {
            while (t>=0) {
                temp[t--] = a1 < 0 ?arr2[a2--]:arr1[a1--];
            }
        } else if(arr2[0] > arr1[a1]){
            while (t>=0) {
                temp[t--] = a2 < 0 ?arr1[a1--]:arr2[a2--];
            }
        }else {
            while (t >= 0) {
                temp[t--] = a2 < 0 ||(a1 >= 0 && arr1[a1] > arr2[a2])?arr1[a1--]:arr2[a2--];
            }
        }
        System.arraycopy(temp, 0, arr2, 0, temp.length);
    }

}
