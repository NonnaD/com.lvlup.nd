package recursion;

import java.util.ArrayList;
import java.util.List;

public class NChooseK {
//    N Choose K Combinations
//    Given two integers n and k, find all the possible unique combinations of k numbers in range 1 to n.
//
//    Input: 5, 2
//    Output: [[1, 2], [1, 3], [1, 4], [1, 5], [2, 3], [2, 4], [2, 5], [3, 4], [3, 5], [4, 5]].
//
//    Example Two:
//    Input: 6, 6
//    Output: [[1, 2, 3, 4, 5, 6]].

    public static void main(String[] args) {
        List<List<Integer>> flist1 = find_combinations(5,2);

        for (List<Integer> l: flist1){
            for (Integer i: l){
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }


    public static List<List<Integer>> find_combinations1(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();

        helper(n, 1, k, new ArrayList<>(), list);
        return list;
    }

    public static List<List<Integer>> find_combinations(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();

        //interative(n, k, new ArrayList<>(), list);
        helper(n, 1, k, new ArrayList<>(), list);
        return list;
    }


    public static void interative(int n, int k, List<Integer> subList, List<List<Integer>> list){
        for (int i = 1; i <=n; i++){
            subList.add(i);
            for (int m = i + 1; m <= n; m++){
                subList.add(m);
                list.add(new ArrayList<>(subList));
                subList.remove(subList.size() - 1);
            }
            subList.remove(subList.size() - 1);
        }
    }


    public static void helper(int n, int m, int k, List<Integer> subList, List<List<Integer>> list){
        if (subList.size() == k){
            list.add(new ArrayList<>(subList));
            return;
        }

        for (int i = m; i <= n; i++){
            subList.add(i);
            helper(n, i + 1, k, subList, list);
            subList.remove(subList.size() - 1);
        }
    }

}
