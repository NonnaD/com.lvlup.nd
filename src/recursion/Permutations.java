package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        get_permutations(arr);
    }

    /**
     * Find all permutations for given array [1,2,3]
     *
     * Permutation formula = n!/ (n-k)! = 3!/3!(3-3)! = 6/1 = 6
     */
    static List<List<Integer>> get_permutations(List<Integer> arr) {
        List<List<Integer>> permutations = new ArrayList<>();
        premut(permutations, arr, 0);
        return permutations;
    }

    static void premut(List<List<Integer>> permutations, List<Integer> arr, int n){
        if( n >= arr.size()) {
            permutations.add(new ArrayList(arr));
            return;
        }

        for(int i = n; i <= arr.size() - 1; i++){
            swap(arr, n, i);
            premut(permutations, arr, n + 1);
            swap(arr, n, i);
        }
    }

    public static void swap(List<Integer> arr, int a, int b){
        Collections.swap(arr, a, b);
    }
}

