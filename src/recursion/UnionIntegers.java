package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permute Array Of Unique Integers
 *
 * Given an array of unique numbers, return in any order all its permutations.
 *
 * Input: [1, 2, 3]
 *
 * Output:
 * [[1, 2, 3], [1, 3, 2],
 * [2, 1, 3], [2, 3, 1],
 * [3, 2, 1], [3, 1, 2]]
 */
public class UnionIntegers {

    public static void main(String[] args) {
//        List<Integer> prem = new ArrayList<>();
//        prem.add(1);
//        prem.add(2);
//        prem.add(3);
//        get_permutations(prem);
        int[] arr = {1,2,3};
        fix(arr);
    }

    static void fix(int[] arr){
        int temp;
        for(int i = 0; i <= arr.length - 1; i++){
            for (int k = i; k <= arr.length - 1; k++){
               int[] arr1 = arr;
               temp = arr1[k];
               arr1[k] = arr1[i];
               arr1[i] = temp;
               System.out.println(Arrays.toString(arr1));
               temp = arr[i];
               arr[i] = arr[k];
               arr[k] = temp;
                System.out.println(Arrays.toString(arr1) + " origin");
            }
        }
    }

    /*
     * Complete the function below.
     */
    static List<List<Integer>> get_permutations(List<Integer> arr) {

        List<List<Integer>> permutations = new ArrayList<>();

        int numberOfCombinations = nfactorial(arr.size());
        System.out.println(numberOfCombinations);
        premut(permutations, arr, numberOfCombinations, arr.size() - 1);

        permutations.stream().forEach(list -> list.stream().forEach(elem -> System.out.print(elem + "")));
        return null;

    }

    private static void premut(List<List<Integer>> permutations, List<Integer> arr, int num, int swaper){
        if(num <= 0 || swaper < 0) return;
        arr.set(swaper, arr.get(arr.size() - 1));
        permutations.add(arr);
        premut(permutations, arr, --num, --swaper );
    }

    private static int nfactorial(int n){
        if(n <= 1) return 1;
        return n * nfactorial(--n);
    }


}
