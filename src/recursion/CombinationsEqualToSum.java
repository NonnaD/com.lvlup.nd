package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationsEqualToSum {

//    Generate All Combinations With Sum Equal to Target
//
//    Given an integer array, generate all the unique combinations of the array numbers that sum up to a given target value
//
//    Example One
//    Input: [1, 2, 3],
//    Output: [ [1, 2], [3] ]
//    Example Two
//    Input: [1, 1, 1, 1],
//    Output: [ [1, 1]

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        generate_all_combinations(arr, 8);
       //forEach(li -> li.forEach(System.out::print));
    }

    // Complete the function below.
    public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Collections.sort(arr);
        helper(results, arr, target, 0, new ArrayList<>(), 0);
        int sums = arr.stream().mapToInt(i -> i).sum();
        return results;
    }

    public static void helper(List<List<Integer>> results, List<Integer> arr, int target, int index, List<Integer> sum, int sums){
        if (sums == target){
            sum.forEach(System.out::print);
            System.out.println();
            results.add(new ArrayList<>(sum));
            return;
        }

        for(int i = index; i < arr.size(); i++){
            sum.add(arr.get(i));
            helper(results, arr, target, i + 1, sum, sums + arr.get(i));
            sum.remove(sum.size() -1);
        }
    }





}
