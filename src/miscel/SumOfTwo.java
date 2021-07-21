package miscel;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfTwo {
    public static void main(String[] args) {
        int[] num = new int[]{4,1,5,0,-1};

        List<Integer> intlist = new ArrayList<>(num.length);
        Arrays.stream(num).forEach(intlist::add);
        System.out.println(pair_sum_sorted_array(intlist, 6));
        System.out.println(pair_sum_sorted_array_hash_map(intlist, 6));


    }

    //2 pointmers soultion
    //T(n) = 3n = n
    public static List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {
        List<Integer> results =  new ArrayList<>();
        int k = 0, j = numbers.size() - 1;
        int sum;
        int l;
        int p;
        while (k < j){
            sum = numbers.get(k) + numbers.get(j);
            if(sum == target){
                results.add(k);
                results.add(j);
                return results;
            }else if (sum > target){
                j--;
            }else { k++;}
        }
        if (results.size() == 0){
            results.add(-1);
            results.add(-1);
        }

        return results;
    }


    public static List<Integer> pair_sum_sorted_array_recursion(List<Integer> numbers, int target) {
        List<Integer> results =  new ArrayList<>();
        int k = 0, j = numbers.size() - 1;
        int[] ind = sumOfTwo(numbers, target, k, j);
        results.add(ind[0]);
        results.add(ind[1]);
        return results;
    }

    public static int[] sumOfTwo(List<Integer> num, int target, int start, int end){
        if(start > end ) return new int[]{-1, -1};
        int sum = num.get(start) + num.get(end);
        if (sum == target) return new int[]{start, end};
        if(sum > target){end--;}
        if (sum < target){start++;}
        return sumOfTwo(num, target, start, end);
    }


    public static List<Integer> pair_sum_sorted_array_hash_map(List<Integer> numbers, int target) {
        List<Integer> results =  new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.size() -1; i++){
            int ivalue = numbers.get(i);
            int required = target - ivalue;
            if(map.containsKey(required)){
                results.add(i);
                results.add(ivalue);
                return results;
            }
            map.put(ivalue, i);
        }

        if (results.size() == 0){
            results.add(-1);
            results.add(-1);
        }
        return results;
    }


    public static List<Integer> two_sum(List<Integer> numbers, int target) {
        HashMap<Integer, Integer> mymap = new HashMap<>();
        List<Integer> results =  new ArrayList<>();

        sum(results, numbers, target, mymap, 0);
        if(results.size() > 0) return results;
        results.add(-1);
        results.add(-1);
        return results;
    }

    public static void sum(List<Integer> results, List<Integer> numbers, int target, HashMap<Integer, Integer> mymap, int i){
        if(i < 0) return;
        int required = target - numbers.get(i);
        if(mymap.containsKey(required)){
            results.add(mymap.get(required));
            results.add(i);
            return;
        }
        mymap.put(numbers.get(i), i);
        i++;
        sum(results, numbers, target, mymap, i);
    }


}
