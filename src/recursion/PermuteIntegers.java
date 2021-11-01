package recursion;

import java.util.ArrayList;
import java.util.List;

public class PermuteIntegers {

    //Permute Array Of Integers Duplicates Allowed

//    Given an array of numbers with possible duplicates, return all of its permutations in any order.
//
//    Example:
//    Input: [1, 2, 2]
//    Output: [ [1, 2, 2], [2, 1, 2], [2, 2, 1] ]

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        List<List<Integer>> lo = get_permutations(li);
        lo.forEach(System.out::print);


    }

    static List<List<Integer>> get_permutations(List<Integer> arr) {
        List<List<Integer>> list = new ArrayList<>();
        helper(0, arr, list);
        return list;

    }

    public static void helper(int index, List<Integer> arr, List<List<Integer>> list){
        if (index == arr.size()){
            list.add(new ArrayList<>(arr));
            return;
        }

//        for (int i = index; i < arr.size(); i++){
//
//
//            int temp = arr.get(index);
//            arr.set(k, arr.get(i));
//            arr.set(i, temp);
//            helper(k + 1, n + 1, arr, list);
//            temp = arr.get(i);
//            arr.set(i, arr.get(k));
//            arr.set(k, temp);
//        }

    }

}
