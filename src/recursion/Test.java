package recursion;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
       // brackets(4, 0, 0, "");
        int[] arr = {1,2,3};
        premutation(arr, arr.length -1);
        sumOfTwo(new int[]{1,2,3,4,5}, 6);

    }

    static void brackets(int n, int l, int r, String result){
        if (l == n && n == r){
            System.out.println(result);
            return;
        }
        if (l < n) brackets(n, l + 1, r, result + ')');
        if (r < n) brackets(n, l, r + 1, result + '(');
    }

    static void premutation(int[] arr, int n){
        if(n < 1) return;
        for(int i = 0; i < arr.length - 1; i++){
            swap(arr, n, i);
            premutation(arr, n -1);
            System.out.println(Arrays.toString(arr));
            swap(arr, i, n);
        }

    }

    static void sumOfTwo(int[] arr, int t){
        HashMap<Integer, Integer> maph = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            int k = t - arr[i];
            if(maph.containsKey(k)){
                System.out.println(i + " " + maph.get(k) + " = " + t);
                return;
            }else {
                maph.put(arr[i], i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
